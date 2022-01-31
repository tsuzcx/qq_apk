package android.support.design.widget;

import android.view.View;

final class b$5
  implements n.a
{
  b$5(b paramb) {}
  
  public final void onDismiss(View paramView)
  {
    paramView.setVisibility(8);
    ??? = this.eX;
    paramView = l.aT();
    l.a locala = ((b)???).eW;
    synchronized (paramView.mLock)
    {
      if (paramView.d(locala)) {
        paramView.a(paramView.jF);
      }
      while (!paramView.e(locala)) {
        return;
      }
      paramView.a(paramView.jG);
    }
  }
  
  public final void s(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      l.aT().a(this.eX.eW);
      return;
    }
    l.aT().b(this.eX.eW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.b.5
 * JD-Core Version:    0.7.0.1
 */