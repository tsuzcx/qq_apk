package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class bk
{
  public static void clear(String paramString)
  {
    AppMethodBeat.i(90662);
    String str2 = g.afB().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    paramString = new com.tencent.mm.vfs.e(str1 + "appbrand/loadingurl/" + paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      i.cO(q.B(paramString.mUri), true);
    }
    str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith("/")) {
      paramString = str1 + "/";
    }
    paramString = new com.tencent.mm.vfs.e(paramString + "tencent/MicroMsg/appbrand/loadingurl");
    if ((paramString.exists()) && (paramString.isDirectory())) {
      i.cO(q.B(paramString.mUri), true);
    }
    AppMethodBeat.o(90662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bk
 * JD-Core Version:    0.7.0.1
 */