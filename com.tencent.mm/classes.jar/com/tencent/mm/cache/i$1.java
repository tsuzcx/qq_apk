package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

final class i$1
  implements Runnable
{
  i$1(i parami, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(9227);
    try
    {
      BitmapUtil.saveBitmapToImage(this.lvW, 50, Bitmap.CompressFormat.PNG, this.val$path, true);
      AppMethodBeat.o(9227);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
      AppMethodBeat.o(9227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.i.1
 * JD-Core Version:    0.7.0.1
 */