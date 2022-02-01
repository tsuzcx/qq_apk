package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.bt;

public final class ac
{
  private static String[] jGS = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String coW;
  private volatile String jGR;
  
  public ac(String paramString)
  {
    this.appId = paramString;
    this.coW = null;
  }
  
  public ac(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.coW = Ls(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ac(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.coW = Ls(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.coW = "";
      continue;
      this.coW = (Ls(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.coW = (Ls(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.coW = "__PLUGINCODE__";
      continue;
      this.coW = "__WITHOUT_PLUGINCODE__";
      continue;
      this.coW = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String Ls(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((bt.isNullOrNil(paramString)) || (a.contains(jGS, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = m.Mp(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (bt.isNullOrNil(this.jGR))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bt.isNullOrNil(this.coW)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.coW)
    {
      this.jGR = str;
      str = this.jGR;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */