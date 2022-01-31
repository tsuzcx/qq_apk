package a.j.b.a.c.d.a.c.a;

import a.a.v;
import a.a.x;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.d.a.e.aa;
import a.j.b.a.c.d.a.e.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class j
  extends m
{
  private final t Cgh;
  private final a.j.b.a.c.k.g<Set<String>> Cgj;
  private final a.j.b.a.c.k.d<j.a, e> Cgk;
  final h Cgl;
  
  public j(a.j.b.a.c.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(119984);
    this.Cgh = paramt;
    this.Cgl = paramh1;
    this.Cgj = paramh.Cfj.BRT.m((a.f.a.a)new j.d(this, paramh));
    this.Cgk = paramh.Cfj.BRT.j((a.f.a.b)new j.c(this, paramh));
    AppMethodBeat.o(119984);
  }
  
  final e a(f paramf, a.j.b.a.c.d.a.e.g paramg)
  {
    AppMethodBeat.i(119977);
    if (!a.j.b.a.c.f.h.x(paramf))
    {
      AppMethodBeat.o(119977);
      return null;
    }
    Set localSet = (Set)this.Cgj.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.name)))
    {
      AppMethodBeat.o(119977);
      return null;
    }
    paramf = (e)this.Cgk.S(new j.a(paramf, paramg));
    AppMethodBeat.o(119977);
    return paramf;
  }
  
  public final Collection<ah> a(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119978);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    paramf = (Collection)v.BMx;
    AppMethodBeat.o(119978);
    return paramf;
  }
  
  public final Collection<l> a(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(119983);
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    paramd = (Collection)a(paramd, paramb, (a.j.b.a.c.c.a.a)c.CbF);
    AppMethodBeat.o(119983);
    return paramd;
  }
  
  protected final Set<f> a(a.j.b.a.c.i.e.d paramd)
  {
    AppMethodBeat.i(119982);
    a.f.b.j.q(paramd, "kindFilter");
    paramd = (Set)x.BMz;
    AppMethodBeat.o(119982);
    return paramd;
  }
  
  protected final void a(Collection<al> paramCollection, f paramf)
  {
    AppMethodBeat.i(119981);
    a.f.b.j.q(paramCollection, "result");
    a.f.b.j.q(paramf, "name");
    AppMethodBeat.o(119981);
  }
  
  protected final Set<f> b(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(119980);
    a.f.b.j.q(paramd, "kindFilter");
    paramd = (Set)x.BMz;
    AppMethodBeat.o(119980);
    return paramd;
  }
  
  protected final Set<f> c(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(119979);
    a.f.b.j.q(paramd, "kindFilter");
    Object localObject = a.j.b.a.c.i.e.d.CxM;
    if (!paramd.VQ(a.j.b.a.c.i.e.d.eob()))
    {
      paramd = (Set)x.BMz;
      AppMethodBeat.o(119979);
      return paramd;
    }
    paramd = (Set)this.Cgj.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(f.ayT((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(119979);
      return paramd;
    }
    localObject = this.Cgh;
    paramd = paramb;
    if (paramb == null) {
      paramd = a.j.b.a.c.n.d.eoS();
    }
    paramd = (Iterable)((t)localObject).g(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label219:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (a.j.b.a.c.d.a.e.g)((Iterator)localObject).next();
      if (aa.Chj == null) {}
      for (paramd = null;; paramd = paramd.edF())
      {
        if (paramd == null) {
          break label219;
        }
        paramb.add(paramd);
        break;
      }
    }
    paramd = (Set)paramb;
    AppMethodBeat.o(119979);
    return paramd;
  }
  
  public final e e(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119975);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    paramf = a(paramf, null);
    AppMethodBeat.o(119975);
    return paramf;
  }
  
  protected final b efS()
  {
    return (b)b.a.CfA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */