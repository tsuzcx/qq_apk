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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] cec = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(w paramw)
  {
    AppMethodBeat.i(201270);
    Object localObject = paramw.view;
    if (((View)localObject).getVisibility() == 8)
    {
      AppMethodBeat.o(201270);
      return;
    }
    Rect localRect = z.ax((View)localObject);
    paramw.values.put("android:clipBounds:clip", localRect);
    if (localRect == null)
    {
      localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      paramw.values.put("android:clipBounds:bounds", localObject);
    }
    AppMethodBeat.o(201270);
  }
  
  public final String[] LI()
  {
    return cec;
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201334);
    if ((paramw1 == null) || (paramw2 == null) || (!paramw1.values.containsKey("android:clipBounds:clip")) || (!paramw2.values.containsKey("android:clipBounds:clip")))
    {
      AppMethodBeat.o(201334);
      return null;
    }
    Object localObject = (Rect)paramw1.values.get("android:clipBounds:clip");
    Rect localRect = (Rect)paramw2.values.get("android:clipBounds:clip");
    if (localRect == null) {}
    for (int i = 1; (localObject == null) && (localRect == null); i = 0)
    {
      AppMethodBeat.o(201334);
      return null;
    }
    if (localObject == null)
    {
      paramViewGroup = (Rect)paramw1.values.get("android:clipBounds:bounds");
      paramw1 = localRect;
    }
    while (paramViewGroup.equals(paramw1))
    {
      AppMethodBeat.o(201334);
      return null;
      paramViewGroup = (ViewGroup)localObject;
      paramw1 = localRect;
      if (localRect == null)
      {
        paramw1 = (Rect)paramw2.values.get("android:clipBounds:bounds");
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    z.a(paramw2.view, paramViewGroup);
    localObject = new n(new Rect());
    paramViewGroup = ObjectAnimator.ofObject(paramw2.view, ai.chN, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramw1 });
    if (i != 0) {
      paramViewGroup.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(201224);
          z.a(this.ceC, null);
          AppMethodBeat.o(201224);
        }
      });
    }
    AppMethodBeat.o(201334);
    return paramViewGroup;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201304);
    a(paramw);
    AppMethodBeat.o(201304);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201317);
    a(paramw);
    AppMethodBeat.o(201317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */