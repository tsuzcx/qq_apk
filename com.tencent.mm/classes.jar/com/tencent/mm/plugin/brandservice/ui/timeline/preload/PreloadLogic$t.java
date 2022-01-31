package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.l;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import java.util.concurrent.atomic.AtomicBoolean;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
public final class PreloadLogic$t
  implements MessageQueue.IdleHandler
{
  PreloadLogic$t(int paramInt) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(14910);
    Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
    d.aNX();
    PreloadLogic localPreloadLogic = PreloadLogic.kbJ;
    PreloadLogic.so(this.jSy);
    localPreloadLogic = PreloadLogic.kbJ;
    PreloadLogic.aXG().set(false);
    AppMethodBeat.o(14910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.t
 * JD-Core Version:    0.7.0.1
 */