package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.bs;

public final class ab
{
  private static String[] jmU = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String ceF;
  private volatile String jmT;
  
  public ab(String paramString)
  {
    this.appId = paramString;
    this.ceF = null;
  }
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.ceF = Ia(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.ceF = Ia(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.ceF = "";
      continue;
      this.ceF = (Ia(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.ceF = (Ia(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.ceF = "__PLUGINCODE__";
      continue;
      this.ceF = "__WITHOUT_PLUGINCODE__";
      continue;
      this.ceF = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String Ia(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((bs.isNullOrNil(paramString)) || (a.contains(jmU, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = m.IY(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (bs.isNullOrNil(this.jmT))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bs.isNullOrNil(this.ceF)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.ceF)
    {
      this.jmT = str;
      str = this.jmT;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */