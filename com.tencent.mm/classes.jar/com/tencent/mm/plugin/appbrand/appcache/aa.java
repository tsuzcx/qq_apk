package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class aa
{
  private static final byte[] iMG = new byte[0];
  
  public static aa.b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = aa.b.iMI;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(ax.aQj());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = aa.b.iMI;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (ag)j.T(ag.class);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = aa.b.iMK;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (iMG)
    {
      localObject4 = ((ag)localObject1).db.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = aa.b.iMK;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = aa.b.iMK;
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
      ??? = j.aOK();
      if (??? == null)
      {
        ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = aa.b.iMK;
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
      Iterator localIterator = ((bf)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bf.a.iOJ, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bb localbb = (bb)localIterator.next();
        l = i.aMN(localbb.field_pkgPath) + l;
        i.deleteFile(localbb.field_pkgPath);
        i += 1;
        ((ag)localObject1).aD((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new ez();
          parama.eaD = 3L;
          parama.eaF = i;
          parama.eaB = 1L;
          parama.aBj();
          parama = aa.b.iMJ;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = aa.b.iMK;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.aLy()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void aC(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (bt.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = u.Gh(???);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    ag localag = (ag)j.T(ag.class);
    if (localag == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (iMG)
    {
      af localaf = new af();
      localaf.field_appId = str;
      localaf.field_type = paramInt;
      if (localag.get(localaf, af.iLd))
      {
        localaf.field_hit += 1;
        localaf.field_hitTimeMS = bt.eGO();
        localag.update(localaf, af.iLd);
        AppMethodBeat.o(44308);
        return;
      }
      localaf.field_hit = 1;
      localaf.field_hitTimeMS = bt.eGO();
      localag.insert(localaf);
    }
  }
  
  public static aa.b mQ(long paramLong)
  {
    AppMethodBeat.i(44309);
    try
    {
      aa.b localb1 = a(paramLong, a.iMH);
      AppMethodBeat.o(44309);
      return localb1;
    }
    catch (InterruptedException localInterruptedException)
    {
      ad.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", new Object[] { localInterruptedException });
      aa.b localb2 = aa.b.iMK;
      AppMethodBeat.o(44309);
      return localb2;
    }
  }
  
  public static abstract interface a
  {
    public static final a iMH = new a()
    {
      public final boolean aLy()
      {
        return false;
      }
    };
    
    public abstract boolean aLy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */