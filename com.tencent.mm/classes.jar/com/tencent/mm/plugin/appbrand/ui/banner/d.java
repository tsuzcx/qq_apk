package com.tencent.mm.plugin.appbrand.ui.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends com.tencent.mm.pluginsdk.ui.a.b
  implements View.OnClickListener, f
{
  private static boolean uhA = false;
  
  public static void cMb()
  {
    uhA = false;
  }
  
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    AppMethodBeat.o(48998);
    throw null;
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(48994);
    if (!uhA)
    {
      ((e)h.ax(e.class)).b(this);
      ((e)h.ax(e.class)).cLW();
      ((e)h.ax(e.class)).a(this);
      uhA = true;
    }
    Object localObject2 = BannerModel.cMe();
    if ((localObject2 != null) && (!Util.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      localObject2 = ((BannerModel)localObject2).uhR;
      if (Util.isNullOrNil((String)localObject2)) {}
      while (Util.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = localObject2;
      }
      AppMethodBeat.o(48994);
      throw null;
    }
    AppMethodBeat.o(48994);
    throw null;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    AppMethodBeat.o(48996);
    throw null;
  }
  
  public final int getLayoutId()
  {
    return ba.g.chatting_app_brand_entrance_banner;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48997);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    Object localObject2 = BannerModel.cMe();
    if (localObject2 == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject1 = ((BannerModel)localObject2).appId;
    int i = ((BannerModel)localObject2).euz;
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(48997);
      throw null;
    }
    localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1022;
    ((t)h.ax(t.class)).a(paramView.getContext(), null, (String)localObject1, i, -1, null, (AppBrandStatObject)localObject2);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48997);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48995);
    AppMethodBeat.o(48995);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */