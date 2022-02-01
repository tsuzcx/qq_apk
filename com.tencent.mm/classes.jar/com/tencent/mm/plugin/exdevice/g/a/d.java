package com.tencent.mm.plugin.exdevice.g.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class d
{
  private static final String qeI;
  private static final String qeJ;
  
  static
  {
    AppMethodBeat.i(23505);
    qeI = b.ask() + "uploaded_photos/";
    qeJ = b.ask() + "temp/";
    AppMethodBeat.o(23505);
  }
  
  public static String acA(String paramString)
  {
    AppMethodBeat.i(23503);
    if (bt.isNullOrNil(paramString)) {}
    for (String str = "";; str = q.B(new e(clG(), str).fOK()))
    {
      g.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      AppMethodBeat.o(23503);
      return str;
      str = ai.ee(paramString);
      str = str + "_t";
    }
  }
  
  public static e clG()
  {
    AppMethodBeat.i(23504);
    e locale = new e(qeI);
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