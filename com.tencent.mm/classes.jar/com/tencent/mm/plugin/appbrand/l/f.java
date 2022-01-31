package com.tencent.mm.plugin.appbrand.l;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public enum f
  implements n
{
  private f() {}
  
  public static Long bU(String paramString1, String paramString2)
  {
    String str = e.aaY().get(bV(paramString1, paramString2), "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (Long.valueOf(str).longValue() < System.currentTimeMillis())
    {
      e.aaY().jJ(bV(paramString1, paramString2));
      y.i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=" + paramString1);
    }
    return Long.valueOf(str);
  }
  
  private static String bV(String paramString1, String paramString2)
  {
    return paramString1 + "#WxaWeAppPushCommandMgr#" + paramString2;
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    int i;
    if ("WeAppPushCommand".equals(paramString))
    {
      paramString = ".sysmsg.WeAppPushCommand.weapp";
      i = 0;
    }
    label164:
    label184:
    label326:
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
            y.i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", new Object[] { Integer.valueOf(i), str, parama, paramString });
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
          break label326;
        }
        return null;
        j = 0;
        break;
        if (!parama.equals("copypath")) {
          break label164;
        }
        j = 0;
        break label164;
        long l = Long.valueOf(paramString).longValue();
        e.aaY().bi(bV(str, "copypath"), String.valueOf(l * 1000L + System.currentTimeMillis()));
        break label184;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.f
 * JD-Core Version:    0.7.0.1
 */