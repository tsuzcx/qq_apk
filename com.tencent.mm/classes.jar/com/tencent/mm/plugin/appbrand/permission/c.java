package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static Set<String> iBm;
  
  static
  {
    AppMethodBeat.i(102245);
    HashSet localHashSet = new HashSet();
    iBm = localHashSet;
    localHashSet.add("operateLivePlayer");
    iBm.add("operateLivePusher");
    AppMethodBeat.o(102245);
  }
  
  static int c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102244);
    if ((paramc instanceof v)) {}
    for (boolean bool = true; !bool; bool = iBm.contains(paramString1))
    {
      AppMethodBeat.o(102244);
      return -2147483648;
    }
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(102244);
      return -2147483648;
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      bool = paramString2.has("permissionBytes");
      if (!bool)
      {
        AppMethodBeat.o(102244);
        return -2147483648;
      }
      paramString2 = paramString2.getJSONArray("permissionBytes");
      if (paramString2.length() < 3)
      {
        ab.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", new Object[] { Integer.valueOf(paramString2.length()) });
        AppMethodBeat.o(102244);
        return -2147483648;
      }
    }
    catch (Exception paramc)
    {
      ab.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", new Object[] { paramc.getMessage() });
      AppMethodBeat.o(102244);
      return -2147483648;
    }
    int i;
    if ((paramc instanceof r)) {
      switch (c.1.gYx[((r)paramc).getRuntime().gPL.gYj.awr().ordinal()])
      {
      default: 
        i = paramString2.optInt(0, -2147483648);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(102244);
      return i;
      i = paramString2.optInt(2, -2147483648);
      continue;
      i = paramString2.optInt(1, -2147483648);
      continue;
      i = paramString2.optInt(0, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c
 * JD-Core Version:    0.7.0.1
 */