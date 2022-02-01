package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements d
{
  private final int bcw;
  private final int bcx;
  
  public c(int paramInt1, int paramInt2)
  {
    this.bcw = paramInt1;
    this.bcx = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    if (this.bcw != ((c)paramObject).bcw) {
      return false;
    }
    return this.bcx == ((c)paramObject).bcx;
  }
  
  public final int hashCode()
  {
    return this.bcw * 31 + this.bcx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205260);
    String str = "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.bcw + ", lengthAfterCursor=" + this.bcx + ')';
    AppMethodBeat.o(205260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.c.c
 * JD-Core Version:    0.7.0.1
 */