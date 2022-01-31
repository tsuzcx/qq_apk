package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

final class q
{
  private static final int[] nh = { 16843848 };
  
  static void a(View paramView, AttributeSet paramAttributeSet)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, nh, 0, 2131493834);
    try
    {
      if (paramAttributeSet.hasValue(0)) {
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, paramAttributeSet.getResourceId(0, 0)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  static void c(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(2131623939);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766, 2130772104, -2130772103 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
  
  static void v(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.q
 * JD-Core Version:    0.7.0.1
 */