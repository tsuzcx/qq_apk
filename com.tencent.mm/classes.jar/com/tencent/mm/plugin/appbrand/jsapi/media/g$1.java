package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class g$1
  implements Runnable
{
  g$1(g paramg, String paramString, c paramc, int paramInt1, WeakReference paramWeakReference, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(114353);
    if ((!bo.isNullOrNil(this.val$filePath)) && (this.val$filePath.startsWith("wxfile://"))) {}
    c localc;
    for (Object localObject = new g.b((byte)0);; localObject = new g.d((byte)0))
    {
      localObject = ((g.c)localObject).a(this.hza, this.val$filePath, this.hRW);
      if ((this.hRX.get() == null) || (!((c)this.hRX.get()).isRunning())) {
        break label256;
      }
      localc = (c)this.hRX.get();
      if ((((g.a)localObject).success) || (!bo.isNullOrNil(((g.a)localObject).result))) {
        break;
      }
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
      localc.h(this.bAX, this.hRY.j("fail:compress image fail", null));
      AppMethodBeat.o(114353);
      return;
    }
    if (!((g.a)localObject).success)
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((g.a)localObject).result });
      localc.h(this.bAX, this.hRY.j(((g.a)localObject).result, null));
      AppMethodBeat.o(114353);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("tempFilePath", ((g.a)localObject).result);
    localc.h(this.bAX, this.hRY.j("ok", localHashMap));
    AppMethodBeat.o(114353);
    return;
    label256:
    ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
    AppMethodBeat.o(114353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g.1
 * JD-Core Version:    0.7.0.1
 */