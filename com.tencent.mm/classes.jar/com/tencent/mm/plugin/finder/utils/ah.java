package com.tencent.mm.plugin.finder.utils;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LoadingProgressBar;", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "()V", "loadingProgressBar", "Landroid/widget/ProgressBar;", "getLoadingProgressBar", "()Landroid/widget/ProgressBar;", "setLoadingProgressBar", "(Landroid/widget/ProgressBar;)V", "dismiss", "", "show", "plugin-finder_release"})
public final class ah
  extends ai
{
  public ProgressBar uuU;
  
  public final void dismiss()
  {
    AppMethodBeat.i(253793);
    ProgressBar localProgressBar = this.uuU;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      AppMethodBeat.o(253793);
      return;
    }
    AppMethodBeat.o(253793);
  }
  
  public final void show()
  {
    AppMethodBeat.i(253792);
    ProgressBar localProgressBar = this.uuU;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(0);
      AppMethodBeat.o(253792);
      return;
    }
    AppMethodBeat.o(253792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ah
 * JD-Core Version:    0.7.0.1
 */