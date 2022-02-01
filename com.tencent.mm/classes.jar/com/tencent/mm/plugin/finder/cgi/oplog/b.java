package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.service.h;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bic;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "Lcom/tencent/mm/plugin/finder/service/IFinderDelFansService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "delFans", "", "fansId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getCmdId", "", "handleUpdateResult", "retCode", "plugin-finder_release"})
public final class b
  extends m<bic>
  implements h
{
  private final String TAG = "Finder.FinderDelFansService";
  
  public final void a(String paramString, aj<bic> paramaj)
  {
    AppMethodBeat.i(284170);
    p.k(paramString, "fansId");
    bic localbic = new bic();
    localbic.SSE = paramString;
    m.a(this, localbic, paramaj);
    AppMethodBeat.o(284170);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(284168);
    ca.a locala = ca.xdJ;
    int i = ca.doN();
    AppMethodBeat.o(284168);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */