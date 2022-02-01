package com.tencent.mm.plugin.findersdk.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bkk;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveAdNoticeCache;", "Lcom/tencent/mm/kernel/service/IService;", "assignRequestInterval", "", "_requestInterval", "", "getNoticeState", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "save", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "update", "reserved", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aj
  extends a
{
  public abstract void Ow(int paramInt);
  
  public abstract void a(String paramString1, String paramString2, bkk parambkk);
  
  public abstract Boolean hJ(String paramString1, String paramString2);
  
  public abstract void u(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.aj
 * JD-Core Version:    0.7.0.1
 */