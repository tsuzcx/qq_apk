package com.tencent.mm.plugin.findersdk.b;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/LoadingProgressBar;", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "()V", "loadingProgressBar", "Landroid/widget/ProgressBar;", "getLoadingProgressBar", "()Landroid/widget/ProgressBar;", "setLoadingProgressBar", "(Landroid/widget/ProgressBar;)V", "dismiss", "", "show", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends g
{
  ProgressBar Dlp;
  
  public final void dismiss()
  {
    AppMethodBeat.i(273901);
    ProgressBar localProgressBar = this.Dlp;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(8);
    }
    AppMethodBeat.o(273901);
  }
  
  public final void show()
  {
    AppMethodBeat.i(273894);
    ProgressBar localProgressBar = this.Dlp;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
    AppMethodBeat.o(273894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.f
 * JD-Core Version:    0.7.0.1
 */