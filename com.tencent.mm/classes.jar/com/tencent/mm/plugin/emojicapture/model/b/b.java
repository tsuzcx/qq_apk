package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b
  extends g
{
  private final String TAG;
  
  public b(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb, int paramInt)
  {
    super(paramString, paramb);
    AppMethodBeat.i(204245);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    acF(paramInt * 20);
    if (fyy() > 30) {
      acF(30);
    }
    this.Iam /= paramInt;
    this.Iao = (1000.0F / fyy());
    if (this.Iao < this.Iam) {
      this.Iao = this.Iam;
    }
    acE((int)(getVideoDuration() / paramInt / this.Iao));
    this.Iak = 0;
    Log.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + fyw() + ", duration:" + getVideoDuration() + ", frameCount:" + fyv() + ", frameDuration:" + this.Iam + ", targetFrameRate:" + fyy() + ", targetFrameCount:" + fyx() + ", targetFrameDuration:" + this.Iao);
    AppMethodBeat.o(204245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */