package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveBase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends b
{
  private static final int CTRL_INDEX = 364;
  public static final String NAME = "insertLivePlayer";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145857);
    int i = paramJSONObject.getInt("livePlayerId");
    AppMethodBeat.o(145857);
    return i;
  }
  
  public final View a(g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145858);
    paramJSONObject = new AppBrandLivePlayerView(paramg.getContext());
    paramg = new CoverViewContainer(paramg.getContext(), paramJSONObject);
    paramg.setBackgroundColor(-16777216);
    AppMethodBeat.o(145858);
    return paramg;
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145856);
    l.bSv();
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      if (!(parame.getContext() instanceof Activity))
      {
        Log.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
        parame.j(paramInt, h("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      Activity localActivity = (Activity)parame.getContext();
      try
      {
        int i = androidx.core.content.a.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
        if (i == 0)
        {
          super.a(parame, paramJSONObject, paramInt);
          AppMethodBeat.o(145856);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
        parame.j(paramInt, h("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(145856);
      return;
    }
    super.a(parame, paramJSONObject, paramInt);
    AppMethodBeat.o(145856);
  }
  
  public final void a(final g paramg, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145859);
    Log.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145859);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { paramg.getAppId() }));
    final AppBrandLivePlayerView localAppBrandLivePlayerView = (AppBrandLivePlayerView)((CoverViewContainer)paramView).aA(AppBrandLivePlayerView.class);
    Object localObject = new bx()
    {
      public final void PS()
      {
        AppMethodBeat.i(145844);
        AppBrandLivePlayerView localAppBrandLivePlayerView = localAppBrandLivePlayerView;
        Log.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        localAppBrandLivePlayerView.ik(false);
        AppMethodBeat.o(145844);
      }
    };
    final h.d local2 = new h.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145845);
        k localk = localAppBrandLivePlayerView.oVp.Ty();
        Log.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        AppMethodBeat.o(145845);
      }
    };
    final h.b local3 = new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145846);
        k.d locald = com.tencent.mm.plugin.appbrand.k.abM(paramg.getAppId());
        Log.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
        if (locald == k.d.nth)
        {
          localAppBrandLivePlayerView.iW(2);
          AppMethodBeat.o(145846);
          return;
        }
        if (locald == k.d.ntd)
        {
          localAppBrandLivePlayerView.iW(1);
          AppMethodBeat.o(145846);
          return;
        }
        localAppBrandLivePlayerView.iW(3);
        AppMethodBeat.o(145846);
      }
    };
    h.c local4 = new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145847);
        localAppBrandLivePlayerView.onExit();
        paramg.b(this);
        AppMethodBeat.o(145847);
      }
    };
    paramg.a(local2);
    paramg.a(local3);
    paramg.a(local4);
    localAppBrandLivePlayerView.setFullScreenDelegate(new AppBrandLivePlayerView.a()
    {
      public final void Az(int paramAnonymousInt)
      {
        AppMethodBeat.i(145848);
        paramg.hl(this.oGm).a(paramInt, this.oVC, paramAnonymousInt);
        AppMethodBeat.o(145848);
      }
      
      public final boolean QT()
      {
        AppMethodBeat.i(145850);
        boolean bool = paramg.hl(this.oGm).zW(paramInt);
        AppMethodBeat.o(145850);
        return bool;
      }
      
      public final void bSs()
      {
        AppMethodBeat.i(145849);
        paramg.hl(this.oGm).zV(paramInt);
        AppMethodBeat.o(145849);
      }
    });
    localAppBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b()
    {
      public final void bSt()
      {
        AppMethodBeat.i(145851);
        paramg.b(local3);
        paramg.b(local2);
        AppMethodBeat.o(145851);
      }
    });
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new c.7(this, paramInt, paramg));
    paramJSONObject = n.ac(paramJSONObject);
    localObject = localAppBrandLivePlayerView.oVp.a(localAppBrandLivePlayerView, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject).errorCode), ((k)localObject).errorInfo });
    localAppBrandLivePlayerView.setPlayEventListener(new c.8(this, paramInt, paramg));
    localAppBrandLivePlayerView.setAudioVolumeEventListener(new c.9(this, paramInt, paramg));
    if (paramJSONObject.getInt("mode", 0) == 5) {}
    for (paramg = paramView.getContext().getString(a.a.app_brand_accessibility_live_player_mode_rtc);; paramg = paramView.getContext().getString(a.a.app_brand_accessibility_live_player_mode_live))
    {
      localAppBrandLivePlayerView.setContentDescription(paramg);
      AppMethodBeat.o(145859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */