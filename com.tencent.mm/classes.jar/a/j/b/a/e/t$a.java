package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.d.a.n;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;

@l(eaO={1, 1, 13})
public final class t$a
{
  public static boolean a(t paramt)
  {
    AppMethodBeat.i(123104);
    boolean bool = Modifier.isAbstract(paramt.getModifiers());
    AppMethodBeat.o(123104);
    return bool;
  }
  
  public static boolean b(t paramt)
  {
    AppMethodBeat.i(123105);
    boolean bool = Modifier.isStatic(paramt.getModifiers());
    AppMethodBeat.o(123105);
    return bool;
  }
  
  public static boolean c(t paramt)
  {
    AppMethodBeat.i(123106);
    boolean bool = Modifier.isFinal(paramt.getModifiers());
    AppMethodBeat.o(123106);
    return bool;
  }
  
  public static az d(t paramt)
  {
    AppMethodBeat.i(123107);
    int i = paramt.getModifiers();
    if (Modifier.isPublic(i))
    {
      paramt = ay.BWO;
      j.p(paramt, "Visibilities.PUBLIC");
      AppMethodBeat.o(123107);
      return paramt;
    }
    if (Modifier.isPrivate(i))
    {
      paramt = ay.BWK;
      j.p(paramt, "Visibilities.PRIVATE");
      AppMethodBeat.o(123107);
      return paramt;
    }
    if (Modifier.isProtected(i))
    {
      if (Modifier.isStatic(i)) {}
      for (paramt = n.CcV;; paramt = n.CcW)
      {
        j.p(paramt, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
        AppMethodBeat.o(123107);
        return paramt;
      }
    }
    paramt = n.CcU;
    j.p(paramt, "JavaVisibilities.PACKAGE_VISIBILITY");
    AppMethodBeat.o(123107);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.e.t.a
 * JD-Core Version:    0.7.0.1
 */