package android.support.transition;

import android.view.ViewGroup;

final class ChangeBounds$10
  extends ad
{
  boolean qM = false;
  
  ChangeBounds$10(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup) {}
  
  public final void a(Transition paramTransition)
  {
    if (!this.qM) {
      an.c(this.qN, false);
    }
    paramTransition.b(this);
  }
  
  public final void ce()
  {
    an.c(this.qN, false);
  }
  
  public final void cf()
  {
    an.c(this.qN, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.ChangeBounds.10
 * JD-Core Version:    0.7.0.1
 */