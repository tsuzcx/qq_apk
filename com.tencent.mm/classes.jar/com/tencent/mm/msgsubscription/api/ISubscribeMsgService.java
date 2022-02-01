package com.tencent.mm.msgsubscription.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getStorage", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ISubscribeMsgService
  extends com.tencent.mm.kernel.c.a
{
  public static final ISubscribeMsgService.Companion piq = ISubscribeMsgService.Companion.pir;
  
  public abstract boolean QV(String paramString);
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, List<String> paramList, a parama);
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void b(String paramString, a parama);
  
  public abstract SubscribeMsgTmpItem bU(String paramString1, String paramString2);
  
  public abstract void g(String paramString1, String paramString2, long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.ISubscribeMsgService
 * JD-Core Version:    0.7.0.1
 */