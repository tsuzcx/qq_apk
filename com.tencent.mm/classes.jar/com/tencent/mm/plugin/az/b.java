package com.tencent.mm.plugin.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends u
{
  public b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(260975);
    AppMethodBeat.o(260975);
  }
  
  public final u bii(String paramString)
  {
    AppMethodBeat.i(260985);
    s.u(paramString, "id");
    paramString = new u(ah.v(this.mUri) + '/' + paramString);
    AppMethodBeat.o(260985);
    return paramString;
  }
  
  public final boolean clearAll()
  {
    AppMethodBeat.i(260990);
    boolean bool = y.ew(ah.v(this.mUri), true);
    AppMethodBeat.o(260990);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(260979);
    s.u(paramString, "id");
    boolean bool = y.ZC(ah.v(this.mUri) + '/' + paramString);
    AppMethodBeat.o(260979);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.az.b
 * JD-Core Version:    0.7.0.1
 */