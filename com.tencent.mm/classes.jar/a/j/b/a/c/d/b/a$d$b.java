package a.j.b.a.c.d.b;

import a.f.b.j;
import a.j.b.a.c.b.am;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class a$d$b
  implements n.c
{
  private final ArrayList<A> CiO;
  final q CiP;
  
  public a$d$b(q paramq)
  {
    AppMethodBeat.i(120220);
    this.CiP = localObject;
    this.CiO = new ArrayList();
    AppMethodBeat.o(120220);
  }
  
  public final n.a a(a.j.b.a.c.f.a parama, am paramam)
  {
    AppMethodBeat.i(120218);
    j.q(parama, "classId");
    j.q(paramam, "source");
    parama = a.a(this.CiN.CiK, parama, paramam, (List)this.CiO);
    AppMethodBeat.o(120218);
    return parama;
  }
  
  public final void zi()
  {
    AppMethodBeat.i(120219);
    if (!((Collection)this.CiO).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((Map)this.CiN.CiL).put(this.CiP, this.CiO);
      }
      AppMethodBeat.o(120219);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.b.a.d.b
 * JD-Core Version:    0.7.0.1
 */