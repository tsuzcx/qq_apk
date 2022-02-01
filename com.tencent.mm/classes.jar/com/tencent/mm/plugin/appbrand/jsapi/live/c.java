package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145885);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145885);
    return i;
  }
  
  public final boolean aYw()
  {
    return true;
  }
  
  public final boolean b(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(145886);
    ad.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145886);
      return false;
    }
    Object localObject1 = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(localObject1 instanceof AppBrandLivePlayerView))
    {
      ad.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145886);
      return false;
    }
    localObject1 = (AppBrandLivePlayerView)localObject1;
    Object localObject2 = paramJSONObject.optString("type");
    ad.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", new Object[] { localObject2 });
    if (((String)localObject2).equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePlayerView)localObject1).setSnapshotListener(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145884);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            ad.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
            paramg.HQ(c.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145884);
            return;
          }
          String str = b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          i locali;
          try
          {
            f.a(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            locali = new i();
            if (parame.Ee().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) != l.iSq)
            {
              paramg.HQ(c.this.e("fail:snapshot error", null));
              AppMethodBeat.o(145884);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            ad.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            paramg.HQ(c.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145884);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            ad.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          ad.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          paramg.HQ(c.this.k("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145884);
        }
      });
      if (!((AppBrandLivePlayerView)localObject1).g("snapshot", paramJSONObject)) {
        paramg.HQ(e("fail:snapshot error", null));
      }
      boolean bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(145886);
      return bool;
    }
    if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
    {
      localObject2 = paramJSONObject.optJSONArray("data");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
      {
        ad.w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
        i = 0;
        label242:
        ad.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(i) });
        if (((AppBrandLivePlayerView)localObject1).jSH != null) {
          break label315;
        }
        ad.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
        i = 0;
        label279:
        if (i == 0) {
          break label374;
        }
      }
      label315:
      label374:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        paramg.HQ(e((String)localObject1, null));
        break;
        i = ((JSONArray)localObject2).optInt(0, 0);
        break label242;
        if (((AppBrandLivePlayerView)localObject1).jSH.isFullScreen())
        {
          ad.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
          i = j;
          break label279;
        }
        ((AppBrandLivePlayerView)localObject1).jSH.rM(i);
        ((AppBrandLivePlayerView)localObject1).jSJ = i;
        ((AppBrandLivePlayerView)localObject1).fV(true);
        i = j;
        break label279;
      }
    }
    if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
      if (((AppBrandLivePlayerView)localObject1).jSH == null)
      {
        ad.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
        label413:
        if (i == 0) {
          break label479;
        }
      }
      label479:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        paramg.HQ(e((String)localObject1, null));
        break;
        if (!((AppBrandLivePlayerView)localObject1).jSH.isFullScreen())
        {
          ad.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
          i = 1;
          break label413;
        }
        ((AppBrandLivePlayerView)localObject1).jSH.bah();
        i = 1;
        break label413;
      }
    }
    if (((AppBrandLivePlayerView)localObject1).g((String)localObject2, paramJSONObject)) {}
    for (localObject1 = "ok";; localObject1 = "fail")
    {
      paramg.HQ(e((String)localObject1, null));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */