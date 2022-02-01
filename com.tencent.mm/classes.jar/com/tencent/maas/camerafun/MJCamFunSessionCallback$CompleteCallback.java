package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJCamFunSessionCallback$CompleteCallback
  extends MJCamFunSessionCallback.BaseCallback<MJCamFunSessionCallback.MJCamFunSessionCallbackArg.CompleteArg>
{
  private final MJCamFunSession.b onComplete;
  
  public MJCamFunSessionCallback$CompleteCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.b paramb)
  {
    super(paramMJCamFunSession);
    this.onComplete = paramb;
  }
  
  public MJCamFunSessionCallback$CompleteCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.b paramb, boolean paramBoolean)
  {
    super(paramMJCamFunSession, paramBoolean);
    this.onComplete = paramb;
  }
  
  public void onInvoke(MJCamFunSession paramMJCamFunSession, MJCamFunSessionCallback.MJCamFunSessionCallbackArg.CompleteArg paramCompleteArg)
  {
    AppMethodBeat.i(216840);
    if ((this.onComplete != null) && (paramCompleteArg != null)) {
      this.onComplete.onComplete(paramCompleteArg.error);
    }
    AppMethodBeat.o(216840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.CompleteCallback
 * JD-Core Version:    0.7.0.1
 */