package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class e
  implements i, ad
{
  private static Map<Long, f.a> ftr;
  private static Map<Long, Integer> wIw;
  private static Set<Long> wIy;
  private Queue<g> ftp;
  private boolean ftt;
  public int ftu;
  private long ftv;
  public MTimerHandler fty;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101661);
    ftr = new HashMap();
    wIw = new HashMap();
    wIy = new HashSet();
    AppMethodBeat.o(101661);
  }
  
  public e()
  {
    AppMethodBeat.i(101654);
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftt = false;
    this.ftp = new LinkedList();
    this.fty = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(101652);
        try
        {
          e.d(e.this);
          AppMethodBeat.o(101652);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101653);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(101653);
        return str;
      }
    }, false);
    com.tencent.mm.kernel.h.aGY().a(401, this);
    AppMethodBeat.o(101654);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(101658);
    al localal = new al();
    com.tencent.mm.kernel.h.aGY().a(localal, 0);
    AppMethodBeat.o(101658);
  }
  
  public final void afk()
  {
    AppMethodBeat.i(101657);
    Log.i("MicroMsg.Fav.FavSendService", "on finish");
    this.ftp.clear();
    ftr.clear();
    this.running = false;
    this.ftt = false;
    wIw.clear();
    AppMethodBeat.o(101657);
  }
  
  public final boolean brE()
  {
    return this.ftt;
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(101655);
    Log.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101648);
        if (paramq.getType() != 401)
        {
          AppMethodBeat.o(101648);
          return;
        }
        if (!(paramq instanceof ah))
        {
          AppMethodBeat.o(101648);
          return;
        }
        e.a(e.this);
        g localg = ((ah)paramq).wHp;
        long l = localg.field_localId;
        e.avo().remove(Long.valueOf(l));
        if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -400)) {
          e.bKm().add(Long.valueOf(l));
        }
        if ((paramInt1 != 0) && (paramInt2 != -400)) {
          e.b(e.this);
        }
        Integer localInteger2 = Integer.valueOf(Util.nullAs((Integer)e.wIw.get(Long.valueOf(l)), 0));
        Integer localInteger1 = localInteger2;
        if (paramInt1 != 1)
        {
          localInteger1 = localInteger2;
          if (paramInt1 != 0)
          {
            localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
            e.wIw.put(Long.valueOf(localg.field_localId), localInteger1);
          }
        }
        if (localInteger1.intValue() <= 0)
        {
          int i = com.tencent.mm.plugin.fav.a.h.gp(paramInt1, paramInt2);
          com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.Kf(localg.field_localId)) });
          e.wIw.remove(Long.valueOf(l));
          Log.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          if (localg.field_itemStatus == 12) {
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(14, localg.field_localId);
          }
          if (localg.field_itemStatus == 9) {
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(11, localg.field_localId);
          }
        }
        if (e.c(e.this) > 0)
        {
          if (!e.d(e.this))
          {
            e.startSync();
            AppMethodBeat.o(101648);
          }
        }
        else
        {
          Log.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
          e.e(e.this);
        }
        AppMethodBeat.o(101648);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101649);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(101649);
        return str;
      }
    });
    AppMethodBeat.o(101655);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101656);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101650);
        long l = System.currentTimeMillis() - e.f(e.this);
        if (e.g(e.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(101650);
            return;
          }
          Log.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(e.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + e.g(e.this));
        }
        e.a(e.this);
        e.h(e.this);
        e.i(e.this);
        e.j(e.this).startTimer(10L);
        AppMethodBeat.o(101650);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101651);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101651);
        return str;
      }
    });
    AppMethodBeat.o(101656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e
 * JD-Core Version:    0.7.0.1
 */