package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(139870);
    if (paramc == null)
    {
      ae.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(139870);
      return;
    }
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(139870);
      return;
    }
    final String str = paramJSONObject.optString("src");
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.h(paramInt, e("fail:data src is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    if (paramc.Fl() == null)
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramc.h(paramInt, e("fail:runtime fileSystem is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    int j = paramJSONObject.optInt("quality", 80);
    final int i;
    if (j > 0)
    {
      i = j;
      if (j <= 100) {}
    }
    else
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    ae.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139867);
        if ((!bu.isNullOrNil(str)) && (str.startsWith("wxfile://"))) {}
        c localc;
        for (Object localObject = new h.b((byte)0);; localObject = new h.d((byte)0))
        {
          localObject = ((h.c)localObject).a(paramc, str, i);
          if ((this.daA.get() == null) || (!((c)this.daA.get()).isRunning())) {
            break label256;
          }
          localc = (c)this.daA.get();
          if ((((h.a)localObject).success) || (!bu.isNullOrNil(((h.a)localObject).result))) {
            break;
          }
          ae.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
          localc.h(paramInt, h.this.e("fail:compress image fail", null));
          AppMethodBeat.o(139867);
          return;
        }
        if (!((h.a)localObject).success)
        {
          ae.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((h.a)localObject).result });
          localc.h(paramInt, h.this.e(((h.a)localObject).result, null));
          AppMethodBeat.o(139867);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((h.a)localObject).result);
        localc.h(paramInt, h.this.n("ok", localHashMap));
        AppMethodBeat.o(139867);
        return;
        label256:
        ae.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
        AppMethodBeat.o(139867);
      }
    }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }));
    AppMethodBeat.o(139870);
  }
  
  static final class a
  {
    String result;
    boolean success;
    
    public a(boolean paramBoolean, String paramString)
    {
      this.success = paramBoolean;
      this.result = paramString;
    }
  }
  
  static abstract interface c
  {
    public abstract h.a a(c paramc, String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */