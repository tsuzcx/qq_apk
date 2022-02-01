package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bqb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderModProfileSticky;", "Lcom/tencent/mm/kernel/service/IService;", "modifyStickyFeed", "", "feedId", "", "opType", "", "nonceId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface o
  extends a
{
  public abstract void a(long paramLong, int paramInt, String paramString, ck<bqb> paramck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.o
 * JD-Core Version:    0.7.0.1
 */