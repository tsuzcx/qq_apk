package com.tencent.open.business.viareport;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.APNUtil;

public class OpenSdkStatic
{
  protected static OpenSdkStatic a;
  
  public static OpenSdkStatic a()
  {
    try
    {
      if (a == null) {
        a = new OpenSdkStatic();
      }
      OpenSdkStatic localOpenSdkStatic = a;
      return localOpenSdkStatic;
    }
    finally {}
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    long l = SystemClock.elapsedRealtime() - paramLong.longValue();
    if ((paramLong.longValue() == 0L) || (l < 0L)) {
      l = 0L;
    }
    for (;;)
    {
      paramLong = new StringBuffer("https://c.isdspeed.qq.com/code.cgi");
      paramLong.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(paramInt1).append("&code=").append(paramInt2).append("&time=").append(l).append("&rate=").append(paramInt3).append("&uin=").append(paramString2).append("&data=");
      paramString1 = AuthorityUtil.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      ReportCenter.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      CommonDataAdapter.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = ReportConfig.a();
      String str = String.valueOf(CommonDataAdapter.a().a());
      if (!((String)localObject).equals(str))
      {
        ReportManager.a().a((String)localObject, new BatchReportInfo(), null, true);
        ReportConfig.a(str);
      }
      localObject = new BatchReportInfo();
      ((BatchReportInfo)localObject).c = paramString4;
      ((BatchReportInfo)localObject).a = paramString2;
      ((BatchReportInfo)localObject).f = APNUtil.a(CommonDataAdapter.a().a());
      ((BatchReportInfo)localObject).e = paramString5;
      ((BatchReportInfo)localObject).d = paramString1;
      ((BatchReportInfo)localObject).b = paramString3;
      ((BatchReportInfo)localObject).g = String.valueOf(System.currentTimeMillis());
      ReportManager.a().a((BatchReportInfo)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, CommonDataAdapter.a().e(), null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.business.viareport.OpenSdkStatic
 * JD-Core Version:    0.7.0.1
 */