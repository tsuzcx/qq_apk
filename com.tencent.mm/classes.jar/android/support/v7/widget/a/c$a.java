package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.q;
import android.support.v7.e.a.b;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class c$a
  extends c.b
{
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    float f3;
    float f1;
    int i;
    if ((paramBoolean) && (paramView.getTag(a.b.item_touch_helper_previous_elevation) == null))
    {
      f3 = q.Z(paramView);
      int j = paramRecyclerView.getChildCount();
      f1 = 0.0F;
      i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (localView == paramView) {
          break label118;
        }
        float f2 = q.Z(localView);
        if (f2 <= f1) {
          break label118;
        }
        f1 = f2;
      }
    }
    label118:
    for (;;)
    {
      i += 1;
      break;
      q.h(paramView, 1.0F + f1);
      paramView.setTag(a.b.item_touch_helper_previous_elevation, Float.valueOf(f3));
      super.a(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
  }
  
  public final void bI(View paramView)
  {
    Object localObject = paramView.getTag(a.b.item_touch_helper_previous_elevation);
    if ((localObject != null) && ((localObject instanceof Float))) {
      q.h(paramView, ((Float)localObject).floatValue());
    }
    paramView.setTag(a.b.item_touch_helper_previous_elevation, null);
    super.bI(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.a.c.a
 * JD-Core Version:    0.7.0.1
 */