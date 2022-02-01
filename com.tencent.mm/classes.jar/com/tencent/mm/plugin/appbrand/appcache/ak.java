package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.plugin.appbrand.launching.ba;
import com.tencent.mm.plugin.appbrand.launching.bb;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ak
{
  private static final byte[] jJL = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = b.jJW;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(az.baY());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.jJW;
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
    if ((parama != null) && (parama.aWa()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44327);
      throw parama;
    }
    AppMethodBeat.o(44327);
  }
  
  public static void aL(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    ae.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    aj localaj = (aj)j.T(aj.class);
    if (localaj == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (jJL)
    {
      al localal = new al();
      localal.field_appId = paramString;
      localal.field_version = paramInt;
      if (localaj.get(localal, al.jHZ))
      {
        localal.field_hit += 1;
        localal.field_hitTimeMS = bu.fpO();
        localaj.update(localal, al.jHZ);
        AppMethodBeat.o(44324);
        return;
      }
      localal.field_hit = 1;
      localal.field_hitTimeMS = bu.fpO();
      localaj.insert(localal);
    }
  }
  
  public static b b(long paramLong, a parama)
  {
    AppMethodBeat.i(44326);
    ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", new Object[] { Long.valueOf(paramLong) });
    aj localaj = (aj)j.T(aj.class);
    if (localaj == null)
    {
      ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.jJY;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (jJL)
    {
      localObject3 = localaj.db.a("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = b.jJY;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = b.jJY;
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
          ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "plugincode size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      ??? = j.aZu();
      if (??? == null)
      {
        ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.jJY;
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
      Iterator localIterator = ((bh)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bh.a.jLP, new String[] { "pkgPath", "versionMd5" }).iterator();
      label806:
      label811:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bd)localIterator.next();
        l = o.aZR(((bd)localObject4).field_pkgPath) + l;
        ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bd)localObject4).field_appId, ((bd)localObject4).field_pkgPath, Long.valueOf(l) });
        o.deleteFile(((bd)localObject4).field_pkgPath);
        ce(((bd)localObject4).field_appId, ((bd)localObject4).field_versionMd5);
        localObject4 = ((bd)localObject4).field_appId;
        if (bu.isNullOrNil((String)localObject4))
        {
          ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          i += 1;
          localaj.aM((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label811;
          }
          if (i > 0)
          {
            parama = new hw();
            parama.euV = 4L;
            parama.euX = i;
            if (!v.bas()) {
              break label806;
            }
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.euT = paramLong;
          parama.aLH();
          parama = b.jJX;
          AppMethodBeat.o(44326);
          return parama;
          localObject4 = ((String)localObject4).substring(0, ((String)localObject4).indexOf("$"));
          if (bu.isNullOrNil((String)localObject4))
          {
            ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject5 = j.aZm();
          bb localbb = j.aZo();
          if ((localObject5 == null) || (localbb == null))
          {
            ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localbb.SD((String)localObject4) != null)
          {
            localObject5 = new ba();
            ((ba)localObject5).field_appId = ((String)localObject4);
            ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject4, Boolean.valueOf(localbb.delete((com.tencent.mm.sdk.e.c)localObject5, new String[0])) });
            break;
          }
          ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject4 });
          break;
        }
      }
    }
    parama = b.jJY;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  private static void ce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222129);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(222129);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    ae.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = o.dh(ad.bie(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (com.tencent.mm.vfs.c)paramString1.next();
      if ((!bu.isNullOrNil(((com.tencent.mm.vfs.c)localObject).name)) && (((com.tencent.mm.vfs.c)localObject).LGd) && (((com.tencent.mm.vfs.c)localObject).name.startsWith("plugin.js")) && (((com.tencent.mm.vfs.c)localObject).name.endsWith(str)))
      {
        localObject = o.dh(((com.tencent.mm.vfs.c)localObject).Itr, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.vfs.c localc = (com.tencent.mm.vfs.c)((Iterator)localObject).next();
          ae.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { localc.name });
          if ((!bu.isNullOrNil(localc.name)) && (localc.name.equals(paramString2)))
          {
            boolean bool = localc.delete();
            ae.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { localc.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(222129);
  }
  
  public static abstract interface a
  {
    public static final a jJV = new a()
    {
      public final boolean aWa()
      {
        return false;
      }
    };
    
    public abstract boolean aWa();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44323);
      jJW = new b("NO_NEED", 0);
      jJX = new b("TRIMMED", 1);
      jJY = new b("TRIM_FAIL", 2);
      jJZ = new b[] { jJW, jJX, jJY };
      AppMethodBeat.o(44323);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */