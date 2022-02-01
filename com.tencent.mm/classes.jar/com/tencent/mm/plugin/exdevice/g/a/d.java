package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class d
{
  private static final String qln;
  private static final String qlo;
  
  static
  {
    AppMethodBeat.i(23505);
    qln = b.asz() + "uploaded_photos/";
    qlo = b.asz() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String adr(String paramString)
  {
    AppMethodBeat.i(23503);
    if (bu.isNullOrNil(paramString)) {}
    for (String str = "";; str = w.B(new k(cmW(), str).fTh()))
    {
      h.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = aj.ej(paramString);
      str = str + "_t";
    }
  }
  
  public static k cmW()
  {
    AppMethodBeat.i(23504);
    k localk = new k(qln);
    if ((!localk.exists()) || (!localk.isDirectory())) {
      localk.mkdirs();
    }
    AppMethodBeat.o(23504);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.d
 * JD-Core Version:    0.7.0.1
 */