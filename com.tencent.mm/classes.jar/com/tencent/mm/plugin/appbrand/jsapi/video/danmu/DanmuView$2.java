package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class DanmuView$2
  implements Runnable
{
  DanmuView$2(DanmuView paramDanmuView) {}
  
  public final void run()
  {
    AppMethodBeat.i(126600);
    DanmuView.a(this.ieM, false);
    this.ieM.invalidate();
    AppMethodBeat.o(126600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.2
 * JD-Core Version:    0.7.0.1
 */