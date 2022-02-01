package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "()V", "view", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "getView", "()Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "setView", "(Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;)V", "goDetailUI", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "onActivityCreated", "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements b
{
  public c pjz;
  
  public void A(Activity paramActivity)
  {
    s.u(paramActivity, "activity");
  }
  
  public void a(MMActivity paramMMActivity, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt)
  {
    s.u(paramMMActivity, "activity");
    s.u(paramSubscribeMsgTmpItem, "item");
  }
  
  public final c bQc()
  {
    c localc = this.pjz;
    if (localc != null) {
      return localc;
    }
    s.bIx("view");
    return null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    s.u(paramActivity, "activity");
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    s.u(paramActivity, "activity");
  }
  
  public void z(Activity paramActivity)
  {
    s.u(paramActivity, "activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.a
 * JD-Core Version:    0.7.0.1
 */