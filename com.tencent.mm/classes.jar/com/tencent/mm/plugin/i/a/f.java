package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.amf;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "finder-sdk_release"})
public abstract interface f
  extends a
{
  public abstract void a(long paramLong1, long paramLong2, String paramString, k<amf> paramk);
  
  public abstract void a(String paramString, boolean paramBoolean, k<amf> paramk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.f
 * JD-Core Version:    0.7.0.1
 */