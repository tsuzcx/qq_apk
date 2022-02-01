package android.support.design.transformation;

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
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.circularreveal.a.1;
import android.support.design.circularreveal.c.c;
import android.support.design.circularreveal.c.d;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.k;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  private final Rect jL = new Rect();
  private final RectF jM = new RectF();
  private final RectF jN = new RectF();
  private final int[] jO = new int[2];
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static float a(a parama, i parami, float paramFloat)
  {
    long l1 = parami.ed;
    long l2 = parami.duration;
    parama = parama.jU.j("expansion");
    long l3 = parama.ed;
    float f = (float)(parama.duration + l3 + 17L - l1) / (float)l2;
    return android.support.design.a.a.lerp(paramFloat, 0.0F, parami.getInterpolator().getInterpolation(f));
  }
  
  private float a(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.jM;
    RectF localRectF2 = this.jN;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f2 = 0.0F;
    float f1 = f2;
    switch (paramj.gravity & 0x7)
    {
    default: 
      f1 = f2;
    }
    for (;;)
    {
      return f1 + paramj.ef;
      f1 = localRectF2.left - localRectF1.left;
      continue;
      f1 = localRectF2.centerX() - localRectF1.centerX();
      continue;
      f1 = localRectF2.right - localRectF1.right;
    }
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
    int[] arrayOfInt = this.jO;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private float b(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.jM;
    RectF localRectF2 = this.jN;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    float f = 0.0F;
    switch (paramj.gravity & 0x70)
    {
    }
    for (;;)
    {
      return f + paramj.eg;
      f = localRectF2.top - localRectF1.top;
      continue;
      f = localRectF2.centerY() - localRectF1.centerY();
      continue;
      f = localRectF2.bottom - localRectF1.bottom;
    }
  }
  
  private static ViewGroup e(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  public final void a(CoordinatorLayout.d paramd)
  {
    if (paramd.nL == 0) {
      paramd.nL = 80;
    }
  }
  
  public final boolean a(View paramView1, View paramView2)
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
    a locala = h(paramView2.getContext(), paramBoolean1);
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
      f1 = t.al(paramView2) - t.al(paramView1);
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          paramView2.setTranslationZ(-f1);
        }
        localObject1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
        locala.jU.j("elevation").a((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
    }
    else
    {
      RectF localRectF1 = this.jM;
      f2 = a(paramView1, paramView2, locala.jV);
      f1 = b(paramView1, paramView2, locala.jV);
      if ((f2 != 0.0F) && (f1 != 0.0F)) {
        break label1017;
      }
      localObject2 = locala.jU.j("translationXLinear");
      localObject1 = locala.jU.j("translationYLinear");
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
      Object localObject5 = this.jL;
      paramView2.getWindowVisibleDisplayFrame((Rect)localObject5);
      RectF localRectF2 = this.jM;
      localRectF2.set((Rect)localObject5);
      localObject5 = this.jN;
      a(paramView2, (RectF)localObject5);
      ((RectF)localObject5).offset(f2, f1);
      ((RectF)localObject5).intersect(localRectF2);
      localRectF1.set((RectF)localObject5);
      ((i)localObject2).a((Animator)localObject4);
      ((i)localObject1).a((Animator)localObject3);
      localArrayList1.add(localObject4);
      localArrayList1.add(localObject3);
      f4 = localRectF1.width();
      float f5 = localRectF1.height();
      if (((paramView2 instanceof android.support.design.circularreveal.c)) && ((paramView1 instanceof ImageView))) {
        break label1136;
      }
      if ((paramView2 instanceof android.support.design.circularreveal.c))
      {
        localObject2 = (android.support.design.circularreveal.c)paramView2;
        localObject1 = locala.jV;
        localObject3 = this.jM;
        localObject4 = this.jN;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(-a(paramView1, paramView2, (j)localObject1), 0.0F);
        f2 = ((RectF)localObject3).centerX() - ((RectF)localObject4).left;
        localObject1 = locala.jV;
        localObject3 = this.jM;
        localObject4 = this.jN;
        a(paramView1, (RectF)localObject3);
        a(paramView2, (RectF)localObject4);
        ((RectF)localObject4).offset(0.0F, -b(paramView1, paramView2, (j)localObject1));
        f3 = ((RectF)localObject3).centerY() - ((RectF)localObject4).top;
        ((FloatingActionButton)paramView1).b(this.jL);
        f1 = this.jL.width() / 2.0F;
        localObject3 = locala.jU.j("expansion");
        if (!paramBoolean1) {
          break label1284;
        }
        if (!paramBoolean2) {
          ((android.support.design.circularreveal.c)localObject2).setRevealInfo(new c.d(f2, f3, f1));
        }
        if (!paramBoolean2) {
          break label1281;
        }
        f1 = ((android.support.design.circularreveal.c)localObject2).getRevealInfo().radius;
        localObject1 = android.support.design.circularreveal.a.a((android.support.design.circularreveal.c)localObject2, f2, f3, k.c(f2, f3, f4, f5));
        ((Animator)localObject1).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator = this.jS.getRevealInfo();
            paramAnonymousAnimator.radius = 3.4028235E+38F;
            this.jS.setRevealInfo(paramAnonymousAnimator);
          }
        });
        a(paramView2, ((i)localObject3).ed, (int)f2, (int)f3, f1, localArrayList1);
        label661:
        ((i)localObject3).a((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new a.1((android.support.design.circularreveal.c)localObject2));
      }
      if ((paramView2 instanceof android.support.design.circularreveal.c))
      {
        localObject1 = (android.support.design.circularreveal.c)paramView2;
        localObject2 = t.at(paramView1);
        if (localObject2 == null) {
          break label1432;
        }
        i = ((ColorStateList)localObject2).getColorForState(paramView1.getDrawableState(), ((ColorStateList)localObject2).getDefaultColor());
        label735:
        if (!paramBoolean1) {
          break label1438;
        }
        if (!paramBoolean2) {
          ((android.support.design.circularreveal.c)localObject1).setCircularRevealScrimColor(i);
        }
        localObject1 = ObjectAnimator.ofInt(localObject1, c.c.gV, new int[] { 0xFFFFFF & i });
        label775:
        ((ObjectAnimator)localObject1).setEvaluator(android.support.design.a.c.au());
        locala.jU.j("color").a((Animator)localObject1);
        localArrayList1.add(localObject1);
      }
      if (((paramView2 instanceof ViewGroup)) && ((!(paramView2 instanceof android.support.design.circularreveal.c)) || (android.support.design.circularreveal.b.gK != 0)))
      {
        localObject1 = paramView2.findViewById(2131302557);
        if (localObject1 == null) {
          break label1459;
        }
        localObject1 = e((View)localObject1);
        label850:
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label1498;
          }
          if (!paramBoolean2) {
            d.dV.set(localObject1, Float.valueOf(0.0F));
          }
        }
      }
    }
    label1097:
    label1498:
    for (Object localObject1 = ObjectAnimator.ofFloat(localObject1, d.dV, new float[] { 1.0F });; localObject1 = ObjectAnimator.ofFloat(localObject1, d.dV, new float[] { 0.0F }))
    {
      locala.jU.j("contentFade").a((Animator)localObject1);
      localArrayList1.add(localObject1);
      localObject1 = new AnimatorSet();
      android.support.design.a.b.a((AnimatorSet)localObject1, localArrayList1);
      ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!paramBoolean1)
          {
            paramView2.setVisibility(4);
            paramView1.setAlpha(1.0F);
            paramView1.setVisibility(0);
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramBoolean1)
          {
            paramView2.setVisibility(0);
            paramView1.setAlpha(0.0F);
            paramView1.setVisibility(4);
          }
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
        localObject2 = locala.jU.j("translationXCurveUpwards");
        localObject1 = locala.jU.j("translationYCurveUpwards");
        break label177;
      }
      localObject2 = locala.jU.j("translationXCurveDownwards");
      localObject1 = locala.jU.j("translationYCurveDownwards");
      break label177;
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f2 });
      localObject3 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f1 });
      break label326;
      label1136:
      localObject2 = (android.support.design.circularreveal.c)paramView2;
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
      for (localObject1 = ObjectAnimator.ofInt(localObject3, e.dW, new int[] { 0 });; localObject1 = ObjectAnimator.ofInt(localObject3, e.dW, new int[] { 255 }))
      {
        ((ObjectAnimator)localObject1).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramView2.invalidate();
          }
        });
        locala.jU.j("iconFade").a((Animator)localObject1);
        localArrayList1.add(localObject1);
        localArrayList2.add(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            this.jS.setCircularRevealOverlayDrawable(null);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            this.jS.setCircularRevealOverlayDrawable(this.jT);
          }
        });
        break;
      }
      break label605;
      f4 = ((android.support.design.circularreveal.c)localObject2).getRevealInfo().radius;
      localObject1 = android.support.design.circularreveal.a.a((android.support.design.circularreveal.c)localObject2, f2, f3, f1);
      a(paramView2, ((i)localObject3).ed, (int)f2, (int)f3, f4, localArrayList1);
      long l1 = ((i)localObject3).ed;
      long l2 = ((i)localObject3).duration;
      long l3 = locala.jU.getTotalDuration();
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
      localObject1 = ObjectAnimator.ofInt(localObject1, c.c.gV, new int[] { i });
      break label775;
      if (((paramView2 instanceof TransformationChildLayout)) || ((paramView2 instanceof TransformationChildCard)))
      {
        localObject1 = e(((ViewGroup)paramView2).getChildAt(0));
        break label850;
      }
      localObject1 = e(paramView2);
      break label850;
    }
    label1281:
    label1284:
    label1432:
    label1438:
    label1459:
    return localObject1;
  }
  
  protected abstract a h(Context paramContext, boolean paramBoolean);
  
  protected static final class a
  {
    public h jU;
    public j jV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */