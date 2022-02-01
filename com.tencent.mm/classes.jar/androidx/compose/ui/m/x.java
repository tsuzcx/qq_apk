package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "verbatim", "", "(Ljava/lang/String;)V", "getVerbatim", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends w
{
  public final String baI;
  
  public x(String paramString)
  {
    super((byte)0);
    AppMethodBeat.i(204906);
    this.baI = paramString;
    AppMethodBeat.o(204906);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204909);
    if (this == paramObject)
    {
      AppMethodBeat.o(204909);
      return true;
    }
    if (!(paramObject instanceof x))
    {
      AppMethodBeat.o(204909);
      return false;
    }
    if (!s.p(this.baI, ((x)paramObject).baI))
    {
      AppMethodBeat.o(204909);
      return false;
    }
    AppMethodBeat.o(204909);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204913);
    int i = this.baI.hashCode();
    AppMethodBeat.o(204913);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204918);
    String str = "VerbatimTtsAnnotation(verbatim=" + this.baI + ')';
    AppMethodBeat.o(204918);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.m.x
 * JD-Core Version:    0.7.0.1
 */