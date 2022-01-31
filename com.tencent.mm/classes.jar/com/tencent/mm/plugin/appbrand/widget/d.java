package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.h.a.ii;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfContainer;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements com.tencent.mm.plugin.appbrand.widget.recentview.d
{
  public final com.tencent.mm.plugin.appbrand.widget.header.a a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    return new com.tencent.mm.plugin.appbrand.widget.desktop.a(paramContext, paramListView, paramHeaderContainer);
  }
  
  public final AppBrandRecentView a(Context paramContext, d.b paramb, d.a parama)
  {
    if (paramb == d.b.hDk)
    {
      paramb = new ConversationAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(y.e.app_brand_recent_view_height));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(y.e.app_brand_recent_view_padding_top), 0, 0);
      paramb.setLayoutParams(parama);
      return paramb;
    }
    if (paramb == d.b.hDj)
    {
      paramb = new MenuAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(y.e.app_brand_recent_view_height));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(y.e.app_brand_recent_view_padding_top), 0, 0);
      paramb.setLayoutParams(parama);
      return paramb;
    }
    return null;
  }
  
  public final b aqW()
  {
    return new b();
  }
  
  public final void cE(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
    localIntent.putExtra("isShowHeaderWithAnim", true);
    localIntent.putExtra("isShowHeader", true);
    localIntent.putExtra("isScrollFirst", true);
    paramContext.startActivity(localIntent);
  }
  
  public final HeaderContainer cF(Context paramContext)
  {
    return new AppBrandDesktopHalfContainer(paramContext);
  }
  
  public final void ci(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (((h)g.DM().Dr()).Ex())
    {
      ii localii = new ii();
      localii.bQy.delay = paramInt1;
      localii.bQy.type = paramInt2;
      com.tencent.mm.sdk.b.a.udP.m(localii);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */