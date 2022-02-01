package androidx.compose.ui.m.c;

import androidx.compose.ui.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/SetComposingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "text", "", "newCursorPosition", "", "(Ljava/lang/String;I)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements d
{
  private final a aYS;
  private final int bcv;
  
  private p(a parama, int paramInt)
  {
    AppMethodBeat.i(205283);
    this.aYS = parama;
    this.bcv = paramInt;
    AppMethodBeat.o(205283);
  }
  
  public p(String paramString, int paramInt)
  {
    this(new a(paramString, null, null, 6), paramInt);
    AppMethodBeat.i(205288);
    AppMethodBeat.o(205288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205294);
    if (this == paramObject)
    {
      AppMethodBeat.o(205294);
      return true;
    }
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(205294);
      return false;
    }
    if (!s.p(this.aYS.text, ((p)paramObject).aYS.text))
    {
      AppMethodBeat.o(205294);
      return false;
    }
    if (this.bcv != ((p)paramObject).bcv)
    {
      AppMethodBeat.o(205294);
      return false;
    }
    AppMethodBeat.o(205294);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205299);
    int i = this.aYS.text.hashCode();
    int j = this.bcv;
    AppMethodBeat.o(205299);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205301);
    String str = "SetComposingTextCommand(text='" + this.aYS.text + "', newCursorPosition=" + this.bcv + ')';
    AppMethodBeat.o(205301);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.p
 * JD-Core Version:    0.7.0.1
 */