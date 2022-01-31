package a.j.b.a.c.d.a;

import a.f.b.j;
import a.f.b.k;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.a.q;
import a.j.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;

public final class t
{
  static final a.j.b.a.c.f.b a(a.j.b.a.c.f.b paramb, String paramString)
  {
    AppMethodBeat.i(119733);
    paramb = paramb.q(f.ayT(paramString));
    j.p(paramb, "child(Name.identifier(name))");
    AppMethodBeat.o(119733);
    return paramb;
  }
  
  public static final boolean a(a.j.b.a.c.b.e parame, a.j.b.a.c.b.a parama)
  {
    AppMethodBeat.i(119741);
    j.q(parame, "receiver$0");
    j.q(parama, "specialCallableDescriptor");
    parama = parama.ecv();
    if (parama == null)
    {
      parame = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(119741);
      throw parame;
    }
    parama = ((a.j.b.a.c.b.e)parama).edE();
    j.p(parama, "(specialCallableDescript…ssDescriptor).defaultType");
    for (parame = a.j.b.a.c.i.d.x(parame); parame != null; parame = a.j.b.a.c.i.d.x(parame)) {
      if (!(parame instanceof a.j.b.a.c.d.a.b.d))
      {
        int i;
        if (q.e((w)parame.edE(), (w)parama) != null) {
          i = 1;
        }
        while (i != 0) {
          if (!g.b((l)parame))
          {
            AppMethodBeat.o(119741);
            return true;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(119741);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(119741);
    return false;
  }
  
  static final a.j.b.a.c.f.b b(a.j.b.a.c.f.c paramc, String paramString)
  {
    AppMethodBeat.i(119734);
    paramc = paramc.t(f.ayT(paramString)).emf();
    j.p(paramc, "child(Name.identifier(name)).toSafe()");
    AppMethodBeat.o(119734);
    return paramc;
  }
  
  public static final <T extends a.j.b.a.c.b.b> T n(T paramT)
  {
    AppMethodBeat.i(119736);
    j.q(paramT, "receiver$0");
    Object localObject = c.Ccl;
    if (!c.eft().contains(paramT.edF()))
    {
      localObject = e.CcN;
      if (!e.efv().contains(a.j.b.a.c.i.c.a.x(paramT).edF()))
      {
        AppMethodBeat.o(119736);
        return null;
      }
    }
    if (((paramT instanceof ah)) || ((paramT instanceof ag)))
    {
      paramT = a.j.b.a.c.i.c.a.b(paramT, (a.f.a.b)a.Cdz);
      AppMethodBeat.o(119736);
      return paramT;
    }
    if ((paramT instanceof al))
    {
      paramT = a.j.b.a.c.i.c.a.b(paramT, (a.f.a.b)t.b.CdA);
      AppMethodBeat.o(119736);
      return paramT;
    }
    AppMethodBeat.o(119736);
    return null;
  }
  
  public static final boolean o(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119737);
    j.q(paramb, "receiver$0");
    if (n(paramb) != null)
    {
      AppMethodBeat.o(119737);
      return true;
    }
    AppMethodBeat.o(119737);
    return false;
  }
  
  public static final <T extends a.j.b.a.c.b.b> T p(T paramT)
  {
    AppMethodBeat.i(119738);
    j.q(paramT, "receiver$0");
    Object localObject = n(paramT);
    if (localObject != null)
    {
      AppMethodBeat.o(119738);
      return localObject;
    }
    localObject = d.Ccu;
    localObject = paramT.edF();
    j.p(localObject, "name");
    if (!d.h((f)localObject))
    {
      AppMethodBeat.o(119738);
      return null;
    }
    paramT = a.j.b.a.c.i.c.a.b(paramT, (a.f.a.b)t.c.CdB);
    AppMethodBeat.o(119738);
    return paramT;
  }
  
  public static final String q(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119739);
    j.q(paramb, "callableMemberDescriptor");
    paramb = r(paramb);
    if (paramb != null)
    {
      paramb = a.j.b.a.c.i.c.a.x(paramb);
      if (paramb != null) {}
    }
    else
    {
      AppMethodBeat.o(119739);
      return null;
    }
    Object localObject;
    if ((paramb instanceof ah))
    {
      localObject = e.CcN;
      paramb = e.m(paramb);
      AppMethodBeat.o(119739);
      return paramb;
    }
    if ((paramb instanceof al))
    {
      localObject = c.Ccl;
      paramb = c.a((al)paramb);
      if (paramb != null)
      {
        paramb = paramb.name;
        AppMethodBeat.o(119739);
        return paramb;
      }
    }
    AppMethodBeat.o(119739);
    return null;
  }
  
  private static final a.j.b.a.c.b.b r(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119740);
    if (g.b((l)paramb))
    {
      paramb = n(paramb);
      AppMethodBeat.o(119740);
      return paramb;
    }
    AppMethodBeat.o(119740);
    return null;
  }
  
  public static final boolean s(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119742);
    j.q(paramb, "receiver$0");
    j.q(paramb, "receiver$0");
    if (((a.j.b.a.c.i.c.a.x(paramb).ecv() instanceof a.j.b.a.c.d.a.b.d)) || (g.b((l)paramb)))
    {
      AppMethodBeat.o(119742);
      return true;
    }
    AppMethodBeat.o(119742);
    return false;
  }
  
  static final r u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(119735);
    f localf = f.ayT(paramString2);
    j.p(localf, "Name.identifier(name)");
    a.j.b.a.c.d.b.t localt = a.j.b.a.c.d.b.t.Cjx;
    paramString1 = new r(localf, a.j.b.a.c.d.b.t.jq(paramString1, paramString2 + '(' + paramString3 + ')' + paramString4));
    AppMethodBeat.o(119735);
    return paramString1;
  }
  
  static final class a
    extends k
    implements a.f.a.b<a.j.b.a.c.b.b, Boolean>
  {
    public static final a Cdz;
    
    static
    {
      AppMethodBeat.i(119728);
      Cdz = new a();
      AppMethodBeat.o(119728);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.t
 * JD-Core Version:    0.7.0.1
 */