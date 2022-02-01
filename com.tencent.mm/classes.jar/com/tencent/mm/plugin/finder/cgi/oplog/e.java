package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ba;
import com.tencent.mm.protocal.protobuf.bpz;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends n<bpz>
  implements ba
{
  private final String TAG = "Finder.FinderModMessageSetting";
  
  public final int getCmdId()
  {
    return 8;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(336533);
    bpz localbpz = new bpz();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbpz.opType = i;
      n.a((n)this, localbpz, null, false, false, 12);
      AppMethodBeat.o(336533);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */