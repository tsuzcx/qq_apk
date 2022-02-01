package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.protocal.protobuf.app;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"})
public final class b
  extends h<app>
  implements com.tencent.mm.plugin.i.a.h
{
  private final String TAG = "Finder.FinderModMessageSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201237);
    at.a locala = at.rJK;
    int i = at.cyE();
    AppMethodBeat.o(201237);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void lL(boolean paramBoolean)
  {
    AppMethodBeat.i(201239);
    app localapp = new app();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localapp.opType = i;
      a(localapp, null);
      AppMethodBeat.o(201239);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.b
 * JD-Core Version:    0.7.0.1
 */