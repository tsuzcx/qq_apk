package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;

final class MPCommonVideoView$1
  implements Runnable
{
  MPCommonVideoView$1(MPCommonVideoView paramMPCommonVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(138056);
    if (MPCommonVideoView.a(this.kjs) != null) {
      MPCommonVideoView.b(this.kjs).setOneTimeVideoTextureUpdateCallback(this.kjs);
    }
    AppMethodBeat.o(138056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCommonVideoView.1
 * JD-Core Version:    0.7.0.1
 */