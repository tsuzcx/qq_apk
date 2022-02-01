package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final MMHandler EDn;
  private AtomicReference<a> EVO;
  private final String TAG;
  private final String name;
  
  public a(String paramString)
  {
    AppMethodBeat.i(346158);
    this.name = paramString;
    this.TAG = s.X("Finder.ExpiredTimer#", this.name);
    paramString = new MMHandler(this.name);
    paramString.setLogging(false);
    ah localah = ah.aiuX;
    this.EDn = paramString;
    this.EVO = new AtomicReference();
    AppMethodBeat.o(346158);
  }
  
  public final void a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(346165);
    s.u(parama, "runnable");
    s.u(paramString, "tag");
    paramLong = Math.max(0L, paramLong);
    this.EDn.removeCallbacksAndMessages(null);
    parama.delay = paramLong;
    parama.time = cn.bDw();
    this.EDn.postDelayed((Runnable)parama, paramLong);
    Log.i(this.TAG, "[postDelayed] delay=" + parama.delay + "ms hash=" + parama.hashCode() + " tag=" + paramString);
    AppMethodBeat.o(346165);
  }
  
  public final a azn(String paramString)
  {
    AppMethodBeat.i(346171);
    s.u(paramString, "tag");
    this.EVO.set(null);
    this.EDn.removeCallbacksAndMessages(null);
    Log.i(this.TAG, "[stop] tag=" + paramString + ", null");
    AppMethodBeat.o(346171);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
    implements Runnable
  {
    long delay;
    long time = cn.bDw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.a
 * JD-Core Version:    0.7.0.1
 */