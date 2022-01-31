package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

final class AppBrandDesktopView$c
  extends RecyclerView.a
{
  private AppBrandDesktopView$c(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  private AppBrandDesktopView.a mF(int paramInt)
  {
    return (AppBrandDesktopView.a)AppBrandDesktopView.l(this.hqv).get(paramInt);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = com.tencent.mm.ui.y.gt(this.hqv.getContext()).inflate(y.h.appbrand_preview_item, paramViewGroup, false);
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft() + AppBrandDesktopView.h(this.hqv), paramViewGroup.getPaddingTop(), paramViewGroup.getPaddingRight() + AppBrandDesktopView.h(this.hqv), paramViewGroup.getPaddingBottom());
      return new e(paramViewGroup);
    }
    if (paramInt == 2)
    {
      paramViewGroup = new RecentAppBrandView(this.hqv.getContext());
      paramViewGroup.setItemPadding(AppBrandDesktopView.h(this.hqv));
      paramViewGroup.setDataList(AppBrandDesktopView.i(this.hqv));
      return new AppBrandDesktopView.c.1(this, paramViewGroup);
    }
    if (paramInt == 3)
    {
      paramViewGroup = new View(this.hqv.getContext());
      localLayoutParams = new RecyclerView.LayoutParams(-1, this.hqv.getResources().getDisplayMetrics().widthPixels / 4);
      localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.bottomMargin);
      paramViewGroup.setLayoutParams(localLayoutParams);
      return new AppBrandDesktopView.f(this.hqv, paramViewGroup);
    }
    if (paramInt == 6)
    {
      AppBrandDesktopView.a(this.hqv, paramViewGroup);
      return new AppBrandDesktopView.e(this.hqv, AppBrandDesktopView.j(this.hqv));
    }
    if (paramInt == 7)
    {
      paramViewGroup = com.tencent.mm.ui.y.gt(this.hqv.getContext()).inflate(y.h.appbrand_preview_item, paramViewGroup, false);
      localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
      localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.bottomMargin);
      paramViewGroup.setLayoutParams(localLayoutParams);
      return new AppBrandDesktopView.f(this.hqv, paramViewGroup);
    }
    if (paramInt == 8)
    {
      paramViewGroup = com.tencent.mm.ui.y.gt(this.hqv.getContext()).inflate(y.h.app_brand_desktop_collection_empty_item, paramViewGroup, false);
      return new AppBrandDesktopView.d(this.hqv, paramViewGroup);
    }
    if (paramInt == 9)
    {
      paramViewGroup = com.tencent.mm.ui.y.gt(this.hqv.getContext()).inflate(y.h.app_brand_desktop_full_empty_item, paramViewGroup, false);
      return new AppBrandDesktopView.b(this.hqv, paramViewGroup);
    }
    paramViewGroup = com.tencent.mm.ui.y.gt(this.hqv.getContext()).inflate(y.h.my_appbrand_title_item, paramViewGroup, false);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
    localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.h(this.hqv), localLayoutParams.bottomMargin);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new AppBrandDesktopView.f(this.hqv, paramViewGroup);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i = 0;
    int j = paramv.aii;
    if (j == 3) {
      paramv.aie.setVisibility(4);
    }
    label160:
    e locale;
    label269:
    label404:
    label541:
    for (;;)
    {
      return;
      if (j == 7)
      {
        paramv.aie.setVisibility(4);
        return;
      }
      if ((j == 10) || (j == 11))
      {
        paramv = (AppBrandDesktopView.f)paramv;
        paramInt = getItemViewType(paramInt);
        paramv = paramv.eXr;
        if (paramInt == 10) {}
        for (paramInt = y.j.recent_app_brand;; paramInt = y.j.my_app_brand)
        {
          paramv.setText(paramInt);
          return;
        }
      }
      if (j == 8)
      {
        paramv = (AppBrandDesktopView.d)paramv;
        boolean bool;
        if (!AppBrandDesktopView.k(this.hqv))
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MyAppBrandHeader", "alvinluo MyAppBrandEmptyViewHolder show: %b", new Object[] { Boolean.valueOf(bool) });
          paramv = paramv.aie;
          if (!bool) {
            break label160;
          }
        }
        for (paramInt = i;; paramInt = 4)
        {
          paramv.setVisibility(paramInt);
          return;
          bool = false;
          break;
        }
      }
      if ((j != 2) && (j != 6) && (j != 9))
      {
        locale = (e)paramv;
        if (j == 1)
        {
          paramv.aie.setVisibility(0);
          paramv = mF(paramInt);
          paramv.position = paramInt;
          locale.hqE = paramv;
          if (paramv.hqw == null) {
            break label475;
          }
          if (bk.bl(paramv.hqw.nickname)) {
            break label404;
          }
          locale.eXr.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.wZ(paramv.hqw.nickname));
          locale.eXr.setVisibility(0);
          locale.hqB.setVisibility(0);
          if (bk.bl(paramv.hqw.fJY)) {
            break label448;
          }
          b.JD().a(locale.gSx, paramv.hqw.fJY, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
          label316:
          if (bk.bl(com.tencent.mm.plugin.appbrand.appcache.a.kp(paramv.hqw.fJy))) {
            break label462;
          }
          locale.hqC.setVisibility(0);
          locale.hqC.setText(com.tencent.mm.plugin.appbrand.appcache.a.kp(paramv.hqw.fJy));
        }
        for (;;)
        {
          if (this.hqv.getDragRubbishView() == null) {
            break label541;
          }
          paramv = this.hqv.getDragRubbishView();
          if (paramv.getVisibility() == 8) {
            break;
          }
          if (paramv.hqK != paramInt) {
            break label543;
          }
          locale.aie.setVisibility(4);
          return;
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MyAppBrandHeader", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { paramv.hqw.username, paramv.hqw.appId });
          locale.eXr.setVisibility(4);
          break label269;
          label448:
          locale.gSx.setImageDrawable(com.tencent.mm.modelappbrand.a.a.JC());
          break label316;
          label462:
          locale.hqC.setVisibility(8);
          continue;
          label475:
          b.JD().a(locale.gSx, "", com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
          locale.eXr.setVisibility(0);
          locale.hqC.setVisibility(8);
          locale.eXr.setText("[none] " + paramInt);
        }
      }
    }
    label543:
    locale.aie.setVisibility(0);
  }
  
  public final int getItemCount()
  {
    return AppBrandDesktopView.l(this.hqv).size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return mF(paramInt).type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c
 * JD-Core Version:    0.7.0.1
 */