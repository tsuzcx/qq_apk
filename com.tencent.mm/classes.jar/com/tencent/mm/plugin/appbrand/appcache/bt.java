package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;

public final class bt
{
  public static void clear(String paramString)
  {
    AppMethodBeat.i(90662);
    String str2 = h.baE().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    paramString = new u(str1 + "appbrand/loadingurl/" + paramString);
    if ((paramString.jKS()) && (paramString.isDirectory())) {
      y.ew(ah.v(paramString.mUri), true);
    }
    str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith("/")) {
      paramString = str1 + "/";
    }
    paramString = new u(paramString + "tencent/MicroMsg/appbrand/loadingurl");
    if ((paramString.jKS()) && (paramString.isDirectory())) {
      y.ew(ah.v(paramString.mUri), true);
    }
    AppMethodBeat.o(90662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bt
 * JD-Core Version:    0.7.0.1
 */