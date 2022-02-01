package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends g
{
  private final String TAG;
  
  public b(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb, int paramInt)
  {
    super(paramString, paramb);
    AppMethodBeat.i(195131);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.xMZ = (paramInt * 20);
    if (this.xMZ > 30) {
      this.xMZ = 30;
    }
    this.xNa /= paramInt;
    this.xNc = (1000.0F / this.xMZ);
    if (this.xNc < this.xNa) {
      this.xNc = this.xNa;
    }
    this.xMX = ((int)(this.videoDuration / paramInt / this.xNc));
    this.xMY = 0;
    ad.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.xMS + ", duration:" + this.videoDuration + ", frameCount:" + this.videoFrameCount + ", frameDuration:" + this.xNa + ", targetFrameRate:" + this.xMZ + ", targetFrameCount:" + this.xMX + ", targetFrameDuration:" + this.xNc);
    AppMethodBeat.o(195131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */