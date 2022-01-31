package a.j.b.a.c.a.b;

import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.d.b.t;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class f$a
{
  public static boolean d(a.j.b.a.c.f.c paramc)
  {
    AppMethodBeat.i(119210);
    a.f.b.j.q(paramc, "fqName");
    if (e(paramc))
    {
      AppMethodBeat.o(119210);
      return true;
    }
    c localc = c.BVe;
    paramc = c.c(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(119210);
      return false;
    }
    try
    {
      paramc = Class.forName(paramc.emc().CqE.CqJ);
      boolean bool = Serializable.class.isAssignableFrom(paramc);
      AppMethodBeat.o(119210);
      return bool;
    }
    catch (ClassNotFoundException paramc)
    {
      AppMethodBeat.o(119210);
    }
    return false;
  }
  
  static boolean e(a.j.b.a.c.f.c paramc)
  {
    AppMethodBeat.i(119211);
    if ((a.f.b.j.e(paramc, g.BRU.BSh)) || (g.b(paramc)))
    {
      AppMethodBeat.o(119211);
      return true;
    }
    AppMethodBeat.o(119211);
    return false;
  }
  
  static Set<String> edn()
  {
    AppMethodBeat.i(119212);
    Object localObject1 = t.Cjx;
    Object localObject2 = (Iterable)a.a.j.listOf(new a.j.b.a.c.i.d.c[] { a.j.b.a.c.i.d.c.CwT, a.j.b.a.c.i.d.c.CwV, a.j.b.a.c.i.d.c.Cxa, a.j.b.a.c.i.d.c.CwY, a.j.b.a.c.i.d.c.CwV, a.j.b.a.c.i.d.c.CwX, a.j.b.a.c.i.d.c.CwZ, a.j.b.a.c.i.d.c.CwW });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = ((a.j.b.a.c.i.d.c)((Iterator)localObject2).next()).Cxg.CqE.emh().name;
      a.f.b.j.p(str, "it.wrapperFqName.shortName().asString()");
      String[] arrayOfString = t.ad(new String[] { "Ljava/lang/String;" });
      a.a.j.a((Collection)localObject1, (Iterable)t.o(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(119212);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */