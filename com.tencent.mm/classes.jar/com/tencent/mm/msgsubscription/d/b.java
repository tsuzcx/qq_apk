package com.tencent.mm.msgsubscription.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.msgsubscription.e.g;
import com.tencent.mm.msgsubscription.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "", "subscribeStorageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "getLocalSubscribeList", "", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "bizUsername", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "updateLocalSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSubscribeSwitchOpened", "isOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a pjV;
  public final a pjW;
  
  static
  {
    AppMethodBeat.i(149650);
    pjV = new b.a((byte)0);
    AppMethodBeat.o(149650);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(149649);
    this.pjW = parama;
    AppMethodBeat.o(149649);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(236272);
    s.u(paramc, "updateRequest");
    if (this.pjW == null)
    {
      AppMethodBeat.o(236272);
      return;
    }
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateSubscribeList username: " + paramc.username + ", appId: " + paramc.appId + ", size: " + paramc.pis.size());
    Object localObject = d.pkg;
    localObject = this.pjW;
    h localh = new h(paramc, this.pjW);
    localh.piC = paramc.piC;
    localh.piD = paramc.piD;
    paramc = ah.aiuX;
    d.a((a)localObject, (com.tencent.mm.msgsubscription.e.a)localh);
    AppMethodBeat.o(236272);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236266);
    s.u(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
    if (this.pjW == null)
    {
      AppMethodBeat.o(236266);
      return;
    }
    d locald = d.pkg;
    d.a(this.pjW, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.b(paramString, this.pjW, parama));
    AppMethodBeat.o(236266);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236265);
    s.u(paramString, "bizUsername");
    s.u(paramList, "toSaveList");
    if (this.pjW == null)
    {
      AppMethodBeat.o(236265);
      return;
    }
    d locald = d.pkg;
    d.a(this.pjW, (com.tencent.mm.msgsubscription.e.a)new g(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3, this.pjW, (byte)0));
    AppMethodBeat.o(236265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.b
 * JD-Core Version:    0.7.0.1
 */