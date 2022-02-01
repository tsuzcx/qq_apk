package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int rFr = d.rpk - 1;
  private static final int rFs = d.rpk;
  private AppBrandRecentView.a rFq;
  
  public MenuAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(BaseAppBrandRecentView.b paramb, e parame, int paramInt)
  {
    AppMethodBeat.i(271580);
    super.a(paramb, parame, paramInt);
    paramb.titleTv.setTextColor(getContext().getResources().getColor(au.c.normal_text_color));
    if ((parame != null) && (parame.type == 2))
    {
      paramb.titleTv.setVisibility(0);
      paramb.rqi.setVisibility(8);
      paramb.titleTv.setText(au.i.multitask_bar_back_wechat);
      paramb.qps.setImageResource(au.h.app_brand_capsule_multitasking_wechat);
      AppMethodBeat.o(271580);
      return;
    }
    if ((parame != null) && (parame.type == -1)) {
      paramb.qps.setImageResource(au.h.default_avatar);
    }
    AppMethodBeat.o(271580);
  }
  
  public int getLayoutId()
  {
    return au.g.appbrand_menu_preview_item;
  }
  
  protected int getLoadCount()
  {
    return rFs;
  }
  
  protected int getShowCount()
  {
    return rFr;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(271578);
    String str = MenuAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(271578);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(271581);
    super.init(paramContext);
    super.setOnItemClickListener(new AppBrandRecentView.a()
    {
      public final boolean a(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(273880);
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {}
        for (boolean bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).a(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);; bool = false)
        {
          if (bool)
          {
            AppMethodBeat.o(273880);
            return true;
          }
          if (paramAnonymouse.type != 2)
          {
            paramAnonymousView = new AppBrandStatObject();
            paramAnonymousView.scene = 1090;
            ((r)h.ae(r.class)).a(MenuAppBrandRecentView.this.getContext(), paramAnonymouse.rqa.username, null, paramAnonymouse.rqa.cBU, -1, null, paramAnonymousView);
          }
          AppMethodBeat.o(273880);
          return false;
        }
      }
      
      public final boolean b(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(273882);
        boolean bool = false;
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {
          bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).b(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(273882);
        return bool;
      }
    });
    AppMethodBeat.o(271581);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.a parama)
  {
    this.rFq = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */