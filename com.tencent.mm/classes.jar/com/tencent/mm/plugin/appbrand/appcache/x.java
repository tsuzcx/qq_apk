package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class x
{
  private static final byte[] gTS = new byte[0];
  
  public static x.b a(long paramLong, x.a parama)
  {
    AppMethodBeat.i(129404);
    if (paramLong <= 0L)
    {
      parama = x.b.gVd;
      AppMethodBeat.o(129404);
      return parama;
    }
    Object localObject1 = new StatFs(ap.avQ());
    int i = ((StatFs)localObject1).getAvailableBlocks();
    long l = ((StatFs)localObject1).getBlockSize() * i;
    if ((l < 0L) || (l > paramLong))
    {
      parama = x.b.gVd;
      AppMethodBeat.o(129404);
      return parama;
    }
    localObject1 = (ad)g.w(ad.class);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = x.b.gVf;
      AppMethodBeat.o(129404);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (gTS)
    {
      localObject4 = ((ad)localObject1).db.a("PkgUsageLRURecord", new String[] { "appId", "type" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = x.b.gVf;
        AppMethodBeat.o(129404);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = x.b.gVf;
        AppMethodBeat.o(129404);
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
          ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
          ((Cursor)localObject4).close();
        }
        parama = finally;
        AppMethodBeat.o(129404);
        throw parama;
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(129404);
      }
      ??? = g.auM();
      if (??? == null)
      {
        ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = x.b.gVf;
        AppMethodBeat.o(129404);
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
      Iterator localIterator = ((ay)???).a((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), ay.a.gWX, new String[] { "pkgPath" }).iterator();
      while (localIterator.hasNext())
      {
        at localat = (at)localIterator.next();
        l = com.tencent.mm.vfs.e.avI(localat.field_pkgPath) + l;
        com.tencent.mm.vfs.e.deleteFile(localat.field_pkgPath);
        i += 1;
        ((ad)localObject1).an((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
        a(parama);
        if (l >= paramLong)
        {
          parama = new ca();
          parama.cZU = 3L;
          parama.cZX = i;
          if (r.avy()) {}
          for (paramLong = 1L;; paramLong = 0L)
          {
            parama.cZS = paramLong;
            parama.ake();
            parama = x.b.gVe;
            AppMethodBeat.o(129404);
            return parama;
          }
        }
      }
    }
    parama = x.b.gVf;
    AppMethodBeat.o(129404);
    return parama;
  }
  
  private static void a(x.a parama)
  {
    AppMethodBeat.i(129405);
    if ((parama != null) && (parama.avg()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(129405);
      throw parama;
    }
    AppMethodBeat.o(129405);
  }
  
  public static void ao(String arg0, int paramInt)
  {
    AppMethodBeat.i(129402);
    if (bo.isNullOrNil(???))
    {
      AppMethodBeat.o(129402);
      return;
    }
    String str = q.Aq(???);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(129402);
      return;
    }
    ad localad = (ad)g.w(ad.class);
    if (localad == null)
    {
      AppMethodBeat.o(129402);
      return;
    }
    synchronized (gTS)
    {
      ac localac = new ac();
      localac.field_appId = str;
      localac.field_type = paramInt;
      if (localad.get(localac, ac.gUa))
      {
        localac.field_hit += 1;
        localac.field_hitTimeMS = bo.aoy();
        localad.update(localac, ac.gUa);
        AppMethodBeat.o(129402);
        return;
      }
      localac.field_hit = 1;
      localac.field_hitTimeMS = bo.aoy();
      localad.insert(localac);
    }
  }
  
  public static x.b hp(long paramLong)
  {
    AppMethodBeat.i(129403);
    try
    {
      x.b localb1 = a(paramLong, x.a.gVc);
      AppMethodBeat.o(129403);
      return localb1;
    }
    catch (InterruptedException localInterruptedException)
    {
      ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", new Object[] { localInterruptedException });
      x.b localb2 = x.b.gVf;
      AppMethodBeat.o(129403);
      return localb2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */