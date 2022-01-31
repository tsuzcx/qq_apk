package a.j.b.a.c.l.d;

import a.aa;
import a.f.b.k;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.l;
import a.j.b.a.c.h.c.a;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.at;
import a.j.b.a.c.l.au;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.m;
import a.o;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static final ap a(ap paramap, boolean paramBoolean)
  {
    AppMethodBeat.i(122841);
    if (paramap == null)
    {
      AppMethodBeat.o(122841);
      return null;
    }
    if (paramap.eoN())
    {
      AppMethodBeat.o(122841);
      return paramap;
    }
    w localw = paramap.eer();
    a.f.b.j.p(localw, "typeProjection.type");
    if (!av.b(localw, (a.f.a.b)b.b.CDe))
    {
      AppMethodBeat.o(122841);
      return paramap;
    }
    ba localba = paramap.eoO();
    a.f.b.j.p(localba, "typeProjection.projectionKind");
    if (localba == ba.CBZ)
    {
      paramap = (ap)new a.j.b.a.c.l.ar(localba, (w)aO(localw).CDd);
      AppMethodBeat.o(122841);
      return paramap;
    }
    if (paramBoolean)
    {
      paramap = (ap)new a.j.b.a.c.l.ar(localba, (w)aO(localw).CDc);
      AppMethodBeat.o(122841);
      return paramap;
    }
    paramap = e(paramap);
    AppMethodBeat.o(122841);
    return paramap;
  }
  
  private static final a<d> a(d paramd)
  {
    AppMethodBeat.i(122845);
    Object localObject1 = aO(paramd.CDh);
    w localw1 = (w)((a)localObject1).CDc;
    localObject1 = (w)((a)localObject1).CDd;
    Object localObject2 = aO(paramd.CDi);
    w localw2 = (w)((a)localObject2).CDc;
    localObject2 = (w)((a)localObject2).CDd;
    paramd = new a(new d(paramd.CBA, (w)localObject1, localw2), new d(paramd.CBA, localw1, (w)localObject2));
    AppMethodBeat.o(122845);
    return paramd;
  }
  
  private static final w a(w paramw, List<d> paramList)
  {
    AppMethodBeat.i(122844);
    if (paramw.enR().size() == paramList.size()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramw = (Throwable)new AssertionError("Incorrect type arguments ".concat(String.valueOf(paramList)));
      AppMethodBeat.o(122844);
      throw paramw;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d(paramList));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (d)localIterator.next();
      boolean bool = paramList.eoQ();
      if ((aa.BMh) && (!bool))
      {
        paramw = a.j.b.a.c.h.c.CtD;
        paramw = c.a.h((a.f.a.b)b.d.CDf);
        paramw = (Throwable)new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + paramw.k((l)paramList.CBA) + ": <" + paramw.b(paramList.CDh) + ", " + paramw.b(paramList.CDi) + ">] was found");
        AppMethodBeat.o(122844);
        throw paramw;
      }
      b.e locale = new b.e(paramList);
      if (a.f.b.j.e(paramList.CDh, paramList.CDi)) {
        paramList = (ap)new a.j.b.a.c.l.ar(paramList.CDh);
      }
      for (;;)
      {
        localCollection.add(paramList);
        break;
        if ((g.y(paramList.CDh)) && (paramList.CBA.edG() != ba.CBY)) {
          paramList = (ap)new a.j.b.a.c.l.ar(locale.b(ba.CBZ), paramList.CDi);
        } else if (g.B(paramList.CDi)) {
          paramList = (ap)new a.j.b.a.c.l.ar(locale.b(ba.CBY), paramList.CDh);
        } else {
          paramList = (ap)new a.j.b.a.c.l.ar(locale.b(ba.CBZ), paramList.CDi);
        }
      }
    }
    paramw = at.a(paramw, (List)localCollection, paramw.ecM());
    AppMethodBeat.o(122844);
    return paramw;
  }
  
  public static final a<w> aO(w paramw)
  {
    AppMethodBeat.i(122843);
    a.f.b.j.q(paramw, "type");
    if (t.ai(paramw))
    {
      localObject1 = aO((w)t.ak(paramw));
      localObject2 = aO((w)t.al(paramw));
      paramw = new a(ax.a(x.a(t.ak((w)((a)localObject1).CDc), t.al((w)((a)localObject2).CDc)), paramw), ax.a(x.a(t.ak((w)((a)localObject1).CDd), t.al((w)((a)localObject2).CDd)), paramw));
      AppMethodBeat.o(122843);
      return paramw;
    }
    Object localObject4 = paramw.enU();
    if (a.j.b.a.c.i.a.a.c.ae(paramw))
    {
      if (localObject4 == null)
      {
        paramw = new v("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        AppMethodBeat.o(122843);
        throw paramw;
      }
      localObject3 = ((a.j.b.a.c.i.a.a.b)localObject4).Cwv;
      localObject1 = new a(paramw);
      localObject2 = ((ap)localObject3).eer();
      a.f.b.j.p(localObject2, "typeProjection.type");
      localObject2 = ((a)localObject1).aP((w)localObject2);
      localObject4 = ((ap)localObject3).eoO();
      switch (c.pRV[localObject4.ordinal()])
      {
      default: 
        paramw = (Throwable)new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(122843);
        throw paramw;
      case 1: 
        paramw = a.j.b.a.c.l.c.a.aL(paramw).ecm();
        a.f.b.j.p(paramw, "type.builtIns.nullableAnyType");
        paramw = new a(localObject2, paramw);
        AppMethodBeat.o(122843);
        return paramw;
      }
      paramw = a.j.b.a.c.l.c.a.aL(paramw).eck();
      a.f.b.j.p(paramw, "type.builtIns.nothingType");
      paramw = new a(((a)localObject1).aP((w)paramw), localObject2);
      AppMethodBeat.o(122843);
      return paramw;
    }
    if ((paramw.enR().isEmpty()) || (paramw.enR().size() != ((an)localObject4).getParameters().size()))
    {
      paramw = new a(paramw, paramw);
      AppMethodBeat.o(122843);
      return paramw;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = (Iterable)paramw.enR();
    localObject4 = ((an)localObject4).getParameters();
    a.f.b.j.p(localObject4, "typeConstructor.parameters");
    localObject3 = a.a.j.a((Iterable)localObject3, (Iterable)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (o)((Iterator)localObject3).next();
      localObject4 = (ap)((o)localObject5).first;
      localObject5 = (a.j.b.a.c.b.ar)((o)localObject5).second;
      a.f.b.j.p(localObject5, "typeParameter");
      localObject5 = b((ap)localObject4, (a.j.b.a.c.b.ar)localObject5);
      if (((ap)localObject4).eoN())
      {
        ((ArrayList)localObject1).add(localObject5);
        ((ArrayList)localObject2).add(localObject5);
      }
      else
      {
        localObject5 = a((d)localObject5);
        localObject4 = (d)((a)localObject5).CDc;
        localObject5 = (d)((a)localObject5).CDd;
        ((ArrayList)localObject1).add(localObject4);
        ((ArrayList)localObject2).add(localObject5);
      }
    }
    localObject3 = (Iterable)localObject1;
    int i;
    if (!((Collection)localObject3).isEmpty())
    {
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext()) {
        if (!((d)((Iterator)localObject3).next()).eoQ())
        {
          i = 1;
          label630:
          if (i == 0) {
            break label688;
          }
          i = 1;
          label636:
          if (i == 0) {
            break label695;
          }
          localObject1 = a.j.b.a.c.l.c.a.aL(paramw).eck();
          a.f.b.j.p(localObject1, "type.builtIns.nothingType");
        }
      }
    }
    label688:
    label695:
    for (localObject1 = (w)localObject1;; localObject1 = a(paramw, (List)localObject1))
    {
      paramw = new a(localObject1, a(paramw, (List)localObject2));
      AppMethodBeat.o(122843);
      return paramw;
      i = 0;
      break label630;
      break;
      i = 0;
      break label636;
    }
  }
  
  private static final d b(ap paramap, a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(122840);
    Object localObject = au.a(paramar.edG(), paramap);
    switch (c.bLo[localObject.ordinal()])
    {
    default: 
      paramap = new m();
      AppMethodBeat.o(122840);
      throw paramap;
    case 1: 
      localObject = paramap.eer();
      a.f.b.j.p(localObject, "type");
      paramap = paramap.eer();
      a.f.b.j.p(paramap, "type");
      paramap = new d(paramar, (w)localObject, paramap);
      AppMethodBeat.o(122840);
      return paramap;
    case 2: 
      paramap = paramap.eer();
      a.f.b.j.p(paramap, "type");
      localObject = a.j.b.a.c.i.c.a.G((l)paramar).ecm();
      a.f.b.j.p(localObject, "typeParameter.builtIns.nullableAnyType");
      paramap = new d(paramar, paramap, (w)localObject);
      AppMethodBeat.o(122840);
      return paramap;
    }
    localObject = a.j.b.a.c.i.c.a.G((l)paramar).eck();
    a.f.b.j.p(localObject, "typeParameter.builtIns.nothingType");
    localObject = (w)localObject;
    paramap = paramap.eer();
    a.f.b.j.p(paramap, "type");
    paramap = new d(paramar, (w)localObject, paramap);
    AppMethodBeat.o(122840);
    return paramap;
  }
  
  private static final ap e(ap paramap)
  {
    AppMethodBeat.i(122842);
    au localau = au.d((as)new b.c());
    a.f.b.j.p(localau, "TypeSubstitutor.create(o…ojection\n        }\n    })");
    paramap = localau.d(paramap);
    AppMethodBeat.o(122842);
    return paramap;
  }
  
  static final class a
    extends k
    implements a.f.a.b<w, w>
  {
    a(w paramw)
    {
      super();
    }
    
    public final w aP(w paramw)
    {
      AppMethodBeat.i(122832);
      a.f.b.j.q(paramw, "receiver$0");
      paramw = av.b(paramw, this.CwE.egH());
      a.f.b.j.p(paramw, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
      AppMethodBeat.o(122832);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.l.d.b
 * JD-Core Version:    0.7.0.1
 */