package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$i$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120564);
    ClK = new b("RETURNS_CONSTANT", 0, 0);
    ClL = new b("CALLS", 1, 1);
    ClM = new b("RETURNS_NOT_NULL", 2, 2);
    ClN = new b[] { ClK, ClL, ClM };
    CkY = new a.i.b.1();
    AppMethodBeat.o(120564);
  }
  
  private a$i$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Ul(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ClK;
    case 1: 
      return ClL;
    }
    return ClM;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.a.i.b
 * JD-Core Version:    0.7.0.1
 */