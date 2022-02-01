package com.tencent.mm.plugin.emoji.ui.v3.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionRecRange;", "", "startPos", "", "endPos", "reportScene", "(III)V", "getEndPos", "()I", "setEndPos", "(I)V", "getReportScene", "setReportScene", "getStartPos", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public final int dIY;
  int endPos;
  public int ybL;
  
  public g()
  {
    this(0, 0, 0, 7);
  }
  
  private g(int paramInt1, int paramInt2, int paramInt3)
  {
    this.dIY = paramInt1;
    this.endPos = paramInt2;
    this.ybL = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof g)) {
        return false;
      }
      paramObject = (g)paramObject;
      if (this.dIY != paramObject.dIY) {
        return false;
      }
      if (this.endPos != paramObject.endPos) {
        return false;
      }
    } while (this.ybL == paramObject.ybL);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.dIY * 31 + this.endPos) * 31 + this.ybL;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(270685);
    String str = "EmojiStoreV3EmotionRecRange(startPos=" + this.dIY + ", endPos=" + this.endPos + ", reportScene=" + this.ybL + ')';
    AppMethodBeat.o(270685);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.g
 * JD-Core Version:    0.7.0.1
 */