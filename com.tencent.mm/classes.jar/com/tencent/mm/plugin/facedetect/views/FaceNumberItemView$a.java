package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

final class FaceNumberItemView$a
  extends TimerTask
{
  private WeakReference<Runnable> mpp;
  
  private FaceNumberItemView$a(FaceNumberItemView paramFaceNumberItemView, Runnable paramRunnable)
  {
    AppMethodBeat.i(643);
    this.mpp = null;
    this.mpp = new WeakReference(paramRunnable);
    AppMethodBeat.o(643);
  }
  
  public final void run()
  {
    AppMethodBeat.i(644);
    if ((this.mpp != null) && (this.mpp.get() != null))
    {
      al.d((Runnable)this.mpp.get());
      AppMethodBeat.o(644);
      return;
    }
    cancel();
    AppMethodBeat.o(644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */