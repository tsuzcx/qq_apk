package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "()V", "view", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "getView", "()Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "setView", "(Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;)V", "goDetailUI", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "onActivityCreated", "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "plugin-comm_release"})
public abstract class a
  implements b
{
  public c mpN;
  
  public final c bsw()
  {
    c localc = this.mpN;
    if (localc == null) {
      p.bGy("view");
    }
    return localc;
  }
  
  public void onActivityCreated(Activity paramActivity)
  {
    p.k(paramActivity, "activity");
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    p.k(paramActivity, "activity");
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    p.k(paramActivity, "activity");
  }
  
  public void x(Activity paramActivity)
  {
    p.k(paramActivity, "activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.a
 * JD-Core Version:    0.7.0.1
 */