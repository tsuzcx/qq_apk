package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.si;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ae
{
  private static final byte[] qFv = new byte[0];
  
  public static b a(long paramLong, List<o.a> paramList, a parama)
  {
    AppMethodBeat.i(320255);
    if (paramLong <= 0L)
    {
      paramList = b.qFx;
      AppMethodBeat.o(320255);
      return paramList;
    }
    Object localObject1 = new StatFs(bd.cgP());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      paramList = b.qFx;
      AppMethodBeat.o(320255);
      return paramList;
    }
    localObject1 = (ak)n.ag(ak.class);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      paramList = b.qFz;
      AppMethodBeat.o(320255);
      return paramList;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (qFv)
    {
      localObject4 = ((ak)localObject1).db.query("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        paramList = b.qFz;
        AppMethodBeat.o(320255);
        return paramList;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        paramList = b.qFz;
        AppMethodBeat.o(320255);
        return paramList;
      }
    }
    try
    {
      boolean bool;
      do
      {
        ((LinkedList)localObject3).add(Pair.create(((Cursor)localObject4).getString(0), Integer.valueOf(((Cursor)localObject4).getInt(1))));
        bool = ((Cursor)localObject4).moveToNext();
      } while (bool);
      ((Cursor)localObject4).close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
        ((Cursor)localObject4).close();
      }
      paramList = finally;
      AppMethodBeat.o(320255);
      throw paramList;
    }
    finally
    {
      ((Cursor)localObject4).close();
      AppMethodBeat.o(320255);
    }
    ??? = n.cfm();
    if (??? == null)
    {
      Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
      paramList = b.qFz;
      AppMethodBeat.o(320255);
      return paramList;
    }
    a(parama);
    localObject3 = ((LinkedList)localObject3).iterator();
    l = 0L;
    i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Pair)((Iterator)localObject3).next();
      Object localObject5 = new o.a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
      if (paramList.contains(localObject5))
      {
        Log.i("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize appPkg: %s is in white list, skip", new Object[] { localObject5 });
      }
      else
      {
        localObject5 = ((bm)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bm.a.qHE, new String[] { "pkgPath" }).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          bh localbh = (bh)((Iterator)localObject5).next();
          l = y.bEl(localbh.field_pkgPath) + l;
          y.deleteFile(localbh.field_pkgPath);
          i += 1;
          ((ak)localObject1).bB((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
          a(parama);
          if (l >= paramLong)
          {
            paramList = new si();
            paramList.jxW = 3L;
            paramList.jxY = i;
            paramList.jxU = 1L;
            paramList.bMH();
            paramList = b.qFy;
            AppMethodBeat.o(320255);
            return paramList;
          }
        }
      }
    }
    paramList = b.qFz;
    AppMethodBeat.o(320255);
    return paramList;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.cbj()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void bA(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (Util.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = ad.XJ(???);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    ak localak = (ak)n.ag(ak.class);
    if (localak == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (qFv)
    {
      aj localaj = new aj();
      localaj.field_appId = str;
      localaj.field_type = paramInt;
      if (localak.get(localaj, aj.qDJ))
      {
        localaj.field_hit += 1;
        localaj.field_hitTimeMS = Util.nowMilliSecond();
        localak.update(localaj, aj.qDJ);
        AppMethodBeat.o(44308);
        return;
      }
      localaj.field_hit = 1;
      localaj.field_hitTimeMS = Util.nowMilliSecond();
      localak.insert(localaj);
    }
  }
  
  public static abstract interface a
  {
    public static final a qFw = new a()
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
      AppMethodBeat.i(44307);
      qFx = new b("NO_NEED", 0);
      qFy = new b("TRIMMED", 1);
      qFz = new b("TRIM_FAIL", 2);
      qFA = new b[] { qFx, qFy, qFz };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */