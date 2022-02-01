package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public b dBf;
  private d dBg;
  private Object dBh;
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(146311);
    if (this.dBf == null) {
      Log.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146311);
      return false;
    }
    boolean bool = this.dBf.ZZ();
    synchronized (this.dBh)
    {
      if (this.dBg != null)
      {
        this.dBg.flush();
        this.dBg.close();
        this.dBg = null;
      }
      this.dBf.release();
      Log.i("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146311);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a
 * JD-Core Version:    0.7.0.1
 */