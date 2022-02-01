package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "createThumbFile", "Lcom/tencent/mm/vfs/VFSFile;", "videoPath", "getThumbPathWorkaround", "thumbPath", "parseVideoDurationS", "", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class dn
{
  public static final int ZT(String paramString)
  {
    AppMethodBeat.i(325916);
    s.u(paramString, "videoPath");
    try
    {
      com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
      locald.setDataSource(paramString);
      long l = Util.getLong(locald.extractMetadata(9), 0L);
      locald.release();
      i = Util.videoMsToSec(l);
      Log.i("MicroMsg.AppBrand.SendVideoCommons", s.X("parseVideoDurationS, duration: ", Integer.valueOf(i)));
      AppMethodBeat.o(325916);
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
  
  private static final u ZU(String paramString)
  {
    AppMethodBeat.i(325919);
    u localu = new u(s.X(paramString, ".jpg"));
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Pf(paramString);
      paramString = localu;
      if (localBitmap != null)
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, ah.v(localu.jKT()), true);
        paramString = localu;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.SendVideoCommons", s.X("createThumbFile, fail since ", paramString));
        paramString = null;
      }
    }
    AppMethodBeat.o(325919);
    return paramString;
  }
  
  public static final String dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(325914);
    s.u(paramString1, "videoPath");
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString1 = ZU(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(325914);
        return null;
        i = 0;
      }
      else
      {
        paramString1 = ah.v(paramString1.jKT());
        AppMethodBeat.o(325914);
        return paramString1;
      }
    }
    AppMethodBeat.o(325914);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dn
 * JD-Core Version:    0.7.0.1
 */