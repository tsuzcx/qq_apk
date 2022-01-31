package com.a.a;

import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements IBinder.DeathRecipient
{
  a$1(a parama) {}
  
  public final void binderDied()
  {
    AppMethodBeat.i(118244);
    if (this.blH.blE != null) {
      this.blH.blE.bC(2101, -1);
    }
    AppMethodBeat.o(118244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */