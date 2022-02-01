package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMovieSessionCallback$ProgressCallback
  extends MJMovieSessionCallback.BaseCallback<MJMovieSessionCallback.MJMoveSessionCallbackArg.ProgressArg>
{
  private final MJMovieSession.OnProgress onProgress;
  
  public MJMovieSessionCallback$ProgressCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnProgress paramOnProgress)
  {
    super(paramMJMovieSession);
    this.onProgress = paramOnProgress;
  }
  
  public MJMovieSessionCallback$ProgressCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnProgress paramOnProgress, boolean paramBoolean)
  {
    super(paramMJMovieSession, paramBoolean);
    this.onProgress = paramOnProgress;
  }
  
  public void onInvoke(MJMovieSession paramMJMovieSession, MJMovieSessionCallback.MJMoveSessionCallbackArg.ProgressArg paramProgressArg)
  {
    AppMethodBeat.i(216930);
    if ((this.onProgress != null) && (paramProgressArg != null)) {
      this.onProgress.onProgress(paramProgressArg.progress);
    }
    AppMethodBeat.o(216930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.ProgressCallback
 * JD-Core Version:    0.7.0.1
 */