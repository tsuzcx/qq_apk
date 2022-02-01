package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;)V", "getPkgInfo", "()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "getSource", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y$e
{
  public final IPkgInfo sZZ;
  final y.f taa;
  
  public y$e(IPkgInfo paramIPkgInfo, y.f paramf)
  {
    AppMethodBeat.i(180572);
    this.sZZ = paramIPkgInfo;
    this.taa = paramf;
    AppMethodBeat.o(180572);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(180575);
    if (this == paramObject)
    {
      AppMethodBeat.o(180575);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(180575);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.sZZ, paramObject.sZZ))
    {
      AppMethodBeat.o(180575);
      return false;
    }
    if (!s.p(this.taa, paramObject.taa))
    {
      AppMethodBeat.o(180575);
      return false;
    }
    AppMethodBeat.o(180575);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(180574);
    int i = this.sZZ.hashCode();
    int j = this.taa.hashCode();
    AppMethodBeat.o(180574);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180573);
    String str = "Response(pkgInfo=" + this.sZZ + ", source=" + this.taa + ')';
    AppMethodBeat.o(180573);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.e
 * JD-Core Version:    0.7.0.1
 */