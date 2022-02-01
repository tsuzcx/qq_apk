package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cd;
import com.tencent.mm.protocal.protobuf.bqa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends n<bqa>
  implements cd
{
  private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";
  
  public final void O(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(336527);
    s.u(paramString, "session");
    bqa localbqa = new bqa();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbqa.opType = i;
      localbqa.sessionId = paramString;
      n.a((n)this, localbqa, null, false, false, 12);
      AppMethodBeat.o(336527);
      return;
    }
  }
  
  public final int getCmdId()
  {
    return 10;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.o
 * JD-Core Version:    0.7.0.1
 */