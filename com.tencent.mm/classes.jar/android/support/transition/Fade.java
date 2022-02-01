package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.g;
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.zX);
    setMode(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, this.mMode));
    paramContext.recycle();
  }
  
  private static float a(u paramu, float paramFloat)
  {
    float f = paramFloat;
    if (paramu != null)
    {
      paramu = (Float)paramu.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramu != null) {
        f = paramu.floatValue();
      }
    }
    return f;
  }
  
  private Animator b(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    ag.d(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ag.BK, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new Fade.a(paramView));
    a(new q()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        ag.d(paramView, 1.0F);
        ag.Q(paramView);
        paramAnonymousTransition.b(this);
      }
    });
    return localObjectAnimator;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, u paramu)
  {
    ag.P(paramView);
    return b(paramView, a(paramu, 1.0F), 0.0F);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, u paramu1, u paramu2)
  {
    float f1 = 0.0F;
    float f2 = a(paramu1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      return b(paramView, f1, 1.0F);
      f1 = f2;
    }
  }
  
  public final void a(u paramu)
  {
    super.a(paramu);
    paramu.values.put("android:fade:transitionAlpha", Float.valueOf(ag.O(paramu.view)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Fade
 * JD-Core Version:    0.7.0.1
 */