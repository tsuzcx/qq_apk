package a.k;

import a.a.e;
import a.f.a.b;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, eaR=1)
public class l
  extends k
{
  public static final <T> h<T> a(h<? extends T> paramh)
  {
    AppMethodBeat.i(55980);
    j.q(paramh, "receiver$0");
    paramh = (h)new a(paramh);
    AppMethodBeat.o(55980);
    return paramh;
  }
  
  public static final <T> h<T> a(T paramT, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(55982);
    j.q(paramb, "nextFunction");
    if (paramT == null)
    {
      paramT = (h)d.CGj;
      AppMethodBeat.o(55982);
      return paramT;
    }
    paramT = (h)new g((a.f.a.a)new d(paramT), paramb);
    AppMethodBeat.o(55982);
    return paramT;
  }
  
  public static final <T> h<T> aa(T... paramVarArgs)
  {
    AppMethodBeat.i(55979);
    j.q(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramVarArgs = (h)d.CGj;
      AppMethodBeat.o(55979);
      return paramVarArgs;
    }
    paramVarArgs = e.U(paramVarArgs);
    AppMethodBeat.o(55979);
    return paramVarArgs;
  }
  
  public static final <T> h<T> n(a.f.a.a<? extends T> parama)
  {
    AppMethodBeat.i(55981);
    j.q(parama, "nextFunction");
    parama = i.a((h)new g(parama, (b)new l.c(parama)));
    AppMethodBeat.o(55981);
    return parama;
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
  static final class d
    extends a.f.b.k
    implements a.f.a.a<T>
  {
    d(Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      return this.CGz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.k.l
 * JD-Core Version:    0.7.0.1
 */