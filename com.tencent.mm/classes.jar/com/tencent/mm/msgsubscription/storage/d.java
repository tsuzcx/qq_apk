package com.tencent.mm.msgsubscription.storage;

import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "", "clearStorage", "", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "bizUsername", "", "getSubscribeSwitchOpened", "", "getSubscribeTmpByTemplateId", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "saveSubscribeMsgList", "scene", "", "subscribeMsgList", "", "subscribeSwitchOpened", "saveSubscribeMsgSubscribeStatus", "toSaveList", "isOpened", "saveSubscribeMsgUiStatus", "switchOpened", "needUpdateSwitchOpen", "needUpdateTimestamp", "plugin-comm_release"})
public abstract interface d
{
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean);
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void awD();
  
  public abstract void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean);
  
  public abstract SubscribeMsgTmpItem bd(String paramString1, String paramString2);
  
  public abstract boolean xx(String paramString);
  
  public abstract IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper xy(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.d
 * JD-Core Version:    0.7.0.1
 */