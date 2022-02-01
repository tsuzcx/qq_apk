package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends d
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145885);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145885);
    return i;
  }
  
  public final boolean b(final h paramh, int paramInt, View paramView, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(145886);
    Log.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145886);
      return false;
    }
    Object localObject1 = (View)((CoverViewContainer)paramView).aB(View.class);
    if (!(localObject1 instanceof AppBrandLivePlayerView))
    {
      Log.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145886);
      return false;
    }
    localObject1 = (AppBrandLivePlayerView)localObject1;
    Object localObject2 = paramJSONObject.optString("type");
    Log.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", new Object[] { localObject2 });
    if (((String)localObject2).equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePlayerView)localObject1).setSnapshotListener(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145884);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            Log.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
            parami.ZA(c.this.h("fail:snapshot error", null));
            AppMethodBeat.o(145884);
            return;
          }
          String str = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          com.tencent.mm.plugin.appbrand.ac.i locali;
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            locali = new com.tencent.mm.plugin.appbrand.ac.i();
            if (paramh.getFileSystem().a(new o(str), "jpg", true, locali) != m.kSu)
            {
              parami.ZA(c.this.h("fail:snapshot error", null));
              AppMethodBeat.o(145884);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            Log.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            parami.ZA(c.this.h("fail:snapshot error", null));
            AppMethodBeat.o(145884);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            Log.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          Log.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          parami.ZA(c.this.n("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145884);
        }
      });
      if (!((AppBrandLivePlayerView)localObject1).j("snapshot", paramJSONObject)) {
        parami.ZA(h("fail:snapshot error", null));
      }
      boolean bool = super.b(paramh, paramInt, paramView, paramJSONObject, parami);
      AppMethodBeat.o(145886);
      return bool;
    }
    if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
    {
      localObject2 = paramJSONObject.optJSONArray("data");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
      {
        Log.w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
        i = 0;
        label242:
        Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(i) });
        if (((AppBrandLivePlayerView)localObject1).lXD != null) {
          break label315;
        }
        Log.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
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
        parami.ZA(h((String)localObject1, null));
        break;
        i = ((JSONArray)localObject2).optInt(0, 0);
        break label242;
        if (((AppBrandLivePlayerView)localObject1).lXD.isFullScreen())
        {
          Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
          i = j;
          break label279;
        }
        ((AppBrandLivePlayerView)localObject1).lXD.xd(i);
        ((AppBrandLivePlayerView)localObject1).lXF = i;
        ((AppBrandLivePlayerView)localObject1).ht(true);
        i = j;
        break label279;
      }
    }
    if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
    {
      Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
      if (((AppBrandLivePlayerView)localObject1).lXD == null)
      {
        Log.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
        label413:
        if (i == 0) {
          break label479;
        }
      }
      label479:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        parami.ZA(h((String)localObject1, null));
        break;
        if (!((AppBrandLivePlayerView)localObject1).lXD.isFullScreen())
        {
          Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
          i = 1;
          break label413;
        }
        ((AppBrandLivePlayerView)localObject1).lXD.bGL();
        i = 1;
        break label413;
      }
    }
    if (((AppBrandLivePlayerView)localObject1).j((String)localObject2, paramJSONObject)) {}
    for (localObject1 = "ok";; localObject1 = "fail")
    {
      parami.ZA(h((String)localObject1, null));
      break;
    }
  }
  
  public final boolean bEV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */