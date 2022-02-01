package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.findersdk.a.v;
import com.tencent.mm.protocal.protobuf.bes;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"})
public final class d
  extends m<bes>
  implements v
{
  private final String TAG = "Finder.FinderModFeedReproduce";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(287098);
    ca.a locala = ca.xdJ;
    int i = ca.doJ();
    AppMethodBeat.o(287098);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void oh(boolean paramBoolean)
  {
    AppMethodBeat.i(287100);
    bes localbes = new bes();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localbes.SPG = i;
      m.a(this, localbes, null);
      AppMethodBeat.o(287100);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */