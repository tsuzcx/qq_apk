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
  private ImageView kXS;
  private TextView kXT;
  private Button kXU;
  
  public g(Context paramContext, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), 2131492993, this);
    this.kXS = ((ImageView)findViewById(2131296714));
    this.kXT = ((TextView)findViewById(2131296716));
    this.kXU = ((Button)findViewById(2131296713));
    this.kXT.setText(getResources().getString(2131760993, new Object[] { paramc.DY().dfM }));
    paramContext = (LinearLayout.LayoutParams)this.kXS.getLayoutParams();
    if ((paramc.getAppConfig() != null) && (paramc.getAppConfig().aTm() != null) && (paramc.getAppConfig().aTm().aTr())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165765);
        this.kXS.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.kXS.setColorFilter(paramContext);
      b.aub().a(this.kXS, paramc.DY().hGe, ((h)paramc.ab(h.class)).bra(), com.tencent.mm.modelappbrand.a.g.gSK);
      this.kXU.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */