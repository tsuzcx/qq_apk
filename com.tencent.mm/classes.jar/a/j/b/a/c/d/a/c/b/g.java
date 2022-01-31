package a.j.b.a.c.d.a.c.b;

import a.aa;
import a.f.a.b;
import a.j.b.a.c.h.i;
import a.j.b.a.c.l.ac;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
  implements ac
{
  public g(ad paramad1, ad paramad2)
  {
    super(paramad1, paramad2);
    AppMethodBeat.i(120077);
    boolean bool = a.j.b.a.c.l.a.c.CCi.c((w)paramad1, (w)paramad2);
    if ((aa.BMh) && (!bool))
    {
      paramad1 = (Throwable)new AssertionError("Lower bound " + paramad1 + " of a flexible type must be a subtype of the upper bound " + paramad2);
      AppMethodBeat.o(120077);
      throw paramad1;
    }
    AppMethodBeat.o(120077);
  }
  
  public final String a(a.j.b.a.c.h.c paramc, i parami)
  {
    int i = 0;
    AppMethodBeat.i(120076);
    a.f.b.j.q(paramc, "renderer");
    a.f.b.j.q(parami, "options");
    Object localObject1 = g.a.Chf;
    Object localObject2 = new g.b(paramc);
    localObject1 = g.c.Chh;
    String str = paramc.b((w)this.CBm);
    localObject1 = paramc.b((w)this.CBn);
    if (parami.enq())
    {
      paramc = "raw (" + str + ".." + (String)localObject1 + ')';
      AppMethodBeat.o(120076);
      return paramc;
    }
    if (this.CBn.enR().isEmpty())
    {
      paramc = paramc.a(str, (String)localObject1, a.aL(this));
      AppMethodBeat.o(120076);
      return paramc;
    }
    parami = ((g.b)localObject2).Q((w)this.CBm);
    Object localObject3 = ((g.b)localObject2).Q((w)this.CBn);
    localObject2 = a.a.j.a((Iterable)parami, (CharSequence)", ", null, null, 0, null, (b)g.d.Chi, 30);
    parami = (Iterable)a.a.j.a((Iterable)parami, (Iterable)localObject3);
    if (!((Collection)parami).isEmpty())
    {
      parami = parami.iterator();
      while (parami.hasNext())
      {
        localObject3 = (o)parami.next();
        g.a locala = g.a.Chf;
        if (!g.a.jm((String)((o)localObject3).first, (String)((o)localObject3).second)) {
          if (i == 0) {
            break label327;
          }
        }
      }
    }
    label327:
    for (parami = g.c.jn((String)localObject1, (String)localObject2);; parami = (i)localObject1)
    {
      localObject1 = g.c.jn(str, (String)localObject2);
      if (!a.f.b.j.e(localObject1, parami)) {
        break label333;
      }
      AppMethodBeat.o(120076);
      return localObject1;
      i = 1;
      break;
    }
    label333:
    paramc = paramc.a((String)localObject1, parami, a.aL(this));
    AppMethodBeat.o(120076);
    return paramc;
  }
  
  public final a.j.b.a.c.i.e.h ecq()
  {
    AppMethodBeat.i(120073);
    a.j.b.a.c.b.h localh = enU().ecR();
    Object localObject = localh;
    if (!(localh instanceof a.j.b.a.c.b.e)) {
      localObject = null;
    }
    localObject = (a.j.b.a.c.b.e)localObject;
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalStateException(("Incorrect classifier: " + enU().ecR()).toString());
      AppMethodBeat.o(120073);
      throw ((Throwable)localObject);
    }
    localObject = ((a.j.b.a.c.b.e)localObject).a((as)e.Che);
    a.f.b.j.p(localObject, "classDescriptor.getMemberScope(RawSubstitution)");
    AppMethodBeat.o(120073);
    return localObject;
  }
  
  public final ad efX()
  {
    return this.CBm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */