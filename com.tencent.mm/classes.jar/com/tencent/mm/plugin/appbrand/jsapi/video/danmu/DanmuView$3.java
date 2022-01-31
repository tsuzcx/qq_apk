package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.List;

public final class DanmuView$3
  implements Runnable
{
  public DanmuView$3(DanmuView paramDanmuView, d paramd) {}
  
  public final void run()
  {
    List localList = DanmuView.a(this.gFJ);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < DanmuView.a(this.gFJ).size())
        {
          if (this.gFK.akZ() <= ((d)DanmuView.a(this.gFJ).get(i)).akZ()) {
            DanmuView.a(this.gFJ).add(i, this.gFK);
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3
 * JD-Core Version:    0.7.0.1
 */