package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.b;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.widget.j;

@SuppressLint({"ViewConstructor"})
public final class i
  extends LinearLayout
{
  private ImageView qps;
  private TextView qpt;
  private Button qpu;
  
  public i(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), a.e.app_brand_error_page_layout, this);
    this.qps = ((ImageView)findViewById(a.d.app_brand_error_page_iv));
    this.qpt = ((TextView)findViewById(a.d.app_brand_error_page_tips));
    this.qpu = ((Button)findViewById(a.d.app_brand_error_page_index));
    this.qpt.setText(getResources().getString(a.g.luggage_app_brand_error_guide, new Object[] { paramd.Sj().fzM }));
    paramContext = (LinearLayout.LayoutParams)this.qps.getLayoutParams();
    if ((paramd.getAppConfig() != null) && (paramd.getAppConfig().bKU() != null) && (paramd.getAppConfig().bKU().bLa())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = a.aZ(getContext(), a.b.app_brand_error_page_top_margin);
        this.qps.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.qps.setColorFilter(paramContext);
      com.tencent.mm.modelappbrand.a.b.bhh().a(this.qps, paramd.Sj().mnM, ((j)paramd.ae(j.class)).cmY(), g.lzF);
      this.qpu.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */