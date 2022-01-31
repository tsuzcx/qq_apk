package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopHalfView$17
  implements View.OnCreateContextMenuListener
{
  AppBrandDesktopHalfView$17(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(134177);
    paramContextMenu.add(0, 11, 0, this.jin.getContext().getResources().getString(2131296615));
    AppMethodBeat.o(134177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.17
 * JD-Core Version:    0.7.0.1
 */