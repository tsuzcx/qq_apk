package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"})
public final class a
{
  final String TAG;
  private final String name;
  final MMHandler uOI;
  AtomicReference<a> uUM;
  
  public a(String paramString)
  {
    AppMethodBeat.i(249553);
    this.name = paramString;
    this.TAG = ("Finder.ExpiredTimer#" + this.name);
    paramString = new MMHandler(this.name);
    paramString.setLogging(false);
    this.uOI = paramString;
    this.uUM = new AtomicReference();
    AppMethodBeat.o(249553);
  }
  
  public final void a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(249551);
    p.h(parama, "runnable");
    p.h(paramString, "tag");
    paramLong = Math.max(0L, paramLong);
    this.uOI.removeCallbacksAndMessages(null);
    parama.gY = paramLong;
    parama.time = System.currentTimeMillis();
    this.uOI.postDelayed((Runnable)parama, paramLong);
    Log.i(this.TAG, "[postDelayed] delay=" + parama.gY + "ms hash=" + parama.hashCode() + " tag=" + paramString);
    AppMethodBeat.o(249551);
  }
  
  public final a aut(String paramString)
  {
    AppMethodBeat.i(249552);
    p.h(paramString, "tag");
    this.uUM.set(null);
    this.uOI.removeCallbacksAndMessages(null);
    Log.i(this.TAG, "[stop] tag=" + paramString + ", null");
    AppMethodBeat.o(249552);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"})
  public static abstract class a
    implements Runnable
  {
    long gY;
    long time = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.a
 * JD-Core Version:    0.7.0.1
 */