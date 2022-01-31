package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandLauncherRecentsList$c
  extends RecyclerView.c
  implements RecyclerView.f.a
{
  private AppBrandLauncherRecentsList$c(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  private void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(133372);
    this.iTl.postOnUiThread(new AppBrandLauncherRecentsList.c.1(this, paramBoolean));
    AppMethodBeat.o(133372);
  }
  
  public final void as(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133368);
    eT(false);
    AppMethodBeat.o(133368);
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133369);
    eT(true);
    AppMethodBeat.o(133369);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133370);
    eT(false);
    AppMethodBeat.o(133370);
  }
  
  public final void jx()
  {
    AppMethodBeat.i(133371);
    eT(false);
    AppMethodBeat.o(133371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.c
 * JD-Core Version:    0.7.0.1
 */