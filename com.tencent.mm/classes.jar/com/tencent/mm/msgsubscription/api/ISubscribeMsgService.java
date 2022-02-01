package com.tencent.mm.msgsubscription.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getStorage", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"})
public abstract interface ISubscribeMsgService
  extends com.tencent.mm.kernel.c.a
{
  public static final ISubscribeMsgService.Companion jyT = ISubscribeMsgService.Companion.jyU;
  
  public abstract boolean Rt(String paramString);
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, List<String> paramList, a parama);
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void b(String paramString, a parama);
  
  public abstract SubscribeMsgTmpItem bF(String paramString1, String paramString2);
  
  public abstract void g(String paramString1, String paramString2, long paramLong);
  
  @l(hxD={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.ISubscribeMsgService
 * JD-Core Version:    0.7.0.1
 */