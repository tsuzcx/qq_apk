package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad
{
  private static String[] kLP = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String cBp;
  private volatile String kLO;
  
  public ad(String paramString)
  {
    this.appId = paramString;
    this.cBp = null;
  }
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.cBp = Ve(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.cBp = Ve(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.cBp = "";
      continue;
      this.cBp = (Ve(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.cBp = (Ve(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.cBp = "__PLUGINCODE__";
      continue;
      this.cBp = "__WITHOUT_PLUGINCODE__";
      continue;
      this.cBp = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String Ve(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((Util.isNullOrNil(paramString)) || (a.contains(kLP, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = n.We(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (Util.isNullOrNil(this.kLO))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!Util.isNullOrNil(this.cBp)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.cBp)
    {
      this.kLO = str;
      str = this.kLO;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */