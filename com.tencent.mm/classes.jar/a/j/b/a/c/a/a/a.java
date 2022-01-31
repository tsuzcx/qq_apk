package a.j.b.a.c.a.a;

import a.a.x;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.f;
import a.j.b.a.c.k.i;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  implements a.j.b.a.c.b.b.b
{
  public static final a.a BUw;
  private final i BRT;
  private final y BUv;
  
  static
  {
    AppMethodBeat.i(119134);
    BUw = new a.a((byte)0);
    AppMethodBeat.o(119134);
  }
  
  public a(i parami, y paramy)
  {
    AppMethodBeat.i(119133);
    this.BRT = parami;
    this.BUv = paramy;
    AppMethodBeat.o(119133);
  }
  
  public final boolean a(a.j.b.a.c.f.b paramb, f paramf)
  {
    AppMethodBeat.i(119130);
    a.f.b.j.q(paramb, "packageFqName");
    a.f.b.j.q(paramf, "name");
    paramf = paramf.name;
    a.f.b.j.p(paramf, "name.asString()");
    if (((m.jw(paramf, "Function")) || (m.jw(paramf, "KFunction")) || (m.jw(paramf, "SuspendFunction")) || (m.jw(paramf, "KSuspendFunction"))) && (a.a.a(paramf, paramb) != null))
    {
      AppMethodBeat.o(119130);
      return true;
    }
    AppMethodBeat.o(119130);
    return false;
  }
  
  public final Collection<e> d(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119132);
    a.f.b.j.q(paramb, "packageFqName");
    paramb = (Collection)x.BMz;
    AppMethodBeat.o(119132);
    return paramb;
  }
  
  public final e e(a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(119131);
    a.f.b.j.q(parama, "classId");
    if ((parama.CqC) || (parama.emb()))
    {
      AppMethodBeat.o(119131);
      return null;
    }
    Object localObject2 = parama.CqB.CqE.CqJ;
    a.f.b.j.p(localObject2, "classId.relativeClassName.asString()");
    if (!m.a((CharSequence)localObject2, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(119131);
      return null;
    }
    Object localObject1 = parama.BUK;
    a.f.b.j.p(localObject1, "classId.packageFqName");
    localObject2 = a.a.a((String)localObject2, (a.j.b.a.c.f.b)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(119131);
      return null;
    }
    parama = ((a.b)localObject2).BUx;
    int i = ((a.b)localObject2).BNe;
    localObject2 = (Iterable)this.BUv.g((a.j.b.a.c.f.b)localObject1).getFragments();
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof a.j.b.a.c.a.c)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (a.j.b.a.c.a.c)a.a.j.fQ((List)localObject1);
    parama = (e)new b(this.BRT, (ab)localObject1, parama, i);
    AppMethodBeat.o(119131);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */