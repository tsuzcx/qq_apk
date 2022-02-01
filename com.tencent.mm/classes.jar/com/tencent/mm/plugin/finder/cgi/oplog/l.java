package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.bez;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class l
  extends m<bez>
  implements t
{
  private final String TAG = "Finder.FinderMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(289685);
    ca.a locala = ca.xdJ;
    int i = ca.doH();
    AppMethodBeat.o(289685);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(289689);
    p.k(paramString, "session");
    bez localbez = new bez();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbez.opType = i;
      localbez.sessionId = paramString;
      m.a(this, localbez, null);
      AppMethodBeat.o(289689);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.l
 * JD-Core Version:    0.7.0.1
 */