package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends d
{
  private static final int CTRL_INDEX = 363;
  public static final String NAME = "operateLivePusher";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145889);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(145889);
    return i;
  }
  
  public final boolean b(final g paramg, int paramInt, View paramView, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(145890);
    Log.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145890);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).aA(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      Log.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145890);
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    final String str = paramJSONObject.optString("type");
    Log.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145888);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            Log.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            parami.aho(f.this.h("fail:snapshot error", null));
            AppMethodBeat.o(145888);
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
            if (paramg.getFileSystem().a(new q(str), "jpg", true, locali) != m.nMR)
            {
              parami.aho(f.this.h("fail:snapshot error", null));
              AppMethodBeat.o(145888);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            Log.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            parami.aho(f.this.h("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            Log.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          Log.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          parami.aho(f.this.m("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145888);
        }
      });
      if (!((AppBrandLivePusherView)localObject).j("snapshot", paramJSONObject)) {
        parami.aho(h("fail:snapshot error", null));
      }
    }
    for (;;)
    {
      boolean bool = super.b(paramg, paramInt, paramView, paramJSONObject, parami);
      AppMethodBeat.o(145890);
      return bool;
      if (str.equalsIgnoreCase("playBGM"))
      {
        str = paramJSONObject.optString("url");
        if (Util.isNullOrNil(str))
        {
          Log.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
          parami.aho(h("fail:url is nil", null));
        }
        else
        {
          e.a(paramg, str, null, new e.a()
          {
            public final void dR(String paramAnonymousString)
            {
              AppMethodBeat.i(145887);
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                String str = u.n(paramAnonymousString, false);
                Log.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s, realLocalPath: %s", new Object[] { paramAnonymousString, str });
                paramAnonymousString = new JSONObject();
                try
                {
                  paramAnonymousString.put("BGMFilePath", str);
                  if (!this.oVG.j("playBGM", paramAnonymousString))
                  {
                    Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { str });
                    paramAnonymousString = new HashMap();
                    paramAnonymousString.put("url", str);
                    this.oVG.a(10003, "download file fail", paramAnonymousString);
                  }
                  AppMethodBeat.o(145887);
                  return;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { localJSONException });
                  }
                }
              }
              Log.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { str });
              paramAnonymousString = new HashMap();
              paramAnonymousString.put("url", str);
              this.oVG.a(10003, "download file fail", paramAnonymousString);
              AppMethodBeat.o(145887);
            }
          });
          parami.aho(h("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).j(str, paramJSONObject))
      {
        parami.aho(h("ok", null));
      }
      else
      {
        parami.aho(h("fail", null));
      }
    }
  }
  
  public final boolean bQz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.f
 * JD-Core Version:    0.7.0.1
 */