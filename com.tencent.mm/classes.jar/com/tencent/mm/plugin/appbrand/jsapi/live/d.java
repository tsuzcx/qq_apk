package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  
  public final boolean b(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    AppMethodBeat.i(145890);
    ac.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145890);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      ac.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145890);
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    final String str = paramJSONObject.optString("type");
    ac.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145888);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            ac.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            paramg.LV(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          String str = com.tencent.mm.loader.j.b.aps() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          i locali;
          try
          {
            f.a(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            locali = new i();
            if (parame.DH().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) != l.jsB)
            {
              paramg.LV(d.this.e("fail:snapshot error", null));
              AppMethodBeat.o(145888);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            ac.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            paramg.LV(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            ac.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          ac.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          paramg.LV(d.this.k("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145888);
        }
      });
      if (!((AppBrandLivePusherView)localObject).g("snapshot", paramJSONObject)) {
        paramg.LV(e("fail:snapshot error", null));
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
        if (bs.isNullOrNil(str))
        {
          ac.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
          paramg.LV(e("fail:url is nil", null));
        }
        else
        {
          com.tencent.mm.plugin.appbrand.utils.b.a(parame, str, null, new b.a()
          {
            public final void Jr(String paramAnonymousString)
            {
              AppMethodBeat.i(145887);
              if (!bs.isNullOrNil(paramAnonymousString))
              {
                ac.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", new Object[] { paramAnonymousString });
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("BGMFilePath", paramAnonymousString);
                  if (!this.ktK.g("playBGM", localJSONObject))
                  {
                    ac.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { str });
                    paramAnonymousString = new HashMap();
                    paramAnonymousString.put("url", str);
                    this.ktK.a(10003, "download file fail", paramAnonymousString);
                  }
                  AppMethodBeat.o(145887);
                  return;
                }
                catch (JSONException paramAnonymousString)
                {
                  for (;;)
                  {
                    ac.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { paramAnonymousString });
                  }
                }
              }
              ac.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { str });
              paramAnonymousString = new HashMap();
              paramAnonymousString.put("url", str);
              this.ktK.a(10003, "download file fail", paramAnonymousString);
              AppMethodBeat.o(145887);
            }
          });
          paramg.LV(e("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).g(str, paramJSONObject))
      {
        paramg.LV(e("ok", null));
      }
      else
      {
        paramg.LV(e("fail", null));
      }
    }
  }
  
  public final boolean bft()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */