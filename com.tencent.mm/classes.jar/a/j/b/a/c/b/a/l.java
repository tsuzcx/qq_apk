package a.j.b.a.c.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class l
  implements g
{
  private final g BXJ;
  private final a.f.a.b<a.j.b.a.c.f.b, Boolean> BXK;
  
  public l(g paramg, a.f.a.b<? super a.j.b.a.c.f.b, Boolean> paramb)
  {
    AppMethodBeat.i(119362);
    this.BXJ = paramg;
    this.BXK = paramb;
    AppMethodBeat.o(119362);
  }
  
  private final boolean c(c paramc)
  {
    AppMethodBeat.i(119361);
    paramc = paramc.eee();
    if ((paramc != null) && (((Boolean)this.BXK.S(paramc)).booleanValue()))
    {
      AppMethodBeat.o(119361);
      return true;
    }
    AppMethodBeat.o(119361);
    return false;
  }
  
  public final c i(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119358);
    j.q(paramb, "fqName");
    if (((Boolean)this.BXK.S(paramb)).booleanValue())
    {
      paramb = this.BXJ.i(paramb);
      AppMethodBeat.o(119358);
      return paramb;
    }
    AppMethodBeat.o(119358);
    return null;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(119360);
    Object localObject = (Iterable)this.BXJ;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (((l)this).c(localc))
        {
          AppMethodBeat.o(119360);
          return true;
        }
      }
    }
    AppMethodBeat.o(119360);
    return false;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(119359);
    Object localObject2 = (Iterable)this.BXJ;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      c localc = (c)localObject3;
      if (((l)this).c(localc)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    AppMethodBeat.o(119359);
    return localObject1;
  }
  
  public final boolean j(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119357);
    j.q(paramb, "fqName");
    if (((Boolean)this.BXK.S(paramb)).booleanValue())
    {
      boolean bool = this.BXJ.j(paramb);
      AppMethodBeat.o(119357);
      return bool;
    }
    AppMethodBeat.o(119357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.b.a.l
 * JD-Core Version:    0.7.0.1
 */