package com.tencent.mm.plugin.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

final class a$10
  implements Runnable
{
  a$10(a parama, q[] paramArrayOfq) {}
  
  public final void run()
  {
    AppMethodBeat.i(22699);
    if ((this.sXj == null) || (this.sXj.length == 0))
    {
      Log.e("MicroMsg.CalcWxService", "apkList is null or 0");
      AppMethodBeat.o(22699);
      return;
    }
    q[] arrayOfq = this.sXj;
    int m = arrayOfq.length;
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    if (j < m)
    {
      q localq = arrayOfq[j];
      Object localObject1;
      Object localObject2;
      int i;
      if (localq.getName().endsWith(".temp")) {
        if (Util.milliSecondsToNow(localq.lastModified()) > 86400000L)
        {
          localq.cFq();
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
          localObject2 = localq;
          localObject1 = localObject4;
        }
        else if (localq.lastModified() > localObject3.lastModified())
        {
          localObject3.cFq();
          i = k;
          localObject2 = localq;
          localObject1 = localObject4;
        }
        else
        {
          localq.cFq();
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          continue;
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localq.getName().endsWith(".apk"))
          {
            localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(localq.bOF(), 128);
            if (localObject1 != null)
            {
              if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals(MMApplicationContext.getApplicationId())))
              {
                localq.cFq();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
              localObject1 = ((PackageInfo)localObject1).applicationInfo;
              if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
              {
                i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                Log.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.RAD) });
                if (i <= d.RAD)
                {
                  localq.cFq();
                  i = k;
                  localObject2 = localObject3;
                  localObject1 = localObject4;
                  continue;
                }
                if (localObject4 == null)
                {
                  localObject2 = localObject3;
                  localObject1 = localq;
                  continue;
                }
                if (i > k)
                {
                  localObject4.cFq();
                  localObject2 = localObject3;
                  localObject1 = localq;
                  continue;
                }
                localq.cFq();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
            }
            if (k != 0)
            {
              localq.cFq();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
            else if (localObject4 == null)
            {
              i = k;
              localObject2 = localObject3;
              localObject1 = localq;
            }
            else if (localq.lastModified() > localObject4.lastModified())
            {
              localObject4.cFq();
              i = k;
              localObject2 = localObject3;
              localObject1 = localq;
            }
            else
            {
              localq.cFq();
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
 * Qualified Name:     com.tencent.mm.plugin.h.a.10
 * JD-Core Version:    0.7.0.1
 */