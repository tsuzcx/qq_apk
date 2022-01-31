package com.tencent.mm.plugin.emojicapture.model.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.f.e;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends e
{
  private final String TAG;
  
  public b(String paramString, d paramd, int paramInt)
  {
    super(paramString, paramd);
    AppMethodBeat.i(2663);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    this.eVH = (paramInt * 20);
    if (this.eVH > 30) {
      this.eVH = 30;
    }
    this.eVI /= paramInt;
    this.eVK = (1000.0F / this.eVH);
    if (this.eVK < this.eVI) {
      this.eVK = this.eVI;
    }
    this.eVF = ((int)(this.eVA / paramInt / this.eVK));
    this.eVG = 0;
    ab.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + this.eVz + ", duration:" + this.eVA + ", frameCount:" + this.eVy + ", frameDuration:" + this.eVI + ", targetFrameRate:" + this.eVH + ", targetFrameCount:" + this.eVF + ", targetFrameDuration:" + this.eVK);
    AppMethodBeat.o(2663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */