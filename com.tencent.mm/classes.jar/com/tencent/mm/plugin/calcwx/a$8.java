package com.tencent.mm.plugin.calcwx;

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
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

final class a$8
  implements Runnable
{
  a$8(a parama, u[] paramArrayOfu) {}
  
  public final void run()
  {
    AppMethodBeat.i(22699);
    if ((this.wbA == null) || (this.wbA.length == 0))
    {
      Log.e("MicroMsg.CalcWxService", "apkList is null or 0");
      AppMethodBeat.o(22699);
      return;
    }
    u[] arrayOfu = this.wbA;
    int m = arrayOfu.length;
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    if (j < m)
    {
      u localu = arrayOfu[j];
      Object localObject1;
      Object localObject2;
      int i;
      if (localu.getName().endsWith(".temp")) {
        if (Util.milliSecondsToNow(localu.lastModified()) > 86400000L)
        {
          localu.diJ();
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
          localObject2 = localu;
          localObject1 = localObject4;
        }
        else if (localu.lastModified() > localObject3.lastModified())
        {
          localObject3.diJ();
          i = k;
          localObject2 = localu;
          localObject1 = localObject4;
        }
        else
        {
          localu.diJ();
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          continue;
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localu.getName().endsWith(".apk"))
          {
            localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(ah.v(localu.jKT()), 128);
            if (localObject1 != null)
            {
              if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals(MMApplicationContext.getApplicationId())))
              {
                localu.diJ();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
              localObject1 = ((PackageInfo)localObject1).applicationInfo;
              if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
              {
                i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                Log.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.Yxh) });
                if (i <= d.Yxh)
                {
                  localu.diJ();
                  i = k;
                  localObject2 = localObject3;
                  localObject1 = localObject4;
                  continue;
                }
                if (localObject4 == null)
                {
                  localObject2 = localObject3;
                  localObject1 = localu;
                  continue;
                }
                if (i > k)
                {
                  localObject4.diJ();
                  localObject2 = localObject3;
                  localObject1 = localu;
                  continue;
                }
                localu.diJ();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
            }
            if (k != 0)
            {
              localu.diJ();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
            else if (localObject4 == null)
            {
              i = k;
              localObject2 = localObject3;
              localObject1 = localu;
            }
            else if (localu.lastModified() > localObject4.lastModified())
            {
              localObject4.diJ();
              i = k;
              localObject2 = localObject3;
              localObject1 = localu;
            }
            else
            {
              localu.diJ();
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
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.8
 * JD-Core Version:    0.7.0.1
 */