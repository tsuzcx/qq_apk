package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.findersdk.a.ah;
import com.tencent.mm.protocal.protobuf.bez;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class n
  extends m<bez>
  implements ah
{
  private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";
  
  public final void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(282529);
    p.k(paramString, "session");
    bez localbez = new bez();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbez.opType = i;
      localbez.sessionId = paramString;
      m.a(this, localbez, null);
      AppMethodBeat.o(282529);
      return;
    }
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(282527);
    ca.a locala = ca.xdJ;
    int i = ca.doK();
    AppMethodBeat.o(282527);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.n
 * JD-Core Version:    0.7.0.1
 */