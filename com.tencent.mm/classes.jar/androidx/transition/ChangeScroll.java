package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeScroll
  extends Transition
{
  private static final String[] ceH = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(w paramw)
  {
    AppMethodBeat.i(201233);
    paramw.values.put("android:changeScroll:x", Integer.valueOf(paramw.view.getScrollX()));
    paramw.values.put("android:changeScroll:y", Integer.valueOf(paramw.view.getScrollY()));
    AppMethodBeat.o(201233);
  }
  
  public final String[] LI()
  {
    return ceH;
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201275);
    if ((paramw1 == null) || (paramw2 == null))
    {
      AppMethodBeat.o(201275);
      return null;
    }
    View localView = paramw2.view;
    int i = ((Integer)paramw1.values.get("android:changeScroll:x")).intValue();
    int j = ((Integer)paramw2.values.get("android:changeScroll:x")).intValue();
    int k = ((Integer)paramw1.values.get("android:changeScroll:y")).intValue();
    int m = ((Integer)paramw2.values.get("android:changeScroll:y")).intValue();
    if (i != j) {
      localView.setScrollX(i);
    }
    for (paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });; paramViewGroup = null)
    {
      if (k != m) {
        localView.setScrollY(k);
      }
      for (paramw1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });; paramw1 = null)
      {
        paramViewGroup = v.a(paramViewGroup, paramw1);
        AppMethodBeat.o(201275);
        return paramViewGroup;
      }
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201246);
    a(paramw);
    AppMethodBeat.o(201246);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201254);
    a(paramw);
    AppMethodBeat.o(201254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ChangeScroll
 * JD-Core Version:    0.7.0.1
 */