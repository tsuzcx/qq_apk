package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.kh;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoHeaderView$d
  implements View.OnClickListener
{
  MPVideoHeaderView$d(MPVideoHeaderView paramMPVideoHeaderView, kh paramkh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(15254);
    if (this.kgW.wxJ == 1)
    {
      MPVideoHeaderView.e(this.kgT).ao(2, "");
      AppMethodBeat.o(15254);
      return;
    }
    MPVideoHeaderView.e(this.kgT).ao(1, "");
    MPVideoHeaderView.f(this.kgT);
    AppMethodBeat.o(15254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.d
 * JD-Core Version:    0.7.0.1
 */