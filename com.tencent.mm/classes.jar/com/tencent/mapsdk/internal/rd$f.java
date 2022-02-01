package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class rd$f
  implements Runnable
{
  private WeakReference<rd> a;
  
  public rd$f(rd paramrd)
  {
    AppMethodBeat.i(225565);
    this.a = new WeakReference(paramrd);
    AppMethodBeat.o(225565);
  }
  
  public final void run()
  {
    AppMethodBeat.i(225576);
    if (this.a != null)
    {
      rd localrd = (rd)this.a.get();
      if (localrd != null) {
        localrd.a(rd.j(localrd), null);
      }
    }
    AppMethodBeat.o(225576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rd.f
 * JD-Core Version:    0.7.0.1
 */