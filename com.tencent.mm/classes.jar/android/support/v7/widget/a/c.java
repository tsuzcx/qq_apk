package android.support.v7.widget.a;

import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class c
  implements b
{
  static final b aAU = new c();
  
  public final void a(RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f3;
    float f1;
    int i;
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean) && (paramView.getTag(2131302871) == null))
    {
      f3 = u.al(paramView);
      int j = paramRecyclerView.getChildCount();
      f1 = 0.0F;
      i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (localView == paramView) {
          break label120;
        }
        float f2 = u.al(localView);
        if (f2 <= f1) {
          break label120;
        }
        f1 = f2;
      }
    }
    label120:
    for (;;)
    {
      i += 1;
      break;
      u.l(paramView, 1.0F + f1);
      paramView.setTag(2131302871, Float.valueOf(f3));
      paramView.setTranslationX(paramFloat1);
      paramView.setTranslationY(paramFloat2);
      return;
    }
  }
  
  public final void bU(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramView.getTag(2131302871);
      if ((localObject != null) && ((localObject instanceof Float))) {
        u.l(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(2131302871, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.c
 * JD-Core Version:    0.7.0.1
 */