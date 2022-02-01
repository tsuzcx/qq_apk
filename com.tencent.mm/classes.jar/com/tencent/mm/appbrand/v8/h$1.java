package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.mmv8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.File;

final class h$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(144017);
    Object localObject = MMApplicationContext.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    e.d(new String[] { localObject });
    u localu = new u((String)localObject);
    if (!localu.jKS())
    {
      Log.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      localu.jKY();
    }
    Log.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(localu.jKS()) });
    localObject = new File(q.n(ah.v(localu.jKT()), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */