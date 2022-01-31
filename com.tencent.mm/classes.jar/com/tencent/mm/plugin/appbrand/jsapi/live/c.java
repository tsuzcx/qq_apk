package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.j.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int gsl;
  
  private void a(Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = this.gsl;
    this.gsl = (i + 1);
    if (i > 5)
    {
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "doInvokeAfterRequestPermission, avoid dead loop");
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.e.b(paramc.getAppId(), new c.3(this, paramActivity, paramc, paramJSONObject, paramInt));
    if (!f.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "doInvokeAfterRequestPermission, !retCameraPermission");
      return;
    }
    if (!f.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      return;
    }
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramc, paramJSONObject, paramInt);
  }
  
  protected final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = new AppBrandLivePusherView(parame.getContext());
    return new CoverViewContainer(parame.getContext(), paramJSONObject);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    
    if (!(paramc.getContext() instanceof Activity))
    {
      y.w("MicroMsg.JsApiInsertLivePusher.javayhu", "invokeAfterRequestPermission pageContext not activity");
      paramc.C(paramInt, h("fail", null));
      com.tencent.mm.plugin.appbrand.permission.e.vX(paramc.getAppId());
      return;
    }
    this.gsl = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiInsertLivePusher.javayhu", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).K(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      y.e("MicroMsg.JsApiInsertLivePusher.javayhu", "pusherView null");
      return;
    }
    paramView = new c.1(this, localAppBrandLivePusherView);
    Object localObject = new c.4(this, localAppBrandLivePusherView);
    c.5 local5 = new c.5(this, localAppBrandLivePusherView, parame);
    c.6 local6 = new c.6(this, localAppBrandLivePusherView, parame, local5);
    parame.a(paramView);
    parame.a((e.b)localObject);
    parame.a(local6);
    localAppBrandLivePusherView.setOnExitListener(new c.7(this, parame, paramView, (e.b)localObject));
    g.a(parame.getAppId(), local5);
    localAppBrandLivePusherView.setOnPushEventListener(new c.8(this, paramInt, parame));
    localAppBrandLivePusherView.setBGMNotifyListener(new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onBGMComplete, error:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        c.a locala = new c.a((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", paramAnonymousInt);
          localJSONObject.put("livePusherId", paramInt);
          parame.b(locala.tM(localJSONObject.toString()));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiInsertLivePusher.javayhu", "onBGMComplete fail", new Object[] { localJSONException });
          }
        }
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        c.b localb = new c.b((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("progress", paramAnonymousLong1);
          localJSONObject.put("duration", paramAnonymousLong2);
          localJSONObject.put("livePusherId", paramInt);
          parame.b(localb.tM(localJSONObject.toString()));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiInsertLivePusher.javayhu", "onBGMProgress fail", new Object[] { localJSONException });
          }
        }
      }
      
      public final void onBGMStart()
      {
        y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onBGMStart");
        c.c localc = new c.c((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("livePusherId", paramInt);
          parame.b(localc.tM(localJSONObject.toString()));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiInsertLivePusher.javayhu", "onBGMStart fail", new Object[] { localJSONException });
          }
        }
      }
    });
    localAppBrandLivePusherView.setOnErrorListener(new c.10(this, paramInt, parame));
    paramView = new Bundle();
    paramView.putString("pushUrl", paramJSONObject.optString("pushUrl"));
    paramView.putInt("mode", paramJSONObject.optInt("mode", 0));
    paramView.putBoolean("autopush", paramJSONObject.optBoolean("autopush", false));
    paramView.putBoolean("muted", paramJSONObject.optBoolean("muted", false));
    paramView.putBoolean("enableCamera", paramJSONObject.optBoolean("enableCamera", true));
    paramView.putInt("focusMode", paramJSONObject.optInt("focusMode", 0));
    paramView.putString("orientation", paramJSONObject.optString("orientation"));
    paramView.putInt("beauty", paramJSONObject.optInt("beauty", 0));
    paramView.putInt("whiteness", paramJSONObject.optInt("whiteness", 0));
    paramView.putString("audioQuality", paramJSONObject.optString("audioQuality", "high"));
    paramView.putInt("aspect", paramJSONObject.optInt("aspect", 0));
    paramView.putInt("minBitrate", paramJSONObject.optInt("minBitrate", 0));
    paramView.putInt("maxBitrate", paramJSONObject.optInt("maxBitrate", 0));
    paramView.putBoolean("backgroundMute", paramJSONObject.optBoolean("backgroundMute", false));
    paramView.putBoolean("zoom", paramJSONObject.optBoolean("zoom", true));
    paramView.putBoolean("needEvent", paramJSONObject.optBoolean("needEvent", false));
    paramView.putBoolean("debug", paramJSONObject.optBoolean("debug", false));
    paramView.putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkLeft", 0.0D)).floatValue());
    paramView.putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkTop", 0.0D)).floatValue());
    paramView.putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkWidth", 0.1D)).floatValue());
    paramView.putString("devicePosition", paramJSONObject.optString("devicePosition", "front"));
    paramView.putBoolean("needBGMEvent", paramJSONObject.optBoolean("needBGMEvent", false));
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertParams pushUrl:%s", new Object[] { paramJSONObject.optString("pushUrl") });
    localObject = localAppBrandLivePusherView.gsc;
    if (localAppBrandLivePusherView == null)
    {
      paramView = new j(-1, "invalid params");
      y.i("MicroMsg.AppBrandLivePusherView.javayhu", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(paramView.errorCode), paramView.gst });
      paramView = paramJSONObject.optString("backgroundImage");
      localObject = paramJSONObject.optString("backgroundMD5");
      if (!bk.bl(paramView)) {
        break label930;
      }
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertBackgroundImageToLocalPath, url is null");
    }
    for (;;)
    {
      paramView = paramJSONObject.optString("watermarkImage");
      paramJSONObject = paramJSONObject.optString("watermarkMD5");
      if (!bk.bl(paramView)) {
        break label951;
      }
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertWatermarkImageToLocalPath, url is null");
      return;
      m.h("InitLivePusher", paramView);
      ((m)localObject).gsv = localAppBrandLivePusherView;
      ((m)localObject).gsv.disableLog(false);
      ((m)localObject).gsM = paramView.getString("pushUrl", "");
      ((m)localObject).c(paramView, true);
      ((m)localObject).gsT = paramView.getBoolean("autopush", ((m)localObject).gsT);
      if ((((m)localObject).gsT) && (((m)localObject).gsM != null) && (!((m)localObject).gsM.isEmpty()) && (!((m)localObject).gsK.isPushing()))
      {
        y.i("TXLivePusherJSAdapter.javayhu", "initLivePusher: startPusher");
        ((m)localObject).gsv.setVisibility(0);
        if (((m)localObject).gsY) {
          ((m)localObject).gsK.startCameraPreview(((m)localObject).gsv);
        }
        ((m)localObject).gsK.startPusher(((m)localObject).gsM);
      }
      ((m)localObject).mInited = true;
      paramView = new j();
      break;
      label930:
      a.a(parame, paramView, (String)localObject, new c.11(this, localAppBrandLivePusherView, paramView));
    }
    label951:
    a.a(parame, paramView, paramJSONObject, new a.a()
    {
      public final void ud(String paramAnonymousString)
      {
        if (!bk.bl(paramAnonymousString))
        {
          y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
          Bundle localBundle = new Bundle();
          localBundle.putString("watermarkImage", paramAnonymousString);
          localAppBrandLivePusherView.u(localBundle);
        }
      }
    });
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("livePusherId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */