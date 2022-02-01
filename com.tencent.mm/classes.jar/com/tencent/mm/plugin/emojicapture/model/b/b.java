package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends g
{
  private final String TAG;
  
  public b(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb, int paramInt)
  {
    super(paramString, paramb);
    AppMethodBeat.i(256432);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.CdV = (paramInt * 20);
    if (this.CdV > 30) {
      this.CdV = 30;
    }
    this.CdW /= paramInt;
    this.CdY = (1000.0F / this.CdV);
    if (this.CdY < this.CdW) {
      this.CdY = this.CdW;
    }
    this.CdT = ((int)(this.videoDuration / paramInt / this.CdY));
    this.CdU = 0;
    Log.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.CdO + ", duration:" + this.videoDuration + ", frameCount:" + this.videoFrameCount + ", frameDuration:" + this.CdW + ", targetFrameRate:" + this.CdV + ", targetFrameCount:" + this.CdT + ", targetFrameDuration:" + this.CdY);
    AppMethodBeat.o(256432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */