package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
public final class n$b
  extends TimerTask
{
  public n$b(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(144773);
    TimerTask localTimerTask = (TimerTask)this;
    this.ipQ.invoke(Boolean.FALSE);
    localTimerTask.cancel();
    AppMethodBeat.o(144773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n.b
 * JD-Core Version:    0.7.0.1
 */