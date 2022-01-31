package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 363;
  public static final String NAME = "operateLivePusher";
  
  protected final boolean a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    y.i("MicroMsg.JsApiOperateLivePusher.javayhu", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiOperateLivePusher.javayhu", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(localObject instanceof AppBrandLivePusherView))
    {
      y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "targetView not AppBrandLivePusherView");
      return false;
    }
    localObject = (AppBrandLivePusherView)localObject;
    String str = paramJSONObject.optString("type");
    y.i("MicroMsg.JsApiOperateLivePusher.javayhu", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePusherView)localObject).setSnapshotListener(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
          {
            y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "onSnapshot: bitmap nil");
            paramg.tT(e.this.h("fail", null));
            return;
          }
          Object localObject = ((com.tencent.luggage.f.a)com.tencent.luggage.b.e.i(com.tencent.luggage.f.a.class)).qt() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
          int i = paramAnonymousBitmap.getWidth();
          int j = paramAnonymousBitmap.getHeight();
          try
          {
            com.tencent.mm.sdk.platformtools.c.a(paramAnonymousBitmap, 90, Bitmap.CompressFormat.JPEG, (String)localObject, true);
            paramAnonymousBitmap = new com.tencent.mm.plugin.appbrand.u.k();
            if (parame.Zl().a(new File((String)localObject), "jpg", true, paramAnonymousBitmap) != h.fGU)
            {
              paramg.tT(e.this.h("fail save snapshot failed", null));
              return;
            }
          }
          catch (IOException paramAnonymousBitmap)
          {
            y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "onSnapshot: exception %s", new Object[] { paramAnonymousBitmap.getMessage() });
            paramg.tT(e.this.h("fail", null));
            return;
          }
          y.i("MicroMsg.JsApiOperateLivePusher.javayhu", "onSnapshot: actualPath:%s path:%s", new Object[] { localObject, paramAnonymousBitmap.value });
          localObject = new HashMap();
          ((Map)localObject).put("tempImagePath", paramAnonymousBitmap.value);
          ((Map)localObject).put("width", Integer.valueOf(i));
          ((Map)localObject).put("height", Integer.valueOf(j));
          paramg.tT(e.this.h("ok", (Map)localObject));
        }
      });
      if (!((AppBrandLivePusherView)localObject).b("snapshot", null)) {
        paramg.tT(h("fail", null));
      }
    }
    for (;;)
    {
      return super.a(parame, paramInt, paramView, paramJSONObject, paramg);
      if (str.equalsIgnoreCase("playBGM"))
      {
        str = paramJSONObject.optString("url");
        if (bk.bl(str))
        {
          y.w("MicroMsg.JsApiOperateLivePusher.javayhu", "operatePlayBgm, url is nil");
          paramg.tT(h("fail:url is nil", null));
        }
        else
        {
          a.a(parame, str, null, new e.1(this, (AppBrandLivePusherView)localObject, str));
          paramg.tT(h("ok", null));
        }
      }
      else if (((AppBrandLivePusherView)localObject).b(str, paramJSONObject))
      {
        paramg.tT(h("ok", null));
      }
      else
      {
        paramg.tT(h("fail", null));
      }
    }
  }
  
  protected final boolean aik()
  {
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.e
 * JD-Core Version:    0.7.0.1
 */