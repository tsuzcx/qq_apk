package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static volatile Set<String> tEh;
  
  static
  {
    AppMethodBeat.i(147598);
    HashSet localHashSet = new HashSet();
    tEh = localHashSet;
    localHashSet.add("operateLivePlayer");
    tEh.add("operateLivePusher");
    tEh.add("operateXWebLivePlayer");
    tEh.add("operateXWebLivePusher");
    Collections.addAll(tEh, new String[] { "joinVoIPChat", "exitVoIPChat", "onVoIPChatMembersChanged", "onVoIPChatSpeakersChanged", "onVoIPChatInterrupted", "updateVoIPChatMuteConfig", "insertVoIPView", "updateVoIPView", "removeVoIPView" });
    AppMethodBeat.o(147598);
  }
  
  public static void afo(String paramString)
  {
    AppMethodBeat.i(169512);
    tEh.add(paramString);
    AppMethodBeat.o(169512);
  }
  
  static int e(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147597);
    if ((paramf instanceof ad)) {}
    for (boolean bool = true; !bool; bool = tEh.contains(paramString1))
    {
      AppMethodBeat.o(147597);
      return -2147483648;
    }
    if (Util.isNullOrNil(paramString2))
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
        Log.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", new Object[] { Integer.valueOf(paramString2.length()) });
        AppMethodBeat.o(147597);
        return -2147483648;
      }
    }
    catch (Exception paramf)
    {
      Log.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", new Object[] { paramf.getMessage() });
      AppMethodBeat.o(147597);
      return -2147483648;
    }
    int i;
    if ((paramf instanceof y)) {
      switch (1.qKW[((y)paramf).getRuntime().qsB.qKC.chD().ordinal()])
      {
      default: 
        i = paramString2.optInt(0, -2147483648);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", new Object[] { paramString1, Integer.valueOf(i) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c
 * JD-Core Version:    0.7.0.1
 */