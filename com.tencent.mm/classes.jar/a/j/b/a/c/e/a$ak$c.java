package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$ak$c
  implements j.a
{
  private static j.b<c> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(121030);
    CnQ = new c("LANGUAGE_VERSION", 0, 0);
    CnR = new c("COMPILER_VERSION", 1, 1);
    CnS = new c("API_VERSION", 2, 2);
    CnT = new c[] { CnQ, CnR, CnS };
    CkY = new a.ak.c.1();
    AppMethodBeat.o(121030);
  }
  
  private a$ak$c(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static c Vm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return CnQ;
    case 1: 
      return CnR;
    }
    return CnS;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.ak.c
 * JD-Core Version:    0.7.0.1
 */