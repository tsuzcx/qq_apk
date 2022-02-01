package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private HashMap _$_findViewCache;
  private String nYm;
  private AppBrandVideoView nYn;
  private VideoLiteControBar pKb;
  private ImageView pKc;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195971);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195971);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195970);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(195970);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496799;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(195966);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.pKb;
    if (localVideoLiteControBar != null)
    {
      localVideoLiteControBar.e(paramConfiguration);
      AppMethodBeat.o(195966);
      return;
    }
    AppMethodBeat.o(195966);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195964);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.rb(true);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1284);
    this.nYm = getIntent().getStringExtra("rawUrl");
    this.pKc = ((ImageView)findViewById(2131298258));
    paramBundle = this.pKc;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    paramBundle.setMyVideoViewFactory((com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.f.mFb);
    this.nYn = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.pKb = new VideoLiteControBar((Context)this);
    Object localObject = this.pKb;
    if (localObject == null) {
      p.hyc();
    }
    ((VideoLiteControBar)localObject).setBtnCloseListener((View.OnClickListener)new VideoLiteUI.a(this));
    localObject = this.pKb;
    if (localObject == null) {
      p.hyc();
    }
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener((VideoLiteControBar.a)new VideoLiteUI.b(this));
    localObject = this.nYn;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((e.a)this.pKb);
    }
    paramBundle.setVideoFooterView((e.b)this.pKb);
    paramBundle = (FrameLayout)findViewById(2131299181);
    if (paramBundle != null) {
      paramBundle.addView((View)this.nYn, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.pKc;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new VideoLiteUI.c(this));
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null) {
      paramBundle.hM(true);
    }
    paramBundle = this.nYn;
    if (paramBundle != null)
    {
      paramBundle.e(this.nYm, false, 0);
      AppMethodBeat.o(195964);
      return;
    }
    AppMethodBeat.o(195964);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195969);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.nYn;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(195969);
      return;
    }
    AppMethodBeat.o(195969);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(195968);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.nYn;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.xr(3);
      AppMethodBeat.o(195968);
      return;
    }
    AppMethodBeat.o(195968);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195967);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.nYn;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(195967);
      return;
    }
    AppMethodBeat.o(195967);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(195965);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1284);
    AppMethodBeat.o(195965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */