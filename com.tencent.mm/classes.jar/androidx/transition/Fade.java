package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class Fade
  extends Visibility
{
  public Fade() {}
  
  public Fade(int paramInt)
  {
    AppMethodBeat.i(201284);
    setMode(paramInt);
    AppMethodBeat.o(201284);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201300);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfW);
    setMode(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, getMode()));
    paramContext.recycle();
    AppMethodBeat.o(201300);
  }
  
  private static float a(w paramw, float paramFloat)
  {
    AppMethodBeat.i(201322);
    float f = paramFloat;
    if (paramw != null)
    {
      paramw = (Float)paramw.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramw != null) {
        f = paramw.floatValue();
      }
    }
    AppMethodBeat.o(201322);
    return f;
  }
  
  private Animator d(final View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201312);
    if (paramFloat1 == paramFloat2)
    {
      AppMethodBeat.o(201312);
      return null;
    }
    ai.o(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ai.chM, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new Fade.a(paramView));
    a(new s()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(201385);
        ai.o(paramView, 1.0F);
        ai.ck(paramView);
        paramAnonymousTransition.b(this);
        AppMethodBeat.o(201385);
      }
    });
    AppMethodBeat.o(201312);
    return localObjectAnimator;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw)
  {
    AppMethodBeat.i(201350);
    ai.cj(paramView);
    paramViewGroup = d(paramView, a(paramw, 1.0F), 0.0F);
    AppMethodBeat.o(201350);
    return paramViewGroup;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw1, w paramw2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(201341);
    float f2 = a(paramw1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      paramViewGroup = d(paramView, f1, 1.0F);
      AppMethodBeat.o(201341);
      return paramViewGroup;
      f1 = f2;
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201331);
    super.b(paramw);
    paramw.values.put("android:fade:transitionAlpha", Float.valueOf(ai.ci(paramw.view)));
    AppMethodBeat.o(201331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.Fade
 * JD-Core Version:    0.7.0.1
 */