package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMovieSessionCallback$MediaTimeChangeCallback
  extends MJMovieSessionCallback.BaseCallback<MJMovieSessionCallback.MJMoveSessionCallbackArg.MediaTimeChangeArg>
{
  private final MJMovieSession.OnMediaTimeChange onMediaTimeChange;
  
  public MJMovieSessionCallback$MediaTimeChangeCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnMediaTimeChange paramOnMediaTimeChange)
  {
    super(paramMJMovieSession);
    this.onMediaTimeChange = paramOnMediaTimeChange;
  }
  
  public MJMovieSessionCallback$MediaTimeChangeCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnMediaTimeChange paramOnMediaTimeChange, boolean paramBoolean)
  {
    super(paramMJMovieSession, paramBoolean);
    this.onMediaTimeChange = paramOnMediaTimeChange;
  }
  
  public void onInvoke(MJMovieSession paramMJMovieSession, MJMovieSessionCallback.MJMoveSessionCallbackArg.MediaTimeChangeArg paramMediaTimeChangeArg)
  {
    AppMethodBeat.i(216882);
    if ((this.onMediaTimeChange != null) && (paramMediaTimeChangeArg != null)) {
      this.onMediaTimeChange.onMediaTimeChange(paramMediaTimeChangeArg.lastFrameTime, paramMediaTimeChangeArg.mediaTimeRange, paramMediaTimeChangeArg.tag);
    }
    AppMethodBeat.o(216882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.MediaTimeChangeCallback
 * JD-Core Version:    0.7.0.1
 */