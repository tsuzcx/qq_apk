package com.tencent.mm.live.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.d.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class LiveUID$b
  implements View.OnClickListener
{
  LiveUID$b(LiveUID paramLiveUID) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203270);
    if (LiveUID.b(this.KyL)) {
      if (LiveUID.d(this.KyL) != LiveUID.e(this.KyL)) {
        d.fPP();
      }
    }
    for (;;)
    {
      LiveUID.a(this.KyL, LiveUID.e(this.KyL));
      paramView = LiveUID.f(this.KyL);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = LiveUID.g(this.KyL);
      if (paramView == null) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(203270);
      return;
      d.fPL();
    }
    AppMethodBeat.o(203270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID.b
 * JD-Core Version:    0.7.0.1
 */