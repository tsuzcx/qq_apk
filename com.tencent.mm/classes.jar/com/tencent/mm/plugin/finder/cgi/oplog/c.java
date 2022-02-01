package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpq;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModBlockPoster;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modBlockPoster", "finderUserName", "block", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends n<bpq>
  implements com.tencent.mm.plugin.finder.service.n
{
  private final String TAG = "Finder.FinderModBloclPosterSetting";
  
  public final void a(String paramString, boolean paramBoolean, ck<bpq> paramck)
  {
    AppMethodBeat.i(336529);
    s.u(paramString, "finderUserName");
    bpq localbpq = new bpq();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbpq.opType = i;
      localbpq.finderUsername = paramString;
      n.a((n)this, localbpq, paramck, false, false, 12);
      AppMethodBeat.o(336529);
      return;
    }
  }
  
  public final int getCmdId()
  {
    return 13;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */