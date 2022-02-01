package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b
  implements f, r
{
  private static Map<Long, f.a> djr;
  private Queue<com.tencent.mm.plugin.fav.a.g> djp;
  private boolean djt;
  private long djv;
  public aw djz;
  public com.tencent.mm.network.n hWv;
  private boolean rCA;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101621);
    djr = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.djv = 0L;
    this.djt = false;
    this.djp = new LinkedList();
    this.hWv = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101611);
        boolean bool;
        try
        {
          bool = az.isWifi(ak.getContext());
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            b.a(b.this, bool);
            AppMethodBeat.o(101611);
            return;
          }
          ae.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(b.this)) });
          if ((!b.c(b.this)) && (bool))
          {
            b localb = b.this;
            Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwN();
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label271;
            }
            ae.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          ae.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101611);
          return;
        }
        for (;;)
        {
          b.a(b.this, bool);
          AppMethodBeat.o(101611);
          return;
          label271:
          ae.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
        }
      }
    };
    this.djz = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
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
            ae.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
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
    this.rCA = az.isWifi(ak.getContext());
    com.tencent.mm.kernel.g.ajQ().a(this.hWv);
    com.tencent.mm.kernel.g.ajj().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void Qd()
  {
    AppMethodBeat.i(101619);
    this.djp.clear();
    djr.clear();
    this.running = false;
    this.djt = false;
    AppMethodBeat.o(101619);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
        long l = ((aj)paramn).rBM.field_localId;
        com.tencent.mm.plugin.fav.a.g localg = ((aj)paramn).rBM;
        b.abc().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          ae.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(h.vN(localg.field_localId)) });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(3, l);
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
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
          ae.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(b.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(b.this));
        }
        b.a(b.this);
        b.f(b.this);
        b.g(b.this).ay(10L, 10L);
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