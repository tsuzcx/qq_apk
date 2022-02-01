package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class d
{
  private static final String rCi;
  private static final String rCj;
  
  static
  {
    AppMethodBeat.i(23505);
    rCi = b.aKZ() + "uploaded_photos/";
    rCj = b.aKZ() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String anA(String paramString)
  {
    AppMethodBeat.i(23503);
    if (Util.isNullOrNil(paramString)) {}
    for (String str = "";; str = aa.z(new o(cKY(), str).her()))
    {
      BitmapUtil.createThumbNail(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str, true);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = MD5Util.getMD5String(paramString);
      str = str + "_t";
    }
  }
  
  public static o cKY()
  {
    AppMethodBeat.i(23504);
    o localo = new o(rCi);
    if ((!localo.exists()) || (!localo.isDirectory())) {
      localo.mkdirs();
    }
    AppMethodBeat.o(23504);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.d
 * JD-Core Version:    0.7.0.1
 */