package android.support.design.widget;

import android.support.v4.view.q;
import android.widget.OverScroller;

final class HeaderBehavior$a
  implements Runnable
{
  private final CoordinatorLayout jc;
  private final V jd;
  
  HeaderBehavior$a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    this.jc = paramV;
    Object localObject;
    this.jd = localObject;
  }
  
  public final void run()
  {
    if ((this.jd != null) && (this.je.iY != null))
    {
      if (this.je.iY.computeScrollOffset())
      {
        this.je.c(this.jc, this.jd, this.je.iY.getCurrY());
        q.b(this.jd, this);
      }
    }
    else {
      return;
    }
    this.je.a(this.jc, this.jd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior.a
 * JD-Core Version:    0.7.0.1
 */