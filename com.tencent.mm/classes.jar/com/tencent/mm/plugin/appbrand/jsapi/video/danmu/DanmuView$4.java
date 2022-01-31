package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.Deque;
import java.util.List;

public final class DanmuView$4
  extends Thread
{
  public DanmuView$4(DanmuView paramDanmuView, List paramList) {}
  
  public final void run()
  {
    synchronized (DanmuView.b(this.gFJ))
    {
      DanmuView.b(this.gFJ).addAll(this.gFL);
    }
    synchronized (DanmuView.a(this.gFJ))
    {
      DanmuView.a(this.gFJ).addAll(this.gFL);
      this.gFJ.postInvalidate();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4
 * JD-Core Version:    0.7.0.1
 */