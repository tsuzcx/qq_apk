package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderShareInfoService;", "Lcom/tencent/mm/kernel/service/IService;", "getMegaVideoDetail", "", "objectId", "", "nonceId", "", "commentScene", "", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "username", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderShareInfoService$ResultCallback;", "isBizToTimeline", "", "isShareToTimeline", "isShowFinderEntrance", "preloadShareFeed", "isMegaVideo", "ResultCallback", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bq
  extends a
{
  public abstract void a(long paramLong, String paramString1, int paramInt, bui parambui, Context paramContext, boolean paramBoolean, String paramString2);
  
  public abstract void a(long paramLong, String paramString1, bui parambui, String paramString2, Context paramContext, a parama);
  
  public abstract boolean bZX();
  
  public abstract boolean eHE();
  
  public abstract boolean ecY();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderShareInfoService$ResultCallback;", "", "onFinish", "", "objectId", "", "nonceId", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onFinish(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bq
 * JD-Core Version:    0.7.0.1
 */