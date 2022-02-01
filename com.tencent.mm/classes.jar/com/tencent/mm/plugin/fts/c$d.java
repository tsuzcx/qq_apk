package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.IOException;

final class c$d
  implements Runnable
{
  private c.a BFA;
  
  public c$d(c paramc, c.a parama)
  {
    this.BFA = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52508);
    Log.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
    try
    {
      if (!new q(this.BFA.fNU).ifE())
      {
        if ((this.BFA.bitmap != null) && (!this.BFA.bitmap.isRecycled()))
        {
          long l = System.currentTimeMillis();
          BitmapUtil.saveBitmapToImage(this.BFA.bitmap, 100, Bitmap.CompressFormat.PNG, this.BFA.fNU, false);
          Log.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(52508);
          return;
        }
        Log.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
      }
      AppMethodBeat.o(52508);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(52508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */