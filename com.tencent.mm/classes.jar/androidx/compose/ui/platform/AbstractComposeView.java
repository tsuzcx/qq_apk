package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.compose.runtime.aw;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.ui.i.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "composition", "Landroidx/compose/runtime/Composition;", "creatingComposition", "", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "", "getDisposeViewCompositionStrategy$annotations", "()V", "hasComposition", "getHasComposition", "()Z", "value", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInLayout", "preventRequestLayout", "checkAddView", "createComposition", "disposeComposition", "ensureCompositionCreated", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "onAttachedToWindow", "onLayout", "onMeasure", "onRtlPropertiesChanged", "layoutDirection", "resolveParentCompositionContext", "setParentCompositionContext", "parent", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AbstractComposeView
  extends ViewGroup
{
  public static final int Ue = 8;
  private k aDs;
  private l aQt;
  private IBinder aQu;
  private a<ah> aQv;
  private boolean aQw;
  private boolean aQx;
  private l alH;
  
  public AbstractComposeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AbstractComposeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClipChildren(false);
    setClipToPadding(false);
    this.aQv = at.b.aVn.a(this);
  }
  
  private final void setParentContext(l paraml)
  {
    if (this.alH != paraml)
    {
      this.alH = paraml;
      if (paraml != null) {
        this.aQt = null;
      }
      paraml = this.aDs;
      if (paraml != null)
      {
        paraml.dispose();
        this.aDs = null;
        if (isAttachedToWindow()) {
          ys();
        }
      }
    }
  }
  
  private final void setPreviousAttachedWindowToken(IBinder paramIBinder)
  {
    if (this.aQu != paramIBinder)
    {
      this.aQu = paramIBinder;
      this.aQt = null;
    }
  }
  
  private final void yq()
  {
    if (!this.aQx) {
      throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }
  }
  
  private final l yr()
  {
    Object localObject2 = this.alH;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (View)this;
      s.u(localObject2, "<this>");
      localObject1 = be.z((View)localObject2);
      if (localObject1 != null) {
        break label220;
      }
      for (localObject2 = ((View)localObject2).getParent(); (localObject1 == null) && ((localObject2 instanceof View)); localObject2 = ((ViewParent)localObject2).getParent()) {
        localObject1 = be.z((View)localObject2);
      }
    }
    label187:
    label220:
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (localObject2 == null) {
        localObject2 = null;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label187;
        }
        localObject2 = this.aQt;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label187;
        }
        localObject1 = (View)this;
        s.u(localObject1, "<this>");
        if (((View)localObject1).isAttachedToWindow()) {
          break;
        }
        throw ((Throwable)new IllegalStateException(("Cannot locate windowRecomposer; View " + localObject1 + " is not attached to a window").toString()));
        this.aQt = ((l)localObject2);
      }
      localObject1 = be.A((View)localObject1);
      localObject2 = be.z((View)localObject1);
      if (localObject2 == null) {
        localObject2 = bd.aVN;
      }
      for (localObject1 = bd.y((View)localObject1);; localObject1 = (aw)localObject2)
      {
        this.aQt = ((l)localObject1);
        localObject1 = (l)localObject1;
        return localObject1;
        if (!(localObject2 instanceof aw)) {
          break;
        }
      }
      throw ((Throwable)new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString()));
    }
  }
  
  private final void ys()
  {
    if (this.aDs == null) {}
    try
    {
      this.aQx = true;
      this.aDs = bh.a((ViewGroup)this, yr(), (m)c.a(-985541477, true, new a(this)));
      return;
    }
    finally
    {
      this.aQx = false;
    }
  }
  
  public void addView(View paramView)
  {
    yq();
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    yq();
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    yq();
    super.addView(paramView, paramInt1, paramInt2);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    yq();
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    yq();
    super.addView(paramView, paramLayoutParams);
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    yq();
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams);
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    yq();
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public abstract void b(h paramh, int paramInt);
  
  public final boolean getHasComposition()
  {
    return this.aDs != null;
  }
  
  protected boolean getShouldCreateCompositionOnAttachedToWindow()
  {
    return true;
  }
  
  public final boolean getShowLayoutBounds()
  {
    return this.aQw;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setPreviousAttachedWindowToken(getWindowToken());
    if (getShouldCreateCompositionOnAttachedToWindow()) {
      ys();
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if (localView != null) {
      localView.layout(getPaddingLeft(), getPaddingTop(), paramInt3 - paramInt1 - getPaddingRight(), paramInt4 - paramInt2 - getPaddingBottom());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    ys();
    View localView = getChildAt(0);
    if (localView == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = Math.max(0, View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight());
    int j = Math.max(0, View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom());
    localView.measure(View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt1)), View.MeasureSpec.makeMeasureSpec(j, View.MeasureSpec.getMode(paramInt2)));
    setMeasuredDimension(localView.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), localView.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    View localView = getChildAt(0);
    if (localView != null) {
      localView.setLayoutDirection(paramInt);
    }
  }
  
  public final void setParentCompositionContext(l paraml)
  {
    setParentContext(paraml);
  }
  
  public final void setShowLayoutBounds(boolean paramBoolean)
  {
    this.aQw = paramBoolean;
    View localView = getChildAt(0);
    if (localView != null) {
      ((y)localView).setShowLayoutBounds(paramBoolean);
    }
  }
  
  public final void setViewCompositionStrategy(at paramat)
  {
    s.u(paramat, "strategy");
    a locala = this.aQv;
    if (locala != null) {
      locala.invoke();
    }
    this.aQv = paramat.a(this);
  }
  
  public final void yp()
  {
    if ((this.alH != null) || (isAttachedToWindow())) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString()));
    }
    ys();
  }
  
  public final void yt()
  {
    k localk = this.aDs;
    if (localk != null) {
      localk.dispose();
    }
    this.aDs = null;
    requestLayout();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    a(AbstractComposeView paramAbstractComposeView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.AbstractComposeView
 * JD-Core Version:    0.7.0.1
 */