package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.p.c;
import java.util.HashMap;

public final class a
  extends ai
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a hTI;
  
  static
  {
    AppMethodBeat.i(108018);
    hTI = new a();
    AppMethodBeat.o(108018);
  }
  
  public static void a(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(108013);
    a(paramc, paramc1, "found");
    AppMethodBeat.o(108013);
  }
  
  private static void a(c paramc, p.c paramc1, String paramString)
  {
    try
    {
      AppMethodBeat.i(108017);
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc1.itH);
        localHashMap.put("serviceName", paramc1.itG);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc1.ip);
          localHashMap.put("port", Integer.valueOf(paramc1.port));
          localHashMap.put("attributes", paramc1.itF);
        }
      }
      hTI.x(localHashMap).j(paramc).aBz();
      AppMethodBeat.o(108017);
      return;
    }
    finally {}
  }
  
  public static void b(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(108014);
    a(paramc, paramc1, "lost");
    AppMethodBeat.o(108014);
  }
  
  public static void c(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(108015);
    a(paramc, paramc1, "resolveFail");
    AppMethodBeat.o(108015);
  }
  
  public static void t(c paramc)
  {
    AppMethodBeat.i(108016);
    a(paramc, null, "stopScan");
    AppMethodBeat.o(108016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */