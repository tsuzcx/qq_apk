package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public b cXB;
  private d cXC;
  private Object cXD;
  
  public final boolean NX()
  {
    AppMethodBeat.i(146311);
    if (this.cXB == null) {
      ac.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146311);
      return false;
    }
    boolean bool = this.cXB.NX();
    synchronized (this.cXD)
    {
      if (this.cXC != null)
      {
        this.cXC.flush();
        this.cXC.close();
        this.cXC = null;
      }
      this.cXB.release();
      ac.i("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146311);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a
 * JD-Core Version:    0.7.0.1
 */