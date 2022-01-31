package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$1
  extends Slide.b
{
  Slide$1()
  {
    super((byte)0);
  }
  
  public final float b(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationX() - paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.Slide.1
 * JD-Core Version:    0.7.0.1
 */