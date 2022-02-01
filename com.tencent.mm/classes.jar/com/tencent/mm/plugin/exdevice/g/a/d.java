package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class d
{
  private static final String vhQ;
  private static final String vhR;
  
  static
  {
    AppMethodBeat.i(23505);
    vhQ = b.aTb() + "uploaded_photos/";
    vhR = b.aTb() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String avz(String paramString)
  {
    AppMethodBeat.i(23503);
    if (Util.isNullOrNil(paramString)) {}
    for (String str = "";; str = new q(cZL(), str).bOF())
    {
      BitmapUtil.createThumbNail(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str, true);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = MD5Util.getMD5String(paramString);
      str = str + "_t";
    }
  }
  
  public static q cZL()
  {
    AppMethodBeat.i(23504);
    q localq = new q(vhQ);
    if ((!localq.ifE()) || (!localq.isDirectory())) {
      localq.ifL();
    }
    AppMethodBeat.o(23504);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.d
 * JD-Core Version:    0.7.0.1
 */