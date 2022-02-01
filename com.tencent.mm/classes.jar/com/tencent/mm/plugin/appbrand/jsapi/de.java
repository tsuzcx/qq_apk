package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "createThumbFile", "Lcom/tencent/mm/vfs/VFSFile;", "videoPath", "getThumbPathWorkaround", "thumbPath", "parseVideoDurationS", "", "plugin-appbrand-integration_release"})
public final class de
{
  public static final int agW(String paramString)
  {
    AppMethodBeat.i(278145);
    p.k(paramString, "videoPath");
    try
    {
      com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
      locald.setDataSource(paramString);
      long l = Util.getLong(locald.extractMetadata(9), 0L);
      locald.release();
      i = Util.videoMsToSec(l);
      Log.i("MicroMsg.AppBrand.SendVideoCommons", "parseVideoDurationS, duration: ".concat(String.valueOf(i)));
      AppMethodBeat.o(278145);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  private static final q agX(String paramString)
  {
    AppMethodBeat.i(278146);
    q localq = new q(paramString + ".jpg");
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Xd(paramString);
      paramString = localq;
      if (localBitmap != null)
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, localq.bOF(), true);
        paramString = localq;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.SendVideoCommons", "createThumbFile, fail since ".concat(String.valueOf(paramString)));
        paramString = null;
      }
    }
    AppMethodBeat.o(278146);
    return paramString;
  }
  
  public static final String dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(278143);
    p.k(paramString1, "videoPath");
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString1 = agX(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.bOF();
        AppMethodBeat.o(278143);
        return paramString1;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(278143);
        return null;
      }
    }
    AppMethodBeat.o(278143);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.de
 * JD-Core Version:    0.7.0.1
 */