package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ayt;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/kernel/service/IService;", "modifyCommentBlackList", "", "commentId", "", "feedId", "feedNonceId", "", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", "username", "finder-sdk_release"})
public abstract interface t
  extends a
{
  public abstract void a(long paramLong1, long paramLong2, String paramString, ai<ayt> paramai);
  
  public abstract void b(String paramString, ai<ayt> paramai);
  
  public abstract void b(String paramString, boolean paramBoolean, ai<ayt> paramai);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.t
 * JD-Core Version:    0.7.0.1
 */