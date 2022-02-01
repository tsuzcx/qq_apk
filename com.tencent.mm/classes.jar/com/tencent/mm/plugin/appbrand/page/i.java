package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.widget.m;

public final class i
  extends LinearLayout
{
  private ImageView ttT;
  private TextView ttU;
  private Button ttV;
  
  public i(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), a.e.app_brand_error_page_layout, this);
    this.ttT = ((ImageView)findViewById(a.d.app_brand_error_page_iv));
    this.ttU = ((TextView)findViewById(a.d.app_brand_error_page_tips));
    this.ttV = ((Button)findViewById(a.d.app_brand_error_page_index));
    this.ttU.setText(getResources().getString(a.g.luggage_app_brand_error_guide, new Object[] { paramd.asz().hEy }));
    paramContext = (LinearLayout.LayoutParams)this.ttT.getLayoutParams();
    if ((paramd.getAppConfig() != null) && (paramd.getAppConfig().ckt() != null) && (paramd.getAppConfig().ckt().cky())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = a.bs(getContext(), a.b.app_brand_error_page_top_margin);
        this.ttT.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.ttT.setColorFilter(paramContext);
      com.tencent.mm.modelappbrand.a.b.bEY().a(this.ttT, paramd.asz().phA, ((m)paramd.ax(m.class)).cOQ(), g.org);
      this.ttV.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */