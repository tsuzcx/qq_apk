package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;

final class b$a
  extends SwipeDismissBehavior<b.e>
{
  b$a(b paramb) {}
  
  private boolean a(CoordinatorLayout paramCoordinatorLayout, b.e parame, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.a(paramCoordinatorLayout, parame, paramMotionEvent);
      if (paramCoordinatorLayout.d(parame, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        l.bD().a(this.fW.fV);
        continue;
        l.bD().b(this.fW.fV);
      }
    }
  }
  
  public final boolean g(View paramView)
  {
    return paramView instanceof b.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.b.a
 * JD-Core Version:    0.7.0.1
 */