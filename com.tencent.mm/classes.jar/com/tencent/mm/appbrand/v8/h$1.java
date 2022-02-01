package com.tencent.mm.appbrand.v8;

import android.content.Context;
import com.eclipsesource.mmv8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject);
    if (!localq.ifE())
    {
      Log.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
      localq.ifL();
    }
    Log.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", new Object[] { localObject, Boolean.valueOf(localq.ifE()) });
    localObject = new File(com.tencent.mm.b.q.n(localq.bOF(), true));
    AppMethodBeat.o(144017);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h.1
 * JD-Core Version:    0.7.0.1
 */