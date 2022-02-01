package com.g.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.pulldown.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "()V", "getMaxOffset", "", "child", "Landroid/view/View;", "getMinOffset", "getOffset", "setOffset", "", "offset", "springBack", "stopSpringBack", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements h
{
  public final void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(206951);
    if (paramView == null)
    {
      AppMethodBeat.o(206951);
      return;
    }
    float f = Math.abs(paramInt) / paramView.getHeight();
    if (paramInt > 0) {
      paramView.setPivotY(0.0F);
    }
    for (;;)
    {
      paramView.setScaleY(f + 1.0F);
      AppMethodBeat.o(206951);
      return;
      paramView.setPivotY(paramView.getHeight());
    }
  }
  
  public final int cI(View paramView)
  {
    AppMethodBeat.i(206959);
    if (paramView == null)
    {
      AppMethodBeat.o(206959);
      return 0;
    }
    float f = (paramView.getScaleY() - 1.0F) * paramView.getHeight();
    if (paramView.getPivotY() > 0.0F)
    {
      i = -(int)f;
      AppMethodBeat.o(206959);
      return i;
    }
    int i = (int)f;
    AppMethodBeat.o(206959);
    return i;
  }
  
  public final int cJ(View paramView)
  {
    AppMethodBeat.i(206963);
    if (paramView == null)
    {
      AppMethodBeat.o(206963);
      return 0;
    }
    int i = paramView.getHeight();
    AppMethodBeat.o(206963);
    return i;
  }
  
  public final int cK(View paramView)
  {
    AppMethodBeat.i(206970);
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getHeight())
    {
      i = -i;
      AppMethodBeat.o(206970);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.g.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */