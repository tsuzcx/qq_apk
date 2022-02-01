package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
    AppMethodBeat.i(192121);
    setMode(paramInt);
    AppMethodBeat.o(192121);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192129);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.arn);
    setMode(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, getMode()));
    paramContext.recycle();
    AppMethodBeat.o(192129);
  }
  
  private static float a(w paramw, float paramFloat)
  {
    AppMethodBeat.i(192153);
    float f = paramFloat;
    if (paramw != null)
    {
      paramw = (Float)paramw.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramw != null) {
        f = paramw.floatValue();
      }
    }
    AppMethodBeat.o(192153);
    return f;
  }
  
  private Animator c(final View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192141);
    if (paramFloat1 == paramFloat2)
    {
      AppMethodBeat.o(192141);
      return null;
    }
    ai.n(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ai.atd, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new a(paramView));
    a(new s()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(192101);
        ai.n(paramView, 1.0F);
        ai.bQ(paramView);
        paramAnonymousTransition.b(this);
        AppMethodBeat.o(192101);
      }
    });
    AppMethodBeat.o(192141);
    return localObjectAnimator;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw)
  {
    AppMethodBeat.i(192148);
    ai.bP(paramView);
    paramViewGroup = c(paramView, a(paramw, 1.0F), 0.0F);
    AppMethodBeat.o(192148);
    return paramViewGroup;
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, w paramw1, w paramw2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(192144);
    float f2 = a(paramw1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      paramViewGroup = c(paramView, f1, 1.0F);
      AppMethodBeat.o(192144);
      return paramViewGroup;
      f1 = f2;
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(192134);
    super.b(paramw);
    paramw.values.put("android:fade:transitionAlpha", Float.valueOf(ai.bO(paramw.view)));
    AppMethodBeat.o(192134);
  }
  
  static final class a
    extends AnimatorListenerAdapter
  {
    private boolean aqx = false;
    private final View mView;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(192113);
      ai.n(this.mView, 1.0F);
      if (this.aqx) {
        this.mView.setLayerType(0, null);
      }
      AppMethodBeat.o(192113);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(192111);
      if ((androidx.core.g.w.aa(this.mView)) && (this.mView.getLayerType() == 0))
      {
        this.aqx = true;
        this.mView.setLayerType(2, null);
      }
      AppMethodBeat.o(192111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.Fade
 * JD-Core Version:    0.7.0.1
 */