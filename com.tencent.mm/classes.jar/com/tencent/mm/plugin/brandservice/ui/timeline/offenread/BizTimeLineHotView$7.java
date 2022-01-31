package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class BizTimeLineHotView$7
  implements MessageQueue.IdleHandler
{
  BizTimeLineHotView$7(BizTimeLineHotView paramBizTimeLineHotView) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(14312);
    Looper.myQueue().removeIdleHandler(BizTimeLineHotView.g(this.jZn));
    if ((this.jZn.jZe.get() == null) || (((Activity)this.jZn.jZe.get()).isFinishing()))
    {
      AppMethodBeat.o(14312);
      return false;
    }
    BizTimeLineHotView.f(this.jZn).aW(BizTimeLineHotView.a(this.jZn));
    AppMethodBeat.o(14312);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.7
 * JD-Core Version:    0.7.0.1
 */