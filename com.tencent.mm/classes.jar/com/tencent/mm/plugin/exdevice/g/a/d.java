package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  private static final String pBd;
  private static final String pBe;
  
  static
  {
    AppMethodBeat.i(23505);
    pBd = b.apw() + "uploaded_photos/";
    pBe = b.apw() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String YU(String paramString)
  {
    AppMethodBeat.i(23503);
    if (bs.isNullOrNil(paramString)) {}
    for (String str = "";; str = q.B(new e(chc(), str).fxV()))
    {
      f.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = ah.dg(paramString);
      str = str + "_t";
    }
  }
  
  public static e chc()
  {
    AppMethodBeat.i(23504);
    e locale = new e(pBd);
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    AppMethodBeat.o(23504);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.d
 * JD-Core Version:    0.7.0.1
 */