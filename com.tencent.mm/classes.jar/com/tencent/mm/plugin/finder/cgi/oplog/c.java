package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.protocal.protobuf.apo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyLikeRecommendSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFriendRecommendSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyLikeRecommendSetting", "ifOpen", "", "plugin-finder_release"})
public final class c
  extends h<apo>
  implements m
{
  private final String TAG = "Finder.FinderModRecommendSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201241);
    at.a locala = at.rJK;
    int i = at.cyC();
    AppMethodBeat.o(201241);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */