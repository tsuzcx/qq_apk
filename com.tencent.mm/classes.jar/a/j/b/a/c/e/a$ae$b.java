package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$ae$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120941);
    Cnv = new b("IN", 0, 0);
    Cnw = new b("OUT", 1, 1);
    Cnx = new b("INV", 2, 2);
    Cny = new b[] { Cnv, Cnw, Cnx };
    CkY = new a.ae.b.1();
    AppMethodBeat.o(120941);
  }
  
  private a$ae$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Vb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Cnv;
    case 1: 
      return Cnw;
    }
    return Cnx;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.ae.b
 * JD-Core Version:    0.7.0.1
 */