package com.tencent.mm.plugin.emojicapture.model.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "", "()V", "attachEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getAttachEmoji", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setAttachEmoji", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "attachEmojiMatrix", "Landroid/graphics/Matrix;", "getAttachEmojiMatrix", "()Landroid/graphics/Matrix;", "setAttachEmojiMatrix", "(Landroid/graphics/Matrix;)V", "attachText", "", "getAttachText", "()Ljava/lang/String;", "setAttachText", "(Ljava/lang/String;)V", "attachTextColor", "", "getAttachTextColor", "()I", "setAttachTextColor", "(I)V", "enableRemoveBg", "", "getEnableRemoveBg", "()Z", "setEnableRemoveBg", "(Z)V", "removeBg", "getRemoveBg", "setRemoveBg", "scene", "getScene", "setScene", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "getStickerInfo", "()Lcom/tencent/mm/sticker/StickerPack;", "setStickerInfo", "(Lcom/tencent/mm/sticker/StickerPack;)V", "thumbPath", "getThumbPath", "setThumbPath", "timeEnter", "", "getTimeEnter", "()J", "setTimeEnter", "(J)V", "videoPath", "getVideoPath", "setVideoPath", "plugin-emojicapture_release"})
public final class b
{
  public long gpU;
  public boolean pQj;
  public f pRi;
  public String pRj;
  public int pRk;
  public boolean pRl;
  public EmojiInfo pRm;
  public Matrix pRn;
  public int scene;
  public String thumbPath;
  public String videoPath;
  
  public b()
  {
    AppMethodBeat.i(212);
    this.scene = 1;
    this.videoPath = "";
    this.thumbPath = "";
    this.pRl = true;
    this.pRn = new Matrix();
    AppMethodBeat.o(212);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(210);
    p.h(paramString, "<set-?>");
    this.videoPath = paramString;
    AppMethodBeat.o(210);
  }
  
  public final void yo(String paramString)
  {
    AppMethodBeat.i(211);
    p.h(paramString, "<set-?>");
    this.thumbPath = paramString;
    AppMethodBeat.o(211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.b
 * JD-Core Version:    0.7.0.1
 */