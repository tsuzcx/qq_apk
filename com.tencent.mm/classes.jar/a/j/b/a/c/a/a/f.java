package a.j.b.a.c.a.a;

import a.aa;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.ad;
import a.j.b.a.c.b.c.p;
import a.j.b.a.c.b.c.p.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
  extends ad
{
  public static final f.a BUN;
  
  static
  {
    AppMethodBeat.i(119164);
    BUN = new f.a((byte)0);
    AppMethodBeat.o(119164);
  }
  
  private f(l paraml, f paramf, b.a parama, boolean paramBoolean)
  {
    super(paraml, paramf, g.a.eeH(), a.j.b.a.c.m.j.CDJ, parama, am.BWF);
    AppMethodBeat.i(119163);
    this.BZF = true;
    this.BZN = paramBoolean;
    so(false);
    AppMethodBeat.o(119163);
  }
  
  private final t fX(List<a.j.b.a.c.f.f> paramList)
  {
    boolean bool = true;
    AppMethodBeat.i(119162);
    int j = this.BZA.size() - paramList.size();
    if ((j == 0) || (j == 1)) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(119162);
      throw paramList;
    }
    Object localObject1 = this.BZA;
    a.f.b.j.p(localObject1, "valueParameters");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      a.j.b.a.c.b.au localau = (a.j.b.a.c.b.au)localIterator.next();
      a.f.b.j.p(localau, "it");
      localObject2 = localau.edF();
      a.f.b.j.p(localObject2, "it.name");
      i = localau.getIndex();
      int k = i - j;
      localObject1 = localObject2;
      if (k >= 0)
      {
        a.j.b.a.c.f.f localf = (a.j.b.a.c.f.f)paramList.get(k);
        localObject1 = localObject2;
        if (localf != null) {
          localObject1 = localf;
        }
      }
      localCollection.add(localau.a((a)this, (a.j.b.a.c.f.f)localObject1, i));
    }
    localObject1 = (List)localCollection;
    Object localObject2 = h(a.j.b.a.c.l.au.CBL);
    paramList = (Iterable)paramList;
    if (!((Collection)paramList).isEmpty())
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        if ((a.j.b.a.c.f.f)paramList.next() == null)
        {
          i = 1;
          label298:
          if (i == 0) {
            break label359;
          }
        }
      }
    }
    for (;;)
    {
      ((p.a)localObject2).Cal = Boolean.valueOf(bool);
      paramList = ((p.a)localObject2).ga((List)localObject1).h((b)efj());
      a.f.b.j.p(paramList, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
      paramList = super.a(paramList);
      if (paramList == null) {
        a.f.b.j.ebi();
      }
      AppMethodBeat.o(119162);
      return paramList;
      i = 0;
      break label298;
      label359:
      break;
      bool = false;
    }
  }
  
  public final p a(l paraml, t paramt, b.a parama, a.j.b.a.c.f.f paramf, g paramg, am paramam)
  {
    AppMethodBeat.i(119161);
    a.f.b.j.q(paraml, "newOwner");
    a.f.b.j.q(parama, "kind");
    a.f.b.j.q(paramg, "annotations");
    a.f.b.j.q(paramam, "source");
    paraml = (p)new f(paraml, (f)paramt, parama, edU());
    AppMethodBeat.o(119161);
    return paraml;
  }
  
  public final t a(p.a parama)
  {
    AppMethodBeat.i(119160);
    a.f.b.j.q(parama, "configuration");
    parama = (f)super.a(parama);
    if (parama == null)
    {
      AppMethodBeat.o(119160);
      return null;
    }
    Object localObject1 = parama.BZA;
    a.f.b.j.p(localObject1, "substituted.valueParameters");
    localObject1 = (Iterable)localObject1;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.j.b.a.c.b.au)((Iterator)localObject1).next();
        a.f.b.j.p(localObject2, "it");
        localObject2 = ((a.j.b.a.c.b.au)localObject2).eer();
        a.f.b.j.p(localObject2, "it.type");
        if (a.j.b.a.c.a.f.k((w)localObject2) != null)
        {
          i = 1;
          label126:
          if (i == 0) {
            break label151;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label158;
      }
      parama = (t)parama;
      AppMethodBeat.o(119160);
      return parama;
      i = 0;
      break label126;
      label151:
      break;
    }
    label158:
    localObject1 = parama.BZA;
    a.f.b.j.p(localObject1, "substituted.valueParameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (a.j.b.a.c.b.au)((Iterator)localObject2).next();
      a.f.b.j.p(localObject3, "it");
      localObject3 = ((a.j.b.a.c.b.au)localObject3).eer();
      a.f.b.j.p(localObject3, "it.type");
      ((Collection)localObject1).add(a.j.b.a.c.a.f.k((w)localObject3));
    }
    parama = parama.fX((List)localObject1);
    AppMethodBeat.o(119160);
    return parama;
  }
  
  public final boolean ecI()
  {
    return false;
  }
  
  public final boolean ecL()
  {
    return false;
  }
  
  public final boolean ecW()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */