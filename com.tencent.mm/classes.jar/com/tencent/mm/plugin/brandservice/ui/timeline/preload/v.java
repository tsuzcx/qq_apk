package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "plugin-brandservice_release"})
public final class v
  extends k
{
  public v(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(208933);
    AppMethodBeat.o(208933);
  }
  
  public final k Yu(String paramString)
  {
    AppMethodBeat.i(208931);
    p.h(paramString, "id");
    paramString = new k(getPath() + '/' + paramString);
    AppMethodBeat.o(208931);
    return paramString;
  }
  
  public final boolean aCo()
  {
    AppMethodBeat.i(208932);
    boolean bool = o.dd(getPath(), true);
    AppMethodBeat.o(208932);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(208930);
    p.h(paramString, "id");
    boolean bool = o.fB(getPath() + '/' + paramString);
    AppMethodBeat.o(208930);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */