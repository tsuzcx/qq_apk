package a.j.b.a.c.d.a.c.a;

import a.f.a.b<-La.j.b.a.c.f.f;+Ljava.util.Collection<+La.j.b.a.c.b.al;>;>;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.ad;
import a.j.b.a.c.b.c.p;
import a.j.b.a.c.b.c.y;
import a.j.b.a.c.b.t.a;
import a.j.b.a.c.d.a.e.n;
import a.j.b.a.c.d.a.e.q;
import a.j.b.a.c.d.a.e.x;
import a.j.b.a.c.d.a.m.a;
import a.j.b.a.c.d.a.o;
import a.j.b.a.c.d.a.s;
import a.j.b.a.c.d.b.r;
import a.j.b.a.c.i.j.a;
import a.j.b.a.c.i.j.a.a;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.c.n.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends k
{
  final a.j.b.a.c.k.f<List<a.j.b.a.c.b.d>> CfU;
  private final a.j.b.a.c.k.f<Set<a.j.b.a.c.f.f>> CfV;
  private final a.j.b.a.c.k.f<Map<a.j.b.a.c.f.f, n>> CfW;
  private final a.j.b.a.c.k.d<a.j.b.a.c.f.f, a.j.b.a.c.b.c.g> CfX;
  final a.j.b.a.c.b.e CfY;
  private final a.j.b.a.c.d.a.e.g Cfx;
  
  public g(a.j.b.a.c.d.a.c.h paramh, a.j.b.a.c.b.e parame, a.j.b.a.c.d.a.e.g paramg)
  {
    super(paramh);
    AppMethodBeat.i(119952);
    this.CfY = parame;
    this.Cfx = paramg;
    this.CfU = paramh.Cfj.BRT.l((a.f.a.a)new g.f(this, paramh));
    this.CfV = paramh.Cfj.BRT.l((a.f.a.a)new i(this));
    this.CfW = paramh.Cfj.BRT.l((a.f.a.a)new g.g(this));
    this.CfX = paramh.Cfj.BRT.j((a.f.a.b)new g.j(this, paramh));
    AppMethodBeat.o(119952);
  }
  
  private final al a(ah paramah, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119927);
    Object localObject1 = paramah.eeh();
    if (localObject1 != null)
    {
      localObject1 = (a.j.b.a.c.b.ai)a.j.b.a.c.d.a.t.n((a.j.b.a.c.b.b)localObject1);
      if (localObject1 == null) {
        break label84;
      }
      localObject2 = a.j.b.a.c.d.a.e.CcN;
    }
    label84:
    for (Object localObject2 = a.j.b.a.c.d.a.e.m((a.j.b.a.c.b.b)localObject1);; localObject2 = null)
    {
      if ((localObject2 == null) || (a.j.b.a.c.d.a.t.a(this.CfY, (a.j.b.a.c.b.a)localObject1))) {
        break label90;
      }
      paramah = a(paramah, (String)localObject2, paramb);
      AppMethodBeat.o(119927);
      return paramah;
      localObject1 = null;
      break;
    }
    label90:
    localObject1 = o.ayF(paramah.edF().name);
    a.f.b.j.p(localObject1, "JvmAbi.getterName(name.asString())");
    paramah = a(paramah, (String)localObject1, paramb);
    AppMethodBeat.o(119927);
    return paramah;
  }
  
  private static al a(ah paramah, String paramString, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119928);
    paramString = a.j.b.a.c.f.f.ayT(paramString);
    a.f.b.j.p(paramString, "Name.identifier(getterName)");
    paramb = ((Iterable)paramb.S(paramString)).iterator();
    label119:
    label122:
    while (paramb.hasNext())
    {
      paramString = (al)paramb.next();
      a.j.b.a.c.l.a.c localc;
      a.j.b.a.c.l.w localw;
      boolean bool;
      if (paramString.edu().size() == 0)
      {
        localc = a.j.b.a.c.l.a.c.CCi;
        localw = paramString.eds();
        if (localw == null)
        {
          bool = false;
          if (!bool) {
            break label119;
          }
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label122;
        }
        AppMethodBeat.o(119928);
        return paramString;
        bool = localc.c(localw, paramah.eer());
        break;
        paramString = null;
      }
    }
    AppMethodBeat.o(119928);
    return null;
  }
  
  private static al a(al paramal, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119934);
    if (!paramal.edU())
    {
      AppMethodBeat.o(119934);
      return null;
    }
    Object localObject = paramal.edF();
    a.f.b.j.p(localObject, "descriptor.name");
    localObject = ((Iterable)paramb.S(localObject)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramb = h((al)((Iterator)localObject).next());
      if (paramb != null) {
        if (!b((a.j.b.a.c.b.a)paramb, (a.j.b.a.c.b.a)paramal)) {}
      }
      while (paramb != null)
      {
        AppMethodBeat.o(119934);
        return paramb;
        paramb = null;
        continue;
        paramb = null;
      }
    }
    AppMethodBeat.o(119934);
    return null;
  }
  
  private static al a(al paramal, a.j.b.a.c.b.a parama, Collection<? extends al> paramCollection)
  {
    AppMethodBeat.i(119935);
    paramCollection = (Iterable)paramCollection;
    if ((!(paramCollection instanceof Collection)) || (!((Collection)paramCollection).isEmpty()))
    {
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        al localal = (al)paramCollection.next();
        if (((a.f.b.j.e(paramal, localal) ^ true)) && (localal.edP() == null) && (b((a.j.b.a.c.b.a)localal, parama)))
        {
          i = 1;
          label91:
          if (i == 0) {
            break label111;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label118;
      }
      AppMethodBeat.o(119935);
      return paramal;
      i = 0;
      break label91;
      label111:
      break;
    }
    label118:
    paramal = paramal.edV().edZ().eeb();
    if (paramal == null) {
      a.f.b.j.ebi();
    }
    paramal = (al)paramal;
    AppMethodBeat.o(119935);
    return paramal;
  }
  
  private static al a(al paramal, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119924);
    paramal = paramal.edV();
    paramal.e(paramf);
    paramal.edW();
    paramal.edX();
    paramal = paramal.eeb();
    if (paramal == null) {
      a.f.b.j.ebi();
    }
    paramal = (al)paramal;
    AppMethodBeat.o(119924);
    return paramal;
  }
  
  private final void a(a.j.b.a.c.f.f paramf, Collection<? extends al> paramCollection1, Collection<? extends al> paramCollection2, Collection<al> paramCollection, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119933);
    Iterator localIterator = paramCollection2.iterator();
    if (localIterator.hasNext())
    {
      al localal = (al)localIterator.next();
      paramCollection2 = (al)a.j.b.a.c.d.a.t.n((a.j.b.a.c.b.b)localal);
      label51:
      label52:
      label54:
      Object localObject1;
      if (paramCollection2 == null)
      {
        break label149;
        paramCollection2 = null;
        a.j.b.a.c.n.a.b(paramCollection, paramCollection2);
        localObject1 = a.j.b.a.c.d.a.d.e((a.j.b.a.c.b.t)localal);
        if (localObject1 != null) {
          break label201;
        }
        paramCollection2 = null;
      }
      for (;;)
      {
        a.j.b.a.c.n.a.b(paramCollection, paramCollection2);
        a.j.b.a.c.n.a.b(paramCollection, a(localal, paramb));
        break;
        localObject1 = a.j.b.a.c.d.a.t.q((a.j.b.a.c.b.b)paramCollection2);
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        localObject1 = a.j.b.a.c.f.f.ayT((String)localObject1);
        a.f.b.j.p(localObject1, "Name.identifier(nameInJava)");
        localObject1 = ((Collection)paramb.S(localObject1)).iterator();
        label149:
        if (!((Iterator)localObject1).hasNext()) {
          break label52;
        }
        Object localObject2 = a((al)((Iterator)localObject1).next(), paramf);
        if (!a(paramCollection2, (a.j.b.a.c.b.t)localObject2)) {
          break label51;
        }
        paramCollection2 = a((al)localObject2, (a.j.b.a.c.b.a)paramCollection2, paramCollection1);
        break label54;
        label201:
        paramCollection2 = ((a.j.b.a.c.b.t)localObject1).edF();
        a.f.b.j.p(paramCollection2, "overridden.name");
        localObject2 = ((Iterable)paramb.S(paramCollection2)).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramCollection2 = ((Iterator)localObject2).next();
        } while (!b((al)paramCollection2, (a.j.b.a.c.b.t)localObject1));
        for (;;)
        {
          localObject2 = (al)paramCollection2;
          if (localObject2 == null) {
            break label518;
          }
          paramCollection2 = ((al)localObject2).edV();
          localObject3 = ((a.j.b.a.c.b.t)localObject1).edu();
          a.f.b.j.p(localObject3, "overridden.valueParameters");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            au localau = (au)((Iterator)localObject4).next();
            a.f.b.j.p(localau, "it");
            a.j.b.a.c.l.w localw = localau.eer();
            a.f.b.j.p(localw, "it.type");
            ((Collection)localObject3).add(new a.j.b.a.c.d.a.b.j(localw, localau.eet()));
          }
          paramCollection2 = null;
        }
        Object localObject3 = (Collection)localObject3;
        localObject2 = ((al)localObject2).edu();
        a.f.b.j.p(localObject2, "override.valueParameters");
        paramCollection2.fY(a.j.b.a.c.d.a.b.i.a((Collection)localObject3, (Collection)localObject2, (a.j.b.a.c.b.a)localObject1));
        paramCollection2.edW();
        paramCollection2.edX();
        paramCollection2 = (al)paramCollection2.eeb();
        label485:
        if (paramCollection2 != null)
        {
          if (((g)this).d(paramCollection2)) {}
          for (;;)
          {
            if (paramCollection2 == null) {
              break label528;
            }
            paramCollection2 = a(paramCollection2, (a.j.b.a.c.b.a)localObject1, paramCollection1);
            break;
            paramCollection2 = null;
            break label485;
            paramCollection2 = null;
          }
        }
        label518:
        label528:
        paramCollection2 = null;
      }
    }
    AppMethodBeat.o(119933);
  }
  
  private final void a(Collection<al> paramCollection, Collection<? extends al> paramCollection1, boolean paramBoolean)
  {
    AppMethodBeat.i(119932);
    paramCollection1 = a.j.b.a.c.d.a.a.a.a(paramCollection1, paramCollection, this.CfY, this.Cfb.Cfj.CeJ);
    a.f.b.j.p(paramCollection1, "resolveOverridesForNonSt…s.errorReporter\n        )");
    if (!paramBoolean)
    {
      paramCollection.addAll(paramCollection1);
      AppMethodBeat.o(119932);
      return;
    }
    List localList = a.a.j.b(paramCollection, (Iterable)paramCollection1);
    paramCollection1 = (Iterable)paramCollection1;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d(paramCollection1));
    Iterator localIterator = paramCollection1.iterator();
    if (localIterator.hasNext())
    {
      paramCollection1 = (al)localIterator.next();
      al localal = (al)a.j.b.a.c.d.a.t.p((a.j.b.a.c.b.b)paramCollection1);
      if (localal == null) {}
      for (;;)
      {
        localCollection.add(paramCollection1);
        break;
        a.f.b.j.p(paramCollection1, "resolvedOverride");
        paramCollection1 = a(paramCollection1, (a.j.b.a.c.b.a)localal, (Collection)localList);
      }
    }
    paramCollection.addAll((Collection)localCollection);
    AppMethodBeat.o(119932);
  }
  
  private final void a(List<au> paramList, a.j.b.a.c.b.k paramk, int paramInt, q paramq, a.j.b.a.c.l.w paramw1, a.j.b.a.c.l.w paramw2)
  {
    AppMethodBeat.i(119943);
    a.j.b.a.c.b.a locala = (a.j.b.a.c.b.a)paramk;
    paramk = a.j.b.a.c.b.a.g.BXx;
    a.j.b.a.c.b.a.g localg = g.a.eeH();
    a.j.b.a.c.f.f localf = paramq.edF();
    paramw1 = av.aA(paramw1);
    a.f.b.j.p(paramw1, "TypeUtils.makeNotNullable(returnType)");
    boolean bool = paramq.egv();
    if (paramw2 != null) {}
    for (paramk = av.aA(paramw2);; paramk = null)
    {
      paramList.add(new a.j.b.a.c.b.c.ai(locala, null, paramInt, localg, localf, paramw1, bool, false, false, paramk, (am)this.Cfb.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)paramq)));
      AppMethodBeat.o(119943);
      return;
    }
  }
  
  private final void a(Set<? extends ah> paramSet, Collection<ah> paramCollection, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119938);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      a.j.b.a.c.d.a.b.f localf = d((ah)paramSet.next(), paramb);
      if (localf != null)
      {
        paramCollection.add(localf);
        AppMethodBeat.o(119938);
        return;
      }
    }
    AppMethodBeat.o(119938);
  }
  
  private static boolean a(al paramal, a.j.b.a.c.b.t paramt)
  {
    AppMethodBeat.i(119925);
    a.j.b.a.c.d.a.c localc = a.j.b.a.c.d.a.c.Ccl;
    if (a.j.b.a.c.d.a.c.c(paramal)) {
      paramt = paramt.edO();
    }
    for (;;)
    {
      a.f.b.j.p(paramt, "if (superDescriptor.isRe…iginal else subDescriptor");
      boolean bool = b((a.j.b.a.c.b.a)paramt, (a.j.b.a.c.b.a)paramal);
      AppMethodBeat.o(119925);
      return bool;
    }
  }
  
  private static al b(ah paramah, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119929);
    Object localObject1 = a.j.b.a.c.f.f.ayT(o.ayG(paramah.edF().name));
    a.f.b.j.p(localObject1, "Name.identifier(JvmAbi.s…terName(name.asString()))");
    localObject1 = ((Iterable)paramb.S(localObject1)).iterator();
    label172:
    while (((Iterator)localObject1).hasNext())
    {
      paramb = (al)((Iterator)localObject1).next();
      Object localObject2;
      if (paramb.edu().size() == 1)
      {
        localObject2 = paramb.eds();
        if (localObject2 != null) {}
      }
      else
      {
        paramb = null;
      }
      for (;;)
      {
        if (paramb == null) {
          break label172;
        }
        AppMethodBeat.o(119929);
        return paramb;
        if (!a.j.b.a.c.a.g.D((a.j.b.a.c.l.w)localObject2)) {
          break;
        }
        localObject2 = a.j.b.a.c.l.a.c.CCi;
        Object localObject3 = paramb.edu();
        a.f.b.j.p(localObject3, "descriptor.valueParameters");
        localObject3 = a.a.j.fU((List)localObject3);
        a.f.b.j.p(localObject3, "descriptor.valueParameters.single()");
        if (!((a.j.b.a.c.l.a.c)localObject2).d(((au)localObject3).eer(), paramah.eer())) {
          break;
        }
      }
    }
    AppMethodBeat.o(119929);
    return null;
  }
  
  private static boolean b(a.j.b.a.c.b.a parama1, a.j.b.a.c.b.a parama2)
  {
    AppMethodBeat.i(119926);
    Object localObject = a.j.b.a.c.i.j.Cwb.a(parama2, parama1, true);
    a.f.b.j.p(localObject, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
    localObject = ((j.a)localObject).Cwn;
    a.f.b.j.p(localObject, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
    if (localObject == j.a.a.Cwp)
    {
      localObject = a.j.b.a.c.d.a.m.CcT;
      if (!m.a.a(parama2, parama1))
      {
        AppMethodBeat.o(119926);
        return true;
      }
    }
    AppMethodBeat.o(119926);
    return false;
  }
  
  private static boolean b(al paramal, a.j.b.a.c.b.t paramt)
  {
    AppMethodBeat.i(119942);
    String str = r.a((a.j.b.a.c.b.t)paramal, false, false, 2);
    a.j.b.a.c.b.t localt = paramt.edO();
    a.f.b.j.p(localt, "builtinWithErasedParameters.original");
    if ((a.f.b.j.e(str, r.a(localt, false, false, 2))) && (!b((a.j.b.a.c.b.a)paramal, (a.j.b.a.c.b.a)paramt)))
    {
      AppMethodBeat.o(119942);
      return true;
    }
    AppMethodBeat.o(119942);
    return false;
  }
  
  private final boolean c(ah paramah, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    AppMethodBeat.i(119930);
    if (c.e(paramah))
    {
      AppMethodBeat.o(119930);
      return false;
    }
    al localal = a(paramah, paramb);
    paramb = b(paramah, paramb);
    if (localal == null)
    {
      AppMethodBeat.o(119930);
      return false;
    }
    if (!paramah.eey())
    {
      AppMethodBeat.o(119930);
      return true;
    }
    if ((paramb != null) && (paramb.ecC() == localal.ecC()))
    {
      AppMethodBeat.o(119930);
      return true;
    }
    AppMethodBeat.o(119930);
    return false;
  }
  
  private final a.j.b.a.c.d.a.b.f d(ah paramah, a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>> paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(119939);
    if (!c(paramah, paramb))
    {
      AppMethodBeat.o(119939);
      return null;
    }
    al localal = a(paramah, paramb);
    if (localal == null) {
      a.f.b.j.ebi();
    }
    int i;
    if (paramah.eey())
    {
      localObject1 = b(paramah, paramb);
      paramb = (a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>>)localObject1;
      if (localObject1 == null)
      {
        a.f.b.j.ebi();
        paramb = (a.f.a.b<? super a.j.b.a.c.f.f, ? extends Collection<? extends al>>)localObject1;
      }
      if (paramb == null) {
        break label204;
      }
      if (paramb.ecC() != localal.ecC()) {
        break label199;
      }
      i = 1;
      label94:
      if ((!a.aa.BMh) || (i != 0)) {
        break label214;
      }
      localObject1 = new StringBuilder("Different accessors modalities when creating overrides for ").append(paramah).append(" in ").append(this.CfY).append("for getter is ").append(localal.ecC()).append(", but for setter is ");
      if (paramb == null) {
        break label209;
      }
    }
    label199:
    label204:
    label209:
    for (paramah = paramb.ecC();; paramah = null)
    {
      paramah = (Throwable)new AssertionError(paramah);
      AppMethodBeat.o(119939);
      throw paramah;
      paramb = null;
      break;
      i = 0;
      break label94;
      i = 1;
      break label94;
    }
    label214:
    Object localObject1 = (a.j.b.a.c.b.l)this.CfY;
    Object localObject2 = a.j.b.a.c.b.a.g.BXx;
    localObject2 = g.a.eeH();
    a.j.b.a.c.b.w localw = localal.ecC();
    az localaz = localal.ecE();
    if (paramb != null) {}
    for (;;)
    {
      localObject1 = a.j.b.a.c.d.a.b.f.a((a.j.b.a.c.b.l)localObject1, (a.j.b.a.c.b.a.g)localObject2, localw, localaz, bool, paramah.edF(), localal.ecN(), false);
      a.f.b.j.p(localObject1, "JavaPropertyDescriptor.c…inal = */ false\n        )");
      paramah = localal.eds();
      if (paramah == null) {
        a.f.b.j.ebi();
      }
      ((a.j.b.a.c.d.a.b.f)localObject1).a(paramah, (List)a.a.v.BMx, edq(), null);
      localObject2 = a.j.b.a.c.i.c.a((ah)localObject1, localal.ecM(), false, localal.ecN());
      ((y)localObject2).BZU = ((a.j.b.a.c.b.t)localal);
      ((a.j.b.a.c.b.c.aa)localObject2).K(((a.j.b.a.c.d.a.b.f)localObject1).eer());
      a.f.b.j.p(localObject2, "DescriptorFactory.create…escriptor.type)\n        }");
      if (paramb == null) {
        break label504;
      }
      paramah = paramb.edu();
      a.f.b.j.p(paramah, "setterMethod.valueParameters");
      paramah = (au)a.a.j.fR(paramah);
      if (paramah != null) {
        break;
      }
      paramah = (Throwable)new AssertionError("No parameter found for ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(119939);
      throw paramah;
      bool = false;
    }
    paramah = a.j.b.a.c.i.c.a((ah)localObject1, paramb.ecM(), paramah.ecM(), false, paramb.ecE(), paramb.ecN());
    paramah.BZU = ((a.j.b.a.c.b.t)paramb);
    for (;;)
    {
      ((a.j.b.a.c.d.a.b.f)localObject1).a((a.j.b.a.c.b.c.aa)localObject2, (a.j.b.a.c.b.aj)paramah);
      AppMethodBeat.o(119939);
      return localObject1;
      label504:
      paramah = null;
    }
  }
  
  private final boolean d(al paramal)
  {
    AppMethodBeat.i(119919);
    Object localObject1 = paramal.edF();
    a.f.b.j.p(localObject1, "function.name");
    localObject1 = (Iterable)s.j((a.j.b.a.c.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Iterable)n((a.j.b.a.c.f.f)((Iterator)localObject1).next());
        label181:
        label187:
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label111:
          if (((Iterator)localObject2).hasNext())
          {
            ah localah = (ah)((Iterator)localObject2).next();
            if ((c(localah, (a.f.a.b)new g.h(this, paramal))) && ((localah.eey()) || (!o.ayE(paramal.edF().name))))
            {
              i = 1;
              if (i == 0) {
                break label208;
              }
              i = 1;
              if (i == 0) {
                break label213;
              }
            }
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label220;
      }
      AppMethodBeat.o(119919);
      return false;
      i = 0;
      break label181;
      label208:
      break label111;
      i = 0;
      break label187;
      label213:
      break;
    }
    label220:
    if ((!f(paramal)) && (!e(paramal)) && (!g(paramal)))
    {
      AppMethodBeat.o(119919);
      return true;
    }
    AppMethodBeat.o(119919);
    return false;
  }
  
  private final boolean e(al paramal)
  {
    AppMethodBeat.i(119920);
    Object localObject1 = a.j.b.a.c.d.a.d.Ccu;
    localObject1 = paramal.edF();
    a.f.b.j.p(localObject1, "name");
    if (!a.j.b.a.c.d.a.d.h((a.j.b.a.c.f.f)localObject1))
    {
      AppMethodBeat.o(119920);
      return false;
    }
    localObject1 = paramal.edF();
    a.f.b.j.p(localObject1, "name");
    Object localObject2 = (Iterable)m((a.j.b.a.c.f.f)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.j.b.a.c.b.t localt = a.j.b.a.c.d.a.d.e((a.j.b.a.c.b.t)((Iterator)localObject2).next());
      if (localt != null) {
        ((Collection)localObject1).add(localt);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (!((Collection)localObject1).isEmpty())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (b(paramal, (a.j.b.a.c.b.t)((Iterator)localObject1).next()))
        {
          AppMethodBeat.o(119920);
          return true;
        }
      }
    }
    AppMethodBeat.o(119920);
    return false;
  }
  
  private final boolean f(al paramal)
  {
    AppMethodBeat.i(119921);
    Object localObject1 = a.j.b.a.c.d.a.c.Ccl;
    localObject1 = paramal.edF();
    a.f.b.j.p(localObject1, "name");
    localObject1 = (Iterable)a.j.b.a.c.d.a.c.g((a.j.b.a.c.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (a.j.b.a.c.f.f)((Iterator)localObject1).next();
        Object localObject4 = (Iterable)m((a.j.b.a.c.f.f)localObject2);
        Object localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (a.j.b.a.c.d.a.t.o((a.j.b.a.c.b.b)localObject5)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (!((List)localObject3).isEmpty())
        {
          localObject2 = a(paramal, (a.j.b.a.c.f.f)localObject2);
          localObject3 = (Iterable)localObject3;
          if (!((Collection)localObject3).isEmpty())
          {
            localObject3 = ((Iterable)localObject3).iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!a((al)((Iterator)localObject3).next(), (a.j.b.a.c.b.t)localObject2));
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(119921);
          return true;
        }
      }
    }
    AppMethodBeat.o(119921);
    return false;
  }
  
  private final boolean g(al paramal)
  {
    AppMethodBeat.i(119922);
    al localal1 = h(paramal);
    if (localal1 == null)
    {
      AppMethodBeat.o(119922);
      return false;
    }
    paramal = paramal.edF();
    a.f.b.j.p(paramal, "name");
    paramal = (Iterable)m(paramal);
    if (!((Collection)paramal).isEmpty())
    {
      paramal = paramal.iterator();
      while (paramal.hasNext())
      {
        al localal2 = (al)paramal.next();
        if ((localal2.edU()) && (b((a.j.b.a.c.b.a)localal1, (a.j.b.a.c.b.a)localal2))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(119922);
          return true;
        }
      }
    }
    AppMethodBeat.o(119922);
    return false;
  }
  
  private static al h(al paramal)
  {
    AppMethodBeat.i(119923);
    Object localObject1 = paramal.edu();
    a.f.b.j.p(localObject1, "valueParameters");
    Object localObject2 = (au)a.a.j.fT((List)localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((au)localObject2).eer().enU().ecR();
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = a.j.b.a.c.i.c.a.q((a.j.b.a.c.b.l)localObject1);
      if (localObject1 == null) {
        break label106;
      }
      if (!((a.j.b.a.c.f.c)localObject1).eme()) {
        break label101;
      }
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = ((a.j.b.a.c.f.c)localObject1).emf();
      label79:
      if (!a.j.b.a.c.a.k.a((a.j.b.a.c.f.b)localObject1, false)) {
        break label111;
      }
    }
    label101:
    label106:
    label111:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label116;
      }
      AppMethodBeat.o(119923);
      return null;
      localObject1 = null;
      break;
      localObject1 = null;
      break label79;
    }
    label116:
    localObject2 = paramal.edV();
    paramal = paramal.edu();
    a.f.b.j.p(paramal, "valueParameters");
    paramal = (al)((t.a)localObject2).fY(a.a.j.fW(paramal)).I(((ap)((au)localObject1).eer().enR().get(0)).eer()).eeb();
    localObject1 = (ad)paramal;
    if (localObject1 != null) {
      ((p)localObject1).BZN = true;
    }
    AppMethodBeat.o(119923);
    return paramal;
  }
  
  private final Set<al> m(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119936);
    Object localObject1 = this.CfY.ecx();
    a.f.b.j.p(localObject1, "ownerDescriptor.typeConstructor");
    localObject1 = ((an)localObject1).eeO();
    a.f.b.j.p(localObject1, "ownerDescriptor.typeConstructor.supertypes");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((a.j.b.a.c.l.w)((Iterator)localObject2).next()).ecq().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbH));
    }
    paramf = (Set)localObject1;
    AppMethodBeat.o(119936);
    return paramf;
  }
  
  private final Set<ah> n(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119940);
    Object localObject1 = this.CfY.ecx();
    a.f.b.j.p(localObject1, "ownerDescriptor.typeConstructor");
    localObject1 = ((an)localObject1).eeO();
    a.f.b.j.p(localObject1, "ownerDescriptor.typeConstructor.supertypes");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Iterable)((a.j.b.a.c.l.w)((Iterator)localObject2).next()).ecq().a(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbH);
      Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((ah)((Iterator)localObject3).next());
      }
      a.a.j.a((Collection)localObject1, (Iterable)localCollection);
    }
    paramf = a.a.j.o((Iterable)localObject1);
    AppMethodBeat.o(119940);
    return paramf;
  }
  
  protected final k.a a(q paramq, List<? extends ar> paramList, a.j.b.a.c.l.w paramw, List<? extends au> paramList1)
  {
    AppMethodBeat.i(119941);
    a.f.b.j.q(paramq, "method");
    a.f.b.j.q(paramList, "methodTypeParameters");
    a.f.b.j.q(paramw, "returnType");
    a.f.b.j.q(paramList1, "valueParameters");
    Object localObject = this.Cfb.Cfj.CeI.a(paramw, paramList1, paramList);
    a.f.b.j.p(localObject, "c.components.signaturePr…dTypeParameters\n        )");
    paramq = ((a.j.b.a.c.d.a.a.k.a)localObject).CaW;
    a.f.b.j.p(paramq, "propagated.returnType");
    paramList = ((a.j.b.a.c.d.a.a.k.a)localObject).Ceg;
    paramw = ((a.j.b.a.c.d.a.a.k.a)localObject).Ceh;
    a.f.b.j.p(paramw, "propagated.valueParameters");
    paramList1 = ((a.j.b.a.c.d.a.a.k.a)localObject).BWy;
    a.f.b.j.p(paramList1, "propagated.typeParameters");
    boolean bool = ((a.j.b.a.c.d.a.a.k.a)localObject).BZO;
    localObject = ((a.j.b.a.c.d.a.a.k.a)localObject).Cei;
    a.f.b.j.p(localObject, "propagated.errors");
    paramq = new k.a(paramq, paramList, paramw, paramList1, bool, (List)localObject);
    AppMethodBeat.o(119941);
    return paramq;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119947);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    paramf = super.a(paramf, parama);
    AppMethodBeat.o(119947);
    return paramf;
  }
  
  protected final Set<a.j.b.a.c.f.f> a(a.j.b.a.c.i.e.d paramd)
  {
    AppMethodBeat.i(119949);
    a.f.b.j.q(paramd, "kindFilter");
    if (this.Cfx.egg())
    {
      paramd = eeT();
      AppMethodBeat.o(119949);
      return paramd;
    }
    paramd = new LinkedHashSet((Collection)((b)this.Cgq.invoke()).efN());
    Object localObject = this.CfY.ecx();
    a.f.b.j.p(localObject, "ownerDescriptor.typeConstructor");
    localObject = ((an)localObject).eeO();
    a.f.b.j.p(localObject, "ownerDescriptor.typeConstructor.supertypes");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterable localIterable = (Iterable)((a.j.b.a.c.l.w)((Iterator)localObject).next()).ecq().eeU();
      a.a.j.a((Collection)paramd, localIterable);
    }
    paramd = (Set)paramd;
    AppMethodBeat.o(119949);
    return paramd;
  }
  
  protected final void a(a.j.b.a.c.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(119937);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "result");
    if (this.Cfx.egg())
    {
      localObject1 = (q)a.a.j.i((Iterable)((b)this.Cgq.invoke()).k(paramf));
      if (localObject1 != null) {
        break label86;
      }
    }
    for (;;)
    {
      paramf = n(paramf);
      if (!paramf.isEmpty()) {
        break;
      }
      AppMethodBeat.o(119937);
      return;
      label86:
      Object localObject2 = a.j.b.a.c.b.w.BWp;
      Object localObject3 = a.j.b.a.c.d.a.c.f.a(this.Cfb, (a.j.b.a.c.d.a.e.d)localObject1);
      localObject2 = a.j.b.a.c.d.a.b.f.a((a.j.b.a.c.b.l)this.CfY, (a.j.b.a.c.b.a.g)localObject3, (a.j.b.a.c.b.w)localObject2, ((q)localObject1).ecE(), false, ((q)localObject1).edF(), (am)this.Cfb.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)localObject1), false);
      a.f.b.j.p(localObject2, "JavaPropertyDescriptor.c…inal = */ false\n        )");
      localObject3 = (ah)localObject2;
      g.a locala = a.j.b.a.c.b.a.g.BXx;
      localObject3 = a.j.b.a.c.i.c.a((ah)localObject3, g.a.eeH());
      a.f.b.j.p(localObject3, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
      ((a.j.b.a.c.d.a.b.f)localObject2).a((a.j.b.a.c.b.c.aa)localObject3, null);
      localObject1 = a((q)localObject1, a.j.b.a.c.d.a.c.a.a(this.Cfb, (a.j.b.a.c.b.l)localObject2, (x)localObject1, 0));
      ((a.j.b.a.c.d.a.b.f)localObject2).a((a.j.b.a.c.l.w)localObject1, (List)a.a.v.BMx, edq(), null);
      ((a.j.b.a.c.b.c.aa)localObject3).K((a.j.b.a.c.l.w)localObject1);
      paramCollection.add(localObject2);
    }
    Object localObject1 = a.j.b.a.c.n.i.CFl;
    localObject1 = i.b.epb();
    a(paramf, paramCollection, (a.f.a.b)new g.d(this));
    a(paramf, (Collection)localObject1, (a.f.a.b)new g.e(this));
    paramf = a.j.b.a.c.d.a.a.a.a((Collection)a.a.aj.a(paramf, (Iterable)localObject1), paramCollection, this.CfY, this.Cfb.Cfj.CeJ);
    a.f.b.j.p(paramf, "resolveOverridesForNonSt…rorReporter\n            )");
    paramCollection.addAll(paramf);
    AppMethodBeat.o(119937);
  }
  
  protected final void a(Collection<al> paramCollection, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119931);
    a.f.b.j.q(paramCollection, "result");
    a.f.b.j.q(paramf, "name");
    Object localObject1 = m(paramf);
    Object localObject2 = a.j.b.a.c.d.a.c.Ccl;
    if (!a.j.b.a.c.d.a.c.f(paramf))
    {
      localObject2 = a.j.b.a.c.d.a.d.Ccu;
      if (!a.j.b.a.c.d.a.d.h(paramf))
      {
        localObject2 = (Iterable)localObject1;
        int i;
        if (!((Collection)localObject2).isEmpty())
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((a.j.b.a.c.b.t)((Iterator)localObject2).next()).edU()) {
              i = 0;
            }
          }
        }
        while (i != 0)
        {
          localObject1 = (Iterable)localObject1;
          paramf = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              if (d((al)localObject2))
              {
                paramf.add(localObject2);
                continue;
                i = 1;
                break;
              }
            }
          }
          a(paramCollection, (Collection)paramf, false);
          AppMethodBeat.o(119931);
          return;
        }
      }
    }
    localObject2 = a.j.b.a.c.n.i.CFl;
    localObject2 = i.b.epb();
    Object localObject3 = a.j.b.a.c.d.a.a.a.a((Collection)localObject1, (Collection)a.a.v.BMx, this.CfY, a.j.b.a.c.j.a.m.CyU);
    a.f.b.j.p(localObject3, "resolveOverridesForNonSt…rter.DO_NOTHING\n        )");
    a(paramf, paramCollection, (Collection)localObject3, paramCollection, (a.f.a.b)new b((g)this));
    a(paramf, paramCollection, (Collection)localObject3, (Collection)localObject2, (a.f.a.b)new g.c((g)this));
    localObject1 = (Iterable)localObject1;
    paramf = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (d((al)localObject3)) {
        paramf.add(localObject3);
      }
    }
    a(paramCollection, (Collection)a.a.j.b((Collection)paramf, (Iterable)localObject2), true);
    AppMethodBeat.o(119931);
  }
  
  protected final boolean a(a.j.b.a.c.d.a.b.e parame)
  {
    AppMethodBeat.i(119918);
    a.f.b.j.q(parame, "receiver$0");
    if (this.Cfx.egg())
    {
      AppMethodBeat.o(119918);
      return false;
    }
    boolean bool = d((al)parame);
    AppMethodBeat.o(119918);
    return bool;
  }
  
  public final Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119946);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    paramf = super.b(paramf, parama);
    AppMethodBeat.o(119946);
    return paramf;
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119945);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    paramf = (a.j.b.a.c.b.h)this.CfX.S(paramf);
    AppMethodBeat.o(119945);
    return paramf;
  }
  
  protected final Set<a.j.b.a.c.f.f> c(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(119948);
    a.f.b.j.q(paramd, "kindFilter");
    paramd = a.a.aj.a((Set)this.CfV.invoke(), (Iterable)((Map)this.CfW.invoke()).keySet());
    AppMethodBeat.o(119948);
    return paramd;
  }
  
  public final void d(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119950);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    a.j.b.a.c.c.a.a(this.Cfb.Cfj.CeQ, parama, this.CfY, paramf);
    AppMethodBeat.o(119950);
  }
  
  protected final ak edq()
  {
    AppMethodBeat.i(119944);
    ak localak = a.j.b.a.c.i.d.l((a.j.b.a.c.b.l)this.CfY);
    AppMethodBeat.o(119944);
    return localak;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119951);
    String str = "Lazy Java member scope for " + this.Cfx.eee();
    AppMethodBeat.o(119951);
    return str;
  }
  
  static final class b
    extends a.f.b.i
    implements a.f.a.b<a.j.b.a.c.f.f, Collection<? extends al>>
  {
    b(g paramg)
    {
      super();
    }
    
    public final String dyz()
    {
      return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }
    
    public final a.j.d ebe()
    {
      AppMethodBeat.i(119905);
      a.j.b localb = a.f.b.v.aG(g.class);
      AppMethodBeat.o(119905);
      return localb;
    }
    
    public final String getName()
    {
      return "searchMethodsByNameWithoutBuiltinMagic";
    }
  }
  
  static final class i
    extends a.f.b.k
    implements a.f.a.a<Set<? extends a.j.b.a.c.f.f>>
  {
    i(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */