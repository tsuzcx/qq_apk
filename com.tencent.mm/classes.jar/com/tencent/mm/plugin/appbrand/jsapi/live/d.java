package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.base.d
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
  
  public final boolean b(final e parame, int paramInt, View paramView, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(145890);
    ae.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145890);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      ae.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145890);
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    final String str = paramJSONObject.optString("type");
    ae.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145888);
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            ae.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            parami.PZ(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          String str = b.asv() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          com.tencent.mm.plugin.appbrand.y.i locali;
          try
          {
            h.a(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
            locali = new com.tencent.mm.plugin.appbrand.y.i();
            if (parame.Fl().a(new k(str), "jpg", true, locali) != com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
            {
              parami.PZ(d.this.e("fail:snapshot error", null));
              AppMethodBeat.o(145888);
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            ae.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            parami.PZ(d.this.e("fail:snapshot error", null));
            AppMethodBeat.o(145888);
            return;
          }
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            ae.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + paramAnonymousBitmap.toString());
            paramAnonymousBitmap.recycle();
          }
          ae.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[] { str, locali.value });
          paramAnonymousBitmap = new HashMap();
          paramAnonymousBitmap.put("tempImagePath", locali.value);
          paramAnonymousBitmap.put("width", Integer.valueOf(i));
          paramAnonymousBitmap.put("height", Integer.valueOf(j));
          parami.PZ(d.this.n("ok", paramAnonymousBitmap));
          AppMethodBeat.o(145888);
        }
      });
      if (!((AppBrandLivePusherView)localObject).g("snapshot", paramJSONObject)) {
        parami.PZ(e("fail:snapshot error", null));
      }
    }
    for (;;)
    {
      boolean bool = super.b(parame, paramInt, paramView, paramJSONObject, parami);
      AppMethodBeat.o(145890);
      return bool;
      if (str.equalsIgnoreCase("playBGM"))
      {
        str = paramJSONObject.optString("url");
        if (bu.isNullOrNil(str))
        {
          ae.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
          parami.PZ(e("fail:url is nil", null));
        }
        else
        {
          c.a(parame, str, null, new c.a()
          {
            public final void Nr(String paramAnonymousString)
            {
              AppMethodBeat.i(145887);
              if (!bu.isNullOrNil(paramAnonymousString))
              {
                ae.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", new Object[] { paramAnonymousString });
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("BGMFilePath", paramAnonymousString);
                  if (!this.kSO.g("playBGM", localJSONObject))
                  {
                    ae.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { str });
                    paramAnonymousString = new HashMap();
                    paramAnonymousString.put("url", str);
                    this.kSO.a(10003, "download file fail", paramAnonymousString);
                  }
                  AppMethodBeat.o(145887);
                  return;
                }
                catch (JSONException paramAnonymousString)
                {
                  for (;;)
                  {
                    ae.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { paramAnonymousString });
                  }
                }
              }
              ae.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { str });
              paramAnonymousString = new HashMap();
              paramAnonymousString.put("url", str);
              this.kSO.a(10003, "download file fail", paramAnonymousString);
              AppMethodBeat.o(145887);
            }
          });
          parami.PZ(e("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).g(str, paramJSONObject))
      {
        parami.PZ(e("ok", null));
      }
      else
      {
        parami.PZ(e("fail", null));
      }
    }
  }
  
  public final boolean bjF()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */