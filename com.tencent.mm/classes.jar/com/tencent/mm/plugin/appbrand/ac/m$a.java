package com.tencent.mm.plugin.appbrand.ac;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

@Deprecated
public final class m$a
  extends MMHandler
{
  m$a(String paramString)
  {
    super(paramString);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(221351);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(221351);
    throw localUnsupportedOperationException;
  }
  
  public final boolean j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(221350);
    boolean bool = super.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(221350);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.m.a
 * JD-Core Version:    0.7.0.1
 */