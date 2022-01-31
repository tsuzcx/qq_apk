package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$ak$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(121026);
    CnM = new b("WARNING", 0, 0);
    CnN = new b("ERROR", 1, 1);
    CnO = new b("HIDDEN", 2, 2);
    CnP = new b[] { CnM, CnN, CnO };
    CkY = new a.ak.b.1();
    AppMethodBeat.o(121026);
  }
  
  private a$ak$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Vl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CnM;
    case 1: 
      return CnN;
    }
    return CnO;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.ak.b
 * JD-Core Version:    0.7.0.1
 */