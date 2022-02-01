package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.bd;
import com.tencent.mm.protocal.protobuf.bqg;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModPersonalizedSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModWxPersonalizedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModWxPersonalizedSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxPersonalizedSetting", "isEnable", "", "scene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends n<bqg>
  implements bd
{
  private final String TAG = "Finder.FinderModPersonalizedSetting";
  
  public final void K(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(336556);
    bqg localbqg = new bqg();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbqg.hYl = i;
      localbqg.scene = paramInt;
      n.a((n)this, localbqg, null, false, false, 12);
      AppMethodBeat.o(336556);
      return;
    }
  }
  
  public final int getCmdId()
  {
    return 18;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.g
 * JD-Core Version:    0.7.0.1
 */