package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$w$b$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120777);
    CmH = new b("CLASS", 0, 0);
    CmI = new b("PACKAGE", 1, 1);
    CmJ = new b("LOCAL", 2, 2);
    CmK = new b[] { CmH, CmI, CmJ };
    CkY = new j.b() {};
    AppMethodBeat.o(120777);
  }
  
  private a$w$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b UJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CmH;
    case 1: 
      return CmI;
    }
    return CmJ;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.a.w.b.b
 * JD-Core Version:    0.7.0.1
 */