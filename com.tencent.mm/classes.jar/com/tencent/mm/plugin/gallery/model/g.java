package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class g
{
  public ak faV;
  HandlerThread ndf;
  HandlerThread ndg;
  HandlerThread ndh;
  ak ndi;
  ak ndj;
  ak ndk;
  
  public g()
  {
    AppMethodBeat.i(21273);
    ab.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
    this.ndf = new HandlerThread("galleryDecodeHanlderThread", 10);
    this.ndi = null;
    this.ndf.start();
    this.ndg = new HandlerThread("galleryQueryHandlerThread", 1);
    this.ndj = null;
    this.ndg.start();
    this.ndh = new HandlerThread("galleryAfterTakePicThreadThread", 0);
    this.ndk = null;
    this.ndh.start();
    AppMethodBeat.o(21273);
  }
  
  private ak bEd()
  {
    AppMethodBeat.i(21274);
    if ((this.ndi == null) && (this.ndf != null)) {
      this.ndi = new ak(this.ndf.getLooper());
    }
    ak localak = this.ndi;
    AppMethodBeat.o(21274);
    return localak;
  }
  
  public final void T(Runnable paramRunnable)
  {
    AppMethodBeat.i(21278);
    ak localak = bEd();
    if (localak == null)
    {
      ab.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
      AppMethodBeat.o(21278);
      return;
    }
    localak.post(paramRunnable);
    AppMethodBeat.o(21278);
  }
  
  public final void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(21279);
    ak localak = bEd();
    if (localak == null)
    {
      ab.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
      AppMethodBeat.o(21279);
      return;
    }
    ab.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[] { Boolean.valueOf(localak.postAtFrontOfQueueV2(paramRunnable)) });
    AppMethodBeat.o(21279);
  }
  
  public final ak bEe()
  {
    AppMethodBeat.i(21276);
    if (this.ndj == null) {
      this.ndj = new ak(this.ndg.getLooper());
    }
    ak localak = this.ndj;
    AppMethodBeat.o(21276);
    return localak;
  }
  
  public final ak bEf()
  {
    AppMethodBeat.i(21277);
    if (this.faV == null) {
      this.faV = new ak(Looper.getMainLooper());
    }
    ak localak = this.faV;
    AppMethodBeat.o(21277);
    return localak;
  }
  
  public final void bEg()
  {
    AppMethodBeat.i(21280);
    ak localak = bEd();
    if (localak == null)
    {
      ab.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
      AppMethodBeat.o(21280);
      return;
    }
    localak.removeCallbacksAndMessages(null);
    this.ndi = null;
    AppMethodBeat.o(21280);
  }
  
  public final void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(21281);
    bEf().post(paramRunnable);
    AppMethodBeat.o(21281);
  }
  
  public final void wL(int paramInt)
  {
    AppMethodBeat.i(21275);
    try
    {
      Process.setThreadPriority(this.ndh.getThreadId(), paramInt);
      AppMethodBeat.o(21275);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.GalleryHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(21275);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.g
 * JD-Core Version:    0.7.0.1
 */