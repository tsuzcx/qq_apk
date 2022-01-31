package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.al;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;

final class c$1
  implements Runnable
{
  private void s(File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return;
      paramFile = paramFile.listFiles(new c.1.1(this));
      if ((paramFile != null) && (paramFile.length > 0))
      {
        long l = bk.UY();
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if (l - localObject.lastModified() >= c.rg()) {
            e.deleteFile(localObject.getAbsolutePath());
          }
          i += 1;
        }
      }
    }
  }
  
  public final void run()
  {
    int j = 0;
    Object localObject = new File(al.aiR());
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          s(localObject[i]);
          i += 1;
        }
        localObject = new File(AppBrandVideoDownLoadMgr.gDc);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          if ((localObject != null) && (localObject.length > 0))
          {
            k = localObject.length;
            i = j;
            while (i < k)
            {
              s(localObject[i]);
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c.1
 * JD-Core Version:    0.7.0.1
 */