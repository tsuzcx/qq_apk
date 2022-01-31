package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int hNH;
  
  private void a(Activity paramActivity, c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(96107);
    int i = this.hNH;
    this.hNH = (i + 1);
    if (i > 5)
    {
      ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(96107);
      return;
    }
    n.b(paramc.getAppId(), new b.3(this, paramActivity, paramc, paramJSONObject, paramInt));
    if (!g.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(96107);
      return;
    }
    if (!g.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(96107);
      return;
    }
    ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(96107);
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96104);
    paramJSONObject = new AppBrandLivePusherView(parame.getContext());
    parame = new CoverViewContainer(parame.getContext(), paramJSONObject);
    AppMethodBeat.o(96104);
    return parame;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(96103);
    j.xn();
    if (!(paramc.getContext() instanceof Activity))
    {
      ab.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramc.h(paramInt, j("fail", null));
      n.EA(paramc.getAppId());
      AppMethodBeat.o(96103);
      return;
    }
    this.hNH = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(96103);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96106);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96106);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).aa(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      ab.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(96106);
      return;
    }
    Object localObject1 = new b.1(this, localAppBrandLivePusherView);
    Object localObject2 = new b.4(this, localAppBrandLivePusherView);
    b.5 local5 = new b.5(this, localAppBrandLivePusherView, parame);
    b.6 local6 = new b.6(this, localAppBrandLivePusherView, parame, local5);
    parame.a((f.d)localObject1);
    parame.a((f.b)localObject2);
    parame.a(local6);
    localAppBrandLivePusherView.setOnExitListener(new b.7(this, parame, (f.d)localObject1, (f.b)localObject2));
    com.tencent.mm.plugin.appbrand.e.a(parame.getAppId(), local5);
    localAppBrandLivePusherView.setOnPushEventListener(new b.8(this, paramInt, parame));
    localAppBrandLivePusherView.setBGMNotifyListener(new b.9(this, paramInt, parame));
    localAppBrandLivePusherView.setOnErrorListener(new b.10(this, paramInt, parame));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("pushUrl", paramJSONObject.optString("pushUrl"));
    ((Bundle)localObject1).putInt("mode", paramJSONObject.optInt("mode", 0));
    ((Bundle)localObject1).putBoolean("autopush", paramJSONObject.optBoolean("autopush", false));
    ((Bundle)localObject1).putBoolean("muted", paramJSONObject.optBoolean("muted", false));
    ((Bundle)localObject1).putBoolean("enableCamera", paramJSONObject.optBoolean("enableCamera", true));
    ((Bundle)localObject1).putInt("focusMode", paramJSONObject.optInt("focusMode", 0));
    ((Bundle)localObject1).putString("orientation", paramJSONObject.optString("orientation"));
    ((Bundle)localObject1).putInt("beauty", paramJSONObject.optInt("beauty", 0));
    ((Bundle)localObject1).putInt("whiteness", paramJSONObject.optInt("whiteness", 0));
    ((Bundle)localObject1).putString("audioQuality", paramJSONObject.optString("audioQuality", "high"));
    ((Bundle)localObject1).putInt("aspect", paramJSONObject.optInt("aspect", 0));
    ((Bundle)localObject1).putInt("minBitrate", paramJSONObject.optInt("minBitrate", 0));
    ((Bundle)localObject1).putInt("maxBitrate", paramJSONObject.optInt("maxBitrate", 0));
    ((Bundle)localObject1).putBoolean("backgroundMute", paramJSONObject.optBoolean("backgroundMute", false));
    ((Bundle)localObject1).putBoolean("zoom", paramJSONObject.optBoolean("zoom", true));
    ((Bundle)localObject1).putBoolean("needEvent", paramJSONObject.optBoolean("needEvent", false));
    ((Bundle)localObject1).putBoolean("debug", paramJSONObject.optBoolean("debug", false));
    ((Bundle)localObject1).putBoolean("mirror", paramJSONObject.optBoolean("mirror", false));
    ((Bundle)localObject1).putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkLeft", 0.0D)).floatValue());
    ((Bundle)localObject1).putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkTop", 0.0D)).floatValue());
    ((Bundle)localObject1).putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.optDouble("watermarkWidth", 0.1D)).floatValue());
    ((Bundle)localObject1).putString("devicePosition", paramJSONObject.optString("devicePosition", "front"));
    ((Bundle)localObject1).putBoolean("needBGMEvent", paramJSONObject.optBoolean("needBGMEvent", false));
    ab.i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", new Object[] { paramJSONObject.optString("pushUrl") });
    localObject2 = localAppBrandLivePusherView.hNx;
    l.k("InitLivePusher", (Bundle)localObject1);
    ((l)localObject2).bGi = localAppBrandLivePusherView;
    ((l)localObject2).bGi.disableLog(false);
    ((l)localObject2).bGS = ((Bundle)localObject1).getString("pushUrl", "");
    ((l)localObject2).a((Bundle)localObject1, true);
    ((l)localObject2).bHb = ((Bundle)localObject1).getBoolean("autopush", ((l)localObject2).bHb);
    if ((((l)localObject2).bHb) && (((l)localObject2).bGS != null) && (!((l)localObject2).bGS.isEmpty()) && (!((l)localObject2).bGQ.isPushing()))
    {
      ab.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      ((l)localObject2).bg(((l)localObject2).bHg);
      ((l)localObject2).bGQ.startPusher(((l)localObject2).bGS);
    }
    ((l)localObject2).mInited = true;
    localObject1 = new i();
    ab.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject1).errorCode), ((i)localObject1).bFT });
    localObject1 = paramJSONObject.optString("backgroundImage");
    localObject2 = paramJSONObject.optString("backgroundMD5");
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
      localObject1 = paramJSONObject.optString("watermarkImage");
      paramJSONObject = paramJSONObject.optString("watermarkMD5");
      if (!bo.isNullOrNil((String)localObject1)) {
        break label1004;
      }
      ab.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
    }
    for (;;)
    {
      localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(2131296554));
      AppMethodBeat.o(96106);
      return;
      com.tencent.mm.plugin.appbrand.t.b.a(parame, (String)localObject1, (String)localObject2, new b.11(this, localAppBrandLivePusherView, (String)localObject1));
      break;
      label1004:
      com.tencent.mm.plugin.appbrand.t.b.a(parame, (String)localObject1, paramJSONObject, new b.a()
      {
        public final void BO(String paramAnonymousString)
        {
          AppMethodBeat.i(96086);
          if (!bo.isNullOrNil(paramAnonymousString))
          {
            ab.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
            Bundle localBundle = new Bundle();
            localBundle.putString("watermarkImage", paramAnonymousString);
            localAppBrandLivePusherView.D(localBundle);
          }
          AppMethodBeat.o(96086);
        }
      });
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96105);
    int i = paramJSONObject.getInt("livePusherId");
    AppMethodBeat.o(96105);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */