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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean mHP = false;
  private View mHJ;
  private TextView mHK;
  private ImageView mHL;
  private String mHM;
  private final Runnable mHN;
  private final b.k mHO;
  
  public static void bAb()
  {
    mHP = false;
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(48994);
    if (!mHP)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).bzX();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).a(this);
      mHP = true;
    }
    Object localObject2 = BannerModel.bAg();
    if ((localObject2 != null) && (!bt.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).mIh;
      localObject2 = ((BannerModel)localObject2).jPZ;
      if (bt.isNullOrNil(str)) {}
      while (bt.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.mHK != null) {
        this.mHK.setText((CharSequence)localObject1);
      }
      if (!bt.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!bt.isNullOrNil(this.mHM)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.aDV().Cr(this.mHM);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.mHO.E((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(48994);
        return true;
        label193:
        this.mHM = com.tencent.mm.modelappbrand.a.b.aDV().a(this.mHO, (String)localObject2, com.tencent.mm.modelappbrand.a.g.hLC);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(48994);
    return false;
  }
  
  public final void bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    aq.f(this.mHN);
    AppMethodBeat.o(48998);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    if (this.mHJ != null)
    {
      ((ViewGroup)this.mHJ).removeAllViews();
      this.mHJ.setVisibility(8);
    }
    this.mHJ = null;
    this.mHK = null;
    this.mHL = null;
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
    a.b("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    Object localObject2 = BannerModel.bAg();
    if (localObject2 == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject1 = ((BannerModel)localObject2).appId;
    int i = ((BannerModel)localObject2).hQh;
    if (bt.isNullOrNil((String)localObject1))
    {
      bAa();
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(48997);
      return;
    }
    localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1022;
    ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramView.getContext(), null, (String)localObject1, i, -1, null, (AppBrandStatObject)localObject2);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48997);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48995);
    if (this.mHJ != null) {
      this.mHJ.setVisibility(paramInt);
    }
    AppMethodBeat.o(48995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */