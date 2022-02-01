package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class f
  implements com.tencent.mm.am.h, ae
{
  private static Map<Long, Integer> AeK;
  private static Set<Long> AeQ;
  private static Map<Long, f.a> hxG;
  private Queue<g> hxE;
  private boolean hxI;
  public int hxJ;
  private long hxK;
  public MTimerHandler hxN;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101661);
    hxG = new HashMap();
    AeK = new HashMap();
    AeQ = new HashSet();
    AppMethodBeat.o(101661);
  }
  
  public f()
  {
    AppMethodBeat.i(101654);
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxI = false;
    this.hxE = new LinkedList();
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new f.3(this), false);
    com.tencent.mm.kernel.h.aZW().a(401, this);
    AppMethodBeat.o(101654);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(101658);
    am localam = new am();
    com.tencent.mm.kernel.h.aZW().a(localam, 0);
    AppMethodBeat.o(101658);
  }
  
  public final void aHh()
  {
    AppMethodBeat.i(101657);
    Log.i("MicroMsg.Fav.FavSendService", "on finish");
    this.hxE.clear();
    hxG.clear();
    this.running = false;
    this.hxI = false;
    AeK.clear();
    AppMethodBeat.o(101657);
  }
  
  public final boolean bPk()
  {
    return this.hxI;
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(101655);
    Log.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101648);
        if (paramp.getType() != 401)
        {
          AppMethodBeat.o(101648);
          return;
        }
        if (!(paramp instanceof ai))
        {
          AppMethodBeat.o(101648);
          return;
        }
        f.a(f.this);
        g localg = ((ai)paramp).Ady;
        long l = localg.field_localId;
        f.aCw().remove(Long.valueOf(l));
        if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -400)) {
          f.cjM().add(Long.valueOf(l));
        }
        if ((paramInt1 != 0) && (paramInt2 != -400)) {
          f.b(f.this);
        }
        Integer localInteger2 = Integer.valueOf(Util.nullAs((Integer)f.AeK.get(Long.valueOf(l)), 0));
        Integer localInteger1 = localInteger2;
        if (paramInt1 != 1)
        {
          localInteger1 = localInteger2;
          if (paramInt1 != 0)
          {
            localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
            f.AeK.put(Long.valueOf(localg.field_localId), localInteger1);
          }
        }
        if (localInteger1.intValue() <= 0)
        {
          int i = com.tencent.mm.plugin.fav.a.h.hi(paramInt1, paramInt2);
          com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.mD(localg.field_localId)) });
          f.AeK.remove(Long.valueOf(l));
          Log.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
          if (localg.field_itemStatus == 12) {
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(14, localg.field_localId);
          }
          if (localg.field_itemStatus == 9) {
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(11, localg.field_localId);
          }
        }
        if (f.c(f.this) > 0)
        {
          if (!f.d(f.this))
          {
            f.startSync();
            AppMethodBeat.o(101648);
          }
        }
        else
        {
          Log.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
          f.e(f.this);
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101650);
        long l = System.currentTimeMillis() - f.f(f.this);
        if (f.g(f.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(101650);
            return;
          }
          Log.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + f.g(f.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + f.g(f.this));
        }
        f.a(f.this);
        f.h(f.this);
        f.i(f.this);
        f.j(f.this).startTimer(10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.f
 * JD-Core Version:    0.7.0.1
 */