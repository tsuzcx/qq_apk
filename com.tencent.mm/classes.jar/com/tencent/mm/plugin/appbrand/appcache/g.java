package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class g
{
  private static final byte[] gTS = new byte[0];
  
  public static g.b a(long paramLong, g.a parama)
  {
    AppMethodBeat.i(129332);
    if (paramLong <= 0L)
    {
      parama = g.b.gTW;
      AppMethodBeat.o(129332);
      return parama;
    }
    Object localObject1 = new StatFs(ap.avQ());
    long l = ((StatFs)localObject1).getAvailableBlocks();
    l = ((StatFs)localObject1).getBlockSize() * l;
    if ((l < 0L) || (l > paramLong))
    {
      parama = g.b.gTW;
      AppMethodBeat.o(129332);
      return parama;
    }
    localObject1 = (f)com.tencent.mm.plugin.appbrand.app.g.w(f.class);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[] { Long.valueOf(paramLong) });
      parama = g.b.gTY;
      AppMethodBeat.o(129332);
      return parama;
    }
    Object localObject4 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    Object localObject3 = new LinkedList();
    synchronized (gTS)
    {
      localObject4 = ((f)localObject1).db.a("CodeLibUsageLRURecord", new String[] { "appId", "version" }, null, null, null, null, (String)localObject4, 2);
      if (localObject4 == null)
      {
        parama = g.b.gTY;
        AppMethodBeat.o(129332);
        return parama;
      }
      if (!((Cursor)localObject4).moveToFirst())
      {
        ((Cursor)localObject4).close();
        parama = g.b.gTY;
        AppMethodBeat.o(129332);
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
          ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy, read from cursor e = %s", new Object[] { localException });
          ((Cursor)localObject4).close();
        }
        parama = finally;
        AppMethodBeat.o(129332);
        throw parama;
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(129332);
      }
      ab.i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "codelib size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject3).size()) });
      ??? = com.tencent.mm.plugin.appbrand.app.g.auM();
      if (??? == null)
      {
        ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[] { Long.valueOf(paramLong) });
        parama = g.b.gTY;
        AppMethodBeat.o(129332);
        return parama;
      }
    }
    a(parama);
    localObject3 = ((LinkedList)localObject3).iterator();
    l = 0L;
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Pair)((Iterator)localObject3).next();
      Iterator localIterator = ((ay)???).b((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue(), ay.a.gWX, new String[] { "pkgPath" }).iterator();
      label723:
      label728:
      while (localIterator.hasNext())
      {
        Object localObject5 = (at)localIterator.next();
        l = com.tencent.mm.a.e.cM(((at)localObject5).field_pkgPath) + l;
        ab.i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "wxapkg appid:%s,delete path:%s", new Object[] { ((at)localObject5).field_appId, ((at)localObject5).field_pkgPath });
        com.tencent.mm.a.e.deleteFile(((at)localObject5).field_pkgPath);
        String str = ((at)localObject5).field_appId;
        final int j = ((at)localObject5).field_version;
        if (bo.isNullOrNil(str))
        {
          ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "removeCodeCache appId null or nil!");
          i += 1;
          ((f)localObject1).an((String)((Pair)localObject4).first, ((Integer)((Pair)localObject4).second).intValue());
          a(parama);
          if (l < paramLong) {
            break label728;
          }
          parama = new ca();
          parama.cZU = 4L;
          parama.cZX = i;
          if (!r.avz()) {
            break label723;
          }
        }
        for (paramLong = 1L;; paramLong = 0L)
        {
          parama.cZS = paramLong;
          parama.ake();
          parama = g.b.gTX;
          AppMethodBeat.o(129332);
          return parama;
          localObject5 = str.substring(0, str.indexOf("$"));
          com.tencent.mm.plugin.appbrand.app.g.auT();
          am.a(new FilenameFilter()
          {
            public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
            {
              AppMethodBeat.i(129327);
              boolean bool = paramAnonymousString.equals(this.gTT + "_" + j);
              AppMethodBeat.o(129327);
              return bool;
            }
          });
          break;
        }
      }
    }
    parama = g.b.gTY;
    AppMethodBeat.o(129332);
    return parama;
  }
  
  private static void a(g.a parama)
  {
    AppMethodBeat.i(129333);
    if ((parama != null) && (parama.avg()))
    {
      parama = new InterruptedException();
      AppMethodBeat.o(129333);
      throw parama;
    }
    AppMethodBeat.o(129333);
  }
  
  public static void ao(String paramString, int paramInt)
  {
    AppMethodBeat.i(129331);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129331);
      return;
    }
    f localf = (f)com.tencent.mm.plugin.appbrand.app.g.w(f.class);
    if (localf == null)
    {
      AppMethodBeat.o(129331);
      return;
    }
    synchronized (gTS)
    {
      h localh = new h();
      localh.field_appId = paramString;
      localh.field_version = paramInt;
      if (localf.get(localh, h.gUa))
      {
        localh.field_hit += 1;
        localh.field_hitTimeMS = bo.aoy();
        localf.update(localh, h.gUa);
        AppMethodBeat.o(129331);
        return;
      }
      localh.field_hit = 1;
      localh.field_hitTimeMS = bo.aoy();
      localf.insert(localh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.g
 * JD-Core Version:    0.7.0.1
 */