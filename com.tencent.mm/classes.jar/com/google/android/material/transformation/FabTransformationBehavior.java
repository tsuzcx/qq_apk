package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.g.z;
import com.google.android.material.a.f;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.a.1;
import com.google.android.material.circularreveal.c.c;
import com.google.android.material.circularreveal.c.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  private final int[] dAw = new int[2];
  private final RectF dtX = new RectF();
  private final RectF dtY = new RectF();
  private final Rect tmpRect = new Rect();
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.dtX;
    RectF localRectF2 = this.dtY;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f2 = 0.0F;
    float f1 = f2;
    switch (paramj.fl & 0x7)
    {
    default: 
      f1 = f2;
    }
    for (;;)
    {
      return f1 + paramj.dnE;
      f1 = localRectF2.left - localRectF1.left;
      continue;
      f1 = localRectF2.centerX() - localRectF1.centerX();
      continue;
      f1 = localRectF2.right - localRectF1.right;
    }
  }
  
  private static float a(a parama, i parami, float paramFloat)
  {
    long l1 = parami.delay;
    long l2 = parami.duration;
    parama = parama.dAC.dx("expansion");
    long l3 = parama.delay;
    float f = (float)(parama.duration + l3 + 17L - l1) / (float)l2;
    return com.google.android.material.a.a.lerp(paramFloat, 0.0F, parami.LS().getInterpolation(f));
  }
  
  private static void a(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramLong > 0L))
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      paramView.setStartDelay(0L);
      paramView.setDuration(paramLong);
      paramList.add(paramView);
    }
  }
  
  private void a(View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.dAw;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private float b(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.dtX;
    RectF localRectF2 = this.dtY;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f = 0.0F;
    switch (paramj.fl & 0x70)
    {
    }
    for (;;)
    {
      return f + paramj.dnF;
      f = localRectF2.top - localRectF1.top;
      continue;
      f = localRectF2.centerY() - localRectF1.centerY();
      continue;
      f = localRectF2.bottom - localRectF1.bottom;
    }
  }
  
  private static ViewGroup cH(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  public final void a(CoordinatorLayout.d paramd)
  {
    if (paramd.bnw == 0) {
      paramd.bnw = 80;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    boolean bool2 = false;
    if (paramView1.getVisibility() == 8) {
      throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }
    boolean bool1 = bool2;
    if ((paramView2 instanceof FloatingActionButton))
    {
      int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
      if (i != 0)
      {
        bool1 = bool2;
        if (i != paramView1.getId()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected final AnimatorSet b(final View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = j(paramView2.getContext(), paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    float f1;
    float f2;
    Object localObject2;
    label177:
    Object localObject4;
    Object localObject3;
    label326:
    float f4;
    label388:
    float f3;
    label605:
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      f1 = z.ag(paramView2) - z.ag(paramView1);
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          paramView2.setTranslationZ(-f1);
        }
        localObject1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
        locala.dAC.dx("elevation").b((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
    }
    else
    {
      RectF localRectF1 = this.dtX;
      f2 = a(paramView1, paramView2, locala.dAD);
      f1 = b(paramView1, paramView2, locala.dAD);
      if ((f2 != 0.0F) && (f1 != 0.0F)) {
        break label1017;
      }
      localObject2 = locala.dAC.dx("translationXLinear");
      localObject1 = locala.dAC.dx("translationYLinear");
      if (!paramBoolean1) {
        break label1097;
      }
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f2);
        paramView2.setTranslationY(-f1);
      }
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      localObject3 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      f2 = -f2;
      f1 = -f1;
      f2 = a(locala, (i)localObject2, f2);
      f1 = a(locala, (i)localObject1, f1);
      Object localObject5 = this.tmpRect;
      paramView2.getWindowVisibleDisplayFrame((Rect)localObject5);
      RectF localRectF2 = this.dtX;
      localRectF2.set((Rect)localObject5);
      localObject5 = this.dtY;
      a(paramView2, (RectF)localObject5);
      ((RectF)localObject5).offset(f2, f1);
      ((RectF)localObject5).intersect(localRectF2);
      localRectF1.set((RectF)localObject5);
      ((i)localObject2).b((Animator)localObject4);
      ((i)localObject1).b((Animator)localObject3);
      localArrayList1.add(localObject4);
      localArrayList1.add(localObject3);
      f4 = localRectF1.width();
      float f5 = localRectF1.height();
      if (((paramView2 instanceof com.google.android.material.circularreveal.c)) && ((paramView1 instanceof ImageView))) {
        break label1136;
      }
      if ((paramView2 instanceof com.google.android.material.circularreveal.c))
      {
        localObject2 = (com.google.android.material.circularreveal.c)paramView2;
        localObject1 = locala.dAD;
        localObject3 = this.dtX;
        localObject4 = this.dtY;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(-a(paramView1, paramView2, (j)localObject1), 0.0F);
        f2 = ((RectF)localObject3).centerX() - ((RectF)localObject4).left;
        localObject1 = locala.dAD;
        localObject3 = this.dtX;
        localObject4 = this.dtY;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(0.0F, -b(paramView1, paramView2, (j)localObject1));
        f3 = ((RectF)localObject3).centerY() - ((RectF)localObject4).top;
        ((FloatingActionButton)paramView1).o(this.tmpRect);
        f1 = this.tmpRect.width() / 2.0F;
        localObject3 = locala.dAC.dx("expansion");
        if (!paramBoolean1) {
          break label1284;
        }
        if (!paramBoolean2) {
          ((com.google.android.material.circularreveal.c)localObject2).setRevealInfo(new c.d(f2, f3, f1));
        }
        if (!paramBoolean2) {
          break label1281;
        }
        f1 = ((com.google.android.material.circularreveal.c)localObject2).getRevealInfo().radius;
        localObject1 = com.google.android.material.circularreveal.a.a((com.google.android.material.circularreveal.c)localObject2, f2, f3, com.google.android.material.d.a.l(f2, f3, f4, f5));
        ((Animator)localObject1).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(209988);
            paramAnonymousAnimator = this.dAA.getRevealInfo();
            paramAnonymousAnimator.radius = 3.4028235E+38F;
            this.dAA.setRevealInfo(paramAnonymousAnimator);
            AppMethodBeat.o(209988);
          }
        });
        a(paramView2, ((i)localObject3).delay, (int)f2, (int)f3, f1, localArrayList1);
        label661:
        ((i)localObject3).b((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new a.1((com.google.android.material.circularreveal.c)localObject2));
      }
      if ((paramView2 instanceof com.google.android.material.circularreveal.c))
      {
        localObject1 = (com.google.android.material.circularreveal.c)paramView2;
        localObject2 = z.ap(paramView1);
        if (localObject2 == null) {
          break label1432;
        }
        i = ((ColorStateList)localObject2).getColorForState(paramView1.getDrawableState(), ((ColorStateList)localObject2).getDefaultColor());
        label735:
        if (!paramBoolean1) {
          break label1438;
        }
        if (!paramBoolean2) {
          ((com.google.android.material.circularreveal.c)localObject1).setCircularRevealScrimColor(i);
        }
        localObject1 = ObjectAnimator.ofInt(localObject1, c.c.dti, new int[] { 0xFFFFFF & i });
        label775:
        ((ObjectAnimator)localObject1).setEvaluator(com.google.android.material.a.c.Vr());
        locala.dAC.dx("color").b((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
      if (((paramView2 instanceof ViewGroup)) && ((!(paramView2 instanceof com.google.android.material.circularreveal.c)) || (com.google.android.material.circularreveal.b.dsX != 0)))
      {
        localObject1 = paramView2.findViewById(a.f.mtrl_child_content_container);
        if (localObject1 == null) {
          break label1459;
        }
        localObject1 = cH((View)localObject1);
        label850:
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label1498;
          }
          if (!paramBoolean2) {
            d.dnw.set(localObject1, Float.valueOf(0.0F));
          }
        }
      }
    }
    label1097:
    label1498:
    for (Object localObject1 = ObjectAnimator.ofFloat(localObject1, d.dnw, new float[] { 1.0F });; localObject1 = ObjectAnimator.ofFloat(localObject1, d.dnw, new float[] { 0.0F }))
    {
      locala.dAC.dx("contentFade").b((Animator)localObject1);
      localArrayList1.add(localObject1);
      localObject1 = new AnimatorSet();
      com.google.android.material.a.b.a((AnimatorSet)localObject1, localArrayList1);
      ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209985);
          if (!paramBoolean1)
          {
            paramView2.setVisibility(4);
            paramView1.setAlpha(1.0F);
            paramView1.setVisibility(0);
          }
          AppMethodBeat.o(209985);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209977);
          if (paramBoolean1)
          {
            paramView2.setVisibility(0);
            paramView1.setAlpha(0.0F);
            paramView1.setVisibility(4);
          }
          AppMethodBeat.o(209977);
        }
      });
      int j = localArrayList2.size();
      i = 0;
      while (i < j)
      {
        ((AnimatorSet)localObject1).addListener((Animator.AnimatorListener)localArrayList2.get(i));
        i += 1;
      }
      localObject1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f1 });
      break;
      label1017:
      if (((paramBoolean1) && (f1 < 0.0F)) || ((!paramBoolean1) && (f1 > 0.0F)))
      {
        localObject2 = locala.dAC.dx("translationXCurveUpwards");
        localObject1 = locala.dAC.dx("translationYCurveUpwards");
        break label177;
      }
      localObject2 = locala.dAC.dx("translationXCurveDownwards");
      localObject1 = locala.dAC.dx("translationYCurveDownwards");
      break label177;
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f2 });
      localObject3 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f1 });
      break label326;
      label1136:
      localObject2 = (com.google.android.material.circularreveal.c)paramView2;
      localObject3 = ((ImageView)paramView1).getDrawable();
      if (localObject3 == null) {
        break label388;
      }
      ((Drawable)localObject3).mutate();
      if (paramBoolean1) {
        if (!paramBoolean2) {
          ((Drawable)localObject3).setAlpha(255);
        }
      }
      for (localObject1 = ObjectAnimator.ofInt(localObject3, e.dnx, new int[] { 0 });; localObject1 = ObjectAnimator.ofInt(localObject3, e.dnx, new int[] { 255 }))
      {
        ((ObjectAnimator)localObject1).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(209980);
            paramView2.invalidate();
            AppMethodBeat.o(209980);
          }
        });
        locala.dAC.dx("iconFade").b((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(210005);
            this.dAA.setCircularRevealOverlayDrawable(null);
            AppMethodBeat.o(210005);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(209993);
            this.dAA.setCircularRevealOverlayDrawable(this.dAB);
            AppMethodBeat.o(209993);
          }
        });
        break;
      }
      break label605;
      f4 = ((com.google.android.material.circularreveal.c)localObject2).getRevealInfo().radius;
      localObject1 = com.google.android.material.circularreveal.a.a((com.google.android.material.circularreveal.c)localObject2, f2, f3, f1);
      a(paramView2, ((i)localObject3).delay, (int)f2, (int)f3, f4, localArrayList1);
      long l1 = ((i)localObject3).delay;
      long l2 = ((i)localObject3).duration;
      long l3 = locala.dAC.getTotalDuration();
      i = (int)f2;
      j = (int)f3;
      if ((Build.VERSION.SDK_INT >= 21) && (l1 + l2 < l3))
      {
        localObject4 = ViewAnimationUtils.createCircularReveal(paramView2, i, j, f1, f1);
        ((Animator)localObject4).setStartDelay(l1 + l2);
        ((Animator)localObject4).setDuration(l3 - (l1 + l2));
        localArrayList1.add(localObject4);
      }
      break label661;
      i = 0;
      break label735;
      localObject1 = ObjectAnimator.ofInt(localObject1, c.c.dti, new int[] { i });
      break label775;
      if (((paramView2 instanceof TransformationChildLayout)) || ((paramView2 instanceof TransformationChildCard)))
      {
        localObject1 = cH(((ViewGroup)paramView2).getChildAt(0));
        break label850;
      }
      localObject1 = cH(paramView2);
      break label850;
    }
    label1281:
    label1284:
    label1432:
    label1438:
    label1459:
    return localObject1;
  }
  
  protected abstract a j(Context paramContext, boolean paramBoolean);
  
  protected static final class a
  {
    public h dAC;
    public j dAD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */