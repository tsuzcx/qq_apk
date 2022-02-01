package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ac
{
  private static final byte[] jJL = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = b.jJN;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(az.baY());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.jJN;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (ai)j.T(ai.class);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.jJP;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (jJL)
    {
      localObject4 = ((ai)localObject1).db.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = b.jJP;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = b.jJP;
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
          ae.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      ??? = j.aZu();
      if (??? == null)
      {
        ae.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.jJP;
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
      Iterator localIterator = ((bh)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bh.a.jLP, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bd localbd = (bd)localIterator.next();
        l = o.aZR(localbd.field_pkgPath) + l;
        o.deleteFile(localbd.field_pkgPath);
        i += 1;
        ((ai)localObject1).aM((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new hw();
          parama.euV = 3L;
          parama.euX = i;
          parama.euT = 1L;
          parama.aLH();
          parama = b.jJO;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = b.jJP;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.aWa()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void aL(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (bu.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = v.Om(???);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(44308);
      return;
    }
    ai localai = (ai)j.T(ai.class);
    if (localai == null)
    {
      AppMethodBeat.o(44308);
      return;
    }
    synchronized (jJL)
    {
      ah localah = new ah();
      localah.field_appId = str;
      localah.field_type = paramInt;
      if (localai.get(localah, ah.jHZ))
      {
        localah.field_hit += 1;
        localah.field_hitTimeMS = bu.fpO();
        localai.update(localah, ah.jHZ);
        AppMethodBeat.o(44308);
        return;
      }
      localah.field_hit = 1;
      localah.field_hitTimeMS = bu.fpO();
      localai.insert(localah);
    }
  }
  
  public static b sQ(long paramLong)
  {
    AppMethodBeat.i(44309);
    try
    {
      b localb1 = a(paramLong, a.jJM);
      AppMethodBeat.o(44309);
      return localb1;
    }
    catch (InterruptedException localInterruptedException)
    {
      ae.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", new Object[] { localInterruptedException });
      b localb2 = b.jJP;
      AppMethodBeat.o(44309);
      return localb2;
    }
  }
  
  public static abstract interface a
  {
    public static final a jJM = new a()
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
      AppMethodBeat.i(44307);
      jJN = new b("NO_NEED", 0);
      jJO = new b("TRIMMED", 1);
      jJP = new b("TRIM_FAIL", 2);
      jJQ = new b[] { jJN, jJO, jJP };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */