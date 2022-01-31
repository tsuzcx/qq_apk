package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$r
  implements j.a
{
  private static j.b<r> CkY;
  private final int value;
  
  static
  {
    AppMethodBeat.i(120676);
    Cmr = new r("FINAL", 0, 0);
    Cms = new r("OPEN", 1, 1);
    Cmt = new r("ABSTRACT", 2, 2);
    Cmu = new r("SEALED", 3, 3);
    Cmv = new r[] { Cmr, Cms, Cmt, Cmu };
    CkY = new a.r.1();
    AppMethodBeat.o(120676);
  }
  
  private a$r(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static r Uy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Cmr;
    case 1: 
      return Cms;
    case 2: 
      return Cmt;
    }
    return Cmu;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.r
 * JD-Core Version:    0.7.0.1
 */