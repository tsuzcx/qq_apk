package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
final class aq$2$6
  implements PopupWindow.OnDismissListener
{
  aq$2$6(aq.2 param2, View paramView) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(273534);
    this.kqJ.setBackground(aq.f(this.yoS.yoR));
    AppMethodBeat.o(273534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.2.6
 * JD-Core Version:    0.7.0.1
 */