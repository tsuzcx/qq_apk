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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "", "subscribeStorageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "getLocalSubscribeList", "", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "bizUsername", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "updateLocalSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSubscribeSwitchOpened", "isOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "plugin-comm_release"})
public final class b
{
  public static final b.a jAC;
  public final a jAB;
  
  static
  {
    AppMethodBeat.i(149650);
    jAC = new b.a((byte)0);
    AppMethodBeat.o(149650);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(149649);
    this.jAB = parama;
    AppMethodBeat.o(149649);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(223341);
    p.h(paramc, "updateRequest");
    if (this.jAB == null)
    {
      AppMethodBeat.o(223341);
      return;
    }
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateSubscribeList username: " + paramc.username + ", appId: " + paramc.appId + ", size: " + paramc.jyV.size());
    Object localObject = d.jAR;
    localObject = this.jAB;
    h localh = new h(paramc, this.jAB);
    localh.jzf = paramc.jzf;
    localh.jzg = paramc.jzg;
    d.a((a)localObject, (com.tencent.mm.msgsubscription.e.a)localh);
    AppMethodBeat.o(223341);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223340);
    p.h(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
    if (this.jAB == null)
    {
      AppMethodBeat.o(223340);
      return;
    }
    d locald = d.jAR;
    d.a(this.jAB, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.b(paramString, this.jAB, parama));
    AppMethodBeat.o(223340);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(223339);
    p.h(paramString, "bizUsername");
    p.h(paramList, "toSaveList");
    if (this.jAB == null)
    {
      AppMethodBeat.o(223339);
      return;
    }
    d locald = d.jAR;
    d.a(this.jAB, (com.tencent.mm.msgsubscription.e.a)new g(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3, this.jAB, (byte)0));
    AppMethodBeat.o(223339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.b
 * JD-Core Version:    0.7.0.1
 */