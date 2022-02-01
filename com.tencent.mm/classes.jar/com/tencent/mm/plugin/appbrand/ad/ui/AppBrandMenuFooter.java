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
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuFooter
  extends LinearLayout
{
  private View kHq;
  
  public AppBrandMenuFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(160568);
    bh(paramContext);
    AppMethodBeat.o(160568);
  }
  
  public AppBrandMenuFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(160569);
    bh(paramContext);
    AppMethodBeat.o(160569);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(160570);
    this.kHq = LayoutInflater.from(paramContext).inflate(2131493049, this);
    AppMethodBeat.o(160570);
  }
  
  public void setPageView(ag paramag)
  {
    AppMethodBeat.i(160571);
    ((TextView)this.kHq.findViewById(2131305208)).setText(Util.nullAsNil(e.Uy(paramag.getAppId())));
    ImageView localImageView = (ImageView)this.kHq.findViewById(2131302468);
    b.aXY().a(localImageView, e.Uz(paramag.getAppId()), 2131231017, g.iJB);
    AppMethodBeat.o(160571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter
 * JD-Core Version:    0.7.0.1
 */