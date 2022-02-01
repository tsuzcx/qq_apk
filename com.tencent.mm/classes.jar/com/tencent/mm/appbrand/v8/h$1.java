package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;

final class h$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(144017);
    Object localObject = ak.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    e.f(new String[] { localObject });
    k localk = new k((String)localObject);
    if (!localk.exists())
    {
      ae.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      localk.mkdirs();
    }
    ae.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(localk.exists()) });
    localObject = new File(q.k(w.B(localk.fTh()), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */