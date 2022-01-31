package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.appbrand.y.j;

final class AppBrandDesktopHalfView$17
  implements View.OnCreateContextMenuListener
{
  AppBrandDesktopHalfView$17(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 11, 0, this.hrR.getContext().getResources().getString(y.j.app_brand_desktop_menu_add_to_my_app_brand));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.17
 * JD-Core Version:    0.7.0.1
 */