package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import java.io.File;

public final class bb
{
  public static void clear(String paramString)
  {
    AppMethodBeat.i(59545);
    String str2 = g.RL().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    paramString = new File(str1 + "appbrand/loadingurl" + File.separator + paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      com.tencent.mm.a.e.o(paramString);
    }
    str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith("/")) {
      paramString = str1 + "/";
    }
    paramString = new File(paramString + "Tencent/MicroMsg/appbrand/loadingurl");
    if ((paramString.exists()) && (paramString.isDirectory())) {
      com.tencent.mm.a.e.o(paramString);
    }
    AppMethodBeat.o(59545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */