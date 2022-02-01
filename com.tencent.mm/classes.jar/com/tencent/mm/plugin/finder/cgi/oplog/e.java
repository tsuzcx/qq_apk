package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.protocal.protobuf.dzl;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyLikeRecommendSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFriendRecommendSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyLikeRecommendSetting", "ifOpen", "", "plugin-finder_release"})
public final class e
  extends d<dzl>
  implements m
{
  private final String TAG = "Finder.FinderModRecommendSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(197373);
    v.a locala = v.qpr;
    int i = v.fSf();
    AppMethodBeat.o(197373);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void yy(boolean paramBoolean)
  {
    AppMethodBeat.i(197375);
    dzl localdzl = new dzl();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localdzl.LxS = i;
      a(localdzl, null);
      AppMethodBeat.o(197375);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */