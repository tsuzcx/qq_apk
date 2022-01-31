package a.j.b.a.c.e.b;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$g$b$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(121276);
    CpV = new b("NONE", 0, 0);
    CpW = new b("INTERNAL_TO_CLASS_ID", 1, 1);
    CpX = new b("DESC_TO_CLASS_ID", 2, 2);
    CpY = new b[] { CpV, CpW, CpX };
    CkY = new b.g.b.b.1();
    AppMethodBeat.o(121276);
  }
  
  private b$g$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Vz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CpV;
    case 1: 
      return CpW;
    }
    return CpX;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.g.b.b
 * JD-Core Version:    0.7.0.1
 */