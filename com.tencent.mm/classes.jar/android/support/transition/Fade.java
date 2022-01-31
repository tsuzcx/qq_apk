package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.c;
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rG);
    setMode(c.a(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, this.mMode));
    paramContext.recycle();
  }
  
  private static float a(ai paramai, float paramFloat)
  {
    float f = paramFloat;
    if (paramai != null)
    {
      paramai = (Float)paramai.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramai != null) {
        f = paramai.floatValue();
      }
    }
    return f;
  }
  
  private Animator b(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    av.c(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, av.tv, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new Fade.a(paramView));
    a(new Fade.1(this, paramView));
    return localObjectAnimator;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ai paramai)
  {
    av.I(paramView);
    return b(paramView, a(paramai, 1.0F), 0.0F);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ai paramai1, ai paramai2)
  {
    float f1 = 0.0F;
    float f2 = a(paramai1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      return b(paramView, f1, 1.0F);
      f1 = f2;
    }
  }
  
  public final void a(ai paramai)
  {
    super.a(paramai);
    paramai.values.put("android:fade:transitionAlpha", Float.valueOf(av.H(paramai.view)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Fade
 * JD-Core Version:    0.7.0.1
 */