package com.tencent.mm.live.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.d.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class LiveUID$c
  implements View.OnClickListener
{
  LiveUID$c(LiveUID paramLiveUID) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203271);
    if (LiveUID.b(this.KyL)) {
      if (LiveUID.d(this.KyL) != LiveUID.h(this.KyL)) {
        d.fPQ();
      }
    }
    for (;;)
    {
      LiveUID.a(this.KyL, LiveUID.h(this.KyL));
      paramView = LiveUID.f(this.KyL);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = LiveUID.g(this.KyL);
      if (paramView == null) {
        break;
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(203271);
      return;
      d.fPM();
    }
    AppMethodBeat.o(203271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID.c
 * JD-Core Version:    0.7.0.1
 */