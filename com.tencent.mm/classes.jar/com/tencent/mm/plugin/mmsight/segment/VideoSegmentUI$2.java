package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.c;

final class VideoSegmentUI$2
  implements c.b
{
  VideoSegmentUI$2(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55028);
    if (VideoSegmentUI.d(this.oME) == null)
    {
      AppMethodBeat.o(55028);
      return;
    }
    int i = VideoSegmentUI.e(this.oME);
    VideoSegmentUI.d(this.oME).setLoop((int)(i * paramFloat1), (int)(i * paramFloat2));
    VideoSegmentUI.d(this.oME).seekTo((int)(i * paramFloat1));
    AppMethodBeat.o(55028);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140577);
    if (VideoSegmentUI.d(this.oME) == null)
    {
      AppMethodBeat.o(140577);
      return;
    }
    VideoSegmentUI.d(this.oME).pause();
    AppMethodBeat.o(140577);
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55030);
    if (VideoSegmentUI.d(this.oME) == null)
    {
      AppMethodBeat.o(55030);
      return;
    }
    int i = (int)(VideoSegmentUI.e(this.oME) * paramFloat1);
    int j = (int)(VideoSegmentUI.e(this.oME) * paramFloat2);
    VideoSegmentUI.d(this.oME).setLoop(i, j);
    VideoSegmentUI.d(this.oME).seekTo(i);
    AppMethodBeat.o(55030);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55031);
    if ((paramFloat2 - paramFloat1) * VideoSegmentUI.e(this.oME) <= VideoSegmentUI.p(this.oME))
    {
      this.oME.enableOptionMenu(true);
      AppMethodBeat.o(55031);
      return;
    }
    this.oME.enableOptionMenu(false);
    AppMethodBeat.o(55031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.2
 * JD-Core Version:    0.7.0.1
 */