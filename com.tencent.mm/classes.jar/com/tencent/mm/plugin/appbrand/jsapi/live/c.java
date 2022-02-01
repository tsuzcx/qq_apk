package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.by;
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
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145857);
    int i = paramJSONObject.getInt("livePlayerId");
    AppMethodBeat.o(145857);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145858);
    paramJSONObject = new AppBrandLivePlayerView(paramh.getContext());
    paramh = new CoverViewContainer(paramh.getContext(), paramJSONObject);
    paramh.setBackgroundColor(-16777216);
    AppMethodBeat.o(145858);
    return paramh;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145856);
    l.csC();
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      if (!(paramf.getContext() instanceof Activity))
      {
        Log.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
        paramf.callback(paramInt, ZP("fail"));
        AppMethodBeat.o(145856);
        return;
      }
      Activity localActivity = (Activity)paramf.getContext();
      try
      {
        int i = androidx.core.content.a.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
        if (i == 0)
        {
          super.a(paramf, paramJSONObject, paramInt);
          AppMethodBeat.o(145856);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
        paramf.callback(paramInt, ZP("fail"));
        AppMethodBeat.o(145856);
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, m("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(145856);
      return;
    }
    super.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(145856);
  }
  
  public final void a(final h paramh, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145859);
    Log.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145859);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { paramh.getAppId() }));
    final AppBrandLivePlayerView localAppBrandLivePlayerView = (AppBrandLivePlayerView)((CoverViewContainer)paramView).aT(AppBrandLivePlayerView.class);
    Object localObject = new by()
    {
      public final void aqb()
      {
        AppMethodBeat.i(145844);
        AppBrandLivePlayerView localAppBrandLivePlayerView = localAppBrandLivePlayerView;
        Log.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        localAppBrandLivePlayerView.jo(false);
        AppMethodBeat.o(145844);
      }
    };
    final i.d local2 = new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145845);
        k localk = localAppBrandLivePlayerView.saM.aud();
        Log.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
        AppMethodBeat.o(145845);
      }
    };
    final i.b local3 = new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(145846);
        k.d locald = com.tencent.mm.plugin.appbrand.k.Uo(paramh.getAppId());
        Log.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
        if (locald == k.d.qrM)
        {
          localAppBrandLivePlayerView.my(2);
          AppMethodBeat.o(145846);
          return;
        }
        if (locald == k.d.qrI)
        {
          localAppBrandLivePlayerView.my(1);
          AppMethodBeat.o(145846);
          return;
        }
        localAppBrandLivePlayerView.my(3);
        AppMethodBeat.o(145846);
      }
    };
    i.c local4 = new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(145847);
        localAppBrandLivePlayerView.onExit();
        paramh.b(this);
        AppMethodBeat.o(145847);
      }
    };
    paramh.a(local2);
    paramh.a(local3);
    paramh.a(local4);
    localAppBrandLivePlayerView.setFullScreenDelegate(new AppBrandLivePlayerView.a()
    {
      public final void AM(int paramAnonymousInt)
      {
        AppMethodBeat.i(145848);
        paramh.ic(this.rJl).a(paramInt, this.saZ, paramAnonymousInt);
        AppMethodBeat.o(145848);
      }
      
      public final void csz()
      {
        AppMethodBeat.i(145849);
        paramh.ic(this.rJl).An(paramInt);
        AppMethodBeat.o(145849);
      }
      
      public final boolean isFullScreen()
      {
        AppMethodBeat.i(145850);
        boolean bool = paramh.ic(this.rJl).Ao(paramInt);
        AppMethodBeat.o(145850);
        return bool;
      }
    });
    localAppBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b()
    {
      public final void csA()
      {
        AppMethodBeat.i(145851);
        paramh.b(local3);
        paramh.b(local2);
        AppMethodBeat.o(145851);
      }
    });
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new c.7(this, paramInt, paramh));
    paramJSONObject = n.am(paramJSONObject);
    localObject = localAppBrandLivePlayerView.saM.a(localAppBrandLivePlayerView, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject).errorCode), ((k)localObject).errorInfo });
    localAppBrandLivePlayerView.setPlayEventListener(new c.8(this, paramInt, paramh));
    localAppBrandLivePlayerView.setAudioVolumeEventListener(new c.9(this, paramInt, paramh));
    if (paramJSONObject.getInt("mode", 0) == 5) {}
    for (paramh = paramView.getContext().getString(a.a.app_brand_accessibility_live_player_mode_rtc);; paramh = paramView.getContext().getString(a.a.app_brand_accessibility_live_player_mode_live))
    {
      localAppBrandLivePlayerView.setContentDescription(paramh);
      AppMethodBeat.o(145859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */