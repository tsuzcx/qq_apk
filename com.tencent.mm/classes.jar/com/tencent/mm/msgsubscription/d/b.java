package com.tencent.mm.msgsubscription.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.msgsubscription.e.g;
import com.tencent.mm.msgsubscription.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "", "subscribeStorageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "getLocalSubscribeList", "", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "bizUsername", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "updateLocalSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSubscribeSwitchOpened", "isOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "plugin-comm_release"})
public final class b
{
  public static final b.a mqk;
  public final a mqj;
  
  static
  {
    AppMethodBeat.i(149650);
    mqk = new b.a((byte)0);
    AppMethodBeat.o(149650);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(149649);
    this.mqj = parama;
    AppMethodBeat.o(149649);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(234367);
    p.k(paramc, "updateRequest");
    if (this.mqj == null)
    {
      AppMethodBeat.o(234367);
      return;
    }
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateSubscribeList username: " + paramc.username + ", appId: " + paramc.appId + ", size: " + paramc.moB.size());
    Object localObject = d.mqz;
    localObject = this.mqj;
    h localh = new h(paramc, this.mqj);
    localh.moL = paramc.moL;
    localh.moM = paramc.moM;
    d.a((a)localObject, (com.tencent.mm.msgsubscription.e.a)localh);
    AppMethodBeat.o(234367);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(234366);
    p.k(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
    if (this.mqj == null)
    {
      AppMethodBeat.o(234366);
      return;
    }
    d locald = d.mqz;
    d.a(this.mqj, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.b(paramString, this.mqj, parama));
    AppMethodBeat.o(234366);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(234365);
    p.k(paramString, "bizUsername");
    p.k(paramList, "toSaveList");
    if (this.mqj == null)
    {
      AppMethodBeat.o(234365);
      return;
    }
    d locald = d.mqz;
    d.a(this.mqj, (com.tencent.mm.msgsubscription.e.a)new g(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3, this.mqj, (byte)0));
    AppMethodBeat.o(234365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.b
 * JD-Core Version:    0.7.0.1
 */