package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;

final class h$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(144017);
    Object localObject = MMApplicationContext.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    e.f(new String[] { localObject });
    o localo = new o((String)localObject);
    if (!localo.exists())
    {
      Log.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      localo.mkdirs();
    }
    Log.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(localo.exists()) });
    localObject = new File(q.k(aa.z(localo.her()), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */