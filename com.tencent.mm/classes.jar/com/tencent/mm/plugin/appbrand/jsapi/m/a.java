package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.p.c;
import java.util.HashMap;

public final class a
  extends at
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a kXc;
  
  static
  {
    AppMethodBeat.i(144183);
    kXc = new a();
    AppMethodBeat.o(144183);
  }
  
  public static void a(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(144178);
    a(paramc, paramc1, "found");
    AppMethodBeat.o(144178);
  }
  
  private static void a(c paramc, p.c paramc1, String paramString)
  {
    try
    {
      AppMethodBeat.i(144182);
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc1.hDZ);
        localHashMap.put("serviceName", paramc1.lWT);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc1.ip);
          localHashMap.put("port", Integer.valueOf(paramc1.port));
          localHashMap.put("attributes", paramc1.lWS);
        }
      }
      kXc.B(localHashMap).h(paramc).bir();
      AppMethodBeat.o(144182);
      return;
    }
    finally {}
  }
  
  public static void b(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(144179);
    a(paramc, paramc1, "lost");
    AppMethodBeat.o(144179);
  }
  
  public static void c(c paramc, p.c paramc1)
  {
    AppMethodBeat.i(144180);
    a(paramc, paramc1, "resolveFail");
    AppMethodBeat.o(144180);
  }
  
  public static void t(c paramc)
  {
    AppMethodBeat.i(144181);
    a(paramc, null, "stopScan");
    AppMethodBeat.o(144181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */