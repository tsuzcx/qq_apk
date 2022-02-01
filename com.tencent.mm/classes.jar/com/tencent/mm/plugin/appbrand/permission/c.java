package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static volatile Set<String> mhL;
  
  static
  {
    AppMethodBeat.i(147598);
    HashSet localHashSet = new HashSet();
    mhL = localHashSet;
    localHashSet.add("operateLivePlayer");
    mhL.add("operateLivePusher");
    mhL.add("operateXWebLivePlayer");
    mhL.add("operateXWebLivePusher");
    Collections.addAll(mhL, new String[] { "joinVoIPChat", "exitVoIPChat", "onVoIPChatMembersChanged", "onVoIPChatSpeakersChanged", "onVoIPChatInterrupted", "updateVoIPChatMuteConfig", "insertVoIPView", "updateVoIPView", "removeVoIPView" });
    AppMethodBeat.o(147598);
  }
  
  public static void TP(String paramString)
  {
    AppMethodBeat.i(169512);
    mhL.add(paramString);
    AppMethodBeat.o(169512);
  }
  
  static int c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147597);
    if ((paramc instanceof aa)) {}
    for (boolean bool = true; !bool; bool = mhL.contains(paramString1))
    {
      AppMethodBeat.o(147597);
      return -2147483648;
    }
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(147597);
      return -2147483648;
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      bool = paramString2.has("permissionBytes");
      if (!bool)
      {
        AppMethodBeat.o(147597);
        return -2147483648;
      }
      paramString2 = paramString2.getJSONArray("permissionBytes");
      if (paramString2.length() < 3)
      {
        ad.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", new Object[] { Integer.valueOf(paramString2.length()) });
        AppMethodBeat.o(147597);
        return -2147483648;
      }
    }
    catch (Exception paramc)
    {
      ad.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", new Object[] { paramc.getMessage() });
      AppMethodBeat.o(147597);
      return -2147483648;
    }
    int i;
    if ((paramc instanceof q)) {
      switch (1.jLm[((q)paramc).getRuntime().jwS.jKT.bbg().ordinal()])
      {
      default: 
        i = paramString2.optInt(0, -2147483648);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(147597);
      return i;
      i = paramString2.optInt(2, -2147483648);
      continue;
      i = paramString2.optInt(1, -2147483648);
      continue;
      i = paramString2.optInt(0, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c
 * JD-Core Version:    0.7.0.1
 */