package a.j.b.a.c.d.a.c.a;

import a.a.ab;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.aa.b;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.y;
import a.j.b.a.c.d.a.a.l;
import a.j.b.a.c.d.a.p;
import a.j.b.a.c.i.b.s;
import a.j.b.a.c.j.a.m;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ao;
import a.j.b.a.c.l.au;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class f$b
  extends a.j.b.a.c.l.b
{
  private final a.j.b.a.c.k.f<List<a.j.b.a.c.b.ar>> CfR;
  
  public f$b()
  {
    super(f.b(localf).Cfj.BRT);
    AppMethodBeat.i(119893);
    this.CfR = f.b(localf).Cfj.BRT.l((a.f.a.a)new f.b.a(this));
    AppMethodBeat.o(119893);
  }
  
  private final w efR()
  {
    AppMethodBeat.i(119890);
    Object localObject1 = this.CfS.ecM();
    Object localObject2 = p.Cdi;
    a.f.b.j.p(localObject2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
    localObject1 = ((a.j.b.a.c.b.a.g)localObject1).i((a.j.b.a.c.f.b)localObject2);
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label341;
      }
      if ((((a.j.b.a.c.f.b)localObject1).CqE.CqJ.isEmpty()) || (!((a.j.b.a.c.f.b)localObject1).r(a.j.b.a.c.a.g.BRI))) {
        break label330;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label335;
      }
      label81:
      if (localObject1 != null) {
        break label732;
      }
      localObject2 = a.j.b.a.c.d.a.i.CcR;
    }
    label284:
    label291:
    label303:
    label316:
    label330:
    label335:
    label341:
    label732:
    for (localObject2 = a.j.b.a.c.d.a.i.k(a.j.b.a.c.i.c.a.o(this.CfS));; localObject2 = localObject1)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(119890);
        return null;
        localObject2 = a.a.j.i((Iterable)((a.j.b.a.c.b.a.c)localObject1).eeG().values());
        localObject1 = localObject2;
        if (!(localObject2 instanceof s)) {
          localObject1 = null;
        }
        localObject1 = (s)localObject1;
        if (localObject1 != null)
        {
          localObject2 = (String)((s)localObject1).getValue();
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = null;
          break;
        }
        if (localObject2 != null)
        {
          localObject1 = a.j.b.a.c.f.i.CqV;
          j = ((String)localObject2).length();
          i = 0;
          if (i >= j) {
            break label303;
          }
          char c = ((String)localObject2).charAt(i);
          switch (a.j.b.a.c.f.e.bLo[localObject1.ordinal()])
          {
          }
          do
          {
            for (;;)
            {
              i += 1;
              break;
              if (!Character.isJavaIdentifierPart(c)) {
                break label291;
              }
              localObject1 = a.j.b.a.c.f.i.CqW;
              continue;
              if (c != '.') {
                break label284;
              }
              localObject1 = a.j.b.a.c.f.i.CqX;
            }
          } while (Character.isJavaIdentifierPart(c));
        }
        for (i = 0;; i = 1)
        {
          if (i != 0) {
            break label316;
          }
          localObject1 = null;
          break;
          if (localObject1 == a.j.b.a.c.f.i.CqX) {
            break label291;
          }
        }
        localObject1 = new a.j.b.a.c.f.b((String)localObject2);
        break;
        i = 0;
        break label77;
        localObject1 = null;
        break label81;
        localObject1 = null;
        break label81;
      }
      localObject2 = a.j.b.a.c.i.c.a.b(f.b(this.CfS).Cfj.BUv, (a.j.b.a.c.f.b)localObject2, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbL);
      if (localObject2 == null)
      {
        AppMethodBeat.o(119890);
        return null;
      }
      Object localObject3 = ((e)localObject2).ecx();
      a.f.b.j.p(localObject3, "classDescriptor.typeConstructor");
      i = ((an)localObject3).getParameters().size();
      localObject3 = ((an)this.CfS.CfJ).getParameters();
      a.f.b.j.p(localObject3, "getTypeConstructor().parameters");
      int j = ((List)localObject3).size();
      Object localObject4;
      if (j == i)
      {
        localObject3 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (a.j.b.a.c.b.ar)((Iterator)localObject3).next();
          ba localba = ba.CBX;
          a.f.b.j.p(localObject4, "parameter");
          ((Collection)localObject1).add(new a.j.b.a.c.l.ar(localba, (w)((a.j.b.a.c.b.ar)localObject4).edE()));
        }
      }
      for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
      {
        localObject3 = a.j.b.a.c.b.a.g.BXx;
        localObject1 = (w)x.a(g.a.eeH(), (e)localObject2, (List)localObject1);
        AppMethodBeat.o(119890);
        return localObject1;
        if ((j != 1) || (i <= 1) || (localObject1 != null)) {
          break;
        }
        localObject1 = ba.CBX;
        localObject3 = a.a.j.fU((List)localObject3);
        a.f.b.j.p(localObject3, "typeParameters.single()");
        localObject1 = new a.j.b.a.c.l.ar((ba)localObject1, (w)((a.j.b.a.c.b.ar)localObject3).edE());
        localObject4 = (Iterable)new a.i.d(1, i);
        localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          ((ab)localObject4).nextInt();
          ((Collection)localObject3).add(localObject1);
        }
      }
      AppMethodBeat.o(119890);
      return null;
    }
  }
  
  public final Collection<w> ecQ()
  {
    e locale = null;
    AppMethodBeat.i(119889);
    Object localObject1 = f.a(this.CfS).eeO();
    ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
    Object localObject2 = new ArrayList(0);
    Object localObject3 = efR();
    Object localObject4 = ((Collection)localObject1).iterator();
    label181:
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (a.j.b.a.c.d.a.e.j)((Iterator)localObject4).next();
      localObject5 = f.b(this.CfS).Cfi.a((a.j.b.a.c.d.a.e.v)localObject1, a.j.b.a.c.d.a.c.b.d.a(l.Cej, false, null, 3));
      if ((((w)localObject5).enU().ecR() instanceof aa.b)) {
        ((ArrayList)localObject2).add(localObject1);
      }
      an localan = ((w)localObject5).enU();
      if (localObject3 != null) {}
      for (localObject1 = ((w)localObject3).enU();; localObject1 = null)
      {
        if ((a.f.b.j.e(localan, localObject1)) || (a.j.b.a.c.a.g.A((w)localObject5))) {
          break label181;
        }
        localArrayList.add(localObject5);
        break;
      }
    }
    localObject4 = (Collection)localArrayList;
    Object localObject5 = f.c(this.CfS);
    localObject1 = locale;
    if (localObject5 != null) {
      localObject1 = a.j.b.a.c.a.b.h.a((e)localObject5, (e)this.CfS).eoP().c((w)((e)localObject5).edE(), ba.CBX);
    }
    a.j.b.a.c.n.a.b((Collection)localObject4, localObject1);
    a.j.b.a.c.n.a.b((Collection)localArrayList, localObject3);
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = f.b(this.CfS).Cfj.CeJ;
        locale = (e)this.CfS;
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label400;
        }
        localObject4 = (a.j.b.a.c.d.a.e.v)((Iterator)localObject3).next();
        if (localObject4 == null)
        {
          localObject1 = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
          AppMethodBeat.o(119889);
          throw ((Throwable)localObject1);
          i = 0;
          break;
        }
        ((Collection)localObject2).add(((a.j.b.a.c.d.a.e.j)localObject4).ego());
      }
      label400:
      ((m)localObject1).a(locale, (List)localObject2);
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = (Collection)a.a.j.m((Iterable)localArrayList);
      AppMethodBeat.o(119889);
      return localObject1;
    }
    localObject1 = (Collection)a.a.j.listOf(f.b(this.CfS).Cfj.BUv.eec().ecl());
    AppMethodBeat.o(119889);
    return localObject1;
  }
  
  public final e ecS()
  {
    return (e)this.CfS;
  }
  
  public final boolean ecT()
  {
    return true;
  }
  
  public final ap ecU()
  {
    AppMethodBeat.i(119891);
    ap localap = f.b(this.CfS).Cfj.BZf;
    AppMethodBeat.o(119891);
    return localap;
  }
  
  public final List<a.j.b.a.c.b.ar> getParameters()
  {
    AppMethodBeat.i(119888);
    List localList = (List)this.CfR.invoke();
    AppMethodBeat.o(119888);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119892);
    String str = this.CfS.BYN.name;
    a.f.b.j.p(str, "name.asString()");
    AppMethodBeat.o(119892);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.f.b
 * JD-Core Version:    0.7.0.1
 */