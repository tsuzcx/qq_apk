package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.bt;

public final class ab
{
  private static String[] iMN = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String chK;
  private volatile String iMM;
  
  public ab(String paramString)
  {
    this.appId = paramString;
    this.chK = null;
  }
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.chK = DX(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.chK = DX(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.chK = "";
      continue;
      this.chK = (DX(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.chK = (DX(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.chK = "__PLUGINCODE__";
      continue;
      this.chK = "__WITHOUT_PLUGINCODE__";
      continue;
      this.chK = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String DX(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((bt.isNullOrNil(paramString)) || (a.contains(iMN, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = m.EV(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (bt.isNullOrNil(this.iMM))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bt.isNullOrNil(this.chK)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.chK)
    {
      this.iMM = str;
      str = this.iMM;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */