package com.tencent.mm.plugin.finder.live.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.cgi.oplog.m;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.plugin.findersdk.a.r;
import com.tencent.mm.protocal.protobuf.beu;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/oplog/FinderLiveNotifyRejectService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNotifyRejectService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "rejectNotify", "userName", "reject", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder-live_release"})
public final class a
  extends m<beu>
  implements r
{
  private final String TAG = "Finder.FinderLiveNotifyRejectService";
  
  public final void c(String paramString, boolean paramBoolean, aj<beu> paramaj)
  {
    AppMethodBeat.i(233008);
    p.k(paramString, "userName");
    beu localbeu = new beu();
    localbeu.RLN = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbeu.fSo = i;
      m.a(this, localbeu, paramaj);
      AppMethodBeat.o(233008);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(233005);
    ca.a locala = ca.xdJ;
    int i = ca.doP();
    AppMethodBeat.o(233005);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */