package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QualityReportUtil
{
  public static int a = 19;
  public static final String a = "dlFileTransfer.Quality";
  public static int b = 1;
  public static final String b = "actFAFileUp";
  public static int c = 9;
  public static final String c = "actFAFileDown";
  private static final int d = 2;
  public static final String d = "actFAFileConnection";
  private static final int e = 1;
  public static final String e = "sessionid";
  public static final String f = "mobileterm";
  public static final String g = "otherterm";
  public static final String h = "channeltype";
  public static final String i = "networktype";
  public static final String j = "filesize";
  public static final String k = "fileexist";
  public static final String l = "startpos";
  public static final String m = "duration";
  public static final String n = "suffix";
  public static final String o = "result";
  public static final String p = "failcode";
  public static final String q = "usercode";
  public static final String r = "clientip";
  public static final String s = "serverip";
  public static final String t = "serverport";
  public static final String u = "taskstart";
  public static final String v = "taskend";
  public static final String w = "notifytime";
  public static final String x = "userretry";
  public static final String y = "qqstate";
  
  public static short a()
  {
    if (NetworkUtil.g(BaseApplication.getContext())) {
      return 18;
    }
    if (NetworkUtil.d(BaseApplication.getContext())) {
      return 19;
    }
    if (NetworkUtil.f(BaseApplication.getContext())) {
      return 20;
    }
    return 17;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReportItem paramReportItem, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str;
    boolean bool;
    label62:
    long l3;
    long l4;
    long l5;
    long l1;
    HashMap localHashMap;
    if (paramReportItem.bSend)
    {
      str = "actFAFileUp";
      if ((paramReportItem.emResult != 2) && (paramReportItem.emResult != 26) && (paramReportItem.emResult != 30) && (paramReportItem.emResult != 31) && (paramReportItem.emResult != 34)) {
        break label531;
      }
      bool = true;
      l3 = paramReportItem.uDuration;
      l4 = paramReportItem.uFileSize;
      l5 = paramReportItem.uStartPos;
      long l2 = paramInt;
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramInt == b) {
          l1 = ((RegisterProxySvcPackHandler)paramQQAppInterface.a(9)).a();
        }
      }
      localHashMap = new HashMap();
      localHashMap.put("sessionid", String.valueOf(paramReportItem.uSessionID));
      localHashMap.put("mobileterm", String.valueOf(a));
      localHashMap.put("otherterm", String.valueOf(l1));
      localHashMap.put("channeltype", String.valueOf(paramReportItem.uChannelType));
      localHashMap.put("networktype", String.valueOf(a()));
      localHashMap.put("filesize", String.valueOf(paramReportItem.uFileSize));
      if (!paramReportItem.bFileExist) {
        break label536;
      }
      paramInt = 1;
      label221:
      localHashMap.put("fileexist", String.valueOf(paramInt));
      localHashMap.put("startpos", String.valueOf(paramReportItem.uStartPos));
      localHashMap.put("duration", String.valueOf(paramReportItem.uDuration));
      localHashMap.put("suffix", paramReportItem.sSuffix);
      localHashMap.put("result", String.valueOf(paramReportItem.emResult));
      localHashMap.put("failcode", String.valueOf(paramReportItem.nFailCode));
      localHashMap.put("usercode", String.valueOf(paramReportItem.nUserCode));
      if (!paramQQAppInterface.f) {
        break label541;
      }
      paramInt = 2;
      label329:
      localHashMap.put("qqstate", String.valueOf(paramInt));
      if (paramReportItem.dwClientIP < 0) {
        break label546;
      }
      l1 = paramReportItem.dwClientIP;
      label355:
      localHashMap.put("clientip", String.valueOf(l1));
      if (paramReportItem.dwServerIP < 0) {
        break label560;
      }
      l1 = paramReportItem.dwServerIP;
      label382:
      localHashMap.put("serverip", String.valueOf(l1));
      if (paramReportItem.wServerPort < 0) {
        break label574;
      }
      paramInt = paramReportItem.wServerPort;
      label407:
      localHashMap.put("serverport", String.valueOf(paramInt));
      localHashMap.put("taskstart", String.valueOf(paramReportItem.uTaskStart / 1000L));
      localHashMap.put("taskend", String.valueOf(paramReportItem.uTaskEnd / 1000L));
      localHashMap.put("notifytime", String.valueOf(paramReportItem.uNotifyTime / 1000L));
      if (!paramReportItem.bUserRetry) {
        break label585;
      }
    }
    label531:
    label536:
    label541:
    label546:
    label560:
    label574:
    label585:
    for (paramInt = 1;; paramInt = 0)
    {
      localHashMap.put("userretry", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), str, bool, l3, l4 - l5, localHashMap, null);
      return;
      str = "actFAFileDown";
      break;
      bool = false;
      break label62;
      paramInt = 0;
      break label221;
      paramInt = 1;
      break label329;
      l1 = paramReportItem.dwClientIP + 4294967295L;
      break label355;
      l1 = paramReportItem.dwServerIP + 4294967295L;
      break label382;
      paramInt = paramReportItem.wServerPort + 65535;
      break label407;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        localObject = new String[4];
        i1 = NetworkUtil.a(paramQQAppInterface.getApplication().getApplicationContext());
        if (i1 == 1)
        {
          if (paramBoolean2)
          {
            localObject[0] = "param_WIFIFAFileUploadFlow";
            break label209;
            localObject[3] = "param_Flow";
            paramQQAppInterface.a(paramQQAppInterface.getAccount(), (String[])localObject, paramLong);
            if (!QLog.isColorLevel()) {
              break label226;
            }
            localObject = new StringBuilder().append("addFlowCount ").append(paramLong).append(" for ");
            if (!paramBoolean1) {
              break label254;
            }
            paramQQAppInterface = "nfc";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(" ");
            if (!paramBoolean2) {
              break label261;
            }
            paramQQAppInterface = "upload";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(", netType is ");
            if (i1 != 1) {
              break label184;
            }
            paramQQAppInterface = "wifi";
            QLog.d("dlFileTransfer.Quality", 2, paramQQAppInterface);
            return;
          }
          localObject[0] = "param_WIFIFAFileDownloadFlow";
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      if (paramBoolean2)
      {
        localObject[0] = "param_XGFAFileUploadFlow";
        break label227;
        label184:
        paramQQAppInterface = "nonwifi : " + i1;
        continue;
        label209:
        localObject[1] = "param_WIFIFileFlow";
        localObject[2] = "param_WIFIFlow";
        continue;
        label226:
        return;
      }
      for (;;)
      {
        label227:
        localObject[1] = "param_XGFileFlow";
        localObject[2] = "param_XGFlow";
        break;
        localObject[0] = "param_XGFAFileDownloadFlow";
      }
      label254:
      paramQQAppInterface = "ftn";
      continue;
      label261:
      paramQQAppInterface = "download";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.QualityReportUtil
 * JD-Core Version:    0.7.0.1
 */