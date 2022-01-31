package android.support.transition;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;

final class Slide$2
  extends Slide.b
{
  Slide$2()
  {
    super((byte)0);
  }
  
  public final float b(ViewGroup paramViewGroup, View paramView)
  {
    int i = 1;
    if (t.T(paramViewGroup) == 1) {}
    while (i != 0)
    {
      return paramView.getTranslationX() + paramViewGroup.getWidth();
      i = 0;
    }
    return paramView.getTranslationX() - paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.Slide.2
 * JD-Core Version:    0.7.0.1
 */