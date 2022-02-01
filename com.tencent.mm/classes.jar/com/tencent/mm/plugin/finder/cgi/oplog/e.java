package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.findersdk.a.s;
import com.tencent.mm.protocal.protobuf.bey;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"})
public final class e
  extends m<bey>
  implements s
{
  private final String TAG = "Finder.FinderModMessageSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(225711);
    ca.a locala = ca.xdJ;
    int i = ca.doI();
    AppMethodBeat.o(225711);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void oi(boolean paramBoolean)
  {
    AppMethodBeat.i(225714);
    bey localbey = new bey();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbey.opType = i;
      m.a(this, localbey, null);
      AppMethodBeat.o(225714);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */