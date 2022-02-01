package com.tencent.mm.plugin.emojicapture.model.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "", "()V", "attachEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getAttachEmoji", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setAttachEmoji", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "attachEmojiMatrix", "Landroid/graphics/Matrix;", "getAttachEmojiMatrix", "()Landroid/graphics/Matrix;", "setAttachEmojiMatrix", "(Landroid/graphics/Matrix;)V", "attachText", "", "getAttachText", "()Ljava/lang/String;", "setAttachText", "(Ljava/lang/String;)V", "attachTextColor", "", "getAttachTextColor", "()I", "setAttachTextColor", "(I)V", "enableRemoveBg", "", "getEnableRemoveBg", "()Z", "setEnableRemoveBg", "(Z)V", "removeBg", "getRemoveBg", "setRemoveBg", "scene", "getScene", "setScene", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "getStickerInfo", "()Lcom/tencent/mm/sticker/StickerPack;", "setStickerInfo", "(Lcom/tencent/mm/sticker/StickerPack;)V", "thumbPath", "getThumbPath", "setThumbPath", "timeEnter", "", "getTimeEnter", "()J", "setTimeEnter", "(J)V", "videoPath", "getVideoPath", "setVideoPath", "plugin-emojicapture_release"})
public final class b
{
  public long fWr;
  public boolean pmJ;
  public f pnI;
  public String pnJ;
  public int pnK;
  public boolean pnL;
  public EmojiInfo pnM;
  public Matrix pnN;
  public int scene;
  public String thumbPath;
  public String videoPath;
  
  public b()
  {
    AppMethodBeat.i(212);
    this.scene = 1;
    this.videoPath = "";
    this.thumbPath = "";
    this.pnL = true;
    this.pnN = new Matrix();
    AppMethodBeat.o(212);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(210);
    k.h(paramString, "<set-?>");
    this.videoPath = paramString;
    AppMethodBeat.o(210);
  }
  
  public final void vx(String paramString)
  {
    AppMethodBeat.i(211);
    k.h(paramString, "<set-?>");
    this.thumbPath = paramString;
    AppMethodBeat.o(211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.b
 * JD-Core Version:    0.7.0.1
 */