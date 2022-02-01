package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"})
public final class a
{
  AtomicReference<a> INh;
  final String TAG;
  private final String name;
  final ap skw;
  
  public a(String paramString)
  {
    AppMethodBeat.i(221478);
    this.name = paramString;
    this.TAG = ("Finder.ExpiredTimer#" + this.name);
    paramString = new ap(this.name);
    paramString.setLogging(false);
    this.skw = paramString;
    this.INh = new AtomicReference();
    AppMethodBeat.o(221478);
  }
  
  public final void a(a parama, long paramLong, String paramString)
  {
    AppMethodBeat.i(221476);
    p.h(parama, "runnable");
    p.h(paramString, "tag");
    paramLong = Math.max(0L, paramLong);
    this.skw.removeCallbacksAndMessages(null);
    parama.gW = paramLong;
    parama.time = System.currentTimeMillis();
    this.skw.postDelayed((Runnable)parama, paramLong);
    ad.i(this.TAG, "[postDelayed] delay=" + parama.gW + "ms hash=" + parama.hashCode() + " tag=" + paramString);
    AppMethodBeat.o(221476);
  }
  
  public final a axH(String paramString)
  {
    AppMethodBeat.i(221477);
    p.h(paramString, "tag");
    this.INh.set(null);
    this.skw.removeCallbacksAndMessages(null);
    ad.i(this.TAG, "[stop] tag=" + paramString + ", null");
    AppMethodBeat.o(221477);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"})
  public static abstract class a
    implements Runnable
  {
    long gW;
    long time = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.a
 * JD-Core Version:    0.7.0.1
 */