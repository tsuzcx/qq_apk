package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class n$6
  implements Runnable
{
  n$6(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(76635);
    boolean bool = this.oJA.Xs();
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      if (this.oJA.fcA != null)
      {
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
        al.d(this.oJA.fcA);
        AppMethodBeat.o(76635);
      }
    }
    else
    {
      SightVideoJNI.releaseBigSightDataBufferLock(this.oJA.eRm);
      if (this.oJA.fcz != null) {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(76634);
            n.6.this.oJA.fcz.asO();
            AppMethodBeat.o(76634);
          }
        });
      }
    }
    AppMethodBeat.o(76635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.6
 * JD-Core Version:    0.7.0.1
 */