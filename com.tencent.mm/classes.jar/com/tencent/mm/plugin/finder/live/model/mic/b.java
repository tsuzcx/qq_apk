package com.tencent.mm.plugin.finder.live.model.mic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer;", "", "()V", "TAG", "", "acceptBattleTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1;", "acceptMicTimeoutTaskMap", "Ljava/util/HashMap;", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "acceptPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1;", "applyBattleTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1;", "applyMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1;", "applyPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1;", "timerImplInstance", "Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "release", "", "setupTimer", "timer", "startAcceptBattleTimer", "delay", "", "startAcceptMicTimer", "micId", "startAcceptPkMicTimer", "startApplyBattleTimer", "startApplyMicPkTimer", "startApplyMicTimer", "stopAcceptMicTimer", "stopAcceptPkMicTimer", "stopApplyBattleTimer", "stopApplyMicPkTimer", "stopApplyMicTimer", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.LinkMicTimeoutTimer";
  private static final a ykA;
  private static a ykB;
  public static final b ykC;
  private static final d ykv;
  private static final HashMap<String, Runnable> ykw;
  private static final e ykx;
  private static final b yky;
  private static final c ykz;
  
  static
  {
    AppMethodBeat.i(254142);
    ykC = new b();
    TAG = "Finder.LinkMicTimeoutTimer";
    ykv = new d();
    ykw = new HashMap();
    ykx = new e();
    yky = new b();
    ykz = new c();
    ykA = new a();
    AppMethodBeat.o(254142);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(254129);
    p.k(parama, "timer");
    ykB = parama;
    AppMethodBeat.o(254129);
  }
  
  public static void aCj(String paramString)
  {
    AppMethodBeat.i(254134);
    Log.i(TAG, "startAcceptMicTimer micId:" + paramString + " delay:10000");
    if (paramString != null)
    {
      f localf = new f();
      localf.ktE = paramString;
      ((Map)ykw).put(paramString, localf);
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf, 10000L);
      AppMethodBeat.o(254134);
      return;
    }
    AppMethodBeat.o(254134);
  }
  
  public static void aCk(String paramString)
  {
    AppMethodBeat.i(254139);
    Log.i(TAG, "stopAcceptMicTimer micId:".concat(String.valueOf(paramString)));
    if (paramString != null) {
      MMHandlerThread.removeRunnable((Runnable)ykw.get(paramString));
    }
    AppMethodBeat.o(254139);
  }
  
  public static void dAd()
  {
    AppMethodBeat.i(254131);
    Log.i(TAG, "startApplyMicTimer delay:60000");
    MMHandlerThread.postToMainThreadDelayed((Runnable)ykv, 60000L);
    AppMethodBeat.o(254131);
  }
  
  public static void dAe()
  {
    AppMethodBeat.i(254132);
    Log.i(TAG, "startApplyMicPkTimer delay:60000");
    MMHandlerThread.postToMainThreadDelayed((Runnable)ykx, 60000L);
    AppMethodBeat.o(254132);
  }
  
  public static void dAf()
  {
    AppMethodBeat.i(254133);
    Log.i(TAG, "startApplyBattleTimer delay:60000");
    MMHandlerThread.postToMainThreadDelayed((Runnable)ykz, 60000L);
    AppMethodBeat.o(254133);
  }
  
  public static void dAg()
  {
    AppMethodBeat.i(254135);
    Log.i(TAG, "startAcceptPkMicTimer delay:15000");
    MMHandlerThread.postToMainThreadDelayed((Runnable)yky, 15000L);
    AppMethodBeat.o(254135);
  }
  
  public static void dAh()
  {
    AppMethodBeat.i(254136);
    Log.i(TAG, "stopApplyMicTimer");
    MMHandlerThread.removeRunnable((Runnable)ykv);
    AppMethodBeat.o(254136);
  }
  
  public static void dAi()
  {
    AppMethodBeat.i(254138);
    Log.i(TAG, "stopApplyMicPkTimer");
    MMHandlerThread.removeRunnable((Runnable)ykx);
    AppMethodBeat.o(254138);
  }
  
  public static void dAj()
  {
    AppMethodBeat.i(254140);
    Log.i(TAG, "stopAcceptPkMicTimer");
    MMHandlerThread.removeRunnable((Runnable)yky);
    AppMethodBeat.o(254140);
  }
  
  public static void dAk()
  {
    AppMethodBeat.i(254141);
    Log.i(TAG, "stopApplyBattleTimer");
    MMHandlerThread.removeRunnable((Runnable)ykz);
    AppMethodBeat.o(254141);
  }
  
  public static void release()
  {
    ykB = null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class a
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(289276);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onAcceptBattleTimeout();
        AppMethodBeat.o(289276);
        return;
      }
      AppMethodBeat.o(289276);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(286698);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onAcceptMicPkTimeout();
        AppMethodBeat.o(286698);
        return;
      }
      AppMethodBeat.o(286698);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class c
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(271310);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onApplyBattleTimeout();
        AppMethodBeat.o(271310);
        return;
      }
      AppMethodBeat.o(271310);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class d
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(285492);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onApplyMicTimeout();
        AppMethodBeat.o(285492);
        return;
      }
      AppMethodBeat.o(285492);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class e
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(267565);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onApplyMicPkTimeout();
        AppMethodBeat.o(267565);
        return;
      }
      AppMethodBeat.o(267565);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$startAcceptMicTimer$1$acceptMicTimeoutTask$1", "Ljava/lang/Runnable;", "micId", "", "getMicId", "()Ljava/lang/String;", "setMicId", "(Ljava/lang/String;)V", "run", "", "plugin-finder_release"})
  public static final class f
    implements Runnable
  {
    String ktE;
    
    public final void run()
    {
      AppMethodBeat.i(287748);
      Object localObject = b.ykC;
      localObject = b.dAl();
      if (localObject != null)
      {
        ((a)localObject).onAcceptMicTimeout(this.ktE);
        AppMethodBeat.o(287748);
        return;
      }
      AppMethodBeat.o(287748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.mic.b
 * JD-Core Version:    0.7.0.1
 */