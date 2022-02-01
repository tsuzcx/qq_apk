package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f
{
  private final String TAG;
  
  public b(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb, int paramInt)
  {
    super(paramString, paramb);
    AppMethodBeat.i(269385);
    this.TAG = "MicroMsg.EmojiMixFrameSyncMgr";
    agV(paramInt * 20);
    if (gKj() > 30) {
      agV(30);
    }
    this.NWP /= paramInt;
    this.NWR = (1000.0F / gKj());
    if (this.NWR < this.NWP) {
      this.NWR = this.NWP;
    }
    agU((int)(getVideoDuration() / paramInt / this.NWR));
    this.NWN = 0;
    Log.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + paramInt + ", fps:" + gKh() + ", duration:" + getVideoDuration() + ", frameCount:" + getVideoFrameCount() + ", frameDuration:" + this.NWP + ", targetFrameRate:" + gKj() + ", targetFrameCount:" + gKi() + ", targetFrameDuration:" + this.NWR);
    AppMethodBeat.o(269385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */