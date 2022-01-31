package android.support.design.widget;

import android.support.v4.view.t;
import android.widget.OverScroller;

final class HeaderBehavior$a
  implements Runnable
{
  private final CoordinatorLayout jT;
  private final V jU;
  
  HeaderBehavior$a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    this.jT = paramV;
    Object localObject;
    this.jU = localObject;
  }
  
  public final void run()
  {
    if ((this.jU != null) && (this.jV.jR != null))
    {
      if (this.jV.jR.computeScrollOffset())
      {
        this.jV.c(this.jT, this.jU, this.jV.jR.getCurrY());
        t.b(this.jU, this);
      }
    }
    else {
      return;
    }
    this.jV.a(this.jT, this.jU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior.a
 * JD-Core Version:    0.7.0.1
 */