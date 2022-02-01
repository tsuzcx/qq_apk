package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean oag = false;
  private View oaa;
  private TextView oab;
  private ImageView oac;
  private String oad;
  private final Runnable oae;
  private final b.k oaf;
  
  public static void bYb()
  {
    oag = false;
  }
  
  public final void bJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    MMHandlerThread.postToMainThread(this.oae);
    AppMethodBeat.o(48998);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(48994);
    if (!oag)
    {
      ((e)com.tencent.mm.kernel.g.af(e.class)).b(this);
      ((e)com.tencent.mm.kernel.g.af(e.class)).bXX();
      ((e)com.tencent.mm.kernel.g.af(e.class)).a(this);
      oag = true;
    }
    Object localObject2 = BannerModel.bYf();
    if ((localObject2 != null) && (!Util.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).oax;
      localObject2 = ((BannerModel)localObject2).kVZ;
      if (Util.isNullOrNil(str)) {}
      while (Util.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.oab != null) {
        this.oab.setText((CharSequence)localObject1);
      }
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!Util.isNullOrNil(this.oad)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.aXY().LE(this.oad);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.oaf.I((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(48994);
        return true;
        label193:
        this.oad = com.tencent.mm.modelappbrand.a.b.aXY().a(this.oaf, (String)localObject2, com.tencent.mm.modelappbrand.a.g.iJB);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(48994);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    if (this.oaa != null)
    {
      ((ViewGroup)this.oaa).removeAllViews();
      this.oaa.setVisibility(8);
    }
    this.oaa = null;
    this.oab = null;
    this.oac = null;
    ((e)com.tencent.mm.kernel.g.af(e.class)).b(this);
    AppMethodBeat.o(48996);
  }
  
  public final int getLayoutId()
  {
    return 2131493477;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48997);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    Object localObject2 = BannerModel.bYf();
    if (localObject2 == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject1 = ((BannerModel)localObject2).appId;
    int i = ((BannerModel)localObject2).iOo;
    if (Util.isNullOrNil((String)localObject1))
    {
      bYa();
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1022;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramView.getContext(), null, (String)localObject1, i, -1, null, (AppBrandStatObject)localObject2);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48997);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48995);
    if (this.oaa != null) {
      this.oaa.setVisibility(paramInt);
    }
    AppMethodBeat.o(48995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */