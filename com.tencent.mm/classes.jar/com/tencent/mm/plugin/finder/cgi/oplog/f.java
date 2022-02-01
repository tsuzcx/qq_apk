package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.findersdk.a.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModOverSeaAgree;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModOverSeaAgree;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "", "()V", "TAG", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modOverSeaAgree", "isReset", "", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
public final class f
  extends m<String>
  implements u
{
  private final String TAG = "Finder.FinderModOverSeaAgree";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(291568);
    ca.a locala = ca.xdJ;
    int i = ca.doO();
    AppMethodBeat.o(291568);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(291570);
    if (p.h(paramBoolean, Boolean.TRUE)) {}
    for (paramBoolean = "remove_accept_protobuf";; paramBoolean = "")
    {
      m.a(this, paramBoolean, null);
      AppMethodBeat.o(291570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.f
 * JD-Core Version:    0.7.0.1
 */