package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "", "scene", "", "timeEnter", "", "videoPath", "", "outputPath", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;IZLcom/tencent/mm/sticker/StickerPack;ZLcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "()Z", "getOutputGif", "getOutputPath", "()Ljava/lang/String;", "getRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "getScene", "()I", "getStickerPack", "()Lcom/tencent/mm/sticker/StickerPack;", "getTimeEnter", "()J", "getVideoPath", "getVideoPlayRate", "plugin-emojicapture_release"})
public final class d
{
  final EmojiInfo gWm;
  final long hdz;
  final String rpE;
  final a rpJ;
  final int rpK;
  final boolean rpL;
  final f rpM;
  final boolean rpN;
  final int scene;
  final String videoPath;
  
  public d(int paramInt1, long paramLong, String paramString1, String paramString2, a parama, int paramInt2, boolean paramBoolean1, f paramf, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(270);
    this.scene = paramInt1;
    this.hdz = paramLong;
    this.videoPath = paramString1;
    this.rpE = paramString2;
    this.rpJ = parama;
    this.rpK = paramInt2;
    this.rpL = paramBoolean1;
    this.rpM = paramf;
    this.rpN = paramBoolean2;
    this.gWm = paramEmojiInfo;
    AppMethodBeat.o(270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d
 * JD-Core Version:    0.7.0.1
 */