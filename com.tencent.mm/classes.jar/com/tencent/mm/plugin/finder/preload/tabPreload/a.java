package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"})
public final class a
{
  final String TAG;
  private final String name;
  final aq stt;
  AtomicReference<a> suz;
  
  public a(String paramString)
  {
    AppMethodBeat.i(203543);
    this.name = paramString;
    this.TAG = ("Finder.ExpiredTimer#" + this.name);
    paramString = new aq(this.name);
    paramString.setLogging(false);
    this.stt = paramString;
    this.suz = new AtomicReference();
    AppMethodBeat.o(203543);
  }
  
  public final void a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(203541);
    p.h(parama, "runnable");
    p.h(paramString, "tag");
    paramLong = Math.max(0L, paramLong);
    this.stt.removeCallbacksAndMessages(null);
    parama.gW = paramLong;
    parama.time = System.currentTimeMillis();
    this.stt.postDelayed((Runnable)parama, paramLong);
    ae.i(this.TAG, "[postDelayed] delay=" + parama.gW + "ms hash=" + parama.hashCode() + " tag=" + paramString);
    AppMethodBeat.o(203541);
  }
  
  public final a aiE(String paramString)
  {
    AppMethodBeat.i(203542);
    p.h(paramString, "tag");
    this.suz.set(null);
    this.stt.removeCallbacksAndMessages(null);
    ae.i(this.TAG, "[stop] tag=" + paramString + ", null");
    AppMethodBeat.o(203542);
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"})
  public static abstract class a
    implements Runnable
  {
    long gW;
    long time = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.a
 * JD-Core Version:    0.7.0.1
 */