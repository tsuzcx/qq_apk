package a.j.b.a.c.d.b;

import a.a.aj;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.am;
import a.j.b.a.c.d.b.a.a.a;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.s;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.b.a.g;
import a.j.b.a.c.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class e
{
  private static final Set<a.a> Cja;
  private static final Set<a.a> Cjb;
  private static final g Cjc;
  private static final g Cjd;
  private static final g Cje;
  public static final e.a Cjf;
  public a.j.b.a.c.j.a.i CiZ;
  
  static
  {
    AppMethodBeat.i(120260);
    Cjf = new e.a((byte)0);
    Cja = aj.setOf(a.a.CjY);
    Cjb = aj.setOf(new a.a[] { a.a.CjZ, a.a.Ckc });
    Cjc = new g(new int[] { 1, 1, 2 });
    Cjd = new g(new int[] { 1, 1, 11 });
    Cje = new g(new int[] { 1, 1, 13 });
    AppMethodBeat.o(120260);
  }
  
  private static String[] a(n paramn, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(120259);
    a.f.b.j.q(paramn, "kotlinClass");
    a.f.b.j.q(paramSet, "expectedKinds");
    a.j.b.a.c.d.b.a.a locala = paramn.ebZ();
    String[] arrayOfString = locala.CjT;
    paramn = arrayOfString;
    if (arrayOfString == null) {
      paramn = locala.CjU;
    }
    if (paramn != null)
    {
      if (paramSet.contains(locala.CjQ))
      {
        AppMethodBeat.o(120259);
        return paramn;
      }
      AppMethodBeat.o(120259);
      return null;
    }
    AppMethodBeat.o(120259);
    return null;
  }
  
  private final a.j.b.a.c.j.a.o<g> b(n paramn)
  {
    AppMethodBeat.i(120256);
    egP();
    if (paramn.ebZ().CjR.elW())
    {
      AppMethodBeat.o(120256);
      return null;
    }
    paramn = new a.j.b.a.c.j.a.o((a.j.b.a.c.e.a.a)paramn.ebZ().CjR, (a.j.b.a.c.e.a.a)g.Cqi, paramn.getLocation(), paramn.ebx());
    AppMethodBeat.o(120256);
    return paramn;
  }
  
  private final boolean c(n paramn)
  {
    AppMethodBeat.i(120257);
    if (this.CiZ == null) {
      a.f.b.j.ays("components");
    }
    if (d(paramn))
    {
      AppMethodBeat.o(120257);
      return true;
    }
    AppMethodBeat.o(120257);
    return false;
  }
  
  private final boolean d(n paramn)
  {
    AppMethodBeat.i(120258);
    if (this.CiZ == null) {
      a.f.b.j.ays("components");
    }
    if ((paramn.ebZ().egV()) && (a.f.b.j.e(paramn.ebZ().CjR, Cjd)))
    {
      AppMethodBeat.o(120258);
      return true;
    }
    AppMethodBeat.o(120258);
    return false;
  }
  
  private final boolean egP()
  {
    AppMethodBeat.i(120253);
    if (this.CiZ == null) {
      a.f.b.j.ays("components");
    }
    AppMethodBeat.o(120253);
    return false;
  }
  
  public final a.j.b.a.c.i.e.h a(ab paramab, n paramn)
  {
    AppMethodBeat.i(120255);
    a.f.b.j.q(paramab, "descriptor");
    a.f.b.j.q(paramn, "kotlinClass");
    Object localObject1 = a(paramn, Cjb);
    if (localObject1 == null)
    {
      AppMethodBeat.o(120255);
      return null;
    }
    Object localObject2 = paramn.ebZ().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(120255);
      return null;
    }
    try
    {
      localObject1 = a.j.b.a.c.e.b.a.j.e((String[])localObject1, (String[])localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(120255);
        return null;
      }
    }
    catch (k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramn.getLocation(), (Throwable)localk);
      AppMethodBeat.o(120255);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        egP();
        if (paramn.ebZ().CjR.elW())
        {
          AppMethodBeat.o(120255);
          throw localThrowable2;
        }
        locals = null;
      }
      localObject2 = (a.j.b.a.c.e.b.a.h)locals.first;
      a.s locals = (a.s)locals.second;
      Object localObject3 = new i(paramn, locals, (c)localObject2, b(paramn), c(paramn));
      localObject2 = (c)localObject2;
      paramn = (a.j.b.a.c.e.a.a)paramn.ebZ().CjR;
      localObject3 = (a.j.b.a.c.j.a.a.e)localObject3;
      a.j.b.a.c.j.a.i locali = this.CiZ;
      if (locali == null) {
        a.f.b.j.ays("components");
      }
      paramab = (a.j.b.a.c.i.e.h)new a.j.b.a.c.j.a.a.h(paramab, locals, (c)localObject2, paramn, (a.j.b.a.c.j.a.a.e)localObject3, locali, (a.f.a.a)e.b.Cjg);
      AppMethodBeat.o(120255);
    }
    return paramab;
  }
  
  public final a.j.b.a.c.j.a.e a(n paramn)
  {
    AppMethodBeat.i(120254);
    a.f.b.j.q(paramn, "kotlinClass");
    Object localObject1 = a(paramn, Cja);
    if (localObject1 == null)
    {
      AppMethodBeat.o(120254);
      return null;
    }
    Object localObject2 = paramn.ebZ().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(120254);
      return null;
    }
    try
    {
      localObject1 = a.j.b.a.c.e.b.a.j.d((String[])localObject1, (String[])localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(120254);
        return null;
      }
    }
    catch (k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramn.getLocation(), (Throwable)localk);
      AppMethodBeat.o(120254);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        egP();
        if (paramn.ebZ().CjR.elW())
        {
          AppMethodBeat.o(120254);
          throw localThrowable2;
        }
        localc = null;
      }
      localObject2 = (a.j.b.a.c.e.b.a.h)localc.first;
      a.c localc = (a.c)localc.second;
      p localp = new p(paramn, b(paramn), c(paramn));
      paramn = new a.j.b.a.c.j.a.e((c)localObject2, localc, (a.j.b.a.c.e.a.a)paramn.ebZ().CjR, (am)localp);
      AppMethodBeat.o(120254);
    }
    return paramn;
  }
  
  public final a.j.b.a.c.j.a.i egO()
  {
    AppMethodBeat.i(120252);
    a.j.b.a.c.j.a.i locali = this.CiZ;
    if (locali == null) {
      a.f.b.j.ays("components");
    }
    AppMethodBeat.o(120252);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.b.e
 * JD-Core Version:    0.7.0.1
 */