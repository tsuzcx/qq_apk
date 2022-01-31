package android.support.design.widget;

import android.view.View;

final class b$5
  implements SwipeDismissBehavior.a
{
  b$5(b paramb) {}
  
  public final void onDismiss(View paramView)
  {
    paramView.setVisibility(8);
    ??? = this.fW;
    paramView = l.bD();
    l.a locala = ((b)???).fV;
    synchronized (paramView.mLock)
    {
      if (paramView.d(locala)) {
        paramView.a(paramView.kD);
      }
      while (!paramView.e(locala)) {
        return;
      }
      paramView.a(paramView.kE);
    }
  }
  
  public final void r(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      l.bD().a(this.fW.fV);
      return;
    }
    l.bD().b(this.fW.fV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.b.5
 * JD-Core Version:    0.7.0.1
 */