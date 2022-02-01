package com.tencent.maas.instamovie;

import com.tencent.maas.MJMaasCore;
import com.tencent.maas.MJMaasCore.OnBoolComplete;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMaasCoreCallback$BoolCompleteCallback
  extends MJMaasCoreCallback.BaseCallback<MJMaasCoreCallback.MJMaasCoreCallbackArg.BoolCompleteArg>
{
  private final MJMaasCore.OnBoolComplete onBoolComplete;
  
  public MJMaasCoreCallback$BoolCompleteCallback(MJMaasCore paramMJMaasCore, MJMaasCore.OnBoolComplete paramOnBoolComplete)
  {
    super(paramMJMaasCore);
    this.onBoolComplete = paramOnBoolComplete;
  }
  
  public MJMaasCoreCallback$BoolCompleteCallback(MJMaasCore paramMJMaasCore, MJMaasCore.OnBoolComplete paramOnBoolComplete, boolean paramBoolean)
  {
    super(paramMJMaasCore, paramBoolean);
    this.onBoolComplete = paramOnBoolComplete;
  }
  
  public void onInvoke(MJMaasCore paramMJMaasCore, MJMaasCoreCallback.MJMaasCoreCallbackArg.BoolCompleteArg paramBoolCompleteArg)
  {
    AppMethodBeat.i(216933);
    if ((this.onBoolComplete != null) && (paramBoolCompleteArg != null)) {
      this.onBoolComplete.onComplete(paramBoolCompleteArg.value);
    }
    AppMethodBeat.o(216933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.BoolCompleteCallback
 * JD-Core Version:    0.7.0.1
 */