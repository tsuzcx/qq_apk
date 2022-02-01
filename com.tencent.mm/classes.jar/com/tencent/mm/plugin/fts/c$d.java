package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a svl;
  
  public c$d(c paramc, c.a parama)
  {
    this.svl = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52508);
    ac.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new e(this.svl.dpK).exists())
      {
        if ((this.svl.bitmap != null) && (!this.svl.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          f.a(this.svl.bitmap, 100, Bitmap.CompressFormat.PNG, this.svl.dpK, false);
          ac.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(52508);
          return;
        }
        ac.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
      }
      AppMethodBeat.o(52508);
      return;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(52508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */