package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.a.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int lXS;
  
  private void a(final Activity paramActivity, final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.lXS;
    this.lXS = (i + 1);
    if (i > 5)
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    r.b(paramf.getAppId(), new a.a()
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
                b.a(b.this, b.5.this.val$activity, b.5.this.lBw, b.5.this.cvS, b.5.this.cvP);
                AppMethodBeat.o(182550);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramf.i(paramInt, b.this.h("fail:system permission denied", null));
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
                b.a(b.this, b.5.this.val$activity, b.5.this.lBw, b.5.this.cvS, b.5.this.cvP);
                AppMethodBeat.o(182551);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramf.i(paramInt, b.this.h("fail:system permission denied", null));
        }
        AppMethodBeat.o(182552);
      }
    });
    if (!com.tencent.luggage.h.i.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!com.tencent.luggage.h.i.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(145882);
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145880);
    int i = paramJSONObject.getInt("livePusherId");
    AppMethodBeat.o(145880);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145879);
    paramJSONObject = new AppBrandLivePusherView(paramh.getContext());
    paramh = new CoverViewContainer(paramh.getContext(), paramJSONObject);
    AppMethodBeat.o(145879);
    return paramh;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145878);
    j.PP();
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramf.i(paramInt, h("fail", null));
      r.aeq(paramf.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.lXS = 0;
    a((Activity)paramf.getContext(), paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145881);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145881);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { paramh.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).aB(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      Log.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(145881);
      return;
    }
    Object localObject1 = new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145860);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.lXI.bGO();
        Log.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.errorInfo });
        localAppBrandLivePusherView.lPK.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.lXI.hu(false);
        Log.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.errorInfo });
        localAppBrandLivePusherView.lPK.disable();
        AppMethodBeat.o(145865);
      }
    };
    final h.c local7 = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        Log.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == h.d.kzQ) || (paramAnonymousd == h.d.kzP) || (paramAnonymousd == h.d.kzW)) {
          localAppBrandLivePusherView.lXI.hu(true);
        }
        AppMethodBeat.o(145866);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145868);
        com.tencent.mm.plugin.appbrand.h.b(paramh.getAppId(), this);
        AppMethodBeat.o(145868);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145867);
        localAppBrandLivePusherView.lXI.bGO();
        AppMethodBeat.o(145867);
      }
    };
    i.c local8 = new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145869);
        localAppBrandLivePusherView.onExit();
        paramh.b(this);
        com.tencent.mm.plugin.appbrand.h.b(paramh.getAppId(), local7);
        AppMethodBeat.o(145869);
      }
    };
    paramh.a((i.d)localObject1);
    paramh.a((i.b)localObject2);
    paramh.a(local8);
    localAppBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c()
    {
      public final void bGN()
      {
        AppMethodBeat.i(145870);
        paramh.b(this.lXR);
        paramh.b(this.lXQ);
        AppMethodBeat.o(145870);
      }
    });
    com.tencent.mm.plugin.appbrand.h.a(paramh.getAppId(), local7);
    localAppBrandLivePusherView.setOnPushEventListener(new b.10(this, paramInt, paramh));
    localAppBrandLivePusherView.setBGMNotifyListener(new b.11(this, paramInt, paramh));
    localAppBrandLivePusherView.setOnErrorListener(new b.12(this, paramInt, paramh));
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new b.13(this, paramInt, paramh));
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.cHp = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.cHp);
      localAppBrandLivePusherView.cHq = paramJSONObject.optString("filterImageMd5", null);
      if (!Util.isNullOrNil(localAppBrandLivePusherView.cHp)) {
        break label698;
      }
    }
    label783:
    for (;;)
    {
      try
      {
        paramJSONObject.put("filterImage", "");
        localObject1 = k.Z(paramJSONObject);
        localObject2 = localAppBrandLivePusherView.lXI;
        m.l("InitLivePusher", (Bundle)localObject1);
        ((m)localObject2).mVideoView = localAppBrandLivePusherView;
        ((m)localObject2).mVideoView.disableLog(false);
        ((m)localObject2).cHX = ((Bundle)localObject1).getString("pushUrl", "");
        ((m)localObject2).cHV.setPusherUrl(((m)localObject2).cHX);
        ((m)localObject2).a((Bundle)localObject1, true);
        ((m)localObject2).cIh = ((Bundle)localObject1).getBoolean("autopush", ((m)localObject2).cIh);
        if ((((m)localObject2).cIh) && (((m)localObject2).cHX != null) && (!((m)localObject2).cHX.isEmpty()) && (!((m)localObject2).cHV.isPushing()))
        {
          Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          ((m)localObject2).ca(((m)localObject2).cIm);
          ((m)localObject2).cb(((m)localObject2).cIn);
          ((m)localObject2).cHV.startPusher(((m)localObject2).cHX);
        }
        ((m)localObject2).mInited = true;
        localObject1 = new i();
        Log.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject1).errorCode), ((i)localObject1).errorInfo });
        localObject1 = paramJSONObject.optString("backgroundImage");
        localObject2 = paramJSONObject.optString("backgroundMD5");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label738;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("filterImage");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label761;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label783;
        }
        Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(2131755325));
        AppMethodBeat.o(145881);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { localJSONException });
        continue;
      }
      label698:
      if ((localAppBrandLivePusherView.cHp.startsWith("http://")) || (localAppBrandLivePusherView.cHp.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label738:
        c.a(paramh, localJSONException, (String)localObject2, new c.a()
        {
          public final void Wz(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.P(localBundle);
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
        label761:
        c.a(paramh, localJSONException, null, new c.a()
        {
          public final void Wz(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.P(localBundle);
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
        c.a(paramh, localJSONException, paramJSONObject, new c.a()
        {
          public final void Wz(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("watermarkImage", paramAnonymousString);
              localAppBrandLivePusherView.P(localBundle);
            }
            AppMethodBeat.o(182549);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */