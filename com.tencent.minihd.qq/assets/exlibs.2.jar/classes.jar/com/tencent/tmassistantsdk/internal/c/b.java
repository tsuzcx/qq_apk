package com.tencent.tmassistantsdk.internal.c;

import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;

public class b
  extends a
{
  protected static b d = null;
  
  public static String a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramTMAssistantCallYYBParamStruct != null) {
      localStringBuffer.append(f.b(f.a().b())).append("_").append(String.valueOf(f.c(f.a().b()))).append("_").append(paramTMAssistantCallYYBParamStruct.channelId).append("_").append(paramTMAssistantCallYYBParamStruct.via).append("_").append(paramTMAssistantCallYYBParamStruct.uin).append("_").append(paramTMAssistantCallYYBParamStruct.taskAppId).append("_").append(paramTMAssistantCallYYBParamStruct.taskPackageName).append("_").append(paramTMAssistantCallYYBParamStruct.taskVersion);
    }
    k.c("BusinessReportManager", "logStr=" + localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static b h()
  {
    try
    {
      if (d == null) {
        d = new b();
      }
      b localb = d;
      return localb;
    }
    finally {}
  }
  
  public StatStdReport a(String paramString1, String paramString2, String paramString3)
  {
    k.c("BusinessReportManager", "createTipsInfoLog");
    StatStdReport localStatStdReport = new StatStdReport();
    localStatStdReport.name = paramString3;
    localStatStdReport.time = System.currentTimeMillis();
    localStatStdReport.versionInfo = "1.0";
    localStatStdReport.extraData = paramString1;
    localStatStdReport.traceId = paramString2;
    return localStatStdReport;
  }
  
  protected com.tencent.tmassistant.common.a.a e()
  {
    return com.tencent.tmassistantsdk.internal.d.b.a.g();
  }
  
  protected byte f()
  {
    return 3;
  }
  
  protected boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.b
 * JD-Core Version:    0.7.0.1
 */