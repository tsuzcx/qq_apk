package com.tencent.mm.plugin.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;

final class b$10
  implements Runnable
{
  b$10(b paramb, com.tencent.mm.vfs.b[] paramArrayOfb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18590);
    if ((this.kkA == null) || (this.kkA.length == 0))
    {
      ab.e("MicroMsg.CalcWxService", "apkList is null or 0");
      AppMethodBeat.o(18590);
      return;
    }
    com.tencent.mm.vfs.b[] arrayOfb = this.kkA;
    int m = arrayOfb.length;
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    if (j < m)
    {
      com.tencent.mm.vfs.b localb = arrayOfb[j];
      Object localObject1;
      Object localObject2;
      int i;
      if (localb.getName().endsWith(".temp")) {
        if (bo.hl(localb.lastModified()) > 86400000L)
        {
          localb.delete();
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
          localObject2 = localb;
          localObject1 = localObject4;
        }
        else if (localb.lastModified() > localObject3.lastModified())
        {
          localObject3.delete();
          i = k;
          localObject2 = localb;
          localObject1 = localObject4;
        }
        else
        {
          localb.delete();
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          continue;
          i = k;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localb.getName().endsWith(".apk"))
          {
            localObject1 = ah.getContext().getPackageManager().getPackageArchiveInfo(j.p(localb.dQJ()), 128);
            if (localObject1 != null)
            {
              if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals("com.tencent.mm")))
              {
                localb.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
              localObject1 = ((PackageInfo)localObject1).applicationInfo;
              if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
              {
                i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                ab.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.whH) });
                if (i <= d.whH)
                {
                  localb.delete();
                  i = k;
                  localObject2 = localObject3;
                  localObject1 = localObject4;
                  continue;
                }
                if (localObject4 == null)
                {
                  localObject2 = localObject3;
                  localObject1 = localb;
                  continue;
                }
                if (i > k)
                {
                  localObject4.delete();
                  localObject2 = localObject3;
                  localObject1 = localb;
                  continue;
                }
                localb.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
              }
            }
            if (k != 0)
            {
              localb.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
            else if (localObject4 == null)
            {
              i = k;
              localObject2 = localObject3;
              localObject1 = localb;
            }
            else if (localb.lastModified() > localObject4.lastModified())
            {
              localObject4.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localb;
            }
            else
            {
              localb.delete();
              i = k;
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
          }
        }
      }
    }
    AppMethodBeat.o(18590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.10
 * JD-Core Version:    0.7.0.1
 */