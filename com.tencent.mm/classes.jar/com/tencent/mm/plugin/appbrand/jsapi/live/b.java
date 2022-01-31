package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 364;
  public static final String NAME = "insertLivePlayer";
  
  protected final View a(e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = new AppBrandLivePlayerView(parame.getContext());
    parame = new CoverViewContainer(parame.getContext(), paramJSONObject);
    parame.setBackgroundColor(-16777216);
    return parame;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      if (!(paramc.getContext() instanceof Activity))
      {
        y.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
        paramc.C(paramInt, h("fail", null));
        return;
      }
      Activity localActivity = (Activity)paramc.getContext();
      try
      {
        int i = android.support.v4.content.b.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
        if (i == 0)
        {
          super.a(paramc, paramJSONObject, paramInt);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        y.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
        paramc.C(paramInt, h("fail", null));
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:system permission denied", paramJSONObject));
      return;
    }
    super.a(paramc, paramJSONObject, paramInt);
  }
  
  protected final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    AppBrandLivePlayerView localAppBrandLivePlayerView = (AppBrandLivePlayerView)((CoverViewContainer)paramView).K(AppBrandLivePlayerView.class);
    paramView = new b.1(this, localAppBrandLivePlayerView);
    b.2 local2 = new b.2(this, localAppBrandLivePlayerView);
    b.3 local3 = new b.3(this, localAppBrandLivePlayerView);
    b.4 local4 = new b.4(this, localAppBrandLivePlayerView, parame);
    parame.a(local2);
    parame.a(local3);
    parame.a(local4);
    localAppBrandLivePlayerView.setFullScreenDelegate(new b.5(this, parame, paramInt, paramView));
    localAppBrandLivePlayerView.setExitListener(new b.6(this, parame, local3, local2));
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new b.7(this, paramInt, parame));
    paramView = new Bundle();
    paramView.putString("playUrl", paramJSONObject.optString("playUrl"));
    paramView.putInt("mode", paramJSONObject.optInt("mode", 0));
    paramView.putBoolean("autoplay", paramJSONObject.optBoolean("autoplay", false));
    paramView.putBoolean("muted", paramJSONObject.optBoolean("muted", false));
    paramView.putString("orientation", paramJSONObject.optString("orientation"));
    paramView.putString("objectFit", paramJSONObject.optString("objectFit"));
    paramView.putBoolean("backgroundMute", paramJSONObject.optBoolean("backgroundMute", true));
    paramView.putFloat("minCache", BigDecimal.valueOf(paramJSONObject.optDouble("minCache", 1.0D)).floatValue());
    paramView.putFloat("maxCache", BigDecimal.valueOf(paramJSONObject.optDouble("maxCache", 3.0D)).floatValue());
    paramView.putBoolean("needEvent", paramJSONObject.optBoolean("needEvent", false));
    paramView.putBoolean("debug", paramJSONObject.optBoolean("debug", false));
    paramView.putString("soundMode", paramJSONObject.optString("soundMode", "speaker"));
    y.i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", new Object[] { paramJSONObject.optString("playUrl") });
    paramJSONObject = localAppBrandLivePlayerView.grW;
    if (localAppBrandLivePlayerView == null) {}
    for (paramView = new j(-1, "invalid params");; paramView = new j())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(paramView.errorCode), paramView.gst });
      localAppBrandLivePlayerView.setPlayEventListener(new b.8(this, paramInt, parame));
      return;
      l.h("initLivePlayer", paramView);
      paramJSONObject.gsv = localAppBrandLivePlayerView;
      paramJSONObject.gsv.disableLog(false);
      paramJSONObject.gsx.setPlayerView(localAppBrandLivePlayerView);
      paramJSONObject.gsz = paramView.getString("playUrl", paramJSONObject.gsz);
      paramJSONObject.gsA = paramJSONObject.v(paramView);
      paramJSONObject.w(paramView);
      paramJSONObject.mAutoPlay = paramView.getBoolean("autoplay", paramJSONObject.mAutoPlay);
      if ((paramJSONObject.mAutoPlay) && (paramJSONObject.gsz != null) && (!paramJSONObject.gsz.isEmpty()))
      {
        y.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
        paramJSONObject.gsx.startPlay(paramJSONObject.gsz, paramJSONObject.gsA);
      }
      paramJSONObject.mInited = true;
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("livePlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */