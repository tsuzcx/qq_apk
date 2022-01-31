package android.support.design.widget;

import android.view.View;

final class SwipeDismissBehavior$b
  implements Runnable
{
  private final boolean kZ;
  private final View mView;
  
  SwipeDismissBehavior$b(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    this.mView = paramView;
    this.kZ = paramBoolean;
  }
  
  public final void run()
  {
    if ((this.kY.gq != null) && (this.kY.gq.ep())) {
      android.support.v4.view.t.b(this.mView, this);
    }
    while ((!this.kZ) || (this.kY.kP == null)) {
      return;
    }
    this.kY.kP.onDismiss(this.mView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior.b
 * JD-Core Version:    0.7.0.1
 */