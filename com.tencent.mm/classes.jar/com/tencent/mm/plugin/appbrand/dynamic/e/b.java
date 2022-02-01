package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.eclipsesource.mmv8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.d;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static boolean ojk;
  
  static
  {
    AppMethodBeat.i(121388);
    if (!ojk)
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOB, "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation --no-wasm-code-gc");
      Log.i("MicroMsg.Widget.AppBrandV8JsEngineImpl", "set v8 flag:%s", new Object[] { str });
      V8.setFlags(str);
      ojk = true;
      x.a(new x.a()
      {
        public final void hl(String paramAnonymousString)
        {
          AppMethodBeat.i(121386);
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(121386);
        }
      });
    }
    ojk = false;
    AppMethodBeat.o(121388);
  }
  
  public static d cC(Object paramObject)
  {
    AppMethodBeat.i(121387);
    paramObject = new a(paramObject);
    AppMethodBeat.o(121387);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.b
 * JD-Core Version:    0.7.0.1
 */