package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bpu;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderModifyFeedSetting;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedComment", "", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "modifyFeedPrivacy", "ifPrivate", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface q
  extends a
{
  public abstract void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ck<bpu> paramck);
  
  public abstract void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ck<bpu> paramck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.q
 * JD-Core Version:    0.7.0.1
 */