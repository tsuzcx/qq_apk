package com.tencent.mm.plugin.finder.live.component;

import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.bgj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "destroy", "", "initView", "keyboardChange", "show", "", "height", "", "showAlertDialog", "msg", "", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "updateConfirmBtn", "canConfirm", "updateLotteryDurationTips", "valid", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ae$b
  extends c<ae.a>
{
  public abstract void a(int paramInt, String paramString, bgj parambgj);
  
  public abstract void destroy();
  
  public abstract void initView();
  
  public abstract void keyboardChange(boolean paramBoolean, int paramInt);
  
  public abstract void qt(boolean paramBoolean);
  
  public abstract void qu(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ae.b
 * JD-Core Version:    0.7.0.1
 */