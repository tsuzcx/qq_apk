package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  public static final g.a CFd;
  final String description;
  
  static
  {
    AppMethodBeat.i(122944);
    g localg1 = new g("IGNORE", 0, "ignore");
    CEZ = localg1;
    g localg2 = new g("WARN", 1, "warn");
    CFa = localg2;
    g localg3 = new g("STRICT", 2, "strict");
    CFb = localg3;
    CFc = new g[] { localg1, localg2, localg3 };
    CFd = new g.a((byte)0);
    AppMethodBeat.o(122944);
  }
  
  private g(String paramString)
  {
    AppMethodBeat.i(122945);
    this.description = paramString;
    AppMethodBeat.o(122945);
  }
  
  public final boolean eoW()
  {
    return (g)this == CFa;
  }
  
  public final boolean eoX()
  {
    return (g)this == CEZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.n.g
 * JD-Core Version:    0.7.0.1
 */