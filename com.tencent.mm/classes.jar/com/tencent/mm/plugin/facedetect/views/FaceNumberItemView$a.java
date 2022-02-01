package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

final class FaceNumberItemView$a
  extends TimerTask
{
  private WeakReference<Runnable> pVY;
  
  private FaceNumberItemView$a(FaceNumberItemView paramFaceNumberItemView, Runnable paramRunnable)
  {
    AppMethodBeat.i(104164);
    this.pVY = null;
    this.pVY = new WeakReference(paramRunnable);
    AppMethodBeat.o(104164);
  }
  
  public final void run()
  {
    AppMethodBeat.i(104165);
    if ((this.pVY != null) && (this.pVY.get() != null))
    {
      aq.f((Runnable)this.pVY.get());
      AppMethodBeat.o(104165);
      return;
    }
    cancel();
    AppMethodBeat.o(104165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */