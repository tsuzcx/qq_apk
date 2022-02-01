package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ai
{
  private static final byte[] iMG = new byte[0];
  
  public static ai.b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = ai.b.iMR;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(ax.aQj());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = ai.b.iMR;
      AppMethodBeat.o(44325);
      return parama;
    }
    parama = b(paramLong, parama);
    AppMethodBeat.o(44325);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44327);
    if ((parama != null) && (parama.aLy()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44327);
      throw parama;
    }
    AppMethodBeat.o(44327);
  }
  
  public static void aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    ad.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ah localah = (ah)j.T(ah.class);
    if (localah == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (iMG)
    {
      aj localaj = new aj();
      localaj.field_appId = paramString;
      localaj.field_version = paramInt;
      if (localah.get(localaj, aj.iLd))
      {
        localaj.field_hit += 1;
        localaj.field_hitTimeMS = bt.eGO();
        localah.update(localaj, aj.iLd);
        AppMethodBeat.o(44324);
        return;
      }
      localaj.field_hit = 1;
      localaj.field_hitTimeMS = bt.eGO();
      localah.insert(localaj);
    }
  }
  
  public static ai.b b(long paramLong, a parama)
  {
    AppMethodBeat.i(44326);
    ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", new Object[] { Long.valueOf(paramLong) });
    ah localah = (ah)j.T(ah.class);
    if (localah == null)
    {
      ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = ai.b.iMT;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (iMG)
    {
      localObject3 = localah.db.a("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = ai.b.iMT;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = ai.b.iMT;
        AppMethodBeat.o(44326);
        return parama;
      }
      try
      {
        boolean bool;
        do
        {
          ((LinkedList)localObject2).add(Pair.create(((Cursor)localObject3).getString(0), Integer.valueOf(((Cursor)localObject3).getInt(1))));
          bool = ((Cursor)localObject3).moveToNext();
        } while (bool);
        ((Cursor)localObject3).close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
          ((Cursor)localObject3).close();
        }
        parama = finally;
        AppMethodBeat.o(44326);
        throw parama;
      }
      finally
      {
        ((Cursor)localObject3).close();
        AppMethodBeat.o(44326);
      }
      ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "plugincode size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      ??? = j.aOK();
      if (??? == null)
      {
        ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = ai.b.iMT;
        AppMethodBeat.o(44326);
        return parama;
      }
    }
    a(parama);
    localObject2 = ((LinkedList)localObject2).iterator();
    long l = 0L;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Pair)((Iterator)localObject2).next();
      Iterator localIterator = ((bf)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bf.a.iOJ, new String[] { "pkgPath", "versionMd5" }).iterator();
      label806:
      label811:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bb)localIterator.next();
        l = i.aMN(((bb)localObject4).field_pkgPath) + l;
        ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bb)localObject4).field_appId, ((bb)localObject4).field_pkgPath, Long.valueOf(l) });
        i.deleteFile(((bb)localObject4).field_pkgPath);
        bT(((bb)localObject4).field_appId, ((bb)localObject4).field_versionMd5);
        localObject4 = ((bb)localObject4).field_appId;
        if (bt.isNullOrNil((String)localObject4))
        {
          ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          i += 1;
          localah.aD((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label811;
          }
          if (i > 0)
          {
            parama = new ez();
            parama.eaD = 4L;
            parama.eaF = i;
            if (!u.aPG()) {
              break label806;
            }
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.eaB = paramLong;
          parama.aBj();
          parama = ai.b.iMS;
          AppMethodBeat.o(44326);
          return parama;
          localObject4 = ((String)localObject4).substring(0, ((String)localObject4).indexOf("$"));
          if (bt.isNullOrNil((String)localObject4))
          {
            ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject5 = j.aOD();
          ay localay = j.aOF();
          if ((localObject5 == null) || (localay == null))
          {
            ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localay.Kn((String)localObject4) != null)
          {
            localObject5 = new com.tencent.mm.plugin.appbrand.launching.ax();
            ((com.tencent.mm.plugin.appbrand.launching.ax)localObject5).field_appId = ((String)localObject4);
            ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject4, Boolean.valueOf(localay.delete((c)localObject5, new String[0])) });
            break;
          }
          ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject4 });
          break;
        }
      }
    }
    parama = ai.b.iMT;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  private static void bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195619);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(195619);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    ad.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = i.cT(ac.aWU(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (FileSystem.a)paramString1.next();
      if ((!bt.isNullOrNil(((FileSystem.a)localObject).name)) && (((FileSystem.a)localObject).HRB) && (((FileSystem.a)localObject).name.startsWith("plugin.js")) && (((FileSystem.a)localObject).name.endsWith(str)))
      {
        localObject = i.cT(((FileSystem.a)localObject).EQk, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
          ad.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { locala.name });
          if ((!bt.isNullOrNil(locala.name)) && (locala.name.equals(paramString2)))
          {
            boolean bool = locala.delete();
            ad.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { locala.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(195619);
  }
  
  public static abstract interface a
  {
    public static final a iMQ = new a()
    {
      public final boolean aLy()
      {
        return false;
      }
    };
    
    public abstract boolean aLy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */