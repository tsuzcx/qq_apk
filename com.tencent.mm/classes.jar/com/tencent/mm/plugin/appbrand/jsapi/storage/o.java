package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends aa<j>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorageSync";
  
  private static String a(j paramj, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147287);
    long l = System.currentTimeMillis();
    try
    {
      JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
      localJsApiSetStorageTask.appId = paramj.getAppId();
      localJsApiSetStorageTask.prw = paramInt;
      localJsApiSetStorageTask.F(paramString1, paramString2, paramString3);
      if (localJsApiSetStorageTask.bPu())
      {
        paramString3 = localJsApiSetStorageTask.result;
        return paramString3;
      }
      Log.e("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", new Object[] { paramj.getAppId(), paramString1 });
      return "fail";
    }
    finally
    {
      u.a(1, 1, v.cP(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramj);
      AppMethodBeat.o(147287);
    }
  }
  
  private static String b(j paramj, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147288);
    long l = System.currentTimeMillis();
    try
    {
      paramString3 = p.a(((a)e.K(a.class)).dX(paramj.getAppId()).d(paramInt, paramj.getAppId(), paramString1, paramString2, paramString3));
      return paramString3;
    }
    finally
    {
      u.a(2, 1, v.cP(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramj);
      AppMethodBeat.o(147288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.o
 * JD-Core Version:    0.7.0.1
 */