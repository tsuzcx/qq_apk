package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a ktM;
  
  public c$d(c paramc, c.a parama)
  {
    this.ktM = parama;
  }
  
  public final void run()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new File(this.ktM.bTY).exists())
      {
        if ((this.ktM.bitmap != null) && (!this.ktM.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.c.a(this.ktM.bitmap, 100, Bitmap.CompressFormat.PNG, this.ktM.bTY, false);
          y.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          return;
        }
        y.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
        return;
      }
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */