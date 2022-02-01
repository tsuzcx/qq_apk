package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.g;
import com.tencent.mm.plugin.appbrand.utils.g.a;
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
  private int sbc;
  
  private void a(final Activity paramActivity, final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.sbc;
    this.sbc = (i + 1);
    if (i > 5)
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    s.c(paramf.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(182552);
        Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0)) {
            break label77;
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182550);
              d.a(d.this, d.5.this.val$activity, d.5.this.qwp, d.5.this.ejE, d.5.this.elZ);
              AppMethodBeat.o(182550);
            }
          }, 50L);
        }
        for (;;)
        {
          s.b(paramf.getAppId(), this);
          AppMethodBeat.o(182552);
          return;
          label77:
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
          d.a(d.this, paramf, paramJSONObject, paramInt);
        }
      }
    });
    s.c(paramf.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(326136);
        Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0)) {
            break label77;
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(326128);
              d.a(d.this, d.6.this.val$activity, d.6.this.qwp, d.6.this.ejE, d.6.this.elZ);
              AppMethodBeat.o(326128);
            }
          }, 50L);
        }
        for (;;)
        {
          s.b(paramf.getAppId(), this);
          AppMethodBeat.o(326136);
          return;
          label77:
          Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
          d.b(d.this, paramf, paramJSONObject, paramInt);
        }
      }
    });
    if (!i.a(paramActivity, paramf, "android.permission.CAMERA", 117, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!i.a(paramActivity, paramf, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(145882);
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145880);
    int i = paramJSONObject.getInt("livePusherId");
    AppMethodBeat.o(145880);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
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
    l.csC();
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramf.callback(paramInt, ZP("fail"));
      s.afs(paramf.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.sbc = 0;
    a((Activity)paramf.getContext(), paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
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
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).aT(AppBrandLivePusherView.class);
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
        k localk = localAppBrandLivePusherView.saS.aud();
        Log.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        localAppBrandLivePusherView.rPZ.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        k localk = localAppBrandLivePusherView.saS.cT(false);
        Log.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        localAppBrandLivePusherView.rPZ.disable();
        AppMethodBeat.o(145865);
      }
    };
    final k.c local8 = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        Log.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == k.d.qrH) || (paramAnonymousd == k.d.qrG) || (paramAnonymousd == k.d.qrN)) {
          localAppBrandLivePusherView.saS.cT(true);
        }
        AppMethodBeat.o(145866);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145868);
        com.tencent.mm.plugin.appbrand.k.b(paramh.getAppId(), this);
        AppMethodBeat.o(145868);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145867);
        localAppBrandLivePusherView.saS.aud();
        AppMethodBeat.o(145867);
      }
    };
    i.c local9 = new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145869);
        localAppBrandLivePusherView.onExit();
        paramh.b(this);
        com.tencent.mm.plugin.appbrand.k.b(paramh.getAppId(), local8);
        AppMethodBeat.o(145869);
      }
    };
    paramh.a((i.d)localObject1);
    paramh.a((i.b)localObject2);
    paramh.a(local9);
    localAppBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c()
    {
      public final void csB()
      {
        AppMethodBeat.i(145870);
        paramh.b(this.sbb);
        paramh.b(this.sba);
        AppMethodBeat.o(145870);
      }
    });
    com.tencent.mm.plugin.appbrand.k.a(paramh.getAppId(), local8);
    localAppBrandLivePusherView.setOnPushEventListener(new d.11(this, paramInt, paramh));
    localAppBrandLivePusherView.setBGMNotifyListener(new d.12(this, paramInt, paramh));
    localAppBrandLivePusherView.setOnErrorListener(new d.13(this, paramInt, paramh));
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new d.14(this, paramInt, paramh));
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.eBs = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.eBs);
      localAppBrandLivePusherView.eBt = paramJSONObject.optString("filterImageMd5", null);
      if (!Util.isNullOrNil(localAppBrandLivePusherView.eBs)) {
        break label533;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("filterImage", "");
        localObject1 = n.an(paramJSONObject);
        localObject1 = localAppBrandLivePusherView.saS.b(localAppBrandLivePusherView, (Bundle)localObject1);
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
      if ((localAppBrandLivePusherView.eBs.startsWith("http://")) || (localAppBrandLivePusherView.eBs.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label573:
        g.a(paramh, localJSONException, (String)localObject2, new g.a()
        {
          public final void onLoad(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.ab(localBundle);
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
        g.a(paramh, localJSONException, null, new g.a()
        {
          public final void onLoad(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.ab(localBundle);
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
        g.a(paramh, localJSONException, paramJSONObject, new g.a()
        {
          public final void onLoad(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.n(paramAnonymousString, false);
              Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("watermarkImage", paramAnonymousString);
              localAppBrandLivePusherView.ab(localBundle);
            }
            AppMethodBeat.o(182549);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */