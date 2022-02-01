package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderReportLogic;", "Lcom/tencent/mm/kernel/service/IService;", "report21188", "", "context", "Landroid/content/Context;", "isFirstOpen", "", "clickscene", "", "clickId", "", "appId", "scene", "preWarmPath", "ispresend", "ispreload", "liveid", "finderid", "shopwindowid", "sessionid", "report21235", "appuin", "report21237", "prewarmstartime", "", "prewarmendtime", "appVersion", "report21313", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "joinLiveTime", "enterRoomTime", "liveStates", "uiStates", "statistics", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveEventCode", "liveEventSubCode", "liveEventMsg", "extra", "snn", "networkQuality", "report21837", "action", "setting", "requestId", "report22623", "newIds", "", "oldIds", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bm
  extends a
{
  public abstract void A(List<String> paramList1, List<String> paramList2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void a(Context paramContext, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6);
  
  public abstract void b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bm
 * JD-Core Version:    0.7.0.1
 */