package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

final class FaceNumberItemView$a
  extends TimerTask
{
  private WeakReference<Runnable> jUW = null;
  
  private FaceNumberItemView$a(FaceNumberItemView paramFaceNumberItemView, Runnable paramRunnable)
  {
    this.jUW = new WeakReference(paramRunnable);
  }
  
  public final void run()
  {
    if ((this.jUW != null) && (this.jUW.get() != null))
    {
      ai.d((Runnable)this.jUW.get());
      return;
    }
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.a
 * JD-Core Version:    0.7.0.1
 */