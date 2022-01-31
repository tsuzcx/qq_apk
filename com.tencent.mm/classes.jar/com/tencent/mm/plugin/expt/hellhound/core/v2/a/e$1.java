package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.b;
import com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements a
{
  e$1(e parame) {}
  
  public final void vo(int paramInt)
  {
    AppMethodBeat.i(152297);
    ab.i("FragmentMonitor", "habbyge-mali, mHijackCallback, event: ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      if (this.maw.mau != null)
      {
        this.maw.mau.vi(0);
        AppMethodBeat.o(152297);
      }
    }
    else if ((paramInt == 1) && (this.maw.mau != null)) {
      this.maw.mau.vj(1);
    }
    AppMethodBeat.o(152297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.e.1
 * JD-Core Version:    0.7.0.1
 */