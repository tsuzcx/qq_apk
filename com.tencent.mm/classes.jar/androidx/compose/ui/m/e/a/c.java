package androidx.compose.ui.m.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/extensions/SpanRange;", "", "span", "start", "", "end", "(Ljava/lang/Object;II)V", "getEnd", "()I", "getSpan", "()Ljava/lang/Object;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c
{
  final Object bdW;
  final int end;
  final int start;
  
  public c(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205364);
    this.bdW = paramObject;
    this.start = paramInt1;
    this.end = paramInt2;
    AppMethodBeat.o(205364);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205387);
    if (this == paramObject)
    {
      AppMethodBeat.o(205387);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(205387);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.bdW, paramObject.bdW))
    {
      AppMethodBeat.o(205387);
      return false;
    }
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(205387);
      return false;
    }
    if (this.end != paramObject.end)
    {
      AppMethodBeat.o(205387);
      return false;
    }
    AppMethodBeat.o(205387);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205377);
    int i = this.bdW.hashCode();
    int j = this.start;
    int k = this.end;
    AppMethodBeat.o(205377);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205371);
    String str = "SpanRange(span=" + this.bdW + ", start=" + this.start + ", end=" + this.end + ')';
    AppMethodBeat.o(205371);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.e.a.c
 * JD-Core Version:    0.7.0.1
 */