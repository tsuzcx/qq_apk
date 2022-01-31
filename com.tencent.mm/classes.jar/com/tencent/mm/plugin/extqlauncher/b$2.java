package com.tencent.mm.plugin.extqlauncher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20474);
    for (;;)
    {
      int i;
      try
      {
        this.mgf.mfZ = System.currentTimeMillis();
        List localList = ah.getContext().getPackageManager().getInstalledApplications(128);
        if (localList == null)
        {
          ab.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
          this.mgf.mfY = false;
          AppMethodBeat.o(20474);
          return;
        }
        i = 0;
        if (i < localList.size())
        {
          ApplicationInfo localApplicationInfo = (ApplicationInfo)localList.get(i);
          if ((localApplicationInfo == null) || ((!bo.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.qlauncher")) && (!bo.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.qqlauncher")) && (!bo.nullAsNil(localApplicationInfo.packageName).startsWith("com.tencent.launcher"))) || (localApplicationInfo.metaData == null)) {
            break label382;
          }
          Object localObject = localApplicationInfo.metaData.getString("qlauncher_wx_coop");
          if ((localObject == null) || (((String)localObject).length() <= 0))
          {
            ab.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[] { localApplicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.mgf.mfZ) });
            this.mgf.mfY = false;
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
                if (bo.nullAsNil(localObject[j]).trim().equalsIgnoreCase("fun1"))
                {
                  ab.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[] { localApplicationInfo.packageName });
                  this.mgf.mfY = true;
                  AppMethodBeat.o(20474);
                  return;
                }
                j += 1;
                continue;
              }
            }
            this.mgf.mfY = false;
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[] { localException.getMessage() });
        this.mgf.mfY = false;
        AppMethodBeat.o(20474);
        return;
      }
      ab.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mgf.mfZ) });
      AppMethodBeat.o(20474);
      return;
      label382:
      i += 1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20475);
    String str = super.toString() + "|isPluginInstall";
    AppMethodBeat.o(20475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.2
 * JD-Core Version:    0.7.0.1
 */