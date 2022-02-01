package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.protocal.protobuf.apq;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class i
  extends h<apq>
  implements q
{
  private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201250);
    at.a locala = at.rJK;
    int i = at.cyG();
    AppMethodBeat.o(201250);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(201252);
    p.h(paramString, "session");
    apq localapq = new apq();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localapq.opType = i;
      localapq.sessionId = paramString;
      a(localapq, null);
      AppMethodBeat.o(201252);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.i
 * JD-Core Version:    0.7.0.1
 */