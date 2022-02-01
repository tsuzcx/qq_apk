package com.tencent.mars.mm;

import android.util.Xml;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.u;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  
  public static native void forceUseV6(boolean paramBoolean);
  
  private static String getCurLanguage()
  {
    try
    {
      String str = com.tencent.mm.sdk.platformtools.ad.fom();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static int getHostByName(String paramString, List<String> paramList)
  {
    long l1 = System.currentTimeMillis();
    GetDnsReturn localGetDnsReturn = new GetDnsReturn(null);
    getHostIps(paramString, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    paramList = new ReportInfo();
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
  
  private static native void getHostIps(String paramString, GetDnsReturn paramGetDnsReturn);
  
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
  
  private static native void getSnsIps(boolean paramBoolean, GetDnsReturn paramGetDnsReturn);
  
  public static int getSnsIpsForScene(List<String> paramList, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    GetDnsReturn localGetDnsReturn = new GetDnsReturn(null);
    getSnsIps(paramBoolean, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    ReportInfo localReportInfo = new ReportInfo();
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
    GetDnsReturn localGetDnsReturn = new GetDnsReturn(null);
    getSnsIpsWithHostName(paramString, paramBoolean, localGetDnsReturn);
    int i = 0;
    while (i < localGetDnsReturn.length)
    {
      paramList.add(localGetDnsReturn.aryIps[i]);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    ReportInfo localReportInfo = new ReportInfo();
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
  
  private static native void getSnsIpsWithHostName(String paramString, boolean paramBoolean, GetDnsReturn paramGetDnsReturn);
  
  private static String getUserIDCLocale()
  {
    try
    {
      if (bu.jq(ak.getContext())) {
        return "HK";
      }
      return "CN";
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static void notifyNewSpeedTestReport(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, int paramInt6, int paramInt7)
  {
    if (com.tencent.mm.network.ad.aPM() == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("C2Java", "notifyNewSpeedTestReport failed");
      return;
    }
    dir localdir = new dir();
    localdir.HQn = paramInt1;
    localdir.HQo = paramInt2;
    localdir.HQp = paramInt3;
    localdir.HQq = paramInt4;
    localdir.Hjt = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    localdir.HQl = "";
    localdir.HQk = "";
    localdir.HQm = "";
    if (paramInt7 == 3) {
      localdir.HQk = "dual";
    }
    dip localdip1 = new dip();
    dip localdip2 = new dip();
    localdip1.ip = paramString1;
    localdip1.port = paramInt5;
    localdip2.ip = paramString2;
    localdip2.port = paramInt6;
    localdir.HQs = localdip1;
    localdir.HQr = localdip2;
    paramString1 = new String(paramArrayOfByte);
    com.tencent.mm.sdk.platformtools.ae.d("C2Java", "notifyNewSpeedTestReport origin cookie: " + paramString1 + ", origin size : " + paramArrayOfByte.length + ", covert cookie size " + localdir.Hjt.zr.length);
    try
    {
      paramArrayOfByte = localdir.toByteArray();
      com.tencent.mm.network.ad.aPI().post(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.network.ad.aPM().j(271, this.val$cookieByte);
        }
      });
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ae.e("C2Java", "notifyNewSpeedTestReport :%s", new Object[] { bu.o(paramArrayOfByte) });
    }
  }
  
  private static void onDisasterNodeNotify(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMDisasterInfoHandle", "onDisasterNodeNotify:\n".concat(String.valueOf(paramString)));
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", new Object[] { bu.o(paramString) });
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
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMDisasterInfoHandle", "host ".concat(String.valueOf((String)paramString.next())));
          }
          u.aD(localArrayList);
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
    com.tencent.mm.sdk.platformtools.ae.i("C2Java", "onOOBNotify:".concat(String.valueOf(paramString)));
    if (com.tencent.mm.network.ad.aPM() == null)
    {
      Assert.assertTrue(false);
      return;
    }
    try
    {
      com.tencent.mm.network.ad.aPI().post(new Runnable()
      {
        public final void run()
        {
          ab localab = com.tencent.mm.network.ad.aPM();
          if (bu.isNullOrNil(this.val$_info)) {}
          for (byte[] arrayOfByte = null;; arrayOfByte = this.val$_info.getBytes())
          {
            localab.j(268369923, arrayOfByte);
            return;
          }
        }
      });
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ae.e("C2Java", "onOOBNotify :%s", new Object[] { bu.o(paramString) });
    }
  }
  
  public static native void recoverLinkAddrs();
  
  public static native void reportCGIServerError(int paramInt1, int paramInt2);
  
  public static native void reportFailIp(String paramString);
  
  private static void reportFlow(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    totalWifiRecv += paramInt1;
    totalWifiSend += paramInt2;
    totalMobileRecv += paramInt3;
    totalMobileSend += paramInt4;
    int i = totalMobileRecv + totalMobileSend + totalWifiRecv + totalWifiSend;
    com.tencent.mm.network.a.b localb = com.tencent.mm.network.ad.aPG().iJn;
    com.tencent.mm.sdk.platformtools.ae.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", new Object[] { Long.valueOf(lastReportTime), Long.valueOf(bu.rZ(lastReportTime)), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(totalWifiRecv), Integer.valueOf(paramInt2), Integer.valueOf(totalWifiSend), Integer.valueOf(paramInt3), Integer.valueOf(totalMobileRecv), Integer.valueOf(paramInt4), Integer.valueOf(totalMobileSend), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), localb });
    if (localb == null) {}
    while ((i < 102400) && (bu.rZ(lastReportTime) < 30L)) {
      return;
    }
    lastReportTime = bu.aRi();
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
      com.tencent.mm.network.ad.aPI().post(new Runnable()
      {
        public final void run()
        {
          try
          {
            this.val$monitor.u(paramInt1, paramInt2, paramInt3, paramInt4);
            return;
          }
          catch (Throwable localThrowable)
          {
            com.tencent.mm.sdk.platformtools.ae.e("C2Java", "reportFlowData :%s", new Object[] { bu.o(localThrowable) });
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ae.e("C2Java", "reportFlowData :%s", new Object[] { bu.o(localThrowable) });
    }
  }
  
  public static void reportStat(ReportInfo paramReportInfo)
  {
    try
    {
      com.tencent.mm.network.ad.aPI().post(new Runnable()
      {
        public final void run()
        {
          int i = MMLogic.getJavaActionId(this.val$item.actionId);
          if (i == 0)
          {
            com.tencent.mm.sdk.platformtools.ae.e("C2Java", "ActionId Can not convert");
            return;
          }
          this.val$item.actionId = i;
        }
      });
      return;
    }
    catch (Exception paramReportInfo) {}
  }
  
  public static native void reportV6Status(boolean paramBoolean);
  
  public static native void saveAuthLongIPs(String paramString, String[] paramArrayOfString);
  
  public static native void saveAuthLongList(Object paramObject, int[] paramArrayOfInt);
  
  public static native void saveAuthPorts(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native void saveAuthShortIPs(String paramString, String[] paramArrayOfString);
  
  public static native void saveAuthShortList(Object paramObject, int[] paramArrayOfInt);
  
  public static native void setDebugIP(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public static native void setMmtlsCtrlInfo(boolean paramBoolean);
  
  public static native void setNewDnsDebugHost(String paramString1, String paramString2);
  
  public static native void switchProcessActiveState(boolean paramBoolean);
  
  public static native void uploadFile(String paramString1, String paramString2, String paramString3);
  
  public static native void uploadLog(int[] paramArrayOfInt, boolean paramBoolean, String paramString1, String paramString2);
  
  static class GetDnsReturn
  {
    public String[] aryIps = new String[50];
    public int length;
    public int type = 0;
  }
  
  public static class ReportInfo
  {
    public long actionId = 0L;
    public long beginTime = 0L;
    public String clientIp = "";
    public long connCostTime = 0L;
    public long connTotalCostTime = 0L;
    public long dnsCostTime = 0L;
    public int dnsErrType = 0;
    public String dnsSvrIp = "";
    public int endFlag = 0;
    public int endStep = 0;
    public long endTime = 0L;
    public int errCode = 0;
    public int errType = 0;
    public long expand1 = 0L;
    public long expand2 = 0L;
    public String extraInfo = "";
    public long firstPkgTime = 0L;
    public String host = "";
    public String ip = "";
    public int ipType = 0;
    public boolean isSocket = false;
    public int localIp = 0;
    public long netSignal = 0L;
    public int netType = 0;
    public int newNetType = 0;
    public long newdnsCostTime = 0L;
    public int newdnsErrCode = 0;
    public int newdnsErrType = 0;
    public int port = 0;
    public long recvSize = 0L;
    public int refTime1 = 0;
    public int refTime2 = 0;
    public int refTime3 = 0;
    public int retryCount = 0;
    public long rtType = 0L;
    public long sendSize = 0L;
    public int subNetType = 0;
    public int usedIpIndex = 0;
    
    public String toString()
    {
      return String.format("actionId:%d, rtType:%d, begin:%d, end:%d, cost:%d, ip:%s, port:%d, isSocket:%b, netType:%d, ipType:%d, sendSize:%d, recvSize:%d, errType:%d, errCode:%d, netSignal:%d, retryCount:%d, expand1:%d, clientip:%s, expand2:%d, newNetType:%d, subNetType:%d, extraInfo:%s, host:%s, endStep:%d, endFlag:%d", new Object[] { Long.valueOf(this.actionId), Long.valueOf(this.rtType), Long.valueOf(this.beginTime), Long.valueOf(this.endTime), Long.valueOf(this.endTime - this.beginTime), this.ip, Integer.valueOf(this.port), Boolean.valueOf(this.isSocket), Integer.valueOf(this.netType), Integer.valueOf(this.ipType), Long.valueOf(this.sendSize), Long.valueOf(this.recvSize), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.netSignal), Integer.valueOf(this.retryCount), Long.valueOf(this.expand1), this.clientIp, Long.valueOf(this.expand2), Integer.valueOf(this.newNetType), Integer.valueOf(this.subNetType), this.extraInfo, this.host, Integer.valueOf(this.endStep), Integer.valueOf(this.endFlag) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.mm.MMLogic
 * JD-Core Version:    0.7.0.1
 */