package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  private static boolean kkP;
  
  static
  {
    AppMethodBeat.i(121388);
    if (!kkP)
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJq, "");
      ae.i("MicroMsg.Widget.AppBrandV8JsEngineImpl", "set v8 flag:%s", new Object[] { str });
      V8.setFlags(str);
      kkP = true;
      x.a(new x.a()
      {
        public final void fN(String paramAnonymousString)
        {
          AppMethodBeat.i(121386);
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(121386);
        }
      });
    }
    kkP = false;
    AppMethodBeat.o(121388);
  }
  
  public static d ct(Object paramObject)
  {
    AppMethodBeat.i(121387);
    paramObject = new a(paramObject);
    AppMethodBeat.o(121387);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.b
 * JD-Core Version:    0.7.0.1
 */