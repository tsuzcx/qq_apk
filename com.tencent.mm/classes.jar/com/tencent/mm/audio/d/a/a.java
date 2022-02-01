package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public b diT;
  private d diU;
  private Object diV;
  
  public final boolean PG()
  {
    AppMethodBeat.i(146311);
    if (this.diT == null) {
      ad.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146311);
      return false;
    }
    boolean bool = this.diT.PG();
    synchronized (this.diV)
    {
      if (this.diU != null)
      {
        this.diU.flush();
        this.diU.close();
        this.diU = null;
      }
      this.diT.release();
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