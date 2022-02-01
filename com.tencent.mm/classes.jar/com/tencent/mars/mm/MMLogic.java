package com.tencent.mars.mm;

import android.util.Xml;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.af;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.w;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
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
  static final List<Integer> payCgis = Arrays.asList(new Integer[] { Integer.valueOf(385), Integer.valueOf(386), Integer.valueOf(387), Integer.valueOf(388), Integer.valueOf(389), Integer.valueOf(390), Integer.valueOf(391), Integer.valueOf(392), Integer.valueOf(393), Integer.valueOf(394), Integer.valueOf(395), Integer.valueOf(396), Integer.valueOf(397), Integer.valueOf(398), Integer.valueOf(399), Integer.valueOf(400), Integer.valueOf(401), Integer.valueOf(402), Integer.valueOf(403), Integer.valueOf(404), Integer.valueOf(405), Integer.valueOf(406), Integer.valueOf(410), Integer.valueOf(421), Integer.valueOf(461), Integer.valueOf(462), Integer.valueOf(463), Integer.valueOf(464), Integer.valueOf(465), Integer.valueOf(466), Integer.valueOf(467), Integer.valueOf(468), Integer.valueOf(469), Integer.valueOf(470), Integer.valueOf(471), Integer.valueOf(472), Integer.valueOf(473), Integer.valueOf(474), Integer.valueOf(475), Integer.valueOf(476), Integer.valueOf(477), Integer.valueOf(478), Integer.valueOf(479), Integer.valueOf(495), Integer.valueOf(496), Integer.valueOf(497), Integer.valueOf(498), Integer.valueOf(508), Integer.valueOf(509), Integer.valueOf(514), Integer.valueOf(524), Integer.valueOf(525), Integer.valueOf(526), Integer.valueOf(534), Integer.valueOf(565), Integer.valueOf(566), Integer.valueOf(567), Integer.valueOf(568), Integer.valueOf(569), Integer.valueOf(570), Integer.valueOf(571), Integer.valueOf(573), Integer.valueOf(580), Integer.valueOf(583), Integer.valueOf(584), Integer.valueOf(585), Integer.valueOf(586), Integer.valueOf(587), Integer.valueOf(588), Integer.valueOf(589), Integer.valueOf(590), Integer.valueOf(591), Integer.valueOf(592), Integer.valueOf(593), Integer.valueOf(600), Integer.valueOf(606), Integer.valueOf(609), Integer.valueOf(621), Integer.valueOf(732), Integer.valueOf(844), Integer.valueOf(859), Integer.valueOf(1002), Integer.valueOf(1019), Integer.valueOf(1109), Integer.valueOf(1120), Integer.valueOf(1211), Integer.valueOf(1230), Integer.valueOf(1241), Integer.valueOf(1256), Integer.valueOf(1257), Integer.valueOf(1259), Integer.valueOf(1273), Integer.valueOf(1274), Integer.valueOf(1275), Integer.valueOf(1276), Integer.valueOf(1280), Integer.valueOf(1281), Integer.valueOf(1283), Integer.valueOf(1301), Integer.valueOf(1304), Integer.valueOf(1305), Integer.valueOf(1317), Integer.valueOf(1318), Integer.valueOf(1321), Integer.valueOf(1323), Integer.valueOf(1324), Integer.valueOf(1335), Integer.valueOf(1336), Integer.valueOf(1338), Integer.valueOf(1340), Integer.valueOf(1344), Integer.valueOf(1348), Integer.valueOf(1349), Integer.valueOf(1370), Integer.valueOf(1371), Integer.valueOf(1376), Integer.valueOf(1378), Integer.valueOf(1380), Integer.valueOf(1384), Integer.valueOf(1385), Integer.valueOf(1386), Integer.valueOf(1395), Integer.valueOf(1398), Integer.valueOf(1399), Integer.valueOf(1477), Integer.valueOf(1488), Integer.valueOf(1495), Integer.valueOf(1501), Integer.valueOf(1502), Integer.valueOf(1503), Integer.valueOf(1504), Integer.valueOf(1505), Integer.valueOf(1506), Integer.valueOf(1507), Integer.valueOf(1508), Integer.valueOf(1509), Integer.valueOf(1510), Integer.valueOf(1511), Integer.valueOf(1512), Integer.valueOf(1513), Integer.valueOf(1514), Integer.valueOf(1515), Integer.valueOf(1516), Integer.valueOf(1517), Integer.valueOf(1520), Integer.valueOf(1525), Integer.valueOf(1527), Integer.valueOf(1529), Integer.valueOf(1530), Integer.valueOf(1531), Integer.valueOf(1535), Integer.valueOf(1536), Integer.valueOf(1537), Integer.valueOf(1540), Integer.valueOf(1542), Integer.valueOf(1543), Integer.valueOf(1544), Integer.valueOf(1545), Integer.valueOf(1551), Integer.valueOf(1552), Integer.valueOf(1554), Integer.valueOf(1555), Integer.valueOf(1556), Integer.valueOf(1558), Integer.valueOf(1559), Integer.valueOf(1560), Integer.valueOf(1561), Integer.valueOf(1562), Integer.valueOf(1563), Integer.valueOf(1564), Integer.valueOf(1565), Integer.valueOf(1566), Integer.valueOf(1568), Integer.valueOf(1569), Integer.valueOf(1570), Integer.valueOf(1571), Integer.valueOf(1572), Integer.valueOf(1573), Integer.valueOf(1574), Integer.valueOf(1575), Integer.valueOf(1577), Integer.valueOf(1579), Integer.valueOf(1580), Integer.valueOf(1581), Integer.valueOf(1582), Integer.valueOf(1584), Integer.valueOf(1585), Integer.valueOf(1586), Integer.valueOf(1588), Integer.valueOf(1589), Integer.valueOf(1590), Integer.valueOf(1591), Integer.valueOf(1592), Integer.valueOf(1593), Integer.valueOf(1594), Integer.valueOf(1595), Integer.valueOf(1596), Integer.valueOf(1597), Integer.valueOf(1598), Integer.valueOf(1599), Integer.valueOf(1600), Integer.valueOf(1601), Integer.valueOf(1602), Integer.valueOf(1603), Integer.valueOf(1604), Integer.valueOf(1605), Integer.valueOf(1606), Integer.valueOf(1607), Integer.valueOf(1608), Integer.valueOf(1610), Integer.valueOf(1612), Integer.valueOf(1613), Integer.valueOf(1614), Integer.valueOf(1616), Integer.valueOf(1617), Integer.valueOf(1618), Integer.valueOf(1622), Integer.valueOf(1623), Integer.valueOf(1624), Integer.valueOf(1625), Integer.valueOf(1628), Integer.valueOf(1629), Integer.valueOf(1630), Integer.valueOf(1631), Integer.valueOf(1633), Integer.valueOf(1638), Integer.valueOf(1639), Integer.valueOf(1640), Integer.valueOf(1641), Integer.valueOf(1643), Integer.valueOf(1644), Integer.valueOf(1645), Integer.valueOf(1647), Integer.valueOf(1648), Integer.valueOf(1649), Integer.valueOf(1650), Integer.valueOf(1652), Integer.valueOf(1653), Integer.valueOf(1654), Integer.valueOf(1655), Integer.valueOf(1656), Integer.valueOf(1659), Integer.valueOf(1663), Integer.valueOf(1664), Integer.valueOf(1665), Integer.valueOf(1666), Integer.valueOf(1667), Integer.valueOf(1668), Integer.valueOf(1669), Integer.valueOf(1672), Integer.valueOf(1674), Integer.valueOf(1675), Integer.valueOf(1676), Integer.valueOf(1679), Integer.valueOf(1680), Integer.valueOf(1682), Integer.valueOf(1684), Integer.valueOf(1685), Integer.valueOf(1686), Integer.valueOf(1688), Integer.valueOf(1689), Integer.valueOf(1691), Integer.valueOf(1692), Integer.valueOf(1694), Integer.valueOf(1695), Integer.valueOf(1697), Integer.valueOf(1698), Integer.valueOf(1699), Integer.valueOf(1724), Integer.valueOf(1725), Integer.valueOf(1735), Integer.valueOf(1736), Integer.valueOf(1737), Integer.valueOf(1742), Integer.valueOf(1752), Integer.valueOf(1753), Integer.valueOf(1754), Integer.valueOf(1767), Integer.valueOf(1768), Integer.valueOf(1769), Integer.valueOf(1770), Integer.valueOf(1773), Integer.valueOf(1779), Integer.valueOf(1782), Integer.valueOf(1786), Integer.valueOf(1800), Integer.valueOf(1805), Integer.valueOf(1809), Integer.valueOf(1811), Integer.valueOf(1813), Integer.valueOf(1820), Integer.valueOf(1827), Integer.valueOf(1830), Integer.valueOf(1836), Integer.valueOf(1837), Integer.valueOf(1855), Integer.valueOf(1859), Integer.valueOf(1867), Integer.valueOf(1878), Integer.valueOf(1888), Integer.valueOf(1891), Integer.valueOf(1903), Integer.valueOf(1904), Integer.valueOf(1906), Integer.valueOf(1907), Integer.valueOf(1914), Integer.valueOf(1916), Integer.valueOf(1917), Integer.valueOf(1922), Integer.valueOf(1923), Integer.valueOf(1930), Integer.valueOf(1950), Integer.valueOf(1953), Integer.valueOf(1958), Integer.valueOf(1960), Integer.valueOf(1963), Integer.valueOf(1964), Integer.valueOf(1965), Integer.valueOf(1966), Integer.valueOf(1967), Integer.valueOf(1970), Integer.valueOf(1971), Integer.valueOf(1972), Integer.valueOf(1973), Integer.valueOf(1976), Integer.valueOf(1978), Integer.valueOf(1979), Integer.valueOf(1981), Integer.valueOf(1983), Integer.valueOf(1984), Integer.valueOf(1985), Integer.valueOf(1986), Integer.valueOf(1987), Integer.valueOf(1988), Integer.valueOf(1990), Integer.valueOf(1992), Integer.valueOf(1993), Integer.valueOf(1997), Integer.valueOf(1999), Integer.valueOf(2501), Integer.valueOf(2504), Integer.valueOf(2505), Integer.valueOf(2506), Integer.valueOf(2507), Integer.valueOf(2508), Integer.valueOf(2512), Integer.valueOf(2514), Integer.valueOf(2515), Integer.valueOf(2516), Integer.valueOf(2519), Integer.valueOf(2520), Integer.valueOf(2527), Integer.valueOf(2529), Integer.valueOf(2532), Integer.valueOf(2533), Integer.valueOf(2541), Integer.valueOf(2542), Integer.valueOf(2544), Integer.valueOf(2545), Integer.valueOf(2547), Integer.valueOf(2549), Integer.valueOf(2551), Integer.valueOf(2553), Integer.valueOf(2554), Integer.valueOf(2556), Integer.valueOf(2557), Integer.valueOf(2561), Integer.valueOf(2562), Integer.valueOf(2565), Integer.valueOf(2567), Integer.valueOf(2568), Integer.valueOf(2570), Integer.valueOf(2573), Integer.valueOf(2576), Integer.valueOf(2581), Integer.valueOf(2584), Integer.valueOf(2585), Integer.valueOf(2589), Integer.valueOf(2590), Integer.valueOf(2595), Integer.valueOf(2598), Integer.valueOf(2607), Integer.valueOf(2609), Integer.valueOf(2612), Integer.valueOf(2613), Integer.valueOf(2614), Integer.valueOf(2615), Integer.valueOf(2616), Integer.valueOf(2618), Integer.valueOf(2620), Integer.valueOf(2621), Integer.valueOf(2622), Integer.valueOf(2626), Integer.valueOf(2628), Integer.valueOf(2629), Integer.valueOf(2630), Integer.valueOf(2632), Integer.valueOf(2633), Integer.valueOf(2635), Integer.valueOf(2642), Integer.valueOf(2652), Integer.valueOf(2654), Integer.valueOf(2655), Integer.valueOf(2658), Integer.valueOf(2659), Integer.valueOf(2661), Integer.valueOf(2662), Integer.valueOf(2663), Integer.valueOf(2665), Integer.valueOf(2666), Integer.valueOf(2668), Integer.valueOf(2671), Integer.valueOf(2672), Integer.valueOf(2673), Integer.valueOf(2675), Integer.valueOf(2677), Integer.valueOf(2680), Integer.valueOf(2682), Integer.valueOf(2685), Integer.valueOf(2686), Integer.valueOf(2687), Integer.valueOf(2689), Integer.valueOf(2693), Integer.valueOf(2694), Integer.valueOf(2696), Integer.valueOf(2697), Integer.valueOf(2699), Integer.valueOf(2702), Integer.valueOf(2704), Integer.valueOf(2705), Integer.valueOf(2708), Integer.valueOf(2713), Integer.valueOf(2714), Integer.valueOf(2715), Integer.valueOf(2719), Integer.valueOf(2720), Integer.valueOf(2722), Integer.valueOf(2724), Integer.valueOf(2725), Integer.valueOf(2726), Integer.valueOf(2728), Integer.valueOf(2730), Integer.valueOf(2732), Integer.valueOf(2736), Integer.valueOf(2737), Integer.valueOf(2739), Integer.valueOf(2740), Integer.valueOf(2741), Integer.valueOf(2742), Integer.valueOf(2745), Integer.valueOf(2750), Integer.valueOf(2752), Integer.valueOf(2753), Integer.valueOf(2755), Integer.valueOf(2756), Integer.valueOf(2760), Integer.valueOf(2764), Integer.valueOf(2765), Integer.valueOf(2767), Integer.valueOf(2773), Integer.valueOf(2774), Integer.valueOf(2780), Integer.valueOf(2783), Integer.valueOf(2784), Integer.valueOf(2786), Integer.valueOf(2791), Integer.valueOf(2796), Integer.valueOf(2797), Integer.valueOf(2798), Integer.valueOf(2800), Integer.valueOf(2801), Integer.valueOf(2803), Integer.valueOf(2806), Integer.valueOf(2807), Integer.valueOf(2811), Integer.valueOf(2814), Integer.valueOf(2815), Integer.valueOf(2817), Integer.valueOf(2820), Integer.valueOf(2821), Integer.valueOf(2823), Integer.valueOf(2824), Integer.valueOf(2825), Integer.valueOf(2826), Integer.valueOf(2828), Integer.valueOf(2840), Integer.valueOf(2841), Integer.valueOf(2844), Integer.valueOf(2845), Integer.valueOf(2847), Integer.valueOf(2848), Integer.valueOf(2849), Integer.valueOf(2850), Integer.valueOf(2851), Integer.valueOf(2852), Integer.valueOf(2853), Integer.valueOf(2856), Integer.valueOf(2858), Integer.valueOf(2860), Integer.valueOf(2861), Integer.valueOf(2862), Integer.valueOf(2863), Integer.valueOf(2867), Integer.valueOf(2868), Integer.valueOf(2870), Integer.valueOf(2871), Integer.valueOf(2872), Integer.valueOf(2876), Integer.valueOf(2878), Integer.valueOf(2880), Integer.valueOf(2882), Integer.valueOf(2886), Integer.valueOf(2887), Integer.valueOf(2888), Integer.valueOf(2892), Integer.valueOf(2894), Integer.valueOf(2896), Integer.valueOf(2901), Integer.valueOf(2907), Integer.valueOf(2910), Integer.valueOf(2911), Integer.valueOf(2916), Integer.valueOf(2923), Integer.valueOf(2924), Integer.valueOf(2925), Integer.valueOf(2926), Integer.valueOf(2927), Integer.valueOf(2928), Integer.valueOf(2929), Integer.valueOf(2930), Integer.valueOf(2931), Integer.valueOf(2935), Integer.valueOf(2938), Integer.valueOf(2939), Integer.valueOf(2941), Integer.valueOf(2952), Integer.valueOf(2956), Integer.valueOf(2958), Integer.valueOf(2960), Integer.valueOf(2961), Integer.valueOf(2969), Integer.valueOf(2970), Integer.valueOf(2971), Integer.valueOf(2976), Integer.valueOf(2980), Integer.valueOf(2983), Integer.valueOf(2984), Integer.valueOf(2987), Integer.valueOf(2990), Integer.valueOf(2992), Integer.valueOf(2993), Integer.valueOf(2996), Integer.valueOf(2997), Integer.valueOf(3505), Integer.valueOf(3521), Integer.valueOf(3555), Integer.valueOf(3570), Integer.valueOf(3572), Integer.valueOf(3573), Integer.valueOf(3584), Integer.valueOf(3591), Integer.valueOf(3634), Integer.valueOf(3651), Integer.valueOf(3665), Integer.valueOf(3671), Integer.valueOf(3708), Integer.valueOf(3730), Integer.valueOf(3766), Integer.valueOf(3768), Integer.valueOf(3774), Integer.valueOf(3780), Integer.valueOf(3781), Integer.valueOf(3795), Integer.valueOf(3801), Integer.valueOf(3857), Integer.valueOf(3858), Integer.valueOf(3885), Integer.valueOf(3920), Integer.valueOf(3962), Integer.valueOf(3989) });
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
      String str = LocaleUtil.getApplicationLanguage();
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
  
  private static int getLogIdSubType(long paramLong, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramLong == 11108L) {}
    try
    {
      int k = Integer.parseInt(paramString);
      i = j;
      if (payCgis.contains(Integer.valueOf(k)))
      {
        Log.d("C2Java", "gettype 1");
        i = 1;
      }
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static native NetworkIdInfo getNetworkId(String paramString);
  
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
      if (Util.isOverseasUser(MMApplicationContext.getContext())) {
        return "HK";
      }
      return "CN";
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static int getXAgreementId()
  {
    Log.d("zyzhang", "getXAgreementId");
    int i = WeChatBrands.UserInfo.xagreementId;
    Log.i("C2Java", "MMLogic get xagreement id %s", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  private static void notifyNewSpeedTestReport(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, int paramInt6, int paramInt7)
  {
    if (af.bkn() == null)
    {
      Log.e("C2Java", "notifyNewSpeedTestReport failed");
      return;
    }
    ecb localecb = new ecb();
    localecb.Ncf = paramInt1;
    localecb.Ncg = paramInt2;
    localecb.Nch = paramInt3;
    localecb.Nci = paramInt4;
    localecb.Mpw = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    localecb.Ncd = "";
    localecb.Ncc = "";
    localecb.Nce = "";
    if (paramInt7 == 3) {
      localecb.Ncc = "dual";
    }
    ebz localebz1 = new ebz();
    ebz localebz2 = new ebz();
    localebz1.ip = paramString1;
    localebz1.port = paramInt5;
    localebz2.ip = paramString2;
    localebz2.port = paramInt6;
    localecb.Nck = localebz1;
    localecb.Ncj = localebz2;
    paramString1 = new String(paramArrayOfByte);
    Log.d("C2Java", "notifyNewSpeedTestReport origin cookie: " + paramString1 + ", origin size : " + paramArrayOfByte.length + ", covert cookie size " + localecb.Mpw.zy.length);
    try
    {
      paramArrayOfByte = localecb.toByteArray();
      af.bkj().post(new Runnable()
      {
        public final void run()
        {
          af.bkn().j(271, this.val$cookieByte);
        }
      });
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("C2Java", "notifyNewSpeedTestReport :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
    }
  }
  
  private static void onDisasterNodeNotify(String paramString)
  {
    Log.i("MicroMsg.MMDisasterInfoHandle", "onDisasterNodeNotify:\n".concat(String.valueOf(paramString)));
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
        Log.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
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
            Log.i("MicroMsg.MMDisasterInfoHandle", "host ".concat(String.valueOf((String)paramString.next())));
          }
          w.aL(localArrayList);
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
    Log.i("C2Java", "onOOBNotify:".concat(String.valueOf(paramString)));
    if (af.bkn() == null)
    {
      Assert.assertTrue(false);
      return;
    }
    try
    {
      af.bkj().post(new Runnable()
      {
        public final void run()
        {
          ad localad = af.bkn();
          if (Util.isNullOrNil(this.val$_info)) {}
          for (byte[] arrayOfByte = null;; arrayOfByte = this.val$_info.getBytes())
          {
            localad.j(268369923, arrayOfByte);
            return;
          }
        }
      });
      return;
    }
    catch (Exception paramString)
    {
      Log.e("C2Java", "onOOBNotify :%s", new Object[] { Util.stackTraceToString(paramString) });
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
    com.tencent.mm.network.a.b localb = af.bkh().jFR;
    Log.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", new Object[] { Long.valueOf(lastReportTime), Long.valueOf(Util.secondsToNow(lastReportTime)), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(totalWifiRecv), Integer.valueOf(paramInt2), Integer.valueOf(totalWifiSend), Integer.valueOf(paramInt3), Integer.valueOf(totalMobileRecv), Integer.valueOf(paramInt4), Integer.valueOf(totalMobileSend), Boolean.valueOf(CrashReportFactory.foreground), localb });
    if (localb == null) {}
    while ((i < 102400) && (Util.secondsToNow(lastReportTime) < 30L)) {
      return;
    }
    lastReportTime = Util.nowSecond();
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
      af.bkj().post(new Runnable()
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
            Log.e("C2Java", "reportFlowData :%s", new Object[] { Util.stackTraceToString(localThrowable) });
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("C2Java", "reportFlowData :%s", new Object[] { Util.stackTraceToString(localThrowable) });
    }
  }
  
  public static void reportStat(ReportInfo paramReportInfo)
  {
    try
    {
      af.bkj().post(new Runnable()
      {
        public final void run()
        {
          int i = MMLogic.getJavaActionId(this.val$item.actionId);
          if (i == 0)
          {
            Log.e("C2Java", "ActionId Can not convert");
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
  
  public static native void setDebugHost(String paramString);
  
  public static native void setDebugIP(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public static native void setMmtlsCtrlInfo(boolean paramBoolean);
  
  public static native void setNetworkId(String paramString1, String paramString2, String paramString3, int paramInt);
  
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
  
  public static class NetworkIdInfo
  {
    public byte[] ctx;
    public byte[] networkId;
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