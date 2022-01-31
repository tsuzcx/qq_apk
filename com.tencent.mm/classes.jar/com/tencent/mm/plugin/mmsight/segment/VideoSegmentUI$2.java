package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.c;

final class VideoSegmentUI$2
  implements c.b
{
  VideoSegmentUI$2(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    if (VideoSegmentUI.d(this.mnw) == null) {
      return;
    }
    int i = VideoSegmentUI.e(this.mnw);
    VideoSegmentUI.d(this.mnw).setLoop((int)(i * paramFloat1), (int)(i * paramFloat2));
    VideoSegmentUI.d(this.mnw).seekTo((int)(i * paramFloat1));
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    if (VideoSegmentUI.d(this.mnw) == null) {
      return;
    }
    int i = (int)(VideoSegmentUI.e(this.mnw) * paramFloat1);
    int j = (int)(VideoSegmentUI.e(this.mnw) * paramFloat2);
    VideoSegmentUI.d(this.mnw).setLoop(i, j);
    VideoSegmentUI.d(this.mnw).seekTo(i);
  }
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat2 - paramFloat1) * VideoSegmentUI.e(this.mnw) <= VideoSegmentUI.p(this.mnw))
    {
      this.mnw.enableOptionMenu(true);
      return;
    }
    this.mnw.enableOptionMenu(false);
  }
  
  public final void bjM()
  {
    if (VideoSegmentUI.d(this.mnw) == null) {
      return;
    }
    VideoSegmentUI.d(this.mnw).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.2
 * JD-Core Version:    0.7.0.1
 */