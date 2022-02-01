package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.as;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ak
{
  private static final byte[] kLI = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = b.kLT;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(az.bwm());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.kLT;
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
    if ((parama != null) && (parama.bqX()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44327);
      throw parama;
    }
    AppMethodBeat.o(44327);
  }
  
  public static void aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    aj localaj = (aj)n.W(aj.class);
    if (localaj == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (kLI)
    {
      al localal = new al();
      localal.field_appId = paramString;
      localal.field_version = paramInt;
      if (localaj.get(localal, al.kJX))
      {
        localal.field_hit += 1;
        localal.field_hitTimeMS = Util.nowMilliSecond();
        localaj.update(localal, al.kJX);
        AppMethodBeat.o(44324);
        return;
      }
      localal.field_hit = 1;
      localal.field_hitTimeMS = Util.nowMilliSecond();
      localaj.insert(localal);
    }
  }
  
  public static b b(long paramLong, a parama)
  {
    AppMethodBeat.i(44326);
    Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", new Object[] { Long.valueOf(paramLong) });
    aj localaj = (aj)n.W(aj.class);
    if (localaj == null)
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.kLV;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (kLI)
    {
      localObject3 = localaj.db.query("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = b.kLV;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = b.kLV;
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
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "plugincode size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      ??? = n.buL();
      if (??? == null)
      {
        Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.kLV;
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
      Iterator localIterator = ((bh)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bh.a.kNQ, new String[] { "pkgPath", "versionMd5" }).iterator();
      label806:
      label811:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bd)localIterator.next();
        l = s.boW(((bd)localObject4).field_pkgPath) + l;
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bd)localObject4).field_appId, ((bd)localObject4).field_pkgPath, Long.valueOf(l) });
        s.deleteFile(((bd)localObject4).field_pkgPath);
        cs(((bd)localObject4).field_appId, ((bd)localObject4).field_versionMd5);
        localObject4 = ((bd)localObject4).field_appId;
        if (Util.isNullOrNil((String)localObject4))
        {
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          i += 1;
          localaj.aS((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label811;
          }
          if (i > 0)
          {
            parama = new lr();
            parama.eZr = 4L;
            parama.eZt = i;
            if (!v.bvG()) {
              break label806;
            }
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.eZp = paramLong;
          parama.bfK();
          parama = b.kLU;
          AppMethodBeat.o(44326);
          return parama;
          localObject4 = ((String)localObject4).substring(0, ((String)localObject4).indexOf("$"));
          if (Util.isNullOrNil((String)localObject4))
          {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject5 = n.buD();
          at localat = n.buF();
          if ((localObject5 == null) || (localat == null))
          {
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localat.ach((String)localObject4) != null)
          {
            localObject5 = new as();
            ((as)localObject5).field_appId = ((String)localObject4);
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject4, Boolean.valueOf(localat.delete((IAutoDBItem)localObject5, new String[0])) });
            break;
          }
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject4 });
          break;
        }
      }
    }
    parama = b.kLV;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  private static void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226358);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(226358);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = s.dC(ad.bDt(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (e)paramString1.next();
      if ((!Util.isNullOrNil(((e)localObject).name)) && (((e)localObject).RbJ) && (((e)localObject).name.startsWith("plugin.js")) && (((e)localObject).name.endsWith(str)))
      {
        localObject = s.dC(((e)localObject).NGP, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { locale.name });
          if ((!Util.isNullOrNil(locale.name)) && (locale.name.equals(paramString2)))
          {
            boolean bool = locale.hdW();
            Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { locale.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(226358);
  }
  
  public static abstract interface a
  {
    public static final a kLS = new a()
    {
      public final boolean bqX()
      {
        return false;
      }
    };
    
    public abstract boolean bqX();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44323);
      kLT = new b("NO_NEED", 0);
      kLU = new b("TRIMMED", 1);
      kLV = new b("TRIM_FAIL", 2);
      kLW = new b[] { kLT, kLU, kLV };
      AppMethodBeat.o(44323);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */