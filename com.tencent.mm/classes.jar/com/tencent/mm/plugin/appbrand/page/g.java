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
  private ImageView lzC;
  private TextView lzD;
  private Button lzE;
  
  public g(Context paramContext, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), 2131492993, this);
    this.lzC = ((ImageView)findViewById(2131296714));
    this.lzD = ((TextView)findViewById(2131296716));
    this.lzE = ((Button)findViewById(2131296713));
    this.lzD.setText(getResources().getString(2131760993, new Object[] { paramc.DB().ddh }));
    paramContext = (LinearLayout.LayoutParams)this.lzC.getLayoutParams();
    if ((paramc.getAppConfig() != null) && (paramc.getAppConfig().bak() != null) && (paramc.getAppConfig().bak().bap())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = com.tencent.mm.cc.a.av(getContext(), 2131165765);
        this.lzC.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.lzC.setColorFilter(paramContext);
      b.aAS().a(this.lzC, paramc.DB().igG, ((h)paramc.ab(h.class)).bya(), com.tencent.mm.modelappbrand.a.g.htk);
      this.lzE.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */