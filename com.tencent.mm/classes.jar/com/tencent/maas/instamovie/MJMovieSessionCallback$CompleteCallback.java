package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMovieSessionCallback$CompleteCallback
  extends MJMovieSessionCallback.BaseCallback<MJMovieSessionCallback.MJMoveSessionCallbackArg.CompleteArg>
{
  private final MJMovieSession.OnComplete onComplete;
  
  public MJMovieSessionCallback$CompleteCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnComplete paramOnComplete)
  {
    super(paramMJMovieSession);
    this.onComplete = paramOnComplete;
  }
  
  public MJMovieSessionCallback$CompleteCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnComplete paramOnComplete, boolean paramBoolean)
  {
    super(paramMJMovieSession, paramBoolean);
    this.onComplete = paramOnComplete;
  }
  
  public void onInvoke(MJMovieSession paramMJMovieSession, MJMovieSessionCallback.MJMoveSessionCallbackArg.CompleteArg paramCompleteArg)
  {
    AppMethodBeat.i(216884);
    if ((this.onComplete != null) && (paramCompleteArg != null)) {
      this.onComplete.onComplete(paramCompleteArg.error);
    }
    AppMethodBeat.o(216884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.CompleteCallback
 * JD-Core Version:    0.7.0.1
 */