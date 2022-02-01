package com.tencent.mm.plugin.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "webview-sdk_release"})
public final class b
  extends o
{
  public b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(224912);
    AppMethodBeat.o(224912);
  }
  
  public final o aWR(String paramString)
  {
    AppMethodBeat.i(224910);
    p.h(paramString, "id");
    paramString = new o(getPath() + '/' + paramString);
    AppMethodBeat.o(224910);
    return paramString;
  }
  
  public final boolean clearAll()
  {
    AppMethodBeat.i(224911);
    boolean bool = s.dy(getPath(), true);
    AppMethodBeat.o(224911);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(224909);
    p.h(paramString, "id");
    boolean bool = s.YS(getPath() + '/' + paramString);
    AppMethodBeat.o(224909);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.b
 * JD-Core Version:    0.7.0.1
 */