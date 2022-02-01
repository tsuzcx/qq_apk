package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.protocal.protobuf.aqd;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class i
  extends h<aqd>
  implements q
{
  private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201677);
    au.a locala = au.rRY;
    int i = au.cAh();
    AppMethodBeat.o(201677);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void w(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(201679);
    p.h(paramString, "session");
    aqd localaqd = new aqd();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localaqd.opType = i;
      localaqd.sessionId = paramString;
      a(localaqd, null);
      AppMethodBeat.o(201679);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.i
 * JD-Core Version:    0.7.0.1
 */