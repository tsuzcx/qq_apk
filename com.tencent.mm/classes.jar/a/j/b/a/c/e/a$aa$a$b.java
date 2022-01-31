package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$aa$a$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120843);
    Cne = new b("IN", 0, 0);
    Cnf = new b("OUT", 1, 1);
    Cng = new b("INV", 2, 2);
    Cnh = new b("STAR", 3, 3);
    Cni = new b[] { Cne, Cnf, Cng, Cnh };
    CkY = new a.aa.a.b.1();
    AppMethodBeat.o(120843);
  }
  
  private a$aa$a$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b UL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Cne;
    case 1: 
      return Cnf;
    case 2: 
      return Cng;
    }
    return Cnh;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.aa.a.b
 * JD-Core Version:    0.7.0.1
 */