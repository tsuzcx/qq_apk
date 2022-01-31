package a.j.b.a.c.e;

import a.j.b.a.c.g.j.a;
import a.j.b.a.c.g.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$c$b
  implements j.a
{
  private static j.b<b> CkY;
  private final int value;
  
  static
  {
    AppMethodBeat.i(120475);
    Clt = new b("CLASS", 0, 0);
    Clu = new b("INTERFACE", 1, 1);
    Clv = new b("ENUM_CLASS", 2, 2);
    Clw = new b("ENUM_ENTRY", 3, 3);
    Clx = new b("ANNOTATION_CLASS", 4, 4);
    Cly = new b("OBJECT", 5, 5);
    Clz = new b("COMPANION_OBJECT", 6, 6);
    ClA = new b[] { Clt, Clu, Clv, Clw, Clx, Cly, Clz };
    CkY = new a.c.b.1();
    AppMethodBeat.o(120475);
  }
  
  private a$c$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b Uj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Clt;
    case 1: 
      return Clu;
    case 2: 
      return Clv;
    case 3: 
      return Clw;
    case 4: 
      return Clx;
    case 5: 
      return Cly;
    }
    return Clz;
  }
  
  public final int ehC()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.e.a.c.b
 * JD-Core Version:    0.7.0.1
 */