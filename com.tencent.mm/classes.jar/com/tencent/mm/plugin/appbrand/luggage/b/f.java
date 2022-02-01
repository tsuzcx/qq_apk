package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.ui.ao;

public final class f
  implements p.a
{
  private Context mContext;
  private String version = "";
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static String acq(String paramString)
  {
    AppMethodBeat.i(224209);
    if (!ao.gJH())
    {
      AppMethodBeat.o(224209);
      return paramString;
    }
    String str = Util.nullAsNil(paramString);
    paramString = str;
    if (!str.contains("Android Tablet")) {
      paramString = str + " Android Tablet";
    }
    AppMethodBeat.o(224209);
    return paramString;
  }
  
  public final String Nv()
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
      localObject = b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
      if (localObject != null)
      {
        this.version += ChannelUtil.formatVersion(null, d.KyO);
        this.version = (this.version + "." + ((PackageInfo)localObject).versionCode);
        this.version = (this.version + "(" + String.format("0x%08X", new Object[] { Integer.valueOf(d.KyO) }) + ")");
        StringBuilder localStringBuilder = new StringBuilder().append(this.version).append(" Process/");
        localObject = MMApplicationContext.getPackageName().trim().toLowerCase();
        str2 = MMApplicationContext.getProcessName().trim().toLowerCase();
        if (!str2.equals(localObject)) {
          break label358;
        }
        localObject = "mm";
        this.version = ((String)localObject);
        localStringBuilder = new StringBuilder().append(this.version).append(" WeChat/");
        if (!q.is64BitRuntime()) {
          break label386;
        }
        localObject = "arm64";
        this.version = ((String)localObject);
        this.version = (this.version + " " + WeChatBrands.AppInfo.current().getUserAgent());
        if (ChannelUtil.isGPVersion()) {
          this.version += " GPVersion/1";
        }
      }
      this.version = acq(this.version);
      localObject = this.version;
      AppMethodBeat.o(103126);
      return localObject;
    }
    catch (Exception localException)
    {
      label386:
      for (;;)
      {
        String str2;
        String str1 = null;
        continue;
        label358:
        if (str2.startsWith(str1))
        {
          str1 = str2.substring(str1.length() + 1);
        }
        else
        {
          str1 = "unknown";
          continue;
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