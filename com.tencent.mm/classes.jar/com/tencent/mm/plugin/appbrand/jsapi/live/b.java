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
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int ktJ;
  
  private void a(final Activity paramActivity, final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145882);
    int i = this.ktJ;
    this.ktJ = (i + 1);
    if (i > 5)
    {
      ac.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      AppMethodBeat.o(145882);
      return;
    }
    o.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(182552);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182550);
                b.a(b.this, b.5.this.val$activity, b.5.this.jZx, b.5.this.bZB, b.5.this.bZy);
                AppMethodBeat.o(182550);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ac.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
          AppMethodBeat.o(182552);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182551);
                b.a(b.this, b.5.this.val$activity, b.5.this.jZx, b.5.this.bZB, b.5.this.bZy);
                AppMethodBeat.o(182551);
              }
            }, 50L);
            AppMethodBeat.o(182552);
            return;
          }
          ac.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
          paramc.h(paramInt, b.this.e("fail:system permission denied", null));
        }
        AppMethodBeat.o(182552);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ac.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      AppMethodBeat.o(145882);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ac.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      AppMethodBeat.o(145882);
      return;
    }
    ac.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
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
    j.EB();
    if (!(paramc.getContext() instanceof Activity))
    {
      ac.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramc.h(paramInt, e("fail", null));
      o.Qo(paramc.getAppId());
      AppMethodBeat.o(145878);
      return;
    }
    this.ktJ = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145878);
  }
  
  public final void a(final e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145881);
    ac.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145881);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePusherView localAppBrandLivePusherView = (AppBrandLivePusherView)((CoverViewContainer)paramView).ax(AppBrandLivePusherView.class);
    if (localAppBrandLivePusherView == null)
    {
      ac.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      AppMethodBeat.o(145881);
      return;
    }
    Object localObject1 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145860);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.ktz.bhd();
        ac.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.chn });
        localAppBrandLivePusherView.ktx.enable();
        AppMethodBeat.o(145860);
      }
    };
    Object localObject2 = new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145865);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        i locali = localAppBrandLivePusherView.ktz.gs(false);
        ac.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(locali.errorCode), locali.chn });
        localAppBrandLivePusherView.ktx.disable();
        AppMethodBeat.o(145865);
      }
    };
    final g.c local7 = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(145866);
        AppBrandLivePusherView localAppBrandLivePusherView = localAppBrandLivePusherView;
        ac.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramAnonymousd });
        if ((paramAnonymousd == g.d.jdd) || (paramAnonymousd == g.d.jdc) || (paramAnonymousd == g.d.jdj)) {
          localAppBrandLivePusherView.ktz.gs(true);
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
        localAppBrandLivePusherView.ktz.bhd();
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
      public final void bhc()
      {
        AppMethodBeat.i(145870);
        parame.b(this.ktI);
        parame.b(this.ktH);
        AppMethodBeat.o(145870);
      }
    });
    g.a(parame.getAppId(), local7);
    localAppBrandLivePusherView.setOnPushEventListener(new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(145872);
        b.f localf = new b.f((byte)0);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2;
        try
        {
          localJSONObject1.put("livePusherId", paramInt);
          localJSONObject2 = new JSONObject();
          if (paramAnonymousBundle != null)
          {
            Iterator localIterator = paramAnonymousBundle.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localJSONObject2.put(str, paramAnonymousBundle.get(str));
              continue;
              parame.b(localf.LO(localJSONObject1.toString()));
            }
          }
        }
        catch (JSONException paramAnonymousBundle) {}
        for (;;)
        {
          AppMethodBeat.o(145872);
          return;
          localJSONObject1.put("info", localJSONObject2);
        }
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(145871);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        b.g localg = new b.g((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", paramAnonymousInt);
          localJSONObject.put("errMsg", paramAnonymousBundle.getString("EVT_MSG"));
          localJSONObject.put("livePusherId", paramInt);
          label76:
          parame.b(localg.LO(localJSONObject.toString()));
          AppMethodBeat.o(145871);
          return;
        }
        catch (JSONException paramAnonymousBundle)
        {
          break label76;
        }
      }
    });
    localAppBrandLivePusherView.setBGMNotifyListener(new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(145875);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        b.b localb = new b.b((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", paramAnonymousInt);
          localJSONObject.put("livePusherId", paramInt);
          parame.b(localb.LO(localJSONObject.toString()));
          AppMethodBeat.o(145875);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", new Object[] { localJSONException });
          }
        }
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(145874);
        b.c localc = new b.c((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("progress", paramAnonymousLong1);
          localJSONObject.put("duration", paramAnonymousLong2);
          localJSONObject.put("livePusherId", paramInt);
          parame.b(localc.LO(localJSONObject.toString()));
          AppMethodBeat.o(145874);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", new Object[] { localJSONException });
          }
        }
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(145873);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
        b.d locald = new b.d((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("livePusherId", paramInt);
          parame.b(locald.LO(localJSONObject.toString()));
          AppMethodBeat.o(145873);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", new Object[] { localJSONException });
          }
        }
      }
    });
    localAppBrandLivePusherView.setOnErrorListener(new AppBrandLivePusherView.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, HashMap<String, Object> paramAnonymousHashMap)
      {
        AppMethodBeat.i(145876);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        b.e locale = new b.e((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", paramAnonymousInt);
          localJSONObject.put("errMsg", bs.nullAsNil(paramAnonymousString));
          localJSONObject.put("livePusherId", paramInt);
          if ((paramAnonymousHashMap != null) && (!paramAnonymousHashMap.isEmpty())) {
            localJSONObject.put("data", new JSONObject(paramAnonymousHashMap));
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertLivePusher", "onError fail", new Object[] { paramAnonymousString });
          }
        }
        parame.b(locale.LO(localJSONObject.toString()));
        AppMethodBeat.o(145876);
      }
    });
    localAppBrandLivePusherView.setAudioVolumeNotifyListener(new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(182553);
        ac.i("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify, volume:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        b.a locala = new b.a((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("volume", paramAnonymousInt);
          localJSONObject.put("livePusherId", paramInt);
          parame.b(locala.LO(localJSONObject.toString()));
          AppMethodBeat.o(182553);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify fail", new Object[] { localJSONException });
          }
        }
      }
    });
    if (paramJSONObject.has("filterImage"))
    {
      localAppBrandLivePusherView.ciQ = paramJSONObject.optString("filterImage", localAppBrandLivePusherView.ciQ);
      localAppBrandLivePusherView.ciR = paramJSONObject.optString("filterImageMd5", null);
      if (!bs.isNullOrNil(localAppBrandLivePusherView.ciQ)) {
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
        localObject2 = localAppBrandLivePusherView.ktz;
        m.l("InitLivePusher", (Bundle)localObject1);
        ((m)localObject2).mVideoView = localAppBrandLivePusherView;
        ((m)localObject2).mVideoView.disableLog(false);
        ((m)localObject2).cjk = ((Bundle)localObject1).getString("pushUrl", "");
        ((m)localObject2).cji.setPusherUrl(((m)localObject2).cjk);
        ((m)localObject2).a((Bundle)localObject1, true);
        ((m)localObject2).cju = ((Bundle)localObject1).getBoolean("autopush", ((m)localObject2).cju);
        if ((((m)localObject2).cju) && (((m)localObject2).cjk != null) && (!((m)localObject2).cjk.isEmpty()) && (!((m)localObject2).cji.isPushing()))
        {
          ac.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          ((m)localObject2).bB(((m)localObject2).cjA);
          ((m)localObject2).bC(((m)localObject2).cjB);
          ((m)localObject2).cji.startPusher(((m)localObject2).cjk);
        }
        ((m)localObject2).mInited = true;
        localObject1 = new i();
        ac.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject1).errorCode), ((i)localObject1).chn });
        localObject1 = paramJSONObject.optString("backgroundImage");
        localObject2 = paramJSONObject.optString("backgroundMD5");
        if (!bs.isNullOrNil((String)localObject1)) {
          break label738;
        }
        ac.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("filterImage");
        if (!bs.isNullOrNil((String)localObject1)) {
          break label761;
        }
        ac.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        localObject1 = paramJSONObject.optString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (!bs.isNullOrNil((String)localObject1)) {
          break label783;
        }
        ac.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        localAppBrandLivePusherView.setContentDescription(paramView.getContext().getString(2131755289));
        AppMethodBeat.o(145881);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { localJSONException });
        continue;
      }
      label698:
      if ((localAppBrandLivePusherView.ciQ.startsWith("http://")) || (localAppBrandLivePusherView.ciQ.startsWith("https://")))
      {
        paramJSONObject.remove("filterImage");
        continue;
        label738:
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, (String)localObject2, new com.tencent.mm.plugin.appbrand.utils.b.a()
        {
          public final void Jr(String paramAnonymousString)
          {
            AppMethodBeat.i(145861);
            if (!bs.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ac.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("backgroundImage", paramAnonymousString);
              localAppBrandLivePusherView.H(localBundle);
              AppMethodBeat.o(145861);
              return;
            }
            ac.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10004, "load background image fail", paramAnonymousString);
            AppMethodBeat.o(145861);
          }
        });
        continue;
        label761:
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, null, new com.tencent.mm.plugin.appbrand.utils.b.a()
        {
          public final void Jr(String paramAnonymousString)
          {
            AppMethodBeat.i(182548);
            if (!bs.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ac.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
              Bundle localBundle = new Bundle();
              localBundle.putString("filterImage", paramAnonymousString);
              localAppBrandLivePusherView.H(localBundle);
              AppMethodBeat.o(182548);
              return;
            }
            ac.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("url", localJSONException);
            localAppBrandLivePusherView.a(10005, "load filter image fail", paramAnonymousString);
            AppMethodBeat.o(182548);
          }
        });
        continue;
        com.tencent.mm.plugin.appbrand.utils.b.a(parame, localJSONException, paramJSONObject, new com.tencent.mm.plugin.appbrand.utils.b.a()
        {
          public final void Jr(String paramAnonymousString)
          {
            AppMethodBeat.i(182549);
            if (!bs.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousString = q.k(paramAnonymousString, false);
              ac.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
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
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 783;
    private static final String NAME = "onLivePusherAudioVolume";
  }
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 515;
    private static final String NAME = "onLivePusherBGMComplete";
  }
  
  static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 514;
    private static final String NAME = "onLivePusherBGMProgress";
  }
  
  static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 513;
    private static final String NAME = "onLivePusherBGMStart";
  }
  
  static final class e
    extends ar
  {
    private static final int CTRL_INDEX = 531;
    private static final String NAME = "onLivePusherError";
  }
  
  static final class f
    extends ar
  {
    private static final int CTRL_INDEX = 411;
    private static final String NAME = "onLivePusherNetStatus";
  }
  
  static final class g
    extends ar
  {
    private static final int CTRL_INDEX = 368;
    private static final String NAME = "onLivePusherEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */