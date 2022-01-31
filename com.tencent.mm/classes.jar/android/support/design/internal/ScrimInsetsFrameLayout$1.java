package android.support.design.internal;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.m;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.view.View;
import android.view.WindowInsets;

final class ScrimInsetsFrameLayout$1
  implements m
{
  ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout paramScrimInsetsFrameLayout) {}
  
  public final y a(View paramView, y paramy)
  {
    if (this.ed.eb == null) {
      this.ed.eb = new Rect();
    }
    this.ed.eb.set(paramy.getSystemWindowInsetLeft(), paramy.getSystemWindowInsetTop(), paramy.getSystemWindowInsetRight(), paramy.getSystemWindowInsetBottom());
    this.ed.a(paramy);
    paramView = this.ed;
    if (Build.VERSION.SDK_INT >= 20)
    {
      bool = ((WindowInsets)paramy.HI).hasSystemWindowInsets();
      if ((bool) && (this.ed.ea != null)) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      paramView.setWillNotDraw(bool);
      q.O(this.ed);
      return paramy.dv();
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */