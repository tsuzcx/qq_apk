package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ad;

final class l$2
  implements Runnable
{
  l$2(l paraml, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(78744);
    switch (this.fTY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78744);
      return;
      ad.a(g.RL().eHR + this.fTZ, r.Zn(), false, true);
      AppMethodBeat.o(78744);
      return;
      ad.a(g.RL().cachePath + this.fTZ, r.Zn(), false, true);
      AppMethodBeat.o(78744);
      return;
      ad.a(this.fTZ, r.Zn(), false, true);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78745);
    String str = super.toString() + "|onPreAddMessage";
    AppMethodBeat.o(78745);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.2
 * JD-Core Version:    0.7.0.1
 */