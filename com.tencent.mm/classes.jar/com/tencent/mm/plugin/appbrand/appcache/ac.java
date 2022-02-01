package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ac
{
  private static final byte[] kLI = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = b.kLK;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(az.bwm());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.kLK;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (ai)n.W(ai.class);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.kLM;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (kLI)
    {
      localObject4 = ((ai)localObject1).db.query("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = b.kLM;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = b.kLM;
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
      ??? = n.buL();
      if (??? == null)
      {
        Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.kLM;
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
      Iterator localIterator = ((bh)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bh.a.kNQ, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bd localbd = (bd)localIterator.next();
        l = s.boW(localbd.field_pkgPath) + l;
        s.deleteFile(localbd.field_pkgPath);
        i += 1;
        ((ai)localObject1).aS((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new lr();
          parama.eZr = 3L;
          parama.eZt = i;
          parama.eZp = 1L;
          parama.bfK();
          parama = b.kLL;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = b.kLM;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.bqX()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void aR(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (Util.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = y.Xw(???);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    ai localai = (ai)n.W(ai.class);
    if (localai == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (kLI)
    {
      ah localah = new ah();
      localah.field_appId = str;
      localah.field_type = paramInt;
      if (localai.get(localah, ah.kJX))
      {
        localah.field_hit += 1;
        localah.field_hitTimeMS = Util.nowMilliSecond();
        localai.update(localah, ah.kJX);
        AppMethodBeat.o(44308);
        return;
      }
      localah.field_hit = 1;
      localah.field_hitTimeMS = Util.nowMilliSecond();
      localai.insert(localah);
    }
  }
  
  public static abstract interface a
  {
    public static final a kLJ = new a()
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
      AppMethodBeat.i(44307);
      kLK = new b("NO_NEED", 0);
      kLL = new b("TRIMMED", 1);
      kLM = new b("TRIM_FAIL", 2);
      kLN = new b[] { kLK, kLL, kLM };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */