package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$Companion;", "", "()V", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"})
public final class a$a
{
  public static void a(String paramString1, String paramString2, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(223237);
    p.h(paramString1, "templateId");
    p.h(paramString2, "viewKey");
    p.h(paramb, "callback");
    HashMap localHashMap = (HashMap)a.biU().get(paramString1);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)localHashMap).put(paramString2, paramb);
      ((Map)a.biU()).put(paramString1, localHashMap);
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString1, Integer.valueOf(localHashMap.size()) });
      AppMethodBeat.o(223237);
      return;
    }
  }
  
  public static void bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223238);
    p.h(paramString1, "templateId");
    p.h(paramString2, "viewKey");
    HashMap localHashMap = (HashMap)a.biU().get(paramString1);
    if (localHashMap != null) {
      localHashMap.remove(paramString2);
    }
    if (localHashMap != null) {}
    for (paramString2 = Integer.valueOf(localHashMap.size());; paramString2 = null)
    {
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(223238);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */