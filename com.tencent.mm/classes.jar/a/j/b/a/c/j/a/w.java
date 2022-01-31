package a.j.b.a.c.j.a;

import a.j.b.a.c.b.e;
import a.j.b.a.c.b.h;
import a.j.b.a.c.b.y;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.aa.a;
import a.j.b.a.c.e.a.aa.a.b;
import a.j.b.a.c.e.a.ae;
import a.j.b.a.c.e.a.b.a;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.l.ag;
import a.j.b.a.c.l.ah;
import a.j.b.a.c.l.al;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class w
{
  private final String Cqu;
  final k CyY;
  private final a.f.a.b<Integer, e> Czs;
  private final a.f.a.b<Integer, h> Czt;
  private final Map<Integer, a.j.b.a.c.b.ar> Czu;
  private final w Czv;
  boolean Czw;
  
  private w(k paramk, w paramw, List<a.ae> paramList, String paramString)
  {
    AppMethodBeat.i(122332);
    this.CyY = paramk;
    this.Czv = paramw;
    this.Cqu = paramString;
    this.Czw = false;
    this.Czs = ((a.f.a.b)this.CyY.CiZ.BRT.j((a.f.a.b)new w.a(this)));
    this.Czt = ((a.f.a.b)this.CyY.CiZ.BRT.j((a.f.a.b)new w.d(this)));
    if (paramList.isEmpty()) {
      paramk = a.a.ad.emptyMap();
    }
    for (paramw = this;; paramw = this)
    {
      paramw.Czu = paramk;
      AppMethodBeat.o(122332);
      return;
      paramk = new LinkedHashMap();
      paramw = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramw.hasNext())
      {
        paramList = (a.ae)paramw.next();
        ((Map)paramk).put(Integer.valueOf(paramList.Cks), new a.j.b.a.c.j.a.a.l(this.CyY, paramList, i));
        i += 1;
      }
      paramk = (Map)paramk;
    }
  }
  
  private final an VT(int paramInt)
  {
    AppMethodBeat.i(122328);
    Object localObject1 = this;
    do
    {
      localObject2 = (a.j.b.a.c.b.ar)((w)localObject1).Czu.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        an localan = ((a.j.b.a.c.b.ar)localObject2).ecx();
        localObject2 = localan;
        if (localan != null) {
          break;
        }
      }
      localObject2 = ((w)localObject1).Czv;
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = null;
    AppMethodBeat.o(122328);
    return localObject2;
  }
  
  private final a.j.b.a.c.l.ad VU(int paramInt)
  {
    AppMethodBeat.i(122329);
    if (r.a(this.CyY.BOc, paramInt).CqC)
    {
      AppMethodBeat.o(122329);
      return null;
    }
    AppMethodBeat.o(122329);
    return null;
  }
  
  private final a.j.b.a.c.l.ad a(a.j.b.a.c.b.a.g paramg, an paraman, List<? extends ap> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(122324);
    switch (paraman.getParameters().size() - paramList.size())
    {
    }
    for (;;)
    {
      paramg = (a.j.b.a.c.b.a.g)localObject;
      if (localObject == null)
      {
        paramg = p.F("Bad suspend function in metadata with constructor: ".concat(String.valueOf(paraman)), paramList);
        a.f.b.j.p(paramg, "ErrorUtils.createErrorTy…      arguments\n        )");
      }
      AppMethodBeat.o(122324);
      return paramg;
      localObject = b(paramg, paraman, paramList, paramBoolean);
      continue;
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        localObject = paraman.eec().TU(i);
        a.f.b.j.p(localObject, "functionTypeConstructor.…getSuspendFunction(arity)");
        localObject = ((e)localObject).ecx();
        a.f.b.j.p(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
        localObject = x.c(paramg, (an)localObject, paramList, paramBoolean);
      }
    }
  }
  
  private static a.j.b.a.c.l.ad a(a.j.b.a.c.l.w paramw1, a.j.b.a.c.l.w paramw2)
  {
    AppMethodBeat.i(122327);
    a.j.b.a.c.a.g localg = a.j.b.a.c.l.c.a.aL(paramw1);
    a.j.b.a.c.b.a.g localg1 = paramw1.ecM();
    a.j.b.a.c.l.w localw = a.j.b.a.c.a.f.h(paramw1);
    Object localObject = (Iterable)a.a.j.fW(a.j.b.a.c.a.f.j(paramw1));
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((ap)((Iterator)localObject).next()).eer());
    }
    paramw1 = a.j.b.a.c.a.f.a(localg, localg1, localw, (List)localCollection, paramw2, true).ss(paramw1.egH());
    AppMethodBeat.o(122327);
    return paramw1;
  }
  
  private final ap a(a.j.b.a.c.b.ar paramar, a.aa.a parama)
  {
    AppMethodBeat.i(122330);
    if (parama.Cnb == a.aa.a.b.Cnh)
    {
      if (paramar == null)
      {
        paramar = this.CyY.CiZ.BVj.eec().ecm();
        a.f.b.j.p(paramar, "c.components.moduleDescr….builtIns.nullableAnyType");
        paramar = (ap)new al((a.j.b.a.c.l.w)paramar);
        AppMethodBeat.o(122330);
        return paramar;
      }
      paramar = (ap)new ah(paramar);
      AppMethodBeat.o(122330);
      return paramar;
    }
    paramar = t.Czm;
    paramar = parama.Cnb;
    a.f.b.j.p(paramar, "typeArgumentProto.projection");
    paramar = t.b(paramar);
    parama = a.j.b.a.c.e.a.g.a(parama, this.CyY.BOd);
    if (parama == null)
    {
      paramar = (ap)new a.j.b.a.c.l.ar((a.j.b.a.c.l.w)p.azj("No type recorded"));
      AppMethodBeat.o(122330);
      return paramar;
    }
    paramar = (ap)new a.j.b.a.c.l.ar(paramar, r(parama));
    AppMethodBeat.o(122330);
    return paramar;
  }
  
  private final a.j.b.a.c.l.ad af(a.j.b.a.c.l.w paramw)
  {
    Object localObject2 = null;
    AppMethodBeat.i(122326);
    Object localObject1 = (ap)a.a.j.fT(a.j.b.a.c.a.f.j(paramw));
    if (localObject1 != null)
    {
      localObject3 = ((ap)localObject1).eer();
      if (localObject3 != null) {}
    }
    else
    {
      AppMethodBeat.o(122326);
      return null;
    }
    a.f.b.j.p(localObject3, "funType.getValueParamete…ll()?.type ?: return null");
    localObject1 = ((a.j.b.a.c.l.w)localObject3).enU().ecR();
    if (localObject1 != null) {}
    for (localObject1 = a.j.b.a.c.i.c.a.o((a.j.b.a.c.b.l)localObject1); (((a.j.b.a.c.l.w)localObject3).enR().size() != 1) || ((!a.j.b.a.c.a.k.a((a.j.b.a.c.f.b)localObject1, true)) && (!a.j.b.a.c.a.k.a((a.j.b.a.c.f.b)localObject1, false))); localObject1 = null)
    {
      paramw = (a.j.b.a.c.l.ad)paramw;
      AppMethodBeat.o(122326);
      return paramw;
    }
    a.j.b.a.c.l.w localw = ((ap)a.a.j.fU(((a.j.b.a.c.l.w)localObject3).enR())).eer();
    a.f.b.j.p(localw, "continuationArgumentType.arguments.single().type");
    Object localObject3 = this.CyY.BZh;
    localObject1 = localObject3;
    if (!(localObject3 instanceof a.j.b.a.c.b.a)) {
      localObject1 = null;
    }
    localObject3 = (a.j.b.a.c.b.a)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = a.j.b.a.c.i.c.a.I((a.j.b.a.c.b.l)localObject3);
    }
    if (a.f.b.j.e(localObject1, v.Czr))
    {
      paramw = a(paramw, localw);
      AppMethodBeat.o(122326);
      return paramw;
    }
    if (this.Czw) {}
    for (boolean bool = true;; bool = false)
    {
      this.Czw = bool;
      paramw = a(paramw, localw);
      AppMethodBeat.o(122326);
      return paramw;
    }
  }
  
  private final a.j.b.a.c.l.ad b(a.j.b.a.c.b.a.g paramg, an paraman, List<? extends ap> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(122325);
    paramg = x.c(paramg, paraman, paramList, paramBoolean);
    if (!a.j.b.a.c.a.f.d((a.j.b.a.c.l.w)paramg))
    {
      AppMethodBeat.o(122325);
      return null;
    }
    paramg = af((a.j.b.a.c.l.w)paramg);
    AppMethodBeat.o(122325);
    return paramg;
  }
  
  private final an t(a.aa paramaa)
  {
    AppMethodBeat.i(122323);
    Object localObject3 = new w.e(this, paramaa);
    Object localObject2;
    Object localObject1;
    if (paramaa.ejB())
    {
      localObject2 = (e)this.Czs.S(Integer.valueOf(paramaa.CmS));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((w.e)localObject3).VV(paramaa.CmS);
      }
      paramaa = ((e)localObject1).ecx();
      a.f.b.j.p(paramaa, "(classDescriptors(proto.…assName)).typeConstructor");
      AppMethodBeat.o(122323);
      return paramaa;
    }
    if (paramaa.ejC())
    {
      localObject2 = VT(paramaa.CmT);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramaa = p.azl("Unknown type parameter " + paramaa.CmT);
        a.f.b.j.p(paramaa, "ErrorUtils.createErrorTy… ${proto.typeParameter}\")");
        AppMethodBeat.o(122323);
        return paramaa;
      }
    }
    else
    {
      if (paramaa.ejD())
      {
        localObject2 = this.CyY.BZh;
        localObject3 = this.CyY.BOc.getString(paramaa.CmU);
        localObject1 = ((Iterable)eoq()).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramaa = ((Iterator)localObject1).next();
        } while (!a.f.b.j.e(((a.j.b.a.c.b.ar)paramaa).edF().name, localObject3));
        for (;;)
        {
          paramaa = (a.j.b.a.c.b.ar)paramaa;
          if (paramaa != null)
          {
            paramaa = paramaa.ecx();
            localObject1 = paramaa;
            if (paramaa != null) {
              break;
            }
          }
          paramaa = p.azl("Deserialized type parameter " + (String)localObject3 + " in " + localObject2);
          a.f.b.j.p(paramaa, "ErrorUtils.createErrorTy…ter $name in $container\")");
          AppMethodBeat.o(122323);
          return paramaa;
          paramaa = null;
        }
      }
      if (paramaa.ejE())
      {
        localObject2 = (h)this.Czt.S(Integer.valueOf(paramaa.CmV));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (h)((w.e)localObject3).VV(paramaa.CmV);
        }
        paramaa = ((h)localObject1).ecx();
        a.f.b.j.p(paramaa, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
        AppMethodBeat.o(122323);
        return paramaa;
      }
      localObject1 = p.azl("Unknown type");
      a.f.b.j.p(localObject1, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
    }
    AppMethodBeat.o(122323);
    return localObject1;
  }
  
  public final List<a.j.b.a.c.b.ar> eoq()
  {
    AppMethodBeat.i(122320);
    List localList = a.a.j.m((Iterable)this.Czu.values());
    AppMethodBeat.o(122320);
    return localList;
  }
  
  public final a.j.b.a.c.l.w r(a.aa paramaa)
  {
    AppMethodBeat.i(122321);
    a.f.b.j.q(paramaa, "proto");
    if (paramaa.ejy())
    {
      String str = this.CyY.BOc.getString(paramaa.CmP);
      a.j.b.a.c.l.ad localad = s(paramaa);
      Object localObject = a.j.b.a.c.e.a.g.a(paramaa, this.CyY.BOd);
      if (localObject == null) {
        a.f.b.j.ebi();
      }
      localObject = s((a.aa)localObject);
      paramaa = this.CyY.CiZ.CyJ.a(paramaa, str, localad, (a.j.b.a.c.l.ad)localObject);
      AppMethodBeat.o(122321);
      return paramaa;
    }
    paramaa = (a.j.b.a.c.l.w)s(paramaa);
    AppMethodBeat.o(122321);
    return paramaa;
  }
  
  public final a.j.b.a.c.l.ad s(a.aa paramaa)
  {
    AppMethodBeat.i(122322);
    a.f.b.j.q(paramaa, "proto");
    if (paramaa.ejB()) {
      VU(paramaa.CmS);
    }
    for (;;)
    {
      localObject1 = t(paramaa);
      if (!p.L((a.j.b.a.c.b.l)((an)localObject1).ecR())) {
        break;
      }
      paramaa = p.a(localObject1.toString(), (an)localObject1);
      a.f.b.j.p(paramaa, "ErrorUtils.createErrorTy….toString(), constructor)");
      AppMethodBeat.o(122322);
      return paramaa;
      if (paramaa.ejE()) {
        VU(paramaa.CmV);
      }
    }
    a.j.b.a.c.j.a.a.a locala = new a.j.b.a.c.j.a.a.a(this.CyY.CiZ.BRT, (a.f.a.a)new w.c(this, paramaa));
    Object localObject3 = (Iterable)new w.b(this).u(paramaa);
    Object localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject4 = (a.aa.a)localObject4;
      List localList = ((an)localObject1).getParameters();
      a.f.b.j.p(localList, "constructor.parameters");
      ((Collection)localObject2).add(a((a.j.b.a.c.b.ar)a.a.j.w(localList, i), (a.aa.a)localObject4));
      i += 1;
    }
    localObject2 = a.a.j.m((Iterable)localObject2);
    localObject3 = a.j.b.a.c.e.a.b.Coh.Vo(paramaa.CkK);
    a.f.b.j.p(localObject3, "Flags.SUSPEND_TYPE.get(proto.flags)");
    if (((Boolean)localObject3).booleanValue()) {}
    for (Object localObject1 = a((a.j.b.a.c.b.a.g)locala, (an)localObject1, (List)localObject2, paramaa.CmO);; localObject1 = x.c((a.j.b.a.c.b.a.g)locala, (an)localObject1, (List)localObject2, paramaa.CmO))
    {
      paramaa = a.j.b.a.c.e.a.g.c(paramaa, this.CyY.BOd);
      if (paramaa != null) {
        break;
      }
      AppMethodBeat.o(122322);
      return localObject1;
    }
    paramaa = ag.b((a.j.b.a.c.l.ad)localObject1, s(paramaa));
    AppMethodBeat.o(122322);
    return paramaa;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122331);
    StringBuilder localStringBuilder = new StringBuilder().append(this.Cqu);
    if (this.Czv == null) {}
    for (String str = "";; str = ". Child of " + this.Czv.Cqu)
    {
      str = str;
      AppMethodBeat.o(122331);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.j.a.w
 * JD-Core Version:    0.7.0.1
 */