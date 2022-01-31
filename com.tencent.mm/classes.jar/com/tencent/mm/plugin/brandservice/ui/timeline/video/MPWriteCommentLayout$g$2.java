package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPWriteCommentLayout$g$2
  implements Runnable
{
  MPWriteCommentLayout$g$2(MPWriteCommentLayout.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(152917);
    MPWriteCommentLayout.b(this.khO.khv).bab();
    MPWriteCommentLayout.b(this.khO.khv).postInvalidate();
    MPWriteCommentLayout.c(this.khO.khv).postInvalidate();
    AppMethodBeat.o(152917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.g.2
 * JD-Core Version:    0.7.0.1
 */