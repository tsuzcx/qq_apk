package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;

public final class h
  implements q.a
{
  private String version;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(80436);
    this.version = "";
    paramContext = b.getPackageInfo(paramContext, ah.getPackageName());
    StringBuilder localStringBuilder;
    String str;
    if (paramContext != null)
    {
      this.version += g.au(null, d.whH);
      this.version = (this.version + "." + paramContext.versionCode);
      this.version = (this.version + "(" + f.CLIENT_VERSION + ")");
      localStringBuilder = new StringBuilder().append(this.version).append(" Process/");
      paramContext = ah.getPackageName().trim().toLowerCase();
      str = ah.getProcessName().trim().toLowerCase();
      if (!str.equals(paramContext)) {
        break label197;
      }
      paramContext = "mm";
    }
    for (;;)
    {
      this.version = paramContext;
      AppMethodBeat.o(80436);
      return;
      label197:
      if (str.startsWith(paramContext)) {
        paramContext = str.substring(paramContext.length() + 1);
      } else {
        paramContext = "unknown";
      }
    }
  }
  
  public final String vV()
  {
    return " MicroMessenger/";
  }
  
  public final String version()
  {
    return this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */