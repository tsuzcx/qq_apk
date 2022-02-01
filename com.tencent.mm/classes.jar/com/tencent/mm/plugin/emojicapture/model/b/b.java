package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends g
{
  private final String TAG;
  
  public b(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb, int paramInt)
  {
    super(paramString, paramb);
    AppMethodBeat.i(221763);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.ycT = (paramInt * 20);
    if (this.ycT > 30) {
      this.ycT = 30;
    }
    this.ycU /= paramInt;
    this.ycW = (1000.0F / this.ycT);
    if (this.ycW < this.ycU) {
      this.ycW = this.ycU;
    }
    this.ycR = ((int)(this.videoDuration / paramInt / this.ycW));
    this.ycS = 0;
    ae.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.ycM + ", duration:" + this.videoDuration + ", frameCount:" + this.videoFrameCount + ", frameDuration:" + this.ycU + ", targetFrameRate:" + this.ycT + ", targetFrameCount:" + this.ycR + ", targetFrameDuration:" + this.ycW);
    AppMethodBeat.o(221763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */