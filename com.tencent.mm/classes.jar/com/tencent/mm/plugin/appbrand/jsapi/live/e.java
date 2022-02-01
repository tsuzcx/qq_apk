package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends d
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145885);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145885);
    return i;
  }
  
  public final boolean b(final h paramh, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
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
    Object localObject1 = (View)((CoverViewContainer)paramView).aT(View.class);
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
            parami.aal(e.this.ZP("fail:snapshot error"));
            AppMethodBeat.o(145884);
            return;
          }
          String str = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          k localk;
          try
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            localk = new k();
            if (paramh.getFileSystem().a(new u(str), "jpg", true, localk) != r.qML)
            {
              parami.aal(e.this.ZP("fail:snapshot error"));
              AppMethodBeat.o(145884);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            Log.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            parami.aal(e.this.ZP("fail:snapshot error"));
            AppMethodBeat.o(145884);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            Log.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          Log.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", new Object[] { str, localk.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", localk.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          parami.aal(e.this.m("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145884);
        }
      });
      if (!((AppBrandLivePlayerView)localObject1).k("snapshot", paramJSONObject)) {
        parami.aal(ZP("fail:snapshot error"));
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
        label241:
        Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(i) });
        if (((AppBrandLivePlayerView)localObject1).saN != null) {
          break label313;
        }
        Log.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
        i = 0;
        label278:
        if (i == 0) {
          break label372;
        }
      }
      label313:
      label372:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        parami.aal(ZP((String)localObject1));
        break;
        i = ((JSONArray)localObject2).optInt(0, 0);
        break label241;
        if (((AppBrandLivePlayerView)localObject1).saN.isFullScreen())
        {
          Log.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
          i = j;
          break label278;
        }
        ((AppBrandLivePlayerView)localObject1).saN.AM(i);
        ((AppBrandLivePlayerView)localObject1).saP = i;
        ((AppBrandLivePlayerView)localObject1).jo(true);
        i = j;
        break label278;
      }
    }
    if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
    {
      Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
      if (((AppBrandLivePlayerView)localObject1).saN == null)
      {
        Log.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
        label411:
        if (i == 0) {
          break label476;
        }
      }
      label476:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        parami.aal(ZP((String)localObject1));
        break;
        if (!((AppBrandLivePlayerView)localObject1).saN.isFullScreen())
        {
          Log.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
          i = 1;
          break label411;
        }
        ((AppBrandLivePlayerView)localObject1).saN.csz();
        i = 1;
        break label411;
      }
    }
    if (((AppBrandLivePlayerView)localObject1).k((String)localObject2, paramJSONObject)) {}
    for (localObject1 = "ok";; localObject1 = "fail")
    {
      parami.aal(ZP((String)localObject1));
      break;
    }
  }
  
  public final boolean cqw()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.e
 * JD-Core Version:    0.7.0.1
 */