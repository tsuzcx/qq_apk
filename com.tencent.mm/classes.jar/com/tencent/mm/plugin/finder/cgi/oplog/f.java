package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.bc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModOverSeaAgree;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModOverSeaAgree;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "", "()V", "TAG", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modOverSeaAgree", "isReset", "", "(Ljava/lang/Boolean;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends n<String>
  implements bc
{
  private final String TAG = "Finder.FinderModOverSeaAgree";
  
  public final int getCmdId()
  {
    return 15;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void s(Boolean paramBoolean)
  {
    AppMethodBeat.i(336554);
    n localn = (n)this;
    if (s.p(paramBoolean, Boolean.TRUE)) {}
    for (paramBoolean = "remove_accept_protobuf";; paramBoolean = "")
    {
      n.a(localn, paramBoolean, null, false, false, 12);
      AppMethodBeat.o(336554);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.f
 * JD-Core Version:    0.7.0.1
 */