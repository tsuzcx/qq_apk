package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap.a;

final class f$1
  implements ap.a
{
  f$1(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(18334);
    f.e(this.jNt).post(new f.1.1(this));
    AppMethodBeat.o(18334);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f.1
 * JD-Core Version:    0.7.0.1
 */