package com.tencent.mm.plugin.emojicapture.model.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "", "scene", "", "timeEnter", "", "videoPath", "", "outputPath", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "hasSticker", "outputGif", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;IZZZLcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getHasSticker", "()Z", "getOutputGif", "getOutputPath", "()Ljava/lang/String;", "getRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "getScene", "()I", "getTimeEnter", "()J", "getVideoPath", "getVideoPlayRate", "plugin-emojicapture_release"})
public final class d
{
  final EmojiInfo evH;
  final long eyh;
  final String lup;
  final a luv;
  final int luw;
  final boolean lux;
  final boolean luy;
  final boolean luz;
  final int scene;
  final String videoPath;
  
  public d(int paramInt1, long paramLong, String paramString1, String paramString2, a parama, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(2670);
    this.scene = paramInt1;
    this.eyh = paramLong;
    this.videoPath = paramString1;
    this.lup = paramString2;
    this.luv = parama;
    this.luw = paramInt2;
    this.lux = paramBoolean1;
    this.luy = paramBoolean2;
    this.luz = paramBoolean3;
    this.evH = paramEmojiInfo;
    AppMethodBeat.o(2670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d
 * JD-Core Version:    0.7.0.1
 */