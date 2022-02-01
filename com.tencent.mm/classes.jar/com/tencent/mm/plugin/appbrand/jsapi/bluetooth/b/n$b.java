package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class n$b
  extends TimerTask
{
  public n$b(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(329641);
    TimerTask localTimerTask = (TimerTask)this;
    this.rLO.invoke(Boolean.FALSE);
    localTimerTask.cancel();
    AppMethodBeat.o(329641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n.b
 * JD-Core Version:    0.7.0.1
 */