package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b
  implements com.tencent.mm.ak.g, r
{
  private static Map<Long, f.a> cWY;
  private Queue<com.tencent.mm.plugin.fav.a.g> cWW;
  private boolean cXa;
  private long cXc;
  public au cXg;
  public com.tencent.mm.network.n hBi;
  private boolean qKm;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101621);
    cWY = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.cXc = 0L;
    this.cXa = false;
    this.cWW = new LinkedList();
    this.hBi = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101611);
        boolean bool;
        try
        {
          bool = ax.isWifi(ai.getContext());
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            b.a(b.this, bool);
            AppMethodBeat.o(101611);
            return;
          }
          ac.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(b.this)) });
          if ((!b.c(b.this)) && (bool))
          {
            b localb = b.this;
            Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpH();
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label271;
            }
            ac.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          ac.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101611);
          return;
        }
        for (;;)
        {
          b.a(b.this, bool);
          AppMethodBeat.o(101611);
          return;
          label271:
          ac.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
        }
      }
    };
    this.cXg = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
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
            ac.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
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
    this.qKm = ax.isWifi(ai.getContext());
    com.tencent.mm.kernel.g.agQ().a(this.hBi);
    com.tencent.mm.kernel.g.agi().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void Ou()
  {
    AppMethodBeat.i(101619);
    this.cWW.clear();
    cWY.clear();
    this.running = false;
    this.cXa = false;
    AppMethodBeat.o(101619);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101609);
        if (paramn.getType() != 404)
        {
          AppMethodBeat.o(101609);
          return;
        }
        if (!(paramn instanceof aj))
        {
          AppMethodBeat.o(101609);
          return;
        }
        b.a(b.this);
        long l = ((aj)paramn).qJy.field_localId;
        com.tencent.mm.plugin.fav.a.g localg = ((aj)paramn).qJy;
        b.Yr().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          ac.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.tA(localg.field_localId)) });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(3, l);
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
    com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          ac.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(b.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(b.this));
        }
        b.a(b.this);
        b.f(b.this);
        b.g(b.this).au(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b
 * JD-Core Version:    0.7.0.1
 */