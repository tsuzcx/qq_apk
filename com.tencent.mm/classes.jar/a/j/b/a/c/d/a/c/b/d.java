package a.j.b.a.c.d.a.c.b;

import a.j.b.a.c.b.e;
import a.j.b.a.c.d.a.a.l;
import a.j.b.a.c.f.b;
import a.j.b.a.c.l.ah;
import a.j.b.a.c.l.ai;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d
{
  private static final b Cha;
  
  static
  {
    AppMethodBeat.i(120055);
    Cha = new b("java.lang.Class");
    AppMethodBeat.o(120055);
  }
  
  public static final ap a(a.j.b.a.c.b.ar paramar, a parama)
  {
    AppMethodBeat.i(120051);
    a.f.b.j.q(paramar, "typeParameter");
    a.f.b.j.q(parama, "attr");
    if (parama.CgK == l.Cej)
    {
      paramar = (ap)new a.j.b.a.c.l.ar(ai.d(paramar));
      AppMethodBeat.o(120051);
      return paramar;
    }
    paramar = (ap)new ah(paramar);
    AppMethodBeat.o(120051);
    return paramar;
  }
  
  public static final w a(a.j.b.a.c.b.ar paramar1, a.j.b.a.c.b.ar paramar2, a.f.a.a<? extends w> parama)
  {
    AppMethodBeat.i(120053);
    a.f.b.j.q(paramar1, "receiver$0");
    a.f.b.j.q(parama, "defaultValue");
    if (paramar1 == paramar2)
    {
      paramar1 = (w)parama.invoke();
      AppMethodBeat.o(120053);
      return paramar1;
    }
    Object localObject = paramar1.ebo();
    a.f.b.j.p(localObject, "upperBounds");
    localObject = (w)a.a.j.fQ((List)localObject);
    if ((((w)localObject).enU().ecR() instanceof e))
    {
      a.f.b.j.p(localObject, "firstUpperBound");
      paramar1 = a.j.b.a.c.l.c.a.aN((w)localObject);
      AppMethodBeat.o(120053);
      return paramar1;
    }
    if (paramar2 == null) {}
    for (;;)
    {
      paramar2 = ((w)localObject).enU().ecR();
      if (paramar2 == null)
      {
        paramar1 = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        AppMethodBeat.o(120053);
        throw paramar1;
      }
      for (paramar2 = (a.j.b.a.c.b.ar)paramar2; (a.f.b.j.e(paramar2, paramar1) ^ true); paramar2 = (a.j.b.a.c.b.ar)paramar2)
      {
        paramar2 = paramar2.ebo();
        a.f.b.j.p(paramar2, "current.upperBounds");
        paramar2 = (w)a.a.j.fQ(paramar2);
        if ((paramar2.enU().ecR() instanceof e))
        {
          a.f.b.j.p(paramar2, "nextUpperBound");
          paramar1 = a.j.b.a.c.l.c.a.aN(paramar2);
          AppMethodBeat.o(120053);
          return paramar1;
        }
        paramar2 = paramar2.enU().ecR();
        if (paramar2 == null)
        {
          paramar1 = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
          AppMethodBeat.o(120053);
          throw paramar1;
        }
      }
      paramar1 = (w)parama.invoke();
      AppMethodBeat.o(120053);
      return paramar1;
      paramar1 = paramar2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */