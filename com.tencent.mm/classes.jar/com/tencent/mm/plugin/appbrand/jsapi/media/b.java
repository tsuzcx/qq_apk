package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      y.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      return;
    }
    if (paramJSONObject == null)
    {
      y.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.C(paramInt, h("fail:invalid data", null));
      return;
    }
    String str = paramJSONObject.optString("src");
    if (bk.bl(str))
    {
      y.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.C(paramInt, h("fail:data src is null", null));
      return;
    }
    if (paramc.Zl() == null)
    {
      y.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramc.C(paramInt, h("fail:runtime fileSystem is null", null));
      return;
    }
    int j = paramJSONObject.optInt("quality", 80);
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= 100) {}
    }
    else
    {
      y.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    y.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    e.a(new b.1(this, str, paramc, i, new WeakReference(paramc), paramInt), String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }), 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b
 * JD-Core Version:    0.7.0.1
 */