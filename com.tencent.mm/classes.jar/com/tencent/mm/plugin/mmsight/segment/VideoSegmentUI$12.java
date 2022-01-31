package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class VideoSegmentUI$12
  implements c.a
{
  VideoSegmentUI$12(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(55043);
    if (paramBoolean)
    {
      Toast.makeText(this.oME, 2131301571, 1).show();
      ab.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
      VideoSegmentUI.m(this.oME);
      this.oME.finish();
      VideoSegmentUI.b(this.oME);
      AppMethodBeat.o(55043);
      return;
    }
    if ((!this.oME.isFinishing()) && (VideoSegmentUI.j(this.oME) != null))
    {
      VideoSegmentUI.a(this.oME, VideoSegmentUI.j(this.oME).getDurationMs());
      ab.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[] { Integer.valueOf(VideoSegmentUI.e(this.oME)) });
    }
    try
    {
      if (VideoSegmentUI.d(this.oME) != null) {
        VideoSegmentUI.d(this.oME).setLoop((int)(VideoSegmentUI.e(this.oME) * VideoSegmentUI.j(this.oME).bRy()), (int)(VideoSegmentUI.e(this.oME) * VideoSegmentUI.j(this.oME).bRz()));
      }
      label185:
      VideoSegmentUI.o(this.oME).countDown();
      AppMethodBeat.o(55043);
      return;
    }
    catch (Exception localException)
    {
      break label185;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.12
 * JD-Core Version:    0.7.0.1
 */