package com.c.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.pulldown.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "()V", "getMaxOffset", "", "child", "Landroid/view/View;", "getMinOffset", "getOffset", "setOffset", "", "offset", "springBack", "stopSpringBack", "weui-native-android-lib_release"})
public final class b
  implements f
{
  public final void K(View paramView, int paramInt)
  {
    AppMethodBeat.i(249745);
    if (paramView == null)
    {
      AppMethodBeat.o(249745);
      return;
    }
    float f = Math.abs(paramInt) / paramView.getHeight();
    if (paramInt > 0) {
      paramView.setPivotY(0.0F);
    }
    for (;;)
    {
      paramView.setScaleY(f + 1.0F);
      AppMethodBeat.o(249745);
      return;
      paramView.setPivotY(paramView.getHeight());
    }
  }
  
  public final int cm(View paramView)
  {
    AppMethodBeat.i(249746);
    if (paramView == null)
    {
      AppMethodBeat.o(249746);
      return 0;
    }
    float f = (paramView.getScaleY() - 1.0F) * paramView.getHeight();
    if (paramView.getPivotY() > 0.0F)
    {
      i = -(int)f;
      AppMethodBeat.o(249746);
      return i;
    }
    int i = (int)f;
    AppMethodBeat.o(249746);
    return i;
  }
  
  public final int cn(View paramView)
  {
    AppMethodBeat.i(249747);
    if (paramView != null)
    {
      int i = paramView.getHeight();
      AppMethodBeat.o(249747);
      return i;
    }
    AppMethodBeat.o(249747);
    return 0;
  }
  
  public final int co(View paramView)
  {
    AppMethodBeat.i(249748);
    if (paramView != null) {}
    for (int i = paramView.getHeight();; i = 0)
    {
      i = -i;
      AppMethodBeat.o(249748);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.c.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */