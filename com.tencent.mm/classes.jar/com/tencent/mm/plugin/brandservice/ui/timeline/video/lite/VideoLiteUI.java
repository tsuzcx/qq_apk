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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.f;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.VideoLiteUI";
  private HashMap _$_findViewCache;
  private String qZW;
  private AppBrandVideoView qZX;
  private VideoLiteControBar sSN;
  private ImageView sSO;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(265469);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(265469);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(265468);
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
    AppMethodBeat.o(265468);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return d.f.suB;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(265464);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    VideoLiteControBar localVideoLiteControBar = this.sSN;
    if (localVideoLiteControBar != null)
    {
      localVideoLiteControBar.e(paramConfiguration);
      AppMethodBeat.o(265464);
      return;
    }
    AppMethodBeat.o(265464);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265462);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ue(true);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1284);
    this.qZW = getIntent().getStringExtra("rawUrl");
    this.sSO = ((ImageView)findViewById(d.e.center_play_btn));
    paramBundle = this.sSO;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new AppBrandVideoWrapper((Context)this);
    paramBundle.setMyVideoViewFactory((e)f.pEn);
    this.qZX = new AppBrandVideoView((Context)this, (View)paramBundle);
    this.sSN = new VideoLiteControBar((Context)this);
    Object localObject = this.sSN;
    if (localObject == null) {
      p.iCn();
    }
    ((VideoLiteControBar)localObject).setBtnCloseListener((View.OnClickListener)new VideoLiteUI.a(this));
    localObject = this.sSN;
    if (localObject == null) {
      p.iCn();
    }
    ((VideoLiteControBar)localObject).setOnPlayStatusChangeListener((VideoLiteControBar.a)new VideoLiteUI.b(this));
    localObject = this.qZX;
    if (localObject != null) {
      ((AppBrandVideoView)localObject).a((d.a)this.sSN);
    }
    paramBundle.setVideoFooterView((d.b)this.sSN);
    paramBundle = (FrameLayout)findViewById(d.e.contentFrameLayout);
    if (paramBundle != null) {
      paramBundle.addView((View)this.qZX, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramBundle = this.sSO;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new VideoLiteUI.c(this));
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setAutoPlay(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setLoop(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setMute(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setCookieData(null);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setObjectFit("contain");
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowDanmakuBtn(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowMuteBtn(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowPlayBtn(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowProgress(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowFullScreenBtn(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setIsShowBasicControls(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setIsEnableBottomProgressBar(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowCenterPlayBtn(false);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setShowControlProgress(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.setPageGesture(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null) {
      paramBundle.iC(true);
    }
    paramBundle = this.qZX;
    if (paramBundle != null)
    {
      paramBundle.f(this.qZW, false, 0);
      AppMethodBeat.o(265462);
      return;
    }
    AppMethodBeat.o(265462);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(265467);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.qZX;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(265467);
      return;
    }
    AppMethodBeat.o(265467);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(265466);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.qZX;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.AO(3);
      AppMethodBeat.o(265466);
      return;
    }
    AppMethodBeat.o(265466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265465);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.qZX;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(265465);
      return;
    }
    AppMethodBeat.o(265465);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(265463);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.j(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1284);
    AppMethodBeat.o(265463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI
 * JD-Core Version:    0.7.0.1
 */