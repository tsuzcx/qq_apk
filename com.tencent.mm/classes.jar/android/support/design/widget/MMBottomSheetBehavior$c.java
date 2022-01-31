package android.support.design.widget;

import android.view.View;

final class MMBottomSheetBehavior$c
  implements Runnable
{
  private final int gD;
  private final View mView;
  
  MMBottomSheetBehavior$c(MMBottomSheetBehavior paramMMBottomSheetBehavior, View paramView, int paramInt)
  {
    this.mView = paramView;
    this.gD = paramInt;
  }
  
  public final void run()
  {
    if ((this.kg.gq != null) && (this.kg.gq.ep()))
    {
      android.support.v4.view.t.b(this.mView, this);
      return;
    }
    this.kg.u(this.gD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior.c
 * JD-Core Version:    0.7.0.1
 */