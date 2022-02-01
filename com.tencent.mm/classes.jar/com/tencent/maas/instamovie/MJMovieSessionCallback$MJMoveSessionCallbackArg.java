package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import com.tencent.maas.model.time.MJTime;
import com.tencent.maas.model.time.MJTimeRange;

public class MJMovieSessionCallback$MJMoveSessionCallbackArg
  extends NativeCallbackManager.CallbackArgs
{
  public static class CompleteArg
    extends MJMovieSessionCallback.MJMoveSessionCallbackArg
  {
    public final MJError error;
    
    public CompleteArg(MJError paramMJError)
    {
      this.error = paramMJError;
    }
  }
  
  public static class ExportClipBundleArg
    extends MJMovieSessionCallback.MJMoveSessionCallbackArg
  {
    public final MJError error;
    public final String path;
    
    public ExportClipBundleArg(String paramString, MJError paramMJError)
    {
      this.path = paramString;
      this.error = paramMJError;
    }
  }
  
  public static class MediaTimeChangeArg
    extends MJMovieSessionCallback.MJMoveSessionCallbackArg
  {
    public MJTime lastFrameTime;
    public MJTimeRange mediaTimeRange;
    public long tag;
    
    public MediaTimeChangeArg(MJTime paramMJTime, MJTimeRange paramMJTimeRange, long paramLong)
    {
      this.lastFrameTime = paramMJTime;
      this.mediaTimeRange = paramMJTimeRange;
      this.tag = paramLong;
    }
  }
  
  public static class ProgressArg
    extends MJMovieSessionCallback.MJMoveSessionCallbackArg
  {
    public final float progress;
    
    public ProgressArg(float paramFloat)
    {
      this.progress = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.MJMoveSessionCallbackArg
 * JD-Core Version:    0.7.0.1
 */