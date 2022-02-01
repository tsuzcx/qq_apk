package com.tencent.mm.plugin.appbrand.message;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public enum h
  implements p
{
  static
  {
    AppMethodBeat.i(47746);
    lYX = new h("INSTANCE");
    lYY = new h[] { lYX };
    AppMethodBeat.o(47746);
  }
  
  private h() {}
  
  public static Long ee(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47744);
    String str = j.Em().get(ef(paramString1, paramString2), "");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(47744);
      return null;
    }
    if (Long.valueOf(str).longValue() < System.currentTimeMillis())
    {
      j.Em().Dc(ef(paramString1, paramString2));
      ae.i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=".concat(String.valueOf(paramString1)));
    }
    paramString1 = Long.valueOf(str);
    AppMethodBeat.o(47744);
    return paramString1;
  }
  
  private static String ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47745);
    paramString1 = paramString1 + "#WxaWeAppPushCommandMgr#" + paramString2;
    AppMethodBeat.o(47745);
    return paramString1;
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(47743);
    int i;
    if ("WeAppPushCommand".equals(paramString))
    {
      paramString = ".sysmsg.WeAppPushCommand.weapp";
      i = 0;
    }
    label172:
    label192:
    label339:
    for (;;)
    {
      parama = (String)paramMap.get(paramString + ".$cmdtype");
      String str = (String)paramMap.get(paramString + ".$appid");
      paramString = (String)paramMap.get(paramString + ".expireSeconds");
      int j;
      if ((!TextUtils.isEmpty(parama)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString)))
      {
        j = 1;
        if (j != 0) {
          j = -1;
        }
        switch (parama.hashCode())
        {
        default: 
          switch (j)
          {
          default: 
            ae.i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", new Object[] { Integer.valueOf(i), str, parama, paramString });
            i += 1;
            if (i != 0) {}
            break;
          }
          break;
        }
      }
      for (paramString = ".sysmsg.WeAppPushCommand.weapp";; paramString = ".sysmsg.WeAppPushCommand.weapp" + i)
      {
        if (paramMap.containsKey(paramString)) {
          break label339;
        }
        AppMethodBeat.o(47743);
        return null;
        j = 0;
        break;
        if (!parama.equals("copypath")) {
          break label172;
        }
        j = 0;
        break label172;
        long l = Long.valueOf(paramString).longValue();
        j.Em().cz(ef(str, "copypath"), String.valueOf(l * 1000L + System.currentTimeMillis()));
        break label192;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.h
 * JD-Core Version:    0.7.0.1
 */