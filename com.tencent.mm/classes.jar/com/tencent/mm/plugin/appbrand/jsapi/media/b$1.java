package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString, c paramc, int paramInt1, WeakReference paramWeakReference, int paramInt2) {}
  
  public final void run()
  {
    if ((!bk.bl(this.val$filePath)) && (this.val$filePath.startsWith("wxfile://"))) {}
    c localc;
    for (Object localObject = new b.b((byte)0);; localObject = new b.d((byte)0))
    {
      localObject = ((b.c)localObject).a(this.ggE, this.val$filePath, this.gwb);
      if ((this.gwc.get() == null) || (!((c)this.gwc.get()).isRunning())) {
        break label236;
      }
      localc = (c)this.gwc.get();
      if ((((b.a)localObject).success) || (!bk.bl(((b.a)localObject).result))) {
        break;
      }
      y.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
      localc.C(this.dIS, this.gwd.h("fail:compress image fail", null));
      return;
    }
    if (!((b.a)localObject).success)
    {
      y.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((b.a)localObject).result });
      localc.C(this.dIS, this.gwd.h(((b.a)localObject).result, null));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("tempFilePath", ((b.a)localObject).result);
    localc.C(this.dIS, this.gwd.h("ok", localHashMap));
    return;
    label236:
    y.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b.1
 * JD-Core Version:    0.7.0.1
 */