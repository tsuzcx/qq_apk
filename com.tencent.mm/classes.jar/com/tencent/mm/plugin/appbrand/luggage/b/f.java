package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.k;

public final class f
  implements p.a
{
  private Context mContext;
  private String version = "";
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final String DZ()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(103126);
    Object localObject;
    if (!TextUtils.isEmpty(this.version))
    {
      localObject = this.version;
      AppMethodBeat.o(103126);
      return localObject;
    }
    try
    {
      localObject = b.getPackageInfo(this.mContext, ak.getPackageName());
      if (localObject != null)
      {
        this.version += k.aD(null, d.FFH);
        this.version = (this.version + "." + ((PackageInfo)localObject).versionCode);
        this.version = (this.version + "(" + String.format("0x%08X", new Object[] { Integer.valueOf(d.FFH) }) + ")");
        StringBuilder localStringBuilder = new StringBuilder().append(this.version).append(" Process/");
        localObject = ak.getPackageName().trim().toLowerCase();
        str2 = ak.getProcessName().trim().toLowerCase();
        if (!str2.equals(localObject)) {
          break label312;
        }
        localObject = "mm";
        this.version = ((String)localObject);
        localStringBuilder = new StringBuilder().append(this.version).append(" WeChat/");
        if (!q.is64BitRuntime()) {
          break label340;
        }
        localObject = "arm64";
        this.version = ((String)localObject);
        if (k.fnT()) {
          this.version += " GPVersion/1";
        }
      }
      localObject = this.version;
      AppMethodBeat.o(103126);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        String str1 = null;
        continue;
        label312:
        if (str2.startsWith(str1))
        {
          str1 = str2.substring(str1.length() + 1);
        }
        else
        {
          str1 = "unknown";
          continue;
          label340:
          str1 = "arm32";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */