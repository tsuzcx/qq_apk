package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends a
{
  private static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  
  protected final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    parame = parame.getContext();
    return new CoverViewContainer(parame, AppBrandVideoView.akc().cm(parame));
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, final View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (AppBrandVideoView)((CoverViewContainer)paramView).K(AppBrandVideoView.class);
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
      return;
    }
    Object localObject1 = new e.1(this, paramView);
    Object localObject2 = new e.2(this, paramView);
    Object localObject3 = new e.b()
    {
      public final void qa()
      {
        AppBrandVideoView localAppBrandVideoView = paramView;
        y.i("MicroMsg.AppBrandVideoView", "onUIPause");
        localAppBrandVideoView.gDj.Se();
      }
    };
    Object localObject4 = new e.4(this, paramView, parame, (e.d)localObject2, (e.b)localObject3);
    parame.a((e.d)localObject2);
    parame.a((e.b)localObject3);
    parame.a((e.c)localObject4);
    paramView.setFullScreenDelegate(new e.5(this, parame, paramInt, (aj)localObject1));
    paramView.setMute(paramJSONObject.optBoolean("muted", false));
    boolean bool1 = paramJSONObject.optBoolean("needEvent", false);
    boolean bool2 = paramJSONObject.optBoolean("autoplay", false);
    y.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    boolean bool3 = paramJSONObject.optBoolean("showDanmuBtn", true);
    boolean bool4 = paramJSONObject.optBoolean("enableDanmu", false);
    localObject1 = paramJSONObject.optJSONArray("danmuList");
    String str1 = paramJSONObject.optString("objectFit");
    String str2 = paramJSONObject.optString("poster");
    boolean bool5 = paramJSONObject.optBoolean("showBasicControls", true);
    String str3 = paramJSONObject.optString("data");
    paramInt = paramJSONObject.optInt("direction", 90);
    boolean bool6 = paramJSONObject.optBoolean("loop", false);
    boolean bool7 = paramJSONObject.optBoolean("pageGesture", false);
    int i = paramJSONObject.optInt("initialTime", 0);
    boolean bool8 = paramJSONObject.optBoolean("showProgress", true);
    boolean bool9 = paramJSONObject.optBoolean("showFullScreenBtn", true);
    boolean bool10 = paramJSONObject.optBoolean("showPlayBtn", true);
    boolean bool11 = paramJSONObject.optBoolean("showCenterPlayBtn", true);
    boolean bool12 = paramJSONObject.optBoolean("enableProgressGesture", true);
    localObject2 = paramJSONObject.optString("scene", "default");
    boolean bool13 = paramJSONObject.optBoolean("showMuteBtn", false);
    localObject3 = paramJSONObject.optString("title", "");
    boolean bool14 = paramJSONObject.optBoolean("showControlProgress", true);
    localObject4 = paramJSONObject.optString("playBtnPosition", "bottom");
    boolean bool15 = paramJSONObject.optBoolean("enablePlayGesture", false);
    paramView.setComponent(parame);
    paramView.setCookieData(str3);
    paramView.setIsShowBasicControls(bool5);
    paramView.setCover$16da05f7(str2);
    paramView.setFullScreenDirection(paramInt);
    paramView.setObjectFit(str1);
    paramView.setLoop(bool6);
    paramView.setPageGesture(bool7);
    try
    {
      paramView.setVideoPlayerId(p(paramJSONObject));
      paramView.setAutoPlay(bool2);
      paramView.setShowDanmakuBtn(bool3);
      paramView.setDanmakuEnable(bool4);
      paramView.setDanmakuItemList((JSONArray)localObject1);
      paramView.setInitialTime(i);
      paramView.setShowControlProgress(bool14);
      paramView.setShowProgress(bool8);
      paramView.setShowFullScreenBtn(bool9);
      paramView.setShowPlayBtn(bool10);
      paramView.setShowCenterPlayBtn(bool11);
      paramView.ds(bool12);
      if (((String)localObject2).equalsIgnoreCase("default"))
      {
        paramView.setVideoSource(0);
        paramView.setShowMuteBtn(bool13);
        paramView.setTitle((String)localObject3);
        paramView.setPlayBtnPosition((String)localObject4);
        paramView.setEnablePlayGesture(bool15);
        if (bool1) {
          paramView.setCallback(new j(paramView, parame));
        }
        paramInt = paramJSONObject.optInt("duration", -1);
        parame = paramJSONObject.optString("filePath");
        bool1 = paramJSONObject.optBoolean("live", false);
        y.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[] { parame, Boolean.valueOf(bool1) });
        paramView.e(parame, bool1, paramInt);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[] { localJSONException });
        continue;
        paramView.setVideoSource(1);
      }
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("videoPlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e
 * JD-Core Version:    0.7.0.1
 */