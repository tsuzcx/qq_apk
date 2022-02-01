package androidx.compose.ui.i;

import androidx.compose.ui.h.l;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "()V", "isVirtual", "", "(Z)V", "ZComparator", "Ljava/util/Comparator;", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "_foldedParent", "_innerLayerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "_unfoldedChildren", "_zSortedChildren", "alignmentLines", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "getAlignmentLines$ui_release", "()Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "getCanMultiMeasure$ui_release", "()Z", "setCanMultiMeasure$ui_release", "children", "", "getChildren$ui_release", "()Ljava/util/List;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerLayerWrapper", "getInnerLayerWrapper$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "innerLayerWrapperIsDirty", "getInnerLayerWrapperIsDirty$ui_release", "setInnerLayerWrapperIsDirty$ui_release", "innerLayoutNodeWrapper", "getInnerLayoutNodeWrapper$ui_release", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "isAttached", "<set-?>", "isPlaced", "isValid", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState$ui_release", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope$ui_release", "()Landroidx/compose/ui/layout/MeasureScope;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "onPositionedCallbacks", "Landroidx/compose/ui/node/OnGloballyPositionedModifierWrapper;", "outerLayoutNodeWrapper", "getOuterLayoutNodeWrapper$ui_release", "outerMeasurablePlaceable", "Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousPlaceOrder", "unfoldedVirtualChildrenListDirty", "virtualChildrenCount", "wasMeasuredDuringThisIteration", "getWasMeasuredDuringThisIteration$ui_release", "width", "getWidth", "wrapperCache", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "alignmentLinesQueriedByModifier", "attach", "attach$ui_release", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLines$ui_release", "copyWrappersToCache", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachDelegate", "block", "forEachDelegateIncludingInner", "forceRemeasure", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "getOrCreateOnPositionedCallbacks", "handleMeasureResult", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "handleMeasureResult$ui_release", "hasNewPositioningCallback", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitPointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-3MmeM6k$ui_release", "(JLjava/util/List;)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-3MmeM6k$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateUnfoldedVirtualChildren", "layoutChildren", "layoutChildren$ui_release", "markNodeAndSubtreeAsPlaced", "markReusedModifiers", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "move", "from", "to", "count", "move$ui_release", "onAlignmentsChanged", "onAlignmentsChanged$ui_release", "onBeforeLayoutChildren", "onDensityOrLayoutDirectionChanged", "onNodePlaced", "onNodePlaced$ui_release", "onZSortedChildrenInvalidated", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "reuseLayoutNodeWrapper", "Landroidx/compose/ui/Modifier$Element;", "wrapper", "shouldInvalidateParentLayer", "toString", "withNoSnapshotReadObservation", "withNoSnapshotReadObservation$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements l, o, androidx.compose.ui.h.z, a, z
{
  private static final kotlin.g.a.a<f> aNE;
  private static final e aOM;
  public static final f.a aOe;
  androidx.compose.ui.n.d TD;
  public f aOA;
  boolean aOB;
  public final j aOC;
  public final w aOD;
  private j aOE;
  boolean aOF;
  private androidx.compose.ui.f aOG;
  public kotlin.g.a.b<? super y, ah> aOH;
  public kotlin.g.a.b<? super y, ah> aOI;
  private androidx.compose.runtime.a.e<u> aOJ;
  boolean aOK;
  private final Comparator<f> aOL;
  private final boolean aOf;
  int aOg;
  public final androidx.compose.runtime.a.e<f> aOh;
  private androidx.compose.runtime.a.e<f> aOi;
  private boolean aOj;
  f aOk;
  public y aOl;
  int aOm;
  public d aOn;
  private androidx.compose.runtime.a.e<b<?>> aOo;
  private boolean aOp;
  private final androidx.compose.runtime.a.e<f> aOq;
  private boolean aOr;
  private final e aOs;
  final r aOt;
  final g aOu;
  final h aOv;
  public boolean aOw;
  int aOx;
  private int aOy;
  int aOz;
  public n agm;
  androidx.compose.ui.h.p ahe;
  float zIndex;
  
  static
  {
    AppMethodBeat.i(204854);
    aOe = new f.a((byte)0);
    aOM = (e)new c();
    aNE = (kotlin.g.a.a)b.aON;
    AppMethodBeat.o(204854);
  }
  
  public f()
  {
    this(false);
  }
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(204661);
    this.aOh = new androidx.compose.runtime.a.e(new f[16]);
    this.aOn = d.aOS;
    this.aOo = new androidx.compose.runtime.a.e(new b[16]);
    this.aOq = new androidx.compose.runtime.a.e(new f[16]);
    this.aOr = true;
    this.ahe = ((androidx.compose.ui.h.p)aOM);
    this.aOs = new e(this);
    this.TD = androidx.compose.ui.n.f.H(1.0F, 1.0F);
    this.aOt = ((r)new l(this));
    this.agm = n.beP;
    this.aOu = new g(this);
    this.aOv = i.xR();
    this.aOx = 2147483647;
    this.aOy = 2147483647;
    this.aOA = f.aOW;
    this.aOC = ((j)new d(this));
    this.aOD = new w(this, this.aOC);
    this.aOF = true;
    this.aOG = ((androidx.compose.ui.f)androidx.compose.ui.f.aud);
    this.aOL = ((Comparator)h.aOY);
    this.aOf = paramBoolean;
    AppMethodBeat.o(204661);
  }
  
  private final String cR(int paramInt)
  {
    AppMethodBeat.i(204680);
    Object localObject1 = new StringBuilder();
    int i;
    if (paramInt > 0)
    {
      i = 0;
      do
      {
        j = i + 1;
        ((StringBuilder)localObject1).append("  ");
        i = j;
      } while (j < paramInt);
    }
    ((StringBuilder)localObject1).append("|-");
    ((StringBuilder)localObject1).append(toString());
    ((StringBuilder)localObject1).append('\n');
    Object localObject2 = xr();
    int j = ((androidx.compose.runtime.a.e)localObject2).size;
    if (j > 0)
    {
      localObject2 = ((androidx.compose.runtime.a.e)localObject2).aqq;
      i = 0;
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(((f)localObject2[i]).cR(paramInt + 1));
      i += 1;
      if (i >= j)
      {
        localObject2 = ((StringBuilder)localObject1).toString();
        kotlin.g.b.s.s(localObject2, "tree.toString()");
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          kotlin.g.b.s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        AppMethodBeat.o(204680);
        return localObject1;
      }
    }
  }
  
  private static void g(f paramf)
  {
    AppMethodBeat.i(204701);
    d locald = paramf.aOn;
    int i = g.$EnumSwitchMapping$0[locald.ordinal()];
    switch (i)
    {
    default: 
      paramf = new IllegalStateException(kotlin.g.b.s.X("Unexpected state ", paramf.aOn));
      AppMethodBeat.o(204701);
      throw paramf;
    case 1: 
    case 2: 
      paramf.aOn = d.aOS;
      if (i == 1)
      {
        paramf.xG();
        AppMethodBeat.o(204701);
        return;
      }
      paramf.xH();
      AppMethodBeat.o(204701);
      return;
    }
    AppMethodBeat.o(204701);
  }
  
  private final void j(androidx.compose.ui.f paramf)
  {
    AppMethodBeat.i(204722);
    Object localObject = this.aOo;
    int j = ((androidx.compose.runtime.a.e)localObject).size;
    int i;
    if (j > 0)
    {
      localObject = ((androidx.compose.runtime.a.e)localObject).aqq;
      i = 0;
    }
    for (;;)
    {
      ((b)localObject[i]).aNQ = false;
      i += 1;
      if (i >= j)
      {
        paramf.a(ah.aiuX, (kotlin.g.a.m)new k(this));
        AppMethodBeat.o(204722);
        return;
      }
    }
  }
  
  private final void xD()
  {
    AppMethodBeat.i(204703);
    Object localObject;
    int j;
    int i;
    if (this.aOw)
    {
      this.aOw = false;
      localObject = xr();
      j = ((androidx.compose.runtime.a.e)localObject).size;
      if (j > 0)
      {
        localObject = ((androidx.compose.runtime.a.e)localObject).aqq;
        i = 0;
      }
    }
    for (;;)
    {
      ((f)localObject[i]).xD();
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(204703);
        return;
      }
    }
  }
  
  private final void xE()
  {
    AppMethodBeat.i(204707);
    Object localObject = xr();
    int j = ((androidx.compose.runtime.a.e)localObject).size;
    int i;
    if (j > 0)
    {
      localObject = ((androidx.compose.runtime.a.e)localObject).aqq;
      i = 0;
    }
    for (;;)
    {
      f localf = (f)localObject[i];
      if ((localf.aOn == d.aOO) && (localf.aOA == f.aOU) && (h(localf))) {
        xG();
      }
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(204707);
        return;
      }
    }
  }
  
  private final void xK()
  {
    AppMethodBeat.i(204715);
    j localj1 = this.aOD.aPZ;
    j localj2 = this.aOC;
    while (!kotlin.g.b.s.p(localj1, localj2))
    {
      this.aOo.add((b)localj1);
      localj1 = localj1.xg();
      kotlin.g.b.s.checkNotNull(localj1);
    }
    AppMethodBeat.o(204715);
  }
  
  private final boolean xL()
  {
    AppMethodBeat.i(204737);
    j localj1 = this.aOD.aPZ;
    j localj2 = this.aOC.xg();
    while ((!kotlin.g.b.s.p(localj1, localj2)) && (localj1 != null))
    {
      if (localj1.aPu != null)
      {
        AppMethodBeat.o(204737);
        return false;
      }
      if ((localj1 instanceof m))
      {
        AppMethodBeat.o(204737);
        return true;
      }
      localj1 = localj1.xg();
    }
    AppMethodBeat.o(204737);
    return true;
  }
  
  private final void xp()
  {
    int i = 0;
    AppMethodBeat.i(204671);
    androidx.compose.runtime.a.e locale;
    Object localObject1;
    int j;
    if (this.aOj)
    {
      this.aOj = false;
      locale = this.aOi;
      if (locale != null) {
        break label125;
      }
      locale = new androidx.compose.runtime.a.e(new f[16]);
      this.aOi = locale;
      locale.clear();
      localObject1 = this.aOh;
      j = ((androidx.compose.runtime.a.e)localObject1).size;
      if (j > 0) {
        localObject1 = ((androidx.compose.runtime.a.e)localObject1).aqq;
      }
    }
    label138:
    for (;;)
    {
      Object localObject2 = (f)localObject1[i];
      if (((f)localObject2).aOf)
      {
        localObject2 = ((f)localObject2).xr();
        locale.a(locale.size, (androidx.compose.runtime.a.e)localObject2);
      }
      for (;;)
      {
        i += 1;
        if (i < j) {
          break label138;
        }
        AppMethodBeat.o(204671);
        return;
        label125:
        break;
        locale.add(localObject2);
      }
    }
  }
  
  private final void xy()
  {
    AppMethodBeat.i(204692);
    xG();
    f localf = xu();
    if (localf != null) {
      localf.xA();
    }
    xJ();
    AppMethodBeat.o(204692);
  }
  
  private j xz()
  {
    AppMethodBeat.i(204699);
    Object localObject;
    j localj;
    if (this.aOF)
    {
      localObject = this.aOC;
      localj = this.aOD.aPZ.aPj;
      this.aOE = null;
    }
    for (;;)
    {
      if (!kotlin.g.b.s.p(localObject, localj)) {
        if (localObject != null) {
          break label98;
        }
      }
      label98:
      for (x localx = null; localx != null; localx = ((j)localObject).aPu)
      {
        this.aOE = ((j)localObject);
        localObject = this.aOE;
        if ((localObject == null) || (((j)localObject).aPu != null)) {
          break label123;
        }
        localObject = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(204699);
        throw ((Throwable)localObject);
      }
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((j)localObject).aPj;
      }
    }
    label123:
    AppMethodBeat.o(204699);
    return localObject;
  }
  
  public final void a(int paramInt, f paramf)
  {
    int j = 1;
    AppMethodBeat.i(204915);
    kotlin.g.b.s.u(paramf, "instance");
    if (paramf.aOk == null)
    {
      i = 1;
      if (i != 0) {
        break label119;
      }
      localObject = new StringBuilder("Cannot insert ").append(paramf).append(" because it already has a parent. This tree: ").append(f(this)).append(" Other tree: ");
      paramf = paramf.aOk;
      if (paramf != null) {
        break label111;
      }
    }
    label111:
    for (paramf = null;; paramf = f(paramf))
    {
      paramf = (Throwable)new IllegalStateException(paramf.toString());
      AppMethodBeat.o(204915);
      throw paramf;
      i = 0;
      break;
    }
    label119:
    if (paramf.aOl == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException(("Cannot insert " + paramf + " because it already has an owner. This tree: " + f(this) + " Other tree: " + f(paramf)).toString());
      AppMethodBeat.o(204915);
      throw paramf;
    }
    paramf.aOk = this;
    this.aOh.add(paramInt, paramf);
    xv();
    if (paramf.aOf)
    {
      if (!this.aOf) {}
      for (paramInt = j; paramInt == 0; paramInt = 0)
      {
        paramf = (Throwable)new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
        AppMethodBeat.o(204915);
        throw paramf;
      }
      this.aOg += 1;
    }
    xq();
    paramf.aOD.aPZ.aPj = this.aOC;
    Object localObject = this.aOl;
    if (localObject != null) {
      paramf.a((y)localObject);
    }
    AppMethodBeat.o(204915);
  }
  
  public final void a(androidx.compose.ui.h.p paramp)
  {
    AppMethodBeat.i(204987);
    kotlin.g.b.s.u(paramp, "value");
    if (!kotlin.g.b.s.p(this.ahe, paramp))
    {
      this.ahe = paramp;
      this.aOs.b(this.ahe);
      xG();
    }
    AppMethodBeat.o(204987);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(204907);
    kotlin.g.b.s.u(paramd, "<set-?>");
    this.aOn = paramd;
    AppMethodBeat.o(204907);
  }
  
  public final void a(y paramy)
  {
    Object localObject2 = null;
    AppMethodBeat.i(204946);
    kotlin.g.b.s.u(paramy, "owner");
    if (this.aOl == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramy = (Throwable)new IllegalStateException(("Cannot attach " + this + " as it already is attached.  Tree: " + f(this)).toString());
      AppMethodBeat.o(204946);
      throw paramy;
    }
    if (this.aOk != null)
    {
      localObject1 = this.aOk;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!kotlin.g.b.s.p(localObject1, paramy)) {
          break label235;
        }
      }
    }
    else
    {
      i = 1;
      label118:
      if (i != 0) {
        break label256;
      }
      localObject1 = new StringBuilder("Attaching to a different owner(").append(paramy).append(") than the parent's owner(");
      paramy = xu();
      if (paramy != null) {
        break label240;
      }
      paramy = null;
      label155:
      localObject1 = ((StringBuilder)localObject1).append(paramy).append("). This tree: ").append(f(this)).append(" Parent tree: ");
      paramy = this.aOk;
      if (paramy != null) {
        break label248;
      }
    }
    label235:
    label240:
    label248:
    for (paramy = (y)localObject2;; paramy = f(paramy))
    {
      paramy = (Throwable)new IllegalStateException(paramy.toString());
      AppMethodBeat.o(204946);
      throw paramy;
      localObject1 = ((f)localObject1).aOl;
      break;
      i = 0;
      break label118;
      paramy = paramy.aOl;
      break label155;
    }
    label256:
    Object localObject1 = xu();
    if (localObject1 == null) {
      this.aOw = true;
    }
    this.aOl = paramy;
    int j;
    if (localObject1 == null)
    {
      i = -1;
      this.aOm = (i + 1);
      if (androidx.compose.ui.k.p.G(this) != null) {
        paramy.ym();
      }
      paramy.z(this);
      localObject2 = this.aOh;
      j = ((androidx.compose.runtime.a.e)localObject2).size;
      if (j > 0)
      {
        localObject2 = ((androidx.compose.runtime.a.e)localObject2).aqq;
        i = 0;
      }
    }
    for (;;)
    {
      ((f)localObject2[i]).a(paramy);
      i += 1;
      if (i >= j)
      {
        xG();
        if (localObject1 != null) {
          ((f)localObject1).xG();
        }
        this.aOC.vX();
        localObject1 = this.aOD.aPZ;
        localObject2 = this.aOC;
        for (;;)
        {
          if (!kotlin.g.b.s.p(localObject1, localObject2))
          {
            ((j)localObject1).vX();
            localObject1 = ((j)localObject1).xg();
            kotlin.g.b.s.checkNotNull(localObject1);
            continue;
            i = ((f)localObject1).aOm;
            break;
          }
        }
        localObject1 = this.aOH;
        if (localObject1 != null) {
          ((kotlin.g.a.b)localObject1).invoke(paramy);
        }
        AppMethodBeat.o(204946);
        return;
      }
    }
  }
  
  public final boolean a(androidx.compose.ui.n.b paramb)
  {
    AppMethodBeat.i(205158);
    if (paramb != null)
    {
      boolean bool = this.aOD.aF(paramb.value);
      AppMethodBeat.o(205158);
      return bool;
    }
    AppMethodBeat.o(205158);
    return false;
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204928);
    if (paramInt2 >= 0) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(("count (" + paramInt2 + ") must be greater than 0").toString());
      AppMethodBeat.o(204928);
      throw ((Throwable)localObject);
    }
    if (this.aOl != null)
    {
      i = 1;
      paramInt2 = paramInt1 + paramInt2 - 1;
      if (paramInt1 > paramInt2) {}
    }
    for (;;)
    {
      localObject = (f)this.aOh.removeAt(paramInt2);
      xv();
      if (i != 0) {
        ((f)localObject).xw();
      }
      ((f)localObject).aOk = null;
      if (((f)localObject).aOf) {
        this.aOg -= 1;
      }
      xq();
      if (paramInt2 == paramInt1)
      {
        AppMethodBeat.o(204928);
        return;
        i = 0;
        break;
      }
      paramInt2 -= 1;
    }
  }
  
  public final androidx.compose.ui.h.x aw(long paramLong)
  {
    AppMethodBeat.i(205146);
    androidx.compose.ui.h.x localx = this.aOD.aw(paramLong);
    AppMethodBeat.o(205146);
    return localx;
  }
  
  public final void d(long paramLong, List<androidx.compose.ui.g.c.s> paramList)
  {
    AppMethodBeat.i(205063);
    kotlin.g.b.s.u(paramList, "hitPointerInputFilters");
    paramLong = this.aOD.aPZ.aC(paramLong);
    this.aOD.aPZ.b(paramLong, paramList);
    AppMethodBeat.o(205063);
  }
  
  public final void d(androidx.compose.ui.e.u paramu)
  {
    AppMethodBeat.i(205055);
    kotlin.g.b.s.u(paramu, "canvas");
    this.aOD.aPZ.e(paramu);
    AppMethodBeat.o(205055);
  }
  
  public final void e(long paramLong, List<androidx.compose.ui.k.w> paramList)
  {
    AppMethodBeat.i(205070);
    kotlin.g.b.s.u(paramList, "hitSemanticsWrappers");
    paramLong = this.aOD.aPZ.aC(paramLong);
    this.aOD.aPZ.c(paramLong, paramList);
    AppMethodBeat.o(205070);
  }
  
  public final boolean isAttached()
  {
    return this.aOl != null;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(204963);
    boolean bool = isAttached();
    AppMethodBeat.o(204963);
    return bool;
  }
  
  public final void k(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(205120);
    kotlin.g.b.s.u(parama, "block");
    i.q(this).getSnapshotObserver().k(parama);
    AppMethodBeat.o(205120);
  }
  
  public final void n(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(204936);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(204936);
      return;
    }
    if (paramInt3 > 0) {}
    int k;
    label109:
    label119:
    for (int j = 0;; j = k)
    {
      k = j + 1;
      int i;
      if (paramInt1 > paramInt2)
      {
        i = paramInt1 + j;
        if (paramInt1 <= paramInt2) {
          break label109;
        }
      }
      for (j = paramInt2 + j;; j = paramInt2 + paramInt3 - 2)
      {
        f localf = (f)this.aOh.removeAt(i);
        this.aOh.add(j, localf);
        if (k < paramInt3) {
          break label119;
        }
        xv();
        xq();
        xG();
        AppMethodBeat.o(204936);
        return;
        i = paramInt1;
        break;
      }
    }
  }
  
  public final void setDensity(androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(204997);
    kotlin.g.b.s.u(paramd, "value");
    if (!kotlin.g.b.s.p(this.TD, paramd))
    {
      this.TD = paramd;
      xy();
    }
    AppMethodBeat.o(204997);
  }
  
  public final void setLayoutDirection(n paramn)
  {
    AppMethodBeat.i(205006);
    kotlin.g.b.s.u(paramn, "value");
    if (this.agm != paramn)
    {
      this.agm = paramn;
      xy();
    }
    AppMethodBeat.o(205006);
  }
  
  public final void setModifier(androidx.compose.ui.f paramf)
  {
    int j = 0;
    AppMethodBeat.i(205042);
    kotlin.g.b.s.u(paramf, "value");
    if (kotlin.g.b.s.p(paramf, this.aOG))
    {
      AppMethodBeat.o(205042);
      return;
    }
    int i;
    if (!kotlin.g.b.s.p(this.aOG, androidx.compose.ui.f.aud))
    {
      if (!this.aOf) {}
      for (i = 1; i == 0; i = 0)
      {
        paramf = (Throwable)new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        AppMethodBeat.o(205042);
        throw paramf;
      }
    }
    this.aOG = paramf;
    boolean bool1 = xL();
    xK();
    j(paramf);
    Object localObject = this.aOD.aPZ;
    if ((androidx.compose.ui.k.p.G(this) != null) && (isAttached()))
    {
      paramf = this.aOl;
      kotlin.g.b.s.checkNotNull(paramf);
      paramf.ym();
    }
    paramf = this.aOJ;
    boolean bool2 = ((Boolean)this.aOG.b(Boolean.FALSE, (kotlin.g.a.m)new i(paramf))).booleanValue();
    paramf = this.aOJ;
    if (paramf != null) {
      paramf.clear();
    }
    j localj1 = (j)this.aOG.b(this.aOC, (kotlin.g.a.m)new m(this));
    paramf = xu();
    int k;
    if (paramf == null)
    {
      paramf = null;
      localj1.aPj = paramf;
      paramf = this.aOD;
      kotlin.g.b.s.u(localj1, "<set-?>");
      paramf.aPZ = localj1;
      if (!isAttached()) {
        break label364;
      }
      paramf = this.aOo;
      k = paramf.size;
      if (k > 0)
      {
        paramf = paramf.aqq;
        i = j;
      }
    }
    for (;;)
    {
      ((b)paramf[i]).detach();
      i += 1;
      if (i >= k)
      {
        paramf = this.aOD.aPZ;
        j localj2 = this.aOC;
        for (;;)
        {
          if (!kotlin.g.b.s.p(paramf, localj2))
          {
            if (!paramf.isAttached()) {
              paramf.vX();
            }
            paramf = paramf.xg();
            kotlin.g.b.s.checkNotNull(paramf);
            continue;
            paramf = paramf.aOC;
            break;
          }
        }
        label364:
        this.aOo.clear();
        paramf = this.aOD.aPZ;
        localj2 = this.aOC;
        while (!kotlin.g.b.s.p(paramf, localj2))
        {
          paramf.vV();
          paramf = paramf.xg();
          kotlin.g.b.s.checkNotNull(paramf);
        }
        if ((!kotlin.g.b.s.p(localObject, this.aOC)) || (!kotlin.g.b.s.p(localj1, this.aOC)))
        {
          xG();
          paramf = xu();
          if (paramf != null) {
            paramf.xH();
          }
        }
        for (;;)
        {
          paramf = this.aOD.aQg;
          localObject = this.aOD;
          ((w)localObject).aQg = ((w)localObject).aPZ.wI();
          if (!kotlin.g.b.s.p(paramf, this.aOD.aQg))
          {
            paramf = xu();
            if (paramf != null) {
              paramf.xG();
            }
          }
          if ((bool1) || (xL()))
          {
            paramf = xu();
            if (paramf != null) {
              paramf.xA();
            }
          }
          AppMethodBeat.o(205042);
          return;
          if ((this.aOn == d.aOS) && (bool2)) {
            xG();
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204974);
    String str = af.al(this) + " children: " + xt().size() + " measurePolicy: " + this.ahe;
    AppMethodBeat.o(204974);
    return str;
  }
  
  public final Object wI()
  {
    return this.aOD.aQg;
  }
  
  public final androidx.compose.ui.h.j wK()
  {
    return (androidx.compose.ui.h.j)this.aOC;
  }
  
  public final void wZ()
  {
    AppMethodBeat.i(205170);
    xG();
    y localy = this.aOl;
    if (localy != null) {
      localy.yl();
    }
    AppMethodBeat.o(205170);
  }
  
  public final void xA()
  {
    AppMethodBeat.i(205019);
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((f)localObject1).xz();
      if (localObject2 != null)
      {
        ((j)localObject2).xY();
        AppMethodBeat.o(205019);
        return;
      }
      localObject2 = ((f)localObject1).xu();
      localObject1 = localObject2;
    } while (localObject2 != null);
    AppMethodBeat.o(205019);
  }
  
  public final void xB()
  {
    AppMethodBeat.i(205081);
    this.aOu.xP();
    if (this.aOn == d.aOQ) {
      xE();
    }
    if (this.aOn == d.aOQ)
    {
      this.aOn = d.aOR;
      i.q(this).getSnapshotObserver().a(this, (kotlin.g.a.a)new j(this));
      this.aOn = d.aOS;
    }
    if (this.aOu.aPc) {
      this.aOu.aPd = true;
    }
    if ((this.aOu.dirty) && (this.aOu.xO())) {
      this.aOu.xQ();
    }
    AppMethodBeat.o(205081);
  }
  
  final void xC()
  {
    AppMethodBeat.i(205088);
    this.aOw = true;
    Object localObject1 = this.aOD.aPZ;
    Object localObject2 = this.aOC.xg();
    while ((!kotlin.g.b.s.p(localObject1, localObject2)) && (localObject1 != null))
    {
      if (((j)localObject1).aPt) {
        ((j)localObject1).xY();
      }
      localObject1 = ((j)localObject1).xg();
    }
    localObject1 = xr();
    int j = ((androidx.compose.runtime.a.e)localObject1).size;
    int i;
    if (j > 0)
    {
      localObject1 = ((androidx.compose.runtime.a.e)localObject1).aqq;
      i = 0;
    }
    for (;;)
    {
      localObject2 = (f)localObject1[i];
      if (((f)localObject2).aOx != 2147483647)
      {
        ((f)localObject2).xC();
        g((f)localObject2);
      }
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(205088);
        return;
      }
    }
  }
  
  public final void xF()
  {
    AppMethodBeat.i(205102);
    Object localObject = this;
    if (((f)localObject).aOu.dirty)
    {
      AppMethodBeat.o(205102);
      return;
    }
    ((f)localObject).aOu.dirty = true;
    f localf = ((f)localObject).xu();
    if (localf == null)
    {
      AppMethodBeat.o(205102);
      return;
    }
    if (((f)localObject).aOu.aPb) {
      localf.xG();
    }
    for (;;)
    {
      if (((f)localObject).aOu.aPe) {
        ((f)localObject).xG();
      }
      if (((f)localObject).aOu.aPf) {
        localf.xH();
      }
      localObject = localf;
      break;
      if (((f)localObject).aOu.aPd) {
        localf.xH();
      }
    }
  }
  
  public final void xG()
  {
    AppMethodBeat.i(205107);
    y localy = this.aOl;
    if (localy == null)
    {
      AppMethodBeat.o(205107);
      return;
    }
    if ((!this.aOp) && (!this.aOf)) {
      localy.x(this);
    }
    AppMethodBeat.o(205107);
  }
  
  public final void xH()
  {
    AppMethodBeat.i(205115);
    if (!this.aOf)
    {
      y localy = this.aOl;
      if (localy != null) {
        localy.y(this);
      }
    }
    AppMethodBeat.o(205115);
  }
  
  public final void xI()
  {
    AppMethodBeat.i(205129);
    if (this.aOn != d.aOS)
    {
      AppMethodBeat.o(205129);
      return;
    }
    if (!this.aOw)
    {
      AppMethodBeat.o(205129);
      return;
    }
    Object localObject = this.aOJ;
    int j;
    int i;
    if (localObject != null)
    {
      j = ((androidx.compose.runtime.a.e)localObject).size;
      if (j > 0)
      {
        localObject = ((androidx.compose.runtime.a.e)localObject).aqq;
        i = 0;
      }
    }
    for (;;)
    {
      u localu = (u)localObject[i];
      ((androidx.compose.ui.h.s)localu.wb()).g((androidx.compose.ui.h.j)localu);
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(205129);
        return;
      }
    }
  }
  
  public final void xJ()
  {
    AppMethodBeat.i(205135);
    Object localObject = this.aOD.aPZ;
    j localj = this.aOC;
    while (!kotlin.g.b.s.p(localObject, localj))
    {
      x localx = ((j)localObject).aPu;
      if (localx != null) {
        localx.invalidate();
      }
      localObject = ((j)localObject).xg();
      kotlin.g.b.s.checkNotNull(localObject);
    }
    localObject = this.aOC.aPu;
    if (localObject != null) {
      ((x)localObject).invalidate();
    }
    AppMethodBeat.o(205135);
  }
  
  final void xq()
  {
    AppMethodBeat.i(204864);
    if (this.aOg > 0) {
      this.aOj = true;
    }
    if (this.aOf)
    {
      f localf = xu();
      if (localf != null) {
        localf.aOj = true;
      }
    }
    AppMethodBeat.o(204864);
  }
  
  public final androidx.compose.runtime.a.e<f> xr()
  {
    AppMethodBeat.i(204878);
    if (this.aOg == 0)
    {
      locale = this.aOh;
      AppMethodBeat.o(204878);
      return locale;
    }
    xp();
    androidx.compose.runtime.a.e locale = this.aOi;
    kotlin.g.b.s.checkNotNull(locale);
    AppMethodBeat.o(204878);
    return locale;
  }
  
  public final List<f> xt()
  {
    AppMethodBeat.i(369515);
    List localList = xr().qp();
    AppMethodBeat.o(369515);
    return localList;
  }
  
  public final f xu()
  {
    Object localObject = this;
    f localf = ((f)localObject).aOk;
    if ((localf != null) && (localf.aOf == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label43;
      }
      localf = ((f)localObject).aOk;
      localObject = localf;
      if (localf != null) {
        break;
      }
      return null;
    }
    label43:
    return ((f)localObject).aOk;
  }
  
  final void xv()
  {
    AppMethodBeat.i(204921);
    Object localObject = this;
    f localf;
    do
    {
      if (!((f)localObject).aOf) {
        break;
      }
      localf = ((f)localObject).xu();
      localObject = localf;
    } while (localf != null);
    for (;;)
    {
      AppMethodBeat.o(204921);
      return;
      ((f)localObject).aOr = true;
    }
  }
  
  public final void xw()
  {
    Object localObject1 = null;
    AppMethodBeat.i(204952);
    Object localObject2 = this.aOl;
    if (localObject2 == null)
    {
      localObject2 = xu();
      if (localObject2 == null) {}
      for (;;)
      {
        localObject1 = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Cannot detach node that is already detached!  Tree: ", localObject1).toString());
        AppMethodBeat.o(204952);
        throw ((Throwable)localObject1);
        localObject1 = ((f)localObject2).cR(0);
      }
    }
    localObject1 = xu();
    if (localObject1 != null)
    {
      ((f)localObject1).xA();
      ((f)localObject1).xG();
    }
    localObject1 = this.aOu;
    ((g)localObject1).dirty = true;
    ((g)localObject1).aPb = false;
    ((g)localObject1).aPd = false;
    ((g)localObject1).aPc = false;
    ((g)localObject1).aPe = false;
    ((g)localObject1).aPf = false;
    ((g)localObject1).aPg = null;
    localObject1 = this.aOI;
    if (localObject1 != null) {
      ((kotlin.g.a.b)localObject1).invoke(localObject2);
    }
    localObject1 = this.aOD.aPZ;
    j localj = this.aOC;
    while (!kotlin.g.b.s.p(localObject1, localj))
    {
      ((j)localObject1).detach();
      localObject1 = ((j)localObject1).xg();
      kotlin.g.b.s.checkNotNull(localObject1);
    }
    this.aOC.detach();
    if (androidx.compose.ui.k.p.G(this) != null) {
      ((y)localObject2).ym();
    }
    ((y)localObject2).A(this);
    this.aOl = null;
    this.aOm = 0;
    localObject1 = this.aOh;
    int j = ((androidx.compose.runtime.a.e)localObject1).size;
    int i;
    if (j > 0)
    {
      localObject1 = ((androidx.compose.runtime.a.e)localObject1).aqq;
      i = 0;
    }
    for (;;)
    {
      ((f)localObject1[i]).xw();
      i += 1;
      if (i >= j)
      {
        this.aOx = 2147483647;
        this.aOy = 2147483647;
        this.aOw = false;
        AppMethodBeat.o(204952);
        return;
      }
    }
  }
  
  public final androidx.compose.runtime.a.e<f> xx()
  {
    AppMethodBeat.i(204956);
    if (this.aOr)
    {
      this.aOq.clear();
      locale1 = this.aOq;
      androidx.compose.runtime.a.e locale2 = xr();
      locale1.a(locale1.size, locale2);
      this.aOq.a(this.aOL);
      this.aOr = false;
    }
    androidx.compose.runtime.a.e locale1 = this.aOq;
    AppMethodBeat.o(204956);
    return locale1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<f>
  {
    public static final b aON;
    
    static
    {
      AppMethodBeat.i(204665);
      aON = new b();
      AppMethodBeat.o(204665);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/node/LayoutNode$Companion$ErrorMeasurePolicy$1", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "measure", "", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Ljava/lang/Void;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends f.e
  {
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "NeedsRemeasure", "Measuring", "NeedsRelayout", "LayingOut", "Ready", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(204581);
      aOO = new d("NeedsRemeasure", 0);
      aOP = new d("Measuring", 1);
      aOQ = new d("NeedsRelayout", 2);
      aOR = new d("LayingOut", 3);
      aOS = new d("Ready", 4);
      aOT = new d[] { aOO, aOP, aOQ, aOR, aOS };
      AppMethodBeat.o(204581);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class e
    implements androidx.compose.ui.h.p
  {
    private final String error;
    
    public e(String paramString)
    {
      this.error = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    static
    {
      AppMethodBeat.i(204605);
      aOU = new f("InMeasureBlock", 0);
      aOV = new f("InLayoutBlock", 1);
      aOW = new f("NotUsed", 2);
      aOX = new f[] { aOU, aOV, aOW };
      AppMethodBeat.o(204605);
    }
    
    private f() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "node1", "Landroidx/compose/ui/node/LayoutNode;", "kotlin.jvm.PlatformType", "node2"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h<T>
    implements Comparator
  {
    public static final h<T> aOY;
    
    static
    {
      AppMethodBeat.i(204604);
      aOY = new h();
      AppMethodBeat.o(204604);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mod", "Landroidx/compose/ui/Modifier$Element;", "hasNewCallback"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.ui.f.c, Boolean, Boolean>
  {
    i(androidx.compose.runtime.a.e<u> parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "mod", "Landroidx/compose/ui/Modifier$Element;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.m<ah, androidx.compose.ui.f.c, ah>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/node/LayoutNode$measureScope$1", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/unit/Density;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements r
  {
    l(f paramf) {}
    
    public final q a(int paramInt1, int paramInt2, Map<androidx.compose.ui.h.a, Integer> paramMap, kotlin.g.a.b<? super x.a, ah> paramb)
    {
      AppMethodBeat.i(204666);
      paramMap = r.a.a(this, paramInt1, paramInt2, paramMap, paramb);
      AppMethodBeat.o(204666);
      return paramMap;
    }
    
    public final float bs(int paramInt)
    {
      AppMethodBeat.i(204659);
      float f = r.a.a((r)this, paramInt);
      AppMethodBeat.o(204659);
      return f;
    }
    
    public final n getLayoutDirection()
    {
      return this.aPa.agm;
    }
    
    public final float mn()
    {
      AppMethodBeat.i(204622);
      float f = this.aPa.TD.mn();
      AppMethodBeat.o(204622);
      return f;
    }
    
    public final float mo()
    {
      AppMethodBeat.i(204626);
      float f = this.aPa.TD.mo();
      AppMethodBeat.o(204626);
      return f;
    }
    
    public final float t(long paramLong)
    {
      AppMethodBeat.i(204656);
      float f = r.a.a((r)this, paramLong);
      AppMethodBeat.o(204656);
      return f;
    }
    
    public final int v(float paramFloat)
    {
      AppMethodBeat.i(204640);
      int i = r.a.a((r)this, paramFloat);
      AppMethodBeat.o(204640);
      return i;
    }
    
    public final float w(float paramFloat)
    {
      AppMethodBeat.i(204646);
      paramFloat = r.a.b((r)this, paramFloat);
      AppMethodBeat.o(204646);
      return paramFloat;
    }
    
    public final long x(float paramFloat)
    {
      AppMethodBeat.i(204651);
      long l = r.a.c((r)this, paramFloat);
      AppMethodBeat.o(204651);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "mod", "Landroidx/compose/ui/Modifier$Element;", "toWrap"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.ui.f.c, j, j>
  {
    m(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.f
 * JD-Core Version:    0.7.0.1
 */