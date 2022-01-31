package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$3
  implements Runnable
{
  j$3(j paramj, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(129549);
    j localj = this.hbe;
    int j = this.Au;
    int k = this.hbf;
    if ((this.hbg & t.axy())) {}
    for (int i = 2;; i = 0)
    {
      j.a(localj, j, k, i | 0x1, this.hbh, this.hbg, this.hbi);
      AppMethodBeat.o(129549);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j.3
 * JD-Core Version:    0.7.0.1
 */