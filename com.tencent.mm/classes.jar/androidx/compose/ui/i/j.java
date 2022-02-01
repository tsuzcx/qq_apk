package androidx.compose.ui.i;

import androidx.compose.ui.d.e;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.e.am;
import androidx.compose.ui.e.av;
import androidx.compose.ui.h.q;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_isAttached", "", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "hasMeasureResult", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isShallowPlacing", "setShallowPlacing", "(Z)V", "isValid", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "value", "measureResult", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "()J", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "", "zIndex", "getZIndex", "()F", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/LayoutNodeWrapper;J)J", "attach", "calculateAlignmentLine", "alignmentLine", "detach", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findParentFocusNode", "findParentFocusNode$ui_release", "findParentKeyInputNode", "findParentKeyInputNode$ui_release", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "fromParentPosition", "fromParentPosition-MK-Hz9U", "(J)J", "fromParentRect", "bounds", "get", "getWrappedByCoordinates", "hitTest", "pointerPosition", "hitPointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-3MmeM6k", "(JLjava/util/List;)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-3MmeM6k", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "onLayerBlockUpdated", "onMeasureResultChanged", "width", "height", "onModifierChanged", "performDraw", "performingMeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "populateFocusOrder", "focusOrder", "Landroidx/compose/ui/focus/FocusOrder;", "propagateFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "rectInParent", "toParentPosition", "toParentPosition-MK-Hz9U", "updateLayerParameters", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class j
  extends androidx.compose.ui.h.x
  implements androidx.compose.ui.h.j, androidx.compose.ui.h.o, z, kotlin.g.a.b<androidx.compose.ui.e.u, kotlin.ah>
{
  public static final j.a aPi = new j.a((byte)0);
  private static final kotlin.g.a.b<j, kotlin.ah> aPv = (kotlin.g.a.b)c.aPz;
  private static final kotlin.g.a.b<j, kotlin.ah> aPw = (kotlin.g.a.b)b.aPy;
  private static final av aPx = new av();
  public final f aOb;
  public j aPj;
  private boolean aPk;
  private androidx.compose.ui.n.d aPl;
  private n aPm;
  private boolean aPn;
  private q aPo;
  private Map<androidx.compose.ui.h.a, Integer> aPp;
  private boolean aPq;
  private androidx.compose.ui.d.d aPr;
  private final kotlin.g.a.a<kotlin.ah> aPs;
  boolean aPt;
  x aPu;
  private kotlin.g.a.b<? super ae, kotlin.ah> awy;
  private long position;
  float zIndex;
  
  public j(f paramf)
  {
    this.aOb = paramf;
    this.aPl = this.aOb.TD;
    this.aPm = this.aOb.agm;
    paramf = androidx.compose.ui.n.j.beN;
    this.position = androidx.compose.ui.n.j.su();
    this.aPs = ((kotlin.g.a.a)new d(this));
  }
  
  private final long a(j paramj, long paramLong)
  {
    if (paramj == this) {
      return paramLong;
    }
    j localj = this.aPj;
    if ((localj == null) || (kotlin.g.b.s.p(paramj, localj))) {
      return aC(paramLong);
    }
    return aC(localj.a(paramj, paramLong));
  }
  
  private j a(j paramj)
  {
    kotlin.g.b.s.u(paramj, "other");
    Object localObject2 = paramj.aOb;
    Object localObject3 = this.aOb;
    Object localObject1 = localObject2;
    if (localObject2 == localObject3)
    {
      localObject2 = this.aOb.aOD.aPZ;
      localObject1 = this;
      while ((localObject1 != localObject2) && (localObject1 != paramj))
      {
        localObject1 = ((j)localObject1).aPj;
        kotlin.g.b.s.checkNotNull(localObject1);
      }
      if (localObject1 != paramj) {}
    }
    Object localObject4;
    do
    {
      return paramj;
      return this;
      for (;;)
      {
        localObject2 = localObject3;
        if (((f)localObject1).aOm <= ((f)localObject3).aOm) {
          break;
        }
        localObject1 = ((f)localObject1).xu();
        kotlin.g.b.s.checkNotNull(localObject1);
      }
      for (;;)
      {
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (((f)localObject2).aOm <= ((f)localObject1).aOm) {
          break;
        }
        localObject2 = ((f)localObject2).xu();
        kotlin.g.b.s.checkNotNull(localObject2);
      }
      while (localObject4 != localObject3)
      {
        localObject4 = ((f)localObject4).xu();
        localObject1 = ((f)localObject3).xu();
        if (localObject4 != null)
        {
          localObject3 = localObject1;
          if (localObject1 != null) {
            break;
          }
        }
        else
        {
          throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
      }
      if (localObject3 == this.aOb) {
        return this;
      }
    } while (localObject4 == paramj.aOb);
    return ((f)localObject4).aOC;
  }
  
  private final void a(androidx.compose.ui.d.d paramd, boolean paramBoolean)
  {
    int i = androidx.compose.ui.n.j.bf(this.position);
    paramd.left -= i;
    paramd.right -= i;
    i = androidx.compose.ui.n.j.bg(this.position);
    paramd.top -= i;
    paramd.bottom -= i;
    x localx = this.aPu;
    if (localx != null)
    {
      localx.b(paramd, true);
      if ((this.aPk) && (paramBoolean))
      {
        paramd.w(l.bi(this.aMV), l.bj(this.aMV));
        if (!paramd.isEmpty()) {}
      }
    }
  }
  
  private final void a(j paramj, androidx.compose.ui.d.d paramd, boolean paramBoolean)
  {
    if (paramj == this) {
      return;
    }
    j localj = this.aPj;
    if (localj != null) {
      localj.a(paramj, paramd, paramBoolean);
    }
    a(paramd, paramBoolean);
  }
  
  private final aa getSnapshotObserver()
  {
    return i.q(this.aOb).getSnapshotObserver();
  }
  
  private void n(kotlin.g.a.b<? super ae, kotlin.ah> paramb)
  {
    int i;
    if ((this.awy != paramb) || (!kotlin.g.b.s.p(this.aPl, this.aOb.TD)) || (this.aPm != this.aOb.agm))
    {
      i = 1;
      this.awy = paramb;
      this.aPl = this.aOb.TD;
      this.aPm = this.aOb.agm;
      if ((!isAttached()) || (paramb == null)) {
        break label173;
      }
      if (this.aPu != null) {
        break label164;
      }
      paramb = i.q(this.aOb).b((kotlin.g.a.b)this, this.aPs);
      paramb.aI(this.aMV);
      paramb.aH(this.position);
      localah = kotlin.ah.aiuX;
      this.aPu = paramb;
      xX();
      this.aOb.aOF = true;
      this.aPs.invoke();
    }
    label164:
    while (i == 0)
    {
      kotlin.ah localah;
      return;
      i = 0;
      break;
    }
    xX();
    return;
    label173:
    paramb = this.aPu;
    if (paramb != null)
    {
      paramb.destroy();
      this.aOb.aOF = true;
      this.aPs.invoke();
      if (isAttached())
      {
        paramb = this.aOb.aOl;
        if (paramb != null) {
          paramb.B(this.aOb);
        }
      }
    }
    this.aPu = null;
    this.aPt = false;
  }
  
  private final void xX()
  {
    Object localObject = this.aPu;
    if (localObject != null)
    {
      kotlin.g.a.b localb = this.awy;
      if (localb == null) {
        throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
      }
      aPx.reset();
      aPx.a(this.aOb.TD);
      getSnapshotObserver().a((z)this, aPv, (kotlin.g.a.a)new f(localb));
      ((x)localObject).a(aPx.scaleX, aPx.scaleY, aPx.alpha, aPx.ayc, aPx.ayd, aPx.aye, aPx.ayf, aPx.ayg, aPx.ayh, aPx.ayi, aPx.ayj, aPx.XK, aPx.SI, this.aOb.agm, this.aOb.TD);
      this.aPk = aPx.SI;
    }
    for (;;)
    {
      localObject = this.aOb.aOl;
      if (localObject != null) {
        ((y)localObject).B(this.aOb);
      }
      return;
      if (this.awy == null) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
    }
  }
  
  public abstract int a(androidx.compose.ui.h.a parama);
  
  public final long a(androidx.compose.ui.h.j paramj, long paramLong)
  {
    kotlin.g.b.s.u(paramj, "sourceCoordinates");
    j localj1 = (j)paramj;
    j localj2 = a((j)paramj);
    paramj = localj1;
    while (paramj != localj2)
    {
      paramLong = paramj.aB(paramLong);
      paramj = paramj.aPj;
      kotlin.g.b.s.checkNotNull(paramj);
    }
    return a(localj2, paramLong);
  }
  
  public final androidx.compose.ui.d.g a(androidx.compose.ui.h.j paramj)
  {
    kotlin.g.b.s.u(paramj, "sourceCoordinates");
    if (!isAttached()) {
      throw ((Throwable)new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString()));
    }
    if (!paramj.isAttached()) {
      throw ((Throwable)new IllegalStateException(("LayoutCoordinates " + paramj + " is not attached!").toString()));
    }
    Object localObject = (j)paramj;
    j localj = a((j)paramj);
    androidx.compose.ui.d.d locald2 = this.aPr;
    androidx.compose.ui.d.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new androidx.compose.ui.d.d();
      this.aPr = locald1;
    }
    locald1.left = 0.0F;
    locald1.top = 0.0F;
    locald1.right = l.bi(paramj.wj());
    locald1.bottom = l.bj(paramj.wj());
    paramj = (androidx.compose.ui.h.j)localObject;
    while (paramj != localj)
    {
      localObject = paramj.aPu;
      if (localObject != null)
      {
        if (paramj.aPk)
        {
          locald1.w(l.bi(paramj.aMV), l.bj(paramj.aMV));
          if (locald1.isEmpty()) {}
        }
        else
        {
          ((x)localObject).b(locald1, false);
        }
      }
      else
      {
        int i = androidx.compose.ui.n.j.bf(paramj.position);
        locald1.left += i;
        float f = locald1.right;
        locald1.right = (i + f);
        i = androidx.compose.ui.n.j.bg(paramj.position);
        locald1.top += i;
        f = locald1.bottom;
        locald1.bottom = (i + f);
      }
      if (locald1.isEmpty())
      {
        paramj = androidx.compose.ui.d.g.avs;
        return androidx.compose.ui.d.g.sy();
      }
      paramj = paramj.aPj;
      kotlin.g.b.s.checkNotNull(paramj);
    }
    a(localj, locald1, true);
    kotlin.g.b.s.u(locald1, "<this>");
    return new androidx.compose.ui.d.g(locald1.left, locald1.top, locald1.right, locald1.bottom);
  }
  
  public void a(long paramLong, float paramFloat, kotlin.g.a.b<? super ae, kotlin.ah> paramb)
  {
    n(paramb);
    if (!androidx.compose.ui.n.j.e(this.position, paramLong))
    {
      this.position = paramLong;
      paramb = this.aPu;
      if (paramb == null) {
        break label105;
      }
      paramb.aH(paramLong);
      paramb = xg();
      if (paramb != null) {
        break label124;
      }
      paramb = null;
      label55:
      if (kotlin.g.b.s.p(paramb, this.aOb)) {
        break label134;
      }
      this.aOb.xF();
    }
    for (;;)
    {
      paramb = this.aOb.aOl;
      if (paramb != null) {
        paramb.B(this.aOb);
      }
      this.zIndex = paramFloat;
      return;
      label105:
      paramb = this.aPj;
      if (paramb == null) {
        break;
      }
      paramb.xY();
      break;
      label124:
      paramb = paramb.aOb;
      break label55;
      label134:
      paramb = this.aOb.xu();
      if (paramb != null) {
        paramb.xF();
      }
    }
  }
  
  public void a(androidx.compose.ui.c.g paramg)
  {
    kotlin.g.b.s.u(paramg, "focusOrder");
    j localj = this.aPj;
    if (localj != null) {
      localj.a(paramg);
    }
  }
  
  public void a(androidx.compose.ui.c.k paramk)
  {
    kotlin.g.b.s.u(paramk, "focusState");
    j localj = this.aPj;
    if (localj != null) {
      localj.a(paramk);
    }
  }
  
  protected final void a(androidx.compose.ui.e.u paramu, am paramam)
  {
    kotlin.g.b.s.u(paramu, "canvas");
    kotlin.g.b.s.u(paramam, "paint");
    paramu.b(new androidx.compose.ui.d.g(0.5F, 0.5F, l.bi(this.aMV) - 0.5F, l.bj(this.aMV) - 0.5F), paramam);
  }
  
  public final void a(q paramq)
  {
    int j = 0;
    kotlin.g.b.s.u(paramq, "value");
    Object localObject = this.aPo;
    int i;
    if (paramq != localObject)
    {
      this.aPo = paramq;
      if ((localObject == null) || (paramq.getWidth() != ((q)localObject).getWidth()) || (paramq.getHeight() != ((q)localObject).getHeight())) {
        ae(paramq.getWidth(), paramq.getHeight());
      }
      localObject = this.aPp;
      if ((localObject != null) && (!((Map)localObject).isEmpty())) {
        break label286;
      }
      i = 1;
      if (i != 0)
      {
        i = j;
        if (!paramq.wL().isEmpty()) {
          i = 1;
        }
        if (i == 0) {}
      }
      else if (!kotlin.g.b.s.p(paramq.wL(), this.aPp))
      {
        localObject = xg();
        if (localObject != null) {
          break label291;
        }
        localObject = null;
        label158:
        if (!kotlin.g.b.s.p(localObject, this.aOb)) {
          break label336;
        }
        localObject = this.aOb.xu();
        if (localObject != null) {
          ((f)localObject).xF();
        }
        if (!this.aOb.aOu.aPb) {
          break label301;
        }
        localObject = this.aOb.xu();
        if (localObject != null) {
          ((f)localObject).xG();
        }
      }
    }
    for (;;)
    {
      this.aOb.aOu.dirty = true;
      Map localMap = this.aPp;
      localObject = localMap;
      if (localMap == null)
      {
        localObject = (Map)new LinkedHashMap();
        this.aPp = ((Map)localObject);
      }
      ((Map)localObject).clear();
      ((Map)localObject).putAll(paramq.wL());
      return;
      label286:
      i = 0;
      break;
      label291:
      localObject = ((j)localObject).aOb;
      break label158;
      label301:
      if (this.aOb.aOu.aPc)
      {
        localObject = this.aOb.xu();
        if (localObject != null)
        {
          ((f)localObject).xH();
          continue;
          label336:
          this.aOb.xF();
        }
      }
    }
  }
  
  public final long aB(long paramLong)
  {
    x localx = this.aPu;
    if (localx == null) {}
    for (;;)
    {
      return androidx.compose.ui.n.k.r(paramLong, this.position);
      paramLong = localx.e(paramLong, false);
    }
  }
  
  public final long aC(long paramLong)
  {
    paramLong = androidx.compose.ui.n.k.s(paramLong, this.position);
    x localx = this.aPu;
    if (localx == null) {
      return paramLong;
    }
    return localx.e(paramLong, true);
  }
  
  protected final boolean aD(long paramLong)
  {
    x localx = this.aPu;
    if ((localx != null) && (this.aPk)) {
      return localx.aG(paramLong);
    }
    return true;
  }
  
  protected final boolean aE(long paramLong)
  {
    float f1 = e.F(paramLong);
    float f2 = e.G(paramLong);
    return (f1 >= 0.0F) && (f2 >= 0.0F) && (f1 < wN()) && (f2 < getMeasuredHeight());
  }
  
  protected void ae(int paramInt1, int paramInt2)
  {
    Object localObject = this.aPu;
    if (localObject != null) {
      ((x)localObject).aI(m.an(paramInt1, paramInt2));
    }
    for (;;)
    {
      localObject = this.aOb.aOl;
      if (localObject != null) {
        ((y)localObject).B(this.aOb);
      }
      ax(m.an(paramInt1, paramInt2));
      return;
      localObject = this.aPj;
      if (localObject != null) {
        ((j)localObject).xY();
      }
    }
  }
  
  public final long au(long paramLong)
  {
    paramLong = av(paramLong);
    return i.q(this.aOb).aJ(paramLong);
  }
  
  public final long av(long paramLong)
  {
    j localj = this;
    if (!isAttached()) {
      throw ((Throwable)new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString()));
    }
    while (localj != null)
    {
      paramLong = localj.aB(paramLong);
      localj = localj.aPj;
    }
    return paramLong;
  }
  
  public final void av(boolean paramBoolean)
  {
    this.aPq = paramBoolean;
  }
  
  public final int b(androidx.compose.ui.h.a parama)
  {
    kotlin.g.b.s.u(parama, "alignmentLine");
    if (this.aPo != null)
    {
      i = 1;
      if (i != 0) {
        break label29;
      }
    }
    label29:
    int j;
    do
    {
      return -2147483648;
      i = 0;
      break;
      j = a(parama);
    } while (j == -2147483648);
    if ((parama instanceof androidx.compose.ui.h.ah)) {}
    for (int i = androidx.compose.ui.n.j.bf(wQ());; i = androidx.compose.ui.n.j.bg(wQ())) {
      return i + j;
    }
  }
  
  public abstract void b(long paramLong, List<androidx.compose.ui.g.c.s> paramList);
  
  public abstract void c(long paramLong, List<androidx.compose.ui.k.w> paramList);
  
  protected abstract void c(androidx.compose.ui.e.u paramu);
  
  public void detach()
  {
    this.aPn = false;
    n(this.awy);
    f localf = this.aOb.xu();
    if (localf != null) {
      localf.xA();
    }
  }
  
  public final void e(androidx.compose.ui.e.u paramu)
  {
    kotlin.g.b.s.u(paramu, "canvas");
    x localx = this.aPu;
    if (localx != null)
    {
      localx.f(paramu);
      return;
    }
    float f1 = androidx.compose.ui.n.j.bf(this.position);
    float f2 = androidx.compose.ui.n.j.bg(this.position);
    paramu.A(f1, f2);
    c(paramu);
    paramu.A(-f1, -f2);
  }
  
  public final boolean isAttached()
  {
    if ((this.aPn) && (!this.aOb.isAttached())) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    return this.aPn;
  }
  
  public boolean isValid()
  {
    return this.aPu != null;
  }
  
  public void vV()
  {
    x localx = this.aPu;
    if (localx != null) {
      localx.invalidate();
    }
  }
  
  public void vX()
  {
    this.aPn = true;
    n(this.awy);
  }
  
  public abstract androidx.compose.ui.g.b.b vY();
  
  public abstract androidx.compose.ui.g.b.b vZ();
  
  public final androidx.compose.ui.h.j wJ()
  {
    if (!isAttached()) {
      throw ((Throwable)new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString()));
    }
    return (androidx.compose.ui.h.j)this.aOb.aOD.aPZ.aPj;
  }
  
  public final long wj()
  {
    return this.aMV;
  }
  
  protected final kotlin.g.a.b<ae, kotlin.ah> xS()
  {
    return this.awy;
  }
  
  public final q xT()
  {
    q localq = this.aPo;
    if (localq == null) {
      throw ((Throwable)new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString()));
    }
    return localq;
  }
  
  public Set<androidx.compose.ui.h.a> xU()
  {
    Set localSet = null;
    Object localObject = this.aPo;
    if (localObject == null) {}
    for (;;)
    {
      localObject = localSet;
      if (localSet == null) {
        localObject = (Set)ad.aivA;
      }
      return localObject;
      localObject = ((q)localObject).wL();
      if (localObject != null) {
        localSet = ((Map)localObject).keySet();
      }
    }
  }
  
  public final long xV()
  {
    return this.position;
  }
  
  public final boolean xW()
  {
    return this.aPq;
  }
  
  public final void xY()
  {
    j localj = this;
    for (;;)
    {
      x localx = localj.aPu;
      if (localx != null) {
        localx.invalidate();
      }
      do
      {
        return;
        localj = localj.aPj;
      } while (localj == null);
    }
  }
  
  public final o xZ()
  {
    Object localObject = this.aPj;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((j)localObject).xj()) {
      return localObject;
    }
    for (f localf = this.aOb.xu();; localf = localf.xu())
    {
      if (localf == null) {
        break label62;
      }
      o localo = localf.aOD.aPZ.xl();
      localObject = localo;
      if (localo != null) {
        break;
      }
    }
    label62:
    return null;
  }
  
  public j xg()
  {
    return null;
  }
  
  public abstract androidx.compose.ui.h.r xh();
  
  public abstract o xj();
  
  public abstract o xk();
  
  public abstract o xl();
  
  public abstract r xm();
  
  public abstract r xn();
  
  public final r ya()
  {
    Object localObject = this.aPj;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((j)localObject).xm()) {
      return localObject;
    }
    for (f localf = this.aOb.xu();; localf = localf.xu())
    {
      if (localf == null) {
        break label62;
      }
      r localr = localf.aOD.aPZ.xn();
      localObject = localr;
      if (localr != null) {
        break;
      }
    }
    label62:
    return null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<j, kotlin.ah>
  {
    public static final b aPy;
    
    static
    {
      AppMethodBeat.i(204631);
      aPy = new b();
      AppMethodBeat.o(204631);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<j, kotlin.ah>
  {
    public static final c aPz;
    
    static
    {
      AppMethodBeat.i(204627);
      aPz = new c();
      AppMethodBeat.o(204627);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(j paramj, androidx.compose.ui.e.u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(kotlin.g.a.b<? super ae, kotlin.ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.j
 * JD-Core Version:    0.7.0.1
 */