package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.ui.component.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedUIC;", "Lcom/tencent/mm/ui/component/ApiUIC;", "getJoinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "liveId", "", "tryFetchPreloadInfo", "", "objectId", "nonceId", "", "context", "Landroid/content/Context;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ap
  extends c
{
  public abstract void a(long paramLong1, String paramString, long paramLong2, Context paramContext);
  
  public abstract bcc nw(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ap
 * JD-Core Version:    0.7.0.1
 */