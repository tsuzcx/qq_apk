package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.File;

final class h$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(144017);
    Object localObject = aj.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    com.tencent.mm.b.e.f(new String[] { localObject });
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
    if (!locale.exists())
    {
      ad.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      locale.mkdirs();
    }
    ad.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(locale.exists()) });
    localObject = new File(com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(locale.fOK()), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */