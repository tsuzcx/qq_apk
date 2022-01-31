package a.j.b.a.c.b.c;

import a.a.e;
import a.a.x;
import a.aa;
import a.f.a.a;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ac;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.y;
import a.j.b.a.c.k.c;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v
  extends j
  implements y
{
  private final a.j.b.a.c.k.i BRT;
  private final a.j.b.a.c.a.g BXC;
  private final Map<Object<? extends Object>, Object> CaC;
  private t CaD;
  private ac CaE;
  private final c<a.j.b.a.c.f.b, a.j.b.a.c.b.ad> CaF;
  private final a.f CaG;
  private final a.j.b.a.c.f.f CaH;
  private boolean bRg;
  
  static
  {
    AppMethodBeat.i(119509);
    eOJ = new k[] { (k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(v.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;")) };
    AppMethodBeat.o(119509);
  }
  
  public v(a.j.b.a.c.f.f paramf, a.j.b.a.c.k.i parami, a.j.b.a.c.a.g paramg)
  {
    this(paramf, parami, paramg, null, 48);
  }
  
  private v(a.j.b.a.c.f.f paramf, a.j.b.a.c.k.i parami, a.j.b.a.c.a.g paramg, Map<Object<?>, ? extends Object> paramMap)
  {
    super(g.a.eeH(), paramf);
    AppMethodBeat.i(119522);
    this.BRT = parami;
    this.BXC = paramg;
    this.CaH = null;
    if (!paramf.CqN)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(119522);
      throw paramf;
    }
    paramf = a.a.ad.emptyMap();
    a.f.b.j.q(paramMap, "receiver$0");
    a.f.b.j.q(paramf, "map");
    parami = new LinkedHashMap(paramMap);
    parami.putAll(paramf);
    this.CaC = ((Map)parami);
    this.bRg = true;
    this.CaF = this.BRT.i((a.f.a.b)new v.b(this));
    this.CaG = a.g.j((a)new v.a(this));
    AppMethodBeat.o(119522);
  }
  
  private void a(t paramt)
  {
    AppMethodBeat.i(119514);
    a.f.b.j.q(paramt, "dependencies");
    if (this.CaD == null) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramt = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(119514);
      throw paramt;
    }
    this.CaD = paramt;
    AppMethodBeat.o(119514);
  }
  
  private void a(List<v> paramList, Set<v> paramSet)
  {
    AppMethodBeat.i(119517);
    a.f.b.j.q(paramList, "descriptors");
    a.f.b.j.q(paramSet, "friends");
    a((t)new u(paramList, paramSet, (List)a.a.v.BMx));
    AppMethodBeat.o(119517);
  }
  
  private void efb()
  {
    AppMethodBeat.i(119510);
    if (!this.bRg)
    {
      Throwable localThrowable = (Throwable)new a.j.b.a.c.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(119510);
      throw localThrowable;
    }
    AppMethodBeat.o(119510);
  }
  
  private final i efc()
  {
    AppMethodBeat.i(119513);
    i locali = (i)this.CaG.getValue();
    AppMethodBeat.o(119513);
    return locali;
  }
  
  private void gb(List<v> paramList)
  {
    AppMethodBeat.i(119516);
    a.f.b.j.q(paramList, "descriptors");
    a(paramList, (Set)x.BMz);
    AppMethodBeat.o(119516);
  }
  
  private final String getId()
  {
    AppMethodBeat.i(119519);
    String str = this.BYN.toString();
    a.f.b.j.p(str, "name.toString()");
    AppMethodBeat.o(119519);
    return str;
  }
  
  private final boolean isInitialized()
  {
    return this.CaE != null;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119524);
    a.f.b.j.q(paramn, "visitor");
    a.f.b.j.q(paramn, "visitor");
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(119524);
    return paramn;
  }
  
  public final Collection<a.j.b.a.c.f.b> a(a.j.b.a.c.f.b paramb, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb1)
  {
    AppMethodBeat.i(119512);
    a.f.b.j.q(paramb, "fqName");
    a.f.b.j.q(paramb1, "nameFilter");
    efb();
    paramb = efd().a(paramb, paramb1);
    AppMethodBeat.o(119512);
    return paramb;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(119520);
    a.f.b.j.q(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(119520);
      throw paramac;
    }
    this.CaE = paramac;
    AppMethodBeat.o(119520);
  }
  
  public final void a(v... paramVarArgs)
  {
    AppMethodBeat.i(119515);
    a.f.b.j.q(paramVarArgs, "descriptors");
    gb(e.R(paramVarArgs));
    AppMethodBeat.o(119515);
  }
  
  public final boolean a(y paramy)
  {
    AppMethodBeat.i(119518);
    a.f.b.j.q(paramy, "targetModule");
    if (!a.f.b.j.e((v)this, paramy))
    {
      t localt = this.CaD;
      if (localt == null) {
        a.f.b.j.ebi();
      }
      if (!a.a.j.a((Iterable)localt.eeZ(), paramy))
      {
        localt = this.CaD;
        if (localt == null)
        {
          paramy = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
          AppMethodBeat.o(119518);
          throw paramy;
        }
        if (!localt.efa().contains(paramy)) {
          break label129;
        }
      }
    }
    AppMethodBeat.o(119518);
    return true;
    label129:
    AppMethodBeat.o(119518);
    return false;
  }
  
  public final l ecv()
  {
    return null;
  }
  
  public final a.j.b.a.c.a.g eec()
  {
    return this.BXC;
  }
  
  public final ac efd()
  {
    AppMethodBeat.i(119521);
    efb();
    ac localac = (ac)efc();
    AppMethodBeat.o(119521);
    return localac;
  }
  
  public final a.j.b.a.c.b.ad g(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119511);
    a.f.b.j.q(paramb, "fqName");
    efb();
    paramb = (a.j.b.a.c.b.ad)this.CaF.S(paramb);
    AppMethodBeat.o(119511);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.c.v
 * JD-Core Version:    0.7.0.1
 */