package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements b.a
{
  a$2(a parama) {}
  
  public final void w(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(140642);
    a locala = this.clq;
    synchronized (locala.clk)
    {
      d locald = locala.clh;
      if (locald != null) {}
      try
      {
        if (!locala.clh.a(false, paramArrayOfByte, paramInt)) {
          ab.e("MicroMsg.RecorderPcm", "encode pcm fail!");
        }
        AppMethodBeat.o(140642);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.b("MicroMsg.RecorderPcm", "", new Object[] { paramArrayOfByte });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a.2
 * JD-Core Version:    0.7.0.1
 */