package com.tencent.mm.plugin.appbrand.message;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public enum h
  implements s
{
  static
  {
    AppMethodBeat.i(47746);
    qhn = new h("INSTANCE");
    qho = new h[] { qhn };
    AppMethodBeat.o(47746);
  }
  
  private h() {}
  
  public static Long eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47744);
    Object localObject = m.QG();
    if (localObject == null)
    {
      Log.e("MicroMsg.WxaWeAppPushCommandMgr", "getExpireTime(appId:%s, type:%s), kvStorage==NULL, account initialized:%b", new Object[] { paramString1, paramString2, Boolean.valueOf(com.tencent.mm.kernel.h.aHE().kbT) });
      AppMethodBeat.o(47744);
      return null;
    }
    localObject = ((e)localObject).L(eK(paramString1, paramString2), "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(47744);
      return null;
    }
    if (Long.valueOf((String)localObject).longValue() < System.currentTimeMillis())
    {
      m.QG().ho(eK(paramString1, paramString2));
      Log.i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=".concat(String.valueOf(paramString1)));
    }
    paramString1 = Long.valueOf((String)localObject);
    AppMethodBeat.o(47744);
    return paramString1;
  }
  
  private static String eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47745);
    paramString1 = paramString1 + "#WxaWeAppPushCommandMgr#" + paramString2;
    AppMethodBeat.o(47745);
    return paramString1;
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
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
            Log.i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", new Object[] { Integer.valueOf(i), str, parama, paramString });
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
        m.QG().cW(eK(str, "copypath"), String.valueOf(l * 1000L + System.currentTimeMillis()));
        break label192;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.h
 * JD-Core Version:    0.7.0.1
 */