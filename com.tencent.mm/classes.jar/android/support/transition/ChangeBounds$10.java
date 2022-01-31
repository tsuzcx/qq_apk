package android.support.transition;

import android.view.ViewGroup;

final class ChangeBounds$10
  extends ae
{
  boolean pP = false;
  
  ChangeBounds$10(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup) {}
  
  public final void a(Transition paramTransition)
  {
    if (!this.pP) {
      ao.c(this.pQ, false);
    }
    paramTransition.b(this);
  }
  
  public final void bq()
  {
    ao.c(this.pQ, false);
  }
  
  public final void br()
  {
    ao.c(this.pQ, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.ChangeBounds.10
 * JD-Core Version:    0.7.0.1
 */