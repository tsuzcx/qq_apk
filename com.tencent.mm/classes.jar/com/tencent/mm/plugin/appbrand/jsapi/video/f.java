package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends a
{
  private static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126556);
    parame = parame.getContext();
    parame = new CoverViewContainer(parame, AppBrandVideoView.aEL().cO(parame));
    AppMethodBeat.o(126556);
    return parame;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126558);
    ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).aa(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      ab.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
      AppMethodBeat.o(126558);
      return;
    }
    Object localObject1 = new f.1(this, localAppBrandVideoView);
    Object localObject2 = new f.2(this, localAppBrandVideoView);
    Object localObject3 = new f.3(this, parame, localAppBrandVideoView);
    Object localObject4 = new f.4(this, localAppBrandVideoView, parame, (f.d)localObject2, (f.b)localObject3);
    parame.a((f.d)localObject2);
    parame.a((f.b)localObject3);
    parame.a((f.c)localObject4);
    localAppBrandVideoView.setFullScreenDelegate(new f.5(this, parame, paramInt, (bc)localObject1));
    localAppBrandVideoView.setContentDescription(paramView.getContext().getString(2131296556));
    localAppBrandVideoView.setMute(paramJSONObject.optBoolean("muted", false));
    boolean bool1 = paramJSONObject.optBoolean("needEvent", false);
    boolean bool2 = paramJSONObject.optBoolean("autoplay", false);
    ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    boolean bool3 = paramJSONObject.optBoolean("showDanmuBtn", true);
    boolean bool4 = paramJSONObject.optBoolean("enableDanmu", false);
    paramView = paramJSONObject.optJSONArray("danmuList");
    localObject4 = paramJSONObject.optString("objectFit");
    String str1 = paramJSONObject.optString("poster");
    boolean bool5 = paramJSONObject.optBoolean("showBasicControls", true);
    String str2 = paramJSONObject.optString("data");
    paramInt = paramJSONObject.optInt("direction", -1);
    boolean bool6 = paramJSONObject.optBoolean("loop", false);
    boolean bool7 = paramJSONObject.optBoolean("pageGesture", false);
    boolean bool8 = paramJSONObject.optBoolean("pageGestureInFullscreen", true);
    double d = paramJSONObject.optDouble("initialTime", 0.0D);
    boolean bool9 = paramJSONObject.optBoolean("showProgress", true);
    boolean bool10 = paramJSONObject.optBoolean("showFullScreenBtn", true);
    boolean bool11 = paramJSONObject.optBoolean("showPlayBtn", true);
    boolean bool12 = paramJSONObject.optBoolean("showCenterPlayBtn", true);
    boolean bool13 = paramJSONObject.optBoolean("enableProgressGesture", true);
    localObject1 = paramJSONObject.optString("scene", "default");
    boolean bool14 = paramJSONObject.optBoolean("showMuteBtn", false);
    localObject2 = paramJSONObject.optString("title", "");
    boolean bool15 = paramJSONObject.optBoolean("showControlProgress", true);
    localObject3 = paramJSONObject.optString("playBtnPosition", "bottom");
    boolean bool16 = paramJSONObject.optBoolean("enablePlayGesture", false);
    boolean bool17 = paramJSONObject.optBoolean("autoPauseIfNavigate", true);
    boolean bool18 = paramJSONObject.optBoolean("autoPauseIfOpenNative", true);
    localAppBrandVideoView.setComponent(parame);
    localAppBrandVideoView.setCookieData(str2);
    localAppBrandVideoView.setIsShowBasicControls(bool5);
    localAppBrandVideoView.setCover$16da05f7(str1);
    localAppBrandVideoView.setFullScreenDirection(paramInt);
    localAppBrandVideoView.setObjectFit((String)localObject4);
    localAppBrandVideoView.setLoop(bool6);
    localAppBrandVideoView.setPageGesture(bool7);
    localAppBrandVideoView.setPageGestureInFullscreen(bool8);
    try
    {
      localAppBrandVideoView.setVideoPlayerId(w(paramJSONObject));
      localAppBrandVideoView.setAutoPlay(bool2);
      localAppBrandVideoView.setShowDanmakuBtn(bool3);
      localAppBrandVideoView.setDanmakuEnable(bool4);
      localAppBrandVideoView.setDanmakuItemList(paramView);
      localAppBrandVideoView.setInitialTime(d);
      localAppBrandVideoView.setShowControlProgress(bool15);
      localAppBrandVideoView.setShowProgress(bool9);
      localAppBrandVideoView.setShowFullScreenBtn(bool10);
      localAppBrandVideoView.setShowPlayBtn(bool11);
      localAppBrandVideoView.setShowCenterPlayBtn(bool12);
      localAppBrandVideoView.ex(bool13);
      if (((String)localObject1).equalsIgnoreCase("default"))
      {
        localAppBrandVideoView.setVideoSource(0);
        localAppBrandVideoView.setShowMuteBtn(bool14);
        localAppBrandVideoView.setTitle((String)localObject2);
        localAppBrandVideoView.setPlayBtnPosition((String)localObject3);
        localAppBrandVideoView.setEnablePlayGesture(bool16);
        localAppBrandVideoView.setAutoPauseIfNavigate(bool17);
        localAppBrandVideoView.setAutoPauseIfOpenNative(bool18);
        if (bool1) {
          localAppBrandVideoView.setCallback(new k(localAppBrandVideoView, parame));
        }
        paramInt = paramJSONObject.optInt("duration", -1);
        parame = paramJSONObject.optString("filePath");
        bool1 = paramJSONObject.optBoolean("live", false);
        ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[] { parame, Boolean.valueOf(bool1) });
        localAppBrandVideoView.f(parame, bool1, paramInt);
        AppMethodBeat.o(126558);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[] { localJSONException });
        continue;
        localAppBrandVideoView.setVideoSource(1);
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126557);
    int i = paramJSONObject.getInt("videoPlayerId");
    AppMethodBeat.o(126557);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f
 * JD-Core Version:    0.7.0.1
 */