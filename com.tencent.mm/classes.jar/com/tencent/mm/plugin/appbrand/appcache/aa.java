package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class aa
{
  private static final byte[] jmN = new byte[0];
  
  public static b a(long paramLong, a parama)
  {
    AppMethodBeat.i(44310);
    if (paramLong <= 0L)
    {
      parama = b.jmP;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject1 = new StatFs(ax.aXb());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = b.jmP;
      AppMethodBeat.o(44310);
      return parama;
    }
    localObject1 = (ag)j.T(ag.class);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = b.jmR;
      AppMethodBeat.o(44310);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (jmN)
    {
      localObject4 = ((ag)localObject1).db.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = b.jmR;
        AppMethodBeat.o(44310);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = b.jmR;
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
          ac.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
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
      ??? = j.aVC();
      if (??? == null)
      {
        ac.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = b.jmR;
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
      Iterator localIterator = ((bf)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), bf.a.joS, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        bb localbb = (bb)localIterator.next();
        l = i.aSp(localbb.field_pkgPath) + l;
        i.deleteFile(localbb.field_pkgPath);
        i += 1;
        ((ag)localObject1).aH((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new gr();
          parama.ecJ = 3L;
          parama.ecL = i;
          parama.ecH = 1L;
          parama.aHZ();
          parama = b.jmQ;
          AppMethodBeat.o(44310);
          return parama;
        }
      }
    }
    parama = b.jmR;
    AppMethodBeat.o(44310);
    return parama;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(44311);
    if ((parama != null) && (parama.aSp()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(44311);
      throw parama;
    }
    AppMethodBeat.o(44311);
  }
  
  public static void aG(String arg0, int paramInt)
  {
    AppMethodBeat.i(44308);
    if (bs.isNullOrNil(???))
    {
      AppMethodBeat.o(44308);
      return;
    }
    String str = u.Kl(???);
    if (bs.isNullOrNil(str))
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
    synchronized (jmN)
    {
      af localaf = new af();
      localaf.field_appId = str;
      localaf.field_type = paramInt;
      if (localag.get(localaf, af.jlk))
      {
        localaf.field_hit += 1;
        localaf.field_hitTimeMS = bs.eWj();
        localag.update(localaf, af.jlk);
        AppMethodBeat.o(44308);
        return;
      }
      localaf.field_hit = 1;
      localaf.field_hitTimeMS = bs.eWj();
      localag.insert(localaf);
    }
  }
  
  public static b qF(long paramLong)
  {
    AppMethodBeat.i(44309);
    try
    {
      b localb1 = a(paramLong, a.jmO);
      AppMethodBeat.o(44309);
      return localb1;
    }
    catch (InterruptedException localInterruptedException)
    {
      ac.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", new Object[] { localInterruptedException });
      b localb2 = b.jmR;
      AppMethodBeat.o(44309);
      return localb2;
    }
  }
  
  public static abstract interface a
  {
    public static final a jmO = new a()
    {
      public final boolean aSp()
      {
        return false;
      }
    };
    
    public abstract boolean aSp();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(44307);
      jmP = new b("NO_NEED", 0);
      jmQ = new b("TRIMMED", 1);
      jmR = new b("TRIM_FAIL", 2);
      jmS = new b[] { jmP, jmQ, jmR };
      AppMethodBeat.o(44307);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */