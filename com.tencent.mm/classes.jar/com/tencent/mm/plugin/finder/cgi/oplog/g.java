package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.apq;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class g
  extends h<apq>
  implements i
{
  private final String TAG = "Finder.FinderMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201246);
    at.a locala = at.rJK;
    int i = at.cyD();
    AppMethodBeat.o(201246);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(201248);
    p.h(paramString, "session");
    apq localapq = new apq();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localapq.opType = i;
      localapq.sessionId = paramString;
      a(localapq, null);
      AppMethodBeat.o(201248);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.g
 * JD-Core Version:    0.7.0.1
 */