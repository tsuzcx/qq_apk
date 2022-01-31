package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.List;

public final class DanmuView$4
  extends Thread
{
  public DanmuView$4(DanmuView paramDanmuView, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(126602);
    synchronized (DanmuView.b(this.ieM))
    {
      DanmuView.b(this.ieM).addAll(this.ieO);
    }
    synchronized (DanmuView.a(this.ieM))
    {
      DanmuView.a(this.ieM).addAll(this.ieO);
      this.ieM.postInvalidate();
      AppMethodBeat.o(126602);
      return;
      localObject2 = finally;
      AppMethodBeat.o(126602);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4
 * JD-Core Version:    0.7.0.1
 */