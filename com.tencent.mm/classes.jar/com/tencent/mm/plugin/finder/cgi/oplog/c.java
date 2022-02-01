package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.protocal.protobuf.aqb;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyLikeRecommendSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFriendRecommendSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyLikeRecommendSetting", "ifOpen", "", "plugin-finder_release"})
public final class c
  extends h<aqb>
  implements m
{
  private final String TAG = "Finder.FinderModRecommendSetting";
  
  public final int getCmdId()
  {
    AppMethodBeat.i(201668);
    au.a locala = au.rRY;
    int i = au.cAd();
    AppMethodBeat.o(201668);
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