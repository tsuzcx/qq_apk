package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaRuntimeModulePluginListMap$c$a
{
  final String name;
  
  public WxaRuntimeModulePluginListMap$c$a(String paramString)
  {
    AppMethodBeat.i(178648);
    paramString = WxaPkgWrappingInfo.VC(paramString);
    s.checkNotNull(paramString);
    this.name = paramString;
    AppMethodBeat.o(178648);
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(178647);
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if (paramObject != null) {
        break label46;
      }
    }
    label46:
    for (paramObject = localObject;; paramObject = paramObject.name)
    {
      boolean bool = s.p(paramObject, this.name);
      AppMethodBeat.o(178647);
      return bool;
      paramObject = null;
      break;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(178646);
    int i = this.name.hashCode();
    AppMethodBeat.o(178646);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap.c.a
 * JD-Core Version:    0.7.0.1
 */