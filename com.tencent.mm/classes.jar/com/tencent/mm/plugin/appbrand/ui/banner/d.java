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
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean mMT = false;
  private View mMN;
  private TextView mMO;
  private ImageView mMP;
  private String mMQ;
  private final Runnable mMR;
  private final b.k mMS;
  
  public static void bAW()
  {
    mMT = false;
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(48994);
    if (!mMT)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).bAS();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).a(this);
      mMT = true;
    }
    Object localObject2 = BannerModel.bBb();
    if ((localObject2 != null) && (!bu.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).mNk;
      localObject2 = ((BannerModel)localObject2).jTr;
      if (bu.isNullOrNil(str)) {}
      while (bu.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.mMO != null) {
        this.mMO.setText((CharSequence)localObject1);
      }
      if (!bu.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!bu.isNullOrNil(this.mMQ)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.aEl().CT(this.mMQ);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.mMS.F((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(48994);
        return true;
        label193:
        this.mMQ = com.tencent.mm.modelappbrand.a.b.aEl().a(this.mMS, (String)localObject2, com.tencent.mm.modelappbrand.a.g.hOv);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(48994);
    return false;
  }
  
  public final void bE(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    ar.f(this.mMR);
    AppMethodBeat.o(48998);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    if (this.mMN != null)
    {
      ((ViewGroup)this.mMN).removeAllViews();
      this.mMN.setVisibility(8);
    }
    this.mMN = null;
    this.mMO = null;
    this.mMP = null;
    ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
    AppMethodBeat.o(48996);
  }
  
  public final int getLayoutId()
  {
    return 2131493383;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48997);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    Object localObject2 = BannerModel.bBb();
    if (localObject2 == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject1 = ((BannerModel)localObject2).appId;
    int i = ((BannerModel)localObject2).hSZ;
    if (bu.isNullOrNil((String)localObject1))
    {
      bAV();
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1022;
    ((p)com.tencent.mm.kernel.g.ab(p.class)).a(paramView.getContext(), null, (String)localObject1, i, -1, null, (AppBrandStatObject)localObject2);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48997);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48995);
    if (this.mMN != null) {
      this.mMN.setVisibility(paramInt);
    }
    AppMethodBeat.o(48995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */