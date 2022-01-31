package a.j.b.a.c.m;

import a.f.b.j;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.t;
import a.j.b.a.c.i.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

final class h
  implements b
{
  public static final h CDw;
  private static final String description = "should not have varargs or parameters with default values";
  
  static
  {
    AppMethodBeat.i(122874);
    CDw = new h();
    description = "should not have varargs or parameters with default values";
    AppMethodBeat.o(122874);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(t paramt)
  {
    AppMethodBeat.i(122873);
    j.q(paramt, "functionDescriptor");
    paramt = paramt.edu();
    j.p(paramt, "functionDescriptor.valueParameters");
    paramt = (Iterable)paramt;
    if ((!(paramt instanceof Collection)) || (!((Collection)paramt).isEmpty()))
    {
      paramt = paramt.iterator();
      while (paramt.hasNext())
      {
        au localau = (au)paramt.next();
        j.p(localau, "it");
        if ((!a.b(localau)) && (localau.eeu() == null)) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(122873);
          return false;
        }
      }
    }
    AppMethodBeat.o(122873);
    return true;
  }
  
  public final String i(t paramt)
  {
    AppMethodBeat.i(122875);
    j.q(paramt, "functionDescriptor");
    paramt = b.a.a(this, paramt);
    AppMethodBeat.o(122875);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.m.h
 * JD-Core Version:    0.7.0.1
 */