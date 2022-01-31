package a.j.b.a.c.i.e;

import a.aa;
import a.f.a.a;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.e;
import a.j.b.a.c.k.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class k
  extends i
{
  private final e CxO;
  private final a.j.b.a.c.k.f CxX;
  
  static
  {
    AppMethodBeat.i(122201);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(k.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(122201);
  }
  
  public k(a.j.b.a.c.k.i parami, e parame)
  {
    AppMethodBeat.i(122206);
    this.CxO = parame;
    if (this.CxO.ecB() == a.j.b.a.c.b.f.BWh) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      parami = (Throwable)new AssertionError("Class should be an enum: " + this.CxO);
      AppMethodBeat.o(122206);
      throw parami;
    }
    this.CxX = parami.l((a)new k.a(this));
    AppMethodBeat.o(122206);
  }
  
  private final List<al> eom()
  {
    AppMethodBeat.i(122203);
    List localList = (List)h.a(this.CxX, eOJ[0]);
    AppMethodBeat.o(122203);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.i.e.k
 * JD-Core Version:    0.7.0.1
 */