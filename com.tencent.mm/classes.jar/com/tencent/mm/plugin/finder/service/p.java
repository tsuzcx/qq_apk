package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "anchorUsername", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface p
  extends a
{
  public abstract void a(long paramLong1, long paramLong2, String paramString, ck<bpp> paramck);
  
  public abstract void a(String paramString1, String paramString2, ck<bpp> paramck);
  
  public abstract void b(String paramString, ck<bpp> paramck);
  
  public abstract void b(String paramString, boolean paramBoolean, ck<bpp> paramck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.p
 * JD-Core Version:    0.7.0.1
 */