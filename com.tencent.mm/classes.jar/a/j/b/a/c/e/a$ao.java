package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$ao
  implements j.a
{
  private static j.b<ao> CkY;
  private final int value;
  
  static
  {
    AppMethodBeat.i(121064);
    CnW = new ao("INTERNAL", 0, 0);
    CnX = new ao("PRIVATE", 1, 1);
    CnY = new ao("PROTECTED", 2, 2);
    CnZ = new ao("PUBLIC", 3, 3);
    Coa = new ao("PRIVATE_TO_THIS", 4, 4);
    Cob = new ao("LOCAL", 5, 5);
    Coc = new ao[] { CnW, CnX, CnY, CnZ, Coa, Cob };
    CkY = new a.ao.1();
    AppMethodBeat.o(121064);
  }
  
  private a$ao(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static ao Vn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CnW;
    case 1: 
      return CnX;
    case 2: 
      return CnY;
    case 3: 
      return CnZ;
    case 4: 
      return Coa;
    }
    return Cob;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.ao
 * JD-Core Version:    0.7.0.1
 */