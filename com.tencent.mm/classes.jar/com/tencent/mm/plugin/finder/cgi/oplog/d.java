package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.protocal.protobuf.azc;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"})
public final class d
  extends k<azc>
  implements p
{
  private final String TAG = "Finder.FinderModMessageSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242649);
    bx.a locala = bx.tvW;
    int i = bx.cYT();
    AppMethodBeat.o(242649);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(242651);
    azc localazc = new azc();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localazc.opType = i;
      a(localazc, null, false);
      AppMethodBeat.o(242651);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */