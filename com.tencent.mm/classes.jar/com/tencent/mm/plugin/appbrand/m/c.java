package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public final class c
{
  private static SimpleDateFormat rus = null;
  
  private static boolean ZC(String paramString)
  {
    AppMethodBeat.i(138803);
    if ((!TextUtils.isEmpty(paramString)) && (new u(paramString).jKS()))
    {
      AppMethodBeat.o(138803);
      return true;
    }
    AppMethodBeat.o(138803);
    return false;
  }
  
  public static void b(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(138802);
    if ((paramInputStream == null) || (!ZC(paramString)))
    {
      AppMethodBeat.o(138802);
      return;
    }
    paramString = new a(paramString);
    b.a(new a(paramInputStream), paramString);
    paramString.m("Orientation", null);
    paramString.m("ImageWidth", null);
    paramString.m("ThumbnailImageWidth", null);
    paramString.FM();
    AppMethodBeat.o(138802);
  }
  
  public static void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138801);
    if ((!ZC(paramString1)) || (!ZC(paramString2)))
    {
      AppMethodBeat.o(138801);
      return;
    }
    paramString2 = new a(paramString2);
    b.a(new a(paramString1), paramString2);
    paramString2.m("Orientation", null);
    paramString2.m("ImageWidth", null);
    paramString2.m("ThumbnailImageWidth", null);
    paramString2.FM();
    AppMethodBeat.o(138801);
  }
  
  public static int v(InputStream paramInputStream)
  {
    AppMethodBeat.i(138800);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    try
    {
      int i = new a(paramInputStream).k("Orientation", 1);
      AppMethodBeat.o(138800);
      return i;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(138800);
      return 0;
    }
    catch (Error paramInputStream)
    {
      AppMethodBeat.o(138800);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.c
 * JD-Core Version:    0.7.0.1
 */