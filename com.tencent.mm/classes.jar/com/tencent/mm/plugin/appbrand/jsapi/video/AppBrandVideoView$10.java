package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandVideoView$10
  implements l.b
{
  AppBrandVideoView$10(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void aEX()
  {
    AppMethodBeat.i(126452);
    ab.d("MicroMsg.AppBrandVideoView", "onSingleTap");
    if ((AppBrandVideoView.f(this.icX)) && (AppBrandVideoView.g(this.icX).getVisibility() != 0))
    {
      AppBrandVideoView.h(this.icX).aFo();
      if (AppBrandVideoView.i(this.icX)) {
        AppBrandVideoView.j(this.icX);
      }
    }
    AppMethodBeat.o(126452);
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(126453);
    ab.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
    if (AppBrandVideoView.k(this.icX))
    {
      if (AppBrandVideoView.b(this.icX).isPlaying())
      {
        this.icX.pause();
        AppMethodBeat.o(126453);
        return;
      }
      this.icX.start();
    }
    AppMethodBeat.o(126453);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(126454);
    if (!AppBrandVideoView.l(this.icX))
    {
      AppMethodBeat.o(126454);
      return;
    }
    AppBrandVideoView.m(this.icX).setVisibility(0);
    AppBrandVideoView.j(this.icX);
    AppMethodBeat.o(126454);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(126460);
    if (!AppBrandVideoView.s(this.icX))
    {
      AppMethodBeat.o(126460);
      return;
    }
    AppBrandVideoView.r(this.icX).setVisibility(8);
    AppBrandVideoView.n(this.icX);
    AppMethodBeat.o(126460);
  }
  
  public final void aFb()
  {
    AppMethodBeat.i(126461);
    if (!AppBrandVideoView.s(this.icX))
    {
      AppMethodBeat.o(126461);
      return;
    }
    AppBrandVideoView.r(this.icX).setVisibility(8);
    AppBrandVideoView.n(this.icX);
    AppMethodBeat.o(126461);
  }
  
  public final boolean aFc()
  {
    AppMethodBeat.i(156829);
    boolean bool = AppBrandVideoView.s(this.icX);
    AppMethodBeat.o(156829);
    return bool;
  }
  
  public final boolean aFd()
  {
    AppMethodBeat.i(156830);
    boolean bool = AppBrandVideoView.s(this.icX);
    AppMethodBeat.o(156830);
    return bool;
  }
  
  public final boolean aFe()
  {
    AppMethodBeat.i(126464);
    boolean bool = AppBrandVideoView.l(this.icX);
    AppMethodBeat.o(126464);
    return bool;
  }
  
  public final void aw(float paramFloat)
  {
    AppMethodBeat.i(126458);
    if (!AppBrandVideoView.s(this.icX))
    {
      AppMethodBeat.o(126458);
      return;
    }
    ab.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramFloat)));
    AppBrandVideoView.o(this.icX).setPercent(paramFloat);
    AppBrandVideoView.p(this.icX).setText(2131301354);
    AppBrandVideoView.q(this.icX).setImageResource(2130837788);
    AppBrandVideoView.r(this.icX).setVisibility(0);
    AppBrandVideoView.j(this.icX);
    AppMethodBeat.o(126458);
  }
  
  public final void ax(float paramFloat)
  {
    AppMethodBeat.i(126459);
    if (!AppBrandVideoView.s(this.icX))
    {
      AppMethodBeat.o(126459);
      return;
    }
    ab.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
    AppBrandVideoView.o(this.icX).setPercent(paramFloat);
    AppBrandVideoView.p(this.icX).setText(2131301353);
    AppBrandVideoView.q(this.icX).setImageResource(2130837780);
    AppBrandVideoView.r(this.icX).setVisibility(0);
    AppBrandVideoView.j(this.icX);
    AppMethodBeat.o(126459);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(126457);
    int i = AppBrandVideoView.b(this.icX).getCurrPosSec();
    AppMethodBeat.o(126457);
    return i;
  }
  
  public final int h(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(126455);
    if (!AppBrandVideoView.l(this.icX))
    {
      AppMethodBeat.o(126455);
      return 0;
    }
    ab.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + paramInt + "/" + paramFloat);
    paramInt = AppBrandVideoView.b(this.icX).getVideoDurationSec();
    int i = b.c(paramFloat, this.icX.getMeasuredWidth(), getCurrentPosition(), paramInt);
    String str = m.ha(paramInt * 1000L);
    AppBrandVideoView.m(this.icX).setText(m.ha(i * 1000L) + "/" + str);
    AppBrandVideoView.h(this.icX).seek(i);
    if (AppBrandVideoView.h(this.icX).Pk()) {
      AppBrandVideoView.h(this.icX).aFn();
    }
    AppMethodBeat.o(126455);
    return i;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(126456);
    if (!AppBrandVideoView.l(this.icX))
    {
      AppMethodBeat.o(126456);
      return;
    }
    AppBrandVideoView.m(this.icX).setVisibility(8);
    AppBrandVideoView.n(this.icX);
    ab.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppBrandVideoView.b(this.icX).getCurrPosSec()), Float.valueOf(paramFloat) });
    this.icX.e(paramInt, false);
    AppMethodBeat.o(126456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.10
 * JD-Core Version:    0.7.0.1
 */