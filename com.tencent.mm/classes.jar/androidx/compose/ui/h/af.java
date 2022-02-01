package androidx.compose.ui.h;

import androidx.compose.runtime.a.e;
import androidx.compose.runtime.h;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.ui.i.f;
import androidx.compose.ui.i.f.d;
import androidx.compose.ui.i.f.e;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "()V", "maxSlotsToRetainForReuse", "", "(I)V", "NoIntrinsicsMessage", "", "_root", "Landroidx/compose/ui/node/LayoutNode;", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext$ui_release", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext$ui_release", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "nodeToNodeState", "", "Landroidx/compose/ui/layout/SubcomposeLayoutState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "root", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "scope", "Landroidx/compose/ui/layout/SubcomposeLayoutState$Scope;", "setMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "", "getSetMeasurePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "setRoot", "Lkotlin/Function1;", "getSetRoot$ui_release", "()Lkotlin/jvm/functions/Function1;", "slotIdToNode", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "createNodeAt", "index", "disposeAfterIndex", "disposeCurrentNodes", "disposeCurrentNodes$ui_release", "disposeNode", "node", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose$ui_release", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "NodeState", "PrecomposedSlotHandle", "Scope", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final int Ue = 8;
  private final int aNj;
  l aNk;
  final kotlin.g.a.b<f, ah> aNl;
  final m<f, m<? super ag, ? super androidx.compose.ui.n.b, ? extends q>, ah> aNm;
  private f aNn;
  final Map<f, a> aNo;
  public final Map<Object, f> aNp;
  private final c aNq;
  public final Map<Object, f> aNr;
  public int aNs;
  public int aNt;
  private final String aNu;
  int currentIndex;
  
  public af()
  {
    this(0);
  }
  
  public af(int paramInt)
  {
    AppMethodBeat.i(205608);
    this.aNj = paramInt;
    this.aNl = ((kotlin.g.a.b)new g(this));
    this.aNm = ((m)new f(this));
    this.aNo = ((Map)new LinkedHashMap());
    this.aNp = ((Map)new LinkedHashMap());
    this.aNq = new c();
    this.aNr = ((Map)new LinkedHashMap());
    this.aNu = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    AppMethodBeat.o(205608);
  }
  
  private final void a(final f paramf, final a parama)
  {
    AppMethodBeat.i(205618);
    paramf.k((kotlin.g.a.a)new h(this, parama, paramf));
    AppMethodBeat.o(205618);
  }
  
  private final void b(f paramf)
  {
    AppMethodBeat.i(205624);
    paramf = this.aNo.remove(paramf);
    s.checkNotNull(paramf);
    paramf = (a)paramf;
    k localk = paramf.aDs;
    s.checkNotNull(localk);
    localk.dispose();
    this.aNp.remove(paramf.aNv);
    AppMethodBeat.o(205624);
  }
  
  public final void a(f paramf, Object paramObject, m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(205703);
    Map localMap = this.aNo;
    Object localObject2 = localMap.get(paramf);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = c.aMD;
      localObject1 = new a(paramObject, c.wE(), (byte)0);
      localMap.put(paramf, localObject1);
    }
    paramObject = (a)localObject1;
    localObject1 = paramObject.aDs;
    if (localObject1 == null) {}
    for (boolean bool = true;; bool = ((k)localObject1).pa())
    {
      if ((paramObject.SP != paramm) || (bool))
      {
        paramObject.setContent(paramm);
        a(paramf, paramObject);
      }
      AppMethodBeat.o(205703);
      return;
    }
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205721);
    f localf = getRoot();
    f.a(localf, true);
    getRoot().n(paramInt1, paramInt2, 1);
    f.a(localf, false);
    AppMethodBeat.o(205721);
  }
  
  public final f aj(Object paramObject)
  {
    AppMethodBeat.i(205712);
    if (this.aNs > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(205712);
      throw paramObject;
    }
    int k = getRoot().aOh.qp().size() - this.aNt;
    int j = k - this.aNs;
    i = j;
    for (;;)
    {
      Object localObject = (f)getRoot().aOh.qp().get(i);
      localObject = (a)ak.e(this.aNo, localObject);
      if (!s.p(((a)localObject).aNv, paramObject))
      {
        if (i == k - 1) {
          ((a)localObject).aNv = paramObject;
        }
      }
      else
      {
        if (i != j) {
          ac(i, j);
        }
        this.aNs -= 1;
        paramObject = (f)getRoot().aOh.qp().get(j);
        AppMethodBeat.o(205712);
        return paramObject;
      }
      i += 1;
    }
  }
  
  public final f cQ(int paramInt)
  {
    AppMethodBeat.i(205718);
    f localf1 = new f(true);
    f localf2 = getRoot();
    f.a(localf2, true);
    getRoot().a(paramInt, localf1);
    f.a(localf2, false);
    AppMethodBeat.o(205718);
    return localf1;
  }
  
  public final f getRoot()
  {
    AppMethodBeat.i(205697);
    Object localObject = this.aNn;
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalArgumentException("Required value was null.".toString());
      AppMethodBeat.o(205697);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(205697);
    return localObject;
  }
  
  public final void xa()
  {
    AppMethodBeat.i(205706);
    if (this.aNo.size() == getRoot().aOh.qp().size()) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.aNo.size() + ") and the children count on the SubcomposeLayout (" + getRoot().aOh.qp().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
      AppMethodBeat.o(205706);
      throw localThrowable;
    }
    AppMethodBeat.o(205706);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    m<? super h, ? super Integer, ah> SP;
    k aDs;
    Object aNv;
    
    private a(Object paramObject, m<? super h, ? super Integer, ah> paramm)
    {
      AppMethodBeat.i(205613);
      this.aNv = paramObject;
      this.SP = paramm;
      this.aDs = null;
      AppMethodBeat.o(205613);
    }
    
    public final void setContent(m<? super h, ? super Integer, ah> paramm)
    {
      AppMethodBeat.i(205631);
      s.u(paramm, "<set-?>");
      this.SP = paramm;
      AppMethodBeat.o(205631);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "dispose", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void dispose();
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
    implements ag
  {
    n agm;
    float density;
    float fontScale;
    
    public c()
    {
      AppMethodBeat.i(205597);
      this.agm = n.beQ;
      AppMethodBeat.o(205597);
    }
    
    public final q a(int paramInt1, int paramInt2, Map<a, Integer> paramMap, kotlin.g.a.b<? super x.a, ah> paramb)
    {
      AppMethodBeat.i(205652);
      ag localag = (ag)this;
      s.u(localag, "this");
      s.u(paramMap, "alignmentLines");
      s.u(paramb, "placementBlock");
      paramMap = r.a.a((r)localag, paramInt1, paramInt2, paramMap, paramb);
      AppMethodBeat.o(205652);
      return paramMap;
    }
    
    public final float bs(int paramInt)
    {
      AppMethodBeat.i(205646);
      ag localag = (ag)this;
      s.u(localag, "this");
      float f = r.a.a((r)localag, paramInt);
      AppMethodBeat.o(205646);
      return f;
    }
    
    public final List<o> d(Object paramObject, m<? super h, ? super Integer, ah> paramm)
    {
      int j = 1;
      AppMethodBeat.i(205621);
      s.u(paramm, "content");
      af localaf = this.aNw;
      s.u(paramm, "content");
      localaf.xa();
      Object localObject1 = localaf.getRoot().aOn;
      if ((localObject1 == f.d.aOP) || (localObject1 == f.d.aOR)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
        AppMethodBeat.o(205621);
        throw paramObject;
      }
      Map localMap = localaf.aNp;
      Object localObject2 = localMap.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (f)localaf.aNr.remove(paramObject);
        if (localObject1 == null) {
          break label275;
        }
        if (localaf.aNt > 0) {}
        for (i = j; i == 0; i = 0)
        {
          paramObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(205621);
          throw paramObject;
        }
        localaf.aNt -= 1;
      }
      for (;;)
      {
        localMap.put(paramObject, localObject1);
        localObject1 = (f)localObject1;
        i = localaf.getRoot().aOh.qp().indexOf(localObject1);
        if (i >= localaf.currentIndex) {
          break;
        }
        paramObject = new IllegalArgumentException("Key " + paramObject + " was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
        AppMethodBeat.o(205621);
        throw paramObject;
        label275:
        if (localaf.aNs > 0) {
          localObject1 = localaf.aj(paramObject);
        } else {
          localObject1 = localaf.cQ(localaf.currentIndex);
        }
      }
      if (localaf.currentIndex != i) {
        localaf.ac(i, localaf.currentIndex);
      }
      localaf.currentIndex += 1;
      localaf.a((f)localObject1, paramObject, paramm);
      paramObject = ((f)localObject1).xt();
      AppMethodBeat.o(205621);
      return paramObject;
    }
    
    public final n getLayoutDirection()
    {
      return this.agm;
    }
    
    public final float mn()
    {
      return this.density;
    }
    
    public final float mo()
    {
      return this.fontScale;
    }
    
    public final float t(long paramLong)
    {
      AppMethodBeat.i(205641);
      ag localag = (ag)this;
      s.u(localag, "this");
      float f = r.a.a((r)localag, paramLong);
      AppMethodBeat.o(205641);
      return f;
    }
    
    public final int v(float paramFloat)
    {
      AppMethodBeat.i(205626);
      ag localag = (ag)this;
      s.u(localag, "this");
      int i = r.a.a((r)localag, paramFloat);
      AppMethodBeat.o(205626);
      return i;
    }
    
    public final float w(float paramFloat)
    {
      AppMethodBeat.i(205632);
      ag localag = (ag)this;
      s.u(localag, "this");
      paramFloat = r.a.b((r)localag, paramFloat);
      AppMethodBeat.o(205632);
      return paramFloat;
    }
    
    public final long x(float paramFloat)
    {
      AppMethodBeat.i(205636);
      ag localag = (ag)this;
      s.u(localag, "this");
      long l = r.a.c((r)localag, paramFloat);
      AppMethodBeat.o(205636);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/layout/SubcomposeLayoutState$createMeasurePolicy$1", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends f.e
  {
    d(af paramaf, m<? super ag, ? super androidx.compose.ui.n.b, ? extends q> paramm, String paramString)
    {
      super();
    }
    
    public final q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(205602);
      s.u(paramr, "$receiver");
      s.u(paramList, "measurables");
      paramList = af.a(this.aNw);
      n localn = paramr.getLayoutDirection();
      s.u(localn, "<set-?>");
      paramList.agm = localn;
      af.a(this.aNw).density = paramr.mn();
      af.a(this.aNw).fontScale = paramr.mo();
      af.a(this.aNw, 0);
      paramr = (q)this.VV.invoke(af.a(this.aNw), androidx.compose.ui.n.b.bb(paramLong));
      final int i = af.b(this.aNw);
      paramr = (q)new a(paramr, this.aNw, i);
      AppMethodBeat.o(205602);
      return paramr;
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/SubcomposeLayoutState$createMeasurePolicy$1$measure$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements q
    {
      a(q paramq, af paramaf, int paramInt) {}
      
      public final int getHeight()
      {
        AppMethodBeat.i(205627);
        int i = this.aNx.getHeight();
        AppMethodBeat.o(205627);
        return i;
      }
      
      public final int getWidth()
      {
        AppMethodBeat.i(205623);
        int i = this.aNx.getWidth();
        AppMethodBeat.o(205623);
        return i;
      }
      
      public final Map<a, Integer> wL()
      {
        AppMethodBeat.i(205633);
        Map localMap = this.aNx.wL();
        AppMethodBeat.o(205633);
        return localMap;
      }
      
      public final void wM()
      {
        AppMethodBeat.i(205638);
        af.a(this.aNw, i);
        this.aNx.wM();
        af.b(this.aNw, af.b(this.aNw));
        AppMethodBeat.o(205638);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/layout/SubcomposeLayoutState$precompose$1", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "dispose", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements af.b
  {
    public e(af paramaf, Object paramObject) {}
    
    public final void dispose()
    {
      AppMethodBeat.i(205622);
      Object localObject1 = (f)af.c(this.aNw).remove(this.aNz);
      if (localObject1 != null)
      {
        int j = af.d(this.aNw).aOh.qp().indexOf(localObject1);
        if (j != -1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(205622);
          throw ((Throwable)localObject1);
        }
        if (af.e(this.aNw) < af.f(this.aNw))
        {
          i = af.d(this.aNw).aOh.qp().size();
          int k = af.g(this.aNw);
          int m = af.e(this.aNw);
          af.a(this.aNw, j, i - k - m);
          localObject1 = this.aNw;
          af.c((af)localObject1, af.e((af)localObject1) + 1);
          if (af.g(this.aNw) <= 0) {
            break label270;
          }
        }
        label270:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label275;
          }
          localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(205622);
          throw ((Throwable)localObject1);
          Object localObject2 = this.aNw;
          af localaf = this.aNw;
          localObject2 = af.d((af)localObject2);
          f.a((f)localObject2, true);
          af.a(localaf, (f)localObject1);
          af.d(localaf).ad(j, 1);
          f.a((f)localObject2, false);
          break;
        }
        label275:
        localObject1 = this.aNw;
        af.d((af)localObject1, af.g((af)localObject1) - 1);
      }
      AppMethodBeat.o(205622);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<f, m<? super ag, ? super androidx.compose.ui.n.b, ? extends q>, ah>
  {
    f(af paramaf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<f, ah>
  {
    g(af paramaf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(af paramaf, af.a parama, f paramf)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<h, Integer, ah>
    {
      a(m<? super h, ? super Integer, ah> paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.af
 * JD-Core Version:    0.7.0.1
 */