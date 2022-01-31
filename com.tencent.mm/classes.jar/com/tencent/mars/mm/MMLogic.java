package com.tencent.mars.mm;

import android.util.Xml;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.u;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class MMLogic
{
  public static final int MM_STAT_CGI_INFO = 1;
  public static final int MM_STAT_CGI_NETWORK_COST = 7;
  public static final int MM_STAT_DNS = 8;
  public static final int MM_STAT_LONGLINK_BUILD = 3;
  public static final int MM_STAT_LONGLINK_CONNECT = 4;
  public static final int MM_STAT_LONGLINK_DISCONNECT = 5;
  public static final int MM_STAT_LONGLINK_FUNC_CONNECT = 6;
  public static final int MM_STAT_NETWORK_UNREACHABLE = 2;
  public static final int MM_Stat_Local_GetHostByName = 11;
  public static final int MM_Stat_Network_Changed = 10;
  public static final int MM_Stat_Noop_Send = 9;
  private static long lastReportTime = 0L;
  private static int totalMobileRecv;
  private static int totalMobileSend;
  private static int totalWifiRecv = 0;
  private static int totalWifiSend = 0;
  
  static
  {
    totalMobileRecv = 0;
    totalMobileSend = 0;
  }
  
  public static native void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public static native void clearLocalHostCache();
  
  private static String getCurLanguage()
  {
    try
    {
      String str = aa.dsG();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static int getHostByName(String paramString, List<String> paramList)
  {
    long l1 = System.currentTimeMillis();
    MMLogic.GetDnsReturn localGetDnsReturn = new MMLogic.GetDnsReturn(null);
    getHostIps(paramString, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    paramList = new MMLogic.ReportInfo();
    paramList.actionId = 11L;
    paramList.beginTime = l1;
    paramList.endTime = l2;
    paramList.clientIp = paramString;
    if (localGetDnsReturn.length > 0) {}
    for (paramString = localGetDnsReturn.aryIps[0];; paramString = "0.0.0.0")
    {
      paramList.ip = paramString;
      reportStat(paramList);
      return localGetDnsReturn.type;
    }
  }
  
  private static native void getHostIps(String paramString, MMLogic.GetDnsReturn paramGetDnsReturn);
  
  public static native String[] getIPsString(boolean paramBoolean);
  
  public static native String getIspId();
  
  private static int getJavaActionId(long paramLong)
  {
    switch ((int)paramLong)
    {
    default: 
      return 0;
    case 1: 
      return 10955;
    case 2: 
      return 10104;
    case 3: 
      return 10103;
    case 4: 
      return 10105;
    case 5: 
      return 10102;
    case 6: 
      return 10101;
    case 7: 
      return 1105;
    case 8: 
      return 10428;
    case 9: 
      return -1;
    case 10: 
      return -2;
    }
    return -3;
  }
  
  public static native void getLocalHostList(String[] paramArrayOfString, String paramString);
  
  public static native String getNetworkServerIp();
  
  private static native void getSnsIps(boolean paramBoolean, MMLogic.GetDnsReturn paramGetDnsReturn);
  
  public static int getSnsIpsForScene(List<String> paramList, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    MMLogic.GetDnsReturn localGetDnsReturn = new MMLogic.GetDnsReturn(null);
    getSnsIps(paramBoolean, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    MMLogic.ReportInfo localReportInfo = new MMLogic.ReportInfo();
    localReportInfo.actionId = 11L;
    localReportInfo.beginTime = l1;
    localReportInfo.endTime = l2;
    localReportInfo.clientIp = "mmsns.qpic.cn";
    if (localGetDnsReturn.length > 0) {}
    for (paramList = localGetDnsReturn.aryIps[0];; paramList = "0.0.0.0")
    {
      localReportInfo.ip = paramList;
      reportStat(localReportInfo);
      return localGetDnsReturn.type;
    }
  }
  
  public static int getSnsIpsForSceneWithHostName(List<String> paramList, String paramString, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    MMLogic.GetDnsReturn localGetDnsReturn = new MMLogic.GetDnsReturn(null);
    getSnsIpsWithHostName(paramString, paramBoolean, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    MMLogic.ReportInfo localReportInfo = new MMLogic.ReportInfo();
    localReportInfo.actionId = 11L;
    localReportInfo.beginTime = l1;
    localReportInfo.endTime = l2;
    localReportInfo.clientIp = paramString;
    if (localGetDnsReturn.length > 0) {}
    for (paramList = localGetDnsReturn.aryIps[0];; paramList = "0.0.0.0")
    {
      localReportInfo.ip = paramList;
      reportStat(localReportInfo);
      return localGetDnsReturn.type;
    }
  }
  
  private static native void getSnsIpsWithHostName(String paramString, boolean paramBoolean, MMLogic.GetDnsReturn paramGetDnsReturn);
  
  private static String getUserIDCLocale()
  {
    try
    {
      if (bo.hl(ah.getContext())) {
        return "HK";
      }
      return "CN";
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static void notifyNewSpeedTestReport(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, int paramInt6, int paramInt7)
  {
    if (com.tencent.mm.network.ab.anH() == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("C2Java", "notifyNewSpeedTestReport failed");
      return;
    }
    cfx localcfx = new cfx();
    localcfx.xQC = paramInt1;
    localcfx.xQD = paramInt2;
    localcfx.xQE = paramInt3;
    localcfx.xQF = paramInt4;
    localcfx.xpR = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    localcfx.xQA = "";
    localcfx.xQz = "";
    localcfx.xQB = "";
    if (paramInt7 == 3) {
      localcfx.xQz = "dual";
    }
    cfv localcfv1 = new cfv();
    cfv localcfv2 = new cfv();
    localcfv1.ip = paramString1;
    localcfv1.port = paramInt5;
    localcfv2.ip = paramString2;
    localcfv2.port = paramInt6;
    localcfx.xQH = localcfv1;
    localcfx.xQG = localcfv2;
    paramString1 = new String(paramArrayOfByte);
    com.tencent.mm.sdk.platformtools.ab.d("C2Java", "notifyNewSpeedTestReport origin cookie: " + paramString1 + ", origin size : " + paramArrayOfByte.length + ", covert cookie size " + localcfx.xpR.pW.length);
    try
    {
      paramArrayOfByte = localcfx.toByteArray();
      com.tencent.mm.network.ab.anD().post(new MMLogic.4(paramArrayOfByte));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ab.e("C2Java", "notifyNewSpeedTestReport :%s", new Object[] { bo.l(paramArrayOfByte) });
    }
  }
  
  private static void onDisasterNodeNotify(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMDisasterInfoHandle", "onDisasterNodeNotify:\n".concat(String.valueOf(paramString)));
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new StringReader(paramString));
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", new Object[] { bo.l(paramString) });
        return;
      }
      int i = localXmlPullParser.next();
      if ("host".equals(localXmlPullParser.getName()))
      {
        localArrayList.add(localXmlPullParser.nextText());
        while (i == 1)
        {
          paramString = localArrayList.iterator();
          while (paramString.hasNext()) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMDisasterInfoHandle", "host ".concat(String.valueOf((String)paramString.next())));
          }
          u.ak(localArrayList);
          return;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  private static void onOOBNotify(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ab.i("C2Java", "onOOBNotify:".concat(String.valueOf(paramString)));
    if (com.tencent.mm.network.ab.anH() == null)
    {
      Assert.assertTrue(false);
      return;
    }
    try
    {
      com.tencent.mm.network.ab.anD().post(new MMLogic.3(paramString));
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ab.e("C2Java", "onOOBNotify :%s", new Object[] { bo.l(paramString) });
    }
  }
  
  public static native void recoverLinkAddrs();
  
  public static native void reportCGIServerError(int paramInt1, int paramInt2);
  
  public static native void reportFailIp(String paramString);
  
  private static void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    totalWifiRecv += paramInt1;
    totalWifiSend += paramInt2;
    totalMobileRecv += paramInt3;
    totalMobileSend += paramInt4;
    int i = totalMobileRecv + totalMobileSend + totalWifiRecv + totalWifiSend;
    com.tencent.mm.network.a.b localb = com.tencent.mm.network.ab.anB().geK;
    com.tencent.mm.sdk.platformtools.ab.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", new Object[] { Long.valueOf(lastReportTime), Long.valueOf(bo.gz(lastReportTime)), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(totalWifiRecv), Integer.valueOf(paramInt2), Integer.valueOf(totalWifiSend), Integer.valueOf(paramInt3), Integer.valueOf(totalMobileRecv), Integer.valueOf(paramInt4), Integer.valueOf(totalMobileSend), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), localb });
    if (localb == null) {}
    while ((i < 102400) && (bo.gz(lastReportTime) < 30L)) {
      return;
    }
    lastReportTime = bo.aox();
    paramInt1 = totalWifiRecv;
    totalWifiRecv = 0;
    paramInt2 = totalWifiSend;
    totalWifiSend = 0;
    paramInt3 = totalMobileRecv;
    totalMobileRecv = 0;
    paramInt4 = totalMobileSend;
    totalMobileSend = 0;
    try
    {
      com.tencent.mm.network.ab.anD().post(new MMLogic.2(localb, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ab.e("C2Java", "reportFlowData :%s", new Object[] { bo.l(localThrowable) });
    }
  }
  
  public static void reportStat(MMLogic.ReportInfo paramReportInfo)
  {
    try
    {
      com.tencent.mm.network.ab.anD().post(new MMLogic.1(paramReportInfo));
      return;
    }
    catch (Exception paramReportInfo) {}
  }
  
  public static native void saveAuthLongIPs(String paramString, String[] paramArrayOfString);
  
  public static native void saveAuthPorts(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native void saveAuthShortIPs(String paramString, String[] paramArrayOfString);
  
  public static native void setDebugIP(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public static native void setMmtlsCtrlInfo(boolean paramBoolean);
  
  public static native void setNewDnsDebugHost(String paramString1, String paramString2);
  
  public static native void uploadFile(String paramString1, String paramString2, String paramString3);
  
  public static native void uploadLog(int[] paramArrayOfInt, boolean paramBoolean, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.mm.MMLogic
 * JD-Core Version:    0.7.0.1
 */