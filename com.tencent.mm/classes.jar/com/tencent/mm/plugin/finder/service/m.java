package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.buf;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderDelFansService;", "Lcom/tencent/mm/kernel/service/IService;", "delFans", "", "fansId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface m
  extends a
{
  public abstract void a(String paramString, ck<buf> paramck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.m
 * JD-Core Version:    0.7.0.1
 */