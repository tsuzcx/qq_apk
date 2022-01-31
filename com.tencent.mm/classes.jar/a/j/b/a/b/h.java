package a.j.b.a.b;

import a.f.b.j;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.e;
import a.j.b.a.c.j.a.m;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/RuntimeErrorReporter;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter;", "()V", "reportCannotInferVisibility", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "reportIncompleteHierarchy", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "unresolvedSuperClasses", "", "", "descriptors.runtime"})
public final class h
  implements m
{
  public static final h BRk;
  
  static
  {
    AppMethodBeat.i(119048);
    BRk = new h();
    AppMethodBeat.o(119048);
  }
  
  public final void a(e parame, List<String> paramList)
  {
    AppMethodBeat.i(119046);
    j.q(parame, "descriptor");
    j.q(paramList, "unresolvedSuperClasses");
    parame = (Throwable)new IllegalStateException("Incomplete hierarchy for class " + parame.edF() + ", unresolved classes " + paramList);
    AppMethodBeat.o(119046);
    throw parame;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(119047);
    j.q(paramb, "descriptor");
    paramb = (Throwable)new IllegalStateException("Cannot infer visibility for ".concat(String.valueOf(paramb)));
    AppMethodBeat.o(119047);
    throw paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */