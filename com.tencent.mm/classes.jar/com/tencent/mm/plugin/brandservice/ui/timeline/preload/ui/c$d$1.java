package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$tryPreloadTmplWebview$1$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
public final class c$d$1
  implements MessageQueue.IdleHandler
{
  public final boolean queueIdle()
  {
    AppMethodBeat.i(15034);
    Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
    if (this.kee.ked == -1)
    {
      Object localObject = b.kcE;
      localObject = b.aXP();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)localObject[i]).intValue();
        c.a(c.kdW, k);
        i += 1;
      }
    }
    c.a(c.kdW, this.kee.ked);
    AppMethodBeat.o(15034);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.d.1
 * JD-Core Version:    0.7.0.1
 */