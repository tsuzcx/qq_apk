package a.j.b.a.c.l.a;

import a.j.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q$a
{
  static
  {
    AppMethodBeat.i(122790);
    CCO = new a("IN", 0);
    CCP = new a("OUT", 1);
    CCQ = new a("INV", 2);
    CCR = new a("STAR", 3);
    CCS = new a[] { CCO, CCP, CCQ, CCR };
    AppMethodBeat.o(122790);
  }
  
  private q$a() {}
  
  public static a a(ba paramba)
  {
    AppMethodBeat.i(122789);
    switch (q.1.CCN[paramba.ordinal()])
    {
    default: 
      paramba = new IllegalStateException("Unknown variance");
      AppMethodBeat.o(122789);
      throw paramba;
    case 1: 
      paramba = CCQ;
      AppMethodBeat.o(122789);
      return paramba;
    case 2: 
      paramba = CCO;
      AppMethodBeat.o(122789);
      return paramba;
    }
    paramba = CCP;
    AppMethodBeat.o(122789);
    return paramba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.l.a.q.a
 * JD-Core Version:    0.7.0.1
 */