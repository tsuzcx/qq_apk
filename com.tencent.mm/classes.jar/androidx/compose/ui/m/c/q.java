package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/SetSelectionCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements d
{
  private final int end;
  private final int start;
  
  public q(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof q)) {
      return false;
    }
    if (this.start != ((q)paramObject).start) {
      return false;
    }
    return this.end == ((q)paramObject).end;
  }
  
  public final int hashCode()
  {
    return this.start * 31 + this.end;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205291);
    String str = "SetSelectionCommand(start=" + this.start + ", end=" + this.end + ')';
    AppMethodBeat.o(205291);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.c.q
 * JD-Core Version:    0.7.0.1
 */