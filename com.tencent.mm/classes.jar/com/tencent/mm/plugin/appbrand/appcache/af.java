package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.Util;

public final class af
{
  private static final String[] qFC = { "__APP__", "__WITHOUT_PLUGINCODE__", "__WITHOUT_MULTI_PLUGINCODE__", "__PLUGINCODE__" };
  private final String appId;
  private final String esT;
  private volatile String qFB;
  
  public af(String paramString)
  {
    this.appId = paramString;
    this.esT = null;
  }
  
  public af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146000);
    this.appId = paramString1;
    this.esT = Vm(paramString2);
    AppMethodBeat.o(146000);
  }
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146002);
    switch (paramInt)
    {
    default: 
      this.esT = Vm(paramString2);
    }
    for (;;)
    {
      this.appId = paramString1;
      AppMethodBeat.o(146002);
      return;
      this.esT = "";
      continue;
      this.esT = (Vm(paramString2) + '$' + "__WITHOUT_PLUGINCODE__");
      continue;
      this.esT = (Vm(paramString2) + '$' + "__WITHOUT_MULTI_PLUGINCODE__");
      continue;
      this.esT = "__PLUGINCODE__";
      continue;
      this.esT = "__WITHOUT_PLUGINCODE__";
      continue;
      this.esT = "__WITHOUT_MULTI_PLUGINCODE__";
    }
  }
  
  private static String Vm(String paramString)
  {
    AppMethodBeat.i(146001);
    if ((Util.isNullOrNil(paramString)) || (a.contains(qFC, paramString)))
    {
      AppMethodBeat.o(146001);
      return paramString;
    }
    paramString = t.as(paramString, true);
    AppMethodBeat.o(146001);
    return paramString;
  }
  
  public final boolean cgr()
  {
    AppMethodBeat.i(320257);
    boolean bool = toString().endsWith("$__PLUGINCODE__");
    AppMethodBeat.o(320257);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146003);
    StringBuilder localStringBuilder;
    if (Util.isNullOrNil(this.qFB))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!Util.isNullOrNil(this.esT)) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = "$" + this.esT)
    {
      this.qFB = str;
      str = this.qFB;
      AppMethodBeat.o(146003);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af
 * JD-Core Version:    0.7.0.1
 */