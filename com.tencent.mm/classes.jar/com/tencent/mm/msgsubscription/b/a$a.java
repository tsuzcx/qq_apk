package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$Companion;", "", "()V", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static void a(String paramString1, String paramString2, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(236317);
    s.u(paramString1, "templateId");
    s.u(paramString2, "viewKey");
    s.u(paramb, "callback");
    HashMap localHashMap = (HashMap)a.bPY().get(paramString1);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)localHashMap).put(paramString2, paramb);
      ((Map)a.bPY()).put(paramString1, localHashMap);
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString1, Integer.valueOf(localHashMap.size()) });
      AppMethodBeat.o(236317);
      return;
    }
  }
  
  public static void bW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236324);
    s.u(paramString1, "templateId");
    s.u(paramString2, "viewKey");
    HashMap localHashMap = (HashMap)a.bPY().get(paramString1);
    if (localHashMap != null) {
      localHashMap.remove(paramString2);
    }
    if (localHashMap == null) {}
    for (paramString2 = null;; paramString2 = Integer.valueOf(localHashMap.size()))
    {
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(236324);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */