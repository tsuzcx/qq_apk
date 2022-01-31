package android.support.design.widget;

import android.support.v4.view.q;
import android.support.v4.widget.r;
import android.view.View;

final class n$b
  implements Runnable
{
  private final boolean kb;
  private final View mView;
  
  n$b(n paramn, View paramView, boolean paramBoolean)
  {
    this.mView = paramView;
    this.kb = paramBoolean;
  }
  
  public final void run()
  {
    if ((this.ka.ft != null) && (this.ka.ft.dW())) {
      q.b(this.mView, this);
    }
    while ((!this.kb) || (this.ka.jR == null)) {
      return;
    }
    this.ka.jR.onDismiss(this.mView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.n.b
 * JD-Core Version:    0.7.0.1
 */