package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.protocal.protobuf.azd;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class j
  extends k<azd>
  implements q
{
  private final String TAG = "Finder.FinderMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242667);
    bx.a locala = bx.tvW;
    int i = bx.cYS();
    AppMethodBeat.o(242667);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242669);
    p.h(paramString, "session");
    azd localazd = new azd();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localazd.opType = i;
      localazd.sessionId = paramString;
      a(localazd, null, false);
      AppMethodBeat.o(242669);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.j
 * JD-Core Version:    0.7.0.1
 */