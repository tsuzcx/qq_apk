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
import d.g.b.k;
import d.l;

@a(32)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private String mfw;
  private AppBrandVideoView mfx;
  private VideoLiteControBar nNv;
  private ImageView nNw;
  
  public final int getLayoutId()
  {
    return 2131496368;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(199162);
    k.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.nNv;
    if (localVideoLiteControBar != null)
    {
      localVideoLiteControBar.f(paramConfiguration);
      AppMethodBeat.o(199162);
      return;
    }
    AppMethodBeat.o(199162);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199160);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.nX(true);
    paramBundle = getWindow();
    k.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    k.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    k.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1284);
    this.mfw = getIntent().getStringExtra("rawUrl");
    this.nNw = ((ImageView)findViewById(2131297935));
    paramBundle = this.nNw;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    this.mfx = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.nNv = new VideoLiteControBar((Context)this);
    Object localObject = this.nNv;
    if (localObject == null) {
      k.fOy();
    }
    ((VideoLiteControBar)localObject).setBtnCloseListener((View.OnClickListener)new a(this));
    localObject = this.nNv;
    if (localObject == null) {
      k.fOy();
    }
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener((VideoLiteControBar.a)new b(this));
    localObject = this.mfx;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((e.a)this.nNv);
    }
    paramBundle.setVideoFooterView((e.b)this.nNv);
    paramBundle = (FrameLayout)findViewById(2131298740);
    if (paramBundle != null) {
      paramBundle.addView((View)this.mfx, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.nNw;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null) {
      paramBundle.gI(true);
    }
    paramBundle = this.mfx;
    if (paramBundle != null)
    {
      paramBundle.e(this.mfw, false, 0);
      AppMethodBeat.o(199160);
      return;
    }
    AppMethodBeat.o(199160);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199165);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.mfx;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(199165);
      return;
    }
    AppMethodBeat.o(199165);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199164);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.mfx;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.sM(3);
      AppMethodBeat.o(199164);
      return;
    }
    AppMethodBeat.o(199164);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199163);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.mfx;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(199163);
      return;
    }
    AppMethodBeat.o(199163);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(199161);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    k.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    k.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1284);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(199161);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(VideoLiteUI paramVideoLiteUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199157);
      this.nNx.onBackPressed();
      AppMethodBeat.o(199157);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
  static final class b
    implements VideoLiteControBar.a
  {
    b(VideoLiteUI paramVideoLiteUI) {}
    
    public final void jf(boolean paramBoolean)
    {
      AppMethodBeat.i(199158);
      ImageView localImageView = VideoLiteUI.a(this.nNx);
      if (localImageView != null)
      {
        if (paramBoolean) {}
        for (int i = 8;; i = 0)
        {
          localImageView.setVisibility(i);
          AppMethodBeat.o(199158);
          return;
        }
      }
      AppMethodBeat.o(199158);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(VideoLiteUI paramVideoLiteUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199159);
      paramView = VideoLiteUI.b(this.nNx);
      if (paramView != null)
      {
        paramView.start();
        AppMethodBeat.o(199159);
        return;
      }
      AppMethodBeat.o(199159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */