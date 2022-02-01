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
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.config.b.b;

@SuppressLint({"ViewConstructor"})
public final class i
  extends LinearLayout
{
  private ImageView nnL;
  private TextView nnM;
  private Button nnN;
  
  public i(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), 2131493028, this);
    this.nnL = ((ImageView)findViewById(2131296796));
    this.nnM = ((TextView)findViewById(2131296798));
    this.nnN = ((Button)findViewById(2131296795));
    this.nnM.setText(getResources().getString(2131762769, new Object[] { paramd.OM().brandName }));
    paramContext = (LinearLayout.LayoutParams)this.nnL.getLayoutParams();
    if ((paramd.getAppConfig() != null) && (paramd.getAppConfig().bzF() != null) && (paramd.getAppConfig().bzF().bzL())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = a.aH(getContext(), 2131165788);
        this.nnL.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.nnL.setColorFilter(paramContext);
      com.tencent.mm.modelappbrand.a.b.aXY().a(this.nnL, paramd.OM().jyi, ((com.tencent.mm.plugin.appbrand.widget.g)paramd.af(com.tencent.mm.plugin.appbrand.widget.g.class)).cab(), com.tencent.mm.modelappbrand.a.g.iJB);
      this.nnN.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */