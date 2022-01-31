package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements a.a
{
  g$1(g paramg) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gNX.onError(1);
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    g localg;
    int j;
    int i;
    if ((g.a(this.gNX) != null) && (g.b(this.gNX) != null))
    {
      localg = this.gNX;
      j = g.c(this.gNX);
      a locala = g.b(this.gNX);
      if (locala.bCc == null) {
        break label103;
      }
      i = locala.bCc.bCz;
    }
    for (;;)
    {
      g.a(localg, i + j);
      try
      {
        if (!g.a(this.gNX).a(g.d(this.gNX), paramArrayOfByte, paramInt)) {
          y.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
        }
        return;
        label103:
        i = 20;
      }
      catch (Exception paramArrayOfByte)
      {
        do
        {
          y.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramArrayOfByte, "onRecPcmDataReady", new Object[0]);
          if ((g.e(this.gNX) != null) && ("mp3".equalsIgnoreCase(g.e(this.gNX).gja)))
          {
            j.lU(19);
            return;
          }
        } while ((g.e(this.gNX) == null) || (!"aac".equalsIgnoreCase(g.e(this.gNX).gja)));
        j.lU(23);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.1
 * JD-Core Version:    0.7.0.1
 */