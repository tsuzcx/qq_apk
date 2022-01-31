package a.j.b.a;

import a.f.a.a;
import a.f.b.k;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.e;
import a.j.b.a.c.d.a.o;
import a.j.b.a.c.e.b.a.f.a;
import a.j.b.a.c.e.b.a.j;
import a.l;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
final class s$f
  extends k
  implements a<Field>
{
  s$f(s params)
  {
    super(0);
  }
  
  private Field ebS()
  {
    Object localObject3 = null;
    AppMethodBeat.i(118863);
    Object localObject1 = ad.BQq;
    localObject1 = ad.c(this.BPQ.ebO());
    ah localah;
    Object localObject4;
    if ((localObject1 instanceof d.c))
    {
      localah = ((d.c)localObject1).BNZ;
      localObject4 = j.Cqr;
      localObject4 = j.a(((d.c)localObject1).BOa, ((d.c)localObject1).BOc, ((d.c)localObject1).BOd);
      if (localObject4 != null) {
        if ((o.d(localah)) || (j.f(((d.c)localObject1).BOa))) {
          localObject1 = this.BPQ.BPf.ebg().getEnclosingClass();
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {}
      try
      {
        for (localObject1 = ((Class)localObject1).getDeclaredField(((f.a)localObject4).name);; localObject1 = null)
        {
          AppMethodBeat.o(118863);
          return localObject1;
          localObject1 = localah.ecv();
          if ((localObject1 instanceof e))
          {
            localObject1 = af.a((e)localObject1);
            break;
          }
          localObject1 = this.BPQ.BPf.ebg();
          break;
        }
        AppMethodBeat.o(118863);
        return null;
        if ((localObject1 instanceof d.a))
        {
          localObject1 = ((d.a)localObject1).erN;
          AppMethodBeat.o(118863);
          return localObject1;
        }
        if ((localObject1 instanceof d.b))
        {
          AppMethodBeat.o(118863);
          return null;
        }
        if ((localObject1 instanceof d.d))
        {
          AppMethodBeat.o(118863);
          return null;
        }
        localObject1 = new m();
        AppMethodBeat.o(118863);
        throw ((Throwable)localObject1);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.s.f
 * JD-Core Version:    0.7.0.1
 */