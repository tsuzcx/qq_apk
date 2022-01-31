package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

public final class g
  extends a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(114356);
    if (paramc == null)
    {
      ab.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(114356);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(114356);
      return;
    }
    String str = paramJSONObject.optString("src");
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.h(paramInt, j("fail:data src is null", null));
      AppMethodBeat.o(114356);
      return;
    }
    if (paramc.wX() == null)
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramc.h(paramInt, j("fail:runtime fileSystem is null", null));
      AppMethodBeat.o(114356);
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
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    ab.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    d.f(new g.1(this, str, paramc, i, new WeakReference(paramc), paramInt), String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }));
    AppMethodBeat.o(114356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */