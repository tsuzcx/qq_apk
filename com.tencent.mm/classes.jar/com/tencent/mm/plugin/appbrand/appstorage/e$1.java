package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;

final class e$1
  implements Runnable
{
  private void y(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(129521);
    if ((!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      AppMethodBeat.o(129521);
      return;
    }
    if (com.tencent.mm.vfs.e.cN(paramFile.getAbsolutePath() + "/dir.lock"))
    {
      if (bo.aoy() - new b(paramFile.getAbsolutePath() + "/dir.lock").lastModified() < e.awG())
      {
        ab.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", new Object[] { paramFile.getName() });
        AppMethodBeat.o(129521);
        return;
      }
      ab.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", new Object[] { paramFile.getName() });
    }
    ab.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", new Object[] { paramFile.getName() });
    paramFile = paramFile.listFiles(new e.1.1(this));
    if ((paramFile == null) || (paramFile.length <= 0))
    {
      AppMethodBeat.o(129521);
      return;
    }
    long l = bo.aoy();
    int j = paramFile.length;
    while (i < j)
    {
      Object localObject = paramFile[i];
      if (l - localObject.lastModified() >= e.access$100()) {
        com.tencent.mm.a.e.deleteFile(localObject.getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(129521);
  }
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(129520);
    Object localObject = new File(an.aCY());
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      AppMethodBeat.o(129520);
      return;
    }
    localObject = ((File)localObject).listFiles();
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(129520);
      return;
    }
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      y(localObject[i]);
      i += 1;
    }
    localObject = new File(AppBrandVideoDownLoadMgr.ice);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      AppMethodBeat.o(129520);
      return;
    }
    localObject = ((File)localObject).listFiles();
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(129520);
      return;
    }
    k = localObject.length;
    i = j;
    while (i < k)
    {
      y(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(129520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.1
 * JD-Core Version:    0.7.0.1
 */