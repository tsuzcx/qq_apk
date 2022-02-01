package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b
  implements com.tencent.mm.al.g, r
{
  private static Map<Long, f.a> cZC;
  private Queue<com.tencent.mm.plugin.fav.a.g> cZA;
  private boolean cZE;
  private long cZG;
  public av cZK;
  public com.tencent.mm.network.n haH;
  private boolean qbG;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101621);
    cZC = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.cZG = 0L;
    this.cZE = false;
    this.cZA = new LinkedList();
    this.haH = new n.a()
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
            Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cia();
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
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new b.4(this), false);
    this.qbG = ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext());
    com.tencent.mm.kernel.g.afA().a(this.haH);
    com.tencent.mm.kernel.g.aeS().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void Oy()
  {
    AppMethodBeat.i(101619);
    this.cZA.clear();
    cZC.clear();
    this.running = false;
    this.cZE = false;
    AppMethodBeat.o(101619);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
        long l = ((com.tencent.mm.plugin.fav.a.aj)paramn).qaS.field_localId;
        com.tencent.mm.plugin.fav.a.g localg = ((com.tencent.mm.plugin.fav.a.aj)paramn).qaS;
        b.Xu().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          ad.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.pL(localg.field_localId)) });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(3, l);
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
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
        b.g(b.this).av(10L, 10L);
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