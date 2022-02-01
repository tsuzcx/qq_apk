package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "bizScene", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;I)V", "getBizScene", "()I", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
final class v$c
{
  private final int hDa;
  final v.e pDL;
  final String url;
  
  public v$c(String paramString, v.e parame, int paramInt)
  {
    AppMethodBeat.i(195652);
    this.url = paramString;
    this.pDL = parame;
    this.hDa = paramInt;
    AppMethodBeat.o(195652);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195655);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.j(this.url, paramObject.url)) || (!p.j(this.pDL, paramObject.pDL)) || (this.hDa != paramObject.hDa)) {}
      }
    }
    else
    {
      AppMethodBeat.o(195655);
      return true;
    }
    AppMethodBeat.o(195655);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(195654);
    Object localObject = this.url;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.pDL;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      int k = this.hDa;
      AppMethodBeat.o(195654);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195653);
    String str = "PrefetchRes(url=" + this.url + ", type=" + this.pDL + ", bizScene=" + this.hDa + ")";
    AppMethodBeat.o(195653);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.c
 * JD-Core Version:    0.7.0.1
 */