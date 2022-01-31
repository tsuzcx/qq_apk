package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$c
  implements d.a
{
  private final u.b Cse;
  private d.a Csf;
  int Csg;
  
  private u$c(u paramu)
  {
    AppMethodBeat.i(121592);
    this.Cse = new u.b(paramu, (byte)0);
    this.Csf = this.Cse.ena().emm();
    this.Csg = paramu.size();
    AppMethodBeat.o(121592);
  }
  
  public final boolean hasNext()
  {
    return this.Csg > 0;
  }
  
  public final byte nextByte()
  {
    AppMethodBeat.i(121593);
    if (!this.Csf.hasNext()) {
      this.Csf = this.Cse.ena().emm();
    }
    this.Csg -= 1;
    byte b = this.Csf.nextByte();
    AppMethodBeat.o(121593);
    return b;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121594);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121594);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.u.c
 * JD-Core Version:    0.7.0.1
 */