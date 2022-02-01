package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ab
{
  private static final byte[] jGL = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = b.jGN;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(ay.baz());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.jGN;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (ah)j.T(ah.class);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.jGP;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (jGL)
    {
      localObject4 = ((ah)localObject1).db.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = b.jGP;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = b.jGP;
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
          ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      ??? = j.aYX();
      if (??? == null)
      {
        ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.jGP;
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
      Iterator localIterator = ((bg)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bg.a.jIO, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bc localbc = (bc)localIterator.next();
        l = i.aYo(localbc.field_pkgPath) + l;
        i.deleteFile(localbc.field_pkgPath);
        i += 1;
        ((ah)localObject1).aJ((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new hu();
          parama.eto = 3L;
          parama.etq = i;
          parama.etm = 1L;
          parama.aLk();
          parama = b.jGO;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = b.jGP;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.aVB()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void aI(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (bt.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = v.NE(???);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    ah localah = (ah)j.T(ah.class);
    if (localah == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (jGL)
    {
      ag localag = new ag();
      localag.field_appId = str;
      localag.field_type = paramInt;
      if (localah.get(localag, ag.jFa))
      {
        localag.field_hit += 1;
        localag.field_hitTimeMS = bt.flT();
        localah.update(localag, ag.jFa);
        AppMethodBeat.o(44308);
        return;
      }
      localag.field_hit = 1;
      localag.field_hitTimeMS = bt.flT();
      localah.insert(localag);
    }
  }
  
  public static b sD(long paramLong)
  {
    AppMethodBeat.i(44309);
    try
    {
      b localb1 = a(paramLong, a.jGM);
      AppMethodBeat.o(44309);
      return localb1;
    }
    catch (InterruptedException localInterruptedException)
    {
      ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", new Object[] { localInterruptedException });
      b localb2 = b.jGP;
      AppMethodBeat.o(44309);
      return localb2;
    }
  }
  
  public static abstract interface a
  {
    public static final a jGM = new a()
    {
      public final boolean aVB()
      {
        return false;
      }
    };
    
    public abstract boolean aVB();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44307);
      jGN = new b("NO_NEED", 0);
      jGO = new b("TRIMMED", 1);
      jGP = new b("TRIM_FAIL", 2);
      jGQ = new b[] { jGN, jGO, jGP };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */