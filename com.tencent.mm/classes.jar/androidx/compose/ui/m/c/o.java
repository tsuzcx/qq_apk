package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/SetComposingRegionCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements d
{
  private final int end;
  private final int start;
  
  public o(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof o)) {
      return false;
    }
    if (this.start != ((o)paramObject).start) {
      return false;
    }
    return this.end == ((o)paramObject).end;
  }
  
  public final int hashCode()
  {
    return this.start * 31 + this.end;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205297);
    String str = "SetComposingRegionCommand(start=" + this.start + ", end=" + this.end + ')';
    AppMethodBeat.o(205297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.c.o
 * JD-Core Version:    0.7.0.1
 */