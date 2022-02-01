package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a tCD;
  
  public c$d(c paramc, c.a parama)
  {
    this.tCD = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52508);
    ae.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new k(this.tCD.dCC).exists())
      {
        if ((this.tCD.bitmap != null) && (!this.tCD.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          h.a(this.tCD.bitmap, 100, Bitmap.CompressFormat.PNG, this.tCD.dCC, false);
          ae.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(52508);
          return;
        }
        ae.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
      }
      AppMethodBeat.o(52508);
      return;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(52508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */