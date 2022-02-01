package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.beo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "plugin-finder_release"})
public abstract interface k
  extends a
{
  public abstract void a(long paramLong1, long paramLong2, String paramString, aj<beo> paramaj);
  
  public abstract void b(String paramString, aj<beo> paramaj);
  
  public abstract void b(String paramString, boolean paramBoolean, aj<beo> paramaj);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.k
 * JD-Core Version:    0.7.0.1
 */