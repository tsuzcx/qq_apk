package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] apt = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(w paramw)
  {
    AppMethodBeat.i(191819);
    Object localObject = paramw.view;
    if (((View)localObject).getVisibility() == 8)
    {
      AppMethodBeat.o(191819);
      return;
    }
    Rect localRect = androidx.core.g.w.ak((View)localObject);
    paramw.values.put("android:clipBounds:clip", localRect);
    if (localRect == null)
    {
      localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      paramw.values.put("android:clipBounds:bounds", localObject);
    }
    AppMethodBeat.o(191819);
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(191830);
    if ((paramw1 == null) || (paramw2 == null) || (!paramw1.values.containsKey("android:clipBounds:clip")) || (!paramw2.values.containsKey("android:clipBounds:clip")))
    {
      AppMethodBeat.o(191830);
      return null;
    }
    Object localObject = (Rect)paramw1.values.get("android:clipBounds:clip");
    Rect localRect = (Rect)paramw2.values.get("android:clipBounds:clip");
    if (localRect == null) {}
    for (int i = 1; (localObject == null) && (localRect == null); i = 0)
    {
      AppMethodBeat.o(191830);
      return null;
    }
    if (localObject == null)
    {
      paramViewGroup = (Rect)paramw1.values.get("android:clipBounds:bounds");
      paramw1 = localRect;
    }
    while (paramViewGroup.equals(paramw1))
    {
      AppMethodBeat.o(191830);
      return null;
      paramViewGroup = (ViewGroup)localObject;
      paramw1 = localRect;
      if (localRect == null)
      {
        paramw1 = (Rect)paramw2.values.get("android:clipBounds:bounds");
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    androidx.core.g.w.a(paramw2.view, paramViewGroup);
    localObject = new n(new Rect());
    paramViewGroup = ObjectAnimator.ofObject(paramw2.view, ai.ate, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramw1 });
    if (i != 0) {
      paramViewGroup.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(191814);
          androidx.core.g.w.a(this.apT, null);
          AppMethodBeat.o(191814);
        }
      });
    }
    AppMethodBeat.o(191830);
    return paramViewGroup;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(191824);
    a(paramw);
    AppMethodBeat.o(191824);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(191825);
    a(paramw);
    AppMethodBeat.o(191825);
  }
  
  public final String[] nf()
  {
    return apt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */