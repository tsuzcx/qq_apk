package androidx.compose.ui.p;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.compose.runtime.l;
import androidx.compose.ui.b.i;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.g.c.aa;
import androidx.compose.ui.g.c.v;
import androidx.compose.ui.g.c.w.a;
import androidx.compose.ui.h.j;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.p;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.i.y;
import androidx.compose.ui.n.d;
import androidx.compose.ui.platform.be;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "runUpdate", "Lkotlin/Function0;", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends ViewGroup
{
  private d TD;
  private androidx.compose.ui.f aOG;
  private final androidx.compose.ui.i.f aOb;
  private kotlin.g.a.a<ah> beZ;
  private boolean bfa;
  private kotlin.g.a.b<? super androidx.compose.ui.f, ah> bfb;
  private kotlin.g.a.b<? super d, ah> bfc;
  private final androidx.compose.runtime.f.u bfd;
  private final kotlin.g.a.b<a, ah> bfe;
  private final kotlin.g.a.a<ah> bff;
  private kotlin.g.a.b<? super Boolean, ah> bfg;
  private final int[] bfh;
  public int bfi;
  public int bfj;
  private View view;
  
  public a(Context paramContext, final l paraml)
  {
    super(paramContext);
    if (paraml != null) {
      be.a((View)this, paraml);
    }
    setSaveFromParentEnabled(false);
    this.beZ = ((kotlin.g.a.a)a.k.bfo);
    this.aOG = ((androidx.compose.ui.f)androidx.compose.ui.f.aud);
    this.TD = androidx.compose.ui.n.f.H(1.0F, 1.0F);
    this.bfd = new androidx.compose.runtime.f.u((kotlin.g.a.b)new a.j(this));
    this.bfe = ((kotlin.g.a.b)new a.h(this));
    this.bff = ((kotlin.g.a.a)new i(this));
    this.bfh = new int[2];
    this.bfi = -2147483648;
    this.bfj = -2147483648;
    paramContext = (a)this;
    paraml = new androidx.compose.ui.i.f();
    Object localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
    s.u(localObject1, "<this>");
    s.u(paramContext, "view");
    v localv = new v();
    Object localObject2 = (kotlin.g.a.b)new w.a(paramContext);
    s.u(localObject2, "<set-?>");
    localv.aLA = ((kotlin.g.a.b)localObject2);
    localObject2 = new aa();
    aa localaa = localv.aLB;
    if (localaa != null) {
      localaa.aLR = null;
    }
    localv.aLB = ((aa)localObject2);
    localaa = localv.aLB;
    if (localaa != null) {
      localaa.aLR = localv;
    }
    paramContext.setOnRequestDisallowInterceptTouchEvent$ui_release((kotlin.g.a.b)localObject2);
    localObject1 = androidx.compose.ui.h.u.c(i.a(((androidx.compose.ui.f)localObject1).a((androidx.compose.ui.f)localv), (kotlin.g.a.b)new f(paraml, this)), (kotlin.g.a.b)new g(paramContext, paraml));
    paraml.setModifier(paramContext.getModifier().a((androidx.compose.ui.f)localObject1));
    paramContext.setOnModifierChanged$ui_release((kotlin.g.a.b)new a(paraml, (androidx.compose.ui.f)localObject1));
    paraml.setDensity(paramContext.getDensity());
    paramContext.setOnDensityChanged$ui_release((kotlin.g.a.b)new b(paraml));
    localObject1 = new ah.f();
    paraml.aOH = ((kotlin.g.a.b)new c(paramContext, paraml, (ah.f)localObject1));
    paraml.aOI = ((kotlin.g.a.b)new d(paramContext, (ah.f)localObject1));
    paraml.a((p)new e(paramContext, paraml));
    this.aOb = paraml;
  }
  
  public boolean gatherTransparentRegion(Region paramRegion)
  {
    if (paramRegion == null) {
      return true;
    }
    getLocationInWindow(this.bfh);
    int i = this.bfh[0];
    int j = this.bfh[1];
    int k = this.bfh[0];
    int m = getWidth();
    int n = this.bfh[1];
    paramRegion.op(i, j, m + k, getHeight() + n, Region.Op.DIFFERENCE);
    return true;
  }
  
  public final d getDensity()
  {
    return this.TD;
  }
  
  public final androidx.compose.ui.i.f getLayoutNode()
  {
    return this.aOb;
  }
  
  public ViewGroup.LayoutParams getLayoutParams()
  {
    Object localObject1 = this.view;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ViewGroup.LayoutParams(-1, -1);
      }
      return localObject2;
    }
  }
  
  public final androidx.compose.ui.f getModifier()
  {
    return this.aOG;
  }
  
  public final kotlin.g.a.b<d, ah> getOnDensityChanged$ui_release()
  {
    return this.bfc;
  }
  
  public final kotlin.g.a.b<androidx.compose.ui.f, ah> getOnModifierChanged$ui_release()
  {
    return this.bfb;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getOnRequestDisallowInterceptTouchEvent$ui_release()
  {
    return this.bfg;
  }
  
  public final kotlin.g.a.a<ah> getUpdate()
  {
    return this.beZ;
  }
  
  public final View getView()
  {
    return this.view;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    super.invalidateChildInParent(paramArrayOfInt, paramRect);
    this.aOb.xA();
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.bfd.start();
  }
  
  public void onDescendantInvalidated(View paramView1, View paramView2)
  {
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    super.onDescendantInvalidated(paramView1, paramView2);
    this.aOb.xA();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.bfd.stop();
    this.bfd.clear();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.view;
    if (localView != null) {
      localView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    View localView = this.view;
    if (localView != null) {
      localView.measure(paramInt1, paramInt2);
    }
    localView = this.view;
    int i;
    if (localView == null)
    {
      i = 0;
      localView = this.view;
      if (localView != null) {
        break label72;
      }
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      this.bfi = paramInt1;
      this.bfj = paramInt2;
      return;
      i = localView.getMeasuredWidth();
      break;
      label72:
      j = localView.getMeasuredHeight();
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    kotlin.g.a.b localb = this.bfg;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public final void setDensity(d paramd)
  {
    s.u(paramd, "value");
    if (paramd != this.TD)
    {
      this.TD = paramd;
      kotlin.g.a.b localb = this.bfc;
      if (localb != null) {
        localb.invoke(paramd);
      }
    }
  }
  
  public final void setModifier(androidx.compose.ui.f paramf)
  {
    s.u(paramf, "value");
    if (paramf != this.aOG)
    {
      this.aOG = paramf;
      kotlin.g.a.b localb = this.bfb;
      if (localb != null) {
        localb.invoke(paramf);
      }
    }
  }
  
  public final void setOnDensityChanged$ui_release(kotlin.g.a.b<? super d, ah> paramb)
  {
    this.bfc = paramb;
  }
  
  public final void setOnModifierChanged$ui_release(kotlin.g.a.b<? super androidx.compose.ui.f, ah> paramb)
  {
    this.bfb = paramb;
  }
  
  public final void setOnRequestDisallowInterceptTouchEvent$ui_release(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.bfg = paramb;
  }
  
  protected final void setUpdate(kotlin.g.a.a<ah> parama)
  {
    s.u(parama, "value");
    this.beZ = parama;
    this.bfa = true;
    this.bff.invoke();
  }
  
  public final void setView$ui_release(View paramView)
  {
    if (paramView != this.view)
    {
      this.view = paramView;
      removeAllViews();
      if (paramView != null)
      {
        addView(paramView);
        this.bff.invoke();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.f, ah>
  {
    a(androidx.compose.ui.i.f paramf, androidx.compose.ui.f paramf1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/unit/Density;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<d, ah>
  {
    b(androidx.compose.ui.i.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "owner", "Landroidx/compose/ui/node/Owner;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, ah>
  {
    c(a parama, androidx.compose.ui.i.f paramf, ah.f<View> paramf1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "owner", "Landroidx/compose/ui/node/Owner;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, ah>
  {
    d(a parama, ah.f<View> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/viewinterop/AndroidViewHolder$layoutNode$1$5", "Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicHeight", "", "width", "intrinsicWidth", "height", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements p
  {
    e(a parama, androidx.compose.ui.i.f paramf) {}
    
    public final q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(204418);
      s.u(paramr, "$receiver");
      s.u(paramList, "measurables");
      if (androidx.compose.ui.n.b.aT(paramLong) != 0) {
        this.bfl.getChildAt(0).setMinimumWidth(androidx.compose.ui.n.b.aT(paramLong));
      }
      if (androidx.compose.ui.n.b.aV(paramLong) != 0) {
        this.bfl.getChildAt(0).setMinimumHeight(androidx.compose.ui.n.b.aV(paramLong));
      }
      paramList = this.bfl;
      int i = androidx.compose.ui.n.b.aT(paramLong);
      int j = androidx.compose.ui.n.b.aU(paramLong);
      ViewGroup.LayoutParams localLayoutParams = this.bfl.getLayoutParams();
      s.checkNotNull(localLayoutParams);
      i = a.p(i, j, localLayoutParams.width);
      j = androidx.compose.ui.n.b.aV(paramLong);
      int k = androidx.compose.ui.n.b.aW(paramLong);
      localLayoutParams = this.bfl.getLayoutParams();
      s.checkNotNull(localLayoutParams);
      paramList.measure(i, a.p(j, k, localLayoutParams.height));
      paramr = r.a.a(paramr, this.bfl.getMeasuredWidth(), this.bfl.getMeasuredHeight(), (kotlin.g.a.b)new a(this.bfl, paraml));
      AppMethodBeat.o(204418);
      return paramr;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<x.a, ah>
    {
      a(a parama, androidx.compose.ui.i.f paramf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<e, ah>
  {
    f(androidx.compose.ui.i.f paramf, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<j, ah>
  {
    g(a parama, androidx.compose.ui.i.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.p.a
 * JD-Core Version:    0.7.0.1
 */