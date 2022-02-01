package com.tencent.mm.plugin.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "webview-sdk_release"})
public final class b
  extends q
{
  public b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(206380);
    AppMethodBeat.o(206380);
  }
  
  public final q biA(String paramString)
  {
    AppMethodBeat.i(206375);
    p.k(paramString, "id");
    paramString = new q(getPath() + '/' + paramString);
    AppMethodBeat.o(206375);
    return paramString;
  }
  
  public final boolean clearAll()
  {
    AppMethodBeat.i(206379);
    boolean bool = u.dK(getPath(), true);
    AppMethodBeat.o(206379);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(206372);
    p.k(paramString, "id");
    boolean bool = u.agG(getPath() + '/' + paramString);
    AppMethodBeat.o(206372);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.b
 * JD-Core Version:    0.7.0.1
 */