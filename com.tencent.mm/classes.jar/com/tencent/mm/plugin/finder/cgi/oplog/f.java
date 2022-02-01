package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.i.a.w;
import com.tencent.mm.protocal.protobuf.ayz;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyLikeRecommendSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFriendRecommendSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyLikeRecommendSetting", "ifOpen", "", "plugin-finder_release"})
public final class f
  extends k<ayz>
  implements w
{
  private final String TAG = "Finder.FinderModRecommendSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(242658);
    bx.a locala = bx.tvW;
    int i = bx.cYR();
    AppMethodBeat.o(242658);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.f
 * JD-Core Version:    0.7.0.1
 */