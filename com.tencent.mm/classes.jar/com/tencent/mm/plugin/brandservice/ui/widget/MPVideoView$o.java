package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
public final class MPVideoView$o
  implements a.b
{
  public final void aM(float paramFloat)
  {
    AppMethodBeat.i(7506);
    if (!MPVideoView.r(this.sVn))
    {
      AppMethodBeat.o(7506);
      return;
    }
    Log.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
    Object localObject = MPVideoView.n(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
    localObject = MPVideoView.o(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setText(d.i.luggage_app_brand_video_volume);
    localObject = MPVideoView.p(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((ImageView)localObject).setImageResource(d.d.app_brand_video_volume_icon);
    localObject = MPVideoView.q(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((LinearLayout)localObject).setVisibility(0);
    MPVideoView.f(this.sVn);
    AppMethodBeat.o(7506);
  }
  
  public final void aN(float paramFloat)
  {
    AppMethodBeat.i(7507);
    if (!MPVideoView.r(this.sVn))
    {
      AppMethodBeat.o(7507);
      return;
    }
    Log.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
    Object localObject = MPVideoView.n(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
    localObject = MPVideoView.o(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setText(d.i.luggage_app_brand_video_brightness);
    localObject = MPVideoView.p(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((ImageView)localObject).setImageResource(d.d.app_brand_video_brightness_icon);
    localObject = MPVideoView.q(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((LinearLayout)localObject).setVisibility(0);
    MPVideoView.f(this.sVn);
    AppMethodBeat.o(7507);
  }
  
  public final void bUS()
  {
    AppMethodBeat.i(7500);
    Log.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
    if ((MPVideoView.a(this.sVn)) && (!MPVideoView.b(this.sVn)))
    {
      localObject = MPVideoView.c(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((MPVideoViewControlBar)localObject).bVb();
    }
    Object localObject = MPVideoView.d(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.sVn))) {
      MPVideoView.f(this.sVn);
    }
    AppMethodBeat.o(7500);
  }
  
  public final void bUT()
  {
    AppMethodBeat.i(7501);
    Log.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
    if (MPVideoView.g(this.sVn))
    {
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
      if (localMPExoVideoWrapper == null) {
        p.iCn();
      }
      if (localMPExoVideoWrapper.isPlaying())
      {
        this.sVn.pause();
        AppMethodBeat.o(7501);
        return;
      }
      this.sVn.start();
    }
    AppMethodBeat.o(7501);
  }
  
  public final void bUU()
  {
    AppMethodBeat.i(7502);
    if (!MPVideoView.i(this.sVn))
    {
      AppMethodBeat.o(7502);
      return;
    }
    TextView localTextView = MPVideoView.j(this.sVn);
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setVisibility(0);
    MPVideoView.f(this.sVn);
    if (this.sVn.isPlaying()) {
      this.sVn.cEH();
    }
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7502);
  }
  
  public final void bUV()
  {
    AppMethodBeat.i(7508);
    if (!MPVideoView.r(this.sVn))
    {
      AppMethodBeat.o(7508);
      return;
    }
    LinearLayout localLinearLayout = MPVideoView.q(this.sVn);
    if (localLinearLayout == null) {
      p.iCn();
    }
    localLinearLayout.setVisibility(8);
    MPVideoView.l(this.sVn);
    AppMethodBeat.o(7508);
  }
  
  public final void bUW()
  {
    AppMethodBeat.i(7509);
    if (!MPVideoView.r(this.sVn))
    {
      AppMethodBeat.o(7509);
      return;
    }
    LinearLayout localLinearLayout = MPVideoView.q(this.sVn);
    if (localLinearLayout == null) {
      p.iCn();
    }
    localLinearLayout.setVisibility(8);
    MPVideoView.l(this.sVn);
    AppMethodBeat.o(7509);
  }
  
  public final boolean bUX()
  {
    AppMethodBeat.i(293039);
    boolean bool = MPVideoView.r(this.sVn);
    AppMethodBeat.o(293039);
    return bool;
  }
  
  public final boolean bUY()
  {
    AppMethodBeat.i(293040);
    boolean bool = MPVideoView.r(this.sVn);
    AppMethodBeat.o(293040);
    return bool;
  }
  
  public final boolean bUZ()
  {
    AppMethodBeat.i(7512);
    boolean bool = MPVideoView.i(this.sVn);
    AppMethodBeat.o(7512);
    return bool;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(7505);
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7505);
    return i;
  }
  
  public final int l(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(7503);
    if (!MPVideoView.i(this.sVn))
    {
      AppMethodBeat.o(7503);
      return 0;
    }
    Log.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
    Object localObject = MPVideoView.h(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
    int i = a.c(paramFloat, this.sVn.getMeasuredWidth(), getCurrentPosition(), paramInt);
    localObject = k.GN(paramInt * 1000L);
    TextView localTextView = MPVideoView.j(this.sVn);
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setText((CharSequence)(k.GN(i * 1000L) + "/" + (String)localObject));
    localObject = MPVideoView.c(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((MPVideoViewControlBar)localObject).seek(i);
    localObject = MPVideoView.c(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    if (((MPVideoViewControlBar)localObject).bVd())
    {
      localObject = MPVideoView.c(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((MPVideoViewControlBar)localObject).bVi();
    }
    AppMethodBeat.o(7503);
    return i;
  }
  
  public final void m(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(7504);
    if (!MPVideoView.i(this.sVn))
    {
      AppMethodBeat.o(7504);
      return;
    }
    Object localObject = MPVideoView.j(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setVisibility(8);
    MPVideoView.l(this.sVn);
    localObject = MPVideoView.h(this.sVn);
    if (localObject == null) {
      p.iCn();
    }
    int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
    Log.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
    MPVideoView.a(this.sVn, paramInt * 1000);
    MPVideoView.m(this.sVn);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.o
 * JD-Core Version:    0.7.0.1
 */