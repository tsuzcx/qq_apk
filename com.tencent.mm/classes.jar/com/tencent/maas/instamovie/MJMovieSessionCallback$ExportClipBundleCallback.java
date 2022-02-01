package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMovieSessionCallback$ExportClipBundleCallback
  extends MJMovieSessionCallback.BaseCallback<MJMovieSessionCallback.MJMoveSessionCallbackArg.ExportClipBundleArg>
{
  private final MJMovieSession.OnExportClipBundle onExportClipBundle;
  
  public MJMovieSessionCallback$ExportClipBundleCallback(MJMovieSession paramMJMovieSession, MJMovieSession.OnExportClipBundle paramOnExportClipBundle)
  {
    super(paramMJMovieSession);
    this.onExportClipBundle = paramOnExportClipBundle;
  }
  
  public MJMovieSessionCallback$ExportClipBundleCallback(MJMovieSession paramMJMovieSession, boolean paramBoolean, MJMovieSession.OnExportClipBundle paramOnExportClipBundle)
  {
    super(paramMJMovieSession, paramBoolean);
    this.onExportClipBundle = paramOnExportClipBundle;
  }
  
  public void onInvoke(MJMovieSession paramMJMovieSession, MJMovieSessionCallback.MJMoveSessionCallbackArg.ExportClipBundleArg paramExportClipBundleArg)
  {
    AppMethodBeat.i(216917);
    if ((this.onExportClipBundle != null) && (paramExportClipBundleArg != null)) {
      this.onExportClipBundle.onExportClipBundle(paramExportClipBundleArg.path, paramExportClipBundleArg.error);
    }
    AppMethodBeat.o(216917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.ExportClipBundleCallback
 * JD-Core Version:    0.7.0.1
 */