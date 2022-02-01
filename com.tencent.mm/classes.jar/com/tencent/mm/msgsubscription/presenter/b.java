package com.tencent.mm.msgsubscription.presenter;

import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "", "bizUsername", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onActivityCreated", "activity", "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "LoadDataListener", "plugin-comm_release"})
public abstract interface b
{
  public abstract void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean);
  
  public abstract void a(String paramString, a parama);
  
  public abstract boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
  
  public abstract void fC(boolean paramBoolean);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static abstract interface a
  {
    public abstract void a(SubscribeMsgSettingData paramSubscribeMsgSettingData);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.b
 * JD-Core Version:    0.7.0.1
 */