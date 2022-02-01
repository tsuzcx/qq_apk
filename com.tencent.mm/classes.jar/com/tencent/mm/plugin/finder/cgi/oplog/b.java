package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.protocal.protobuf.aqc;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"})
public final class b
  extends h<aqc>
  implements com.tencent.mm.plugin.i.a.h
{
  private final String TAG = "Finder.FinderModMessageSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201664);
    au.a locala = au.rRY;
    int i = au.cAf();
    AppMethodBeat.o(201664);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void lL(boolean paramBoolean)
  {
    AppMethodBeat.i(201666);
    aqc localaqc = new aqc();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localaqc.opType = i;
      a(localaqc, null);
      AppMethodBeat.o(201666);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */