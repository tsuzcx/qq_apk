package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
public final class MPVideoView$m
  implements l.b
{
  public final void aEX()
  {
    AppMethodBeat.i(153020);
    ab.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
    if ((MPVideoView.b(this.kjR)) && (!MPVideoView.c(this.kjR)))
    {
      localObject = MPVideoView.d(this.kjR);
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoViewControlBar)localObject).aFo();
    }
    Object localObject = MPVideoView.e(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    if ((((View)localObject).getVisibility() != 0) && (MPVideoView.f(this.kjR))) {
      MPVideoView.g(this.kjR);
    }
    AppMethodBeat.o(153020);
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(153021);
    ab.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
    if (MPVideoView.h(this.kjR))
    {
      MPVideoWrapper localMPVideoWrapper = MPVideoView.i(this.kjR);
      if (localMPVideoWrapper == null) {
        j.ebi();
      }
      if (localMPVideoWrapper.isPlaying())
      {
        this.kjR.pause();
        AppMethodBeat.o(153021);
        return;
      }
      this.kjR.start();
    }
    AppMethodBeat.o(153021);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(153022);
    if (!MPVideoView.j(this.kjR))
    {
      AppMethodBeat.o(153022);
      return;
    }
    TextView localTextView = MPVideoView.k(this.kjR);
    if (localTextView == null) {
      j.ebi();
    }
    localTextView.setVisibility(0);
    MPVideoView.g(this.kjR);
    AppMethodBeat.o(153022);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(153028);
    if (!MPVideoView.r(this.kjR))
    {
      AppMethodBeat.o(153028);
      return;
    }
    LinearLayout localLinearLayout = MPVideoView.q(this.kjR);
    if (localLinearLayout == null) {
      j.ebi();
    }
    localLinearLayout.setVisibility(8);
    MPVideoView.l(this.kjR);
    AppMethodBeat.o(153028);
  }
  
  public final void aFb()
  {
    AppMethodBeat.i(153029);
    if (!MPVideoView.r(this.kjR))
    {
      AppMethodBeat.o(153029);
      return;
    }
    LinearLayout localLinearLayout = MPVideoView.q(this.kjR);
    if (localLinearLayout == null) {
      j.ebi();
    }
    localLinearLayout.setVisibility(8);
    MPVideoView.l(this.kjR);
    AppMethodBeat.o(153029);
  }
  
  public final boolean aFc()
  {
    AppMethodBeat.i(156913);
    boolean bool = MPVideoView.r(this.kjR);
    AppMethodBeat.o(156913);
    return bool;
  }
  
  public final boolean aFd()
  {
    AppMethodBeat.i(156914);
    boolean bool = MPVideoView.r(this.kjR);
    AppMethodBeat.o(156914);
    return bool;
  }
  
  public final boolean aFe()
  {
    AppMethodBeat.i(153032);
    boolean bool = MPVideoView.j(this.kjR);
    AppMethodBeat.o(153032);
    return bool;
  }
  
  public final void aw(float paramFloat)
  {
    AppMethodBeat.i(153026);
    if (!MPVideoView.r(this.kjR))
    {
      AppMethodBeat.o(153026);
      return;
    }
    ab.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
    Object localObject = MPVideoView.n(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
    localObject = MPVideoView.o(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((TextView)localObject).setText(2131301354);
    localObject = MPVideoView.p(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((ImageView)localObject).setImageResource(2130837788);
    localObject = MPVideoView.q(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((LinearLayout)localObject).setVisibility(0);
    MPVideoView.g(this.kjR);
    AppMethodBeat.o(153026);
  }
  
  public final void ax(float paramFloat)
  {
    AppMethodBeat.i(153027);
    if (!MPVideoView.r(this.kjR))
    {
      AppMethodBeat.o(153027);
      return;
    }
    ab.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
    Object localObject = MPVideoView.n(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
    localObject = MPVideoView.o(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((TextView)localObject).setText(2131301353);
    localObject = MPVideoView.p(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((ImageView)localObject).setImageResource(2130837780);
    localObject = MPVideoView.q(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((LinearLayout)localObject).setVisibility(0);
    MPVideoView.g(this.kjR);
    AppMethodBeat.o(153027);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(153025);
    MPVideoWrapper localMPVideoWrapper = MPVideoView.i(this.kjR);
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(153025);
    return i;
  }
  
  public final int h(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(153023);
    if (!MPVideoView.j(this.kjR))
    {
      AppMethodBeat.o(153023);
      return 0;
    }
    ab.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
    Object localObject = MPVideoView.i(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    paramInt = ((MPVideoWrapper)localObject).getVideoDurationSec();
    int i = b.c(paramFloat, this.kjR.getMeasuredWidth(), getCurrentPosition(), paramInt);
    localObject = m.ha(paramInt * 1000L);
    TextView localTextView = MPVideoView.k(this.kjR);
    if (localTextView == null) {
      j.ebi();
    }
    localTextView.setText((CharSequence)(m.ha(i * 1000L) + "/" + (String)localObject));
    localObject = MPVideoView.d(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoViewControlBar)localObject).seek(i);
    localObject = MPVideoView.d(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    if (((MPVideoViewControlBar)localObject).Pk())
    {
      localObject = MPVideoView.d(this.kjR);
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoViewControlBar)localObject).aFn();
    }
    AppMethodBeat.o(153023);
    return i;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(153024);
    if (!MPVideoView.j(this.kjR))
    {
      AppMethodBeat.o(153024);
      return;
    }
    Object localObject = MPVideoView.k(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    ((TextView)localObject).setVisibility(8);
    MPVideoView.l(this.kjR);
    localObject = MPVideoView.i(this.kjR);
    if (localObject == null) {
      j.ebi();
    }
    int i = ((MPVideoWrapper)localObject).getCurrPosSec();
    ab.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
    MPVideoView.a(this.kjR, paramInt);
    localObject = MPVideoView.m(this.kjR);
    if (localObject != null)
    {
      ((MPVideoView.c)localObject).aZD();
      AppMethodBeat.o(153024);
      return;
    }
    AppMethodBeat.o(153024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.m
 * JD-Core Version:    0.7.0.1
 */