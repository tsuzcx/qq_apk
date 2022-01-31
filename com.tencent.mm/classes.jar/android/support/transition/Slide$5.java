package android.support.transition;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;

final class Slide$5
  extends Slide.b
{
  Slide$5()
  {
    super((byte)0);
  }
  
  public final float b(ViewGroup paramViewGroup, View paramView)
  {
    int i = 1;
    if (q.Q(paramViewGroup) == 1) {}
    while (i != 0)
    {
      return paramView.getTranslationX() - paramViewGroup.getWidth();
      i = 0;
    }
    return paramView.getTranslationX() + paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Slide.5
 * JD-Core Version:    0.7.0.1
 */