package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class d
{
  private static final String ytR;
  private static final String ytS;
  
  static
  {
    AppMethodBeat.i(23505);
    ytR = b.bmP() + "uploaded_photos/";
    ytS = b.bmP() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String apz(String paramString)
  {
    AppMethodBeat.i(23503);
    if (Util.isNullOrNil(paramString)) {}
    for (String str = "";; str = ah.v(new u(dGe(), str).jKT()))
    {
      BitmapUtil.createThumbNail(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str, true);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = MD5Util.getMD5String(paramString);
      str = str + "_t";
    }
  }
  
  public static u dGe()
  {
    AppMethodBeat.i(23504);
    u localu = new u(ytR);
    if ((!localu.jKS()) || (!localu.isDirectory())) {
      localu.jKY();
    }
    AppMethodBeat.o(23504);
    return localu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.d
 * JD-Core Version:    0.7.0.1
 */