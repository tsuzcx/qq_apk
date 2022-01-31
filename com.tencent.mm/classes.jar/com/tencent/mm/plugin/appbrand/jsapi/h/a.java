package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j.b;
import com.tencent.mm.plugin.appbrand.k.a.b;
import com.tencent.mm.plugin.appbrand.k.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  String hTE = "";
  String hwp = "";
  long mTotalSize = -1L;
  
  private void s(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(114381);
    a.a.a(paramc, this.hwp, "fail", this.hTE);
    AppMethodBeat.o(114381);
  }
  
  public final String Ox()
  {
    return "loadTaskId";
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(114380);
    paramc = (h)paramc;
    this.hTE = paramJSONObject.optString("moduleName");
    if (bo.isNullOrNil(this.hTE))
    {
      ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      s(paramc);
      AppMethodBeat.o(114380);
      return;
    }
    paramJSONObject = paramc.getRuntime();
    if ((paramJSONObject == null) || (paramJSONObject.mFinished))
    {
      ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      s(paramc);
      AppMethodBeat.o(114380);
      return;
    }
    paramJSONObject = paramJSONObject.gPM;
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      s(paramc);
      AppMethodBeat.o(114380);
      return;
    }
    if (!paramJSONObject.aIe())
    {
      ab.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      s(paramc);
      AppMethodBeat.o(114380);
      return;
    }
    paramJSONObject.a(this.hTE, false, new a.b()new a.2
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(114374);
        ab.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s", new Object[] { paramAnonymousd.toString() });
        switch (a.3.hTG[paramAnonymousd.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(114374);
          return;
          a.a.a(paramc, a.this.hwp, "success", a.this.hTE);
          AppMethodBeat.o(114374);
          return;
          a.a.a(paramc, a.this.hwp, "fail", a.this.hTE);
          AppMethodBeat.o(114374);
          return;
          ab.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
          a.a.a(paramc, a.this.hwp, "fail", a.this.hTE);
        }
      }
    }, new a.2(this, paramc));
    AppMethodBeat.o(114380);
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(114379);
    if (bo.isNullOrNil(this.hwp))
    {
      localObject = new StringBuilder();
      com.tencent.mm.plugin.appbrand.m.c.aIh();
      this.hwp = com.tencent.mm.plugin.appbrand.m.c.aIg();
    }
    Object localObject = this.hwp;
    AppMethodBeat.o(114379);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a
 * JD-Core Version:    0.7.0.1
 */