package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, eaR=1)
public class i
{
  public static final <T> f<T> a(k paramk, a<? extends T> parama)
  {
    AppMethodBeat.i(56366);
    j.q(paramk, "mode");
    j.q(parama, "initializer");
    switch (h.bLo[paramk.ordinal()])
    {
    default: 
      paramk = new m();
      AppMethodBeat.o(56366);
      throw paramk;
    case 1: 
      paramk = (f)new s(parama, (byte)0);
      AppMethodBeat.o(56366);
      return paramk;
    case 2: 
      paramk = (f)new r(parama);
      AppMethodBeat.o(56366);
      return paramk;
    }
    paramk = (f)new z(parama);
    AppMethodBeat.o(56366);
    return paramk;
  }
  
  public static final <T> f<T> j(a<? extends T> parama)
  {
    AppMethodBeat.i(56365);
    j.q(parama, "initializer");
    parama = (f)new s(parama, (byte)0);
    AppMethodBeat.o(56365);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.i
 * JD-Core Version:    0.7.0.1
 */