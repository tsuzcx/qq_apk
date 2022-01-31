package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean hfH = false;
  private View hfB;
  private TextView hfC;
  private ImageView hfD;
  private String hfE;
  private final Runnable hfF;
  private final b.h hfG;
  
  public static void apv()
  {
    hfH = false;
  }
  
  public final void aP(String paramString, int paramInt)
  {
    ai.d(this.hfF);
  }
  
  public final boolean apu()
  {
    if (!hfH)
    {
      ((e)g.r(e.class)).b(this);
      ((e)g.r(e.class)).apr();
      ((e)g.r(e.class)).a(this);
      hfH = true;
    }
    Object localObject2 = BannerModel.apA();
    if ((localObject2 != null) && (!bk.bl(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).hfX;
      localObject2 = ((BannerModel)localObject2).fJY;
      if (bk.bl(str)) {}
      while (bk.bl((String)localObject1))
      {
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.hfC != null) {
        this.hfC.setText((CharSequence)localObject1);
      }
      if (!bk.bl((String)localObject2))
      {
        localObject1 = null;
        if (!bk.bl(this.hfE)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.JD().jG(this.hfE);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label178;
        }
        this.hfG.p((Bitmap)localObject1);
      }
      for (;;)
      {
        return true;
        label178:
        this.hfE = com.tencent.mm.modelappbrand.a.b.JD().a(this.hfG, (String)localObject2, com.tencent.mm.modelappbrand.a.f.eaL);
      }
    }
    setVisibility(8);
    return false;
  }
  
  public final void destroy()
  {
    if (this.hfB != null)
    {
      ((ViewGroup)this.hfB).removeAllViews();
      this.hfB.setVisibility(8);
    }
    this.hfB = null;
    this.hfC = null;
    this.hfD = null;
    ((e)g.r(e.class)).b(this);
  }
  
  public final int getLayoutId()
  {
    return y.h.chatting_app_brand_entrance_banner;
  }
  
  public final void onClick(View paramView)
  {
    Object localObject = BannerModel.apA();
    if (localObject == null) {
      return;
    }
    String str = ((BannerModel)localObject).appId;
    int i = ((BannerModel)localObject).fJy;
    if (bk.bl(str))
    {
      apu();
      return;
    }
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1022;
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramView.getContext(), null, str, i, -1, null, (AppBrandStatObject)localObject);
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.hfB != null) {
      this.hfB.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */