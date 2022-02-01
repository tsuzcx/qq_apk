package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.aa;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends ab<k>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorageSync";
  
  private static String a(k paramk, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147287);
    long l = System.currentTimeMillis();
    try
    {
      JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
      localJsApiSetStorageTask.appId = paramk.getAppId();
      localJsApiSetStorageTask.svX = paramInt;
      localJsApiSetStorageTask.J(paramString1, paramString2, paramString3);
      if (localJsApiSetStorageTask.cpB())
      {
        paramString3 = localJsApiSetStorageTask.result;
        return paramString3;
      }
      Log.e("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", new Object[] { paramk.getAppId(), paramString1 });
      return "fail";
    }
    finally
    {
      z.a(1, 1, aa.dg(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramk);
      AppMethodBeat.o(147287);
    }
  }
  
  private static String b(k paramk, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147288);
    long l = System.currentTimeMillis();
    try
    {
      int i = paramk.getRuntime().asG().qYZ;
      String str = paramk.getRuntime().asG().qLQ;
      paramString3 = q.a(((a)e.T(a.class)).f(paramk.getAppId(), i, str).d(paramInt, paramk.getAppId(), paramString1, paramString2, paramString3));
      return paramString3;
    }
    finally
    {
      z.a(2, 1, aa.dg(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramk);
      AppMethodBeat.o(147288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.p
 * JD-Core Version:    0.7.0.1
 */