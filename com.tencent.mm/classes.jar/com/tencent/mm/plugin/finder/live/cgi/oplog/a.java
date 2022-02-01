package com.tencent.mm.plugin.finder.live.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.oplog.n;
import com.tencent.mm.plugin.findersdk.a.at;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpv;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/oplog/FinderLiveNotifyRejectService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNotifyRejectService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "rejectNotify", "userName", "reject", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n<bpv>
  implements at
{
  private final String TAG = "Finder.FinderLiveNotifyRejectService";
  
  public final void c(String paramString, boolean paramBoolean, ck<bpv> paramck)
  {
    AppMethodBeat.i(351230);
    s.u(paramString, "userName");
    bpv localbpv = new bpv();
    localbpv.YIZ = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbpv.hYl = i;
      n.a((n)this, localbpv, paramck, false, false, 12);
      AppMethodBeat.o(351230);
      return;
    }
  }
  
  public final int getCmdId()
  {
    return 16;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */