package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
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
import androidx.core.g.w;
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
  private final RectF bAV = new RectF();
  private final RectF bAW = new RectF();
  private final int[] bHx = new int[2];
  private final Rect bvn = new Rect();
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.bAV;
    RectF localRectF2 = this.bAW;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f2 = 0.0F;
    float f1 = f2;
    switch (paramj.ek & 0x7)
    {
    default: 
      f1 = f2;
    }
    for (;;)
    {
      return f1 + paramj.buB;
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
    parama = parama.bHD.bX("expansion");
    long l3 = parama.delay;
    float f = (float)(parama.duration + l3 + 17L - l1) / (float)l2;
    return com.google.android.material.a.a.lerp(paramFloat, 0.0F, parami.np().getInterpolation(f));
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
    int[] arrayOfInt = this.bHx;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private float b(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.bAV;
    RectF localRectF2 = this.bAW;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f = 0.0F;
    switch (paramj.ek & 0x70)
    {
    }
    for (;;)
    {
      return f + paramj.buC;
      f = localRectF2.top - localRectF1.top;
      continue;
      f = localRectF2.centerY() - localRectF1.centerY();
      continue;
      f = localRectF2.bottom - localRectF1.bottom;
    }
  }
  
  private static ViewGroup cl(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  public final void a(CoordinatorLayout.d paramd)
  {
    if (paramd.Hv == 0) {
      paramd.Hv = 80;
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
  
  protected final AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = j(paramView2.getContext(), paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    float f1;
    float f2;
    Object localObject2;
    label175:
    Object localObject4;
    Object localObject3;
    label324:
    float f4;
    label386:
    float f3;
    label603:
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      f1 = w.U(paramView2) - w.U(paramView1);
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          paramView2.setTranslationZ(-f1);
        }
        localObject1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
        locala.bHD.bX("elevation").b((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
    }
    else
    {
      RectF localRectF1 = this.bAV;
      f2 = a(paramView1, paramView2, locala.bHE);
      f1 = b(paramView1, paramView2, locala.bHE);
      if ((f2 != 0.0F) && (f1 != 0.0F)) {
        break label1015;
      }
      localObject2 = locala.bHD.bX("translationXLinear");
      localObject1 = locala.bHD.bX("translationYLinear");
      if (!paramBoolean1) {
        break label1095;
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
      Object localObject5 = this.bvn;
      paramView2.getWindowVisibleDisplayFrame((Rect)localObject5);
      RectF localRectF2 = this.bAV;
      localRectF2.set((Rect)localObject5);
      localObject5 = this.bAW;
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
        break label1134;
      }
      if ((paramView2 instanceof com.google.android.material.circularreveal.c))
      {
        localObject2 = (com.google.android.material.circularreveal.c)paramView2;
        localObject1 = locala.bHE;
        localObject3 = this.bAV;
        localObject4 = this.bAW;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(-a(paramView1, paramView2, (j)localObject1), 0.0F);
        f2 = ((RectF)localObject3).centerX() - ((RectF)localObject4).left;
        localObject1 = locala.bHE;
        localObject3 = this.bAV;
        localObject4 = this.bAW;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(0.0F, -b(paramView1, paramView2, (j)localObject1));
        f3 = ((RectF)localObject3).centerY() - ((RectF)localObject4).top;
        ((FloatingActionButton)paramView1).i(this.bvn);
        f1 = this.bvn.width() / 2.0F;
        localObject3 = locala.bHD.bX("expansion");
        if (!paramBoolean1) {
          break label1282;
        }
        if (!paramBoolean2) {
          ((com.google.android.material.circularreveal.c)localObject2).setRevealInfo(new c.d(f2, f3, f1));
        }
        if (!paramBoolean2) {
          break label1279;
        }
        f1 = ((com.google.android.material.circularreveal.c)localObject2).getRevealInfo().radius;
        localObject1 = com.google.android.material.circularreveal.a.a((com.google.android.material.circularreveal.c)localObject2, f2, f3, com.google.android.material.d.a.i(f2, f3, f4, f5));
        ((Animator)localObject1).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(240688);
            paramAnonymousAnimator = this.bHB.getRevealInfo();
            paramAnonymousAnimator.radius = 3.4028235E+38F;
            this.bHB.setRevealInfo(paramAnonymousAnimator);
            AppMethodBeat.o(240688);
          }
        });
        a(paramView2, ((i)localObject3).delay, (int)f2, (int)f3, f1, localArrayList1);
        label659:
        ((i)localObject3).b((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new a.1((com.google.android.material.circularreveal.c)localObject2));
      }
      if ((paramView2 instanceof com.google.android.material.circularreveal.c))
      {
        localObject1 = (com.google.android.material.circularreveal.c)paramView2;
        localObject2 = w.ac(paramView1);
        if (localObject2 == null) {
          break label1430;
        }
        i = ((ColorStateList)localObject2).getColorForState(paramView1.getDrawableState(), ((ColorStateList)localObject2).getDefaultColor());
        label733:
        if (!paramBoolean1) {
          break label1436;
        }
        if (!paramBoolean2) {
          ((com.google.android.material.circularreveal.c)localObject1).setCircularRevealScrimColor(i);
        }
        localObject1 = ObjectAnimator.ofInt(localObject1, c.c.bAh, new int[] { 0xFFFFFF & i });
        label773:
        ((ObjectAnimator)localObject1).setEvaluator(com.google.android.material.a.c.vS());
        locala.bHD.bX("color").b((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
      if (((paramView2 instanceof ViewGroup)) && ((!(paramView2 instanceof com.google.android.material.circularreveal.c)) || (com.google.android.material.circularreveal.b.bzW != 0)))
      {
        localObject1 = paramView2.findViewById(a.f.mtrl_child_content_container);
        if (localObject1 == null) {
          break label1457;
        }
        localObject1 = cl((View)localObject1);
        label848:
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label1496;
          }
          if (!paramBoolean2) {
            d.bus.set(localObject1, Float.valueOf(0.0F));
          }
        }
      }
    }
    label1095:
    label1496:
    for (Object localObject1 = ObjectAnimator.ofFloat(localObject1, d.bus, new float[] { 1.0F });; localObject1 = ObjectAnimator.ofFloat(localObject1, d.bus, new float[] { 0.0F }))
    {
      locala.bHD.bX("contentFade").b((Animator)localObject1);
      localArrayList1.add(localObject1);
      localObject1 = new AnimatorSet();
      com.google.android.material.a.b.a((AnimatorSet)localObject1, localArrayList1);
      ((AnimatorSet)localObject1).addListener(new FabTransformationBehavior.1(this, paramBoolean1, paramView2, paramView1));
      int j = localArrayList2.size();
      i = 0;
      while (i < j)
      {
        ((AnimatorSet)localObject1).addListener((Animator.AnimatorListener)localArrayList2.get(i));
        i += 1;
      }
      localObject1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f1 });
      break;
      label1015:
      if (((paramBoolean1) && (f1 < 0.0F)) || ((!paramBoolean1) && (f1 > 0.0F)))
      {
        localObject2 = locala.bHD.bX("translationXCurveUpwards");
        localObject1 = locala.bHD.bX("translationYCurveUpwards");
        break label175;
      }
      localObject2 = locala.bHD.bX("translationXCurveDownwards");
      localObject1 = locala.bHD.bX("translationYCurveDownwards");
      break label175;
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f2 });
      localObject3 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f1 });
      break label324;
      label1134:
      localObject2 = (com.google.android.material.circularreveal.c)paramView2;
      localObject3 = ((ImageView)paramView1).getDrawable();
      if (localObject3 == null) {
        break label386;
      }
      ((Drawable)localObject3).mutate();
      if (paramBoolean1) {
        if (!paramBoolean2) {
          ((Drawable)localObject3).setAlpha(255);
        }
      }
      for (localObject1 = ObjectAnimator.ofInt(localObject3, e.but, new int[] { 0 });; localObject1 = ObjectAnimator.ofInt(localObject3, e.but, new int[] { 255 }))
      {
        ((ObjectAnimator)localObject1).addUpdateListener(new FabTransformationBehavior.2(this, paramView2));
        locala.bHD.bX("iconFade").b((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(240683);
            this.bHB.setCircularRevealOverlayDrawable(null);
            AppMethodBeat.o(240683);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(240681);
            this.bHB.setCircularRevealOverlayDrawable(this.bHC);
            AppMethodBeat.o(240681);
          }
        });
        break;
      }
      label1279:
      break label603;
      f4 = ((com.google.android.material.circularreveal.c)localObject2).getRevealInfo().radius;
      localObject1 = com.google.android.material.circularreveal.a.a((com.google.android.material.circularreveal.c)localObject2, f2, f3, f1);
      a(paramView2, ((i)localObject3).delay, (int)f2, (int)f3, f4, localArrayList1);
      long l1 = ((i)localObject3).delay;
      long l2 = ((i)localObject3).duration;
      long l3 = locala.bHD.getTotalDuration();
      i = (int)f2;
      j = (int)f3;
      if ((Build.VERSION.SDK_INT >= 21) && (l1 + l2 < l3))
      {
        localObject4 = ViewAnimationUtils.createCircularReveal(paramView2, i, j, f1, f1);
        ((Animator)localObject4).setStartDelay(l1 + l2);
        ((Animator)localObject4).setDuration(l3 - (l1 + l2));
        localArrayList1.add(localObject4);
      }
      break label659;
      i = 0;
      break label733;
      localObject1 = ObjectAnimator.ofInt(localObject1, c.c.bAh, new int[] { i });
      break label773;
      if (((paramView2 instanceof TransformationChildLayout)) || ((paramView2 instanceof TransformationChildCard)))
      {
        localObject1 = cl(((ViewGroup)paramView2).getChildAt(0));
        break label848;
      }
      localObject1 = cl(paramView2);
      break label848;
    }
    label1282:
    label1430:
    label1436:
    label1457:
    return localObject1;
  }
  
  protected abstract a j(Context paramContext, boolean paramBoolean);
  
  protected static final class a
  {
    public h bHD;
    public j bHE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */