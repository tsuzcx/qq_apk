package a.j.b.a.c.i;

import a.j.b.a.c.l.a.c.a;
import a.j.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class j$3
  implements c.a
{
  j$3(j paramj, Map paramMap) {}
  
  public final boolean a(an paraman1, an paraman2)
  {
    AppMethodBeat.i(121996);
    if (j.a(this.Cwe).a(paraman1, paraman2))
    {
      AppMethodBeat.o(121996);
      return true;
    }
    an localan1 = (an)this.Cwd.get(paraman1);
    an localan2 = (an)this.Cwd.get(paraman2);
    if (((localan1 != null) && (localan1.equals(paraman2))) || ((localan2 != null) && (localan2.equals(paraman1))))
    {
      AppMethodBeat.o(121996);
      return true;
    }
    AppMethodBeat.o(121996);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.i.j.3
 * JD-Core Version:    0.7.0.1
 */