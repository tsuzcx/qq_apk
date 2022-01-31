package com.tencent.mm.at;

import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

final class p$2
  extends AsyncTask<p.b, Integer, Integer>
{
  p$2(p paramp) {}
  
  private static Integer a(p.b... paramVarArgs)
  {
    AppMethodBeat.i(78397);
    if ((paramVarArgs.length == 0) || (bo.isNullOrNil(paramVarArgs[0].path)) || (paramVarArgs[0].bitmap == null))
    {
      ab.e("MicroMsg.UrlImageCacheService", "nothing to save");
      AppMethodBeat.o(78397);
      return null;
    }
    try
    {
      d.a(paramVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramVarArgs[0].path, false);
      AppMethodBeat.o(78397);
      return null;
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        ab.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramVarArgs.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.p.2
 * JD-Core Version:    0.7.0.1
 */