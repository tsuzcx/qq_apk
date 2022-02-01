package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ajw;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "finder-sdk_release"})
public abstract interface e
  extends a
{
  public abstract void a(long paramLong1, long paramLong2, String paramString, i<ajw> parami);
  
  public abstract void a(String paramString, boolean paramBoolean, i<ajw> parami);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.e
 * JD-Core Version:    0.7.0.1
 */