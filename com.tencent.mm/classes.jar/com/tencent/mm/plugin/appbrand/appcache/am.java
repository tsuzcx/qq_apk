package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.si;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.launching.aq;
import com.tencent.mm.plugin.appbrand.n.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class am
{
  private static final byte[] qFv = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = b.qFF;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(bd.cgP());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.qFF;
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
    if ((parama != null) && (parama.cbj()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44327);
      throw parama;
    }
    AppMethodBeat.o(44327);
  }
  
  public static b b(long paramLong, a parama)
  {
    AppMethodBeat.i(44326);
    Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", new Object[] { Long.valueOf(paramLong) });
    al localal = (al)n.ag(al.class);
    if (localal == null)
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.qFH;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (qFv)
    {
      localObject3 = localal.db.query("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = b.qFH;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = b.qFH;
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
      ??? = n.cfm();
      if (??? == null)
      {
        Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.qFH;
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
      Iterator localIterator = ((bm)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bm.a.qHE, new String[] { "pkgPath", "versionMd5" }).iterator();
      label826:
      label888:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bh)localIterator.next();
        l = y.bEl(((bh)localObject4).field_pkgPath) + l;
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bh)localObject4).field_appId, ((bh)localObject4).field_pkgPath, Long.valueOf(l) });
        y.deleteFile(((bh)localObject4).field_pkgPath);
        cO(((bh)localObject4).field_appId, ((bh)localObject4).field_versionMd5);
        Object localObject5 = ((bh)localObject4).field_appId;
        if (Util.isNullOrNil((String)localObject5))
        {
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          localObject4 = ((bh)localObject4).field_appId;
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission");
          if (!Util.isNullOrNil((String)localObject4)) {
            break label826;
          }
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission appId null!");
        }
        for (;;)
        {
          i += 1;
          localal.bB((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label888;
          }
          if (i > 0)
          {
            parama = new si();
            parama.jxW = 4L;
            parama.jxY = i;
            parama.jxU = 1L;
            parama.bMH();
          }
          parama = b.qFG;
          AppMethodBeat.o(44326);
          return parama;
          localObject5 = ((String)localObject5).substring(0, ((String)localObject5).indexOf("$"));
          if (Util.isNullOrNil((String)localObject5))
          {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject6 = n.cfd();
          aq localaq = n.cff();
          if ((localObject6 == null) || (localaq == null))
          {
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localaq.adg((String)localObject5) != null)
          {
            localObject6 = new ap();
            ((ap)localObject6).field_appId = ((String)localObject5);
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject5, Boolean.valueOf(localaq.delete((IAutoDBItem)localObject6, new String[0])) });
            break;
          }
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject5 });
          break;
          if (Util.isNullOrNil(((String)localObject4).substring(0, ((String)localObject4).indexOf("$"))))
          {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission provider null!");
          }
          else
          {
            localObject4 = n.cfd();
            localObject5 = n.cfg();
            if ((localObject4 == null) || (localObject5 == null)) {
              Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission storage null!");
            }
          }
        }
      }
    }
    parama = b.qFH;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  public static void bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    al localal = (al)n.ag(al.class);
    if (localal == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (qFv)
    {
      an localan = new an();
      localan.field_appId = paramString;
      localan.field_version = paramInt;
      if (localal.get(localan, an.qDJ))
      {
        localan.field_hit += 1;
        localan.field_hitTimeMS = Util.nowMilliSecond();
        localal.update(localan, an.qDJ);
        AppMethodBeat.o(44324);
        return;
      }
      localan.field_hit = 1;
      localan.field_hitTimeMS = Util.nowMilliSecond();
      localal.insert(localan);
    }
  }
  
  private static void cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320270);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(320270);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = y.eB(ad.cpf(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (j)paramString1.next();
      if ((!Util.isNullOrNil(((j)localObject).name)) && (((j)localObject).agxh) && (((j)localObject).name.startsWith("plugin.js")) && (((j)localObject).name.endsWith(str)))
      {
        localObject = y.eB(((j)localObject).acpB, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          j localj = (j)((Iterator)localObject).next();
          Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { localj.name });
          if ((!Util.isNullOrNil(localj.name)) && (localj.name.equals(paramString2)))
          {
            boolean bool = localj.NP(true);
            Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { localj.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(320270);
  }
  
  public static abstract interface a
  {
    public static final a qFE = new a()
    {
      public final boolean cbj()
      {
        return false;
      }
    };
    
    public abstract boolean cbj();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44323);
      qFF = new b("NO_NEED", 0);
      qFG = new b("TRIMMED", 1);
      qFH = new b("TRIM_FAIL", 2);
      qFI = new b[] { qFF, qFG, qFH };
      AppMethodBeat.o(44323);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.am
 * JD-Core Version:    0.7.0.1
 */