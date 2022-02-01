package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.compose.ui.i.f;
import androidx.compose.ui.p.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "holderToLayoutNode", "Ljava/util/HashMap;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/collections/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "layoutNodeToHolder", "getLayoutNodeToHolder", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "drawView", "", "view", "canvas", "Landroid/graphics/Canvas;", "invalidateChildInParent", "", "location", "", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", "Landroid/view/View;", "target", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends ViewGroup
{
  private final HashMap<a, f> aTo;
  private final HashMap<f, a> aTp;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206771);
    setClipChildren(false);
    this.aTo = new HashMap();
    this.aTp = new HashMap();
    AppMethodBeat.o(206771);
  }
  
  public static void a(a parama, Canvas paramCanvas)
  {
    AppMethodBeat.i(206776);
    s.u(parama, "view");
    s.u(paramCanvas, "canvas");
    parama.draw(paramCanvas);
    AppMethodBeat.o(206776);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final HashMap<a, f> getHolderToLayoutNode()
  {
    return this.aTo;
  }
  
  public final HashMap<f, a> getLayoutNodeToHolder()
  {
    return this.aTp;
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(206826);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    AppMethodBeat.o(206826);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206816);
    Object localObject = this.aTo.keySet();
    s.s(localObject, "holderToLayoutNode.keys");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      locala.layout(locala.getLeft(), locala.getTop(), locala.getRight(), locala.getBottom());
    }
    AppMethodBeat.o(206816);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(206806);
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(206806);
      throw ((Throwable)localObject);
    }
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (i = j; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(206806);
      throw ((Throwable)localObject);
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    Object localObject = this.aTo.keySet();
    s.s(localObject, "holderToLayoutNode.keys");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.bfi != -2147483648) && (locala.bfj != -2147483648)) {
        locala.measure(locala.bfi, locala.bfj);
      }
    }
    AppMethodBeat.o(206806);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(206846);
    cleanupLayoutState((View)this);
    int i = 0;
    int k = getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = getChildAt(i);
      f localf = (f)((Map)this.aTo).get(localView);
      if ((localView.isLayoutRequested()) && (localf != null)) {
        localf.xG();
      }
      if (j >= k)
      {
        AppMethodBeat.o(206846);
        return;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.r
 * JD-Core Version:    0.7.0.1
 */