package a.j.b.a.c.j.a.a;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.a.c;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.b;
import a.j.b.a.c.f.b;
import a.j.b.a.c.k.f;
import a.j.b.a.c.k.h;
import a.j.b.a.c.k.i;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class a
  implements g
{
  private final f CzC;
  
  static
  {
    AppMethodBeat.i(122333);
    eOJ = new k[] { (k)v.a(new t(v.aG(a.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(122333);
  }
  
  public a(i parami, a.f.a.a<? extends List<? extends c>> parama)
  {
    AppMethodBeat.i(122337);
    this.CzC = parami.l(parama);
    AppMethodBeat.o(122337);
  }
  
  private final List<c> eor()
  {
    AppMethodBeat.i(122334);
    List localList = (List)h.a(this.CzC, eOJ[0]);
    AppMethodBeat.o(122334);
    return localList;
  }
  
  public final c i(b paramb)
  {
    AppMethodBeat.i(122338);
    j.q(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(122338);
    return paramb;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(122335);
    boolean bool = eor().isEmpty();
    AppMethodBeat.o(122335);
    return bool;
  }
  
  public Iterator<c> iterator()
  {
    AppMethodBeat.i(122336);
    Iterator localIterator = eor().iterator();
    AppMethodBeat.o(122336);
    return localIterator;
  }
  
  public final boolean j(b paramb)
  {
    AppMethodBeat.i(122339);
    j.q(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(122339);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */