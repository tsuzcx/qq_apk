package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.p.c;
import java.util.HashMap;

public final class a
  extends bc
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a mga;
  
  static
  {
    AppMethodBeat.i(144183);
    mga = new a();
    AppMethodBeat.o(144183);
  }
  
  public static void a(f paramf, p.c paramc)
  {
    AppMethodBeat.i(144178);
    a(paramf, paramc, "found");
    AppMethodBeat.o(144178);
  }
  
  private static void a(f paramf, p.c paramc, String paramString)
  {
    try
    {
      AppMethodBeat.i(144182);
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc.iBb);
        localHashMap.put("serviceName", paramc.serviceName);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc.ip);
          localHashMap.put("port", Integer.valueOf(paramc.port));
          localHashMap.put("attributes", paramc.njl);
        }
      }
      mga.L(localHashMap).h(paramf).bEo();
      AppMethodBeat.o(144182);
      return;
    }
    finally {}
  }
  
  public static void b(f paramf, p.c paramc)
  {
    AppMethodBeat.i(144179);
    a(paramf, paramc, "lost");
    AppMethodBeat.o(144179);
  }
  
  public static void c(f paramf, p.c paramc)
  {
    AppMethodBeat.i(144180);
    a(paramf, paramc, "resolveFail");
    AppMethodBeat.o(144180);
  }
  
  public static void t(f paramf)
  {
    AppMethodBeat.i(144181);
    a(paramf, null, "stopScan");
    AppMethodBeat.o(144181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a
 * JD-Core Version:    0.7.0.1
 */