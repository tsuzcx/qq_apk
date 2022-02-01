package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(19)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandRecommendVideoUI
  extends MMActivity
{
  public static final AppBrandRecommendVideoUI.a upB;
  private CommonVideoView upC;
  public String videoUrl;
  
  static
  {
    AppMethodBeat.i(51387);
    upB = new AppBrandRecommendVideoUI.a((byte)0);
    AppMethodBeat.o(51387);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    Object localObject2 = null;
    AppMethodBeat.i(51385);
    CommonVideoView localCommonVideoView = this.upC;
    Object localObject1 = localCommonVideoView;
    if (localCommonVideoView == null)
    {
      s.bIx("videoView");
      localObject1 = null;
    }
    if (((CommonVideoView)localObject1).isPlaying())
    {
      localObject1 = this.upC;
      if (localObject1 != null) {
        break label63;
      }
      s.bIx("videoView");
      localObject1 = localObject2;
    }
    label63:
    for (;;)
    {
      ((CommonVideoView)localObject1).pause();
      super.finish();
      AppMethodBeat.o(51385);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_recommend_video;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(51384);
    super.onCreate(paramBundle);
    hideTitleView();
    getWindow().setFlags(1024, 1024);
    paramBundle = findViewById(ba.f.app_brand_recommend_player);
    s.s(paramBundle, "findViewById(R.id.app_brand_recommend_player)");
    this.upC = ((CommonVideoView)paramBundle);
    paramBundle = getIntent().getStringExtra("1");
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "intent.getStringExtra(KEY_VIDEO_URL)!!");
    s.u(paramBundle, "<set-?>");
    this.videoUrl = paramBundle;
    Object localObject1 = this.upC;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("videoView");
      paramBundle = null;
    }
    localObject1 = this.videoUrl;
    if (localObject1 != null)
    {
      paramBundle.b(true, (String)localObject1, 1000);
      paramBundle = this.upC;
      if (paramBundle != null) {
        break label154;
      }
      s.bIx("videoView");
      paramBundle = localObject2;
    }
    label154:
    for (;;)
    {
      paramBundle.start();
      AppMethodBeat.o(51384);
      return;
      s.bIx("videoUrl");
      localObject1 = null;
      break;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendVideoUI
 * JD-Core Version:    0.7.0.1
 */