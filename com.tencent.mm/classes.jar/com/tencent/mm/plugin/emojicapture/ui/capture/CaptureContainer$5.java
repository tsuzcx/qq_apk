package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.a.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureContainer$5
  implements View.OnClickListener
{
  CaptureContainer$5(CaptureContainer paramCaptureContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2957);
    paramView = this.lyp.getPresenter();
    if (paramView != null)
    {
      paramView.exit();
      AppMethodBeat.o(2957);
      return;
    }
    AppMethodBeat.o(2957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.5
 * JD-Core Version:    0.7.0.1
 */