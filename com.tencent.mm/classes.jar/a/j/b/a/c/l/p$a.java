package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.c.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.w;
import a.j.b.a.c.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

final class p$a
  extends a.j.b.a.c.b.c.h
{
  public p$a(a.j.b.a.c.f.f paramf)
  {
    super(p.eoH(), paramf, w.BWr, a.j.b.a.c.b.f.BWf, Collections.emptyList(), am.BWF, b.CAv);
    AppMethodBeat.i(122543);
    paramf = g.BXx;
    paramf = a.j.b.a.c.b.c.f.a(this, g.a.eeH(), am.BWF);
    paramf.a(Collections.emptyList(), ay.BWN);
    a.j.b.a.c.i.e.h localh = p.azi(this.BYN.name);
    paramf.BZB = new o(p.b("<ERROR>", this), localh, (byte)0);
    a(localh, Collections.singleton(paramf), paramf);
    AppMethodBeat.o(122543);
  }
  
  public final a.j.b.a.c.i.e.h a(as paramas)
  {
    AppMethodBeat.i(122544);
    paramas = p.azi("Error scope for class " + this.BYN + " with arguments: " + paramas);
    AppMethodBeat.o(122544);
    return paramas;
  }
  
  public final e g(au paramau)
  {
    return this;
  }
  
  public final String toString()
  {
    return this.BYN.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.p.a
 * JD-Core Version:    0.7.0.1
 */