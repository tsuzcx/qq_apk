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
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuFooter
  extends LinearLayout
{
  private View qAv;
  
  public AppBrandMenuFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(160569);
    this.qAv = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_menu_footer, this);
    AppMethodBeat.o(160569);
  }
  
  public void setPageView(ah paramah)
  {
    AppMethodBeat.i(160571);
    ((TextView)this.qAv.findViewById(ba.f.name)).setText(Util.nullAsNil(e.UI(paramah.getAppId())));
    ImageView localImageView = (ImageView)this.qAv.findViewById(ba.f.icon);
    b.bEY().a(localImageView, e.UJ(paramah.getAppId()), ba.e.app_brand_menu_footer_ad_icon, g.org);
    AppMethodBeat.o(160571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter
 * JD-Core Version:    0.7.0.1
 */