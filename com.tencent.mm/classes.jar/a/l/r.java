package a.l;

import a.f.a.b;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendElement", "element", "transform", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, eaR=1)
public class r
  extends q
{
  public static final StringBuilder a(StringBuilder paramStringBuilder, String... paramVarArgs)
  {
    AppMethodBeat.i(56298);
    j.q(paramStringBuilder, "receiver$0");
    j.q(paramVarArgs, "value");
    int i = 0;
    while (i < 3)
    {
      paramStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(56298);
    return paramStringBuilder;
  }
  
  public static final <T> void a(Appendable paramAppendable, T paramT, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(56299);
    j.q(paramAppendable, "receiver$0");
    if (paramb != null)
    {
      paramAppendable.append((CharSequence)paramb.S(paramT));
      AppMethodBeat.o(56299);
      return;
    }
    if (paramT != null) {}
    for (boolean bool = paramT instanceof CharSequence; bool; bool = true)
    {
      paramAppendable.append((CharSequence)paramT);
      AppMethodBeat.o(56299);
      return;
    }
    if ((paramT instanceof Character))
    {
      paramAppendable.append(((Character)paramT).charValue());
      AppMethodBeat.o(56299);
      return;
    }
    paramAppendable.append((CharSequence)String.valueOf(paramT));
    AppMethodBeat.o(56299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.l.r
 * JD-Core Version:    0.7.0.1
 */