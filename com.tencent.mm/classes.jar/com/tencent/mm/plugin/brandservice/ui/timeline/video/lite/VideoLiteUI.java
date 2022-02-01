package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.f;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private String ufS;
  private AppBrandVideoView ufT;
  private VideoLiteControBar vYe;
  private ImageView vYf;
  
  private static final void a(VideoLiteUI paramVideoLiteUI, View paramView)
  {
    AppMethodBeat.i(302116);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramVideoLiteUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramVideoLiteUI, "this$0");
    paramVideoLiteUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302116);
  }
  
  private static final void a(VideoLiteUI paramVideoLiteUI, boolean paramBoolean)
  {
    AppMethodBeat.i(302121);
    s.u(paramVideoLiteUI, "this$0");
    paramVideoLiteUI = paramVideoLiteUI.vYf;
    if (paramVideoLiteUI != null) {
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (int i = 8;; i = 0)
    {
      paramVideoLiteUI.setVisibility(i);
      AppMethodBeat.o(302121);
      return;
    }
  }
  
  private static final void b(VideoLiteUI paramVideoLiteUI, View paramView)
  {
    AppMethodBeat.i(302129);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramVideoLiteUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramVideoLiteUI, "this$0");
    paramVideoLiteUI = paramVideoLiteUI.ufT;
    if (paramVideoLiteUI != null) {
      paramVideoLiteUI.start();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302129);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return d.f.video_lite_ui;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(302175);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.vYe;
    if (localVideoLiteControBar != null)
    {
      if (paramConfiguration.orientation == 1)
      {
        paramConfiguration = (RelativeLayout.LayoutParams)localVideoLiteControBar.vYb.getLayoutParams();
        paramConfiguration.addRule(2, d.e.video_close_btn);
        paramConfiguration.removeRule(8);
        paramConfiguration.removeRule(1);
        paramConfiguration.setMargins(com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A), 0, com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A), 0);
        localVideoLiteControBar.vYb.setLayoutParams(paramConfiguration);
        ((RelativeLayout.LayoutParams)localVideoLiteControBar.vYa.getLayoutParams()).setMargins(com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A), com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A), 0, 0);
        ((RelativeLayout.LayoutParams)localVideoLiteControBar.lBX.getLayoutParams()).setMargins(0, 0, 0, com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_2A));
        AppMethodBeat.o(302175);
        return;
      }
      if (paramConfiguration.orientation == 2)
      {
        paramConfiguration = (RelativeLayout.LayoutParams)localVideoLiteControBar.vYb.getLayoutParams();
        paramConfiguration.removeRule(2);
        paramConfiguration.addRule(8, d.e.video_close_btn);
        paramConfiguration.addRule(1, d.e.video_close_btn);
        paramConfiguration.setMargins(com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_7A), 0, com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A), 0);
        localVideoLiteControBar.vYb.setLayoutParams(paramConfiguration);
        paramConfiguration = (RelativeLayout.LayoutParams)localVideoLiteControBar.vYa.getLayoutParams();
        int i = com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_3A);
        paramConfiguration.setMargins(i, com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_2A), 0, com.tencent.mm.cd.a.fromDPToPix(localVideoLiteControBar.getContext(), -5));
        int j = com.tencent.mm.cd.a.bs(localVideoLiteControBar.getContext(), d.c.Edge_5A);
        ((RelativeLayout.LayoutParams)localVideoLiteControBar.lBX.getLayoutParams()).setMargins(i, 0, 0, j);
      }
    }
    AppMethodBeat.o(302175);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(302163);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ys(true);
    getWindow().setNavigationBarColor(-16777216);
    getWindow().getDecorView().setSystemUiVisibility(1284);
    this.ufS = getIntent().getStringExtra("rawUrl");
    this.vYf = ((ImageView)findViewById(d.e.center_play_btn));
    paramBundle = this.vYf;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    paramBundle.setMyVideoViewFactory((e)f.sJy);
    this.ufT = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.vYe = new VideoLiteControBar((Context)this);
    Object localObject = this.vYe;
    s.checkNotNull(localObject);
    ((VideoLiteControBar)localObject).setBtnCloseListener(new VideoLiteUI..ExternalSyntheticLambda1(this));
    localObject = this.vYe;
    s.checkNotNull(localObject);
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener(new VideoLiteUI..ExternalSyntheticLambda2(this));
    localObject = this.ufT;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((d.a)this.vYe);
    }
    paramBundle.setVideoFooterView((d.b)this.vYe);
    paramBundle = (FrameLayout)findViewById(d.e.contentFrameLayout);
    if (paramBundle != null) {
      paramBundle.addView((View)this.ufT, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.vYf;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new VideoLiteUI..ExternalSyntheticLambda0(this));
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.jG(true);
    }
    paramBundle = this.ufT;
    if (paramBundle != null) {
      paramBundle.e(this.ufS, false, 0);
    }
    AppMethodBeat.o(302163);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(302205);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.onUIDestroy();
    }
    AppMethodBeat.o(302205);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(302195);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.Bd(3);
    }
    AppMethodBeat.o(302195);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(302186);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.onUIResume();
    }
    AppMethodBeat.o(302186);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(302169);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    getWindow().getDecorView().setSystemUiVisibility(1284);
    AppMethodBeat.o(302169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */