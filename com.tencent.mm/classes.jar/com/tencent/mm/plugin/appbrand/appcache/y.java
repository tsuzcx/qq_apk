package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class y
{
  private static String[] gVj = { "__APP__", "__WITHOUT_CODELIB__", "__CODELIB__" };
  private String appId;
  private String gVh;
  private volatile String gVi;
  
  public y(String paramString)
  {
    this.appId = paramString;
    this.gVh = null;
  }
  
  public y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101719);
    this.appId = paramString1;
    this.gVh = ys(paramString2);
    AppMethodBeat.o(101719);
  }
  
  public y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(101721);
    if (paramInt == 13) {}
    for (paramString2 = ys(paramString2) + '$' + "__WITHOUT_CODELIB__";; paramString2 = ys(paramString2))
    {
      this.gVh = paramString2;
      this.appId = paramString1;
      AppMethodBeat.o(101721);
      return;
    }
  }
  
  private static String ys(String paramString)
  {
    AppMethodBeat.i(101720);
    if ((bo.isNullOrNil(paramString)) || (a.contains(gVj, paramString)))
    {
      AppMethodBeat.o(101720);
      return paramString;
    }
    paramString = k.zl(paramString);
    AppMethodBeat.o(101720);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101722);
    StringBuilder localStringBuilder;
    if (bo.isNullOrNil(this.gVi))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bo.isNullOrNil(this.gVh)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.gVh)
    {
      this.gVi = str;
      str = this.gVi;
      AppMethodBeat.o(101722);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y
 * JD-Core Version:    0.7.0.1
 */