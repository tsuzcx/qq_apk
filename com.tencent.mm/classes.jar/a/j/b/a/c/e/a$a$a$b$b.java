package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a$a$b$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120395);
    CkL = new b("BYTE", 0, 0);
    CkM = new b("CHAR", 1, 1);
    CkN = new b("SHORT", 2, 2);
    CkO = new b("INT", 3, 3);
    CkP = new b("LONG", 4, 4);
    CkQ = new b("FLOAT", 5, 5);
    CkR = new b("DOUBLE", 6, 6);
    CkS = new b("BOOLEAN", 7, 7);
    CkT = new b("STRING", 8, 8);
    CkU = new b("CLASS", 9, 9);
    CkV = new b("ENUM", 10, 10);
    CkW = new b("ANNOTATION", 11, 11);
    CkX = new b("ARRAY", 12, 12);
    CkZ = new b[] { CkL, CkM, CkN, CkO, CkP, CkQ, CkR, CkS, CkT, CkU, CkV, CkW, CkX };
    CkY = new a.a.a.b.b.1();
    AppMethodBeat.o(120395);
  }
  
  private a$a$a$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Ud(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CkL;
    case 1: 
      return CkM;
    case 2: 
      return CkN;
    case 3: 
      return CkO;
    case 4: 
      return CkP;
    case 5: 
      return CkQ;
    case 6: 
      return CkR;
    case 7: 
      return CkS;
    case 8: 
      return CkT;
    case 9: 
      return CkU;
    case 10: 
      return CkV;
    case 11: 
      return CkW;
    }
    return CkX;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.a.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */