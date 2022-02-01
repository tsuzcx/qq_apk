package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.bu;

public final class ad
{
  private static String[] jJS = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String coY;
  private volatile String jJR;
  
  public ad(String paramString)
  {
    this.appId = paramString;
    this.coY = null;
  }
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.coY = LV(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.coY = LV(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.coY = "";
      continue;
      this.coY = (LV(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.coY = (LV(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.coY = "__PLUGINCODE__";
      continue;
      this.coY = "__WITHOUT_PLUGINCODE__";
      continue;
      this.coY = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String LV(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((bu.isNullOrNil(paramString)) || (a.contains(jJS, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = n.MV(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (bu.isNullOrNil(this.jJR))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bu.isNullOrNil(this.coY)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.coY)
    {
      this.jJR = str;
      str = this.jJR;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */