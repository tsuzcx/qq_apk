package com.github.henryye.nativeiv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 enum d
{
  private static int aPx;
  ExecutorService aPy;
  ExecutorService aPz;
  
  static
  {
    AppMethodBeat.i(127348);
    aPw = new d("INSTANCE");
    aPA = new d[] { aPw };
    aPx = Runtime.getRuntime().availableProcessors() + 1;
    AppMethodBeat.o(127348);
  }
  
  private d()
  {
    AppMethodBeat.i(127347);
    this.aPy = null;
    this.aPz = null;
    int i = Math.max(aPx, 5);
    this.aPy = new ThreadPoolExecutor(1, Math.max(i / 2, 4), 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(127343);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, "native_image_decode_net");
        AppMethodBeat.o(127343);
        return paramAnonymousRunnable;
      }
    });
    this.aPz = new ThreadPoolExecutor(i - 1, i, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(127344);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, "native_image_decode_local");
        AppMethodBeat.o(127344);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(127347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.d
 * JD-Core Version:    0.7.0.1
 */