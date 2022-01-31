package a.j.b.a;

import a.j.m.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class q$a<T, R>
  extends s.c<R>
  implements m.a<T, R>
{
  private final q<T, R> BPG;
  
  public q$a(q<T, ? extends R> paramq)
  {
    AppMethodBeat.i(118838);
    this.BPG = paramq;
    AppMethodBeat.o(118838);
  }
  
  public final R S(T paramT)
  {
    AppMethodBeat.i(118837);
    paramT = this.BPG.get(paramT);
    AppMethodBeat.o(118837);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.q.a
 * JD-Core Version:    0.7.0.1
 */