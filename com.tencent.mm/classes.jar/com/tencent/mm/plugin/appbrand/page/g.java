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
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.widget.h;

@SuppressLint({"ViewConstructor"})
public final class g
  extends LinearLayout
{
  private ImageView lZa;
  private TextView lZb;
  private Button lZc;
  
  public g(Context paramContext, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), 2131492993, this);
    this.lZa = ((ImageView)findViewById(2131296714));
    this.lZb = ((TextView)findViewById(2131296716));
    this.lZc = ((Button)findViewById(2131296713));
    this.lZb.setText(getResources().getString(2131760993, new Object[] { paramc.Fa().doD }));
    paramContext = (LinearLayout.LayoutParams)this.lZa.getLayoutParams();
    if ((paramc.getAppConfig() != null) && (paramc.getAppConfig().bdJ() != null) && (paramc.getAppConfig().bdJ().bdO())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165765);
        this.lZa.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.lZa.setColorFilter(paramContext);
      b.aDV().a(this.lZa, paramc.Fa().iAa, ((h)paramc.ab(h.class)).bCg(), com.tencent.mm.modelappbrand.a.g.hLC);
      this.lZc.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */