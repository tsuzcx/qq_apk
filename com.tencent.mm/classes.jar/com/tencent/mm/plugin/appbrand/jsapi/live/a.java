package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
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
    j.Ga();
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      if (!(paramc.getContext() instanceof Activity))
      {
        ad.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
        paramc.h(paramInt, e("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      Activity localActivity = (Activity)paramc.getContext();
      try
      {
        int i = android.support.v4.content.b.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
        if (i == 0)
        {
          super.a(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(145856);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
        paramc.h(paramInt, e("fail", null));
        AppMethodBeat.o(145856);
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(145856);
      return;
    }
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(145856);
  }
  
  public final void a(final e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145859);
    ad.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145859);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    final AppBrandLivePlayerView localAppBrandLivePlayerView = (AppBrandLivePlayerView)((CoverViewContainer)paramView).ax(AppBrandLivePlayerView.class);
    Object localObject = new bp()
    {
      public final void DA()
      {
        AppMethodBeat.i(145844);
        AppBrandLivePlayerView localAppBrandLivePlayerView = localAppBrandLivePlayerView;
        ad.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        localAppBrandLivePlayerView.gx(false);
        AppMethodBeat.o(145844);
      }
    };
    final f.d local2 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145845);
        Object localObject = localAppBrandLivePlayerView.kOO;
        if (((l)localObject).kPo) {}
        for (localObject = ((l)localObject).h("resume", null);; localObject = new i())
        {
          ad.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).crF });
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
        g.d locald = g.Kv(parame.getAppId());
        ad.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
        if (locald == g.d.jwr)
        {
          localAppBrandLivePlayerView.gE(2);
          AppMethodBeat.o(145846);
          return;
        }
        if (locald == g.d.jwn)
        {
          localAppBrandLivePlayerView.gE(1);
          AppMethodBeat.o(145846);
          return;
        }
        localAppBrandLivePlayerView.gE(3);
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
      public final void bkF()
      {
        AppMethodBeat.i(145849);
        parame.fG(this.kCg).sH(paramInt);
        AppMethodBeat.o(145849);
      }
      
      public final boolean isFullScreen()
      {
        AppMethodBeat.i(145850);
        boolean bool = parame.fG(this.kCg).sI(paramInt);
        AppMethodBeat.o(145850);
        return bool;
      }
      
      public final void te(int paramAnonymousInt)
      {
        AppMethodBeat.i(145848);
        parame.fG(this.kCg).a(paramInt, this.kPc, paramAnonymousInt);
        AppMethodBeat.o(145848);
      }
    });
    localAppBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b()
    {
      public final void bkG()
      {
        AppMethodBeat.i(145851);
        parame.b(local3);
        parame.b(local2);
        AppMethodBeat.o(145851);
      }
    });
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new a.7(this, paramInt, parame));
    paramJSONObject = k.P(paramJSONObject);
    localObject = localAppBrandLivePlayerView.kOO;
    l.l("initLivePlayer", paramJSONObject);
    ((l)localObject).mVideoView = localAppBrandLivePlayerView;
    ((l)localObject).mVideoView.disableLog(false);
    ((l)localObject).csy.setPlayerView(localAppBrandLivePlayerView);
    ((l)localObject).csd = paramJSONObject.getString("playUrl", ((l)localObject).csd);
    ((l)localObject).csB = ((l)localObject).n(paramJSONObject);
    ((l)localObject).a(paramJSONObject, true);
    ((l)localObject).csg = paramJSONObject.getBoolean("autoplay", ((l)localObject).csg);
    if ((((l)localObject).csg) && (((l)localObject).csd != null) && (!((l)localObject).csd.isEmpty()))
    {
      ad.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      ((l)localObject).csy.startPlay(((l)localObject).csd, ((l)localObject).csB);
    }
    ((l)localObject).mInited = true;
    localObject = new i();
    ad.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).crF });
    localAppBrandLivePlayerView.setPlayEventListener(new a.8(this, paramInt, parame));
    localAppBrandLivePlayerView.setAudioVolumeEventListener(new a.9(this, paramInt, parame));
    if (paramJSONObject.getInt("mode", 0) == 5) {}
    for (parame = paramView.getContext().getString(2131755288);; parame = paramView.getContext().getString(2131755287))
    {
      localAppBrandLivePlayerView.setContentDescription(parame);
      AppMethodBeat.o(145859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a
 * JD-Core Version:    0.7.0.1
 */