package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e
  implements f, ac
{
  private static Map<Long, f.a> djr;
  private static Map<Long, Integer> rCM;
  private static Set<Long> rCO;
  private Queue<com.tencent.mm.plugin.fav.a.g> djp;
  private boolean djt;
  public int dju;
  private long djv;
  public aw djz;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101661);
    djr = new HashMap();
    rCM = new HashMap();
    rCO = new HashSet();
    AppMethodBeat.o(101661);
  }
  
  public e()
  {
    AppMethodBeat.i(101654);
    this.running = false;
    this.dju = 0;
    this.djv = 0L;
    this.djt = false;
    this.djp = new LinkedList();
    this.djz = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
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
            ae.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
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
    com.tencent.mm.kernel.g.ajj().a(401, this);
    AppMethodBeat.o(101654);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(101658);
    ak localak = new ak();
    com.tencent.mm.kernel.g.ajj().a(localak, 0);
    AppMethodBeat.o(101658);
  }
  
  public final void Qd()
  {
    AppMethodBeat.i(101657);
    ae.i("MicroMsg.Fav.FavSendService", "on finish");
    this.djp.clear();
    djr.clear();
    this.running = false;
    this.djt = false;
    rCM.clear();
    AppMethodBeat.o(101657);
  }
  
  public final boolean aOa()
  {
    return this.djt;
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(101655);
    ae.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101648);
        if (paramn.getType() != 401)
        {
          AppMethodBeat.o(101648);
          return;
        }
        if (!(paramn instanceof ag))
        {
          AppMethodBeat.o(101648);
          return;
        }
        e.a(e.this);
        com.tencent.mm.plugin.fav.a.g localg = ((ag)paramn).rBF;
        long l = localg.field_localId;
        e.abc().remove(Long.valueOf(l));
        if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -400)) {
          e.bdG().add(Long.valueOf(l));
        }
        if ((paramInt1 != 0) && (paramInt2 != -400)) {
          e.b(e.this);
        }
        Integer localInteger2 = Integer.valueOf(bu.a((Integer)e.rCM.get(Long.valueOf(l)), 0));
        Integer localInteger1 = localInteger2;
        if (paramInt1 != 1)
        {
          localInteger1 = localInteger2;
          if (paramInt1 != 0)
          {
            localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
            e.rCM.put(Long.valueOf(localg.field_localId), localInteger1);
          }
        }
        if (localInteger1.intValue() <= 0)
        {
          int i = h.fC(paramInt1, paramInt2);
          com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(h.vN(localg.field_localId)) });
          e.rCM.remove(Long.valueOf(l));
          ae.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          if (localg.field_itemStatus == 12) {
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(14, localg.field_localId);
          }
          if (localg.field_itemStatus == 9) {
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(11, localg.field_localId);
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
          ae.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
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
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
          ae.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(e.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + e.g(e.this));
        }
        e.a(e.this);
        e.h(e.this);
        e.i(e.this);
        e.j(e.this).ay(10L, 10L);
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