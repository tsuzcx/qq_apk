package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;

final class FaceNumberItemView$a
  implements MTimerHandler.CallBack
{
  private final WeakReference<Runnable> zYE;
  
  public FaceNumberItemView$a(Runnable paramRunnable)
  {
    AppMethodBeat.i(271913);
    this.zYE = new WeakReference(paramRunnable);
    AppMethodBeat.o(271913);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(271914);
    Runnable localRunnable = (Runnable)this.zYE.get();
    if (localRunnable == null)
    {
      AppMethodBeat.o(271914);
      return false;
    }
    localRunnable.run();
    AppMethodBeat.o(271914);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */