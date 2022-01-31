package android.support.design.widget;

import android.support.v4.view.q;
import android.support.v4.widget.r;
import android.view.View;

final class BottomSheetBehavior$b
  implements Runnable
{
  private final int fJ;
  private final View mView;
  
  BottomSheetBehavior$b(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    this.mView = paramView;
    this.fJ = paramInt;
  }
  
  public final void run()
  {
    if ((this.fI.ft != null) && (this.fI.ft.dW()))
    {
      q.b(this.mView, this);
      return;
    }
    this.fI.v(this.fJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.b
 * JD-Core Version:    0.7.0.1
 */