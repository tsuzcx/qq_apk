package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import android.media.ThumbnailUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPVideoView$o
  implements Runnable
{
  MPVideoView$o(MPVideoView paramMPVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(153042);
    al.d((Runnable)new MPVideoView.o.1(this, ThumbnailUtils.createVideoThumbnail(this.kjS, 1)));
    AppMethodBeat.o(153042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.o
 * JD-Core Version:    0.7.0.1
 */