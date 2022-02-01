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
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private int kSN;
  
  private void a(final Activity paramActivity, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.kSN;
    this.kSN = (i + 1);
    if (i > 5)
    {
      ae.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    r.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(182552);
        ae.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182550);
                b.a(b.this, b.5.this.val$activity, b.5.this.kxj, b.5.this.cjV, b.5.this.cjS);
                AppMethodBeat.o(182550);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ae.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
          AppMethodBeat.o(182552);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182551);
                b.a(b.this, b.5.this.val$activity, b.5.this.kxj, b.5.this.cjV, b.5.this.cjS);
                AppMethodBeat.o(182551);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ae.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
        }
        AppMethodBeat.o(182552);
      }
    });
    if (!com.tencent.luggage.h.h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ae.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!com.tencent.luggage.h.h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ae.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    ae.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145882);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145880);
    int i = paramJSONObject.getInt("livePusherId");
    AppMethodBeat.o(145880);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145879);
    paramJSONObject = new AppBrandLivePusherView(parame.getContext());
    parame = new CoverViewContainer(parame.getContext(), paramJSONObject);
    AppMethodBeat.o(145879);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145878);
    j.Gg();
    if (!(paramc.getContext() instanceof Activity))
    {
      ae.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramc.h(paramInt, e("fail", null));
      r.UC(paramc.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.kSN = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145881);
    ae.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145881);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).ax(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      ae.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(145881);
      return;
    }
    Object localObject1 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145860);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.kSD.bls();
        ae.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.csi });
        localAppBrandLivePusherView.kSB.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.kSD.gx(false);
        ae.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.csi });
        localAppBrandLivePusherView.kSB.disable();
        AppMethodBeat.o(145865);
      }
    };
    final h.c local7 = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        ae.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == h.d.jzi) || (paramAnonymousd == h.d.jzh) || (paramAnonymousd == h.d.jzo)) {
          localAppBrandLivePusherView.kSD.gx(true);
        }
        AppMethodBeat.o(145866);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145868);
        com.tencent.mm.plugin.appbrand.h.b(parame.getAppId(), this);
        AppMethodBeat.o(145868);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145867);
        localAppBrandLivePusherView.kSD.bls();
        AppMethodBeat.o(145867);
      }
    };
    f.c local8 = new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145869);
        localAppBrandLivePusherView.onExit();
        parame.b(this);
        com.tencent.mm.plugin.appbrand.h.b(parame.getAppId(), local7);
        AppMethodBeat.o(145869);
      }
    };
    parame.a((f.d)localObject1);
    parame.a((f.b)localObject2);
    parame.a(local8);
    localAppBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c()
    {
      public final void blr()
      {
        AppMethodBeat.i(145870);
        parame.b(this.kSM);
        parame.b(this.kSL);
        AppMethodBeat.o(145870);
      }
    });
    com.tencent.mm.plugin.appbrand.h.a(parame.getAppId(), local7);
    localAppBrandLivePusherView.setOnPushEventListener(new b.10(this, paramInt, parame));
    localAppBrandLivePusherView.setBGMNotifyListener(new b.11(this, paramInt, parame));
    localAppBrandLivePusherView.setOnErrorListener(new b.12(this, paramInt, parame));
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new b.13(this, paramInt, parame));
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.ctJ = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.ctJ);
      localAppBrandLivePusherView.ctK = paramJSONObject.optString("filterImageMd5", null);
      if (!bu.isNullOrNil(localAppBrandLivePusherView.ctJ)) {
        break label698;
      }
    }
    label783:
    for (;;)
    {
      try
      {
        paramJSONObject.put("filterImage", "");
        localObject1 = k.Q(paramJSONObject);
        localObject2 = localAppBrandLivePusherView.kSD;
        m.l("InitLivePusher", (Bundle)localObject1);
        ((m)localObject2).mVideoView = localAppBrandLivePusherView;
        ((m)localObject2).mVideoView.disableLog(false);
        ((m)localObject2).cud = ((Bundle)localObject1).getString("pushUrl", "");
        ((m)localObject2).cub.setPusherUrl(((m)localObject2).cud);
        ((m)localObject2).a((Bundle)localObject1, true);
        ((m)localObject2).cun = ((Bundle)localObject1).getBoolean("autopush", ((m)localObject2).cun);
        if ((((m)localObject2).cun) && (((m)localObject2).cud != null) && (!((m)localObject2).cud.isEmpty()) && (!((m)localObject2).cub.isPushing()))
        {
          ae.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          ((m)localObject2).bB(((m)localObject2).cut);
          ((m)localObject2).bC(((m)localObject2).cuu);
          ((m)localObject2).cub.startPusher(((m)localObject2).cud);
        }
        ((m)localObject2).mInited = true;
        localObject1 = new i();
        ae.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject1).errorCode), ((i)localObject1).csi });
        localObject1 = paramJSONObject.optString("backgroundImage");
        localObject2 = paramJSONObject.optString("backgroundMD5");
        if (!bu.isNullOrNil((String)localObject1)) {
          break label738;
        }
        ae.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("filterImage");
        if (!bu.isNullOrNil((String)localObject1)) {
          break label761;
        }
        ae.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (!bu.isNullOrNil((String)localObject1)) {
          break label783;
        }
        ae.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(2131755289));
        AppMethodBeat.o(145881);
        return;
      }
      catch (JSONException localJSONException)
      {
        ae.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { localJSONException });
        continue;
      }
      label698:
      if ((localAppBrandLivePusherView.ctJ.startsWith("http://")) || (localAppBrandLivePusherView.ctJ.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label738:
        com.tencent.mm.plugin.appbrand.utils.c.a(parame, localJSONException, (String)localObject2, new c.a()
        {
          public final void Nr(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!bu.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ae.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.J(localBundle);
              AppMethodBeat.o(145861);
              return;
            }
            ae.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10004, "load background image fail", paramAnonymousString);
            AppMethodBeat.o(145861);
          }
        });
        continue;
        label761:
        com.tencent.mm.plugin.appbrand.utils.c.a(parame, localJSONException, null, new c.a()
        {
          public final void Nr(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!bu.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ae.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.J(localBundle);
              AppMethodBeat.o(182548);
              return;
            }
            ae.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10005, "load filter image fail", paramAnonymousString);
            AppMethodBeat.o(182548);
          }
        });
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.a(parame, localJSONException, paramJSONObject, new c.a()
        {
          public final void Nr(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!bu.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ae.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("watermarkImage", paramAnonymousString);
              localAppBrandLivePusherView.J(localBundle);
            }
            AppMethodBeat.o(182549);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */