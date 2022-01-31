package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$q
  implements j.a
{
  private static j.b<q> CkY;
  private final int value;
  
  static
  {
    AppMethodBeat.i(120672);
    Cmm = new q("DECLARATION", 0, 0);
    Cmn = new q("FAKE_OVERRIDE", 1, 1);
    Cmo = new q("DELEGATION", 2, 2);
    Cmp = new q("SYNTHESIZED", 3, 3);
    Cmq = new q[] { Cmm, Cmn, Cmo, Cmp };
    CkY = new a.q.1();
    AppMethodBeat.o(120672);
  }
  
  private a$q(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static q Ux(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Cmm;
    case 1: 
      return Cmn;
    case 2: 
      return Cmo;
    }
    return Cmp;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.q
 * JD-Core Version:    0.7.0.1
 */