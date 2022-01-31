package a.j.b.a.c.d.b;

import a.f.b.j;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T>
{
  private int Cji;
  private T Cjj;
  private final k<T> Cjk;
  
  public final void dC(T paramT)
  {
    AppMethodBeat.i(120265);
    j.q(paramT, "objectType");
    dD(paramT);
    AppMethodBeat.o(120265);
  }
  
  final void dD(T paramT)
  {
    AppMethodBeat.i(120266);
    j.q(paramT, "type");
    if (this.Cjj == null) {
      this.Cjj = this.Cjk.ayI(m.t((CharSequence)"[", this.Cji) + this.Cjk.toString(paramT));
    }
    AppMethodBeat.o(120266);
  }
  
  public final void egR()
  {
    if (this.Cjj == null) {
      this.Cji += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.b.h
 * JD-Core Version:    0.7.0.1
 */