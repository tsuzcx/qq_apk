package a.j.b.a.c.d.a.c.b;

import a.f.a.b;
import a.f.b.k;
import a.j.b.a.c.d.a.e.v;
import a.j.b.a.c.d.a.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
  extends k
  implements b<v, Boolean>
{
  public static final a CgS;
  
  static
  {
    AppMethodBeat.i(120033);
    CgS = new a();
    AppMethodBeat.o(120033);
  }
  
  c$a()
  {
    super(1);
  }
  
  public static boolean a(v paramv)
  {
    AppMethodBeat.i(120032);
    if (!(paramv instanceof z)) {
      paramv = null;
    }
    for (;;)
    {
      paramv = (z)paramv;
      if (paramv != null)
      {
        if ((paramv.egC() != null) && (!paramv.egD()))
        {
          AppMethodBeat.o(120032);
          return true;
        }
        AppMethodBeat.o(120032);
        return false;
      }
      AppMethodBeat.o(120032);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.c.a
 * JD-Core Version:    0.7.0.1
 */