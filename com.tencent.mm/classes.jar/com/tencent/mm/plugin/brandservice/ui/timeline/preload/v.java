package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "plugin-brandservice_release"})
public final class v
  extends e
{
  public v(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(198998);
    AppMethodBeat.o(198998);
  }
  
  public final e TY(String paramString)
  {
    AppMethodBeat.i(198996);
    k.h(paramString, "id");
    paramString = new e(getPath() + '/' + paramString);
    AppMethodBeat.o(198996);
    return paramString;
  }
  
  public final boolean ayU()
  {
    AppMethodBeat.i(198997);
    boolean bool = i.cU(getPath(), true);
    AppMethodBeat.o(198997);
    return bool;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(198995);
    k.h(paramString, "id");
    boolean bool = i.eA(getPath() + '/' + paramString);
    AppMethodBeat.o(198995);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */