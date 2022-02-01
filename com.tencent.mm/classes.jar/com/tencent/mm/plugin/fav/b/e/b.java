package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class b
  implements i, s
{
  private static Map<Long, f.a> ftr;
  private Queue<g> ftp;
  private boolean ftt;
  private long ftv;
  public MTimerHandler fty;
  public p lHL;
  private boolean running;
  private boolean wIk;
  
  static
  {
    AppMethodBeat.i(101621);
    ftr = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.ftv = 0L;
    this.ftt = false;
    this.ftp = new LinkedList();
    this.lHL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101611);
        boolean bool;
        try
        {
          bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            b.a(b.this, bool);
            AppMethodBeat.o(101611);
            return;
          }
          Log.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(b.c(b.this)) });
          if ((!b.c(b.this)) && (bool))
          {
            b localb = b.this;
            Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().djX();
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label271;
            }
            Log.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              g localg = (g)((Iterator)localObject).next();
              if (localg.field_itemStatus == 3)
              {
                localg.field_itemStatus = 1;
                ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
              }
            }
            localException.run();
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101611);
          return;
        }
        for (;;)
        {
          b.a(b.this, bool);
          AppMethodBeat.o(101611);
          return;
          label271:
          Log.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
        }
      }
    };
    this.fty = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
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
            Log.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
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
    this.wIk = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    com.tencent.mm.kernel.h.aHF().a(this.lHL);
    com.tencent.mm.kernel.h.aGY().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void afk()
  {
    AppMethodBeat.i(101619);
    this.ftp.clear();
    ftr.clear();
    this.running = false;
    this.ftt = false;
    AppMethodBeat.o(101619);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101609);
        if (paramq.getType() != 404)
        {
          AppMethodBeat.o(101609);
          return;
        }
        if (!(paramq instanceof ak))
        {
          AppMethodBeat.o(101609);
          return;
        }
        b.a(b.this);
        long l = ((ak)paramq).wHw.field_localId;
        g localg = ((ak)paramq).wHw;
        b.avo().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          Log.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.Kf(localg.field_localId)) });
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(3, l);
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
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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
          Log.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(b.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(b.this));
        }
        b.a(b.this);
        b.f(b.this);
        b.g(b.this).startTimer(10L);
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