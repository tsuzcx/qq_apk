package com.tencent.mm.plugin.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

final class b$10
  implements Runnable
{
  b$10(b paramb, e[] paramArrayOfe) {}
  
  public final void run()
  {
    AppMethodBeat.i(22699);
    if ((this.nSD == null) || (this.nSD.length == 0))
    {
      ac.e("MicroMsg.CalcWxService", "apkList is null or 0");
      AppMethodBeat.o(22699);
      return;
    }
    e[] arrayOfe = this.nSD;
    int m = arrayOfe.length;
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    if (j < m)
    {
      e locale = arrayOfe[j];
      Object localObject1;
      Object localObject2;
      int i;
      if (locale.getName().endsWith(".temp")) {
        if (bs.Ap(locale.lastModified()) > 86400000L)
        {
          locale.delete();
          localObject1 = localObject4;
          localObject2 = localObject3;
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        localObject3 = localObject2;
        localObject4 = localObject1;
        break;
        if (localObject3 == null)
        {
          i = k;
          localObject2 = locale;
          localObject1 = localObject4;
        }
        else if (locale.lastModified() > localObject3.lastModified())
        {
          localObject3.delete();
          i = k;
          localObject2 = locale;
          localObject1 = localObject4;
        }
        else
        {
          locale.delete();
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          continue;
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (locale.getName().endsWith(".apk"))
          {
            localObject1 = ai.getContext().getPackageManager().getPackageArchiveInfo(q.B(locale.fxV()), 128);
            if (localObject1 != null)
            {
              if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals("com.tencent.mm")))
              {
                locale.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
              localObject1 = ((PackageInfo)localObject1).applicationInfo;
              if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
              {
                i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                ac.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.DIc) });
                if (i <= d.DIc)
                {
                  locale.delete();
                  i = k;
                  localObject2 = localObject3;
                  localObject1 = localObject4;
                  continue;
                }
                if (localObject4 == null)
                {
                  localObject2 = localObject3;
                  localObject1 = locale;
                  continue;
                }
                if (i > k)
                {
                  localObject4.delete();
                  localObject2 = localObject3;
                  localObject1 = locale;
                  continue;
                }
                locale.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
            }
            if (k != 0)
            {
              locale.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
            else if (localObject4 == null)
            {
              i = k;
              localObject2 = localObject3;
              localObject1 = locale;
            }
            else if (locale.lastModified() > localObject4.lastModified())
            {
              localObject4.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = locale;
            }
            else
            {
              locale.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
          }
        }
      }
    }
    AppMethodBeat.o(22699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.10
 * JD-Core Version:    0.7.0.1
 */