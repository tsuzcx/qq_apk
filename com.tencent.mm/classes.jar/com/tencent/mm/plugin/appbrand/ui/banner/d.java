package com.tencent.mm.plugin.appbrand.ui.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean rbL = false;
  
  public static void ckM()
  {
    rbL = false;
  }
  
  public final void ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    AppMethodBeat.o(48998);
    throw null;
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(48994);
    if (!rbL)
    {
      ((e)h.ae(e.class)).b(this);
      ((e)h.ae(e.class)).ckI();
      ((e)h.ae(e.class)).a(this);
      rbL = true;
    }
    Object localObject2 = BannerModel.ckQ();
    if ((localObject2 != null) && (!Util.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      localObject2 = ((BannerModel)localObject2).rcc;
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
    return au.g.chatting_app_brand_entrance_banner;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48997);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    Object localObject2 = BannerModel.ckQ();
    if (localObject2 == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject1 = ((BannerModel)localObject2).appId;
    int i = ((BannerModel)localObject2).cBU;
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(48997);
      throw null;
    }
    localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1022;
    ((r)h.ae(r.class)).a(paramView.getContext(), null, (String)localObject1, i, -1, null, (AppBrandStatObject)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */