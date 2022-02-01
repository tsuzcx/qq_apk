package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "sosDocId", "", "pageNo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "getPageNo", "getSosDocId", "()Ljava/lang/String;", "contentEquals", "", "other", "", "equals", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends ae
{
  public final EmojiInfo mgK;
  public final int miu;
  public final String miv;
  public final int miw;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public final boolean cv(Object paramObject)
  {
    AppMethodBeat.i(105537);
    if ((super.cv(paramObject)) && ((paramObject instanceof h)) && (((h)paramObject).mgK.kMj() == this.mgK.kMj()) && (((h)paramObject).mgK.field_idx == this.mgK.field_idx) && (((h)paramObject).mgK.field_reserved3 == this.mgK.field_reserved3) && (((h)paramObject).miu == this.miu))
    {
      AppMethodBeat.o(105537);
      return true;
    }
    AppMethodBeat.o(105537);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105536);
    if ((super.equals(paramObject)) && ((paramObject instanceof h)) && ((s.p(((h)paramObject).mgK.getMd5(), this.mgK.getMd5())) || ((this.mgK.field_captureEnterTime != 0L) && (((h)paramObject).mgK.field_captureEnterTime == this.mgK.field_captureEnterTime))))
    {
      AppMethodBeat.o(105536);
      return true;
    }
    AppMethodBeat.o(105536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.h
 * JD-Core Version:    0.7.0.1
 */