package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class d
{
  private static final String lHh;
  private static final String lHi;
  
  static
  {
    AppMethodBeat.i(19438);
    lHh = e.esz + "uploaded_photos/";
    lHi = e.esz + "temp/";
    AppMethodBeat.o(19438);
  }
  
  public static String Lz(String paramString)
  {
    AppMethodBeat.i(19436);
    if (bo.isNullOrNil(paramString)) {}
    for (String str = "";; str = j.p(new b(bql(), str).dQJ()))
    {
      com.tencent.mm.sdk.platformtools.d.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      AppMethodBeat.o(19436);
      return str;
      str = ag.cE(paramString);
      str = str + "_t";
    }
  }
  
  public static b bql()
  {
    AppMethodBeat.i(19437);
    b localb = new b(lHh);
    if ((!localb.exists()) || (!localb.isDirectory())) {
      localb.mkdirs();
    }
    AppMethodBeat.o(19437);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.d
 * JD-Core Version:    0.7.0.1
 */