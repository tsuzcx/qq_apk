package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.msgsubscription.c.c;
import com.tencent.mm.msgsubscription.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "", "subscribeStorageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "getSubscribeMsgByUrl", "", "username", "", "subscribeUrl", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "getSubscribeMsgListByUsername", "getSubscribeSwitchOpened", "", "bizUsername", "getSubscribeTmpByTemplateId", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getSubscribeUIStatus", "templateIdList", "", "loadSubscribeMsgListByUsername", "saveSubscribeUIStatus", "toSaveList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSwitchOpened", "isOpened", "updateSubscribeMsgForDialogRequestSync", "subscribeMsgList", "buffer", "", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "updateSubscribeMsgList", "async", "replaced", "updateSubscribeMsgListAsync", "updateSubscribeMsgListSync", "Companion", "SubscribeMsgOpCallback", "plugin-comm_release"})
public final class e
{
  public static final e.a hHT;
  public final d hHS;
  
  static
  {
    AppMethodBeat.i(149650);
    hHT = new e.a((byte)0);
    AppMethodBeat.o(149650);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(149649);
    this.hHS = paramd;
    AppMethodBeat.o(149649);
  }
  
  public final void a(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(149645);
    k.h(paramString1, "username");
    k.h(paramString2, "subscribeUrl");
    ad.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgByUrl username: %s, url: %s", new Object[] { paramString1, paramString2 });
    g localg = g.hHX;
    g.a(this.hHS, (a)new c(paramString1, paramString2, this.hHS, paramb));
    AppMethodBeat.o(149645);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData, b paramb)
  {
    AppMethodBeat.i(149648);
    k.h(paramString, "username");
    k.h(paramList, "subscribeMsgList");
    k.h(paramArrayOfByte, "buffer");
    ad.i("Mp.SubscribeMsgDataLoader", "alvinluo updateSubscribeMsgListForDialog %s, isOpened: %b, size: %d", new Object[] { paramString, Boolean.TRUE, Integer.valueOf(paramList.size()) });
    Object localObject = g.hHX;
    localObject = this.hHS;
    paramString = new h(paramString, paramList, true, true, this.hHS, paramb, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData);
    paramString.hIb = false;
    g.a((d)localObject, (a)paramString);
    AppMethodBeat.o(149648);
  }
  
  public final void a(String paramString, boolean paramBoolean1, List<SubscribeMsgTmpItem> paramList, b paramb, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(149646);
    ad.i("Mp.SubscribeMsgDataLoader", "alvinluo updateSubscribeMsgList %s, isOpened: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramList.size()) });
    Object localObject = g.hHX;
    localObject = this.hHS;
    paramString = new h(paramString, paramList, paramBoolean1, this.hHS, paramb);
    paramString.hIb = paramBoolean2;
    paramString.hIc = paramBoolean3;
    g.a((d)localObject, (a)paramString);
    AppMethodBeat.o(149646);
  }
  
  public final void a(String paramString, boolean paramBoolean1, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean2, b paramb)
  {
    AppMethodBeat.i(149647);
    k.h(paramString, "username");
    k.h(paramList, "subscribeMsgList");
    a(paramString, paramBoolean1, paramList, paramb, true, paramBoolean2);
    AppMethodBeat.o(149647);
  }
  
  public final void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(149644);
    k.h(paramString, "bizUsername");
    k.h(paramList, "toSaveList");
    g localg = g.hHX;
    g.a(this.hHS, (a)new com.tencent.mm.msgsubscription.c.g(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3, this.hHS, (byte)0));
    AppMethodBeat.o(149644);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void i(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.e
 * JD-Core Version:    0.7.0.1
 */