package com.tencent.mm.plugin.emoji.magicemoji.bean;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "", "keyword", "", "messageLocalId", "", "(Ljava/lang/String;J)V", "getKeyword", "()Ljava/lang/String;", "getMessageLocalId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a xHW;
  private static final a xHY;
  public final String hAB;
  public final long xHX;
  
  static
  {
    AppMethodBeat.i(269953);
    xHW = new a((byte)0);
    xHY = new a("", 0L);
    AppMethodBeat.o(269953);
  }
  
  public a(String paramString, long paramLong)
  {
    AppMethodBeat.i(269947);
    this.hAB = paramString;
    this.xHX = paramLong;
    AppMethodBeat.o(269947);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269967);
    if (this == paramObject)
    {
      AppMethodBeat.o(269967);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(269967);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.hAB, paramObject.hAB))
    {
      AppMethodBeat.o(269967);
      return false;
    }
    if (this.xHX != paramObject.xHX)
    {
      AppMethodBeat.o(269967);
      return false;
    }
    AppMethodBeat.o(269967);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269960);
    int i = this.hAB.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.xHX);
    AppMethodBeat.o(269960);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269956);
    String str = "MagicEmojiEggExtData(keyword=" + this.hAB + ", messageLocalId=" + this.xHX + ')';
    AppMethodBeat.o(269956);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData$Companion;", "", "()V", "NONE", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "getNONE", "()Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.bean.a
 * JD-Core Version:    0.7.0.1
 */