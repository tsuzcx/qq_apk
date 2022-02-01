package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class HwStatisticMgr
{
  public static final String KEY_CONNCNT = "ConnCnt";
  public static final String KEY_CONNFAILCNT = "ConnFailCnt";
  public static final String KEY_CONNSUCCCNT = "ConnSuccCnt";
  public static final String KEY_CTIMECOST = "param_cost";
  public static final String KEY_IPINFO = "connDetail";
  public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHChannel";
  public static long sLastReportTime = -1L;
  
  public static void doReportConnection(int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, ArrayList<EndPoint> paramArrayList, long paramLong)
  {
    HashMap localHashMap;
    StringBuilder localStringBuilder;
    if (sLastReportTime == -1L)
    {
      sLastReportTime = SystemClock.uptimeMillis();
      sLastReportTime = SystemClock.uptimeMillis();
      localHashMap = new HashMap();
      localHashMap.put("ConnCnt", String.valueOf(paramInt2));
      localHashMap.put("ConnSuccCnt", String.valueOf(paramInt3));
      localHashMap.put("ConnFailCnt", String.valueOf(paramInt4));
      localHashMap.put("param_cost", String.valueOf(paramLong));
      if (paramArrayList.size() <= 0) {
        break label268;
      }
      localStringBuilder = new StringBuilder();
      paramInt2 = 0;
      label101:
      if (paramInt2 >= paramArrayList.size()) {
        break label255;
      }
      if (paramInt2 <= 0) {
        break label249;
      }
      localStringBuilder.append(";");
    }
    label249:
    while (paramInt2 <= 20)
    {
      EndPoint localEndPoint = (EndPoint)paramArrayList.get(paramInt2);
      if (localEndPoint != null) {
        localStringBuilder.append(localEndPoint.connIndex + "_" + localEndPoint.ipIndex + "_" + localEndPoint.host + "_" + localEndPoint.port + "_" + localEndPoint.connResult + "_" + localEndPoint.cost);
      }
      paramInt2 += 1;
      break label101;
      if (SystemClock.uptimeMillis() - sLastReportTime >= 480000L) {
        break;
      }
      return;
    }
    label255:
    localHashMap.put("connDetail", localStringBuilder.toString());
    label268:
    report(paramInt1, paramString, "actBDHChannel", paramBoolean, paramLong, 0L, localHashMap);
    BdhLogUtil.LogEvent("HwStatisticMgr", "REPORT event= actBDHChannel value= " + localHashMap.toString());
  }
  
  public static void report(int paramInt, String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    paramString1 = new RdmReq();
    paramString1.eventName = paramString2;
    paramString1.elapse = paramLong1;
    paramString1.size = paramLong2;
    paramString1.isSucceed = paramBoolean;
    paramString1.isRealTime = true;
    paramString1.isMerge = false;
    paramString1.params = paramHashMap;
    try
    {
      paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString1);
      paramString1.setAppId(paramInt);
      paramString1.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwStatisticMgr
 * JD-Core Version:    0.7.0.1
 */