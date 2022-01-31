package com.tencent.mm.plugin.appbrand.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public final class b
{
  public static void a(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(65354);
    if ((paramInputStream == null) || (!cN(paramString)))
    {
      AppMethodBeat.o(65354);
      return;
    }
    paramString = new android.support.d.a(paramString);
    a.a(new android.support.d.a(paramInputStream), paramString);
    paramString.setAttribute("Orientation", null);
    paramString.setAttribute("ImageWidth", null);
    paramString.setAttribute("ThumbnailImageWidth", null);
    paramString.saveAttributes();
    AppMethodBeat.o(65354);
  }
  
  public static void bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65353);
    if ((!cN(paramString1)) || (!cN(paramString2)))
    {
      AppMethodBeat.o(65353);
      return;
    }
    paramString2 = new android.support.d.a(paramString2);
    a.a(new android.support.d.a(paramString1), paramString2);
    paramString2.setAttribute("Orientation", null);
    paramString2.setAttribute("ImageWidth", null);
    paramString2.setAttribute("ThumbnailImageWidth", null);
    paramString2.saveAttributes();
    AppMethodBeat.o(65353);
  }
  
  private static boolean cN(String paramString)
  {
    AppMethodBeat.i(65355);
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      AppMethodBeat.o(65355);
      return true;
    }
    AppMethodBeat.o(65355);
    return false;
  }
  
  public static int f(InputStream paramInputStream)
  {
    AppMethodBeat.i(65352);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(65352);
      return 0;
    }
    try
    {
      int i = new android.support.d.a(paramInputStream).getAttributeInt("Orientation", 1);
      AppMethodBeat.o(65352);
      return i;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(65352);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b
 * JD-Core Version:    0.7.0.1
 */