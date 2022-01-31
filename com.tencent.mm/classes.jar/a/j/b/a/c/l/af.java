package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af
  extends i
  implements aw
{
  private final w CBs;
  private final ad Chy;
  
  public af(ad paramad, w paramw)
  {
    AppMethodBeat.i(122627);
    this.Chy = paramad;
    this.CBs = paramw;
    AppMethodBeat.o(122627);
  }
  
  public final ad d(g paramg)
  {
    AppMethodBeat.i(122623);
    j.q(paramg, "newAnnotations");
    paramg = ax.b(((az)this.Chy).b(paramg), this.CBs);
    if (paramg == null)
    {
      paramg = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(122623);
      throw paramg;
    }
    paramg = (ad)paramg;
    AppMethodBeat.o(122623);
    return paramg;
  }
  
  protected final ad efX()
  {
    return this.Chy;
  }
  
  public final az eoI()
  {
    return (az)this.Chy;
  }
  
  public final w eoJ()
  {
    return this.CBs;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122625);
    Object localObject = ax.b(((az)this.Chy).sr(paramBoolean), (w)this.CBs.eoL().sr(paramBoolean));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(122625);
      throw ((Throwable)localObject);
    }
    localObject = (ad)localObject;
    AppMethodBeat.o(122625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.af
 * JD-Core Version:    0.7.0.1
 */