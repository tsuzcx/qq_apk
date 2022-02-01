package com.tencent.mm.cw;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.a;

public final class d
  implements a
{
  private MMHandler mHandler;
  
  public d(MMHandler paramMMHandler)
  {
    this.mHandler = paramMMHandler;
  }
  
  public static d b(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(133525);
    paramMMHandler = new d(paramMMHandler);
    AppMethodBeat.o(133525);
    return paramMMHandler;
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(133527);
    this.mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(133527);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(133528);
    Looper localLooper = this.mHandler.getLooper();
    AppMethodBeat.o(133528);
    return localLooper;
  }
  
  public final void hC()
  {
    AppMethodBeat.i(133529);
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(133529);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(133526);
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(133526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cw.d
 * JD-Core Version:    0.7.0.1
 */