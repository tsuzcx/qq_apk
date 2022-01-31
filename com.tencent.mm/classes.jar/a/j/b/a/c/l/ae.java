package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ae
  extends ad
{
  private final List<ap> BWD;
  private final an CBb;
  private final h Caq;
  private final boolean Cwx;
  
  public ae(an paraman, List<? extends ap> paramList, boolean paramBoolean, h paramh)
  {
    AppMethodBeat.i(122622);
    this.CBb = paraman;
    this.BWD = paramList;
    this.Cwx = paramBoolean;
    this.Caq = paramh;
    if ((this.Caq instanceof p.b))
    {
      paraman = (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.Caq + '\n' + this.CBb);
      AppMethodBeat.o(122622);
      throw paraman;
    }
    AppMethodBeat.o(122622);
  }
  
  public final ad d(g paramg)
  {
    AppMethodBeat.i(122618);
    a.f.b.j.q(paramg, "newAnnotations");
    if (paramg.isEmpty())
    {
      paramg = (ad)this;
      AppMethodBeat.o(122618);
      return paramg;
    }
    paramg = (ad)new d((ad)this, paramg);
    AppMethodBeat.o(122618);
    return paramg;
  }
  
  public final g ecM()
  {
    AppMethodBeat.i(122617);
    Object localObject = g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(122617);
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
    return this.BWD;
  }
  
  public final an enU()
  {
    return this.CBb;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122620);
    Object localObject;
    if (paramBoolean == this.Cwx) {
      localObject = this;
    }
    for (;;)
    {
      localObject = (ad)localObject;
      AppMethodBeat.o(122620);
      return localObject;
      if (paramBoolean) {
        localObject = (j)new ab((ad)this);
      } else {
        localObject = (j)new aa((ad)this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.l.ae
 * JD-Core Version:    0.7.0.1
 */