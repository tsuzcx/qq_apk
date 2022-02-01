package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    init();
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    ao(1);
    c(new Fade(2)).c(new ChangeBounds()).c(new Fade(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.AutoTransition
 * JD-Core Version:    0.7.0.1
 */