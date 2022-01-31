package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int hDm = b.hpE - 1;
  private static final int hDn = b.hpE;
  private AppBrandRecentView.b hrk;
  
  public MenuAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(BaseAppBrandRecentView.c paramc, a parama, int paramInt)
  {
    super.a(paramc, parama, paramInt);
    paramc.eXr.setTextColor(-1728053248);
    if ((parama != null) && (parama.type == 2))
    {
      paramc.eXr.setVisibility(0);
      paramc.hqB.setVisibility(8);
      paramc.eXr.setText(y.j.multitask_bar_back_wechat);
      paramc.gSx.setImageResource(y.i.app_brand_capsule_multitasking_wechat);
    }
    while ((parama == null) || (parama.type != -1)) {
      return;
    }
    paramc.gSx.setImageResource(y.i.default_avatar);
  }
  
  public int getLayoutId()
  {
    return y.h.appbrand_menu_preview_item;
  }
  
  protected int getLoadCount()
  {
    return hDn;
  }
  
  protected int getShowCount()
  {
    return hDm;
  }
  
  protected String getType()
  {
    return MenuAppBrandRecentView.class.getSimpleName();
  }
  
  protected final void init(Context paramContext)
  {
    super.init(paramContext);
    super.setOnItemClickListener(new MenuAppBrandRecentView.1(this));
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.hrk = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */