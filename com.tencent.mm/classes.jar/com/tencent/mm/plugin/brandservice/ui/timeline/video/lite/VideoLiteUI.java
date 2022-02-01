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
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private String mFX;
  private AppBrandVideoView mFY;
  private VideoLiteControBar oqb;
  private ImageView oqc;
  
  public final int getLayoutId()
  {
    return 2131496368;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(210111);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.oqb;
    if (localVideoLiteControBar != null)
    {
      localVideoLiteControBar.f(paramConfiguration);
      AppMethodBeat.o(210111);
      return;
    }
    AppMethodBeat.o(210111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210109);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.or(true);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1284);
    this.mFX = getIntent().getStringExtra("rawUrl");
    this.oqc = ((ImageView)findViewById(2131297935));
    paramBundle = this.oqc;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    this.mFY = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.oqb = new VideoLiteControBar((Context)this);
    Object localObject = this.oqb;
    if (localObject == null) {
      p.gfZ();
    }
    ((VideoLiteControBar)localObject).setBtnCloseListener((View.OnClickListener)new VideoLiteUI.a(this));
    localObject = this.oqb;
    if (localObject == null) {
      p.gfZ();
    }
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener((VideoLiteControBar.a)new VideoLiteUI.b(this));
    localObject = this.mFY;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((e.a)this.oqb);
    }
    paramBundle.setVideoFooterView((e.b)this.oqb);
    paramBundle = (FrameLayout)findViewById(2131298740);
    if (paramBundle != null) {
      paramBundle.addView((View)this.mFY, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.oqc;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new VideoLiteUI.c(this));
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null) {
      paramBundle.gP(true);
    }
    paramBundle = this.mFY;
    if (paramBundle != null)
    {
      paramBundle.e(this.mFX, false, 0);
      AppMethodBeat.o(210109);
      return;
    }
    AppMethodBeat.o(210109);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(210114);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(210114);
      return;
    }
    AppMethodBeat.o(210114);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(210113);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.tp(3);
      AppMethodBeat.o(210113);
      return;
    }
    AppMethodBeat.o(210113);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(210112);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(210112);
      return;
    }
    AppMethodBeat.o(210112);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(210110);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1284);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(210110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */