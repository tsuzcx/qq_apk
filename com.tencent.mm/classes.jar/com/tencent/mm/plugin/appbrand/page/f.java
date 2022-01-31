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
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.widget.h;

@SuppressLint({"ViewConstructor"})
public final class f
  extends LinearLayout
{
  private ImageView ivs;
  private TextView ivt;
  private Button ivu;
  
  public f(Context paramContext, com.tencent.luggage.sdk.d.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(102213);
    inflate(getContext(), 2130968682, this);
    this.ivs = ((ImageView)findViewById(2131821129));
    this.ivt = ((TextView)findViewById(2131821199));
    this.ivu = ((Button)findViewById(2131821200));
    this.ivt.setText(getResources().getString(2131301348, new Object[] { paramb.wR().cqQ }));
    paramContext = (LinearLayout.LayoutParams)this.ivs.getLayoutParams();
    if ((paramb.getAppConfig() != null) && (paramb.getAppConfig().hgL != null) && (paramb.getAppConfig().hgL.ayo())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131427994);
        this.ivs.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.ivs.setColorFilter(paramContext);
      com.tencent.mm.modelappbrand.a.b.acD().a(this.ivs, paramb.wR().hiQ, ((h)paramb.E(h.class)).aOD(), com.tencent.mm.modelappbrand.a.f.fqU);
      this.ivu.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(102213);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */