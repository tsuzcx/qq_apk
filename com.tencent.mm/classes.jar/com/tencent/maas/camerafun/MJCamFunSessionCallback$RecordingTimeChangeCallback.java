package com.tencent.maas.camerafun;

public class MJCamFunSessionCallback$RecordingTimeChangeCallback
  extends MJCamFunSessionCallback.BaseCallback<MJCamFunSessionCallback.MJCamFunSessionCallbackArg.RecordingTimeChangeArg>
{
  private final MJCamFunSession.e onRecordingTimeChange;
  
  public MJCamFunSessionCallback$RecordingTimeChangeCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.e parame)
  {
    super(paramMJCamFunSession);
    this.onRecordingTimeChange = parame;
  }
  
  public MJCamFunSessionCallback$RecordingTimeChangeCallback(MJCamFunSession paramMJCamFunSession, MJCamFunSession.e parame, boolean paramBoolean)
  {
    super(paramMJCamFunSession, paramBoolean);
    this.onRecordingTimeChange = parame;
  }
  
  public void onInvoke(MJCamFunSession paramMJCamFunSession, MJCamFunSessionCallback.MJCamFunSessionCallbackArg.RecordingTimeChangeArg paramRecordingTimeChangeArg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.RecordingTimeChangeCallback
 * JD-Core Version:    0.7.0.1
 */