package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$3
  extends Slide.c
{
  Slide$3()
  {
    super((byte)0);
  }
  
  public final float c(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationY() - paramViewGroup.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.Slide.3
 * JD-Core Version:    0.7.0.1
 */