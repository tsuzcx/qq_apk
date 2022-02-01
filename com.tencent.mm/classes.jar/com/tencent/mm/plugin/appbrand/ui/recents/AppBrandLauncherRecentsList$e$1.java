package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.a;

final class AppBrandLauncherRecentsList$e$1
  extends a
{
  AppBrandLauncherRecentsList$e$1(AppBrandLauncherRecentsList.e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean fQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49104);
    if (this.umZ.caK.getParent() != null) {
      this.umZ.caK.getParent().requestDisallowInterceptTouchEvent(true);
    }
    boolean bool = super.fQ(paramInt1, paramInt2);
    AppMethodBeat.o(49104);
    return bool;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(49105);
    if (this.umZ.caK.getParent() != null) {
      this.umZ.caK.getParent().requestDisallowInterceptTouchEvent(false);
    }
    super.onDismiss();
    AppMethodBeat.o(49105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.1
 * JD-Core Version:    0.7.0.1
 */