package com.tencent.mm.plugin.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

final class b$10
  implements Runnable
{
  b$10(b paramb, k[] paramArrayOfk) {}
  
  public final void run()
  {
    AppMethodBeat.i(22699);
    if ((this.oCz == null) || (this.oCz.length == 0))
    {
      ae.e("MicroMsg.CalcWxService", "apkList is null or 0");
      AppMethodBeat.o(22699);
      return;
    }
    k[] arrayOfk = this.oCz;
    int m = arrayOfk.length;
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    if (j < m)
    {
      k localk = arrayOfk[j];
      Object localObject1;
      Object localObject2;
      int i;
      if (localk.getName().endsWith(".temp")) {
        if (bu.DD(localk.lastModified()) > 86400000L)
        {
          localk.delete();
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
          localObject2 = localk;
          localObject1 = localObject4;
        }
        else if (localk.lastModified() > localObject3.lastModified())
        {
          localObject3.delete();
          i = k;
          localObject2 = localk;
          localObject1 = localObject4;
        }
        else
        {
          localk.delete();
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          continue;
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localk.getName().endsWith(".apk"))
          {
            localObject1 = ak.getContext().getPackageManager().getPackageArchiveInfo(w.B(localk.fTh()), 128);
            if (localObject1 != null)
            {
              if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals("com.tencent.mm")))
              {
                localk.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
              localObject1 = ((PackageInfo)localObject1).applicationInfo;
              if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
              {
                i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                ae.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.FFH) });
                if (i <= d.FFH)
                {
                  localk.delete();
                  i = k;
                  localObject2 = localObject3;
                  localObject1 = localObject4;
                  continue;
                }
                if (localObject4 == null)
                {
                  localObject2 = localObject3;
                  localObject1 = localk;
                  continue;
                }
                if (i > k)
                {
                  localObject4.delete();
                  localObject2 = localObject3;
                  localObject1 = localk;
                  continue;
                }
                localk.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
            }
            if (k != 0)
            {
              localk.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
            else if (localObject4 == null)
            {
              i = k;
              localObject2 = localObject3;
              localObject1 = localk;
            }
            else if (localk.lastModified() > localObject4.lastModified())
            {
              localObject4.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localk;
            }
            else
            {
              localk.delete();
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