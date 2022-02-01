package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.b;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 364;
  public static final String NAME = "insertLivePlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145857);
    int i = paramJSONObject.getInt("livePlayerId");
    AppMethodBeat.o(145857);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145858);
    paramJSONObject = new AppBrandLivePlayerView(parame.getContext());
    parame = new CoverViewContainer(parame.getContext(), paramJSONObject);
    parame.setBackgroundColor(-16777216);
    AppMethodBeat.o(145858);
    return parame;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145856);
    j.EB();
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      if (!(paramc.getContext() instanceof Activity))
      {
        ac.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
        paramc.h(paramInt, e("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      Activity localActivity = (Activity)paramc.getContext();
      try
      {
        int i = b.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
        if (i == 0)
        {
          super.a(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(145856);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
        paramc.h(paramInt, e("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(145856);
      return;
    }
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145856);
  }
  
  public final void a(final e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145859);
    ac.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145859);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePlayerView localAppBrandLivePlayerView = (AppBrandLivePlayerView)((CoverViewContainer)paramView).ax(AppBrandLivePlayerView.class);
    Object localObject = new bq()
    {
      public final void Cb()
      {
        AppMethodBeat.i(145844);
        AppBrandLivePlayerView localAppBrandLivePlayerView = localAppBrandLivePlayerView;
        ac.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        localAppBrandLivePlayerView.gr(false);
        AppMethodBeat.o(145844);
      }
    };
    final f.d local2 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145845);
        Object localObject = localAppBrandLivePlayerView.kts;
        if (((l)localObject).ktS) {}
        for (localObject = ((l)localObject).h("resume", null);; localObject = new i())
        {
          ac.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).chn });
          AppMethodBeat.o(145845);
          return;
        }
      }
    };
    final f.b local3 = new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145846);
        g.d locald = g.Hg(parame.getAppId());
        ac.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
        if (locald == g.d.jdi)
        {
          localAppBrandLivePlayerView.gz(2);
          AppMethodBeat.o(145846);
          return;
        }
        if (locald == g.d.jde)
        {
          localAppBrandLivePlayerView.gz(1);
          AppMethodBeat.o(145846);
          return;
        }
        localAppBrandLivePlayerView.gz(3);
        AppMethodBeat.o(145846);
      }
    };
    f.c local4 = new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145847);
        localAppBrandLivePlayerView.onExit();
        parame.b(this);
        AppMethodBeat.o(145847);
      }
    };
    parame.a(local2);
    parame.a(local3);
    parame.a(local4);
    localAppBrandLivePlayerView.setFullScreenDelegate(new AppBrandLivePlayerView.a()
    {
      public final void bha()
      {
        AppMethodBeat.i(145849);
        parame.fC(this.khp).sf(paramInt);
        AppMethodBeat.o(145849);
      }
      
      public final boolean isFullScreen()
      {
        AppMethodBeat.i(145850);
        boolean bool = parame.fC(this.khp).sg(paramInt);
        AppMethodBeat.o(145850);
        return bool;
      }
      
      public final void sC(int paramAnonymousInt)
      {
        AppMethodBeat.i(145848);
        parame.fC(this.khp).a(paramInt, this.ktG, paramAnonymousInt);
        AppMethodBeat.o(145848);
      }
    });
    localAppBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b()
    {
      public final void bhb()
      {
        AppMethodBeat.i(145851);
        parame.b(local3);
        parame.b(local2);
        AppMethodBeat.o(145851);
      }
    });
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new AppBrandLivePlayerView.c()
    {
      public final void p(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(145852);
        a.b localb = new a.b((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("fullScreen", paramAnonymousBoolean);
          localJSONObject.put("direction", paramAnonymousInt);
          localJSONObject.put("livePlayerId", paramInt);
          label53:
          parame.b(localb.LO(localJSONObject.toString()));
          AppMethodBeat.o(145852);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label53;
        }
      }
    });
    paramJSONObject = k.O(paramJSONObject);
    localObject = localAppBrandLivePlayerView.kts;
    l.l("initLivePlayer", paramJSONObject);
    ((l)localObject).mVideoView = localAppBrandLivePlayerView;
    ((l)localObject).mVideoView.disableLog(false);
    ((l)localObject).cij.setPlayerView(localAppBrandLivePlayerView);
    ((l)localObject).chO = paramJSONObject.getString("playUrl", ((l)localObject).chO);
    ((l)localObject).cim = ((l)localObject).n(paramJSONObject);
    ((l)localObject).a(paramJSONObject, true);
    ((l)localObject).chR = paramJSONObject.getBoolean("autoplay", ((l)localObject).chR);
    if ((((l)localObject).chR) && (((l)localObject).chO != null) && (!((l)localObject).chO.isEmpty()))
    {
      ac.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      ((l)localObject).cij.startPlay(((l)localObject).chO, ((l)localObject).cim);
    }
    ((l)localObject).mInited = true;
    localObject = new i();
    ac.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).chn });
    localAppBrandLivePlayerView.setPlayEventListener(new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(145854);
        a.c localc = new a.c((byte)0);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2;
        try
        {
          localJSONObject1.put("livePlayerId", paramInt);
          localJSONObject2 = new JSONObject();
          if (paramAnonymousBundle != null)
          {
            Iterator localIterator = paramAnonymousBundle.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localJSONObject2.put(str, paramAnonymousBundle.get(str));
              continue;
              parame.b(localc.LO(localJSONObject1.toString()));
            }
          }
        }
        catch (JSONException paramAnonymousBundle) {}
        for (;;)
        {
          AppMethodBeat.o(145854);
          return;
          localJSONObject1.put("info", localJSONObject2);
        }
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(145853);
        ac.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        a.d locald = new a.d((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", paramAnonymousInt);
          localJSONObject.put("errMsg", paramAnonymousBundle.getString("EVT_MSG"));
          localJSONObject.put("livePlayerId", paramInt);
          label76:
          parame.b(locald.LO(localJSONObject.toString()));
          AppMethodBeat.o(145853);
          return;
        }
        catch (JSONException paramAnonymousBundle)
        {
          break label76;
        }
      }
    });
    localAppBrandLivePlayerView.setAudioVolumeEventListener(new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(145855);
        a.a locala = new a.a((byte)0);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("livePlayerId", paramInt);
          localJSONObject.put("volume", paramAnonymousInt);
          label41:
          parame.b(locala.LO(localJSONObject.toString()));
          AppMethodBeat.o(145855);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label41;
        }
      }
    });
    if (paramJSONObject.getInt("mode", 0) == 5) {}
    for (parame = paramView.getContext().getString(2131755288);; parame = paramView.getContext().getString(2131755287))
    {
      localAppBrandLivePlayerView.setContentDescription(parame);
      AppMethodBeat.o(145859);
      return;
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 709;
    private static final String NAME = "onLivePlayerAudioVolume";
  }
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 371;
    private static final String NAME = "onLivePlayerFullScreenChange";
  }
  
  static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 412;
    private static final String NAME = "onLivePlayerNetStatus";
  }
  
  static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 369;
    private static final String NAME = "onLivePlayerEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a
 * JD-Core Version:    0.7.0.1
 */