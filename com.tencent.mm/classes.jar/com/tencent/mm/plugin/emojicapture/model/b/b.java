package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.g.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends f
{
  private final String TAG;
  
  public b(String paramString, d paramd, int paramInt)
  {
    super(paramString, paramd);
    AppMethodBeat.i(263);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.gSG = (paramInt * 20);
    if (this.gSG > 30) {
      this.gSG = 30;
    }
    this.gSH /= paramInt;
    this.gSJ = (1000.0F / this.gSG);
    if (this.gSJ < this.gSH) {
      this.gSJ = this.gSH;
    }
    this.gSE = ((int)(this.videoDuration / paramInt / this.gSJ));
    this.gSF = 0;
    ac.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.gSz + ", duration:" + this.videoDuration + ", frameCount:" + this.gSy + ", frameDuration:" + this.gSH + ", targetFrameRate:" + this.gSG + ", targetFrameCount:" + this.gSE + ", targetFrameDuration:" + this.gSJ);
    AppMethodBeat.o(263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */