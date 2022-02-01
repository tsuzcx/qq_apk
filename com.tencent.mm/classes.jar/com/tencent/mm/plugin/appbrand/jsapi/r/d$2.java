package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;

final class d$2
  implements Runnable
{
  d$2(d paramd, r paramr, boolean paramBoolean1, z paramz, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138272);
    if (this.liA.jnx != null) {
      this.liA.jnx.stopTimer();
    }
    if (!this.cjR.isRunning())
    {
      ae.w("MicroMsg.JsApiShowToast", "service is not running");
      AppMethodBeat.o(138272);
      return;
    }
    View localView;
    Object localObject;
    label203:
    ImageView localImageView;
    if (this.liB)
    {
      localView = LayoutInflater.from(this.crB.getContext()).inflate(2131493060, (ViewGroup)this.crB.kfr, false);
      if (this.liD) {
        new a(localView);
      }
      localObject = (TextView)localView.findViewById(2131305902);
      int i = a.fromDPToPix(((TextView)localObject).getContext(), 18);
      if (bu.isNullOrNil(this.cZw)) {
        break label390;
      }
      ((TextView)localObject).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject).setSpannableFactory(new d.2.2(this, i));
      ((TextView)localObject).setText(this.cZw, TextView.BufferType.SPANNABLE);
      ((TextView)localObject).setVisibility(0);
      if (!this.liB) {
        localView.findViewById(2131304793).setPadding(0, a.fromDPToPix(((TextView)localObject).getContext(), 27), 0, 0);
      }
      if (!this.liB)
      {
        localImageView = (ImageView)localView.findViewById(2131301215);
        localObject = (ProgressBar)localView.findViewById(2131303515);
        if (!this.liE.equals("loading")) {
          break label399;
        }
        localImageView.setVisibility(8);
        ((ProgressBar)localObject).setVisibility(0);
      }
    }
    label515:
    for (;;)
    {
      this.crB.mgu.bGu();
      this.crB.mgu.dt(localView);
      this.liA.jnx = new aw(Looper.getMainLooper(), new d.2.1(this, localView), false);
      localObject = this.liA.jnx;
      long l = this.liC;
      ((aw)localObject).ay(l, l);
      this.cjR.h(this.cjS, this.liA.e("ok", null));
      AppMethodBeat.o(138272);
      return;
      localView = LayoutInflater.from(this.crB.getContext()).inflate(2131493061, (ViewGroup)this.crB.kfr, false);
      break;
      label390:
      ((TextView)localObject).setVisibility(4);
      break label203;
      label399:
      localImageView.setVisibility(0);
      ((ProgressBar)localObject).setVisibility(8);
      if (!bu.isNullOrNil(this.liF))
      {
        localObject = w.k(this.cjR.getRuntime(), this.liF);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label511;
        }
        localObject = new BitmapDrawable(localImageView.getResources(), (Bitmap)localObject);
      }
      for (;;)
      {
        if (localObject == null) {
          break label515;
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        break;
        localObject = this.cjR.getContext().getResources().getDrawable(2131231021);
        continue;
        label511:
        localObject = null;
      }
    }
  }
  
  final class a
    implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
  {
    View bJG;
    TouchDelegate liI;
    View liJ;
    
    a(View paramView)
    {
      AppMethodBeat.i(138266);
      paramView.addOnAttachStateChangeListener(this);
      paramView.setOnTouchListener(new d.2.a.1(this, d.2.this));
      this.liJ = paramView;
      AppMethodBeat.o(138266);
    }
    
    private void bmW()
    {
      AppMethodBeat.i(138270);
      if ((this.bJG != null) && (t.aC(this.liJ)))
      {
        Object localObject = new Rect(0, 0, this.bJG.getWidth(), this.bJG.getHeight());
        View localView = this.bJG;
        localObject = new TouchDelegate((Rect)localObject, this.liJ);
        this.liI = ((TouchDelegate)localObject);
        localView.setTouchDelegate((TouchDelegate)localObject);
      }
      AppMethodBeat.o(138270);
    }
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(138269);
      bmW();
      AppMethodBeat.o(138269);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(138267);
      this.bJG = ((View)paramView.getParent());
      bmW();
      this.bJG.addOnLayoutChangeListener(this);
      AppMethodBeat.o(138267);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(138268);
      if ((this.bJG != null) && (this.bJG.getTouchDelegate() == this.liI)) {
        this.bJG.setTouchDelegate(null);
      }
      if (this.bJG != null) {
        this.bJG.removeOnLayoutChangeListener(this);
      }
      AppMethodBeat.o(138268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d.2
 * JD-Core Version:    0.7.0.1
 */