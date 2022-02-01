package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/EmojiString$Clip;", "", "start", "", "end", "type", "Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "content", "", "(IILcom/tencent/mm/plugin/emoji/EmojiString$ClipType;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEnd", "()I", "getStart", "getType", "()Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a
{
  final String content;
  private final int end;
  private final int start;
  final e.b xFI;
  
  public e$a(int paramInt1, int paramInt2, e.b paramb, String paramString)
  {
    AppMethodBeat.i(269731);
    this.start = paramInt1;
    this.end = paramInt2;
    this.xFI = paramb;
    this.content = paramString;
    AppMethodBeat.o(269731);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269745);
    if (this == paramObject)
    {
      AppMethodBeat.o(269745);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(269745);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(269745);
      return false;
    }
    if (this.end != paramObject.end)
    {
      AppMethodBeat.o(269745);
      return false;
    }
    if (this.xFI != paramObject.xFI)
    {
      AppMethodBeat.o(269745);
      return false;
    }
    if (!s.p(this.content, paramObject.content))
    {
      AppMethodBeat.o(269745);
      return false;
    }
    AppMethodBeat.o(269745);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269741);
    int i = this.start;
    int j = this.end;
    int k = this.xFI.hashCode();
    int m = this.content.hashCode();
    AppMethodBeat.o(269741);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269735);
    String str = "Clip(start=" + this.start + ", end=" + this.end + ", type=" + this.xFI + ", content=" + this.content + ')';
    AppMethodBeat.o(269735);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */