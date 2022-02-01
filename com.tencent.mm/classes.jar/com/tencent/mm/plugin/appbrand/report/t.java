package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/PVReportIDFactory;", "Lcom/tencent/luggage/sdk/config/MPInstanceIdFactory;", "Lcom/tencent/luggage/sdk/config/MPSessionIdFactory;", "()V", "createInstanceId", "", "createSessionId", "getUINString", "init", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements com.tencent.luggage.sdk.config.d, e
{
  public static final t tOE;
  
  static
  {
    AppMethodBeat.i(321517);
    tOE = new t();
    AppMethodBeat.o(321517);
  }
  
  public static final void init()
  {
    com.tencent.luggage.sdk.config.e.a.eqq = (e)tOE;
    com.tencent.luggage.sdk.config.d.a.eqo = (com.tencent.luggage.sdk.config.d)tOE;
  }
  
  public final String aqP()
  {
    AppMethodBeat.i(321524);
    String str;
    if (MMApplicationContext.isMainProcess())
    {
      h.baC();
      str = b.aZs();
      s.s(str, "{\n            MMKernel.a…unt().uinString\n        }");
    }
    for (;;)
    {
      str = i.b(new String[] { s.X("hash=", str), s.X("ts=", Long.valueOf(Util.nowMilliSecond())), "host=", s.X("version=", Integer.valueOf(com.tencent.mm.protocal.d.Yxh)), "device=2" }, "&");
      s.s(str, "join(arrayOf(\n          …2-android\n        ), \"&\")");
      AppMethodBeat.o(321524);
      return str;
      str = p.getString(b.aZt());
      s.s(str, "{\n            UIN.getStr…OtherProcess())\n        }");
    }
  }
  
  public final String aqQ()
  {
    AppMethodBeat.i(321526);
    String str = aqP();
    AppMethodBeat.o(321526);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.t
 * JD-Core Version:    0.7.0.1
 */