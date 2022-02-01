package com.tencent.mm.cn;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.a;

public final class d
  implements a
{
  private ap mHandler;
  
  public d(ap paramap)
  {
    this.mHandler = paramap;
  }
  
  public static d c(ap paramap)
  {
    AppMethodBeat.i(133525);
    paramap = new d(paramap);
    AppMethodBeat.o(133525);
    return paramap;
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(133527);
    this.mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(133527);
  }
  
  public final void fL()
  {
    AppMethodBeat.i(133529);
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(133529);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(133528);
    Looper localLooper = this.mHandler.getLooper();
    AppMethodBeat.o(133528);
    return localLooper;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(133526);
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(133526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cn.d
 * JD-Core Version:    0.7.0.1
 */