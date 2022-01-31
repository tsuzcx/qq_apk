package a.j.b.a.c.a.a;

import a.j.b.a.c.a.c;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ap.a;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.a;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  final int BNe;
  private final i BRT;
  private final a.j.b.a.c.b.ab BUA;
  final b BUB;
  private final a BUy;
  private final d BUz;
  final List<ar> parameters;
  
  public b(i parami, a.j.b.a.c.b.ab paramab, b paramb, int paramInt)
  {
    super(parami, paramb.TV(paramInt));
    AppMethodBeat.i(119154);
    this.BRT = parami;
    this.BUA = paramab;
    this.BUB = paramb;
    this.BNe = paramInt;
    this.BUy = new a();
    this.BUz = new d(this.BRT, this);
    parami = new ArrayList();
    paramab = new b.1(this, parami);
    Object localObject = (Iterable)new a.i.d(1, this.BNe);
    paramb = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((a.a.ab)localObject).nextInt();
      paramab.a(ba.CBY, "P".concat(String.valueOf(paramInt)));
      paramb.add(a.y.BMg);
    }
    paramab.a(ba.CBZ, "R");
    this.parameters = a.a.j.m((Iterable)parami);
    AppMethodBeat.o(119154);
  }
  
  public final a.j.b.a.c.b.f ecB()
  {
    return a.j.b.a.c.b.f.BWg;
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    return a.j.b.a.c.b.w.BWs;
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(119150);
    az localaz = ay.BWO;
    a.f.b.j.p(localaz, "Visibilities.PUBLIC");
    AppMethodBeat.o(119150);
    return localaz;
  }
  
  public final boolean ecF()
  {
    return false;
  }
  
  public final boolean ecG()
  {
    return false;
  }
  
  public final boolean ecH()
  {
    return false;
  }
  
  public final boolean ecI()
  {
    return false;
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final boolean ecL()
  {
    return false;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    AppMethodBeat.i(119151);
    Object localObject = a.j.b.a.c.b.a.g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(119151);
    return localObject;
  }
  
  public final am ecN()
  {
    AppMethodBeat.i(119152);
    am localam = am.BWF;
    a.f.b.j.p(localam, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(119152);
    return localam;
  }
  
  public final List<ar> ecP()
  {
    return this.parameters;
  }
  
  public final an ecx()
  {
    return (an)this.BUy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119153);
    String str = this.BYN.name;
    a.f.b.j.p(str, "name.asString()");
    AppMethodBeat.o(119153);
    return str;
  }
  
  final class a
    extends a.j.b.a.c.l.b
  {
    public a()
    {
      super();
      AppMethodBeat.i(119144);
      AppMethodBeat.o(119144);
    }
    
    private final c e(a.j.b.a.c.f.b paramb)
    {
      AppMethodBeat.i(119141);
      Object localObject1 = (Iterable)b.a(this.BUC).eed().g(paramb).getFragments();
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof c)) {
          paramb.add(localObject2);
        }
      }
      paramb = (c)a.a.j.fQ((List)paramb);
      AppMethodBeat.o(119141);
      return paramb;
    }
    
    public final Collection<a.j.b.a.c.l.w> ecQ()
    {
      AppMethodBeat.i(119140);
      Object localObject1 = new ArrayList(2);
      b.a.a locala = new b.a.a(this, (ArrayList)localObject1);
      Object localObject2 = this.BUC.BUB;
      a.j.b.a.c.f.f localf;
      switch (c.bLo[localObject2.ordinal()])
      {
      default: 
        localObject2 = b.a(this.BUC);
        localf = a.j.b.a.c.f.f.ayT(this.BUC.BUB.BUL);
        a.f.b.j.p(localf, "Name.identifier(functionKind.classNamePrefix)");
        locala.a((a.j.b.a.c.b.ab)localObject2, localf);
        localObject2 = this.BUC.BUB;
        switch (c.pRV[localObject2.ordinal()])
        {
        }
        break;
      }
      for (;;)
      {
        localObject1 = (Collection)a.a.j.m((Iterable)localObject1);
        AppMethodBeat.o(119140);
        return localObject1;
        localObject2 = a.j.b.a.c.a.g.BRJ;
        a.f.b.j.p(localObject2, "BUILT_INS_PACKAGE_FQ_NAME");
        localObject2 = (a.j.b.a.c.b.ab)e((a.j.b.a.c.f.b)localObject2);
        localf = a.j.b.a.c.f.f.ayT("Function");
        a.f.b.j.p(localf, "Name.identifier(\"Function\")");
        locala.a((a.j.b.a.c.b.ab)localObject2, localf);
        break;
        localObject2 = b.a(this.BUC);
        localf = a.j.b.a.c.f.f.ayT("KFunction");
        a.f.b.j.p(localf, "Name.identifier(\"KFunction\")");
        locala.a((a.j.b.a.c.b.ab)localObject2, localf);
        break;
        localObject2 = a.j.b.a.c.a.g.BRJ;
        a.f.b.j.p(localObject2, "BUILT_INS_PACKAGE_FQ_NAME");
        locala.a((a.j.b.a.c.b.ab)e((a.j.b.a.c.f.b)localObject2), b.b.BUF.TV(this.BUC.BNe));
        continue;
        localObject2 = a.j.b.a.c.i.d.CvH;
        a.f.b.j.p(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        locala.a((a.j.b.a.c.b.ab)e((a.j.b.a.c.f.b)localObject2), b.b.BUG.TV(this.BUC.BNe));
      }
    }
    
    public final boolean ecT()
    {
      return true;
    }
    
    public final ap ecU()
    {
      return (ap)ap.a.BWH;
    }
    
    public final List<ar> getParameters()
    {
      AppMethodBeat.i(119142);
      List localList = b.b(this.BUC);
      AppMethodBeat.o(119142);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(119143);
      String str = this.BUC.toString();
      AppMethodBeat.o(119143);
      return str;
    }
  }
  
  public static enum b
  {
    public static final b.b.a BUM;
    public final a.j.b.a.c.f.b BUK;
    public final String BUL;
    
    static
    {
      AppMethodBeat.i(119145);
      Object localObject1 = a.j.b.a.c.a.g.BRJ;
      a.f.b.j.p(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
      localObject1 = new b("Function", 0, (a.j.b.a.c.f.b)localObject1, "Function");
      BUF = (b)localObject1;
      Object localObject2 = a.j.b.a.c.i.d.CvH;
      a.f.b.j.p(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
      localObject2 = new b("SuspendFunction", 1, (a.j.b.a.c.f.b)localObject2, "SuspendFunction");
      BUG = (b)localObject2;
      b localb1 = new b("KFunction", 2, a.j.b.a.c.a.j.ecs(), "KFunction");
      BUH = localb1;
      b localb2 = new b("KSuspendFunction", 3, a.j.b.a.c.a.j.ecs(), "KSuspendFunction");
      BUI = localb2;
      BUJ = new b[] { localObject1, localObject2, localb1, localb2 };
      BUM = new b.b.a((byte)0);
      AppMethodBeat.o(119145);
    }
    
    private b(a.j.b.a.c.f.b paramb, String paramString)
    {
      AppMethodBeat.i(119147);
      this.BUK = paramb;
      this.BUL = paramString;
      AppMethodBeat.o(119147);
    }
    
    public final a.j.b.a.c.f.f TV(int paramInt)
    {
      AppMethodBeat.i(119146);
      a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT(this.BUL + paramInt);
      a.f.b.j.p(localf, "Name.identifier(\"$classNamePrefix$arity\")");
      AppMethodBeat.o(119146);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */