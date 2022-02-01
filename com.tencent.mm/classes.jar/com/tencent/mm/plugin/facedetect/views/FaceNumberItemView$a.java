package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;

final class FaceNumberItemView$a
  implements MTimerHandler.CallBack
{
  private final WeakReference<Runnable> wCt;
  
  public FaceNumberItemView$a(Runnable paramRunnable)
  {
    AppMethodBeat.i(196533);
    this.wCt = new WeakReference(paramRunnable);
    AppMethodBeat.o(196533);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(196535);
    Runnable localRunnable = (Runnable)this.wCt.get();
    if (localRunnable == null)
    {
      AppMethodBeat.o(196535);
      return false;
    }
    localRunnable.run();
    AppMethodBeat.o(196535);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */