package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.g.b.k;
import d.l;

@a(19)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandRecommendVideoUI
  extends MMActivity
{
  public static final a mno;
  private CommonVideoView mnn;
  public String videoUrl;
  
  static
  {
    AppMethodBeat.i(51387);
    mno = new a((byte)0);
    AppMethodBeat.o(51387);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(51385);
    CommonVideoView localCommonVideoView = this.mnn;
    if (localCommonVideoView == null) {
      k.aVY("videoView");
    }
    if (localCommonVideoView.isPlaying())
    {
      localCommonVideoView = this.mnn;
      if (localCommonVideoView == null) {
        k.aVY("videoView");
      }
      localCommonVideoView.pause();
    }
    super.finish();
    AppMethodBeat.o(51385);
  }
  
  public final int getLayoutId()
  {
    return 2131493049;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51384);
    super.onCreate(paramBundle);
    hideTitleView();
    getWindow().setFlags(1024, 1024);
    paramBundle = findViewById(2131296817);
    k.g(paramBundle, "findViewById(R.id.app_brand_recommend_player)");
    this.mnn = ((CommonVideoView)paramBundle);
    paramBundle = getIntent().getStringExtra("1");
    k.g(paramBundle, "intent.getStringExtra(KEY_VIDEO_URL)");
    this.videoUrl = paramBundle;
    paramBundle = this.mnn;
    if (paramBundle == null) {
      k.aVY("videoView");
    }
    String str = this.videoUrl;
    if (str == null) {
      k.aVY("videoUrl");
    }
    paramBundle.c(true, str, 1000);
    paramBundle = this.mnn;
    if (paramBundle == null) {
      k.aVY("videoView");
    }
    paramBundle.start();
    AppMethodBeat.o(51384);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51386);
    super.onPause();
    AppMethodBeat.o(51386);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI$Companion;", "", "()V", "KEY_VIDEO_URL", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendVideoUI
 * JD-Core Version:    0.7.0.1
 */