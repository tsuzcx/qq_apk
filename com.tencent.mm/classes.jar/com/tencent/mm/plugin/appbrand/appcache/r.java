package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.mm.h.b.a.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class r
{
  private static final byte[] fCL = new byte[0];
  
  public static void af(String arg0, int paramInt)
  {
    if (bk.bl(???)) {}
    String str;
    x localx;
    do
    {
      do
      {
        return;
        str = com.tencent.mm.plugin.appbrand.config.r.sv(???);
      } while (bk.bl(str));
      localx = (x)com.tencent.mm.plugin.appbrand.app.e.G(x.class);
    } while (localx == null);
    for (;;)
    {
      w localw;
      synchronized (fCL)
      {
        localw = new w();
        localw.field_appId = str;
        localw.field_type = paramInt;
        if (localx.b(localw, w.fCT))
        {
          localw.field_hit += 1;
          localw.field_hitTimeMS = bk.UY();
          localx.c(localw, w.fCT);
          return;
        }
      }
      localw.field_hit = 1;
      localw.field_hitTimeMS = bk.UY();
      localx.b(localw);
    }
  }
  
  public static r.a cs(long paramLong)
  {
    if (paramLong <= 0L) {
      return r.a.fCM;
    }
    ??? = new StatFs(aj.abZ());
    int i = ((StatFs)???).getAvailableBlocks();
    long l = ((StatFs)???).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong)) {
      return r.a.fCM;
    }
    Object localObject5 = (x)com.tencent.mm.plugin.appbrand.app.e.G(x.class);
    if (localObject5 == null)
    {
      y.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      return r.a.fCO;
    }
    String str = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject2 = new LinkedList();
    synchronized (fCL)
    {
      localObject5 = ((x)localObject5).dXw.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, str, 2);
      if (localObject5 == null)
      {
        localObject2 = r.a.fCO;
        return localObject2;
      }
    }
    r.a locala;
    if (!((Cursor)localObject5).moveToFirst())
    {
      ((Cursor)localObject5).close();
      locala = r.a.fCO;
      return locala;
    }
    try
    {
      boolean bool;
      do
      {
        locala.add(Pair.create(((Cursor)localObject5).getString(0), Integer.valueOf(((Cursor)localObject5).getInt(1))));
        bool = ((Cursor)localObject5).moveToNext();
      } while (bool);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
        ((Cursor)localObject5).close();
      }
    }
    finally
    {
      ((Cursor)localObject5).close();
    }
    ??? = com.tencent.mm.plugin.appbrand.app.e.abb();
    if (??? == null)
    {
      y.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
      return r.a.fCO;
    }
    l = 0L;
    i = 0;
    Iterator localIterator = localObject4.iterator();
    while (localIterator.hasNext())
    {
      localObject5 = (Pair)localIterator.next();
      localObject5 = ((ar)???).a((String)((Pair)localObject5).first, ((Integer)((Pair)localObject5).second).intValue(), ar.a.fEF, new String[] { "pkgPath" }).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        an localan = (an)((Iterator)localObject5).next();
        l += com.tencent.mm.a.e.bJ(localan.field_pkgPath);
        com.tencent.mm.a.e.deleteFile(localan.field_pkgPath);
        i += 1;
        if (l >= paramLong)
        {
          ??? = new ad();
          ((ad)???).ckB = 3L;
          ((ad)???).ckE = i;
          if (l.abI()) {}
          for (paramLong = 1L;; paramLong = 0L)
          {
            ((ad)???).ckz = paramLong;
            ((ad)???).QX();
            return r.a.fCN;
          }
        }
      }
    }
    return r.a.fCO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.r
 * JD-Core Version:    0.7.0.1
 */