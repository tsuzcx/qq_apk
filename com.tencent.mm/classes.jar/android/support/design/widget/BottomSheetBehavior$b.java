package android.support.design.widget;

import android.view.View;

final class BottomSheetBehavior$b
  implements Runnable
{
  private final int gD;
  private final View mView;
  
  BottomSheetBehavior$b(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    this.mView = paramView;
    this.gD = paramInt;
  }
  
  public final void run()
  {
    if ((this.gC.gq != null) && (this.gC.gq.ep()))
    {
      android.support.v4.view.t.b(this.mView, this);
      return;
    }
    this.gC.u(this.gD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.b
 * JD-Core Version:    0.7.0.1
 */