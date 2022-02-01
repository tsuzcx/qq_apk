package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.File;

final class h$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(144017);
    Object localObject = ai.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    com.tencent.mm.b.e.f(new String[] { localObject });
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
    if (!locale.exists())
    {
      ac.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      locale.mkdirs();
    }
    ac.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(locale.exists()) });
    localObject = new File(com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(locale.fxV()), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */