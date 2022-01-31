package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.o.c;
import java.util.HashMap;

public final class a
  extends ac
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a gxm = new a();
  
  public static void a(c paramc, o.c paramc1)
  {
    a(paramc, paramc1, "found");
  }
  
  private static void a(c paramc, o.c paramc1, String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc1.gRO);
        localHashMap.put("serviceName", paramc1.gRN);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc1.ip);
          localHashMap.put("port", Integer.valueOf(paramc1.port));
        }
      }
      gxm.p(localHashMap).e(paramc).dispatch();
      return;
    }
    finally {}
  }
  
  public static void b(c paramc, o.c paramc1)
  {
    a(paramc, paramc1, "lost");
  }
  
  public static void c(c paramc, o.c paramc1)
  {
    a(paramc, paramc1, "resolveFail");
  }
  
  public static void m(c paramc)
  {
    a(paramc, null, "stopScan");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */