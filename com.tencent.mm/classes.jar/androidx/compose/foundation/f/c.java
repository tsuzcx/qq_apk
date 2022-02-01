package androidx.compose.foundation.f;

import androidx.compose.foundation.a.d.f;
import androidx.compose.foundation.f.a.k.b;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.g.c.ac;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"EmptyInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "Landroidx/compose/foundation/text/PlaceholderRange;", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/text/InlineContentRange;", "CoreText", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "CoreText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "InlineChildren", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "resolveInlineContent", "updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "placeholders", "updateTextDelegate-x_uQXYA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;ZIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "InlineContentRange", "PlaceholderRange", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final kotlin.r<List<androidx.compose.ui.m.a.a<Object>>, List<androidx.compose.ui.m.a.a<kotlin.g.a.q<String, androidx.compose.runtime.h, Integer, ah>>>> agU;
  
  static
  {
    AppMethodBeat.i(203760);
    agU = new kotlin.r((List)ab.aivy, (List)ab.aivy);
    AppMethodBeat.o(203760);
  }
  
  private static final kotlin.r<List<androidx.compose.ui.m.a.a<Object>>, List<androidx.compose.ui.m.a.a<kotlin.g.a.q<String, androidx.compose.runtime.h, Integer, ah>>>> a(androidx.compose.ui.m.a parama, Map<String, d> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(203753);
    if (paramMap.isEmpty())
    {
      parama = agU;
      AppMethodBeat.o(203753);
      return parama;
    }
    int m = parama.length();
    s.u("androidx.compose.foundation.text.inlineContent", "tag");
    parama = parama.aYF;
    Object localObject1 = new ArrayList(parama.size());
    int n = parama.size() - 1;
    if (n >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      Object localObject2 = parama.get(i);
      androidx.compose.ui.m.a.a locala = (androidx.compose.ui.m.a.a)localObject2;
      if (((locala.aYG instanceof String)) && (s.p("androidx.compose.foundation.text.inlineContent", locala.tag)) && (androidx.compose.ui.m.b.i(0, m, locala.start, locala.end)))
      {
        i = 1;
        if (i != 0) {
          ((Collection)localObject1).add(localObject2);
        }
        if (k <= n) {
          continue;
        }
        parama = (List)localObject1;
        localObject1 = (List)new ArrayList();
        localObject2 = (List)new ArrayList();
        k = parama.size() - 1;
        if (k < 0) {
          break label261;
        }
      }
      for (i = j;; i = j)
      {
        j = i + 1;
        if ((d)paramMap.get(((androidx.compose.ui.m.a.a)parama.get(i)).aYG) != null)
        {
          AppMethodBeat.o(203753);
          throw null;
          i = 0;
          break;
        }
        if (j > k)
        {
          label261:
          parama = new kotlin.r(localObject1, localObject2);
          AppMethodBeat.o(203753);
          return parama;
        }
      }
    }
  }
  
  public static final void a(androidx.compose.ui.m.a parama, androidx.compose.ui.f paramf, final androidx.compose.ui.m.u paramu, final boolean paramBoolean, final int paramInt1, final int paramInt2, final Map<String, d> paramMap, final kotlin.g.a.b<? super androidx.compose.ui.m.q, ah> paramb, final androidx.compose.runtime.h paramh, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(203740);
    s.u(parama, "text");
    s.u(paramu, "style");
    s.u(paramMap, "inlineContent");
    s.u(paramb, "onTextLayout");
    androidx.compose.runtime.h localh = paramh.by(1241032154);
    paramh = paramf;
    if ((paramInt4 & 0x2) != 0) {
      paramh = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
    }
    if (paramInt2 > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      parama = (Throwable)new IllegalArgumentException("maxLines should be greater than 0".toString());
      AppMethodBeat.o(203740);
      throw parama;
    }
    androidx.compose.foundation.f.a.g localg = (androidx.compose.foundation.f.a.g)localh.a((androidx.compose.runtime.p)androidx.compose.foundation.f.a.h.nc());
    Object localObject2 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
    Object localObject4 = (androidx.compose.ui.m.b.c.a)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yV());
    long l1 = ((androidx.compose.foundation.f.a.i)localh.a((androidx.compose.runtime.p)androidx.compose.foundation.f.a.j.nd())).ahT;
    paramf = a(parama, paramMap);
    Object localObject5 = (List)paramf.bsC;
    Object localObject3 = (List)paramf.bsD;
    paramf = (kotlin.g.a.a)new e(localg);
    long l2 = ((Number)androidx.compose.runtime.e.b.a(new Object[] { parama, localg }, null, paramf, localh, 6)).longValue();
    localh.bx(-3687241);
    Object localObject1 = localh.or();
    paramf = androidx.compose.runtime.h.alD;
    paramf = (androidx.compose.ui.f)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramf = new i(new g(parama, paramu, paramInt2, paramBoolean, paramInt1, (androidx.compose.ui.n.d)localObject2, (androidx.compose.ui.m.b.c.a)localObject4, (List)localObject5, (byte)0), l2);
      localh.F(paramf);
    }
    localh.od();
    Object localObject6 = (i)paramf;
    localObject1 = ((i)localObject6).ahu;
    s.u(localObject1, "current");
    s.u(parama, "text");
    s.u(paramu, "style");
    s.u(localObject2, "density");
    s.u(localObject4, "resourceLoader");
    s.u(localObject5, "placeholders");
    if ((s.p(((g)localObject1).ahm, parama)) && (s.p(((g)localObject1).ahn, paramu)) && (((g)localObject1).aho == paramBoolean) && (androidx.compose.ui.m.f.h.C(((g)localObject1).ahp, paramInt1)) && (((g)localObject1).maxLines == paramInt2) && (s.p(((g)localObject1).TD, localObject2)))
    {
      paramf = (androidx.compose.ui.f)localObject1;
      if (s.p(((g)localObject1).ahr, localObject5)) {}
    }
    else
    {
      paramf = new g(parama, paramu, paramInt2, paramBoolean, paramInt1, (androidx.compose.ui.n.d)localObject2, (androidx.compose.ui.m.b.c.a)localObject4, (List)localObject5, (byte)0);
    }
    s.u(paramf, "<set-?>");
    ((i)localObject6).ahu = paramf;
    s.u(paramb, "<set-?>");
    ((i)localObject6).ahw = paramb;
    ((i)localObject6).ahB = l1;
    localh.bx(-3687241);
    localObject1 = localh.or();
    paramf = androidx.compose.runtime.h.alD;
    paramf = (androidx.compose.ui.f)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramf = new f((i)localObject6);
      localh.F(paramf);
    }
    localh.od();
    localObject2 = (f)paramf;
    ((f)localObject2).ahc = localg;
    if (((List)localObject3).isEmpty())
    {
      paramf = b.agR;
      localObject1 = b.mX();
      localObject3 = paramh.a(((f)localObject2).ahd);
      if (localg == null) {
        break label1049;
      }
      if (!j.isInTouchMode()) {
        break label1018;
      }
      paramf = ac.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, ((f)localObject2).ahg, (kotlin.g.a.m)new b((f)localObject2, null));
      label668:
      localObject5 = ((androidx.compose.ui.f)localObject3).a(paramf);
      localObject4 = ((f)localObject2).ahe;
      localh.bx(1376089335);
      localObject3 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
      paramf = (n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
      localObject6 = androidx.compose.ui.i.a.aNC;
      localObject6 = androidx.compose.ui.i.a.a.xb();
      localObject5 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject5);
      if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
        androidx.compose.runtime.g.nW();
      }
      localh.ol();
      if (!localh.nY()) {
        break label1059;
      }
      localh.a((kotlin.g.a.a)localObject6);
    }
    for (;;)
    {
      localh.op();
      s.u(localh, "composer");
      localObject6 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject4, androidx.compose.ui.i.a.a.xe());
      localObject4 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject3, androidx.compose.ui.i.a.a.xd());
      localObject3 = androidx.compose.ui.i.a.aNC;
      br.a(localh, paramf, androidx.compose.ui.i.a.a.xf());
      localh.oq();
      s.u(localh, "composer");
      ((kotlin.g.a.q)localObject5).invoke(bc.p(localh), localh, Integer.valueOf(0));
      localh.bx(2058660585);
      ((kotlin.g.a.m)localObject1).invoke(localh, Integer.valueOf(0));
      localh.od();
      localh.on();
      localh.od();
      aa.a(localg, ((f)localObject2).ahf, localh);
      paramf = localh.oh();
      if (paramf != null) {
        paramf.b((kotlin.g.a.m)new d(parama, paramh, paramu, paramBoolean, paramInt1, paramInt2, paramMap, paramb, paramInt3, paramInt4));
      }
      AppMethodBeat.o(203740);
      return;
      localObject1 = (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819890150, new a(parama, (List)localObject3, paramInt3));
      break;
      label1018:
      paramf = ac.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, ((f)localObject2).ahh, (kotlin.g.a.m)new c((f)localObject2, null));
      break label668;
      label1049:
      paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
      break label668;
      label1059:
      localh.om();
    }
  }
  
  public static final void a(androidx.compose.ui.m.a parama, final List<androidx.compose.ui.m.a.a<kotlin.g.a.q<String, androidx.compose.runtime.h, Integer, ah>>> paramList, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(203747);
    s.u(parama, "text");
    s.u(paramList, "inlineContents");
    paramh = paramh.by(710802501);
    int i = 0;
    int k = paramList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject1 = (androidx.compose.ui.m.a.a)paramList.get(i);
      kotlin.g.a.q localq = (kotlin.g.a.q)((androidx.compose.ui.m.a.a)localObject1).aYG;
      i = ((androidx.compose.ui.m.a.a)localObject1).start;
      int m = ((androidx.compose.ui.m.a.a)localObject1).end;
      Object localObject3 = (androidx.compose.ui.h.p)f.agY;
      paramh.bx(1376089335);
      Object localObject4 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
      Object localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
      localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
      Object localObject5 = androidx.compose.ui.i.a.aNC;
      localObject5 = androidx.compose.ui.i.a.a.xb();
      localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
      if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
        androidx.compose.runtime.g.nW();
      }
      paramh.ol();
      if (paramh.nY()) {
        paramh.a((kotlin.g.a.a)localObject5);
      }
      for (;;)
      {
        paramh.op();
        s.u(paramh, "composer");
        localObject5 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1487993655);
        localq.invoke(parama.ah(i, m).text, paramh, Integer.valueOf(0));
        paramh.od();
        paramh.od();
        paramh.on();
        paramh.od();
        if (j <= k) {
          break;
        }
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new g(parama, paramList, paramInt));
        }
        AppMethodBeat.o(203747);
        return;
        paramh.om();
      }
      i = j;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(androidx.compose.ui.m.a parama, List<androidx.compose.ui.m.a.a<kotlin.g.a.q<String, androidx.compose.runtime.h, Integer, ah>>> paramList, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements kotlin.g.a.m<androidx.compose.ui.g.c.u, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(f paramf, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(203709);
      paramd = new b(this.agW, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(203709);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203704);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203704);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (androidx.compose.ui.g.c.u)this.L$0;
        Object localObject = this.agW.ahg;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        kotlin.g.a.b localb = (kotlin.g.a.b)new e.a((h)localObject);
        kotlin.g.a.a locala1 = (kotlin.g.a.a)new e.b((h)localObject);
        localObject = androidx.compose.foundation.a.j.a(paramObject, (kotlin.g.a.m)new d.f(localb, (kotlin.g.a.a)new e.c((h)localObject), locala1, (kotlin.g.a.m)new e.d((h)localObject), null), locald);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        localObject = paramObject;
        if (paramObject != kotlin.d.a.a.aiwj) {
          localObject = ah.aiuX;
        }
        if (localObject == locala)
        {
          AppMethodBeat.o(203704);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(203704);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements kotlin.g.a.m<androidx.compose.ui.g.c.u, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(f paramf, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(203708);
      paramd = new c(this.agW, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(203708);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203705);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203705);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (androidx.compose.ui.g.c.u)this.L$0;
        Object localObject = this.agW.ahh;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = androidx.compose.foundation.a.j.a(paramObject, (kotlin.g.a.m)new k.b(true, (androidx.compose.foundation.f.a.b)localObject, null), locald);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(203705);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(203705);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(androidx.compose.ui.m.a parama, androidx.compose.ui.f paramf, androidx.compose.ui.m.u paramu, boolean paramBoolean, int paramInt1, int paramInt2, Map<String, d> paramMap, kotlin.g.a.b<? super androidx.compose.ui.m.q, ah> paramb, int paramInt3, int paramInt4)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    e(androidx.compose.foundation.f.a.g paramg)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    implements androidx.compose.ui.h.p
  {
    public static final f agY;
    
    static
    {
      AppMethodBeat.i(203679);
      agY = new f();
      AppMethodBeat.o(203679);
    }
    
    public final androidx.compose.ui.h.q a(androidx.compose.ui.h.r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203694);
      s.u(paramr, "$this$Layout");
      s.u(paramList, "children");
      ArrayList localArrayList = new ArrayList(paramList.size());
      int i = 0;
      int k = paramList.size() - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        Object localObject = paramList.get(i);
        ((Collection)localArrayList).add(((o)localObject).aw(paramLong));
        if (j > k)
        {
          paramList = (List)localArrayList;
          paramr = r.a.a(paramr, androidx.compose.ui.n.b.aU(paramLong), androidx.compose.ui.n.b.aW(paramLong), (kotlin.g.a.b)new c.f.a(paramList));
          AppMethodBeat.o(203694);
          return paramr;
        }
        i = j;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    g(androidx.compose.ui.m.a parama, List<androidx.compose.ui.m.a.a<kotlin.g.a.q<String, androidx.compose.runtime.h, Integer, ah>>> paramList, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.c
 * JD-Core Version:    0.7.0.1
 */