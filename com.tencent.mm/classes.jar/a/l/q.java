package a.l;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "", "", "clear", "set", "", "index", "kotlin-stdlib"}, eaR=1)
public class q
  extends p
{
  public static final StringBuilder i(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(56342);
    j.q(paramStringBuilder, "receiver$0");
    paramStringBuilder.setLength(0);
    AppMethodBeat.o(56342);
    return paramStringBuilder;
  }
  
  public static final StringBuilder j(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(56343);
    j.q(paramStringBuilder, "receiver$0");
    paramStringBuilder = paramStringBuilder.append(y.LINE_SEPARATOR);
    j.p(paramStringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
    AppMethodBeat.o(56343);
    return paramStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.l.q
 * JD-Core Version:    0.7.0.1
 */