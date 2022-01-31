package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private ah dPi;
  HandlerThread kGN;
  HandlerThread kGO;
  HandlerThread kGP;
  ah kGQ;
  ah kGR;
  ah kGS;
  
  public e()
  {
    y.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
    this.kGN = new HandlerThread("galleryDecodeHanlderThread", 10);
    this.kGQ = null;
    this.kGN.start();
    this.kGO = new HandlerThread("galleryQueryHandlerThread", 1);
    this.kGR = null;
    this.kGO.start();
    this.kGP = new HandlerThread("galleryAfterTakePicThreadThread", 0);
    this.kGS = null;
    this.kGP.start();
  }
  
  public final void K(Runnable paramRunnable)
  {
    ah localah = aXo();
    if (localah == null)
    {
      y.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
      return;
    }
    localah.post(paramRunnable);
  }
  
  public final ah aXo()
  {
    if ((this.kGQ == null) && (this.kGN != null)) {
      this.kGQ = new ah(this.kGN.getLooper());
    }
    return this.kGQ;
  }
  
  public final ah aXp()
  {
    if (this.kGR == null) {
      this.kGR = new ah(this.kGO.getLooper());
    }
    return this.kGR;
  }
  
  public final ah aXq()
  {
    if (this.dPi == null) {
      this.dPi = new ah(Looper.getMainLooper());
    }
    return this.dPi;
  }
  
  public final void aXr()
  {
    ah localah = aXo();
    if (localah == null)
    {
      y.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
      return;
    }
    localah.removeCallbacksAndMessages(null);
  }
  
  public final void d(Runnable paramRunnable)
  {
    aXq().post(paramRunnable);
  }
  
  public final void rN(int paramInt)
  {
    try
    {
      Process.setThreadPriority(this.kGP.getThreadId(), paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.GalleryHandlerThread", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */