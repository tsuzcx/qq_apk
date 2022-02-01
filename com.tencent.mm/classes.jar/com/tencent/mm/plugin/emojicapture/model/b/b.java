package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.g.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends e
{
  private final String TAG;
  
  public b(String paramString, d paramd, int paramInt)
  {
    super(paramString, paramd);
    AppMethodBeat.i(263);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.grY = (paramInt * 20);
    if (this.grY > 30) {
      this.grY = 30;
    }
    this.grZ /= paramInt;
    this.gsb = (1000.0F / this.grY);
    if (this.gsb < this.grZ) {
      this.gsb = this.grZ;
    }
    this.grW = ((int)(this.videoDuration / paramInt / this.gsb));
    this.grX = 0;
    ad.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.grR + ", duration:" + this.videoDuration + ", frameCount:" + this.grQ + ", frameDuration:" + this.grZ + ", targetFrameRate:" + this.grY + ", targetFrameCount:" + this.grW + ", targetFrameDuration:" + this.gsb);
    AppMethodBeat.o(263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */