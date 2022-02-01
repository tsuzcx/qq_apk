package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuFooter
  extends LinearLayout
{
  private View nBk;
  
  public AppBrandMenuFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(160568);
    bv(paramContext);
    AppMethodBeat.o(160568);
  }
  
  public AppBrandMenuFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(160569);
    bv(paramContext);
    AppMethodBeat.o(160569);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(160570);
    this.nBk = LayoutInflater.from(paramContext).inflate(au.g.app_brand_menu_footer, this);
    AppMethodBeat.o(160570);
  }
  
  public void setPageView(ah paramah)
  {
    AppMethodBeat.i(160571);
    ((TextView)this.nBk.findViewById(au.f.name)).setText(Util.nullAsNil(e.aci(paramah.getAppId())));
    ImageView localImageView = (ImageView)this.nBk.findViewById(au.f.icon);
    b.bhh().a(localImageView, e.acj(paramah.getAppId()), au.e.app_brand_menu_footer_ad_icon, g.lzF);
    AppMethodBeat.o(160571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter
 * JD-Core Version:    0.7.0.1
 */