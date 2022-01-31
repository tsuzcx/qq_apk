package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 363;
  public static final String NAME = "operateLivePusher";
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    AppMethodBeat.i(96115);
    ab.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96115);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      ab.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(96115);
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    String str = paramJSONObject.optString("type");
    ab.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new d.2(this, paramg, parame));
      if (!((AppBrandLivePusherView)localObject).d("snapshot", null)) {
        paramg.BS(j("fail:snapshot error", null));
      }
    }
    for (;;)
    {
      boolean bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(96115);
      return bool;
      if (str.equalsIgnoreCase("playBGM"))
      {
        str = paramJSONObject.optString("url");
        if (bo.isNullOrNil(str))
        {
          ab.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
          paramg.BS(j("fail:url is nil", null));
        }
        else
        {
          b.a(parame, str, null, new d.1(this, (AppBrandLivePusherView)localObject, str));
          paramg.BS(j("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).d(str, paramJSONObject))
      {
        paramg.BS(j("ok", null));
      }
      else
      {
        paramg.BS(j("fail", null));
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96114);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(96114);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */