package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "", "intrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "startIndex", "", "endIndex", "(Landroidx/compose/ui/text/ParagraphIntrinsics;II)V", "getEndIndex", "()I", "getIntrinsics", "()Landroidx/compose/ui/text/ParagraphIntrinsics;", "getStartIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  final k aZb;
  final int endIndex;
  final int startIndex;
  
  public j(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204911);
    this.aZb = paramk;
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
    AppMethodBeat.o(204911);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204926);
    if (this == paramObject)
    {
      AppMethodBeat.o(204926);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(204926);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.aZb, paramObject.aZb))
    {
      AppMethodBeat.o(204926);
      return false;
    }
    if (this.startIndex != paramObject.startIndex)
    {
      AppMethodBeat.o(204926);
      return false;
    }
    if (this.endIndex != paramObject.endIndex)
    {
      AppMethodBeat.o(204926);
      return false;
    }
    AppMethodBeat.o(204926);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204922);
    int i = this.aZb.hashCode();
    int j = this.startIndex;
    int k = this.endIndex;
    AppMethodBeat.o(204922);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204916);
    String str = "ParagraphIntrinsicInfo(intrinsics=" + this.aZb + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ')';
    AppMethodBeat.o(204916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.m.j
 * JD-Core Version:    0.7.0.1
 */