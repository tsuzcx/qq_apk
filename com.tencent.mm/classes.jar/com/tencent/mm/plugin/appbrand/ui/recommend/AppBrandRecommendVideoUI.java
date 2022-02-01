package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@a(19)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandRecommendVideoUI
  extends MMActivity
{
  public static final a rhI;
  private HashMap _$_findViewCache;
  private CommonVideoView rhH;
  public String videoUrl;
  
  static
  {
    AppMethodBeat.i(51387);
    rhI = new a((byte)0);
    AppMethodBeat.o(51387);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(276079);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(276079);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(276078);
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
    AppMethodBeat.o(276078);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(51385);
    CommonVideoView localCommonVideoView = this.rhH;
    if (localCommonVideoView == null) {
      p.bGy("videoView");
    }
    if (localCommonVideoView.isPlaying())
    {
      localCommonVideoView = this.rhH;
      if (localCommonVideoView == null) {
        p.bGy("videoView");
      }
      localCommonVideoView.pause();
    }
    super.finish();
    AppMethodBeat.o(51385);
  }
  
  public final int getLayoutId()
  {
    return au.g.app_brand_recommend_video;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51384);
    super.onCreate(paramBundle);
    hideTitleView();
    getWindow().setFlags(1024, 1024);
    paramBundle = findViewById(au.f.app_brand_recommend_player);
    p.j(paramBundle, "findViewById(R.id.app_brand_recommend_player)");
    this.rhH = ((CommonVideoView)paramBundle);
    paramBundle = getIntent().getStringExtra("1");
    p.j(paramBundle, "intent.getStringExtra(KEY_VIDEO_URL)");
    this.videoUrl = paramBundle;
    paramBundle = this.rhH;
    if (paramBundle == null) {
      p.bGy("videoView");
    }
    String str = this.videoUrl;
    if (str == null) {
      p.bGy("videoUrl");
    }
    paramBundle.c(true, str, 1000);
    paramBundle = this.rhH;
    if (paramBundle == null) {
      p.bGy("videoView");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendVideoUI$Companion;", "", "()V", "KEY_VIDEO_URL", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendVideoUI
 * JD-Core Version:    0.7.0.1
 */