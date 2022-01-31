package com.tencent.mm.as;

import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class p$2
  extends AsyncTask<p.b, Integer, Integer>
{
  p$2(p paramp) {}
  
  private static Integer a(p.b... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (bk.bl(paramVarArgs[0].path)) || (paramVarArgs[0].bitmap == null))
    {
      y.e("MicroMsg.UrlImageCacheService", "nothing to save");
      return null;
    }
    try
    {
      c.a(paramVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramVarArgs[0].path, false);
      return null;
    }
    catch (IOException paramVarArgs)
    {
      y.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramVarArgs.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.as.p.2
 * JD-Core Version:    0.7.0.1
 */