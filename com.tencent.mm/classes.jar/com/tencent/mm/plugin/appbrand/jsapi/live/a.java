package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.b;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Map;
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
    j.EX();
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
        ad.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
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
  
  public final void a(final e parame, int paramInt, View paramView, JSONObject paramJSONObject)
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
    Object localObject = new a.1(this, localAppBrandLivePlayerView);
    final f.d local2 = new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(145845);
        Object localObject = localAppBrandLivePlayerView.jSG;
        if (((l)localObject).jTg) {}
        for (localObject = ((l)localObject).h("resume", null);; localObject = new i())
        {
          ad.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).cko });
          AppMethodBeat.o(145845);
          return;
        }
      }
    };
    final a.3 local3 = new a.3(this, parame, localAppBrandLivePlayerView);
    a.4 local4 = new a.4(this, localAppBrandLivePlayerView, parame);
    parame.a(local2);
    parame.a(local3);
    parame.a(local4);
    localAppBrandLivePlayerView.setFullScreenDelegate(new a.5(this, parame, paramInt, (bv)localObject));
    localAppBrandLivePlayerView.setExitListener(new AppBrandLivePlayerView.b()
    {
      public final void bai()
      {
        AppMethodBeat.i(145851);
        parame.b(local3);
        parame.b(local2);
        AppMethodBeat.o(145851);
      }
    });
    localAppBrandLivePlayerView.setNeedEvent(paramJSONObject.optBoolean("needEvent", false));
    localAppBrandLivePlayerView.setOnFullScreenChangeListener(new a.7(this, paramInt, parame));
    paramJSONObject = k.O(paramJSONObject);
    localObject = localAppBrandLivePlayerView.jSG;
    l.l("initLivePlayer", paramJSONObject);
    ((l)localObject).mVideoView = localAppBrandLivePlayerView;
    ((l)localObject).mVideoView.disableLog(false);
    ((l)localObject).clh.setPlayerView(localAppBrandLivePlayerView);
    ((l)localObject).ckM = paramJSONObject.getString("playUrl", ((l)localObject).ckM);
    ((l)localObject).clk = ((l)localObject).n(paramJSONObject);
    ((l)localObject).a(paramJSONObject, true);
    ((l)localObject).ckP = paramJSONObject.getBoolean("autoplay", ((l)localObject).ckP);
    if ((((l)localObject).ckP) && (((l)localObject).ckM != null) && (!((l)localObject).ckM.isEmpty()))
    {
      ad.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      ((l)localObject).clh.startPlay(((l)localObject).ckM, ((l)localObject).clk);
    }
    ((l)localObject).mInited = true;
    localObject = new i();
    ad.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).cko });
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