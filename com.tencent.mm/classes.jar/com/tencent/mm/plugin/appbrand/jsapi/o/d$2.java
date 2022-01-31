package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.f.b;
import com.tencent.mm.plugin.appbrand.widget.f.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

final class d$2
  implements Runnable
{
  d$2(d paramd, r paramr, boolean paramBoolean1, com.tencent.mm.plugin.appbrand.page.v paramv, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(141770);
    if (this.hXF.hXE != null)
    {
      d.x(this.hXF.hXE);
      this.hXF.hXE = null;
    }
    if (this.hXF.gIs != null) {
      this.hXF.gIs.stopTimer();
    }
    if (!this.bAW.isRunning())
    {
      ab.w("MicroMsg.JsApiShowToast", "service is not running");
      AppMethodBeat.o(141770);
      return;
    }
    Object localObject1;
    label296:
    Object localObject2;
    if (this.hXG)
    {
      this.hXF.hXE = LayoutInflater.from(this.hxy.getContext()).inflate(2130968738, (ViewGroup)this.hxy.hmw, false);
      com.tencent.mm.model.v.aae().z(this.bAW.hashCode() + "toast_name", true).i("toast_view", this.hXF.hXE);
      if (this.hXI) {
        new d.2.a(this, this.hXF.hXE);
      }
      localObject1 = (TextView)this.hXF.hXE.findViewById(2131820680);
      int i = a.fromDPToPix(((TextView)localObject1).getContext(), 18);
      if (bo.isNullOrNil(this.cbK)) {
        break label511;
      }
      ((TextView)localObject1).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject1).setSpannableFactory(new d.2.2(this, i));
      ((TextView)localObject1).setText(this.cbK, TextView.BufferType.SPANNABLE);
      ((TextView)localObject1).setVisibility(0);
      if (!this.hXG) {
        this.hXF.hXE.findViewById(2131821403).setPadding(0, a.fromDPToPix(((TextView)localObject1).getContext(), 27), 0, 0);
      }
      if (!this.hXG)
      {
        localObject2 = (ImageView)this.hXF.hXE.findViewById(2131821405);
        localObject1 = (ProgressBar)this.hXF.hXE.findViewById(2131821404);
        if (!this.hXJ.equals("loading")) {
          break label520;
        }
        ((ImageView)localObject2).setVisibility(8);
        ((ProgressBar)localObject1).setVisibility(0);
      }
    }
    label520:
    label632:
    label636:
    for (;;)
    {
      localObject1 = this.hxy.ixr;
      localObject2 = this.hXF.hXE;
      if (((b)localObject1).jug.isRunning()) {
        ((b)localObject1).aSg().addView((View)localObject2);
      }
      this.hXF.gIs = new ap(new d.2.1(this), false);
      localObject1 = this.hXF.gIs;
      long l = this.hXH;
      ((ap)localObject1).ag(l, l);
      this.bAW.h(this.bAX, this.hXF.j("ok", null));
      AppMethodBeat.o(141770);
      return;
      this.hXF.hXE = LayoutInflater.from(this.hxy.getContext()).inflate(2130968739, (ViewGroup)this.hxy.hmw, false);
      break;
      label511:
      ((TextView)localObject1).setVisibility(4);
      break label296;
      ((ImageView)localObject2).setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      if (!bo.isNullOrNil(this.hXK))
      {
        localObject1 = t.j(this.bAW.getRuntime(), this.hXK);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label632;
        }
        localObject1 = new BitmapDrawable(((ImageView)localObject2).getResources(), (Bitmap)localObject1);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label636;
        }
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        break;
        localObject1 = this.bAW.getContext().getResources().getDrawable(2130837774);
        continue;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.d.2
 * JD-Core Version:    0.7.0.1
 */