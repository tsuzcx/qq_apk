package a.j.b.a.c.i.e;

import a.j.b.a.c.b.b;
import a.j.b.a.c.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e$b
  extends h
{
  e$b(ArrayList paramArrayList) {}
  
  public final void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(122186);
    a.f.b.j.q(paramb1, "fromSuper");
    a.f.b.j.q(paramb2, "fromCurrent");
    paramb1 = (Throwable)new IllegalStateException(("Conflict in scope of " + this.CxP.CxO + ": " + paramb1 + " vs " + paramb2).toString());
    AppMethodBeat.o(122186);
    throw paramb1;
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(122185);
    a.f.b.j.q(paramb, "fakeOverride");
    a.j.b.a.c.i.j.a(paramb, null);
    this.BUD.add(paramb);
    AppMethodBeat.o(122185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.i.e.e.b
 * JD-Core Version:    0.7.0.1
 */