package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public b daf;
  private d dag;
  private Object dah;
  
  public final boolean Ob()
  {
    AppMethodBeat.i(146311);
    if (this.daf == null) {
      ad.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146311);
      return false;
    }
    boolean bool = this.daf.Ob();
    synchronized (this.dah)
    {
      if (this.dag != null)
      {
        this.dag.flush();
        this.dag.close();
        this.dag = null;
      }
      this.daf.release();
      ad.i("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146311);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a
 * JD-Core Version:    0.7.0.1
 */