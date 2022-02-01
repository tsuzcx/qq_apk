package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "plugin-brandservice_release"})
public final class v
  extends e
{
  public v(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(209946);
    AppMethodBeat.o(209946);
  }
  
  public final e XH(String paramString)
  {
    AppMethodBeat.i(209944);
    p.h(paramString, "id");
    paramString = new e(getPath() + '/' + paramString);
    AppMethodBeat.o(209944);
    return paramString;
  }
  
  public final boolean aBY()
  {
    AppMethodBeat.i(209945);
    boolean bool = i.cZ(getPath(), true);
    AppMethodBeat.o(209945);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(209943);
    p.h(paramString, "id");
    boolean bool = i.fv(getPath() + '/' + paramString);
    AppMethodBeat.o(209943);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */