package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.b;
import com.google.android.material.a.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  private final i bHF;
  private final i bHG;
  
  public FabTransformationScrimBehavior()
  {
    AppMethodBeat.i(240761);
    this.bHF = new i(75L);
    this.bHG = new i(0L);
    AppMethodBeat.o(240761);
  }
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(240762);
    this.bHF = new i(75L);
    this.bHG = new i(0L);
    AppMethodBeat.o(240762);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  protected final AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240768);
    ArrayList localArrayList = new ArrayList();
    new ArrayList();
    if (paramBoolean1)
    {
      paramView1 = this.bHF;
      if (!paramBoolean1) {
        break label120;
      }
      if (!paramBoolean2) {
        paramView2.setAlpha(0.0F);
      }
    }
    label120:
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 1.0F });; localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 0.0F }))
    {
      paramView1.b(localObjectAnimator);
      localArrayList.add(localObjectAnimator);
      paramView1 = new AnimatorSet();
      b.a(paramView1, localArrayList);
      paramView1.addListener(new FabTransformationScrimBehavior.1(this, paramBoolean1, paramView2));
      AppMethodBeat.o(240768);
      return paramView1;
      paramView1 = this.bHG;
      break;
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240763);
    boolean bool = super.b(paramCoordinatorLayout, paramView, paramMotionEvent);
    AppMethodBeat.o(240763);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior
 * JD-Core Version:    0.7.0.1
 */