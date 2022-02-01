package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 363;
  public static final String NAME = "operateLivePusher";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145889);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(145889);
    return i;
  }
  
  public final boolean aYw()
  {
    return true;
  }
  
  public final boolean b(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    AppMethodBeat.i(145890);
    ad.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145890);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      ad.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145890);
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    final String str = paramJSONObject.optString("type");
    ad.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145888);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            ad.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            paramg.HQ(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          String str = com.tencent.mm.loader.j.b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          i locali;
          try
          {
            f.a(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            locali = new i();
            if (parame.Ee().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) != l.iSq)
            {
              paramg.HQ(d.this.e("fail:snapshot error", null));
              AppMethodBeat.o(145888);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            ad.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            paramg.HQ(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            ad.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          ad.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          paramg.HQ(d.this.k("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145888);
        }
      });
      if (!((AppBrandLivePusherView)localObject).g("snapshot", paramJSONObject)) {
        paramg.HQ(e("fail:snapshot error", null));
      }
    }
    for (;;)
    {
      boolean bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(145890);
      return bool;
      if (str.equalsIgnoreCase("playBGM"))
      {
        str = paramJSONObject.optString("url");
        if (bt.isNullOrNil(str))
        {
          ad.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
          paramg.HQ(e("fail:url is nil", null));
        }
        else
        {
          com.tencent.mm.plugin.appbrand.utils.b.a(parame, str, null, new b.a()
          {
            public final void Fn(String paramAnonymousString)
            {
              AppMethodBeat.i(145887);
              if (!bt.isNullOrNil(paramAnonymousString))
              {
                ad.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", new Object[] { paramAnonymousString });
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("BGMFilePath", paramAnonymousString);
                  if (!this.jSY.g("playBGM", localJSONObject))
                  {
                    ad.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { str });
                    paramAnonymousString = new HashMap();
                    paramAnonymousString.put("url", str);
                    this.jSY.a(10003, "download file fail", paramAnonymousString);
                  }
                  AppMethodBeat.o(145887);
                  return;
                }
                catch (JSONException paramAnonymousString)
                {
                  for (;;)
                  {
                    ad.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { paramAnonymousString });
                  }
                }
              }
              ad.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { str });
              paramAnonymousString = new HashMap();
              paramAnonymousString.put("url", str);
              this.jSY.a(10003, "download file fail", paramAnonymousString);
              AppMethodBeat.o(145887);
            }
          });
          paramg.HQ(e("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).g(str, paramJSONObject))
      {
        paramg.HQ(e("ok", null));
      }
      else
      {
        paramg.HQ(e("fail", null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */