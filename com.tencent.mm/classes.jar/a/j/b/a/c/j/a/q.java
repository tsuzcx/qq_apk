package a.j.b.a.c.j.a;

import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.aa;
import a.j.b.a.c.b.c.ai;
import a.j.b.a.c.b.c.o;
import a.j.b.a.c.b.c.p;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.ab;
import a.j.b.a.c.e.a.ai;
import a.j.b.a.c.e.a.ao;
import a.j.b.a.c.e.a.e;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.q;
import a.j.b.a.c.e.a.r;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.a.b.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.j.a.a.f.a;
import a.j.b.a.c.j.a.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class q
{
  private final c CiQ;
  private final k CyY;
  
  public q(k paramk)
  {
    AppMethodBeat.i(122291);
    this.CyY = paramk;
    this.CiQ = new c(this.CyY.CiZ.BVj, this.CyY.CiZ.BUa);
    AppMethodBeat.o(122291);
  }
  
  private final s K(l paraml)
  {
    AppMethodBeat.i(122290);
    if ((paraml instanceof a.j.b.a.c.b.ab))
    {
      paraml = (s)new s.b(((a.j.b.a.c.b.ab)paraml).eee(), this.CyY.BOc, this.CyY.BOd, (am)this.CyY.CyT);
      AppMethodBeat.o(122290);
      return paraml;
    }
    if ((paraml instanceof a.j.b.a.c.j.a.a.d))
    {
      paraml = (s)((a.j.b.a.c.j.a.a.d)paraml).CzM;
      AppMethodBeat.o(122290);
      return paraml;
    }
    AppMethodBeat.o(122290);
    return null;
  }
  
  private static int VS(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final a.j.b.a.c.b.a.g a(a.u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(122287);
    if (!a.j.b.a.c.e.a.b.Coi.Vo(paramu.CkK).booleanValue())
    {
      paramu = a.j.b.a.c.b.a.g.BXx;
      paramu = g.a.eeH();
      AppMethodBeat.o(122287);
      return paramu;
    }
    paramu = (a.j.b.a.c.b.a.g)new m(this.CyY.CiZ.BRT, (a.f.a.a)new q.b(this, paramBoolean, paramu));
    AppMethodBeat.o(122287);
    return paramu;
  }
  
  private final a.j.b.a.c.b.a.g a(a.j.b.a.c.g.q paramq, int paramInt, a parama)
  {
    AppMethodBeat.i(122286);
    if (!a.j.b.a.c.e.a.b.Coi.Vo(paramInt).booleanValue())
    {
      paramq = a.j.b.a.c.b.a.g.BXx;
      paramq = g.a.eeH();
      AppMethodBeat.o(122286);
      return paramq;
    }
    paramq = (a.j.b.a.c.b.a.g)new m(this.CyY.CiZ.BRT, (a.f.a.a)new q.a(this, paramq, parama));
    AppMethodBeat.o(122286);
    return paramq;
  }
  
  private final a.j.b.a.c.b.a.g a(a.j.b.a.c.g.q paramq, a parama)
  {
    AppMethodBeat.i(122288);
    paramq = (a.j.b.a.c.b.a.g)new a.j.b.a.c.j.a.a.a(this.CyY.CiZ.BRT, (a.f.a.a)new q.c(this, paramq, parama));
    AppMethodBeat.o(122288);
    return paramq;
  }
  
  private final List<au> a(List<a.ai> paramList, a.j.b.a.c.g.q paramq, a parama)
  {
    AppMethodBeat.i(122289);
    Object localObject1 = this.CyY.BZh;
    if (localObject1 == null)
    {
      paramList = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(122289);
      throw paramList;
    }
    a.j.b.a.c.b.a locala = (a.j.b.a.c.b.a)localObject1;
    localObject1 = locala.ecv();
    a.f.b.j.p(localObject1, "callableDescriptor.containingDeclaration");
    s locals = K((l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d(paramList));
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject1 = (a.ai)paramList;
      int j;
      label146:
      label215:
      f localf;
      a.j.b.a.c.l.w localw;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (((a.ai)localObject1).ehx())
      {
        j = ((a.ai)localObject1).CkK;
        if (locals == null) {
          break label427;
        }
        paramList = a.j.b.a.c.e.a.b.Coi.Vo(j);
        a.f.b.j.p(paramList, "Flags.HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label427;
        }
        paramList = (a.j.b.a.c.b.a.g)new m(this.CyY.CiZ.BRT, (a.f.a.a)new q.e(i, (a.ai)localObject1, this, locals, paramq, parama, locala));
        localf = r.b(this.CyY.BOc, ((a.ai)localObject1).ClT);
        localw = this.CyY.CyQ.r(a.j.b.a.c.e.a.g.a((a.ai)localObject1, this.CyY.BOd));
        localObject2 = a.j.b.a.c.e.a.b.CoJ.Vo(j);
        a.f.b.j.p(localObject2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = a.j.b.a.c.e.a.b.CoK.Vo(j);
        a.f.b.j.p(localObject2, "Flags.IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = a.j.b.a.c.e.a.b.CoL.Vo(j);
        a.f.b.j.p(localObject2, "Flags.IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = a.j.b.a.c.e.a.g.b((a.ai)localObject1, this.CyY.BOd);
        if (localObject1 == null) {
          break label438;
        }
      }
      label427:
      label438:
      for (localObject1 = this.CyY.CyQ.r((a.aa)localObject1);; localObject1 = null)
      {
        localObject2 = am.BWF;
        a.f.b.j.p(localObject2, "SourceElement.NO_SOURCE");
        localCollection.add(new ai(locala, null, i, paramList, localf, localw, bool1, bool2, bool3, (a.j.b.a.c.l.w)localObject1, (am)localObject2));
        i += 1;
        break;
        j = 0;
        break label146;
        paramList = a.j.b.a.c.b.a.g.BXx;
        paramList = g.a.eeH();
        break label215;
      }
    }
    paramList = a.a.j.m((Iterable)localCollection);
    AppMethodBeat.o(122289);
    return paramList;
  }
  
  private static void a(a.j.b.a.c.j.a.a.j paramj, ak paramak1, ak paramak2, List<? extends ar> paramList, List<? extends au> paramList1, a.j.b.a.c.l.w paramw, a.j.b.a.c.b.w paramw1, az paramaz, Map<? extends a.j.b.a.c.b.a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(122281);
    paramj.a(paramak1, paramak2, paramList, paramList1, paramw, paramw1, paramaz, paramMap, f.a.CzX);
    AppMethodBeat.o(122281);
  }
  
  private final ak edq()
  {
    AppMethodBeat.i(122284);
    l locall = this.CyY.BZh;
    Object localObject = locall;
    if (!(locall instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    if (localObject != null)
    {
      localObject = ((e)localObject).edK();
      AppMethodBeat.o(122284);
      return localObject;
    }
    AppMethodBeat.o(122284);
    return null;
  }
  
  public final a.j.b.a.c.b.d a(a.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(122285);
    a.f.b.j.q(parame, "proto");
    Object localObject1 = this.CyY.BZh;
    if (localObject1 == null)
    {
      parame = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(122285);
      throw parame;
    }
    localObject1 = (e)localObject1;
    a.j.b.a.c.j.a.a.c localc = new a.j.b.a.c.j.a.a.c((e)localObject1, a((a.j.b.a.c.g.q)parame, parame.CkK, a.Cyn), paramBoolean, a.j.b.a.c.b.b.a.BVX, parame, this.CyY.BOc, this.CyY.BOd, this.CyY.CyS, this.CyY.CyT);
    Object localObject2 = k.a(this.CyY, (l)localc, (List)a.a.v.BMx).CyR;
    Object localObject3 = parame.ClC;
    a.f.b.j.p(localObject3, "proto.valueParameterList");
    localObject2 = ((q)localObject2).a((List)localObject3, (a.j.b.a.c.g.q)parame, a.Cyn);
    localObject3 = t.Czm;
    localc.a((List)localObject2, t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(parame.CkK)));
    localc.BZB = ((a.j.b.a.c.l.w)((e)localObject1).edE());
    a.f.b.j.p(localc.BZA, "descriptor.valueParameters");
    a.f.b.j.p(localc.BWy, "descriptor.typeParameters");
    localc.eds();
    localc.a(f.a.CzX);
    parame = (a.j.b.a.c.b.d)localc;
    AppMethodBeat.o(122285);
    return parame;
  }
  
  public final aq f(a.ab paramab)
  {
    AppMethodBeat.i(122283);
    a.f.b.j.q(paramab, "proto");
    Object localObject1 = a.j.b.a.c.b.a.g.BXx;
    localObject1 = paramab.Cno;
    a.f.b.j.p(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.j.b.a.c.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.CiQ;
      a.f.b.j.p(localObject3, "it");
      ((Collection)localObject1).add(((c)localObject4).b((a.j.b.a.c.e.a.a)localObject3, this.CyY.BOc));
    }
    localObject1 = g.a.fZ((List)localObject1);
    localObject2 = t.Czm;
    localObject2 = t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(paramab.CkK));
    localObject2 = new a.j.b.a.c.j.a.a.k(this.CyY.CiZ.BRT, this.CyY.BZh, (a.j.b.a.c.b.a.g)localObject1, r.b(this.CyY.BOc, paramab.ClT), (az)localObject2, paramab, this.CyY.BOc, this.CyY.BOd, this.CyY.CyS, this.CyY.CyT);
    localObject1 = this.CyY;
    Object localObject3 = (l)localObject2;
    Object localObject4 = paramab.Cld;
    a.f.b.j.p(localObject4, "proto.typeParameterList");
    localObject4 = k.a((k)localObject1, (l)localObject3, (List)localObject4);
    localObject3 = ((k)localObject4).CyQ.eoq();
    Object localObject5 = ((k)localObject4).CyQ;
    localObject1 = this.CyY.BOd;
    a.f.b.j.q(paramab, "receiver$0");
    a.f.b.j.q(localObject1, "typeTable");
    if (paramab.ejV())
    {
      localObject1 = paramab.Cnk;
      a.f.b.j.p(localObject1, "underlyingType");
      localObject1 = ((w)localObject5).s((a.aa)localObject1);
      localObject4 = ((k)localObject4).CyQ;
      localObject5 = this.CyY.BOd;
      a.f.b.j.q(paramab, "receiver$0");
      a.f.b.j.q(localObject5, "typeTable");
      if (!paramab.ejX()) {
        break label436;
      }
      paramab = paramab.Cnm;
      a.f.b.j.p(paramab, "expandedType");
    }
    for (;;)
    {
      ((a.j.b.a.c.j.a.a.k)localObject2).a((List)localObject3, (a.j.b.a.c.l.ad)localObject1, ((w)localObject4).s(paramab), f.a.CzX);
      paramab = (aq)localObject2;
      AppMethodBeat.o(122283);
      return paramab;
      if (paramab.ejW())
      {
        localObject1 = ((a.j.b.a.c.e.a.h)localObject1).Vs(paramab.Cnl);
        break;
      }
      paramab = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(122283);
      throw paramab;
      label436:
      if (!paramab.ejY()) {
        break label456;
      }
      paramab = ((a.j.b.a.c.e.a.h)localObject5).Vs(paramab.Cnn);
    }
    label456:
    paramab = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(122283);
    throw paramab;
  }
  
  public final ah g(a.u paramu)
  {
    AppMethodBeat.i(122280);
    a.f.b.j.q(paramu, "proto");
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    boolean bool1;
    label414:
    label500:
    int j;
    int k;
    if (paramu.ehx())
    {
      i = paramu.CkK;
      localObject1 = this.CyY.BZh;
      localObject2 = a((a.j.b.a.c.g.q)paramu, i, a.Cyo);
      localObject3 = t.Czm;
      localObject3 = t.a((a.r)a.j.b.a.c.e.a.b.Cok.get(i));
      localObject4 = t.Czm;
      localObject4 = t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(i));
      localObject5 = a.j.b.a.c.e.a.b.CoA.Vo(i);
      a.f.b.j.p(localObject5, "Flags.IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = r.b(this.CyY.BOc, paramu.ClT);
      Object localObject6 = t.Czm;
      localObject6 = t.a((a.q)a.j.b.a.c.e.a.b.Cos.get(i));
      Object localObject7 = a.j.b.a.c.e.a.b.CoE.Vo(i);
      a.f.b.j.p(localObject7, "Flags.IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = a.j.b.a.c.e.a.b.CoD.Vo(i);
      a.f.b.j.p(localObject7, "Flags.IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = a.j.b.a.c.e.a.b.CoG.Vo(i);
      a.f.b.j.p(localObject7, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = a.j.b.a.c.e.a.b.CoH.Vo(i);
      a.f.b.j.p(localObject7, "Flags.IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = a.j.b.a.c.e.a.b.CoI.Vo(i);
      a.f.b.j.p(localObject7, "Flags.IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new a.j.b.a.c.j.a.a.i((l)localObject1, null, (a.j.b.a.c.b.a.g)localObject2, (a.j.b.a.c.b.w)localObject3, (az)localObject4, bool1, (f)localObject5, (a.j.b.a.c.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramu, this.CyY.BOc, this.CyY.BOd, this.CyY.CyS, this.CyY.CyT);
      localObject1 = this.CyY;
      localObject2 = (l)localObject3;
      localObject4 = paramu.Cld;
      a.f.b.j.p(localObject4, "proto.typeParameterList");
      localObject4 = k.a((k)localObject1, (l)localObject2, (List)localObject4);
      localObject1 = a.j.b.a.c.e.a.b.CoB.Vo(i);
      a.f.b.j.p(localObject1, "Flags.HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!a.j.b.a.c.e.a.g.e(paramu))) {
        break label1177;
      }
      localObject1 = a((a.j.b.a.c.g.q)paramu, a.Cyp);
      localObject2 = ((k)localObject4).CyQ.r(a.j.b.a.c.e.a.g.a(paramu, this.CyY.BOd));
      localObject5 = ((k)localObject4).CyQ.eoq();
      localObject6 = edq();
      localObject7 = a.j.b.a.c.e.a.g.b(paramu, this.CyY.BOd);
      if (localObject7 == null) {
        break label1190;
      }
      localObject7 = ((k)localObject4).CyQ.r((a.aa)localObject7);
      if (localObject7 == null) {
        break label1190;
      }
      localObject1 = a.j.b.a.c.i.c.a((a.j.b.a.c.b.a)localObject3, (a.j.b.a.c.l.w)localObject7, (a.j.b.a.c.b.a.g)localObject1);
      ((a.j.b.a.c.j.a.a.i)localObject3).a((a.j.b.a.c.l.w)localObject2, (List)localObject5, (ak)localObject6, (ak)localObject1);
      localObject1 = a.j.b.a.c.e.a.b.Coi.Vo(i);
      a.f.b.j.p(localObject1, "Flags.HAS_ANNOTATIONS.get(flags)");
      j = a.j.b.a.c.e.a.b.a(((Boolean)localObject1).booleanValue(), (a.ao)a.j.b.a.c.e.a.b.Coj.get(i), (a.r)a.j.b.a.c.e.a.b.Cok.get(i));
      if (!bool1) {
        break label1231;
      }
      if (!paramu.eiZ()) {
        break label1196;
      }
      k = paramu.Cmz;
      label576:
      localObject1 = a.j.b.a.c.e.a.b.CoM.Vo(k);
      a.f.b.j.p(localObject1, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.CoN.Vo(k);
      a.f.b.j.p(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.CoO.Vo(k);
      a.f.b.j.p(localObject1, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((a.j.b.a.c.g.q)paramu, k, a.Cyp);
      if (!bool1) {
        break label1208;
      }
      localObject2 = (ah)localObject3;
      localObject5 = t.Czm;
      localObject5 = t.a((a.r)a.j.b.a.c.e.a.b.Cok.get(k));
      localObject6 = t.Czm;
      localObject6 = t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(k));
      if (bool1) {
        break label1202;
      }
      bool1 = true;
      label728:
      localObject1 = new aa((ah)localObject2, (a.j.b.a.c.b.a.g)localObject1, (a.j.b.a.c.b.w)localObject5, (az)localObject6, bool1, bool2, bool3, ((z)localObject3).BZT, null, am.BWF);
      label760:
      ((aa)localObject1).K(((a.j.b.a.c.j.a.a.i)localObject3).eds());
      localObject2 = localObject1;
      label774:
      localObject1 = a.j.b.a.c.e.a.b.CoC.Vo(i);
      a.f.b.j.p(localObject1, "Flags.HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1278;
      }
      if (paramu.eja()) {
        j = paramu.CmA;
      }
      localObject1 = a.j.b.a.c.e.a.b.CoM.Vo(j);
      a.f.b.j.p(localObject1, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.CoN.Vo(j);
      a.f.b.j.p(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.CoO.Vo(j);
      a.f.b.j.p(localObject1, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((a.j.b.a.c.g.q)paramu, j, a.Cyq);
      if (!bool1) {
        break label1243;
      }
      localObject5 = (ah)localObject3;
      localObject6 = t.Czm;
      localObject6 = t.a((a.r)a.j.b.a.c.e.a.b.Cok.get(j));
      localObject7 = t.Czm;
      localObject7 = t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(j));
      if (bool1) {
        break label1237;
      }
      bool1 = true;
      label957:
      localObject1 = new a.j.b.a.c.b.c.ab((ah)localObject5, (a.j.b.a.c.b.a.g)localObject1, (a.j.b.a.c.b.w)localObject6, (az)localObject7, bool1, bool2, bool3, ((z)localObject3).BZT, null, am.BWF);
      ((a.j.b.a.c.b.c.ab)localObject1).a((au)a.a.j.fU(k.a((k)localObject4, (l)localObject1, (List)a.a.v.BMx).CyR.a(a.a.j.listOf(paramu.Cmy), (a.j.b.a.c.g.q)paramu, a.Cyq)));
    }
    for (;;)
    {
      localObject4 = a.j.b.a.c.e.a.b.CoF.Vo(i);
      a.f.b.j.p(localObject4, "Flags.HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((a.j.b.a.c.j.a.a.i)localObject3).a(this.CyY.CiZ.BRT.m((a.f.a.a)new q.d(this, paramu, (a.j.b.a.c.j.a.a.i)localObject3)));
      }
      ((a.j.b.a.c.j.a.a.i)localObject3).a((aa)localObject2, (aj)localObject1, (a.j.b.a.c.b.r)new o(a(paramu, false), (ah)localObject3), (a.j.b.a.c.b.r)new o(a(paramu, true), (ah)localObject3), f.a.CzX);
      paramu = (ah)localObject3;
      AppMethodBeat.o(122280);
      return paramu;
      i = VS(paramu.Cmg);
      break;
      label1177:
      localObject1 = a.j.b.a.c.b.a.g.BXx;
      localObject1 = g.a.eeH();
      break label414;
      label1190:
      localObject1 = null;
      break label500;
      label1196:
      k = j;
      break label576;
      label1202:
      bool1 = false;
      break label728;
      label1208:
      localObject1 = a.j.b.a.c.i.c.a((ah)localObject3, (a.j.b.a.c.b.a.g)localObject1);
      a.f.b.j.p(localObject1, "DescriptorFactory.create…er(property, annotations)");
      break label760;
      label1231:
      localObject2 = null;
      break label774;
      label1237:
      bool1 = false;
      break label957;
      label1243:
      localObject4 = (ah)localObject3;
      localObject5 = a.j.b.a.c.b.a.g.BXx;
      localObject1 = a.j.b.a.c.i.c.a((ah)localObject4, (a.j.b.a.c.b.a.g)localObject1, g.a.eeH());
      a.f.b.j.p(localObject1, "DescriptorFactory.create…ptor */\n                )");
      continue;
      label1278:
      localObject1 = null;
    }
  }
  
  public final al g(a.o paramo)
  {
    AppMethodBeat.i(122282);
    a.f.b.j.q(paramo, "proto");
    int i;
    Object localObject3;
    label58:
    Object localObject2;
    label104:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramo.ehx())
    {
      i = paramo.CkK;
      localObject3 = a((a.j.b.a.c.g.q)paramo, i, a.Cyn);
      if (!a.j.b.a.c.e.a.g.f(paramo)) {
        break label662;
      }
      localObject1 = a((a.j.b.a.c.g.q)paramo, a.Cyn);
      if (!a.f.b.j.e(a.j.b.a.c.i.c.a.o(this.CyY.BZh).q(r.b(this.CyY.BOc, paramo.ClT)), v.Czr)) {
        break label673;
      }
      localObject2 = a.j.b.a.c.e.a.i.CoX;
      localObject2 = a.j.b.a.c.e.a.i.ekN();
      localObject4 = this.CyY.BZh;
      localObject5 = r.b(this.CyY.BOc, paramo.ClT);
      localObject6 = t.Czm;
      localObject2 = new a.j.b.a.c.j.a.a.j((l)localObject4, (a.j.b.a.c.b.a.g)localObject3, (f)localObject5, t.a((a.q)a.j.b.a.c.e.a.b.Cos.get(i)), paramo, this.CyY.BOc, this.CyY.BOd, (a.j.b.a.c.e.a.i)localObject2, this.CyY.CyT);
      localObject3 = this.CyY;
      localObject4 = (l)localObject2;
      localObject5 = paramo.Cld;
      a.f.b.j.p(localObject5, "proto.typeParameterList");
      localObject5 = k.a((k)localObject3, (l)localObject4, (List)localObject5);
      localObject3 = a.j.b.a.c.e.a.g.b(paramo, this.CyY.BOd);
      if (localObject3 == null) {
        break label685;
      }
      localObject3 = ((k)localObject5).CyQ.r((a.aa)localObject3);
      if (localObject3 == null) {
        break label685;
      }
    }
    label662:
    label673:
    label685:
    for (Object localObject1 = a.j.b.a.c.i.c.a((a.j.b.a.c.b.a)localObject2, (a.j.b.a.c.l.w)localObject3, (a.j.b.a.c.b.a.g)localObject1);; localObject1 = null)
    {
      localObject3 = edq();
      localObject4 = ((k)localObject5).CyQ.eoq();
      localObject6 = ((k)localObject5).CyR;
      Object localObject7 = paramo.ClC;
      a.f.b.j.p(localObject7, "proto.valueParameterList");
      localObject6 = ((q)localObject6).a((List)localObject7, (a.j.b.a.c.g.q)paramo, a.Cyn);
      localObject5 = ((k)localObject5).CyQ.r(a.j.b.a.c.e.a.g.a(paramo, this.CyY.BOd));
      localObject7 = t.Czm;
      localObject7 = t.a((a.r)a.j.b.a.c.e.a.b.Cok.get(i));
      Object localObject8 = t.Czm;
      localObject8 = t.a((a.ao)a.j.b.a.c.e.a.b.Coj.get(i));
      Map localMap = a.a.ad.emptyMap();
      Boolean localBoolean = a.j.b.a.c.e.a.b.Coy.Vo(i);
      a.f.b.j.p(localBoolean, "Flags.IS_SUSPEND.get(flags)");
      localBoolean.booleanValue();
      a((a.j.b.a.c.j.a.a.j)localObject2, (ak)localObject1, (ak)localObject3, (List)localObject4, (List)localObject6, (a.j.b.a.c.l.w)localObject5, (a.j.b.a.c.b.w)localObject7, (az)localObject8, localMap);
      localObject1 = a.j.b.a.c.e.a.b.Cot.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_OPERATOR.get(flags)");
      ((p)localObject2).BZF = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Cou.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_INFIX.get(flags)");
      ((p)localObject2).BZG = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Cox.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
      ((p)localObject2).BZi = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Cov.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_INLINE.get(flags)");
      ((p)localObject2).BZH = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Cow.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_TAILREC.get(flags)");
      ((p)localObject2).BZI = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Coy.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_SUSPEND.get(flags)");
      ((p)localObject2).BZN = ((Boolean)localObject1).booleanValue();
      localObject1 = a.j.b.a.c.e.a.b.Coz.Vo(i);
      a.f.b.j.p(localObject1, "Flags.IS_EXPECT_FUNCTION.get(flags)");
      ((p)localObject2).BZJ = ((Boolean)localObject1).booleanValue();
      this.CyY.CiZ.CyL.a(paramo, (a.j.b.a.c.b.t)localObject2, this.CyY.BOd, this.CyY.CyQ);
      paramo = (al)localObject2;
      AppMethodBeat.o(122282);
      return paramo;
      i = VS(paramo.Cmg);
      break;
      localObject1 = a.j.b.a.c.b.a.g.BXx;
      localObject1 = g.a.eeH();
      break label58;
      localObject2 = this.CyY.CyS;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.j.a.q
 * JD-Core Version:    0.7.0.1
 */