package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.service.i;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bep;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModBlockPoster;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modBlockPoster", "finderUserName", "block", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder_release"})
public final class c
  extends m<bep>
  implements i
{
  private final String TAG = "Finder.FinderModBloclPosterSetting";
  
  public final void a(String paramString, boolean paramBoolean, aj<bep> paramaj)
  {
    AppMethodBeat.i(284851);
    p.k(paramString, "finderUserName");
    bep localbep = new bep();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbep.opType = i;
      localbep.finderUsername = paramString;
      m.a(this, localbep, paramaj);
      AppMethodBeat.o(284851);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(284849);
    ca.a locala = ca.xdJ;
    int i = ca.doM();
    AppMethodBeat.o(284849);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */