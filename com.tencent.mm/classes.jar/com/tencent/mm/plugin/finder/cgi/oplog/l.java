package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.ag;
import com.tencent.mm.protocal.protobuf.azd;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class l
  extends k<azd>
  implements ag
{
  private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242671);
    bx.a locala = bx.tvW;
    int i = bx.cYV();
    AppMethodBeat.o(242671);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void w(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242673);
    p.h(paramString, "session");
    azd localazd = new azd();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localazd.opType = i;
      localazd.sessionId = paramString;
      a(localazd, null, false);
      AppMethodBeat.o(242673);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.l
 * JD-Core Version:    0.7.0.1
 */