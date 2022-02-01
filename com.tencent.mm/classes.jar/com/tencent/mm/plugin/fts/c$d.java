package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a rmr;
  
  public c$d(c paramc, c.a parama)
  {
    this.rmr = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52508);
    ad.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new e(this.rmr.drZ).exists())
      {
        if ((this.rmr.bitmap != null) && (!this.rmr.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          f.a(this.rmr.bitmap, 100, Bitmap.CompressFormat.PNG, this.rmr.drZ, false);
          ad.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(52508);
          return;
        }
        ad.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
      }
      AppMethodBeat.o(52508);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(52508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */