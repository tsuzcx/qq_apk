package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.be;
import com.tencent.mm.protocal.protobuf.bpt;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<bpt>
  implements be
{
  private final String TAG = "Finder.FinderModFeedReproduce";
  
  public final int getCmdId()
  {
    return 9;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(336531);
    bpt localbpt = new bpt();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localbpt.ZXY = i;
      n.a((n)this, localbpt, null, false, false, 12);
      AppMethodBeat.o(336531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */