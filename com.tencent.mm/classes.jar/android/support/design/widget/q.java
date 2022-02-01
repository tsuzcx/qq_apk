package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.internal.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

final class q
{
  private static final int[] wI = { 16843848 };
  
  static void B(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
  
  static void a(View paramView, AttributeSet paramAttributeSet)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = f.a(localContext, paramAttributeSet, wI, 0, 2131821681, new int[0]);
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
    int i = paramView.getResources().getInteger(2131361795);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766, 2130969566, -2130969567 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.q
 * JD-Core Version:    0.7.0.1
 */