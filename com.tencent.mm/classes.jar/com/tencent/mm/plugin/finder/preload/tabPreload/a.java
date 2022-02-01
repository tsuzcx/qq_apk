package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"})
public final class a
{
  final String TAG;
  private final String name;
  final MMHandler zBc;
  AtomicReference<a> zLd;
  
  public a(String paramString)
  {
    AppMethodBeat.i(265885);
    this.name = paramString;
    this.TAG = ("Finder.ExpiredTimer#" + this.name);
    paramString = new MMHandler(this.name);
    paramString.setLogging(false);
    this.zBc = paramString;
    this.zLd = new AtomicReference();
    AppMethodBeat.o(265885);
  }
  
  public final void a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(265883);
    p.k(parama, "runnable");
    p.k(paramString, "tag");
    paramLong = Math.max(0L, paramLong);
    this.zBc.removeCallbacksAndMessages(null);
    parama.delay = paramLong;
    parama.time = cm.bfE();
    this.zBc.postDelayed((Runnable)parama, paramLong);
    Log.i(this.TAG, "[postDelayed] delay=" + parama.delay + "ms hash=" + parama.hashCode() + " tag=" + paramString);
    AppMethodBeat.o(265883);
  }
  
  public final a aDJ(String paramString)
  {
    AppMethodBeat.i(265884);
    p.k(paramString, "tag");
    this.zLd.set(null);
    this.zBc.removeCallbacksAndMessages(null);
    Log.i(this.TAG, "[stop] tag=" + paramString + ", null");
    AppMethodBeat.o(265884);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"})
  public static abstract class a
    implements Runnable
  {
    long delay;
    long time = cm.bfE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.a
 * JD-Core Version:    0.7.0.1
 */