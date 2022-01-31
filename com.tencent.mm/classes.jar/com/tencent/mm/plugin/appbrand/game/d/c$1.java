package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.page.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class c$1
  implements Runnable
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.game.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    if (!this.gbY.isRunning())
    {
      y.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
      this.gbY.C(this.dIS, this.gca.h("fail", null));
      return;
    }
    Object localObject = this.gbY.E(q.class);
    if (!(localObject instanceof f))
    {
      this.gbY.C(this.dIS, this.gca.h("fail", null));
      return;
    }
    localObject = c.a((f)localObject, this.gbZ, false);
    this.gbY.C(this.dIS, this.gca.h(((f.a)localObject).aox, ((f.a)localObject).values));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.c.1
 * JD-Core Version:    0.7.0.1
 */