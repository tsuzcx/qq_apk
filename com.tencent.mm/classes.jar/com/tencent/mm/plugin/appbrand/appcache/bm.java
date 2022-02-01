package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.File;

public final class bm
{
  public static void clear(String paramString)
  {
    AppMethodBeat.i(90662);
    String str2 = g.ajR().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    paramString = new k(str1 + "appbrand/loadingurl/" + paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      o.dd(w.B(paramString.mUri), true);
    }
    str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith("/")) {
      paramString = str1 + "/";
    }
    paramString = new k(paramString + "tencent/MicroMsg/appbrand/loadingurl");
    if ((paramString.exists()) && (paramString.isDirectory())) {
      o.dd(w.B(paramString.mUri), true);
    }
    AppMethodBeat.o(90662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm
 * JD-Core Version:    0.7.0.1
 */