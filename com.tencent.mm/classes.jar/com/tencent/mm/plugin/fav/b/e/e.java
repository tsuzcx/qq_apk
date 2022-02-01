package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e
  implements com.tencent.mm.al.g, ac
{
  private static Map<Long, f.a> cZC;
  private static Map<Long, Integer> qbS;
  private static Set<Long> qbU;
  private Queue<com.tencent.mm.plugin.fav.a.g> cZA;
  private boolean cZE;
  public int cZF;
  private long cZG;
  public av cZK;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101661);
    cZC = new HashMap();
    qbS = new HashMap();
    qbU = new HashSet();
    AppMethodBeat.o(101661);
  }
  
  public e()
  {
    AppMethodBeat.i(101654);
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZE = false;
    this.cZA = new LinkedList();
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new e.3(this), false);
    com.tencent.mm.kernel.g.aeS().a(401, this);
    AppMethodBeat.o(101654);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(101658);
    ak localak = new ak();
    com.tencent.mm.kernel.g.aeS().a(localak, 0);
    AppMethodBeat.o(101658);
  }
  
  public final void Oy()
  {
    AppMethodBeat.i(101657);
    ad.i("MicroMsg.Fav.FavSendService", "on finish");
    this.cZA.clear();
    cZC.clear();
    this.running = false;
    this.cZE = false;
    qbS.clear();
    AppMethodBeat.o(101657);
  }
  
  public final boolean aDC()
  {
    return this.cZE;
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(101655);
    ad.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
        com.tencent.mm.plugin.fav.a.g localg = ((ag)paramn).qaL;
        long l = localg.field_localId;
        e.Xu().remove(Long.valueOf(l));
        if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -400)) {
          e.aXZ().add(Long.valueOf(l));
        }
        if ((paramInt1 != 0) && (paramInt2 != -400)) {
          e.b(e.this);
        }
        Integer localInteger2 = Integer.valueOf(bt.a((Integer)e.qbS.get(Long.valueOf(l)), 0));
        Integer localInteger1 = localInteger2;
        if (paramInt1 != 1)
        {
          localInteger1 = localInteger2;
          if (paramInt1 != 0)
          {
            localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
            e.qbS.put(Long.valueOf(localg.field_localId), localInteger1);
          }
        }
        if (localInteger1.intValue() <= 0)
        {
          int i = com.tencent.mm.plugin.fav.a.h.ft(paramInt1, paramInt2);
          com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.pL(localg.field_localId)) });
          e.qbS.remove(Long.valueOf(l));
          ad.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          if (localg.field_itemStatus == 12) {
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(14, localg.field_localId);
          }
          if (localg.field_itemStatus == 9) {
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(11, localg.field_localId);
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
          ad.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
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
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
          ad.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(e.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + e.g(e.this));
        }
        e.a(e.this);
        e.h(e.this);
        e.i(e.this);
        e.j(e.this).av(10L, 10L);
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