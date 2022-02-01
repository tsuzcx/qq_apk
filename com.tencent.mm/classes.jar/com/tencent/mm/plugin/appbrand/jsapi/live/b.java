package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.a.a;
import android.view.View;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int jSX;
  
  private void a(final Activity paramActivity, final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.jSX;
    this.jSX = (i + 1);
    if (i > 5)
    {
      ad.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    o.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(182552);
        ad.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182550);
                b.a(b.this, b.5.this.val$activity, b.5.this.jza, b.5.this.ccE, b.5.this.ccB);
                AppMethodBeat.o(182550);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ad.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
          AppMethodBeat.o(182552);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182551);
                b.a(b.this, b.5.this.val$activity, b.5.this.jza, b.5.this.ccE, b.5.this.ccB);
                AppMethodBeat.o(182551);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ad.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
        }
        AppMethodBeat.o(182552);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ad.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ad.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    ad.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
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
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145878);
    j.EX();
    if (!(paramc.getContext() instanceof Activity))
    {
      ad.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramc.h(paramInt, e("fail", null));
      o.Mi(paramc.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.jSX = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145881);
    ad.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145881);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).ax(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      ad.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(145881);
      return;
    }
    Object localObject1 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145860);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.jSN.bak();
        ad.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.cko });
        localAppBrandLivePusherView.jSL.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.jSN.fW(false);
        ad.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.cko });
        localAppBrandLivePusherView.jSL.disable();
        AppMethodBeat.o(145865);
      }
    };
    final g.c local7 = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        ad.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == g.d.iDd) || (paramAnonymousd == g.d.iDc) || (paramAnonymousd == g.d.iDj)) {
          localAppBrandLivePusherView.jSN.fW(true);
        }
        AppMethodBeat.o(145866);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145868);
        g.b(parame.getAppId(), this);
        AppMethodBeat.o(145868);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145867);
        localAppBrandLivePusherView.jSN.bak();
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
        g.b(parame.getAppId(), local7);
        AppMethodBeat.o(145869);
      }
    };
    parame.a((f.d)localObject1);
    parame.a((f.b)localObject2);
    parame.a(local8);
    localAppBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c()
    {
      public final void baj()
      {
        AppMethodBeat.i(145870);
        parame.b(this.jSW);
        parame.b(this.jSV);
        AppMethodBeat.o(145870);
      }
    });
    g.a(parame.getAppId(), local7);
    localAppBrandLivePusherView.setOnPushEventListener(new b.10(this, paramInt, parame));
    localAppBrandLivePusherView.setBGMNotifyListener(new b.11(this, paramInt, parame));
    localAppBrandLivePusherView.setOnErrorListener(new b.12(this, paramInt, parame));
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new b.13(this, paramInt, parame));
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.clO = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.clO);
      localAppBrandLivePusherView.clP = paramJSONObject.optString("filterImageMd5", null);
      if (!bt.isNullOrNil(localAppBrandLivePusherView.clO)) {
        break label698;
      }
    }
    label783:
    for (;;)
    {
      try
      {
        paramJSONObject.put("filterImage", "");
        localObject1 = k.P(paramJSONObject);
        localObject2 = localAppBrandLivePusherView.jSN;
        m.l("InitLivePusher", (Bundle)localObject1);
        ((m)localObject2).mVideoView = localAppBrandLivePusherView;
        ((m)localObject2).mVideoView.disableLog(false);
        ((m)localObject2).cmi = ((Bundle)localObject1).getString("pushUrl", "");
        ((m)localObject2).cmg.setPusherUrl(((m)localObject2).cmi);
        ((m)localObject2).a((Bundle)localObject1, true);
        ((m)localObject2).cms = ((Bundle)localObject1).getBoolean("autopush", ((m)localObject2).cms);
        if ((((m)localObject2).cms) && (((m)localObject2).cmi != null) && (!((m)localObject2).cmi.isEmpty()) && (!((m)localObject2).cmg.isPushing()))
        {
          ad.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          ((m)localObject2).bC(((m)localObject2).cmy);
          ((m)localObject2).bD(((m)localObject2).cmz);
          ((m)localObject2).cmg.startPusher(((m)localObject2).cmi);
        }
        ((m)localObject2).mInited = true;
        localObject1 = new i();
        ad.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject1).errorCode), ((i)localObject1).cko });
        localObject1 = paramJSONObject.optString("backgroundImage");
        localObject2 = paramJSONObject.optString("backgroundMD5");
        if (!bt.isNullOrNil((String)localObject1)) {
          break label738;
        }
        ad.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("filterImage");
        if (!bt.isNullOrNil((String)localObject1)) {
          break label761;
        }
        ad.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (!bt.isNullOrNil((String)localObject1)) {
          break label783;
        }
        ad.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(2131755289));
        AppMethodBeat.o(145881);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { localJSONException });
        continue;
      }
      label698:
      if ((localAppBrandLivePusherView.clO.startsWith("http://")) || (localAppBrandLivePusherView.clO.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label738:
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, (String)localObject2, new b.a()
        {
          public final void Fn(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ad.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.H(localBundle);
              AppMethodBeat.o(145861);
              return;
            }
            ad.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10004, "load background image fail", paramAnonymousString);
            AppMethodBeat.o(145861);
          }
        });
        continue;
        label761:
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, null, new b.a()
        {
          public final void Fn(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ad.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.H(localBundle);
              AppMethodBeat.o(182548);
              return;
            }
            ad.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10005, "load filter image fail", paramAnonymousString);
            AppMethodBeat.o(182548);
          }
        });
        continue;
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, paramJSONObject, new b.a()
        {
          public final void Fn(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ad.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("watermarkImage", paramAnonymousString);
              localAppBrandLivePusherView.H(localBundle);
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