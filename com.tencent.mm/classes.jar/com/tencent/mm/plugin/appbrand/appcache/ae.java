package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.Util;

public final class ae
{
  private static final String[] nFI = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String cAy;
  private volatile String nFH;
  
  public ae(String paramString)
  {
    this.appId = paramString;
    this.cAy = null;
  }
  
  public ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.cAy = acO(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public ae(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.cAy = acO(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.cAy = "";
      continue;
      this.cAy = (acO(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.cAy = (acO(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.cAy = "__PLUGINCODE__";
      continue;
      this.cAy = "__WITHOUT_PLUGINCODE__";
      continue;
      this.cAy = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String acO(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((Util.isNullOrNil(paramString)) || (a.contains(nFI, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = o.adS(paramString);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final boolean bGV()
  {
    AppMethodBeat.i(232510);
    boolean bool = toString().endsWith("$__PLUGINCODE__");
    AppMethodBeat.o(232510);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (Util.isNullOrNil(this.nFH))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!Util.isNullOrNil(this.cAy)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.cAy)
    {
      this.nFH = str;
      str = this.nFH;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */