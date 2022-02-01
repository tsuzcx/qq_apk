package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.p.c;
import java.util.HashMap;

public final class a
  extends az
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a peh;
  
  static
  {
    AppMethodBeat.i(144183);
    peh = new a();
    AppMethodBeat.o(144183);
  }
  
  public static void a(e parame, p.c paramc)
  {
    AppMethodBeat.i(144178);
    a(parame, paramc, "found");
    AppMethodBeat.o(144178);
  }
  
  private static void a(e parame, p.c paramc, String paramString)
  {
    try
    {
      AppMethodBeat.i(144182);
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc.lqE);
        localHashMap.put("serviceName", paramc.serviceName);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc.ip);
          localHashMap.put("port", Integer.valueOf(paramc.port));
          localHashMap.put("attributes", paramc.qjW);
        }
      }
      peh.E(localHashMap).j(parame).bPO();
      AppMethodBeat.o(144182);
      return;
    }
    finally {}
  }
  
  public static void b(e parame, p.c paramc)
  {
    AppMethodBeat.i(144179);
    a(parame, paramc, "lost");
    AppMethodBeat.o(144179);
  }
  
  public static void c(e parame, p.c paramc)
  {
    AppMethodBeat.i(144180);
    a(parame, paramc, "resolveFail");
    AppMethodBeat.o(144180);
  }
  
  public static void w(e parame)
  {
    AppMethodBeat.i(144181);
    a(parame, null, "stopScan");
    AppMethodBeat.o(144181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a
 * JD-Core Version:    0.7.0.1
 */