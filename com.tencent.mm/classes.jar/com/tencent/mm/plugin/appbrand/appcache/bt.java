package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class bt
{
  public static void clear(String paramString)
  {
    AppMethodBeat.i(90662);
    String str2 = h.aHG().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    paramString = new q(str1 + "appbrand/loadingurl/" + paramString);
    if ((paramString.ifE()) && (paramString.isDirectory())) {
      u.deleteDir(paramString.getPath());
    }
    str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith("/")) {
      paramString = str1 + "/";
    }
    paramString = new q(paramString + "tencent/MicroMsg/appbrand/loadingurl");
    if ((paramString.ifE()) && (paramString.isDirectory())) {
      u.deleteDir(paramString.getPath());
    }
    AppMethodBeat.o(90662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bt
 * JD-Core Version:    0.7.0.1
 */