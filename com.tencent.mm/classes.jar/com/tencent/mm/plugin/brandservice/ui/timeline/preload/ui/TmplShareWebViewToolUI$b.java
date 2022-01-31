package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
final class TmplShareWebViewToolUI$b
  implements MMWebView.d
{
  TmplShareWebViewToolUI$b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(152723);
    paramInt1 = TmplShareWebViewToolUI.a(this.kdm) - paramInt2;
    if (paramInt1 > TmplShareWebViewToolUI.b(this.kdm))
    {
      RelativeLayout localRelativeLayout = this.kdm.aYg();
      ViewGroup.LayoutParams localLayoutParams = this.kdm.aYg().getLayoutParams();
      localLayoutParams.height = paramInt1;
      localRelativeLayout.setLayoutParams(localLayoutParams);
      this.kdm.sy(paramInt1);
    }
    AppMethodBeat.o(152723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI.b
 * JD-Core Version:    0.7.0.1
 */