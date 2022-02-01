package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.op;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ad
{
  private static final byte[] nFB = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = b.nFD;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(bc.bHt());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.nFD;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (aj)m.W(aj.class);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.nFF;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (nFB)
    {
      localObject4 = ((aj)localObject1).db.query("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = b.nFF;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = b.nFF;
        AppMethodBeat.o(44310);
        return parama;
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
        parama = finally;
        AppMethodBeat.o(44310);
        throw parama;
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(44310);
      }
      ??? = m.bFP();
      if (??? == null)
      {
        Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.nFF;
        AppMethodBeat.o(44310);
        return parama;
      }
    }
    a(parama);
    localObject3 = ((LinkedList)localObject3).iterator();
    l = 0L;
    i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Pair)((Iterator)localObject3).next();
      Iterator localIterator = ((bm)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bm.a.nHP, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bh localbh = (bh)localIterator.next();
        l = u.bBQ(localbh.field_pkgPath) + l;
        u.deleteFile(localbh.field_pkgPath);
        i += 1;
        ((aj)localObject1).bk((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new op();
          parama.hci = 3L;
          parama.hck = i;
          parama.hcg = 1L;
          parama.bpa();
          parama = b.nFE;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = b.nFF;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.bBN()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void bj(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (Util.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = y.afi(???);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    aj localaj = (aj)m.W(aj.class);
    if (localaj == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (nFB)
    {
      ai localai = new ai();
      localai.field_appId = str;
      localai.field_type = paramInt;
      if (localaj.get(localai, ai.nDP))
      {
        localai.field_hit += 1;
        localai.field_hitTimeMS = Util.nowMilliSecond();
        localaj.update(localai, ai.nDP);
        AppMethodBeat.o(44308);
        return;
      }
      localai.field_hit = 1;
      localai.field_hitTimeMS = Util.nowMilliSecond();
      localaj.insert(localai);
    }
  }
  
  public static abstract interface a
  {
    public static final a nFC = new a()
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
      AppMethodBeat.i(44307);
      nFD = new b("NO_NEED", 0);
      nFE = new b("TRIMMED", 1);
      nFF = new b("TRIM_FAIL", 2);
      nFG = new b[] { nFD, nFE, nFF };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */