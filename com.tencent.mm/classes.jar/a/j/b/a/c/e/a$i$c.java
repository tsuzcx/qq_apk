package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$i$c
  implements j.a
{
  private static j.b<c> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120568);
    ClO = new c("AT_MOST_ONCE", 0, 0);
    ClP = new c("EXACTLY_ONCE", 1, 1);
    ClQ = new c("AT_LEAST_ONCE", 2, 2);
    ClR = new c[] { ClO, ClP, ClQ };
    CkY = new j.b() {};
    AppMethodBeat.o(120568);
  }
  
  private a$i$c(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static c Um(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ClO;
    case 1: 
      return ClP;
    }
    return ClQ;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.i.c
 * JD-Core Version:    0.7.0.1
 */