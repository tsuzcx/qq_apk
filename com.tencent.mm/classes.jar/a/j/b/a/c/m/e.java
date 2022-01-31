package a.j.b.a.c.m;

import a.j.b.a.c.a.i;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.t;
import a.j.b.a.c.l.ah;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class e
  implements b
{
  public static final e CDs;
  private static final String description = "second parameter must be of type KProperty<*> or its supertype";
  
  static
  {
    AppMethodBeat.i(122865);
    CDs = new e();
    description = "second parameter must be of type KProperty<*> or its supertype";
    AppMethodBeat.o(122865);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(t paramt)
  {
    AppMethodBeat.i(122864);
    a.f.b.j.q(paramt, "functionDescriptor");
    Object localObject1 = (au)paramt.edu().get(1);
    paramt = i.BUb;
    a.f.b.j.p(localObject1, "secondParameter");
    paramt = a.j.b.a.c.i.c.a.F((l)localObject1);
    a.f.b.j.q(paramt, "module");
    Object localObject2 = a.j.b.a.c.a.g.BRU.BTk;
    a.f.b.j.p(localObject2, "KotlinBuiltIns.FQ_NAMES.kProperty");
    paramt = s.a(paramt, (a.j.b.a.c.f.a)localObject2);
    if (paramt == null) {}
    Object localObject3;
    for (paramt = null; paramt != null; paramt = (w)x.a((a.j.b.a.c.b.a.g)localObject2, paramt, a.a.j.listOf(new ah((ar)localObject3))))
    {
      localObject1 = ((au)localObject1).eer();
      a.f.b.j.p(localObject1, "secondParameter.type");
      boolean bool = a.j.b.a.c.l.c.a.c(paramt, a.j.b.a.c.l.c.a.aA((w)localObject1));
      AppMethodBeat.o(122864);
      return bool;
      localObject2 = a.j.b.a.c.b.a.g.BXx;
      localObject2 = a.j.b.a.c.b.a.g.a.eeH();
      localObject3 = paramt.ecx();
      a.f.b.j.p(localObject3, "kPropertyClass.typeConstructor");
      localObject3 = ((an)localObject3).getParameters();
      a.f.b.j.p(localObject3, "kPropertyClass.typeConstructor.parameters");
      localObject3 = a.a.j.fU((List)localObject3);
      a.f.b.j.p(localObject3, "kPropertyClass.typeConstructor.parameters.single()");
    }
    AppMethodBeat.o(122864);
    return false;
  }
  
  public final String i(t paramt)
  {
    AppMethodBeat.i(122866);
    a.f.b.j.q(paramt, "functionDescriptor");
    paramt = b.a.a(this, paramt);
    AppMethodBeat.o(122866);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.m.e
 * JD-Core Version:    0.7.0.1
 */