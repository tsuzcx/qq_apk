package com.tencent.maas.camerafun;

import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import com.tencent.maas.model.time.MJTime;

public class MJCamFunSessionCallback$MJCamFunSessionCallbackArg
  extends NativeCallbackManager.CallbackArgs
{
  public static class CompleteArg
    extends MJCamFunSessionCallback.MJCamFunSessionCallbackArg
  {
    public final MJError error;
    
    public CompleteArg(MJError paramMJError)
    {
      this.error = paramMJError;
    }
  }
  
  public static class OptionsCompleteArg
    extends MJCamFunSessionCallback.MJCamFunSessionCallbackArg
  {
    public final MJError error;
    public final MJCaptureOptions options;
    
    public OptionsCompleteArg(MJCaptureOptions paramMJCaptureOptions, MJError paramMJError)
    {
      this.options = paramMJCaptureOptions;
      this.error = paramMJError;
    }
  }
  
  public static class ProgressArg
    extends MJCamFunSessionCallback.MJCamFunSessionCallbackArg
  {
    public final float progress;
    
    public ProgressArg(float paramFloat)
    {
      this.progress = paramFloat;
    }
  }
  
  public static class RecordingTimeChangeArg
    extends MJCamFunSessionCallback.MJCamFunSessionCallbackArg
  {
    public final MJTime lastFrameTime;
    public final MJTime maxRecordingDuration;
    
    public RecordingTimeChangeArg(MJTime paramMJTime1, MJTime paramMJTime2)
    {
      this.lastFrameTime = paramMJTime1;
      this.maxRecordingDuration = paramMJTime2;
    }
  }
  
  public static class StopRecordingArg
    extends MJCamFunSessionCallback.MJCamFunSessionCallbackArg
  {
    public final MJError error;
    public final MJRecordingFinishInfo finishInfo;
    
    public StopRecordingArg(MJRecordingFinishInfo paramMJRecordingFinishInfo, MJError paramMJError)
    {
      this.finishInfo = paramMJRecordingFinishInfo;
      this.error = paramMJError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.MJCamFunSessionCallbackArg
 * JD-Core Version:    0.7.0.1
 */