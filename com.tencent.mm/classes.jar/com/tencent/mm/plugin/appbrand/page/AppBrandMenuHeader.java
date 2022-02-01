package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.c;

public class AppBrandMenuHeader
  extends LinearLayout
{
  private View nBk;
  private final c<? extends com.tencent.mm.vending.e.a> qpw;
  
  public AppBrandMenuHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47775);
    this.qpw = new c();
    bv(paramContext);
    AppMethodBeat.o(47775);
  }
  
  public AppBrandMenuHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47776);
    this.qpw = new c();
    bv(paramContext);
    AppMethodBeat.o(47776);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(47777);
    this.nBk = LayoutInflater.from(paramContext).inflate(au.g.app_brand_menu_header, this);
    AppMethodBeat.o(47777);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(250054);
    super.onDetachedFromWindow();
    this.qpw.dead();
    AppMethodBeat.o(250054);
  }
  
  public void setPage(ah paramah)
  {
    AppMethodBeat.i(47778);
    Object localObject4 = paramah.getRuntime();
    Object localObject2 = (ImageView)this.nBk.findViewById(au.f.icon);
    TextView localTextView1 = (TextView)this.nBk.findViewById(au.f.name);
    Object localObject1 = (TextView)this.nBk.findViewById(au.f.debug_type_desc);
    ImageView localImageView1 = (ImageView)this.nBk.findViewById(au.f.original_label);
    Object localObject3 = (ImageView)this.nBk.findViewById(au.f.trading_guarantee_icon);
    ImageView localImageView2 = (ImageView)this.nBk.findViewById(au.f.official_icon);
    label185:
    TextView localTextView3;
    TextView localTextView2;
    if ((e.iP(paramah.getRuntime().bDx().nYp)) && (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUy, 0) == 1))
    {
      ((ImageView)localObject3).setVisibility(0);
      if ((!e.iO(paramah.getRuntime().bDx().nYq)) || (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXL, 0) != 1)) {
        break label440;
      }
      localImageView2.setVisibility(0);
      localTextView3 = (TextView)this.nBk.findViewById(au.f.score);
      localObject3 = this.nBk.findViewById(au.f.status_ll);
      localImageView2 = (ImageView)this.nBk.findViewById(au.f.status_icon);
      localTextView2 = (TextView)this.nBk.findViewById(au.f.status_desc);
      View localView = this.nBk.findViewById(au.f.name_area);
      localObject4 = l.ad((AppBrandRuntime)localObject4);
      Runnable localRunnable = ((l)localObject4).c(paramah);
      com.tencent.mm.modelappbrand.a.b.bhh().a((ImageView)localObject2, ((l)localObject4).cdq(), com.tencent.mm.modelappbrand.a.a.bhg(), new g());
      ((ImageView)localObject2).setOnClickListener(new AppBrandMenuHeader.1(this, localRunnable));
      localView.setOnClickListener(new AppBrandMenuHeader.2(this, localRunnable));
      localTextView1.getPaint().setFakeBoldText(true);
      localTextView1.setText(((l)localObject4).cdr());
      localObject2 = ((l)localObject4).cds();
      if (!Util.isNullOrNil((String)localObject2)) {
        break label450;
      }
      ((TextView)localObject1).setVisibility(8);
      label363:
      if (!((l)localObject4).cdt()) {
        break label464;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ((l)localObject4).a(new AppBrandMenuHeader.3(this, localTextView3), this.qpw);
      localObject1 = ((l)localObject4).Cn(a.a.ah(paramah.getRuntime()).cfu());
      if (localObject1 != null) {
        break label473;
      }
      ((View)localObject3).setVisibility(8);
      AppMethodBeat.o(47778);
      return;
      ((ImageView)localObject3).setVisibility(8);
      break;
      label440:
      localImageView2.setVisibility(8);
      break label185;
      label450:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setVisibility(0);
      break label363;
      label464:
      localImageView1.setVisibility(8);
    }
    label473:
    ((View)localObject3).setBackgroundResource(((l.b)localObject1).qpM);
    localImageView2.setImageResource(((l.b)localObject1).qpN);
    localTextView2.setText(((l.b)localObject1).desc);
    ((View)localObject3).setOnClickListener(new AppBrandMenuHeader.4(this, (l)localObject4, paramah));
    ((View)localObject3).setVisibility(0);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader
 * JD-Core Version:    0.7.0.1
 */