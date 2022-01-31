package a.j.b.a.c.l;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class aj
  extends ad
{
  private final an CBD;
  private final an CBb;
  private final h Caq;
  private final boolean Cwx;
  
  private aj(an paraman1, boolean paramBoolean, an paraman2, h paramh)
  {
    AppMethodBeat.i(122643);
    this.CBD = paraman1;
    this.Cwx = paramBoolean;
    this.CBb = paraman2;
    this.Caq = paramh;
    AppMethodBeat.o(122643);
  }
  
  public final ad d(g paramg)
  {
    AppMethodBeat.i(122638);
    j.q(paramg, "newAnnotations");
    paramg = (Throwable)new IllegalStateException("Shouldn't be called on non-fixed type".toString());
    AppMethodBeat.o(122638);
    throw paramg;
  }
  
  public final g ecM()
  {
    AppMethodBeat.i(122637);
    Object localObject = g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(122637);
    return localObject;
  }
  
  public final h ecq()
  {
    return this.Caq;
  }
  
  public final boolean egH()
  {
    return this.Cwx;
  }
  
  public final List<ap> enR()
  {
    return (List)v.BMx;
  }
  
  public final an enU()
  {
    return this.CBb;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122640);
    if (paramBoolean == this.Cwx)
    {
      localad = (ad)this;
      AppMethodBeat.o(122640);
      return localad;
    }
    ad localad = (ad)new aj(this.CBD, paramBoolean, this.CBb, this.Caq);
    AppMethodBeat.o(122640);
    return localad;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122642);
    String str = "NonFixed: " + this.CBD;
    AppMethodBeat.o(122642);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.aj
 * JD-Core Version:    0.7.0.1
 */