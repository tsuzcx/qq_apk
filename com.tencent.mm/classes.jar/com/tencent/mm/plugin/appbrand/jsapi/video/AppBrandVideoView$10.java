package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.c.a.a.b;
import com.tencent.luggage.c.a.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandVideoView$10
  implements k.b
{
  AppBrandVideoView$10(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void ah(float paramFloat)
  {
    if (!AppBrandVideoView.s(this.gDS)) {
      return;
    }
    y.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:" + paramFloat);
    AppBrandVideoView.o(this.gDS).setPercent(paramFloat);
    AppBrandVideoView.p(this.gDS).setText(a.e.luggage_app_brand_video_volume);
    AppBrandVideoView.q(this.gDS).setImageResource(a.b.app_brand_video_volume_icon);
    AppBrandVideoView.r(this.gDS).setVisibility(0);
    AppBrandVideoView.j(this.gDS);
  }
  
  public final void ai(float paramFloat)
  {
    if (!AppBrandVideoView.s(this.gDS)) {
      return;
    }
    y.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:" + paramFloat);
    AppBrandVideoView.o(this.gDS).setPercent(paramFloat);
    AppBrandVideoView.p(this.gDS).setText(a.e.luggage_app_brand_video_brightness);
    AppBrandVideoView.q(this.gDS).setImageResource(a.b.app_brand_video_brightness_icon);
    AppBrandVideoView.r(this.gDS).setVisibility(0);
    AppBrandVideoView.j(this.gDS);
  }
  
  public final void akl()
  {
    y.d("MicroMsg.AppBrandVideoView", "onSingleTap");
    if ((AppBrandVideoView.f(this.gDS)) && (AppBrandVideoView.g(this.gDS).getVisibility() != 0))
    {
      AppBrandVideoView.h(this.gDS).akI();
      if (AppBrandVideoView.i(this.gDS)) {
        AppBrandVideoView.j(this.gDS);
      }
    }
  }
  
  public final void akm()
  {
    y.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
    if (AppBrandVideoView.k(this.gDS))
    {
      if (AppBrandVideoView.b(this.gDS).isPlaying()) {
        this.gDS.pause();
      }
    }
    else {
      return;
    }
    this.gDS.start();
  }
  
  public final void akn()
  {
    if (!AppBrandVideoView.l(this.gDS)) {
      return;
    }
    AppBrandVideoView.m(this.gDS).setVisibility(0);
    AppBrandVideoView.j(this.gDS);
  }
  
  public final void ako()
  {
    if (!AppBrandVideoView.s(this.gDS)) {
      return;
    }
    AppBrandVideoView.r(this.gDS).setVisibility(8);
    AppBrandVideoView.n(this.gDS);
  }
  
  public final void akp()
  {
    if (!AppBrandVideoView.s(this.gDS)) {
      return;
    }
    AppBrandVideoView.r(this.gDS).setVisibility(8);
    AppBrandVideoView.n(this.gDS);
  }
  
  public final boolean akq()
  {
    return AppBrandVideoView.s(this.gDS);
  }
  
  public final boolean akr()
  {
    return AppBrandVideoView.s(this.gDS);
  }
  
  public final boolean aks()
  {
    return AppBrandVideoView.l(this.gDS);
  }
  
  public final int f(int paramInt, float paramFloat)
  {
    int k = 180;
    int j = 0;
    int i = 0;
    if (!AppBrandVideoView.l(this.gDS)) {
      return i;
    }
    y.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + paramInt + "/" + paramFloat);
    i = AppBrandVideoView.b(this.gDS).getVideoDurationSec();
    float f = this.gDS.getMeasuredWidth();
    int m = getCurrentPosition();
    paramFloat /= f;
    if (i <= 180)
    {
      paramInt = i;
      label98:
      paramInt = (int)(paramInt * paramFloat) + m;
      if (paramInt >= 0) {
        break label246;
      }
      paramInt = j;
    }
    for (;;)
    {
      String str = l.ce(i * 1000L);
      AppBrandVideoView.m(this.gDS).setText(l.ce(paramInt * 1000L) + "/" + str);
      AppBrandVideoView.h(this.gDS).seek(paramInt);
      i = paramInt;
      if (!AppBrandVideoView.h(this.gDS).akH()) {
        break;
      }
      AppBrandVideoView.h(this.gDS).akG();
      return paramInt;
      paramInt = k;
      if (i <= 600) {
        break label98;
      }
      if (i <= 1800)
      {
        paramInt = 300;
        break label98;
      }
      paramInt = 600;
      break label98;
      label246:
      if (paramInt > i) {
        paramInt = i;
      }
    }
  }
  
  public final void g(int paramInt, float paramFloat)
  {
    if (!AppBrandVideoView.l(this.gDS)) {
      return;
    }
    AppBrandVideoView.m(this.gDS).setVisibility(8);
    AppBrandVideoView.n(this.gDS);
    y.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppBrandVideoView.b(this.gDS).getCurrPosSec()), Float.valueOf(paramFloat) });
    this.gDS.D(paramInt, false);
  }
  
  public final int getCurrentPosition()
  {
    return AppBrandVideoView.b(this.gDS).getCurrPosSec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.10
 * JD-Core Version:    0.7.0.1
 */