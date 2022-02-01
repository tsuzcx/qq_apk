package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.l.c;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/FinishComposingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "()V", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements d
{
  public final boolean equals(Object paramObject)
  {
    return paramObject instanceof e;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205256);
    int i = ai.cz(getClass()).hashCode();
    AppMethodBeat.o(205256);
    return i;
  }
  
  public final String toString()
  {
    return "FinishComposingTextCommand()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.c.e
 * JD-Core Version:    0.7.0.1
 */