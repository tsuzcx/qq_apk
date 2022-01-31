package a.j.b.a.c.h;

import a.aa;
import a.j.b.a.c.a.g.b;
import a.j.b.a.c.b.aa.b;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.af;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.as;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.aw;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.l.ag;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.bb;
import a.j.b.a.c.l.p.d;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  extends c
  implements i
{
  private final a.f CtO;
  private final a.f CtP;
  final j CtQ;
  
  static
  {
    AppMethodBeat.i(121758);
    eOJ = new k[] { (k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(e.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), (k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(e.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;")) };
    AppMethodBeat.o(121758);
  }
  
  public e(j paramj)
  {
    AppMethodBeat.i(121817);
    this.CtQ = paramj;
    boolean bool = this.CtQ.Cul;
    if ((aa.BMh) && (!bool))
    {
      paramj = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(121817);
      throw paramj;
    }
    this.CtO = a.g.j((a.f.a.a)new e.c(this));
    this.CtP = a.g.j((a.f.a.a)new e.d(this));
    AppMethodBeat.o(121817);
  }
  
  private static boolean W(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121774);
    if (a.j.b.a.c.a.f.f(paramw))
    {
      paramw = (Iterable)paramw.enR();
      if ((!(paramw instanceof Collection)) || (!((Collection)paramw).isEmpty()))
      {
        paramw = paramw.iterator();
        do
        {
          if (!paramw.hasNext()) {
            break;
          }
        } while (!((ap)paramw.next()).eoN());
      }
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(121774);
        return true;
      }
    }
    AppMethodBeat.o(121774);
    return false;
  }
  
  private static boolean X(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121785);
    if ((a.j.b.a.c.a.f.e(paramw)) || (!paramw.ecM().isEmpty()))
    {
      AppMethodBeat.o(121785);
      return true;
    }
    AppMethodBeat.o(121785);
    return false;
  }
  
  private String a(an paraman)
  {
    AppMethodBeat.i(121781);
    a.f.b.j.q(paraman, "typeConstructor");
    a.j.b.a.c.b.h localh = paraman.ecR();
    if (((localh instanceof ar)) || ((localh instanceof a.j.b.a.c.b.e)) || ((localh instanceof aq)))
    {
      paraman = b(localh);
      AppMethodBeat.o(121781);
      return paraman;
    }
    if (localh == null)
    {
      paraman = paraman.toString();
      AppMethodBeat.o(121781);
      return paraman;
    }
    paraman = (Throwable)new IllegalStateException(("Unexpected classifier: " + localh.getClass()).toString());
    AppMethodBeat.o(121781);
    throw paraman;
  }
  
  private final void a(a.j.b.a.c.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121803);
    if (!((Boolean)this.CtQ.CuL.a(j.eOJ[25])).booleanValue())
    {
      AppMethodBeat.o(121803);
      return;
    }
    parama = parama.edp();
    if (parama != null)
    {
      paramStringBuilder = paramStringBuilder.append(" on ");
      parama = parama.eer();
      a.f.b.j.p(parama, "receiver.type");
      paramStringBuilder.append(b(parama));
    }
    AppMethodBeat.o(121803);
  }
  
  private final void a(ar paramar, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(121800);
    if (paramBoolean) {
      paramStringBuilder.append(escape("<"));
    }
    if (this.CtQ.enx()) {
      paramStringBuilder.append("/*").append(paramar.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, paramar.edH(), "reified");
    Object localObject = paramar.edG().label;
    boolean bool;
    if (((CharSequence)localObject).length() > 0)
    {
      bool = true;
      a(paramStringBuilder, bool, (String)localObject);
      a(paramStringBuilder, (a.j.b.a.c.b.a.a)paramar, null);
      a((l)paramar, paramStringBuilder, paramBoolean);
      i = paramar.ebo().size();
      if (((i <= 1) || (paramBoolean)) && (i != 1)) {
        break label237;
      }
      paramar = (a.j.b.a.c.l.w)paramar.ebo().iterator().next();
      if (!a.j.b.a.c.a.g.C(paramar))
      {
        localObject = paramStringBuilder.append(" : ");
        a.f.b.j.p(paramar, "upperBound");
        ((StringBuilder)localObject).append(b(paramar));
      }
    }
    label237:
    while (!paramBoolean)
    {
      if (paramBoolean) {
        paramStringBuilder.append(escape(">"));
      }
      AppMethodBeat.o(121800);
      return;
      bool = false;
      break;
    }
    paramar = paramar.ebo().iterator();
    int i = 1;
    label256:
    if (paramar.hasNext())
    {
      localObject = (a.j.b.a.c.l.w)paramar.next();
      if (a.j.b.a.c.a.g.C((a.j.b.a.c.l.w)localObject)) {
        break label333;
      }
      if (i == 0) {
        break label322;
      }
      paramStringBuilder.append(" : ");
      label297:
      a.f.b.j.p(localObject, "upperBound");
      paramStringBuilder.append(b((a.j.b.a.c.l.w)localObject));
      i = 0;
    }
    label322:
    label333:
    for (;;)
    {
      break label256;
      break;
      paramStringBuilder.append(" & ");
      break label297;
    }
  }
  
  private final void a(au paramau, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    AppMethodBeat.i(121807);
    if (paramBoolean2) {
      paramStringBuilder.append(aza("value-parameter")).append(" ");
    }
    if (this.CtQ.enx()) {
      paramStringBuilder.append("/*").append(paramau.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, (a.j.b.a.c.b.a.a)paramau, null);
    a(paramStringBuilder, paramau.eew(), "crossinline");
    a(paramStringBuilder, paramau.eex(), "noinline");
    a((aw)paramau, paramBoolean1, paramStringBuilder, paramBoolean2);
    if (this.CtQ.enB() != null) {
      if (this.CtQ.enq())
      {
        paramBoolean1 = paramau.eet();
        if (!paramBoolean1) {
          break label219;
        }
      }
    }
    label219:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder(" = ");
        a.f.a.b localb = this.CtQ.enB();
        if (localb == null) {
          a.f.b.j.ebi();
        }
        paramStringBuilder.append((String)localb.S(paramau));
      }
      AppMethodBeat.o(121807);
      return;
      paramBoolean1 = a.j.b.a.c.i.c.a.b(paramau);
      break;
    }
  }
  
  private final void a(aw paramaw, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121808);
    if (!(paramaw instanceof au)) {
      if (!paramaw.eey()) {
        break label49;
      }
    }
    label49:
    for (paramaw = "var";; paramaw = "val")
    {
      paramStringBuilder.append(aza(paramaw)).append(" ");
      AppMethodBeat.o(121808);
      return;
    }
  }
  
  private final void a(aw paramaw, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    AppMethodBeat.i(121809);
    a.j.b.a.c.l.w localw = paramaw.eer();
    a.f.b.j.p(localw, "variable.type");
    if (!(paramaw instanceof au)) {}
    for (Object localObject1 = null;; localObject1 = paramaw)
    {
      localObject1 = (au)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((au)localObject1).eeu();
        if (localObject1 != null) {
          break label198;
        }
      }
      label198:
      for (Object localObject2 = localw;; localObject2 = localObject1)
      {
        if (localObject1 != null) {}
        for (boolean bool = true;; bool = false)
        {
          a(paramStringBuilder, bool, "vararg");
          if ((paramBoolean2) && (!this.CtQ.env())) {
            a(paramaw, paramStringBuilder);
          }
          if (paramBoolean1)
          {
            a((l)paramaw, paramStringBuilder, paramBoolean2);
            paramStringBuilder.append(": ");
          }
          paramStringBuilder.append(b((a.j.b.a.c.l.w)localObject2));
          b(paramaw, paramStringBuilder);
          if ((this.CtQ.enx()) && (localObject1 != null)) {
            paramStringBuilder.append(" /*").append(b(localw)).append("*/");
          }
          AppMethodBeat.o(121809);
          return;
          localObject1 = null;
          break;
        }
      }
    }
  }
  
  private final void a(a.j.b.a.c.b.az paramaz, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121791);
    if (!this.CtQ.enu().contains(h.CtW))
    {
      AppMethodBeat.o(121791);
      return;
    }
    a.j.b.a.c.b.az localaz = paramaz;
    if (((Boolean)this.CtQ.Cuy.a(j.eOJ[12])).booleanValue()) {
      localaz = paramaz.eeF();
    }
    if ((!((Boolean)this.CtQ.Cuz.a(j.eOJ[13])).booleanValue()) && (a.f.b.j.e(localaz, a.j.b.a.c.b.ay.BWV)))
    {
      AppMethodBeat.o(121791);
      return;
    }
    paramStringBuilder.append(aza(localaz.getDisplayName())).append(" ");
    AppMethodBeat.o(121791);
  }
  
  private final void a(a.j.b.a.c.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121793);
    if ((!a.j.b.a.c.i.d.r((l)paramb)) || (paramb.ecC() != a.j.b.a.c.b.w.BWp))
    {
      if ((this.CtQ.enD() == m.Cvj) && (paramb.ecC() == a.j.b.a.c.b.w.BWr) && (t(paramb)))
      {
        AppMethodBeat.o(121793);
        return;
      }
      paramb = paramb.ecC();
      a.f.b.j.p(paramb, "callable.modality");
      a(paramb, paramStringBuilder);
    }
    AppMethodBeat.o(121793);
  }
  
  private final void a(a.j.b.a.c.b.i parami, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121811);
    List localList = parami.ecP();
    a.f.b.j.p(localList, "classifier.declaredTypeParameters");
    Object localObject = parami.ecx();
    a.f.b.j.p(localObject, "classifier.typeConstructor");
    localObject = ((an)localObject).getParameters();
    a.f.b.j.p(localObject, "classifier.typeConstructor.parameters");
    if ((this.CtQ.enx()) && (parami.ecG()) && (((List)localObject).size() > localList.size()))
    {
      paramStringBuilder.append(" /*captured type parameters: ");
      b(paramStringBuilder, ((List)localObject).subList(localList.size(), ((List)localObject).size()));
      paramStringBuilder.append("*/");
    }
    AppMethodBeat.o(121811);
  }
  
  private final void a(l paraml, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(121766);
    paraml = paraml.edF();
    a.f.b.j.p(paraml, "descriptor.name");
    paramStringBuilder.append(b(paraml, paramBoolean));
    AppMethodBeat.o(121766);
  }
  
  private final void a(a.j.b.a.c.b.t paramt, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121798);
    a(paramStringBuilder, paramt.edU(), "suspend");
    AppMethodBeat.o(121798);
  }
  
  private final void a(a.j.b.a.c.b.v paramv, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(121797);
    a(paramStringBuilder, paramv.ecL(), "external");
    if ((this.CtQ.enu().contains(h.Cue)) && (paramv.ecJ()))
    {
      bool1 = true;
      a(paramStringBuilder, bool1, "expect");
      if ((!this.CtQ.enu().contains(h.Cuf)) || (!paramv.ecK())) {
        break label112;
      }
    }
    label112:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(paramStringBuilder, bool1, "actual");
      AppMethodBeat.o(121797);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void a(a.j.b.a.c.b.w paramw, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121792);
    boolean bool = this.CtQ.enu().contains(h.CtX);
    paramw = paramw.name();
    if (paramw == null)
    {
      paramw = new a.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(121792);
      throw paramw;
    }
    paramw = paramw.toLowerCase();
    a.f.b.j.p(paramw, "(this as java.lang.String).toLowerCase()");
    a(paramStringBuilder, bool, paramw);
    AppMethodBeat.o(121792);
  }
  
  private final void a(a.j.b.a.c.f.b paramb, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121812);
    paramStringBuilder.append(aza(paramString));
    paramb = paramb.CqE;
    a.f.b.j.p(paramb, "fqName.toUnsafe()");
    paramb = f(paramb);
    if (((CharSequence)paramb).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ");
        paramStringBuilder.append(paramb);
      }
      AppMethodBeat.o(121812);
      return;
    }
  }
  
  private final void a(StringBuilder paramStringBuilder, a.j.b.a.c.b.a.a parama, a.j.b.a.c.b.a.e parame)
  {
    AppMethodBeat.i(121786);
    if (!this.CtQ.enu().contains(h.CtZ))
    {
      AppMethodBeat.o(121786);
      return;
    }
    Set localSet;
    a.f.a.b localb;
    if ((parama instanceof a.j.b.a.c.l.w))
    {
      localSet = this.CtQ.ens();
      localb = (a.f.a.b)this.CtQ.CuS.a(j.eOJ[32]);
      parama = parama.ecM().iterator();
    }
    for (;;)
    {
      if (!parama.hasNext()) {
        break label227;
      }
      a.j.b.a.c.b.a.c localc = (a.j.b.a.c.b.a.c)parama.next();
      if ((!a.a.j.a((Iterable)localSet, localc.eee())) && ((localb == null) || (((Boolean)localb.S(localc)).booleanValue())))
      {
        paramStringBuilder.append(a(localc, parame));
        if (((Boolean)this.CtQ.CuP.a(j.eOJ[29])).booleanValue())
        {
          a.l.m.j(paramStringBuilder);
          continue;
          localSet = (Set)this.CtQ.CuQ.a(j.eOJ[30]);
          break;
        }
        paramStringBuilder.append(" ");
      }
    }
    label227:
    AppMethodBeat.o(121786);
  }
  
  private final void a(StringBuilder paramStringBuilder, af paramaf)
  {
    AppMethodBeat.i(121780);
    Object localObject = paramaf.BWE;
    if (localObject != null)
    {
      a(paramStringBuilder, (af)localObject);
      paramStringBuilder.append('.');
      localObject = paramaf.BWC.edF();
      a.f.b.j.p(localObject, "possiblyInnerType.classifierDescriptor.name");
      if (paramStringBuilder.append(b((a.j.b.a.c.f.f)localObject, false)) != null) {}
    }
    else
    {
      localObject = paramaf.BWC.ecx();
      a.f.b.j.p(localObject, "possiblyInnerType.classi…escriptor.typeConstructor");
      paramStringBuilder.append(a((an)localObject));
    }
    paramStringBuilder.append(gf(paramaf.BWD));
    AppMethodBeat.o(121780);
  }
  
  private final void a(StringBuilder paramStringBuilder, a.j.b.a.c.l.a parama)
  {
    AppMethodBeat.i(121771);
    if (this.CtQ.enF() == p.Cvw) {
      paramStringBuilder.append("<font color=\"808080\"><i>");
    }
    paramStringBuilder.append(" /* = ");
    c(paramStringBuilder, (a.j.b.a.c.l.w)parama.Chy);
    paramStringBuilder.append(" */");
    if (this.CtQ.enF() == p.Cvw) {
      paramStringBuilder.append("</i></font>");
    }
    AppMethodBeat.o(121771);
  }
  
  private final void a(StringBuilder paramStringBuilder, a.j.b.a.c.l.ad paramad)
  {
    AppMethodBeat.i(121773);
    if ((a.f.b.j.e(paramad, av.CBT)) || (av.ay((a.j.b.a.c.l.w)paramad)))
    {
      paramStringBuilder.append("???");
      AppMethodBeat.o(121773);
      return;
    }
    if (a.j.b.a.c.l.p.ah((a.j.b.a.c.l.w)paramad))
    {
      if (this.CtQ.eny())
      {
        paramad = paramad.enU();
        if (paramad == null)
        {
          paramStringBuilder = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
          AppMethodBeat.o(121773);
          throw paramStringBuilder;
        }
        paramad = ((p.d)paramad).CBk;
        a.f.b.j.p(paramad, "(type.constructor as Uni…).typeParameterDescriptor");
        paramad = paramad.edF().toString();
        a.f.b.j.p(paramad, "(type.constructor as Uni…escriptor.name.toString()");
        paramStringBuilder.append(azb(paramad));
        AppMethodBeat.o(121773);
        return;
      }
      paramStringBuilder.append("???");
      AppMethodBeat.o(121773);
      return;
    }
    if (a.j.b.a.c.l.y.an((a.j.b.a.c.l.w)paramad))
    {
      d(paramStringBuilder, (a.j.b.a.c.l.w)paramad);
      AppMethodBeat.o(121773);
      return;
    }
    if (W((a.j.b.a.c.l.w)paramad))
    {
      e(paramStringBuilder, (a.j.b.a.c.l.w)paramad);
      AppMethodBeat.o(121773);
      return;
    }
    d(paramStringBuilder, (a.j.b.a.c.l.w)paramad);
    AppMethodBeat.o(121773);
  }
  
  private final void a(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw, an paraman)
  {
    AppMethodBeat.i(121778);
    a.f.b.j.q(paramw, "receiver$0");
    a.j.b.a.c.b.h localh = paramw.enU().ecR();
    Object localObject = localh;
    if (!(localh instanceof a.j.b.a.c.b.i)) {
      localObject = null;
    }
    localObject = as.a(paramw, (a.j.b.a.c.b.i)localObject, 0);
    if (localObject == null)
    {
      paramStringBuilder.append(a(paraman));
      paramStringBuilder.append(gf(paramw.enR()));
      AppMethodBeat.o(121778);
      return;
    }
    a(paramStringBuilder, (af)localObject);
    AppMethodBeat.o(121778);
  }
  
  private final void a(StringBuilder paramStringBuilder, List<? extends ap> paramList)
  {
    AppMethodBeat.i(121783);
    a.a.j.a((Iterable)paramList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (a.f.a.b)new e.b(this), 60);
    AppMethodBeat.o(121783);
  }
  
  private final void a(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(121796);
    if (paramBoolean)
    {
      paramStringBuilder.append(aza(paramString));
      paramStringBuilder.append(" ");
    }
    AppMethodBeat.o(121796);
  }
  
  private final void a(Collection<? extends au> paramCollection, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(121806);
    Object localObject = (n)this.CtQ.CuK.a(j.eOJ[24]);
    boolean bool1 = bool2;
    switch (g.CtT[localObject.ordinal()])
    {
    default: 
      paramCollection = new a.m();
      AppMethodBeat.o(121806);
      throw paramCollection;
    case 2: 
      if (!paramBoolean) {
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      int j = paramCollection.size();
      this.CtQ.enE().f(paramStringBuilder);
      paramCollection = ((Iterable)paramCollection).iterator();
      int i = 0;
      while (paramCollection.hasNext())
      {
        localObject = (au)paramCollection.next();
        this.CtQ.enE().a((au)localObject, paramStringBuilder);
        a((au)localObject, bool1, paramStringBuilder, false);
        this.CtQ.enE().a((au)localObject, i, j, paramStringBuilder);
        i += 1;
      }
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.CtQ.enE().g(paramStringBuilder);
    AppMethodBeat.o(121806);
  }
  
  private final void a(List<? extends ar> paramList, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121805);
    if (this.CtQ.enA())
    {
      AppMethodBeat.o(121805);
      return;
    }
    ArrayList localArrayList = new ArrayList(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ar localar = (ar)paramList.next();
      Object localObject1 = localar.ebo();
      a.f.b.j.p(localObject1, "typeParameter.upperBounds");
      localObject1 = ((Iterable)a.a.j.j((Iterable)localObject1)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        localObject2 = (a.j.b.a.c.l.w)localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        a.j.b.a.c.f.f localf = localar.edF();
        a.f.b.j.p(localf, "typeParameter.name");
        localStringBuilder = localStringBuilder.append(b(localf, false)).append(" : ");
        a.f.b.j.p(localObject2, "it");
        localCollection.add(b((a.j.b.a.c.l.w)localObject2));
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramStringBuilder.append(" ").append(aza("where")).append(" ");
      a.a.j.a((Iterable)localArrayList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, null, 124);
    }
    AppMethodBeat.o(121805);
  }
  
  private final void a(List<? extends ar> paramList, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(121801);
    if (this.CtQ.enA())
    {
      AppMethodBeat.o(121801);
      return;
    }
    if (!paramList.isEmpty())
    {
      paramStringBuilder.append(escape("<"));
      b(paramStringBuilder, paramList);
      paramStringBuilder.append(escape(">"));
      if (paramBoolean) {
        paramStringBuilder.append(" ");
      }
    }
    AppMethodBeat.o(121801);
  }
  
  private final String aza(String paramString)
  {
    AppMethodBeat.i(121761);
    p localp = this.CtQ.enF();
    switch (g.bLo[localp.ordinal()])
    {
    default: 
      paramString = new a.m();
      AppMethodBeat.o(121761);
      throw paramString;
    case 1: 
      AppMethodBeat.o(121761);
      return paramString;
    }
    if (this.CtQ.enN())
    {
      AppMethodBeat.o(121761);
      return paramString;
    }
    paramString = "<b>" + paramString + "</b>";
    AppMethodBeat.o(121761);
    return paramString;
  }
  
  private final String azb(String paramString)
  {
    AppMethodBeat.i(121762);
    p localp = this.CtQ.enF();
    switch (g.pRV[localp.ordinal()])
    {
    default: 
      paramString = new a.m();
      AppMethodBeat.o(121762);
      throw paramString;
    case 1: 
      AppMethodBeat.o(121762);
      return paramString;
    }
    paramString = "<font color=red><b>" + paramString + "</b></font>";
    AppMethodBeat.o(121762);
    return paramString;
  }
  
  private String b(a.j.b.a.c.b.h paramh)
  {
    AppMethodBeat.i(121768);
    a.f.b.j.q(paramh, "klass");
    if (a.j.b.a.c.l.p.L((l)paramh))
    {
      paramh = paramh.ecx().toString();
      AppMethodBeat.o(121768);
      return paramh;
    }
    paramh = this.CtQ.ent().a(paramh, (c)this);
    AppMethodBeat.o(121768);
    return paramh;
  }
  
  private final String b(a.j.b.a.c.i.b.f<?> paramf)
  {
    AppMethodBeat.i(121790);
    if ((paramf instanceof a.j.b.a.c.i.b.b))
    {
      paramf = a.a.j.a((Iterable)((a.j.b.a.c.i.b.b)paramf).getValue(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (a.f.a.b)new e.e(this), 24);
      AppMethodBeat.o(121790);
      return paramf;
    }
    if ((paramf instanceof a.j.b.a.c.i.b.a))
    {
      paramf = a.l.m.b(a((a.j.b.a.c.b.a.c)((a.j.b.a.c.i.b.a)paramf).getValue(), null), (CharSequence)"@");
      AppMethodBeat.o(121790);
      return paramf;
    }
    if ((paramf instanceof a.j.b.a.c.i.b.o))
    {
      paramf = b(((a.j.b.a.c.i.b.o)paramf).enW()) + "::class";
      AppMethodBeat.o(121790);
      return paramf;
    }
    paramf = paramf.toString();
    AppMethodBeat.o(121790);
    return paramf;
  }
  
  private final void b(a.j.b.a.c.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121804);
    parama = parama.edp();
    if (parama != null)
    {
      a(paramStringBuilder, (a.j.b.a.c.b.a.a)parama, a.j.b.a.c.b.a.e.BXk);
      a.j.b.a.c.l.w localw = parama.eer();
      a.f.b.j.p(localw, "receiver.type");
      String str = b(localw);
      parama = str;
      if (W(localw))
      {
        parama = str;
        if (!av.aB(localw)) {
          parama = "(" + str + ')';
        }
      }
      paramStringBuilder.append(parama).append(".");
    }
    AppMethodBeat.o(121804);
  }
  
  private final void b(aw paramaw, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121810);
    if (this.CtQ.enz())
    {
      paramaw = paramaw.eez();
      if (paramaw != null)
      {
        paramStringBuilder = paramStringBuilder.append(" = ");
        a.f.b.j.p(paramaw, "constant");
        paramStringBuilder.append(escape(b(paramaw)));
        AppMethodBeat.o(121810);
        return;
      }
    }
    AppMethodBeat.o(121810);
  }
  
  private final void b(a.j.b.a.c.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121794);
    if (!this.CtQ.enu().contains(h.CtY))
    {
      AppMethodBeat.o(121794);
      return;
    }
    if ((t(paramb)) && (this.CtQ.enD() != m.Cvk))
    {
      a(paramStringBuilder, true, "override");
      if (this.CtQ.enx()) {
        paramStringBuilder.append("/*").append(paramb.edw().size()).append("*/ ");
      }
    }
    AppMethodBeat.o(121794);
  }
  
  private final void b(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121770);
    a.j.b.a.c.l.az localaz = paramw.eoL();
    Object localObject = localaz;
    if (!(localaz instanceof a.j.b.a.c.l.a)) {
      localObject = null;
    }
    localObject = (a.j.b.a.c.l.a)localObject;
    if (localObject != null)
    {
      c(paramStringBuilder, (a.j.b.a.c.l.w)((a.j.b.a.c.l.a)localObject).CAO);
      if (this.CtQ.enJ()) {
        a(paramStringBuilder, (a.j.b.a.c.l.a)localObject);
      }
      AppMethodBeat.o(121770);
      return;
    }
    c(paramStringBuilder, paramw);
    AppMethodBeat.o(121770);
  }
  
  private final void b(StringBuilder paramStringBuilder, List<? extends ar> paramList)
  {
    AppMethodBeat.i(121802);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a((ar)paramList.next(), paramStringBuilder, false);
      if (paramList.hasNext()) {
        paramStringBuilder.append(", ");
      }
    }
    AppMethodBeat.o(121802);
  }
  
  private final void c(a.j.b.a.c.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121795);
    if (!this.CtQ.enu().contains(h.Cub))
    {
      AppMethodBeat.o(121795);
      return;
    }
    if ((this.CtQ.enx()) && (paramb.edy() != b.a.BVX))
    {
      paramStringBuilder = paramStringBuilder.append("/*");
      paramb = paramb.edy().name();
      if (paramb == null)
      {
        paramb = new a.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(121795);
        throw paramb;
      }
      paramb = paramb.toLowerCase();
      a.f.b.j.p(paramb, "(this as java.lang.String).toLowerCase()");
      paramStringBuilder.append(paramb).append("*/ ");
    }
    AppMethodBeat.o(121795);
  }
  
  private final void c(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121772);
    if (((paramw instanceof bb)) && (this.CtQ.enq()) && (!((bb)paramw).eoD()))
    {
      paramStringBuilder.append("<Not computed yet>");
      AppMethodBeat.o(121772);
      return;
    }
    paramw = paramw.eoL();
    if ((paramw instanceof a.j.b.a.c.l.q))
    {
      paramStringBuilder.append(((a.j.b.a.c.l.q)paramw).a((c)this, (i)this));
      AppMethodBeat.o(121772);
      return;
    }
    if ((paramw instanceof a.j.b.a.c.l.ad)) {
      a(paramStringBuilder, (a.j.b.a.c.l.ad)paramw);
    }
    AppMethodBeat.o(121772);
  }
  
  private final void d(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121777);
    a(paramStringBuilder, (a.j.b.a.c.b.a.a)paramw, null);
    if (a.j.b.a.c.l.y.an(paramw)) {
      if (((paramw instanceof a.j.b.a.c.l.ay)) && (this.CtQ.enM()))
      {
        paramStringBuilder.append(((a.j.b.a.c.l.ay)paramw).CBW);
        paramStringBuilder.append(gf(paramw.enR()));
      }
    }
    for (;;)
    {
      if (paramw.egH()) {
        paramStringBuilder.append("?");
      }
      if (ag.ap(paramw)) {
        paramStringBuilder.append("!!");
      }
      AppMethodBeat.o(121777);
      return;
      paramStringBuilder.append(paramw.enU().toString());
      break;
      a(this, paramStringBuilder, paramw);
    }
  }
  
  private final void e(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw)
  {
    int k = 1;
    AppMethodBeat.i(121784);
    int m = paramStringBuilder.length();
    enm().a(paramStringBuilder, (a.j.b.a.c.b.a.a)paramw, null);
    int j;
    boolean bool2;
    int i;
    label75:
    label93:
    ap localap;
    if (paramStringBuilder.length() != m)
    {
      j = 1;
      boolean bool1 = a.j.b.a.c.a.f.e(paramw);
      bool2 = paramw.egH();
      localObject = a.j.b.a.c.a.f.h(paramw);
      if ((!bool2) && ((j == 0) || (localObject == null))) {
        break label329;
      }
      i = 1;
      if (i != 0)
      {
        if (!bool1) {
          break label334;
        }
        paramStringBuilder.insert(m, '(');
      }
      a(paramStringBuilder, bool1, "suspend");
      if (localObject != null)
      {
        if (W((a.j.b.a.c.l.w)localObject))
        {
          j = k;
          if (!((a.j.b.a.c.l.w)localObject).egH()) {}
        }
        else
        {
          if (!X((a.j.b.a.c.l.w)localObject)) {
            break label436;
          }
          j = k;
        }
        label140:
        if (j != 0) {
          paramStringBuilder.append("(");
        }
        b(paramStringBuilder, (a.j.b.a.c.l.w)localObject);
        if (j != 0) {
          paramStringBuilder.append(")");
        }
        paramStringBuilder.append(".");
      }
      paramStringBuilder.append("(");
      Iterator localIterator = ((Iterable)a.j.b.a.c.a.f.j(paramw)).iterator();
      j = 0;
      label206:
      if (!localIterator.hasNext()) {
        break label448;
      }
      localap = (ap)localIterator.next();
      if (j > 0) {
        paramStringBuilder.append(", ");
      }
      if (!this.CtQ.enL()) {
        break label442;
      }
      localObject = localap.eer();
      a.f.b.j.p(localObject, "typeProjection.type");
    }
    label436:
    label442:
    for (Object localObject = a.j.b.a.c.a.f.k((a.j.b.a.c.l.w)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        paramStringBuilder.append(b((a.j.b.a.c.f.f)localObject, false));
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(enn().a(localap));
      j += 1;
      break label206;
      j = 0;
      break;
      label329:
      i = 0;
      break label75;
      label334:
      if (j != 0)
      {
        if (a.l.m.at((CharSequence)paramStringBuilder) == ' ') {}
        for (j = 1; (aa.BMh) && (j == 0); j = 0)
        {
          paramStringBuilder = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(121784);
          throw paramStringBuilder;
        }
        if (paramStringBuilder.charAt(a.l.m.ar((CharSequence)paramStringBuilder) - 1) != ')') {
          paramStringBuilder.insert(a.l.m.ar((CharSequence)paramStringBuilder), "()");
        }
      }
      paramStringBuilder.append("(");
      break label93;
      j = 0;
      break label140;
    }
    label448:
    paramStringBuilder.append(") ").append(eno()).append(" ");
    b(paramStringBuilder, a.j.b.a.c.a.f.i(paramw));
    if (i != 0) {
      paramStringBuilder.append(")");
    }
    if (bool2) {
      paramStringBuilder.append("?");
    }
    AppMethodBeat.o(121784);
  }
  
  private final e enm()
  {
    AppMethodBeat.i(121759);
    e locale = (e)this.CtO.getValue();
    AppMethodBeat.o(121759);
    return locale;
  }
  
  private final c enn()
  {
    AppMethodBeat.i(121760);
    c localc = (c)this.CtP.getValue();
    AppMethodBeat.o(121760);
    return localc;
  }
  
  private final String eno()
  {
    AppMethodBeat.i(121764);
    Object localObject = this.CtQ.enF();
    switch (g.pTs[localObject.ordinal()])
    {
    default: 
      localObject = new a.m();
      AppMethodBeat.o(121764);
      throw ((Throwable)localObject);
    case 1: 
      localObject = escape("->");
      AppMethodBeat.o(121764);
      return localObject;
    }
    AppMethodBeat.o(121764);
    return "&rarr;";
  }
  
  private final String escape(String paramString)
  {
    AppMethodBeat.i(121763);
    paramString = this.CtQ.enF().escape(paramString);
    AppMethodBeat.o(121763);
    return paramString;
  }
  
  private String gf(List<? extends ap> paramList)
  {
    AppMethodBeat.i(121776);
    a.f.b.j.q(paramList, "typeArguments");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(121776);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(escape("<"));
    a(localStringBuilder, paramList);
    localStringBuilder.append(escape(">"));
    paramList = localStringBuilder.toString();
    a.f.b.j.p(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(121776);
    return paramList;
  }
  
  private static void h(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121813);
    int i = paramStringBuilder.length();
    if ((i == 0) || (paramStringBuilder.charAt(i - 1) != ' ')) {
      paramStringBuilder.append(' ');
    }
    AppMethodBeat.o(121813);
  }
  
  private static String i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(121814);
    if ((a.l.m.jw(paramString1, paramString2)) && (a.l.m.jw(paramString3, paramString4)))
    {
      int i = paramString2.length();
      if (paramString1 == null)
      {
        paramString1 = new a.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(121814);
        throw paramString1;
      }
      paramString1 = paramString1.substring(i);
      a.f.b.j.p(paramString1, "(this as java.lang.String).substring(startIndex)");
      i = paramString4.length();
      if (paramString3 == null)
      {
        paramString1 = new a.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(121814);
        throw paramString1;
      }
      paramString2 = paramString3.substring(i);
      a.f.b.j.p(paramString2, "(this as java.lang.String).substring(startIndex)");
      paramString3 = paramString5 + paramString1;
      if (a.f.b.j.e(paramString1, paramString2))
      {
        AppMethodBeat.o(121814);
        return paramString3;
      }
      if (ju(paramString1, paramString2))
      {
        paramString1 = paramString3 + "!";
        AppMethodBeat.o(121814);
        return paramString1;
      }
    }
    AppMethodBeat.o(121814);
    return null;
  }
  
  private static boolean ju(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121815);
    if ((a.f.b.j.e(paramString1, a.l.m.h(paramString2, "?", "", false))) || ((a.l.m.jx(paramString2, "?")) && (a.f.b.j.e(paramString1 + '?', paramString2))) || (a.f.b.j.e("(" + paramString1 + ")?", paramString2)))
    {
      AppMethodBeat.o(121815);
      return true;
    }
    AppMethodBeat.o(121815);
    return false;
  }
  
  private final List<String> k(a.j.b.a.c.b.a.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(121789);
    Object localObject3 = paramc.eeG();
    if (((Boolean)this.CtQ.CuO.a(j.eOJ[28])).booleanValue()) {}
    for (Object localObject1 = a.j.b.a.c.i.c.a.l(paramc);; localObject1 = null)
    {
      paramc = (a.j.b.a.c.b.a.c)localObject2;
      if (localObject1 == null) {
        break label234;
      }
      localObject1 = ((a.j.b.a.c.b.e)localObject1).ecD();
      paramc = (a.j.b.a.c.b.a.c)localObject2;
      if (localObject1 == null) {
        break label234;
      }
      localObject1 = ((a.j.b.a.c.b.d)localObject1).edu();
      paramc = (a.j.b.a.c.b.a.c)localObject2;
      if (localObject1 == null) {
        break label234;
      }
      localObject1 = (Iterable)localObject1;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((au)localObject2).eet()) {
          paramc.add(localObject2);
        }
      }
    }
    localObject1 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (au)((Iterator)localObject1).next();
      a.f.b.j.p(localObject2, "it");
      paramc.add(((au)localObject2).edF());
    }
    paramc = (List)paramc;
    label234:
    localObject1 = paramc;
    if (paramc == null) {
      localObject1 = (List)a.a.v.BMx;
    }
    localObject2 = (Iterable)localObject1;
    paramc = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label328:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if (!((Map)localObject3).containsKey((a.j.b.a.c.f.f)localObject4)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label328;
        }
        paramc.add(localObject4);
        break;
      }
    }
    localObject2 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (a.j.b.a.c.f.f)((Iterator)localObject2).next();
      paramc.add(((a.j.b.a.c.f.f)localObject4).name + " = ...");
    }
    localObject2 = (List)paramc;
    paramc = (Iterable)((Map)localObject3).entrySet();
    localObject3 = (Collection)new ArrayList(a.a.j.d(paramc));
    Object localObject4 = paramc.iterator();
    if (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
      paramc = (a.j.b.a.c.f.f)((Map.Entry)localObject5).getKey();
      a.j.b.a.c.i.b.f localf = (a.j.b.a.c.i.b.f)((Map.Entry)localObject5).getValue();
      localObject5 = new StringBuilder().append(paramc.name).append(" = ");
      if (!((List)localObject1).contains(paramc)) {}
      for (paramc = b(localf);; paramc = "...")
      {
        ((Collection)localObject3).add(paramc);
        break;
      }
    }
    paramc = (List)localObject3;
    paramc = (Iterable)a.a.j.b((Collection)localObject2, (Iterable)paramc);
    a.f.b.j.q(paramc, "receiver$0");
    if (((Collection)paramc).size() <= 1)
    {
      paramc = a.a.j.m(paramc);
      AppMethodBeat.o(121789);
      return paramc;
    }
    paramc = ((Collection)paramc).toArray(new Comparable[0]);
    if (paramc == null)
    {
      paramc = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(121789);
      throw paramc;
    }
    if (paramc == null)
    {
      paramc = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(121789);
      throw paramc;
    }
    paramc = (Comparable[])paramc;
    if (paramc == null)
    {
      paramc = new a.v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(121789);
      throw paramc;
    }
    localObject1 = (Object[])paramc;
    a.f.b.j.q(localObject1, "receiver$0");
    if (localObject1.length > 1) {
      Arrays.sort((Object[])localObject1);
    }
    paramc = a.a.e.asList((Object[])paramc);
    AppMethodBeat.o(121789);
    return paramc;
  }
  
  private static boolean t(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(121816);
    if (!paramb.edw().isEmpty())
    {
      AppMethodBeat.o(121816);
      return true;
    }
    AppMethodBeat.o(121816);
    return false;
  }
  
  public final String a(a.j.b.a.c.b.a.c paramc, a.j.b.a.c.b.a.e parame)
  {
    AppMethodBeat.i(121788);
    a.f.b.j.q(paramc, "annotation");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('@');
    if (parame != null) {
      localStringBuilder.append(parame.BXp + ":");
    }
    parame = paramc.eer();
    localStringBuilder.append(b(parame));
    if (i.a.a(this.CtQ))
    {
      paramc = k(paramc);
      if (!i.a.b(this.CtQ)) {
        if (((Collection)paramc).isEmpty()) {
          break label223;
        }
      }
    }
    label223:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a.a.j.a((Iterable)paramc, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 112);
      }
      if ((this.CtQ.enx()) && ((a.j.b.a.c.l.y.an(parame)) || ((parame.enU().ecR() instanceof aa.b)))) {
        localStringBuilder.append(" /* annotation class not found */");
      }
      paramc = localStringBuilder.toString();
      a.f.b.j.p(paramc, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(121788);
      return paramc;
    }
  }
  
  public final String a(ap paramap)
  {
    AppMethodBeat.i(121782);
    a.f.b.j.q(paramap, "typeProjection");
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, a.a.j.listOf(paramap));
    paramap = localStringBuilder.toString();
    a.f.b.j.p(paramap, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(121782);
    return paramap;
  }
  
  public final String a(String paramString1, String paramString2, a.j.b.a.c.a.g paramg)
  {
    AppMethodBeat.i(121775);
    a.f.b.j.q(paramString1, "lowerRendered");
    a.f.b.j.q(paramString2, "upperRendered");
    a.f.b.j.q(paramg, "builtIns");
    if (ju(paramString1, paramString2))
    {
      if (a.l.m.jw(paramString2, "("))
      {
        paramString1 = "(" + paramString1 + ")!";
        AppMethodBeat.o(121775);
        return paramString1;
      }
      paramString1 = paramString1 + "!";
      AppMethodBeat.o(121775);
      return paramString1;
    }
    Object localObject1 = this.CtQ.ent();
    Object localObject2 = ((g.b)paramg.BRR.invoke()).BTy;
    localObject2 = a.j.b.a.c.a.g.a(a.j.b.a.c.f.f.ayT("Collection"), (ab)localObject2);
    a.f.b.j.p(localObject2, "builtIns.collection");
    localObject1 = a.l.m.jz(((b)localObject1).a((a.j.b.a.c.b.h)localObject2, (c)this), "Collection");
    localObject2 = i(paramString1, (String)localObject1 + "Mutable", paramString2, (String)localObject1, (String)localObject1 + '(' + "Mutable" + ')');
    if (localObject2 != null)
    {
      AppMethodBeat.o(121775);
      return localObject2;
    }
    localObject1 = i(paramString1, (String)localObject1 + "MutableMap.MutableEntry", paramString2, (String)localObject1 + "Map.Entry", (String)localObject1 + "(Mutable)Map.(Mutable)Entry");
    if (localObject1 != null)
    {
      AppMethodBeat.o(121775);
      return localObject1;
    }
    localObject1 = this.CtQ.ent();
    paramg = paramg.ayx("Array");
    a.f.b.j.p(paramg, "builtIns.array");
    paramg = a.l.m.jz(((b)localObject1).a((a.j.b.a.c.b.h)paramg, (c)this), "Array");
    paramg = i(paramString1, paramg + escape("Array<"), paramString2, paramg + escape("Array<out "), paramg + escape("Array<(out) "));
    if (paramg != null)
    {
      AppMethodBeat.o(121775);
      return paramg;
    }
    paramString1 = "(" + paramString1 + ".." + paramString2 + ')';
    AppMethodBeat.o(121775);
    return paramString1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(121819);
    a.f.b.j.q(parama, "<set-?>");
    this.CtQ.a(parama);
    AppMethodBeat.o(121819);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(121820);
    a.f.b.j.q(paramb, "<set-?>");
    this.CtQ.a(paramb);
    AppMethodBeat.o(121820);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(121827);
    a.f.b.j.q(paramn, "<set-?>");
    this.CtQ.a(paramn);
    AppMethodBeat.o(121827);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(121831);
    a.f.b.j.q(paramp, "<set-?>");
    this.CtQ.a(paramp);
    AppMethodBeat.o(121831);
  }
  
  public final String b(a.j.b.a.c.f.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(121765);
    a.f.b.j.q(paramf, "name");
    paramf = escape(q.y(paramf));
    if ((this.CtQ.enN()) && (this.CtQ.enF() == p.Cvw) && (paramBoolean))
    {
      paramf = "<b>" + paramf + "</b>";
      AppMethodBeat.o(121765);
      return paramf;
    }
    AppMethodBeat.o(121765);
    return paramf;
  }
  
  public final String b(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121769);
    a.f.b.j.q(paramw, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, (a.j.b.a.c.l.w)((a.f.a.b)this.CtQ.CuE.a(j.eOJ[18])).S(paramw));
    paramw = localStringBuilder.toString();
    a.f.b.j.p(paramw, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(121769);
    return paramw;
  }
  
  public final a enp()
  {
    AppMethodBeat.i(121818);
    a locala = this.CtQ.enp();
    AppMethodBeat.o(121818);
    return locala;
  }
  
  public final boolean enq()
  {
    AppMethodBeat.i(156778);
    boolean bool = this.CtQ.enq();
    AppMethodBeat.o(156778);
    return bool;
  }
  
  public final boolean enr()
  {
    AppMethodBeat.i(121823);
    boolean bool = this.CtQ.enr();
    AppMethodBeat.o(121823);
    return bool;
  }
  
  public final Set<a.j.b.a.c.f.b> ens()
  {
    AppMethodBeat.i(156779);
    Set localSet = this.CtQ.ens();
    AppMethodBeat.o(156779);
    return localSet;
  }
  
  public final String f(a.j.b.a.c.f.c paramc)
  {
    AppMethodBeat.i(121767);
    a.f.b.j.q(paramc, "fqName");
    paramc = paramc.emj();
    a.f.b.j.p(paramc, "fqName.pathSegments()");
    paramc = escape(q.gg(paramc));
    AppMethodBeat.o(121767);
    return paramc;
  }
  
  public final void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(121822);
    this.CtQ.ge(paramBoolean);
    AppMethodBeat.o(121822);
  }
  
  public final String k(l paraml)
  {
    AppMethodBeat.i(121799);
    a.f.b.j.q(paraml, "declarationDescriptor");
    StringBuilder localStringBuilder1 = new StringBuilder();
    paraml.a((a.j.b.a.c.b.n)new e.a(this), localStringBuilder1);
    if ((!((Boolean)this.CtQ.Cun.a(j.eOJ[1])).booleanValue()) || ((paraml instanceof ab)) || ((paraml instanceof a.j.b.a.c.b.ad))) {}
    l locall;
    do
    {
      for (;;)
      {
        paraml = localStringBuilder1.toString();
        a.f.b.j.p(paraml, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121799);
        return paraml;
        if (!(paraml instanceof a.j.b.a.c.b.y)) {
          break;
        }
        localStringBuilder1.append(" is a module");
      }
      locall = paraml.ecv();
    } while ((locall == null) || ((locall instanceof a.j.b.a.c.b.y)));
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ");
    Object localObject = "defined in";
    a.f.b.j.q("defined in", "message");
    p localp = this.CtQ.enF();
    switch (g.CtS[localp.ordinal()])
    {
    default: 
      paraml = new a.m();
      AppMethodBeat.o(121799);
      throw paraml;
    case 2: 
      localObject = "<i>" + "defined in" + "</i>";
    }
    localStringBuilder2.append((String)localObject).append(" ");
    localObject = a.j.b.a.c.i.d.n(locall);
    a.f.b.j.p(localObject, "DescriptorUtils.getFqName(containingDeclaration)");
    if (((a.j.b.a.c.f.c)localObject).CqJ.isEmpty()) {}
    for (localObject = "root package";; localObject = f((a.j.b.a.c.f.c)localObject))
    {
      localStringBuilder1.append((String)localObject);
      if ((!((Boolean)this.CtQ.Cuo.a(j.eOJ[2])).booleanValue()) || (!(locall instanceof ab)) || (!(paraml instanceof a.j.b.a.c.b.o))) {
        break;
      }
      paraml = ((a.j.b.a.c.b.o)paraml).ecN();
      a.f.b.j.p(paraml, "descriptor.source");
      a.f.b.j.p(paraml.ebY(), "descriptor.source.containingFile");
      break;
    }
  }
  
  public final void l(Set<a.j.b.a.c.f.b> paramSet)
  {
    AppMethodBeat.i(121825);
    a.f.b.j.q(paramSet, "<set-?>");
    this.CtQ.l(paramSet);
    AppMethodBeat.o(121825);
  }
  
  public final void m(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(121826);
    a.f.b.j.q(paramSet, "<set-?>");
    this.CtQ.m(paramSet);
    AppMethodBeat.o(121826);
  }
  
  public final void sA(boolean paramBoolean)
  {
    AppMethodBeat.i(121830);
    this.CtQ.sA(paramBoolean);
    AppMethodBeat.o(121830);
  }
  
  public final void sB(boolean paramBoolean)
  {
    AppMethodBeat.i(121832);
    this.CtQ.sB(paramBoolean);
    AppMethodBeat.o(121832);
  }
  
  public final void sC(boolean paramBoolean)
  {
    AppMethodBeat.i(121833);
    this.CtQ.sC(paramBoolean);
    AppMethodBeat.o(121833);
  }
  
  public final void sD(boolean paramBoolean)
  {
    AppMethodBeat.i(121834);
    this.CtQ.sD(paramBoolean);
    AppMethodBeat.o(121834);
  }
  
  public final void sE(boolean paramBoolean)
  {
    AppMethodBeat.i(121835);
    this.CtQ.sE(paramBoolean);
    AppMethodBeat.o(121835);
  }
  
  public final void sy(boolean paramBoolean)
  {
    AppMethodBeat.i(121828);
    this.CtQ.sy(paramBoolean);
    AppMethodBeat.o(121828);
  }
  
  public final void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(121829);
    this.CtQ.sz(paramBoolean);
    AppMethodBeat.o(121829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.h.e
 * JD-Core Version:    0.7.0.1
 */