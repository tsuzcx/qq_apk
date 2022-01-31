package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a mPA;
  
  public c$d(c paramc, c.a parama)
  {
    this.mPA = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136526);
    ab.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new File(this.mPA.cBD).exists())
      {
        if ((this.mPA.bitmap != null) && (!this.mPA.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          d.a(this.mPA.bitmap, 100, Bitmap.CompressFormat.PNG, this.mPA.cBD, false);
          ab.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(136526);
          return;
        }
        ab.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
      }
      AppMethodBeat.o(136526);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(136526);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */