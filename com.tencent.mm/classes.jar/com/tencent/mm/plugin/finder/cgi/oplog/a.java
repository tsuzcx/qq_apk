package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.am.a;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.protocal.protobuf.amh;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyLikeRecommendSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFriendRecommendSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyLikeRecommendSetting", "ifOpen", "", "plugin-finder_release"})
public final class a
  extends e<amh>
  implements h
{
  private final String TAG = "Finder.FinderModRecommendSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201248);
    am.a locala = am.qYu;
    int i = am.csL();
    AppMethodBeat.o(201248);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void lr(boolean paramBoolean)
  {
    AppMethodBeat.i(201250);
    amh localamh = new amh();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localamh.EFF = i;
      a(localamh, null);
      AppMethodBeat.o(201250);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.a
 * JD-Core Version:    0.7.0.1
 */