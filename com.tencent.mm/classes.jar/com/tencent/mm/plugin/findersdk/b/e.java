package com.tencent.mm.plugin.findersdk.b;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/LoadingProgressBar;", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "()V", "loadingProgressBar", "Landroid/widget/ProgressBar;", "getLoadingProgressBar", "()Landroid/widget/ProgressBar;", "setLoadingProgressBar", "(Landroid/widget/ProgressBar;)V", "dismiss", "", "show", "finder-sdk_release"})
public final class e
  extends f
{
  ProgressBar yyI;
  
  public final void dismiss()
  {
    AppMethodBeat.i(210063);
    ProgressBar localProgressBar = this.yyI;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      AppMethodBeat.o(210063);
      return;
    }
    AppMethodBeat.o(210063);
  }
  
  public final void show()
  {
    AppMethodBeat.i(210062);
    ProgressBar localProgressBar = this.yyI;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(0);
      AppMethodBeat.o(210062);
      return;
    }
    AppMethodBeat.o(210062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.e
 * JD-Core Version:    0.7.0.1
 */