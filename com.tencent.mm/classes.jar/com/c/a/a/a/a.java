package com.c.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.pulldown.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "()V", "getMaxOffset", "", "child", "Landroid/view/View;", "getMinOffset", "getOffset", "setOffset", "", "offset", "springBack", "stopSpringBack", "weui-native-android-lib_release"})
public final class a
  implements f
{
  public final void K(View paramView, int paramInt)
  {
    AppMethodBeat.i(250877);
    if (paramView != null)
    {
      paramView.setTranslationY(paramInt);
      AppMethodBeat.o(250877);
      return;
    }
    AppMethodBeat.o(250877);
  }
  
  public final int cm(View paramView)
  {
    AppMethodBeat.i(250878);
    if (paramView != null)
    {
      int i = (int)paramView.getTranslationY();
      AppMethodBeat.o(250878);
      return i;
    }
    AppMethodBeat.o(250878);
    return 0;
  }
  
  public final int cn(View paramView)
  {
    AppMethodBeat.i(250880);
    if (paramView != null)
    {
      int i = paramView.getHeight();
      AppMethodBeat.o(250880);
      return i;
    }
    AppMethodBeat.o(250880);
    return 0;
  }
  
  public final int co(View paramView)
  {
    AppMethodBeat.i(250881);
    if (paramView != null) {}
    for (int i = paramView.getHeight();; i = 0)
    {
      i = -i;
      AppMethodBeat.o(250881);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.c.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */