package com.tencent.mm.msgsubscription.d;

import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "", "clearStorage", "", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "bizUsername", "", "getSubscribeSwitchOpened", "", "getSubscribeTmpByTemplateId", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "saveSubscribeMsgList", "scene", "", "subscribeMsgList", "", "subscribeSwitchOpened", "updateSubscribeStatus", "toSaveList", "switchOpened", "needUpdateSwitchOpen", "needUpdateTimestamp", "updateSubscribeStatusTimestamp", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract boolean Rd(String paramString);
  
  public abstract ISubscribeMsgService.Companion.SubscribeMsgListWrapper Re(String paramString);
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean);
  
  public abstract void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void bQd();
  
  public abstract SubscribeMsgTmpItem bX(String paramString1, String paramString2);
  
  public abstract void f(String paramString, List<SubscribeMsgTmpItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.a
 * JD-Core Version:    0.7.0.1
 */