package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveBase;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int oVF;
  
  private void a(final Activity paramActivity, final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.oVF;
    this.oVF = (i + 1);
    if (i > 5)
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    r.b(parame.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(182552);
        Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182550);
                d.a(d.this, d.5.this.val$activity, d.5.this.owM, d.5.this.cui, d.5.this.cuf);
                AppMethodBeat.o(182550);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
          d.a(d.this, parame, paramJSONObject, paramInt);
          AppMethodBeat.o(182552);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182551);
                d.a(d.this, d.5.this.val$activity, d.5.this.owM, d.5.this.cui, d.5.this.cuf);
                AppMethodBeat.o(182551);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
          d.b(d.this, parame, paramJSONObject, paramInt);
        }
        AppMethodBeat.o(182552);
      }
    });
    if (!i.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!i.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(parame, paramJSONObject, paramInt);
    AppMethodBeat.o(145882);
  }
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145880);
    int i = paramJSONObject.getInt("livePusherId");
    AppMethodBeat.o(145880);
    return i;
  }
  
  public final View a(g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145879);
    paramJSONObject = new AppBrandLivePusherView(paramg.getContext());
    paramg = new CoverViewContainer(paramg.getContext(), paramJSONObject);
    AppMethodBeat.o(145879);
    return paramg;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145878);
    l.bSv();
    if (!(parame.getContext() instanceof Activity))
    {
      Log.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      parame.j(paramInt, h("fail", null));
      r.amk(parame.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.oVF = 0;
    a((Activity)parame.getContext(), parame, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145881);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145881);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { paramg.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).aA(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      Log.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(145881);
      return;
    }
    Object localObject1 = new h.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145860);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        k localk = localAppBrandLivePusherView.oVv.Ty();
        Log.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        localAppBrandLivePusherView.oMe.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        k localk = localAppBrandLivePusherView.oVv.cn(false);
        Log.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        localAppBrandLivePusherView.oMe.disable();
        AppMethodBeat.o(145865);
      }
    };
    final k.c local7 = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        Log.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == k.d.ntc) || (paramAnonymousd == k.d.ntb) || (paramAnonymousd == k.d.nti)) {
          localAppBrandLivePusherView.oVv.cn(true);
        }
        AppMethodBeat.o(145866);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145868);
        com.tencent.mm.plugin.appbrand.k.b(paramg.getAppId(), this);
        AppMethodBeat.o(145868);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145867);
        localAppBrandLivePusherView.oVv.Ty();
        AppMethodBeat.o(145867);
      }
    };
    h.c local8 = new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145869);
        localAppBrandLivePusherView.onExit();
        paramg.b(this);
        com.tencent.mm.plugin.appbrand.k.b(paramg.getAppId(), local7);
        AppMethodBeat.o(145869);
      }
    };
    paramg.a((h.d)localObject1);
    paramg.a((h.b)localObject2);
    paramg.a(local8);
    localAppBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c()
    {
      public final void bSu()
      {
        AppMethodBeat.i(145870);
        paramg.b(this.oVE);
        paramg.b(this.oVD);
        AppMethodBeat.o(145870);
      }
    });
    com.tencent.mm.plugin.appbrand.k.a(paramg.getAppId(), local7);
    localAppBrandLivePusherView.setOnPushEventListener(new d.10(this, paramInt, paramg));
    localAppBrandLivePusherView.setBGMNotifyListener(new d.11(this, paramInt, paramg));
    localAppBrandLivePusherView.setOnErrorListener(new d.12(this, paramInt, paramg));
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new d.13(this, paramInt, paramg));
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.cHV = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.cHV);
      localAppBrandLivePusherView.cHW = paramJSONObject.optString("filterImageMd5", null);
      if (!Util.isNullOrNil(localAppBrandLivePusherView.cHV)) {
        break label533;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("filterImage", "");
        localObject1 = n.ad(paramJSONObject);
        localObject1 = localAppBrandLivePusherView.oVv.b(localAppBrandLivePusherView, (Bundle)localObject1);
        Log.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject1).errorCode), ((k)localObject1).errorInfo });
        localObject1 = paramJSONObject.optString("backgroundImage");
        localObject2 = paramJSONObject.optString("backgroundMD5");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label573;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("filterImage");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label596;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label618;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(com.tencent.luggage.g.a.a.app_brand_accessibility_live_pusher_view));
        AppMethodBeat.o(145881);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { localJSONException });
        continue;
      }
      label533:
      if ((localAppBrandLivePusherView.cHV.startsWith("http://")) || (localAppBrandLivePusherView.cHV.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label573:
        com.tencent.mm.plugin.appbrand.utils.e.a(paramg, localJSONException, (String)localObject2, new e.a()
        {
          public final void dR(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.Q(localBundle);
              AppMethodBeat.o(145861);
              return;
            }
            Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10004, "load background image fail", paramAnonymousString);
            AppMethodBeat.o(145861);
          }
        });
        continue;
        label596:
        com.tencent.mm.plugin.appbrand.utils.e.a(paramg, localJSONException, null, new e.a()
        {
          public final void dR(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.Q(localBundle);
              AppMethodBeat.o(182548);
              return;
            }
            Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10005, "load filter image fail", paramAnonymousString);
            AppMethodBeat.o(182548);
          }
        });
        continue;
        label618:
        com.tencent.mm.plugin.appbrand.utils.e.a(paramg, localJSONException, paramJSONObject, new e.a()
        {
          public final void dR(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("watermarkImage", paramAnonymousString);
              localAppBrandLivePusherView.Q(localBundle);
            }
            AppMethodBeat.o(182549);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */