package com.tencent.upload.common;

import android.content.Context;
import com.tencent.upload.biz.UploadConsoleReport;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;

public final class UploadGlobalConfig
{
  private static IUploadConfig sConfig;
  private static Context sContext;
  private static final IUploadReport sDefaultUploadReport = new UploadConsoleReport();
  private static IUploadLog sUploadLog;
  private static IUploadReport sUploadReport;
  
  public static final IUploadConfig getConfig()
  {
    return sConfig;
  }
  
  public static final Context getContext()
  {
    return sContext;
  }
  
  public static final IUploadLog getUploadLog()
  {
    return sUploadLog;
  }
  
  public static IUploadReport getUploadReport()
  {
    if (sUploadReport == null) {
      return sDefaultUploadReport;
    }
    return sUploadReport;
  }
  
  public static void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport)
  {
    if ((paramContext == null) || (paramIUploadConfig == null)) {
      throw new RuntimeException("upload组件init初始化参数错误！");
    }
    sContext = paramContext;
    sConfig = paramIUploadConfig;
    sUploadReport = paramIUploadReport;
    sUploadLog = paramIUploadLog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.UploadGlobalConfig
 * JD-Core Version:    0.7.0.1
 */