package com.tencent.mm.plugin.finder.live.component;

import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.avp;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "initView", "", "keyboardChange", "show", "", "height", "", "showAlertDialog", "msg", "", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "updateConfirmBtn", "canConfirm", "updateLotteryDesc", "desc", "updateLotteryDurationTips", "valid", "warning", "updateLotteryType", "type", "updateWinnerNumber", "cnt", "plugin-finder_release"})
public abstract interface d$b
  extends c<d.a>
{
  public abstract void N(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(int paramInt, String paramString, avp paramavp);
  
  public abstract void atw(String paramString);
  
  public abstract void initView();
  
  public abstract void keyboardChange(boolean paramBoolean, int paramInt);
  
  public abstract void nk(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.d.b
 * JD-Core Version:    0.7.0.1
 */