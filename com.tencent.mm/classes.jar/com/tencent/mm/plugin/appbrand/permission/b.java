package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  private static Set<String> gWC;
  
  static
  {
    HashSet localHashSet = new HashSet();
    gWC = localHashSet;
    localHashSet.add("operateLivePlayer");
    gWC.add("operateLivePusher");
  }
  
  static int g(c paramc, String paramString1, String paramString2)
  {
    boolean bool;
    if ((paramc instanceof q))
    {
      bool = true;
      if (bool) {
        break label32;
      }
    }
    for (;;)
    {
      return -2147483648;
      bool = gWC.contains(paramString1);
      break;
      label32:
      if (!bk.bl(paramString2)) {
        try
        {
          paramString2 = new JSONObject(paramString2);
          if (paramString2.has("permissionBytes"))
          {
            paramString2 = paramString2.getJSONArray("permissionBytes");
            if (paramString2.length() < 3)
            {
              y.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", new Object[] { Integer.valueOf(paramString2.length()) });
              return -2147483648;
            }
          }
        }
        catch (Exception paramc)
        {
          y.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", new Object[] { paramc.getMessage() });
          return -2147483648;
        }
      }
    }
    int i;
    if ((paramc instanceof o)) {
      switch (b.1.fGc[((o)paramc).getRuntime().fyy.fFN.acz().ordinal()])
      {
      default: 
        i = paramString2.optInt(0, -2147483648);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", new Object[] { paramString1, Integer.valueOf(i) });
      return i;
      i = paramString2.optInt(2, -2147483648);
      continue;
      i = paramString2.optInt(1, -2147483648);
      continue;
      i = paramString2.optInt(0, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */