package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJCamFunSessionCallback$OptionsCompleteCallback
  extends MJCamFunSessionCallback.BaseCallback<MJCamFunSessionCallback.MJCamFunSessionCallbackArg.OptionsCompleteArg>
{
  private final MJCamFunSession.c onComplete;
  
  public MJCamFunSessionCallback$OptionsCompleteCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.c paramc)
  {
    super(paramMJCamFunSession);
    this.onComplete = paramc;
  }
  
  public MJCamFunSessionCallback$OptionsCompleteCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.c paramc, boolean paramBoolean)
  {
    super(paramMJCamFunSession, paramBoolean);
    this.onComplete = paramc;
  }
  
  public void onInvoke(MJCamFunSession paramMJCamFunSession, MJCamFunSessionCallback.MJCamFunSessionCallbackArg.OptionsCompleteArg paramOptionsCompleteArg)
  {
    AppMethodBeat.i(216824);
    if ((this.onComplete != null) && (paramOptionsCompleteArg != null)) {
      this.onComplete.onComplete(paramOptionsCompleteArg.options, paramOptionsCompleteArg.error);
    }
    AppMethodBeat.o(216824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.OptionsCompleteCallback
 * JD-Core Version:    0.7.0.1
 */