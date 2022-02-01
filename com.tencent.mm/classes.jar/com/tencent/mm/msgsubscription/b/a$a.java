package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$Companion;", "", "()V", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"})
public final class a$a
{
  public static void a(String paramString1, String paramString2, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(242486);
    p.k(paramString1, "templateId");
    p.k(paramString2, "viewKey");
    p.k(paramb, "callback");
    HashMap localHashMap = (HashMap)a.bss().get(paramString1);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)localHashMap).put(paramString2, paramb);
      ((Map)a.bss()).put(paramString1, localHashMap);
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString1, Integer.valueOf(localHashMap.size()) });
      AppMethodBeat.o(242486);
      return;
    }
  }
  
  public static void bK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242491);
    p.k(paramString1, "templateId");
    p.k(paramString2, "viewKey");
    HashMap localHashMap = (HashMap)a.bss().get(paramString1);
    if (localHashMap != null) {
      localHashMap.remove(paramString2);
    }
    if (localHashMap != null) {}
    for (paramString2 = Integer.valueOf(localHashMap.size());; paramString2 = null)
    {
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(242491);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */