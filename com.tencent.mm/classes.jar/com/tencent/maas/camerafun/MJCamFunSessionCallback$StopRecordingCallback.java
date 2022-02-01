package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJCamFunSessionCallback$StopRecordingCallback
  extends MJCamFunSessionCallback.BaseCallback<MJCamFunSessionCallback.MJCamFunSessionCallbackArg.StopRecordingArg>
{
  private final MJCamFunSession.f onStopRecording;
  
  public MJCamFunSessionCallback$StopRecordingCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.f paramf)
  {
    super(paramMJCamFunSession);
    this.onStopRecording = paramf;
  }
  
  public MJCamFunSessionCallback$StopRecordingCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.f paramf, boolean paramBoolean)
  {
    super(paramMJCamFunSession, paramBoolean);
    this.onStopRecording = paramf;
  }
  
  public void onInvoke(MJCamFunSession paramMJCamFunSession, MJCamFunSessionCallback.MJCamFunSessionCallbackArg.StopRecordingArg paramStopRecordingArg)
  {
    AppMethodBeat.i(216829);
    if ((this.onStopRecording != null) && (paramStopRecordingArg != null)) {
      this.onStopRecording.onStopRecording(paramStopRecordingArg.finishInfo, paramStopRecordingArg.error);
    }
    AppMethodBeat.o(216829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.StopRecordingCallback
 * JD-Core Version:    0.7.0.1
 */