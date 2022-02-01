package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.protocal.protobuf.apm;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"})
public final class a
  extends h<apm>
  implements k
{
  private final String TAG = "Finder.FinderModFeedReproduce";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201233);
    at.a locala = at.rJK;
    int i = at.cyF();
    AppMethodBeat.o(201233);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void lK(boolean paramBoolean)
  {
    AppMethodBeat.i(201235);
    apm localapm = new apm();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localapm.GnT = i;
      a(localapm, null);
      AppMethodBeat.o(201235);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */