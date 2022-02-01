package com.tencent.luggage.h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class f$1
  implements f.c
{
  f$1(f paramf, f.c paramc) {}
  
  public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174616);
    this.cDs.cDm.remove(this);
    boolean bool = this.cDr.c(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(174616);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.f.1
 * JD-Core Version:    0.7.0.1
 */