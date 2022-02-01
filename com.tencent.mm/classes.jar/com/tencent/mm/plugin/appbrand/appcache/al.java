package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.op;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class al
{
  private static final byte[] nFB = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44325);
    if (paramLong <= 0L)
    {
      parama = b.nFM;
      AppMethodBeat.o(44325);
      return parama;
    }
    StatFs localStatFs = new StatFs(bc.bHt());
    long l = localStatFs.getAvailableBlocks();
    l = localStatFs.getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.nFM;
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
    if ((parama != null) && (parama.bBN()))
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
    ak localak = (ak)m.W(ak.class);
    if (localak == null)
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.nFO;
      AppMethodBeat.o(44326);
      return parama;
    }
    Object localObject3 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (nFB)
    {
      localObject3 = localak.db.query("PluginCodeUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject3, 2);
      if (localObject3 == null)
      {
        parama = b.nFO;
        AppMethodBeat.o(44326);
        return parama;
      }
      if (!((Cursor)localObject3).moveToFirst())
      {
        ((Cursor)localObject3).close();
        parama = b.nFO;
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
      ??? = m.bFP();
      if (??? == null)
      {
        Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.nFO;
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
      Iterator localIterator = ((bm)???).b((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue(), bm.a.nHP, new String[] { "pkgPath", "versionMd5" }).iterator();
      label896:
      label901:
      while (localIterator.hasNext())
      {
        Object localObject4 = (bh)localIterator.next();
        l = u.bBQ(((bh)localObject4).field_pkgPath) + l;
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", new Object[] { ((bh)localObject4).field_appId, ((bh)localObject4).field_pkgPath, Long.valueOf(l) });
        u.deleteFile(((bh)localObject4).field_pkgPath);
        cx(((bh)localObject4).field_appId, ((bh)localObject4).field_versionMd5);
        Object localObject5 = ((bh)localObject4).field_appId;
        if (Util.isNullOrNil((String)localObject5))
        {
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
          localObject4 = ((bh)localObject4).field_appId;
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission");
          if (!Util.isNullOrNil((String)localObject4)) {
            break label834;
          }
          Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission appId null!");
          label592:
          i += 1;
          localak.bk((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label901;
          }
          if (i > 0)
          {
            parama = new op();
            parama.hci = 4L;
            parama.hck = i;
            if (!w.bGN()) {
              break label896;
            }
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.hcg = paramLong;
          parama.bpa();
          parama = b.nFN;
          AppMethodBeat.o(44326);
          return parama;
          localObject5 = ((String)localObject5).substring(0, ((String)localObject5).indexOf("$"));
          if (Util.isNullOrNil((String)localObject5))
          {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
            break;
          }
          Object localObject6 = m.bFG();
          ap localap = m.bFI();
          if ((localObject6 == null) || (localap == null))
          {
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
            break;
          }
          if (localap.akb((String)localObject5) != null)
          {
            localObject6 = new ao();
            ((ao)localObject6).field_appId = ((String)localObject5);
            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", new Object[] { localObject5, Boolean.valueOf(localap.delete((IAutoDBItem)localObject6, new String[0])) });
            break;
          }
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", new Object[] { localObject5 });
          break;
          label834:
          if (Util.isNullOrNil(((String)localObject4).substring(0, ((String)localObject4).indexOf("$"))))
          {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission provider null!");
            break label592;
          }
          localObject4 = m.bFG();
          localObject5 = m.bFJ();
          if ((localObject4 != null) && (localObject5 != null)) {
            break label592;
          }
          Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeAppidABTestPermission storage null!");
          break label592;
        }
      }
    }
    parama = b.nFO;
    AppMethodBeat.o(44326);
    return parama;
  }
  
  public static void bj(String paramString, int paramInt)
  {
    AppMethodBeat.i(44324);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44324);
      return;
    }
    Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ak localak = (ak)m.W(ak.class);
    if (localak == null)
    {
      AppMethodBeat.o(44324);
      return;
    }
    synchronized (nFB)
    {
      am localam = new am();
      localam.field_appId = paramString;
      localam.field_version = paramInt;
      if (localak.get(localam, am.nDP))
      {
        localam.field_hit += 1;
        localam.field_hitTimeMS = Util.nowMilliSecond();
        localak.update(localam, am.nDP);
        AppMethodBeat.o(44324);
        return;
      }
      localam.field_hit = 1;
      localam.field_hitTimeMS = Util.nowMilliSecond();
      localak.insert(localam);
    }
  }
  
  private static void cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(269717);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
      AppMethodBeat.o(269717);
      return;
    }
    String str = paramString1.substring(0, paramString1.indexOf("$"));
    Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", new Object[] { paramString1, paramString2 });
    paramString1 = u.dP(ad.bOR(), false).iterator();
    while (paramString1.hasNext())
    {
      Object localObject = (f)paramString1.next();
      if ((!Util.isNullOrNil(((f)localObject).name)) && (((f)localObject).YCj) && (((f)localObject).name.startsWith("plugin.js")) && (((f)localObject).name.endsWith(str)))
      {
        localObject = u.dP(((f)localObject).UUr, false).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", new Object[] { localf.name });
          if ((!Util.isNullOrNil(localf.name)) && (localf.name.equals(paramString2)))
          {
            boolean bool = localf.cFq();
            Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", new Object[] { localf.name, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(269717);
  }
  
  public static abstract interface a
  {
    public static final a nFL = new a()
    {
      public final boolean bBN()
      {
        return false;
      }
    };
    
    public abstract boolean bBN();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44323);
      nFM = new b("NO_NEED", 0);
      nFN = new b("TRIMMED", 1);
      nFO = new b("TRIM_FAIL", 2);
      nFP = new b[] { nFM, nFN, nFO };
      AppMethodBeat.o(44323);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */