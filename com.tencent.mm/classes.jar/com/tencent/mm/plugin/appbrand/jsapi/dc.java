package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "createThumbFile", "Lcom/tencent/mm/vfs/VFSFile;", "videoPath", "getThumbPathWorkaround", "thumbPath", "parseVideoDurationS", "", "plugin-appbrand-integration_release"})
public final class dc
{
  public static final int Zj(String paramString)
  {
    AppMethodBeat.i(228300);
    p.h(paramString, "videoPath");
    try
    {
      com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
      locald.setDataSource(paramString);
      long l = Util.getLong(locald.extractMetadata(9), 0L);
      locald.release();
      i = Util.videoMsToSec(l);
      Log.i("MicroMsg.AppBrand.SendVideoCommons", "parseVideoDurationS, duration: ".concat(String.valueOf(i)));
      AppMethodBeat.o(228300);
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
  
  private static final o Zk(String paramString)
  {
    AppMethodBeat.i(228301);
    o localo = new o(paramString + ".jpg");
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.PF(paramString);
      paramString = localo;
      if (localBitmap != null)
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, localo.getAbsolutePath(), true);
        paramString = localo;
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
    AppMethodBeat.o(228301);
    return paramString;
  }
  
  public static final String dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228299);
    p.h(paramString1, "videoPath");
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString1 = Zk(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getAbsolutePath();
        AppMethodBeat.o(228299);
        return paramString1;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(228299);
        return null;
      }
    }
    AppMethodBeat.o(228299);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dc
 * JD-Core Version:    0.7.0.1
 */