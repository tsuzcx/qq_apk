package com.tencent.mm.plugin.finder.live.model.mic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer;", "", "()V", "RANDOM_MATCH_DEFAULT_TIMEOUT", "", "TAG", "", "acceptBattleTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1;", "acceptMicTimeoutTaskMap", "Ljava/util/HashMap;", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "acceptPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1;", "applyBattleTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1;", "applyMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1;", "applyPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1;", "randomMatchTimeoutTask", "timerImplInstance", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "release", "", "setupTimer", "timer", "startAcceptBattleTimer", "delay", "", "startAcceptMicTimer", "micId", "startAcceptPkMicTimer", "startApplyBattleTimer", "startApplyMicPkTimer", "startApplyMicTimer", "startRandomMatchTimer", "stopAcceptMicTimer", "stopAcceptPkMicTimer", "stopApplyBattleTimer", "stopApplyMicPkTimer", "stopApplyMicTimer", "stopRandomMatchTimer", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b CMY;
  private static final d CMZ;
  private static final HashMap<String, Runnable> CNa;
  private static final b.e CNb;
  private static final b CNc;
  private static final c CNd;
  private static final a CNe;
  private static final Runnable CNf;
  private static WeakReference<a> CNg;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359799);
    CMY = new b();
    TAG = "Finder.LinkMicTimeoutTimer";
    CMZ = new d();
    CNa = new HashMap();
    CNb = new b.e();
    CNc = new b();
    CNd = new c();
    CNe = new a();
    CNf = b..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(359799);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(359696);
    s.u(parama, "timer");
    CNg = new WeakReference(parama);
    AppMethodBeat.o(359696);
  }
  
  public static void awH(String paramString)
  {
    AppMethodBeat.i(359720);
    Log.i(TAG, "startAcceptMicTimer micId:" + paramString + " delay:10000");
    if (paramString != null)
    {
      f localf = new f();
      localf.mXx = paramString;
      ((Map)CNa).put(paramString, localf);
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf, 10000L);
    }
    AppMethodBeat.o(359720);
  }
  
  public static void awI(String paramString)
  {
    AppMethodBeat.i(359751);
    Log.i(TAG, s.X("stopAcceptMicTimer micId:", paramString));
    if (paramString != null) {
      MMHandlerThread.removeRunnable((Runnable)CNa.get(paramString));
    }
    AppMethodBeat.o(359751);
  }
  
  public static void ena()
  {
    AppMethodBeat.i(359705);
    Log.i(TAG, s.X("startApplyMicTimer delay:", Long.valueOf(60000L)));
    MMHandlerThread.postToMainThreadDelayed((Runnable)CMZ, 60000L);
    AppMethodBeat.o(359705);
  }
  
  public static void enb()
  {
    AppMethodBeat.i(359711);
    Log.i(TAG, s.X("startApplyMicPkTimer delay:", Long.valueOf(60000L)));
    MMHandlerThread.postToMainThreadDelayed((Runnable)CNb, 60000L);
    AppMethodBeat.o(359711);
  }
  
  public static void enc()
  {
    AppMethodBeat.i(359717);
    Log.i(TAG, s.X("startApplyBattleTimer delay:", Long.valueOf(60000L)));
    MMHandlerThread.postToMainThreadDelayed((Runnable)CNd, 60000L);
    AppMethodBeat.o(359717);
  }
  
  public static void ene()
  {
    AppMethodBeat.i(359725);
    Log.i(TAG, s.X("startAcceptPkMicTimer delay:", Long.valueOf(15000L)));
    MMHandlerThread.postToMainThreadDelayed((Runnable)CNc, 15000L);
    AppMethodBeat.o(359725);
  }
  
  public static void enf()
  {
    AppMethodBeat.i(359736);
    Log.i(TAG, "stopApplyMicTimer");
    MMHandlerThread.removeRunnable((Runnable)CMZ);
    AppMethodBeat.o(359736);
  }
  
  public static void eng()
  {
    AppMethodBeat.i(359743);
    Log.i(TAG, "stopApplyMicPkTimer");
    MMHandlerThread.removeRunnable((Runnable)CNb);
    AppMethodBeat.o(359743);
  }
  
  public static void enh()
  {
    AppMethodBeat.i(359758);
    Log.i(TAG, "stopAcceptPkMicTimer");
    MMHandlerThread.removeRunnable((Runnable)CNc);
    AppMethodBeat.o(359758);
  }
  
  public static void eni()
  {
    AppMethodBeat.i(359763);
    Log.i(TAG, "stopApplyBattleTimer");
    MMHandlerThread.removeRunnable((Runnable)CNd);
    AppMethodBeat.o(359763);
  }
  
  public static void enj()
  {
    AppMethodBeat.i(359770);
    Log.i(TAG, "stopRandomMatchTimer");
    MMHandlerThread.removeRunnable(CNf);
    AppMethodBeat.o(359770);
  }
  
  private static final void enk()
  {
    AppMethodBeat.i(359779);
    Object localObject = CNg;
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a)localObject).onRandomMatchTimeout();
      }
    }
    AppMethodBeat.o(359779);
  }
  
  public static void om(long paramLong)
  {
    AppMethodBeat.i(359730);
    Log.i(TAG, s.X("startRandomMatchTimer delay:", Long.valueOf(paramLong)));
    MMHandlerThread.postToMainThreadDelayed(CNf, paramLong);
    AppMethodBeat.o(359730);
  }
  
  public static void release()
  {
    CNg = null;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptBattleTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(359695);
      Object localObject = b.enl();
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onAcceptBattleTimeout();
        }
      }
      AppMethodBeat.o(359695);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(359694);
      Object localObject = b.enl();
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onAcceptMicPkTimeout();
        }
      }
      AppMethodBeat.o(359694);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyBattleTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(359692);
      Object localObject = b.enl();
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onApplyBattleTimeout();
        }
      }
      AppMethodBeat.o(359692);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(359700);
      Object localObject = b.enl();
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onApplyMicTimeout();
        }
      }
      AppMethodBeat.o(359700);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$startAcceptMicTimer$1$acceptMicTimeoutTask$1", "Ljava/lang/Runnable;", "micId", "", "getMicId", "()Ljava/lang/String;", "setMicId", "(Ljava/lang/String;)V", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Runnable
  {
    String mXx;
    
    public final void run()
    {
      AppMethodBeat.i(359690);
      Object localObject = b.enl();
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onAcceptMicTimeout(this.mXx);
        }
      }
      AppMethodBeat.o(359690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.mic.b
 * JD-Core Version:    0.7.0.1
 */