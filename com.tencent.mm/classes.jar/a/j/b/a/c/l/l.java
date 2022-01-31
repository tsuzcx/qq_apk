package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends as
{
  public static final l.a CBa;
  private final as CAY;
  private final as CAZ;
  
  static
  {
    AppMethodBeat.i(122524);
    CBa = new l.a((byte)0);
    AppMethodBeat.o(122524);
  }
  
  private l(as paramas1, as paramas2)
  {
    this.CAY = paramas1;
    this.CAZ = paramas2;
  }
  
  public static final as a(as paramas1, as paramas2)
  {
    AppMethodBeat.i(122525);
    j.q(paramas1, "first");
    j.q(paramas2, "second");
    if (paramas1.isEmpty())
    {
      AppMethodBeat.o(122525);
      return paramas2;
    }
    if (paramas2.isEmpty())
    {
      AppMethodBeat.o(122525);
      return paramas1;
    }
    paramas1 = (as)new l(paramas1, paramas2, (byte)0);
    AppMethodBeat.o(122525);
    return paramas1;
  }
  
  public final ap O(w paramw)
  {
    AppMethodBeat.i(122519);
    j.q(paramw, "key");
    ap localap2 = this.CAY.O(paramw);
    ap localap1 = localap2;
    if (localap2 == null) {
      localap1 = this.CAZ.O(paramw);
    }
    AppMethodBeat.o(122519);
    return localap1;
  }
  
  public final w a(w paramw, ba paramba)
  {
    AppMethodBeat.i(122520);
    j.q(paramw, "topLevelType");
    j.q(paramba, "position");
    paramw = this.CAZ.a(this.CAY.a(paramw, paramba), paramba);
    AppMethodBeat.o(122520);
    return paramw;
  }
  
  public final boolean enV()
  {
    AppMethodBeat.i(122522);
    if ((this.CAY.enV()) || (this.CAZ.enV()))
    {
      AppMethodBeat.o(122522);
      return true;
    }
    AppMethodBeat.o(122522);
    return false;
  }
  
  public final boolean eoG()
  {
    AppMethodBeat.i(122521);
    if ((this.CAY.eoG()) || (this.CAZ.eoG()))
    {
      AppMethodBeat.o(122521);
      return true;
    }
    AppMethodBeat.o(122521);
    return false;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(122523);
    j.q(paramg, "annotations");
    paramg = this.CAZ.h(this.CAY.h(paramg));
    AppMethodBeat.o(122523);
    return paramg;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.l.l
 * JD-Core Version:    0.7.0.1
 */