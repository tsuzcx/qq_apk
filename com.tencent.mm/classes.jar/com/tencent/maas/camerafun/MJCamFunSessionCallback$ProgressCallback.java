package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJCamFunSessionCallback$ProgressCallback
  extends MJCamFunSessionCallback.BaseCallback<MJCamFunSessionCallback.MJCamFunSessionCallbackArg.ProgressArg>
{
  private final MJCamFunSession.d onProgress;
  
  public MJCamFunSessionCallback$ProgressCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.d paramd)
  {
    super(paramMJCamFunSession);
    this.onProgress = paramd;
  }
  
  public MJCamFunSessionCallback$ProgressCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.d paramd, boolean paramBoolean)
  {
    super(paramMJCamFunSession, paramBoolean);
    this.onProgress = paramd;
  }
  
  public void onInvoke(MJCamFunSession paramMJCamFunSession, MJCamFunSessionCallback.MJCamFunSessionCallbackArg.ProgressArg paramProgressArg)
  {
    AppMethodBeat.i(216814);
    if ((this.onProgress != null) && (paramProgressArg != null)) {
      this.onProgress.onProgress(paramProgressArg.progress);
    }
    AppMethodBeat.o(216814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.ProgressCallback
 * JD-Core Version:    0.7.0.1
 */