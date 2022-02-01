package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

final class FaceNumberItemView$a
  extends TimerTask
{
  private WeakReference<Runnable> sWv;
  
  private FaceNumberItemView$a(FaceNumberItemView paramFaceNumberItemView, Runnable paramRunnable)
  {
    AppMethodBeat.i(104164);
    this.sWv = null;
    this.sWv = new WeakReference(paramRunnable);
    AppMethodBeat.o(104164);
  }
  
  public final void run()
  {
    AppMethodBeat.i(104165);
    if ((this.sWv != null) && (this.sWv.get() != null))
    {
      MMHandlerThread.postToMainThread((Runnable)this.sWv.get());
      AppMethodBeat.o(104165);
      return;
    }
    cancel();
    AppMethodBeat.o(104165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */