package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ai
{
  private static final byte[] jmN = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = b.jmY;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(ax.aXb());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.jmY;
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
    if ((parama != null) && (parama.aSp()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44327);
      throw parama;
    }
    AppMethodBeat.o(44327);
  }
  
  public static void aG(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ah localah = (ah)j.T(ah.class);
    if (localah == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (jmN)
    {
      aj localaj = new aj();
      localaj.field_appId = paramString;
      localaj.field_version = paramInt;
      if (localah.get(localaj, aj.jlk))
      {
        localaj.field_hit += 1;
        localaj.field_hitTimeMS = bs.eWj();
        localah.update(localaj, aj.jlk);
        AppMethodBeat.o(44324);
        return;
      }
      localaj.field_hit = 1;
      localaj.field_hitTimeMS = bs.eWj();
      localah.insert(localaj);
    }
  }
  
  public static b b(long paramLong, a parama)
  {
    AppMethodBeat.i(44326);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", new Object[] { Long.valueOf(paramLong) });
    ah localah = (ah)j.T(ah.class);
    if (localah == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.jna;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (jmN)
    {
      localObject3 = localah.db.a("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = b.jna;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = b.jna;
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "plugincode size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      ??? = j.aVC();
      if (??? == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.jna;
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
      Iterator localIterator = ((bf)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bf.a.joS, new String[] { "pkgPath", "versionMd5" }).iterator();
      label806:
      label811:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bb)localIterator.next();
        l = i.aSp(((bb)localObject4).field_pkgPath) + l;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bb)localObject4).field_appId, ((bb)localObject4).field_pkgPath, Long.valueOf(l) });
        i.deleteFile(((bb)localObject4).field_pkgPath);
        cc(((bb)localObject4).field_appId, ((bb)localObject4).field_versionMd5);
        localObject4 = ((bb)localObject4).field_appId;
        if (bs.isNullOrNil((String)localObject4))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          i += 1;
          localah.aH((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label811;
          }
          if (i > 0)
          {
            parama = new gr();
            parama.ecJ = 4L;
            parama.ecL = i;
            if (!u.aWy()) {
              break label806;
            }
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.ecH = paramLong;
          parama.aHZ();
          parama = b.jmZ;
          AppMethodBeat.o(44326);
          return parama;
          localObject4 = ((String)localObject4).substring(0, ((String)localObject4).indexOf("$"));
          if (bs.isNullOrNil((String)localObject4))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject5 = j.aVv();
          ay localay = j.aVx();
          if ((localObject5 == null) || (localay == null))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localay.Ou((String)localObject4) != null)
          {
            localObject5 = new com.tencent.mm.plugin.appbrand.launching.ax();
            ((com.tencent.mm.plugin.appbrand.launching.ax)localObject5).field_appId = ((String)localObject4);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject4, Boolean.valueOf(localay.delete((c)localObject5, new String[0])) });
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject4 });
          break;
        }
      }
    }
    parama = b.jna;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  private static void cc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186323);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(186323);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = i.cZ(com.tencent.mm.plugin.appbrand.jsruntime.ac.bdS(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (FileSystem.a)paramString1.next();
      if ((!bs.isNullOrNil(((FileSystem.a)localObject).name)) && (((FileSystem.a)localObject).Jsg) && (((FileSystem.a)localObject).name.startsWith("plugin.js")) && (((FileSystem.a)localObject).name.endsWith(str)))
      {
        localObject = i.cZ(((FileSystem.a)localObject).Gnx, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { locala.name });
          if ((!bs.isNullOrNil(locala.name)) && (locala.name.equals(paramString2)))
          {
            boolean bool = locala.delete();
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { locala.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(186323);
  }
  
  public static abstract interface a
  {
    public static final a jmX = new a()
    {
      public final boolean aSp()
      {
        return false;
      }
    };
    
    public abstract boolean aSp();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44323);
      jmY = new b("NO_NEED", 0);
      jmZ = new b("TRIMMED", 1);
      jna = new b("TRIM_FAIL", 2);
      jnb = new b[] { jmY, jmZ, jna };
      AppMethodBeat.o(44323);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */