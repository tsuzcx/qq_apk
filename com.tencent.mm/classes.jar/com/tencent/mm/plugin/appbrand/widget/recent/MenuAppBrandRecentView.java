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
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int uQD = d.uzv - 1;
  private static final int uQE = d.uzv;
  private AppBrandRecentView.a uQC;
  
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
    AppMethodBeat.i(324034);
    super.a(paramb, parame, paramInt);
    paramb.titleTv.setTextColor(getContext().getResources().getColor(ba.c.normal_text_color));
    if ((parame != null) && (parame.type == 2))
    {
      paramb.titleTv.setVisibility(0);
      paramb.uAt.setVisibility(8);
      paramb.titleTv.setText(ba.i.multitask_bar_back_wechat);
      paramb.ttT.setImageResource(ba.h.app_brand_capsule_multitasking_wechat);
      AppMethodBeat.o(324034);
      return;
    }
    if ((parame != null) && (parame.type == -1)) {
      paramb.ttT.setImageResource(ba.h.default_avatar);
    }
    AppMethodBeat.o(324034);
  }
  
  public int getLayoutId()
  {
    return ba.g.appbrand_menu_preview_item;
  }
  
  protected int getLoadCount()
  {
    return uQE;
  }
  
  protected int getShowCount()
  {
    return uQD;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(324026);
    String str = MenuAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(324026);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(324047);
    super.init(paramContext);
    super.setOnItemClickListener(new AppBrandRecentView.a()
    {
      public final boolean a(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(324020);
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {}
        for (boolean bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).a(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);; bool = false)
        {
          if (bool)
          {
            AppMethodBeat.o(324020);
            return true;
          }
          if (paramAnonymouse.type != 2)
          {
            paramAnonymousView = new AppBrandStatObject();
            paramAnonymousView.scene = 1090;
            ((t)h.ax(t.class)).a(MenuAppBrandRecentView.this.getContext(), paramAnonymouse.uAl.username, null, paramAnonymouse.uAl.euz, -1, null, paramAnonymousView);
          }
          AppMethodBeat.o(324020);
          return false;
        }
      }
      
      public final boolean b(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(324025);
        boolean bool = false;
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {
          bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).b(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(324025);
        return bool;
      }
    });
    AppMethodBeat.o(324047);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.a parama)
  {
    this.uQC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */