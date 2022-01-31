package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class k
{
  private static final j.a rb = new h.a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      rb = new i.a();
      return;
    }
  }
  
  static j a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    return rb.a(paramView, paramViewGroup, paramMatrix);
  }
  
  static void x(View paramView)
  {
    rb.x(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */