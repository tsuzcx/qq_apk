package com.tencent.mm.plugin.extqlauncher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(24550);
    for (;;)
    {
      int i;
      try
      {
        this.pMR.pML = System.currentTimeMillis();
        List localList = aj.getContext().getPackageManager().getInstalledApplications(128);
        if (localList == null)
        {
          ad.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
          this.pMR.pMK = false;
          AppMethodBeat.o(24550);
          return;
        }
        i = 0;
        if (i < localList.size())
        {
          ApplicationInfo localApplicationInfo = (ApplicationInfo)localList.get(i);
          if ((localApplicationInfo == null) || ((!bt.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.qlauncher")) && (!bt.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.qqlauncher")) && (!bt.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.launcher"))) || (localApplicationInfo.metaData == null)) {
            break label382;
          }
          Object localObject = localApplicationInfo.metaData.getString("qlauncher_wx_coop");
          if ((localObject == null) || (((String)localObject).length() <= 0))
          {
            ad.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[] { localApplicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.pMR.pML) });
            this.pMR.pMK = false;
          }
          else
          {
            localObject = ((String)localObject).split(",");
            if (localObject != null)
            {
              int k = localObject.length;
              int j = 0;
              if (j < k)
              {
                if (bt.nullAsNil(localObject[j]).trim().equalsIgnoreCase("fun1"))
                {
                  ad.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[] { localApplicationInfo.packageName });
                  this.pMR.pMK = true;
                  AppMethodBeat.o(24550);
                  return;
                }
                j += 1;
                continue;
              }
            }
            this.pMR.pMK = false;
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[] { localException.getMessage() });
        this.pMR.pMK = false;
        AppMethodBeat.o(24550);
        return;
      }
      ad.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.pMR.pML) });
      AppMethodBeat.o(24550);
      return;
      label382:
      i += 1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24551);
    String str = super.toString() + "|isPluginInstall";
    AppMethodBeat.o(24551);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.2
 * JD-Core Version:    0.7.0.1
 */