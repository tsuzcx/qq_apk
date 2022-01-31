package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class k
{
  private static final j.a rY = new h.a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      rY = new i.a();
      return;
    }
  }
  
  static void A(View paramView)
  {
    rY.A(paramView);
  }
  
  static j a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    return rY.a(paramView, paramViewGroup, paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.k
 * JD-Core Version:    0.7.0.1
 */