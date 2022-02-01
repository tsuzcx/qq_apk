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
  private static final int[] dpa = { 16843848 };
  
  static void a(View paramView, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(210024);
    Context localContext = paramView.getContext();
    paramAttributeSet = k.a(localContext, paramAttributeSet, dpa, 0, paramInt, new int[0]);
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
      AppMethodBeat.o(210024);
    }
  }
  
  static void cy(View paramView)
  {
    AppMethodBeat.i(210020);
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    AppMethodBeat.o(210020);
  }
  
  static void q(View paramView, float paramFloat)
  {
    AppMethodBeat.i(210033);
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
    AppMethodBeat.o(210033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.b
 * JD-Core Version:    0.7.0.1
 */