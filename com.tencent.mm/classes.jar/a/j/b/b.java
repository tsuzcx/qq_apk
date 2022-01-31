package a.j.b;

import a.f.a.m;
import a.j.b.a.af;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.t;
import a.j.b.a.c.e.a.ag;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.b.a.g;
import a.j.b.a.c.g.q;
import a.j.b.a.i;
import a.j.e;
import a.l;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflect-api"})
public final class b
{
  public static final <R> e<R> a(a.c<? extends R> paramc)
  {
    AppMethodBeat.i(118659);
    a.f.b.j.q(paramc, "receiver$0");
    Object localObject2 = (l)paramc.getClass().getAnnotation(l.class);
    if (localObject2 == null)
    {
      AppMethodBeat.o(118659);
      return null;
    }
    Object localObject1 = ((l)localObject2).eaP();
    int i;
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label72;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label77;
      }
      AppMethodBeat.o(118659);
      return null;
      i = 0;
      break;
      label72:
      localObject1 = null;
    }
    label77:
    Object localObject3 = a.j.b.a.c.e.b.a.j.f((String[])localObject1, ((l)localObject2).eaQ());
    localObject1 = (a.j.b.a.c.e.b.a.h)((o)localObject3).first;
    localObject3 = (a.o)((o)localObject3).second;
    Object localObject4 = ((l)localObject2).eaO();
    if ((((l)localObject2).eaR() & 0x8) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new g((int[])localObject4, bool);
      paramc = paramc.getClass();
      localObject4 = (q)localObject3;
      localObject1 = (a.j.b.a.c.e.a.c)localObject1;
      localObject3 = ((a.o)localObject3).Clq;
      a.f.b.j.p(localObject3, "proto.typeTable");
      paramc = (al)af.a(paramc, (q)localObject4, (a.j.b.a.c.e.a.c)localObject1, new a.j.b.a.c.e.a.h((a.ag)localObject3), (a.j.b.a.c.e.a.a)localObject2, (m)b.a.BNP);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(118659);
      return null;
    }
    paramc = (e)new a.j.b.a.j((i)a.j.b.a.a.BNQ, (t)paramc);
    AppMethodBeat.o(118659);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.b
 * JD-Core Version:    0.7.0.1
 */