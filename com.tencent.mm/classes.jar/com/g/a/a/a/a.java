package com.g.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.pulldown.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "()V", "getMaxOffset", "", "child", "Landroid/view/View;", "getMinOffset", "getOffset", "setOffset", "", "offset", "springBack", "stopSpringBack", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements h
{
  public final void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(206948);
    if (paramView != null) {
      paramView.setTranslationY(paramInt);
    }
    AppMethodBeat.o(206948);
  }
  
  public final int cI(View paramView)
  {
    AppMethodBeat.i(206954);
    if (paramView == null)
    {
      AppMethodBeat.o(206954);
      return 0;
    }
    int i = (int)paramView.getTranslationY();
    AppMethodBeat.o(206954);
    return i;
  }
  
  public final int cJ(View paramView)
  {
    AppMethodBeat.i(206961);
    if (paramView == null)
    {
      AppMethodBeat.o(206961);
      return 0;
    }
    int i = paramView.getHeight();
    AppMethodBeat.o(206961);
    return i;
  }
  
  public final int cK(View paramView)
  {
    AppMethodBeat.i(206966);
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getHeight())
    {
      i = -i;
      AppMethodBeat.o(206966);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.g.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */