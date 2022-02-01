package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.b.d.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230172);
    int i = paramJSONObject.getInt("videoPlayerId");
    AppMethodBeat.o(230172);
    return i;
  }
  
  public final View a(g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230168);
    paramg = paramg.getContext();
    AppBrandVideoViewControlBar localAppBrandVideoViewControlBar = new AppBrandVideoViewControlBar(paramg);
    AppBrandVideoWrapper localAppBrandVideoWrapper = new AppBrandVideoWrapper(paramg);
    localAppBrandVideoWrapper.setVideoFooterView(localAppBrandVideoViewControlBar);
    paramJSONObject = paramJSONObject.optString("playerHint");
    int j;
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      String[] arrayOfString = paramJSONObject.split(",");
      int m = arrayOfString.length;
      int k = 0;
      int i = 0;
      j = i;
      if (k < m)
      {
        String str = arrayOfString[k];
        if ("supportSoftDecode".equals(str.trim())) {
          j = i | 0x1;
        }
        for (;;)
        {
          k += 1;
          i = j;
          break;
          j = i;
          if ("mp4Only".equals(str.trim())) {
            j = i | 0x2;
          }
        }
      }
    }
    else
    {
      j = 0;
    }
    Log.i("MicroMsg.JsApiInsertVideoPlayer", "convertPlayerHint, playerHintStr: %s, playerHint: %d", new Object[] { paramJSONObject, Integer.valueOf(j) });
    localAppBrandVideoWrapper.setPlayerHint(j);
    paramJSONObject = new AppBrandVideoView(paramg, localAppBrandVideoWrapper);
    paramJSONObject.a(localAppBrandVideoViewControlBar);
    paramg = new CoverViewContainer(paramg, paramJSONObject);
    AppMethodBeat.o(230168);
    return paramg;
  }
  
  public void a(final g paramg, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(230178);
    Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    final AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).aA(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      Log.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
      AppMethodBeat.o(230178);
      return;
    }
    Object localObject1 = new bx()
    {
      public final void PS()
      {
        AppMethodBeat.i(228812);
        AppBrandVideoView localAppBrandVideoView = localAppBrandVideoView;
        Log.i("MicroMsg.Video.AppBrandVideoView", "onExitFullScreen");
        if (localAppBrandVideoView.pum.bVe()) {
          localAppBrandVideoView.pum.bSs();
        }
        localAppBrandVideoView.iD(false);
        AppMethodBeat.o(228812);
      }
    };
    Object localObject2 = new h.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(229364);
        localAppBrandVideoView.onUIResume();
        AppMethodBeat.o(229364);
      }
    };
    Object localObject3 = new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(230405);
        k.d locald = k.abM(paramg.getAppId());
        Log.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
        if (locald == k.d.nth)
        {
          localAppBrandVideoView.AO(2);
          AppMethodBeat.o(230405);
          return;
        }
        if (locald == k.d.ntd)
        {
          localAppBrandVideoView.AO(1);
          AppMethodBeat.o(230405);
          return;
        }
        localAppBrandVideoView.AO(3);
        AppMethodBeat.o(230405);
      }
    };
    Object localObject4 = new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(230597);
        localAppBrandVideoView.onUIDestroy();
        paramg.b(this.oVE);
        paramg.b(this.oVD);
        paramg.b(this);
        AppMethodBeat.o(230597);
      }
    };
    paramg.a((h.d)localObject2);
    paramg.a((h.b)localObject3);
    paramg.a((h.c)localObject4);
    localAppBrandVideoView.setFullScreenDelegate(new AppBrandVideoView.a()
    {
      public final void Az(int paramAnonymousInt)
      {
        AppMethodBeat.i(230087);
        paramg.hl(this.oGm).a(paramInt, this.oVC, paramAnonymousInt);
        AppMethodBeat.o(230087);
      }
      
      public final boolean QT()
      {
        AppMethodBeat.i(230089);
        boolean bool = paramg.hl(this.oGm).zW(paramInt);
        AppMethodBeat.o(230089);
        return bool;
      }
      
      public final void bSs()
      {
        AppMethodBeat.i(230088);
        paramg.hl(this.oGm).zV(paramInt);
        AppMethodBeat.o(230088);
      }
    });
    localAppBrandVideoView.setContentDescription(paramView.getContext().getString(a.f.app_brand_accessibility_video_view));
    localAppBrandVideoView.setMute(paramJSONObject.optBoolean("muted", false));
    boolean bool1 = paramJSONObject.optBoolean("needEvent", false);
    boolean bool2 = paramJSONObject.optBoolean("autoplay", false);
    Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
    localAppBrandVideoView.setComponent(paramg);
    localAppBrandVideoView.setCookieData(str3);
    localAppBrandVideoView.setIsShowBasicControls(bool5);
    localAppBrandVideoView.aiL(str2);
    localAppBrandVideoView.setFullScreenDirection(paramInt);
    localAppBrandVideoView.setObjectFit(str1);
    localAppBrandVideoView.setLoop(bool6);
    localAppBrandVideoView.setPageGesture(bool7);
    localAppBrandVideoView.setPageGestureInFullscreen(bool8);
    try
    {
      localAppBrandVideoView.setVideoPlayerId(K(paramJSONObject));
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
      localAppBrandVideoView.iC(bool14);
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
            break label880;
          }
          paramInt = 0;
          localAppBrandVideoView.setBackgroundColor(paramInt);
        }
        if (bool1) {
          localAppBrandVideoView.setCallback(new com.tencent.mm.plugin.appbrand.jsapi.video.c.b(localAppBrandVideoView, paramg));
        }
        paramInt = paramJSONObject.optInt("duration", -1);
        paramg = paramJSONObject.optString("filePath");
        bool1 = paramJSONObject.optBoolean("live", false);
        Log.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[] { paramg, Boolean.valueOf(bool1) });
        localAppBrandVideoView.f(paramg, bool1, paramInt);
        AppMethodBeat.o(230178);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[] { localJSONException });
        continue;
        localAppBrandVideoView.setVideoSource(1);
        continue;
        try
        {
          label880:
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