package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public b djV;
  private d djW;
  private Object djX;
  
  public final boolean PF()
  {
    AppMethodBeat.i(146311);
    if (this.djV == null) {
      ae.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146311);
      return false;
    }
    boolean bool = this.djV.PF();
    synchronized (this.djX)
    {
      if (this.djW != null)
      {
        this.djW.flush();
        this.djW.close();
        this.djW = null;
      }
      this.djV.release();
      ae.i("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146311);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a
 * JD-Core Version:    0.7.0.1
 */