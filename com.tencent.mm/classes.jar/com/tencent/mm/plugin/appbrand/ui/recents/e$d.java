package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.al;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;

final class e$d
  extends RecyclerView.v
  implements View.OnClickListener, View.OnCreateContextMenuListener, n.d
{
  View eYp;
  TextView hhY;
  TextView hhZ;
  TextView hia;
  TextView hib;
  ImageView hic;
  View hid;
  a hie;
  final int hif = 1;
  final int hig = 2;
  
  e$d(e parame, View paramView)
  {
    super(paramView);
    this.eYp = paramView.findViewById(y.g.divider);
    this.hhY = ((TextView)paramView.findViewById(y.g.primary_text));
    this.hhZ = ((TextView)paramView.findViewById(y.g.secondary_text));
    this.hia = ((TextView)paramView.findViewById(y.g.tag_text));
    this.hib = ((TextView)paramView.findViewById(y.g.count_text));
    this.hic = ((ImageView)paramView.findViewById(y.g.icon));
    this.hid = paramView.findViewById(y.g.star_icon);
    paramView.setOnClickListener(this);
    this.hie = new e.d.1(this, this.aie.getContext());
    this.hie.c(this.aie, this, this);
  }
  
  private int apQ()
  {
    return e.i(this.hhH).N(this);
  }
  
  final AppBrandRecentTaskInfo apR()
  {
    try
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)e.b(this.hhH).mt(apQ());
      return localAppBrandRecentTaskInfo;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", localException, "getAppInfo", new Object[0]);
    }
    return null;
  }
  
  public final void onClick(View paramView)
  {
    paramView = apR();
    if (paramView == null) {
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1001;
    switch (this.hhH.fzn)
    {
    }
    for (;;)
    {
      AppBrandLaunchProxyUI.a(this.hhH.getActivity(), paramView.bFn, null, paramView.fEL, -1, localAppBrandStatObject, null, null);
      if ((this.hhH.getActivity() == null) || (!(this.hhH.getActivity() instanceof AppBrandLauncherUI))) {
        break;
      }
      paramView = ((AppBrandLauncherUI)this.hhH.getActivity()).hcW;
      if (paramView == null) {
        break;
      }
      paramView.fJi[7] = "1";
      return;
      localAppBrandStatObject.caB = 12;
      continue;
      localAppBrandStatObject.caB = 11;
      continue;
      localAppBrandStatObject.caB = 13;
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = apR();
    if (paramView == null) {
      return;
    }
    if (e.m(this.hhH))
    {
      paramContextMenuInfo = this.aie.getContext();
      if (!paramView.fJl) {
        break label80;
      }
    }
    label80:
    for (int i = y.j.app_brand_usage_remove_collection;; i = y.j.app_brand_usage_add_collection)
    {
      paramContextMenu.add(0, 1, 0, paramContextMenuInfo.getString(i));
      paramContextMenu.add(0, 2, 0, this.aie.getContext().getString(y.j.app_brand_launcher_recents_list_menu_delete));
      return;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = apR();
    if ((localAppBrandRecentTaskInfo == null) || (paramMenuItem == null)) {}
    label54:
    String str;
    do
    {
      return;
      switch (this.hhH.getActivity().getIntent().getIntExtra("extra_get_usage_reason", 3))
      {
      default: 
        paramInt = 1;
        if (paramInt == 7) {
          str = com.tencent.mm.plugin.appbrand.report.e.aob();
        }
        break;
      }
      for (;;)
      {
        if (1 == paramMenuItem.getItemId())
        {
          if ((!e.g(this.hhH)) && (e.a(this.hhH).apW().size() >= e.y(this.hhH)) && (!localAppBrandRecentTaskInfo.fJl))
          {
            if (this.hhH.getActivity() == null) {
              break;
            }
            h.a(this.hhH.getActivity(), this.hhH.getResources().getString(y.j.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(e.y(this.hhH)) }), "", this.hhH.getResources().getString(y.j.app_ok), false, null);
            return;
            paramInt = 7;
            break label54;
            if (TextUtils.isEmpty(e.x(this.hhH))) {
              e.a(this.hhH, com.tencent.mm.plugin.appbrand.report.e.aoa());
            }
            str = e.x(this.hhH);
            continue;
          }
          e.z(this.hhH).O(new e.d.2(this, localAppBrandRecentTaskInfo, paramInt, str));
          e.f(this.hhH).hjw = true;
          return;
        }
      }
    } while (2 != paramMenuItem.getItemId());
    if ((localAppBrandRecentTaskInfo.fJl) && (!e.g(this.hhH))) {
      e.z(this.hhH).O(new e.d.3(this, localAppBrandRecentTaskInfo, paramInt, str));
    }
    e.a(this.hhH).ms(apQ());
    e.f(this.hhH).hjw = true;
    e.e(this.hhH).apP();
    e.b(this.hhH).bN(apQ());
    e.c(this.hhH);
    al.k(localAppBrandRecentTaskInfo.bFn, localAppBrandRecentTaskInfo.appId, localAppBrandRecentTaskInfo.fEL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.d
 * JD-Core Version:    0.7.0.1
 */