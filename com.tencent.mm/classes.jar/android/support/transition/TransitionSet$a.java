package android.support.transition;

final class TransitionSet$a
  extends ad
{
  TransitionSet tL;
  
  TransitionSet$a(TransitionSet paramTransitionSet)
  {
    this.tL = paramTransitionSet;
  }
  
  public final void a(Transition paramTransition)
  {
    TransitionSet.b(this.tL);
    if (TransitionSet.c(this.tL) == 0)
    {
      TransitionSet.a(this.tL, false);
      this.tL.end();
    }
    paramTransition.b(this);
  }
  
  public final void cj()
  {
    if (!TransitionSet.a(this.tL))
    {
      this.tL.start();
      TransitionSet.a(this.tL, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.TransitionSet.a
 * JD-Core Version:    0.7.0.1
 */