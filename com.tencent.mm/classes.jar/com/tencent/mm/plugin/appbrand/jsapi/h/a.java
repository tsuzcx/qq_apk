package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  String gep = "";
  String gxj = "";
  long mTotalSize = -1L;
  
  private void l(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    a.a.a(paramc, this.gep, "fail", this.gxj);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    paramc = (f)paramc;
    this.gxj = paramJSONObject.optString("moduleName");
    if (bk.bl(this.gxj))
    {
      y.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      l(paramc);
      return;
    }
    paramJSONObject = paramc.getRuntime();
    if ((paramJSONObject == null) || (paramJSONObject.mFinished))
    {
      y.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      l(paramc);
      return;
    }
    paramJSONObject = paramJSONObject.fyz;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      l(paramc);
      return;
    }
    if (!paramJSONObject.amA())
    {
      y.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      a.a.b(paramc, this.gep, "fail", this.gxj, 0, -1L, -1L);
      return;
    }
    paramJSONObject.a(this.gxj, false, new a.1(this, paramc), new com.tencent.mm.plugin.appbrand.m.a.a()
    {
      public final void a(d paramAnonymousd)
      {
        y.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { a.this.gxj, paramAnonymousd.toString() });
        a.this.mTotalSize = paramAnonymousd.acm();
        a.a.b(paramc, a.this.gep, "progressUpdate", a.this.gxj, paramAnonymousd.getProgress(), paramAnonymousd.acl(), paramAnonymousd.acm());
      }
    });
  }
  
  protected final String ajy()
  {
    if (bk.bl(this.gep))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.plugin.appbrand.o.c.amD();
      this.gep = com.tencent.mm.plugin.appbrand.o.c.amC();
    }
    return this.gep;
  }
  
  protected final String ajz()
  {
    return "loadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a
 * JD-Core Version:    0.7.0.1
 */