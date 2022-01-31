package com.tencent.mm.plugin.appbrand.j.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.appbrand.u.b;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;

public final class i
  implements q.a
{
  private String version = "";
  
  public i(Context paramContext)
  {
    paramContext = b.getPackageInfo(paramContext, ae.getPackageName());
    if (paramContext != null)
    {
      this.version += e.ag(null, com.tencent.mm.protocal.d.spa);
      this.version = (this.version + "." + paramContext.versionCode);
      this.version = (this.version + "(" + com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION + ")");
    }
  }
  
  public final String pJ()
  {
    return " MicroMessenger/";
  }
  
  public final String pK()
  {
    return this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.i
 * JD-Core Version:    0.7.0.1
 */