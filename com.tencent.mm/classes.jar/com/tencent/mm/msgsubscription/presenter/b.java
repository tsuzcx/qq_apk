package com.tencent.mm.msgsubscription.presenter;

import com.tencent.mm.msgsubscription.ui.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "", "createAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "goDetailUI", "", "position", "", "loadData", "bizUsername", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onActivityCreated", "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "LoadDataListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(String paramString, a parama);
  
  public abstract a<?> b(MMActivity paramMMActivity);
  
  public abstract void he(boolean paramBoolean);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(SubscribeMsgSettingData paramSubscribeMsgSettingData);
    
    public abstract void atR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.b
 * JD-Core Version:    0.7.0.1
 */