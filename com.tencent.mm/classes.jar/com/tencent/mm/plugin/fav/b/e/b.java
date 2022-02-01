package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b
  implements f, r
{
  private static Map<Long, f.a> dio;
  private Queue<com.tencent.mm.plugin.fav.a.g> dim;
  private boolean diq;
  private long dit;
  public av dix;
  public com.tencent.mm.network.n hTD;
  private boolean running;
  private boolean ruo;
  
  static
  {
    AppMethodBeat.i(101621);
    dio = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.dit = 0L;
    this.diq = false;
    this.dim = new LinkedList();
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101611);
        boolean bool;
        try
        {
          bool = ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext());
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            b.a(b.this, bool);
            AppMethodBeat.o(101611);
            return;
          }
          ad.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(b.this)) });
          if ((!b.c(b.this)) && (bool))
          {
            b localb = b.this;
            Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvm();
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label271;
            }
            ad.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
              if (localg.field_itemStatus == 3)
              {
                localg.field_itemStatus = 1;
                ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
              }
            }
            localException.run();
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101611);
          return;
        }
        for (;;)
        {
          b.a(b.this, bool);
          AppMethodBeat.o(101611);
          return;
          label271:
          ad.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
        }
      }
    };
    this.dix = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(101614);
        try
        {
          b.b(b.this);
          AppMethodBeat.o(101614);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101615);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(101615);
        return str;
      }
    }, false);
    this.ruo = ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext());
    com.tencent.mm.kernel.g.ajB().a(this.hTD);
    com.tencent.mm.kernel.g.aiU().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void Qe()
  {
    AppMethodBeat.i(101619);
    this.dim.clear();
    dio.clear();
    this.running = false;
    this.diq = false;
    AppMethodBeat.o(101619);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101609);
        if (paramn.getType() != 404)
        {
          AppMethodBeat.o(101609);
          return;
        }
        if (!(paramn instanceof com.tencent.mm.plugin.fav.a.aj))
        {
          AppMethodBeat.o(101609);
          return;
        }
        b.a(b.this);
        long l = ((com.tencent.mm.plugin.fav.a.aj)paramn).rtA.field_localId;
        com.tencent.mm.plugin.fav.a.g localg = ((com.tencent.mm.plugin.fav.a.aj)paramn).rtA;
        b.aaT().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          ad.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(3, l);
        }
        b.b(b.this);
        AppMethodBeat.o(101609);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101610);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(101610);
        return str;
      }
    });
    AppMethodBeat.o(101617);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101618);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101612);
        long l = System.currentTimeMillis() - b.d(b.this);
        if (b.e(b.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(101612);
            return;
          }
          ad.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(b.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(b.this));
        }
        b.a(b.this);
        b.f(b.this);
        b.g(b.this).az(10L, 10L);
        AppMethodBeat.o(101612);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101613);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101613);
        return str;
      }
    });
    AppMethodBeat.o(101618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b
 * JD-Core Version:    0.7.0.1
 */