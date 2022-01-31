package com.tencent.mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.u.o;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements b.h
{
  ImageView gDu;
  TextView haW;
  ImageView haX;
  IPCDynamicPageView haY;
  ThreeDotsLoadingView haZ;
  i.a hba;
  
  public WxaShareMessagePage(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    View localView = View.inflate(paramContext, y.h.wxa_share_message_page, this);
    this.gDu = ((ImageView)localView.findViewById(y.g.cover_iv));
    this.haX = ((ImageView)localView.findViewById(y.g.error_icon_iv));
    this.haY = ((IPCDynamicPageView)localView.findViewById(y.g.widget_pv));
    this.haW = ((TextView)localView.findViewById(y.g.title_tv));
    this.haZ = ((ThreeDotsLoadingView)localView.findViewById(y.g.loading_view));
    paramContext = ((a)g.r(a.class)).c(paramContext, (ViewGroup)localView);
    ((ViewGroup)localView.findViewById(y.g.container)).addView(paramContext);
    setGravity(17);
  }
  
  public final void JG() {}
  
  public final void JH()
  {
    this.haZ.setVisibility(4);
    this.haZ.cKc();
    this.gDu.setImageBitmap(null);
    this.haX.setVisibility(0);
    if (this.hba != null) {
      this.hba.ic(1);
    }
  }
  
  public ImageView getCoverImageView()
  {
    return this.gDu;
  }
  
  public ImageView getErrorImageView()
  {
    return this.haX;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.haZ;
  }
  
  public int getWidgetHeight()
  {
    return h.my(180);
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.haY;
  }
  
  public int getWidgetWidth()
  {
    return h.my(224);
  }
  
  public final void p(Bitmap paramBitmap)
  {
    this.haZ.setVisibility(4);
    this.haZ.cKc();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.gDu.setImageBitmap(paramBitmap);
      this.haX.setVisibility(4);
    }
    for (;;)
    {
      if (this.hba != null) {
        this.hba.ic(0);
      }
      return;
      this.gDu.setImageBitmap(null);
      this.haX.setVisibility(0);
    }
  }
  
  public final String pU()
  {
    return o.aX(this);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    this.gDu.setVisibility(0);
    this.haZ.setVisibility(4);
    this.haX.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.f localf = ((i)g.r(i.class)).Jp();
      this.gDu.setImageBitmap(localf.q(paramBitmap));
      return;
    }
    this.gDu.setImageBitmap(null);
  }
  
  public void setImageUrl(String paramString)
  {
    this.haZ.setVisibility(0);
    this.haZ.cKb();
    this.haX.setVisibility(4);
    this.gDu.setVisibility(0);
    b.JD().a(this, paramString, null, ((i)g.r(i.class)).bk(112, 90));
  }
  
  public void setOnLoadImageResult(i.a parama)
  {
    this.hba = parama;
  }
  
  public void setTitle(String paramString)
  {
    this.haW.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */