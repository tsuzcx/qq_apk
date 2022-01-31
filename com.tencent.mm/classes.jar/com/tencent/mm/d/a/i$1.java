package com.tencent.mm.d.a;

import android.content.Context;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

final class i$1
  implements MultiContextNodeJS.IGetTmpFileDirectory
{
  public final File getDirectory()
  {
    AppMethodBeat.i(113812);
    Object localObject = ah.getContext();
    localObject = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
    j.akQ((String)localObject);
    ab.i("MicroMsg.NodeJSRuntime", "tmpDir:%s", new Object[] { localObject });
    localObject = new File((String)localObject);
    AppMethodBeat.o(113812);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.i.1
 * JD-Core Version:    0.7.0.1
 */