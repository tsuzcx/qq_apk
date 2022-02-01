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
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.widget.h;

@SuppressLint({"ViewConstructor"})
public final class f
  extends LinearLayout
{
  private ImageView mdt;
  private TextView mdu;
  private Button mdv;
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147440);
    inflate(getContext(), 2131492993, this);
    this.mdt = ((ImageView)findViewById(2131296714));
    this.mdu = ((TextView)findViewById(2131296716));
    this.mdv = ((Button)findViewById(2131296713));
    this.mdu.setText(getResources().getString(2131760993, new Object[] { paramd.Ff().dpI }));
    paramContext = (LinearLayout.LayoutParams)this.mdt.getLayoutParams();
    if ((paramd.getAppConfig() != null) && (paramd.getAppConfig().beo() != null) && (paramd.getAppConfig().beo().beu())) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext.topMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165765);
        this.mdt.setLayoutParams(paramContext);
        requestLayout();
      }
      paramContext = new ColorMatrix();
      paramContext.setSaturation(0.0F);
      paramContext = new ColorMatrixColorFilter(paramContext);
      this.mdt.setColorFilter(paramContext);
      b.aEl().a(this.mdt, paramd.Ff().iCT, ((h)paramd.ab(h.class)).bDa(), g.hOv);
      this.mdv.setVisibility(8);
      setBackgroundColor(-1);
      AppMethodBeat.o(147440);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */