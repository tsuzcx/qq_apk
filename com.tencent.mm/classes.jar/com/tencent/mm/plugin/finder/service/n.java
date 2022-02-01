package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpq;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderModBlockPoster;", "Lcom/tencent/mm/kernel/service/IService;", "modBlockPoster", "", "finderUserName", "", "block", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
  extends a
{
  public abstract void a(String paramString, boolean paramBoolean, ck<bpq> paramck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.n
 * JD-Core Version:    0.7.0.1
 */