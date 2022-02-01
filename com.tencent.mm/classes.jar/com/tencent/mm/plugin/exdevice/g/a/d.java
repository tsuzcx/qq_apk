package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  private static final String oXS;
  private static final String oXT;
  
  static
  {
    AppMethodBeat.i(23505);
    oXS = b.aiw() + "uploaded_photos/";
    oXT = b.aiw() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String UI(String paramString)
  {
    AppMethodBeat.i(23503);
    if (bt.isNullOrNil(paramString)) {}
    for (String str = "";; str = q.B(new e(bZT(), str).fhU()))
    {
      f.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = ai.du(paramString);
      str = str + "_t";
    }
  }
  
  public static e bZT()
  {
    AppMethodBeat.i(23504);
    e locale = new e(oXS);
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