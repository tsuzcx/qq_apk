package android.support.transition;

final class TransitionSet$a
  extends ae
{
  TransitionSet sJ;
  
  TransitionSet$a(TransitionSet paramTransitionSet)
  {
    this.sJ = paramTransitionSet;
  }
  
  public final void a(Transition paramTransition)
  {
    TransitionSet.b(this.sJ);
    if (TransitionSet.c(this.sJ) == 0)
    {
      TransitionSet.a(this.sJ, false);
      this.sJ.end();
    }
    paramTransition.b(this);
  }
  
  public final void bv()
  {
    if (!TransitionSet.a(this.sJ))
    {
      this.sJ.start();
      TransitionSet.a(this.sJ, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.TransitionSet.a
 * JD-Core Version:    0.7.0.1
 */