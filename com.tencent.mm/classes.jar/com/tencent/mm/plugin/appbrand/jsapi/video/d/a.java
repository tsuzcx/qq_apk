package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194413);
    int i = paramJSONObject.getInt("videoPlayerId");
    AppMethodBeat.o(194413);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194412);
    parame = parame.getContext();
    paramJSONObject = new AppBrandVideoViewControlBar(parame);
    Object localObject = new AppBrandVideoWrapper(parame);
    ((AppBrandVideoWrapper)localObject).setVideoFooterView(paramJSONObject);
    localObject = new AppBrandVideoView(parame, (View)localObject);
    ((AppBrandVideoView)localObject).a(paramJSONObject);
    parame = new CoverViewContainer(parame, (View)localObject);
    AppMethodBeat.o(194412);
    return parame;
  }
  
  public void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194414);
    ac.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).ax(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      ac.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
      AppMethodBeat.o(194414);
      return;
    }
    Object localObject1 = new a.1(this, localAppBrandVideoView);
    Object localObject2 = new a.2(this, localAppBrandVideoView);
    Object localObject3 = new a.3(this, parame, localAppBrandVideoView);
    Object localObject4 = new a.4(this, localAppBrandVideoView, parame, (f.d)localObject2, (f.b)localObject3);
    parame.a((f.d)localObject2);
    parame.a((f.b)localObject3);
    parame.a((f.c)localObject4);
    localAppBrandVideoView.setFullScreenDelegate(new a.5(this, parame, paramJSONObject.optBoolean("independent", false), paramInt, (bq)localObject1));
    localAppBrandVideoView.setContentDescription(paramView.getContext().getString(2131755291));
    localAppBrandVideoView.setMute(paramJSONObject.optBoolean("muted", false));
    boolean bool1 = paramJSONObject.optBoolean("needEvent", false);
    boolean bool2 = paramJSONObject.optBoolean("autoplay", false);
    ac.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    boolean bool3 = paramJSONObject.optBoolean("showDanmuBtn", false);
    boolean bool4 = paramJSONObject.optBoolean("enableDanmu", false);
    paramView = paramJSONObject.optJSONArray("danmuList");
    String str1 = paramJSONObject.optString("objectFit");
    String str2 = paramJSONObject.optString("poster");
    boolean bool5 = paramJSONObject.optBoolean("showBasicControls", true);
    String str3 = paramJSONObject.optString("data");
    paramInt = paramJSONObject.optInt("direction", -1);
    boolean bool6 = paramJSONObject.optBoolean("loop", false);
    boolean bool7 = paramJSONObject.optBoolean("pageGesture", false);
    boolean bool8 = paramJSONObject.optBoolean("pageGestureInFullscreen", true);
    double d = paramJSONObject.optDouble("initialTime", 0.0D);
    boolean bool9 = paramJSONObject.optBoolean("showProgress", true);
    boolean bool10 = paramJSONObject.optBoolean("showProgressInControlMode", true);
    boolean bool11 = paramJSONObject.optBoolean("showFullScreenBtn", true);
    boolean bool12 = paramJSONObject.optBoolean("showPlayBtn", true);
    boolean bool13 = paramJSONObject.optBoolean("showCenterPlayBtn", true);
    boolean bool14 = paramJSONObject.optBoolean("enableProgressGesture", true);
    localObject1 = paramJSONObject.optString("scene", "default");
    boolean bool15 = paramJSONObject.optBoolean("showMuteBtn", false);
    localObject2 = paramJSONObject.optString("title", "");
    boolean bool16 = paramJSONObject.optBoolean("showControlProgress", true);
    localObject3 = paramJSONObject.optString("playBtnPosition", "bottom");
    boolean bool17 = paramJSONObject.optBoolean("enablePlayGesture", false);
    boolean bool18 = paramJSONObject.optBoolean("autoPauseIfNavigate", true);
    boolean bool19 = paramJSONObject.optBoolean("autoPauseIfOpenNative", true);
    localObject4 = paramJSONObject.optString("backgroundColor");
    localAppBrandVideoView.setComponent(parame);
    localAppBrandVideoView.setCookieData(str3);
    localAppBrandVideoView.setIsShowBasicControls(bool5);
    localAppBrandVideoView.setCover$16da05f7(str2);
    localAppBrandVideoView.setFullScreenDirection(paramInt);
    localAppBrandVideoView.setObjectFit(str1);
    localAppBrandVideoView.setLoop(bool6);
    localAppBrandVideoView.setPageGesture(bool7);
    localAppBrandVideoView.setPageGestureInFullscreen(bool8);
    try
    {
      localAppBrandVideoView.setVideoPlayerId(A(paramJSONObject));
      localAppBrandVideoView.setAutoPlay(bool2);
      localAppBrandVideoView.setShowDanmakuBtn(bool3);
      localAppBrandVideoView.setDanmakuEnable(bool4);
      localAppBrandVideoView.setDanmakuItemList(paramView);
      localAppBrandVideoView.setInitialTime(d);
      localAppBrandVideoView.setShowControlProgress(bool16);
      localAppBrandVideoView.setShowProgress(bool9);
      localAppBrandVideoView.setShowProgressBarInControlMode(bool10);
      localAppBrandVideoView.setShowFullScreenBtn(bool11);
      localAppBrandVideoView.setShowPlayBtn(bool12);
      localAppBrandVideoView.setShowCenterPlayBtn(bool13);
      localAppBrandVideoView.gI(bool14);
      if (((String)localObject1).equalsIgnoreCase("default"))
      {
        localAppBrandVideoView.setVideoSource(0);
        localAppBrandVideoView.setShowMuteBtn(bool15);
        localAppBrandVideoView.setTitle((String)localObject2);
        localAppBrandVideoView.setPlayBtnPosition((String)localObject3);
        localAppBrandVideoView.setEnablePlayGesture(bool17);
        localAppBrandVideoView.setAutoPauseIfNavigate(bool18);
        localAppBrandVideoView.setAutoPauseIfOpenNative(bool19);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramInt = -16777216;
          if (!"transparent".equals(localObject4)) {
            break label862;
          }
          paramInt = 0;
          localAppBrandVideoView.setBackgroundColor(paramInt);
        }
        if (bool1) {
          localAppBrandVideoView.setCallback(new b(localAppBrandVideoView, parame));
        }
        paramInt = paramJSONObject.optInt("duration", -1);
        parame = paramJSONObject.optString("filePath");
        bool1 = paramJSONObject.optBoolean("live", false);
        ac.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[] { parame, Boolean.valueOf(bool1) });
        localAppBrandVideoView.e(parame, bool1, paramInt);
        AppMethodBeat.o(194414);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[] { localJSONException });
        continue;
        localAppBrandVideoView.setVideoSource(1);
        continue;
        try
        {
          label862:
          int i = Color.parseColor((String)localObject4);
          paramInt = i;
        }
        catch (IllegalArgumentException paramView) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a
 * JD-Core Version:    0.7.0.1
 */