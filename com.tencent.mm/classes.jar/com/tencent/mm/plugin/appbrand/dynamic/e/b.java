package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.appbrand.v8.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private static boolean jNo;
  
  static
  {
    AppMethodBeat.i(121388);
    if (!jNo)
    {
      String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWT, "");
      ac.i("MicroMsg.Widget.AppBrandV8JsEngineImpl", "set v8 flag:%s", new Object[] { str });
      V8.setFlags(str);
      jNo = true;
      x.a(new x.a()
      {
        public final void eM(String paramAnonymousString)
        {
          AppMethodBeat.i(121386);
          h.wUl.kvStat(17693, paramAnonymousString);
          AppMethodBeat.o(121386);
        }
      });
    }
    jNo = false;
    AppMethodBeat.o(121388);
  }
  
  public static d cq(Object paramObject)
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