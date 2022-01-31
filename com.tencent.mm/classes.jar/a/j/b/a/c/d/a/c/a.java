package a.j.b.a.c.d.a.c;

import a.f;
import a.f.b.j;
import a.j.b.a.c.b.a.c;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.d.a.e.x;
import a.j.b.a.c.n.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final d a(h paramh, a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(119818);
    j.q(paramh, "receiver$0");
    j.q(paramg, "additionalAnnotations");
    if (paramh.Cfj.CeS.tXR)
    {
      paramh = paramh.efL();
      AppMethodBeat.o(119818);
      return paramh;
    }
    paramg = (Iterable)paramg;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = paramg.iterator();
    Object localObject4;
    label118:
    int i;
    label205:
    label350:
    while (((Iterator)localObject3).hasNext())
    {
      c localc1 = (c)((Iterator)localObject3).next();
      localObject4 = paramh.Cfj.CeS;
      j.q(localc1, "annotationDescriptor");
      if (((a.j.b.a.c.d.a.a)localObject4).CbS.eoV())
      {
        paramg = null;
        localObject1 = paramg;
        if (paramg == null)
        {
          paramg = ((a.j.b.a.c.d.a.a)localObject4).e(localc1);
          if (paramg != null) {
            break label254;
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label350;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        paramg = (k)a.j.b.a.c.d.a.b.efq().get(localc1.eee());
        if (paramg != null)
        {
          localObject1 = paramg.Cfq;
          localObject5 = paramg.Cfr;
          paramg = ((a.j.b.a.c.d.a.a)localObject4).f(localc1);
          if (paramg != a.j.b.a.c.n.g.CEZ)
          {
            i = 1;
            if (i == 0) {
              break label223;
            }
          }
          for (;;)
          {
            if (paramg != null) {
              break label228;
            }
            paramg = null;
            break;
            i = 0;
            break label205;
            label223:
            paramg = null;
          }
          label228:
          paramg = new k(a.j.b.a.c.d.a.f.h.a((a.j.b.a.c.d.a.f.h)localObject1, paramg.eoW()), (Collection)localObject5);
          break label118;
        }
        paramg = null;
        break label118;
        label254:
        c localc2 = paramg.CbY;
        Object localObject5 = paramg.efo();
        localObject1 = ((a.j.b.a.c.d.a.a)localObject4).g(localc1);
        paramg = (a.j.b.a.c.b.a.g)localObject1;
        if (localObject1 == null) {
          paramg = ((a.j.b.a.c.d.a.a)localObject4).f(localc2);
        }
        if (paramg.eoX())
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = paramh.Cfj.CeT.i(localc2);
          if (localObject1 != null)
          {
            paramg = a.j.b.a.c.d.a.f.h.a((a.j.b.a.c.d.a.f.h)localObject1, paramg.eoW());
            if (paramg != null) {}
          }
          else
          {
            localObject1 = null;
            continue;
          }
          localObject1 = new k(paramg, (Collection)localObject5);
        }
      }
    }
    Object localObject1 = (List)localObject2;
    if (((List)localObject1).isEmpty())
    {
      paramh = paramh.efL();
      AppMethodBeat.o(119818);
      return paramh;
    }
    paramg = paramh.efL();
    if (paramg != null)
    {
      paramg = paramg.CeZ;
      if (paramg != null)
      {
        paramg = new EnumMap(paramg);
        localObject1 = ((List)localObject1).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label511;
      }
      localObject3 = (k)((Iterator)localObject1).next();
      localObject2 = ((k)localObject3).Cfq;
      localObject3 = ((k)localObject3).Cfr.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (a.a)((Iterator)localObject3).next();
          ((Map)paramg).put(localObject4, localObject2);
          i = 1;
          continue;
          paramg = new EnumMap(a.a.class);
          break;
        }
      }
    }
    label511:
    if (i == 0)
    {
      paramh = paramh.efL();
      AppMethodBeat.o(119818);
      return paramh;
    }
    paramh = new d(paramg);
    AppMethodBeat.o(119818);
    return paramh;
  }
  
  public static final h a(h paramh, a.j.b.a.c.b.l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(119820);
    j.q(paramh, "receiver$0");
    j.q(paraml, "containingDeclaration");
    j.q(paramx, "typeParameterOwner");
    paramh = a(paramh, paraml, paramx, paramInt, paramh.Cfl);
    AppMethodBeat.o(119820);
    return paramh;
  }
  
  private static final h a(h paramh, a.j.b.a.c.b.l paraml, x paramx, int paramInt, f<d> paramf)
  {
    AppMethodBeat.i(119819);
    b localb = paramh.Cfj;
    if (paramx != null) {}
    for (paramh = (m)new i(paramh, paraml, paramx, paramInt);; paramh = paramh.Cfk)
    {
      paramh = new h(localb, paramh, paramf);
      AppMethodBeat.o(119819);
      return paramh;
    }
  }
  
  public static final h b(h paramh, a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(119822);
    j.q(paramh, "receiver$0");
    j.q(paramg, "additionalAnnotations");
    if (paramg.isEmpty())
    {
      AppMethodBeat.o(119822);
      return paramh;
    }
    paramh = new h(paramh.Cfj, paramh.Cfk, a.g.a(a.k.BLV, (a.f.a.a)new a.b(paramh, paramg)));
    AppMethodBeat.o(119822);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */