package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$m$b
  implements j.a
{
  private static j.b<b> CkY;
  final int value;
  
  static
  {
    AppMethodBeat.i(120625);
    Cmb = new b("TRUE", 0, 0);
    Cmc = new b("FALSE", 1, 1);
    Cmd = new b("NULL", 2, 2);
    Cme = new b[] { Cmb, Cmc, Cmd };
    CkY = new a.m.b.1();
    AppMethodBeat.o(120625);
  }
  
  private a$m$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Ur(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Cmb;
    case 1: 
      return Cmc;
    }
    return Cmd;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.m.b
 * JD-Core Version:    0.7.0.1
 */