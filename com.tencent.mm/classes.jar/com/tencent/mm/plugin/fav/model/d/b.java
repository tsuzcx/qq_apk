package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class b
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.fav.a.s
{
  private static Map<Long, f.a> hxG;
  private boolean Aey;
  private Queue<g> hxE;
  private boolean hxI;
  private long hxK;
  public MTimerHandler hxN;
  public com.tencent.mm.network.p oAk;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101621);
    hxG = new HashMap();
    AppMethodBeat.o(101621);
  }
  
  public b()
  {
    AppMethodBeat.i(101616);
    this.running = false;
    this.hxK = 0L;
    this.hxI = false;
    this.hxE = new LinkedList();
    this.oAk = new p.a()
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
            Object localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQH();
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
                ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
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
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new b.4(this), false);
    this.Aey = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    com.tencent.mm.kernel.h.baD().a(this.oAk);
    com.tencent.mm.kernel.h.aZW().a(404, this);
    AppMethodBeat.o(101616);
  }
  
  public final void aHh()
  {
    AppMethodBeat.i(101619);
    this.hxE.clear();
    hxG.clear();
    this.running = false;
    this.hxI = false;
    AppMethodBeat.o(101619);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(101617);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101609);
        if (paramp.getType() != 404)
        {
          AppMethodBeat.o(101609);
          return;
        }
        if (!(paramp instanceof al))
        {
          AppMethodBeat.o(101609);
          return;
        }
        b.a(b.this);
        long l = ((al)paramp).AdF.field_localId;
        g localg = ((al)paramp).AdF;
        b.aCw().remove(Long.valueOf(l));
        if (paramInt1 != 0)
        {
          Log.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.mD(localg.field_localId)) });
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(3, l);
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.b
 * JD-Core Version:    0.7.0.1
 */