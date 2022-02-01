package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace;", "", "()V", "MODULE", "PLUGIN", "luggage-wxa-app_release"})
abstract class WxaRuntimeModulePluginListMap$c
{
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "", "provider", "", "(Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "luggage-wxa-app_release"})
  public static final class b
  {
    private final String provider;
    
    public b(String paramString)
    {
      AppMethodBeat.i(178651);
      this.provider = paramString;
      AppMethodBeat.o(178651);
    }
    
    public final boolean equals(Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(178650);
      if (!(paramObject instanceof b)) {
        paramObject = null;
      }
      for (;;)
      {
        b localb = (b)paramObject;
        paramObject = localObject;
        if (localb != null) {
          paramObject = localb.provider;
        }
        boolean bool = k.g(paramObject, this.provider);
        AppMethodBeat.o(178650);
        return bool;
      }
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(178649);
      int i = this.provider.hashCode();
      AppMethodBeat.o(178649);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(178652);
      String str = "PLUGIN(provider=" + this.provider + ")";
      AppMethodBeat.o(178652);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap.c
 * JD-Core Version:    0.7.0.1
 */