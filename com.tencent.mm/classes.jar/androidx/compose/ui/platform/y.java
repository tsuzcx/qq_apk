package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e.c;
import androidx.compose.ui.e.u;
import androidx.compose.ui.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/DrawChildContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "Landroidx/compose/ui/graphics/Canvas;", "view", "Landroid/view/View;", "drawingTime", "", "drawChild$ui_release", "onLayout", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class y
  extends ViewGroup
{
  public y(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206788);
    setClipChildren(false);
    setTag(g.a.hide_in_inspector_tag, Boolean.TRUE);
    AppMethodBeat.o(206788);
  }
  
  public final void a(u paramu, View paramView, long paramLong)
  {
    AppMethodBeat.i(206838);
    s.u(paramu, "canvas");
    s.u(paramView, "view");
    super.drawChild(c.a(paramu), paramView, paramLong);
    AppMethodBeat.o(206838);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(206828);
    s.u(paramCanvas, "canvas");
    int m = getChildCount();
    int i = j;
    if (m > 0) {}
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      View localView = getChildAt(i);
      if (localView == null)
      {
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
        AppMethodBeat.o(206828);
        throw paramCanvas;
      }
      if (((aw)localView).aVt) {
        i = 1;
      }
      do
      {
        if (i != 0) {
          super.dispatchDraw(paramCanvas);
        }
        AppMethodBeat.o(206828);
        return;
        i = j;
      } while (k >= m);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206813);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(206813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.y
 * JD-Core Version:    0.7.0.1
 */