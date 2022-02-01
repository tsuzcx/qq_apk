package com.tencent.maas.instamovie;

import com.tencent.maas.MJMaasCore;
import com.tencent.maas.MJMaasCore.OnComplete;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMaasCoreCallback$CompleteCallback
  extends MJMaasCoreCallback.BaseCallback<MJMaasCoreCallback.MJMaasCoreCallbackArg.CompleteArg>
{
  private final MJMaasCore.OnComplete onComplete;
  
  public MJMaasCoreCallback$CompleteCallback(MJMaasCore paramMJMaasCore, MJMaasCore.OnComplete paramOnComplete)
  {
    super(paramMJMaasCore);
    this.onComplete = paramOnComplete;
  }
  
  public MJMaasCoreCallback$CompleteCallback(MJMaasCore paramMJMaasCore, MJMaasCore.OnComplete paramOnComplete, boolean paramBoolean)
  {
    super(paramMJMaasCore, paramBoolean);
    this.onComplete = paramOnComplete;
  }
  
  public void onInvoke(MJMaasCore paramMJMaasCore, MJMaasCoreCallback.MJMaasCoreCallbackArg.CompleteArg paramCompleteArg)
  {
    AppMethodBeat.i(216924);
    if ((this.onComplete != null) && (paramCompleteArg != null)) {
      this.onComplete.onComplete(paramCompleteArg.error);
    }
    AppMethodBeat.o(216924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.CompleteCallback
 * JD-Core Version:    0.7.0.1
 */