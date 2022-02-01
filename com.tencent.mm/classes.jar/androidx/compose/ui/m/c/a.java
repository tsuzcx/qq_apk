package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/CommitTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "text", "", "newCursorPosition", "", "(Ljava/lang/String;I)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d
{
  private final androidx.compose.ui.m.a aYS;
  private final int bcv;
  
  private a(androidx.compose.ui.m.a parama, int paramInt)
  {
    AppMethodBeat.i(205268);
    this.aYS = parama;
    this.bcv = paramInt;
    AppMethodBeat.o(205268);
  }
  
  public a(String paramString, int paramInt)
  {
    this(new androidx.compose.ui.m.a(paramString, null, null, 6), paramInt);
    AppMethodBeat.i(205274);
    AppMethodBeat.o(205274);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205278);
    if (this == paramObject)
    {
      AppMethodBeat.o(205278);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(205278);
      return false;
    }
    if (!s.p(this.aYS.text, ((a)paramObject).aYS.text))
    {
      AppMethodBeat.o(205278);
      return false;
    }
    if (this.bcv != ((a)paramObject).bcv)
    {
      AppMethodBeat.o(205278);
      return false;
    }
    AppMethodBeat.o(205278);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205284);
    int i = this.aYS.text.hashCode();
    int j = this.bcv;
    AppMethodBeat.o(205284);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205293);
    String str = "CommitTextCommand(text='" + this.aYS.text + "', newCursorPosition=" + this.bcv + ')';
    AppMethodBeat.o(205293);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.a
 * JD-Core Version:    0.7.0.1
 */