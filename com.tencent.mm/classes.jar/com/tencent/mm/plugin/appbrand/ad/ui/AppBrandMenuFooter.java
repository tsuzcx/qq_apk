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
import com.tencent.mm.sdk.platformtools.bs;

public class AppBrandMenuFooter
  extends LinearLayout
{
  private View jja;
  
  public AppBrandMenuFooter(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(160568);
    aM(paramContext);
    AppMethodBeat.o(160568);
  }
  
  public AppBrandMenuFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(160569);
    aM(paramContext);
    AppMethodBeat.o(160569);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(160570);
    this.jja = LayoutInflater.from(paramContext).inflate(2131493011, this);
    AppMethodBeat.o(160570);
  }
  
  public void setPageView(ae paramae)
  {
    AppMethodBeat.i(160571);
    ((TextView)this.jja.findViewById(2131302654)).setText(bs.nullAsNil(d.HC(paramae.getAppId())));
    ImageView localImageView = (ImageView)this.jja.findViewById(2131300874);
    b.aAS().a(localImageView, d.HD(paramae.getAppId()), 2131230988, g.htk);
    AppMethodBeat.o(160571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter
 * JD-Core Version:    0.7.0.1
 */