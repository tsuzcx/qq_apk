package android.support.design.internal;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ab;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.view.View;
import android.view.WindowInsets;

final class ScrimInsetsFrameLayout$1
  implements p
{
  ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout paramScrimInsetsFrameLayout) {}
  
  public final ab a(View paramView, ab paramab)
  {
    if (this.fb.fa == null) {
      this.fb.fa = new Rect();
    }
    this.fb.fa.set(paramab.getSystemWindowInsetLeft(), paramab.getSystemWindowInsetTop(), paramab.getSystemWindowInsetRight(), paramab.getSystemWindowInsetBottom());
    this.fb.a(paramab);
    paramView = this.fb;
    if (Build.VERSION.SDK_INT >= 20)
    {
      bool = ((WindowInsets)paramab.Hp).hasSystemWindowInsets();
      if ((bool) && (this.fb.eZ != null)) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      paramView.setWillNotDraw(bool);
      t.R(this.fb);
      return paramab.dK();
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */