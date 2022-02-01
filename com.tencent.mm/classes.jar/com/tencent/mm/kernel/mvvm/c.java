package com.tencent.mm.kernel.mvvm;

import androidx.lifecycle.q;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.ServiceStateCenter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/MvvmStateCenterPLC;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "plugin", "Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "(Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;)V", "stateCenter", "Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter;", "getStateCenter", "()Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter;", "setStateCenter", "(Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter;)V", "getInitState", "()Lcom/tencent/mm/sdk/statecenter/BaseState;", "onAccountInitBefore", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<State extends BaseState>
  extends e
{
  ServiceStateCenter<State> mFz;
  
  public c(MvvmPlugin paramMvvmPlugin)
  {
    super(paramMvvmPlugin);
  }
  
  public final void bbx()
  {
    this.mFz = new ServiceStateCenter(getInitState(), (q)bby(), null, null, 12, null);
  }
  
  public abstract State getInitState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.c
 * JD-Core Version:    0.7.0.1
 */