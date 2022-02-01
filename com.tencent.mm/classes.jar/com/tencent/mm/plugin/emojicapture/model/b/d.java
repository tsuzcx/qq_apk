package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "", "scene", "", "timeEnter", "", "videoPath", "", "outputPath", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;IZLcom/tencent/mm/sticker/StickerPack;ZLcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "()Z", "getOutputGif", "getOutputPath", "()Ljava/lang/String;", "getRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "getScene", "()I", "getStickerPack", "()Lcom/tencent/mm/sticker/StickerPack;", "getTimeEnter", "()J", "getVideoPath", "getVideoPlayRate", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final EmojiInfo mgK;
  final long mnX;
  final String outputPath;
  final int scene;
  final String videoPath;
  final a yhR;
  final int yhS;
  final boolean yhT;
  final f yhU;
  final boolean yhV;
  
  public d(int paramInt1, long paramLong, String paramString1, String paramString2, a parama, int paramInt2, boolean paramBoolean1, f paramf, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(270);
    this.scene = paramInt1;
    this.mnX = paramLong;
    this.videoPath = paramString1;
    this.outputPath = paramString2;
    this.yhR = parama;
    this.yhS = paramInt2;
    this.yhT = paramBoolean1;
    this.yhU = paramf;
    this.yhV = paramBoolean2;
    this.mgK = paramEmojiInfo;
    AppMethodBeat.o(270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d
 * JD-Core Version:    0.7.0.1
 */