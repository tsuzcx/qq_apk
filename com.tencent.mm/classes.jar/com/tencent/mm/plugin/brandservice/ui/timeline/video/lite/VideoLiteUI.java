package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.g.b.p;
import d.l;

@a(32)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private String mLb;
  private AppBrandVideoView mLc;
  private VideoLiteControBar owx;
  private ImageView owy;
  
  public final int getLayoutId()
  {
    return 2131496368;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(209145);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.owx;
    if (localVideoLiteControBar != null)
    {
      localVideoLiteControBar.f(paramConfiguration);
      AppMethodBeat.o(209145);
      return;
    }
    AppMethodBeat.o(209145);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(209143);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ow(true);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1284);
    this.mLb = getIntent().getStringExtra("rawUrl");
    this.owy = ((ImageView)findViewById(2131297935));
    paramBundle = this.owy;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    this.mLc = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.owx = new VideoLiteControBar((Context)this);
    Object localObject = this.owx;
    if (localObject == null) {
      p.gkB();
    }
    ((VideoLiteControBar)localObject).setBtnCloseListener((View.OnClickListener)new VideoLiteUI.a(this));
    localObject = this.owx;
    if (localObject == null) {
      p.gkB();
    }
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener((VideoLiteControBar.a)new VideoLiteUI.b(this));
    localObject = this.mLc;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((e.a)this.owx);
    }
    paramBundle.setVideoFooterView((e.b)this.owx);
    paramBundle = (FrameLayout)findViewById(2131298740);
    if (paramBundle != null) {
      paramBundle.addView((View)this.mLc, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.owy;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new VideoLiteUI.c(this));
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null) {
      paramBundle.gP(true);
    }
    paramBundle = this.mLc;
    if (paramBundle != null)
    {
      paramBundle.e(this.mLb, false, 0);
      AppMethodBeat.o(209143);
      return;
    }
    AppMethodBeat.o(209143);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(209148);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.mLc;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(209148);
      return;
    }
    AppMethodBeat.o(209148);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(209147);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.mLc;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.tt(3);
      AppMethodBeat.o(209147);
      return;
    }
    AppMethodBeat.o(209147);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(209146);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.mLc;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(209146);
      return;
    }
    AppMethodBeat.o(209146);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(209144);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1284);
    AppMethodBeat.o(209144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */