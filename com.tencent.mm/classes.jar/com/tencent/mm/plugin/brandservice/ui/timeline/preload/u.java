package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "plugin-brandservice_release"})
public final class u
  extends e
{
  public u(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(193196);
    AppMethodBeat.o(193196);
  }
  
  public final e PN(String paramString)
  {
    AppMethodBeat.i(193194);
    k.h(paramString, "id");
    paramString = new e(getPath() + '/' + paramString);
    AppMethodBeat.o(193194);
    return paramString;
  }
  
  public final boolean asd()
  {
    AppMethodBeat.i(193195);
    boolean bool = i.cO(getPath(), true);
    AppMethodBeat.o(193195);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(193193);
    k.h(paramString, "id");
    boolean bool = i.eK(getPath() + '/' + paramString);
    AppMethodBeat.o(193193);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.u
 * JD-Core Version:    0.7.0.1
 */