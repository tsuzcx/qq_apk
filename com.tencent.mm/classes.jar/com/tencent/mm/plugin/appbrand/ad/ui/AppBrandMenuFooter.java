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
import com.tencent.mm.plugin.appbrand.ad.d;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandMenuFooter
  extends LinearLayout
{
  private View iIW;
  
  public AppBrandMenuFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(160568);
    aL(paramContext);
    AppMethodBeat.o(160568);
  }
  
  public AppBrandMenuFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(160569);
    aL(paramContext);
    AppMethodBeat.o(160569);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(160570);
    this.iIW = LayoutInflater.from(paramContext).inflate(2131493011, this);
    AppMethodBeat.o(160570);
  }
  
  public void setPageView(ae paramae)
  {
    AppMethodBeat.i(160571);
    ((TextView)this.iIW.findViewById(2131302654)).setText(bt.nullAsNil(d.Dz(paramae.getAppId())));
    ImageView localImageView = (ImageView)this.iIW.findViewById(2131300874);
    b.aub().a(localImageView, d.DA(paramae.getAppId()), 2131230988, g.gSK);
    AppMethodBeat.o(160571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter
 * JD-Core Version:    0.7.0.1
 */