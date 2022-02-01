package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class Fade
  extends Visibility
{
  public Fade() {}
  
  public Fade(int paramInt)
  {
    setMode(paramInt);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BV);
    setMode(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, this.mMode));
    paramContext.recycle();
  }
  
  private static float a(v paramv, float paramFloat)
  {
    float f = paramFloat;
    if (paramv != null)
    {
      paramv = (Float)paramv.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramv != null) {
        f = paramv.floatValue();
      }
    }
    return f;
  }
  
  private Animator b(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    ah.d(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ah.DL, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new a(paramView));
    a(new r()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        ah.d(paramView, 1.0F);
        ah.R(paramView);
        paramAnonymousTransition.b(this);
      }
    });
    return localObjectAnimator;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, v paramv)
  {
    ah.Q(paramView);
    return b(paramView, a(paramv, 1.0F), 0.0F);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, v paramv1, v paramv2)
  {
    float f1 = 0.0F;
    float f2 = a(paramv1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      return b(paramView, f1, 1.0F);
      f1 = f2;
    }
  }
  
  public final void a(v paramv)
  {
    super.a(paramv);
    paramv.values.put("android:fade:transitionAlpha", Float.valueOf(ah.P(paramv.view)));
  }
  
  static final class a
    extends AnimatorListenerAdapter
  {
    private boolean AU = false;
    private final View mView;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      ah.d(this.mView, 1.0F);
      if (this.AU) {
        this.mView.setLayerType(0, null);
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      if ((u.ar(this.mView)) && (this.mView.getLayerType() == 0))
      {
        this.AU = true;
        this.mView.setLayerType(2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Fade
 * JD-Core Version:    0.7.0.1
 */