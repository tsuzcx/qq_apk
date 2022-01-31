package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.t;
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
    if ((paramBoolean) && (paramView.getTag(2131820632) == null))
    {
      f3 = t.ag(paramView);
      int j = paramRecyclerView.getChildCount();
      f1 = 0.0F;
      i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (localView == paramView) {
          break label116;
        }
        float f2 = t.ag(localView);
        if (f2 <= f1) {
          break label116;
        }
        f1 = f2;
      }
    }
    label116:
    for (;;)
    {
      i += 1;
      break;
      t.i(paramView, 1.0F + f1);
      paramView.setTag(2131820632, Float.valueOf(f3));
      super.a(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
  }
  
  public final void cb(View paramView)
  {
    Object localObject = paramView.getTag(2131820632);
    if ((localObject != null) && ((localObject instanceof Float))) {
      t.i(paramView, ((Float)localObject).floatValue());
    }
    paramView.setTag(2131820632, null);
    super.cb(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.a.c.a
 * JD-Core Version:    0.7.0.1
 */