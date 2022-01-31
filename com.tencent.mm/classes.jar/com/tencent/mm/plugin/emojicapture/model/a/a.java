package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "", "()V", "attachText", "", "getAttachText", "()Ljava/lang/String;", "setAttachText", "(Ljava/lang/String;)V", "attachTextColor", "", "getAttachTextColor", "()I", "setAttachTextColor", "(I)V", "enableRemoveBg", "", "getEnableRemoveBg", "()Z", "setEnableRemoveBg", "(Z)V", "removeBg", "getRemoveBg", "setRemoveBg", "scene", "getScene", "setScene", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getStickerInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "setStickerInfo", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;)V", "thumbPath", "getThumbPath", "setThumbPath", "timeEnter", "", "getTimeEnter", "()J", "setTimeEnter", "(J)V", "videoPath", "getVideoPath", "setVideoPath", "plugin-emojicapture_release"})
public final class a
{
  public long eyh;
  public boolean lsQ;
  public b ltF;
  public String ltG;
  public int ltH;
  public boolean ltI = true;
  public int scene = 1;
  public String thumbPath = "";
  public String videoPath = "";
  
  public final void mV(String paramString)
  {
    AppMethodBeat.i(2636);
    j.q(paramString, "<set-?>");
    this.thumbPath = paramString;
    AppMethodBeat.o(2636);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(2635);
    j.q(paramString, "<set-?>");
    this.videoPath = paramString;
    AppMethodBeat.o(2635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.a
 * JD-Core Version:    0.7.0.1
 */