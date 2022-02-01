package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.a.b;
import com.google.android.material.a.g;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  private static final int[] bvX = { 16843848 };
  
  static void a(View paramView, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(234817);
    Context localContext = paramView.getContext();
    paramAttributeSet = k.a(localContext, paramAttributeSet, bvX, 0, paramInt, new int[0]);
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
      AppMethodBeat.o(234817);
    }
  }
  
  static void cc(View paramView)
  {
    AppMethodBeat.i(234815);
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    AppMethodBeat.o(234815);
  }
  
  static void p(View paramView, float paramFloat)
  {
    AppMethodBeat.i(234819);
    int i = paramView.getResources().getInteger(a.g.app_bar_elevation_anim_duration);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int j = a.b.state_liftable;
    int k = -a.b.state_lifted;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766, j, k }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(i);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
    AppMethodBeat.o(234819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.b
 * JD-Core Version:    0.7.0.1
 */