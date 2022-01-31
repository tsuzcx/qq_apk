package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.luggage.l.b.a.a;
import com.tencent.luggage.l.b.a.b;
import com.tencent.luggage.l.b.a.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class d$2
  implements Runnable
{
  d$2(d paramd, boolean paramBoolean1, q paramq, o paramo, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    if (this.gAt.gAr != null)
    {
      d.bT(this.gAt.gAr);
      this.gAt.gAr = null;
      if (this.gAt.fqP != null) {
        this.gAt.fqP.stopTimer();
      }
    }
    if (this.gAu) {}
    Object localObject2;
    for (this.gAt.gAr = LayoutInflater.from(this.gjp.mContext).inflate(a.c.app_brand_show_no_icon_toast, null);; this.gAt.gAr = LayoutInflater.from(this.gjp.mContext).inflate(a.c.app_brand_show_toast, null))
    {
      localObject2 = this.gjp.aha();
      if (localObject2 != null) {
        break;
      }
      y.e("MicroMsg.JsApiShowToast", "the page may be destroy");
      return;
    }
    d.a(this.gAt, (FrameLayout)localObject2);
    u.Hc().v(this.gcp.hashCode() + "toast_name", true).h("toast_view", this.gAt.gAr);
    if (this.gAw)
    {
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.gAt.gAr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)this.gAt.gAr.findViewById(a.b.show_toast_view)).setBackgroundColor(0);
      this.gAt.gAr.setOnTouchListener(new d.2.2(this));
    }
    Object localObject1 = (TextView)this.gAt.gAr.findViewById(a.b.title);
    int i = a.fromDPToPix(((TextView)localObject1).getContext(), 18);
    ImageView localImageView;
    if (!bk.bl(this.dYK))
    {
      ((TextView)localObject1).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject1).setSpannableFactory(new d.2.3(this, i));
      ((TextView)localObject1).setText(this.dYK, TextView.BufferType.SPANNABLE);
      ((TextView)localObject1).setVisibility(0);
      if (!this.gAu) {
        this.gAt.gAr.findViewById(a.b.show_toast_view_container).setPadding(0, a.fromDPToPix(((TextView)localObject1).getContext(), 27), 0, 0);
      }
      if (!this.gAu)
      {
        localImageView = (ImageView)this.gAt.gAr.findViewById(a.b.iv_icon);
        localObject1 = (ProgressBar)this.gAt.gAr.findViewById(a.b.progress);
        if (!this.gAx.equals("loading")) {
          break label581;
        }
        localImageView.setVisibility(8);
        ((ProgressBar)localObject1).setVisibility(0);
      }
    }
    label693:
    label697:
    for (;;)
    {
      ((FrameLayout)localObject2).addView(this.gAt.gAr);
      localObject1 = m.ch(this.gjp.aha());
      if (localObject1 != null)
      {
        localObject2 = this.gAt.gAs;
        if ((localObject2 != null) && (!((m)localObject1).htY.contains(localObject2))) {
          ((m)localObject1).htY.add(localObject2);
        }
      }
      this.gAt.fqP = new am(new d.2.1(this), false);
      localObject1 = this.gAt.fqP;
      long l = this.gAv;
      ((am)localObject1).S(l, l);
      this.gcp.C(this.dIS, this.gAt.h("ok", null));
      return;
      ((TextView)localObject1).setVisibility(4);
      break;
      label581:
      localImageView.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      if (!bk.bl(this.gAy))
      {
        localObject1 = p.i(this.gcp.getRuntime(), this.gAy);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label693;
        }
        localObject1 = new BitmapDrawable(localImageView.getResources(), (Bitmap)localObject1);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label697;
        }
        localImageView.setImageDrawable((Drawable)localObject1);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        break;
        localObject1 = this.gcp.getContext().getResources().getDrawable(a.a.app_brand_show_toast_success);
        continue;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d.2
 * JD-Core Version:    0.7.0.1
 */