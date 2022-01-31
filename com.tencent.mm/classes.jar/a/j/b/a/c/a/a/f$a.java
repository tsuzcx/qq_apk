package a.j.b.a.c.a.a;

import a.a.y;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.ai;
import a.j.b.a.c.b.l;
import a.j.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f$a
{
  public static f a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(119158);
    a.f.b.j.q(paramb, "functionClass");
    List localList1 = paramb.parameters;
    f localf = new f((l)paramb, b.a.BVX, paramBoolean);
    paramb = paramb.edK();
    List localList2 = (List)a.a.v.BMx;
    Object localObject2 = (Iterable)localList1;
    Object localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((ar)localObject3).edG() == ba.CBY) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label127;
        }
        ((ArrayList)localObject1).add(localObject3);
        break;
      }
    }
    label127:
    localObject2 = a.a.j.p((Iterable)localObject1);
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (y)((Iterator)localObject2).next();
      a locala = f.BUN;
      ((Collection)localObject1).add(a(localf, ((y)localObject3).index, (ar)((y)localObject3).value));
    }
    localf.b(null, paramb, localList2, (List)localObject1, (a.j.b.a.c.l.w)((ar)a.a.j.fS(localList1)).edE(), a.j.b.a.c.b.w.BWs, ay.BWO);
    localf.sp(true);
    AppMethodBeat.o(119158);
    return localf;
  }
  
  private static au a(f paramf, int paramInt, ar paramar)
  {
    AppMethodBeat.i(119159);
    Object localObject1 = paramar.edF().name;
    a.f.b.j.p(localObject1, "typeParameter.name.asString()");
    switch (((String)localObject1).hashCode())
    {
    default: 
    case 84: 
      while (localObject1 == null)
      {
        paramf = new a.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119159);
        throw paramf;
        if (((String)localObject1).equals("T")) {
          localObject1 = "instance";
        }
      }
    }
    for (;;)
    {
      paramf = (a)paramf;
      Object localObject2 = g.BXx;
      localObject2 = g.a.eeH();
      localObject1 = a.j.b.a.c.f.f.ayT((String)localObject1);
      a.f.b.j.p(localObject1, "Name.identifier(name)");
      paramar = paramar.edE();
      a.f.b.j.p(paramar, "typeParameter.defaultType");
      paramar = (a.j.b.a.c.l.w)paramar;
      am localam = am.BWF;
      a.f.b.j.p(localam, "SourceElement.NO_SOURCE");
      paramf = (au)new ai(paramf, null, paramInt, (g)localObject2, (a.j.b.a.c.f.f)localObject1, paramar, false, false, false, null, localam);
      AppMethodBeat.o(119159);
      return paramf;
      if (!((String)localObject1).equals("E")) {
        break;
      }
      localObject1 = "receiver";
      continue;
      localObject1 = ((String)localObject1).toLowerCase();
      a.f.b.j.p(localObject1, "(this as java.lang.String).toLowerCase()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */