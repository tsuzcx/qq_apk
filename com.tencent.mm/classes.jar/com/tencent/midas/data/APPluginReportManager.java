package com.tencent.midas.data;

import android.text.TextUtils;
import com.pay.http.APBaseHttpAns;
import com.pay.http.APNetworkManager;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class APPluginReportManager
{
  public static final String MIDASPLUGIN_ENTER_ABILITY = "sdk.plugin.enter.ability";
  public static final String MIDASPLUGIN_FORMAT_APKLOAD_ERROR = "sdk.loadapk_error";
  public static final String MIDASPLUGIN_FORMAT_APKLOAD_FAIL = "sdk.loadapk_fail";
  public static final String MIDASPLUGIN_FORMAT_TIME = "sdk.plugin.time";
  public static final String MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON = "sdk.plugin.pureH5.error.reason";
  public static final String MIDASPLUGIN_NAME_LAUNCH_ERROR = "sdk.plugin.launch.error";
  public static final String MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS = "sdk.plugin.init.getFileListFromAssets.time";
  public static final String MIDASPLUGIN_TIMENAME_INIT = "timename.init";
  public static final String MIDASPLUGIN_TIMENAME_INIT_KERNEL = "sdk.plugin.init.kernel.totaltime";
  public static final String MIDASPLUGIN_TIMENAME_INIT_TOTALTIME = "sdk.plugin.init.totaltime";
  public static final String MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS = "sdk.plugin.init.installFromAssets.time";
  public static final String MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL = "sdk.plugin.init.installFromLocal.time";
  public static final String MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE = "sdk.plugin.init.isNeedAssetsUpdate.time";
  public static final String MIDASPLUGIN_TIMENAME_IS_NEED_LOCAL_UPDATE = "sdk.plugin.init.isNeedLocalUpdate.time";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHABILITY = "timename.launchability";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHINFO = "timename.launchinfo";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHNET = "timename.launchnet";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHPAY = "timename.launchpay";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT = "sdk.plugin.launchPay.wait.init.time";
  public static final String MIDASPLUGIN_TIMENAME_LAUNCHWEB = "timename.launchweb";
  public static final String MIDASPLUGIN_TIMENAME_LOAD_DEX = "sdk.plugin.init.loadDex.time";
  public static final String MIDASPLUGIN_TIMENAME_PLUGIN_VALID = "sdk.plugin.init.pluginvalid.time";
  public static final String MIDASPLUGIN_TIMENAME_READ_FILE_FROM_ASSETS = "sdk.plugin.init.readFileFromAssets.time";
  public static final String MIDASPLUGIN_TIMENAME_UNZIP_SO = "sdk.plugin.init.unzip.so.time";
  public static final String MIDASPLUGIN_TIMENAME_WRITE_FILE_TO_DATA = "sdk.plugin.init.writeFileToData.time";
  public static final String MIDASPLUGIN_WEBPAGE_BACK = "sdk.plugin.webpage.back";
  public static final String MIDASPLUGIN_WEBPAGE_CLOSE = "sdk.plugin.webpage.close";
  public static final String MIDASPLUGIN_WEBPAGE_HEAD_INIT = "sdk.plugin.webpage.head.init";
  public static final String MIDASPLUGIN_WEBPAGE_INIT = "sdk.plugin.webpage.init";
  public static final String MIDASPLUGIN_WEBPAGE_KEYBACK = "sdk.plugin.webpage.keyback";
  public static final String MIDASPLUGIN_WEBPAGE_REFRESH = "sdk.plugin.webpage.refresh";
  public static final String MIDASPLUGIN_WEBPAGE_SYSTEM = "sdk.plugin.webpage.system";
  public static final String MIDASPLUGIN_WEBPAGE_WEBCLOSE = "sdk.plugin.webpage.webclose";
  public static final String MIDASPLUGIN_WEBPAGE_X5 = "sdk.plugin.webpage.x5";
  public static final String MIDASPLUGIN_WEBPAGE_X5_BACK = "sdk.plugin.webpage.x5.back";
  public static final String MIDASPLUGIN_WEBPAGE_X5_CLOSE = "sdk.plugin.webpage.x5.close";
  public static final String MIDASPLUGIN_WEBPAGE_X5_HEAD_INIT = "sdk.plugin.webpage.x5.head.init";
  public static final String MIDASPLUGIN_WEBPAGE_X5_KEYBACK = "sdk.plugin.webpage.x5.keyback";
  public static final String MIDASPLUGIN_WEBPAGE_X5_REFRESH = "sdk.plugin.webpage.x5.refresh";
  public static final String MIDASPLUGIN_X5_INIT = "sdk.plugin.x5.init";
  public static final String MIDASPLUGIN_X5_INIT_FAIL = "sdk.plugin.x5.init.fail";
  public static final String MIDASPLUGIN_X5_INIT_SUCCESS = "sdk.plugin.x5.init.success";
  private static APPluginReportManager gInstance = null;
  ArrayList<APClickStreamParams> initDataReport;
  ArrayList<APClickStreamParams> payDataReport;
  
  private APPluginReportManager()
  {
    AppMethodBeat.i(216997);
    this.initDataReport = null;
    this.payDataReport = null;
    this.initDataReport = new ArrayList();
    this.payDataReport = new ArrayList();
    AppMethodBeat.o(216997);
  }
  
  private String constructTimeReport(String paramString, long paramLong)
  {
    AppMethodBeat.i(217056);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name=");
    localStringBuffer.append(paramString);
    localStringBuffer.append("&");
    localStringBuffer.append("times=");
    localStringBuffer.append(paramLong);
    localStringBuffer.append("&");
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(217056);
    return paramString;
  }
  
  private String getAllReportRecord(ArrayList<APClickStreamParams> paramArrayList)
  {
    AppMethodBeat.i(217043);
    int k = paramArrayList.size();
    if (k <= 0)
    {
      AppMethodBeat.o(217043);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += 1;
      localStringBuffer.append("record" + i + "=");
      localStringBuffer.append(reportParams2Str((APClickStreamParams)paramArrayList.get(i)));
      localStringBuffer.append("&");
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    paramArrayList = new StringBuffer();
    paramArrayList.append("num=");
    paramArrayList.append(j);
    paramArrayList.append("&");
    paramArrayList.append(localStringBuffer.toString());
    localStringBuffer.setLength(0);
    paramArrayList = paramArrayList.toString();
    AppMethodBeat.o(217043);
    return paramArrayList;
  }
  
  public static APPluginReportManager getInstance()
  {
    AppMethodBeat.i(217004);
    APPluginReportManager localAPPluginReportManager = SingletonHolder.instance;
    AppMethodBeat.o(217004);
    return localAPPluginReportManager;
  }
  
  public static void initDataRelease()
  {
    AppMethodBeat.i(217008);
    try
    {
      if (getInstance() != null) {
        getInstance().initDataReport.clear();
      }
      AppMethodBeat.o(217008);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(217008);
    }
  }
  
  private void insertOneRecord(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217033);
    APClickStreamParams localAPClickStreamParams = new APClickStreamParams();
    localAPClickStreamParams.device = ("android_v" + APMidasPayAPI.getMidasPluginVersion());
    localAPClickStreamParams.openid = APPluginDataInterface.singleton().getOpenId();
    localAPClickStreamParams.format = paramString2;
    localAPClickStreamParams.from = paramString3;
    localAPClickStreamParams.offerid = APPluginDataInterface.singleton().getOfferId();
    localAPClickStreamParams.pf = APPluginDataInterface.singleton().getPf();
    localAPClickStreamParams.SessionId = APPluginDataInterface.singleton().getSessionId();
    localAPClickStreamParams.SessionType = APPluginDataInterface.singleton().getSessionType();
    if (!TextUtils.isEmpty(paramString4)) {
      localAPClickStreamParams.extend = APMidasTools.urlEncode(paramString4, 3);
    }
    switch (APPluginDataInterface.singleton().getSaveType())
    {
    default: 
      localAPClickStreamParams.savetype = "game";
    }
    for (;;)
    {
      localAPClickStreamParams.currentTimeMillis = String.valueOf(System.currentTimeMillis());
      if (!paramString1.equals("init")) {
        break;
      }
      APInitData.singleton();
      localAPClickStreamParams.dataId = APInitData.getInitdataCount();
      localAPClickStreamParams.VipFlags = APInitData.singleton().getInitGUID();
      this.initDataReport.add(localAPClickStreamParams);
      AppMethodBeat.o(217033);
      return;
      localAPClickStreamParams.savetype = "game";
      continue;
      localAPClickStreamParams.savetype = "goods";
      continue;
      localAPClickStreamParams.savetype = "acct";
      continue;
      localAPClickStreamParams.savetype = "month";
      continue;
      localAPClickStreamParams.savetype = "subscribe";
    }
    localAPClickStreamParams.dataId = APDataId.getDataId();
    paramString1 = APPluginDataInterface.singleton().getProcessData();
    if (paramString1 != null) {
      localAPClickStreamParams.VipFlags = paramString1.getGuid();
    }
    this.payDataReport.add(localAPClickStreamParams);
    AppMethodBeat.o(217033);
  }
  
  private void invokeAPKReportManager(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject4 = null;
    AppMethodBeat.i(217073);
    try
    {
      Object localObject5 = Class.forName("com.pay.data.report.APDataReportManager");
      if (localObject5 != null) {
        try
        {
          localObject1 = ((Class)localObject5).getDeclaredMethod("getInstance", new Class[0]);
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          try
          {
            for (;;)
            {
              Object localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
              try
              {
                localObject5 = ((Class)localObject5).getMethod("insertData", new Class[] { String.class, Integer.TYPE, String.class, String.class, String.class, String.class });
                localObject4 = localObject5;
              }
              catch (NoSuchMethodException localNoSuchMethodException2)
              {
                for (;;)
                {
                  Object localObject2;
                  Object localObject3;
                  APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + localNoSuchMethodException2.toString());
                }
              }
              try
              {
                localObject4.invoke(localObject1, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, paramString4, paramString5 });
                AppMethodBeat.o(217073);
                return;
              }
              catch (Exception paramString1)
              {
                APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + paramString1.toString());
              }
              localNoSuchMethodException1 = localNoSuchMethodException1;
              APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + localNoSuchMethodException1.toString());
              localObject2 = null;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + localException.toString());
              localObject3 = null;
            }
          }
        }
      }
      AppMethodBeat.o(217073);
    }
    catch (Exception paramString1)
    {
      APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + paramString1.toString());
      AppMethodBeat.o(217073);
      return;
    }
  }
  
  public static void payDataRelease()
  {
    AppMethodBeat.i(217012);
    try
    {
      if (getInstance() != null) {
        getInstance().payDataReport.clear();
      }
      AppMethodBeat.o(217012);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(217012);
    }
  }
  
  private StringBuffer reportParams2Str(APClickStreamParams paramAPClickStreamParams)
  {
    AppMethodBeat.i(217024);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramAPClickStreamParams == null)
    {
      AppMethodBeat.o(217024);
      return localStringBuffer;
    }
    localStringBuffer.append("3=" + paramAPClickStreamParams.openid);
    localStringBuffer.append("|7=0");
    localStringBuffer.append("|13=" + paramAPClickStreamParams.dataId);
    localStringBuffer.append("|24=" + paramAPClickStreamParams.offerid);
    if (!TextUtils.isEmpty(paramAPClickStreamParams.payid)) {
      localStringBuffer.append("|4=" + paramAPClickStreamParams.payid);
    }
    if (!TextUtils.isEmpty(paramAPClickStreamParams.isBindQQ)) {
      localStringBuffer.append("|55=" + paramAPClickStreamParams.isBindQQ);
    }
    localStringBuffer.append("|21=" + paramAPClickStreamParams.format);
    localStringBuffer.append("|26=" + paramAPClickStreamParams.pf);
    if (!TextUtils.isEmpty(paramAPClickStreamParams.token)) {
      localStringBuffer.append("|56=" + paramAPClickStreamParams.token);
    }
    APLog.i("getLogRecord extend pre", paramAPClickStreamParams.extend);
    if (!TextUtils.isEmpty(paramAPClickStreamParams.extend)) {
      localStringBuffer.append("|8=" + paramAPClickStreamParams.extend);
    }
    if (!TextUtils.isEmpty(paramAPClickStreamParams.from)) {
      localStringBuffer.append("|20=" + paramAPClickStreamParams.from);
    }
    if (!TextUtils.isEmpty(paramAPClickStreamParams.savetype)) {
      localStringBuffer.append("|47=" + paramAPClickStreamParams.savetype);
    }
    localStringBuffer.append("|29=" + paramAPClickStreamParams.guid);
    localStringBuffer.append("|31=" + paramAPClickStreamParams.device);
    localStringBuffer.append("|38=" + paramAPClickStreamParams.currentTimeMillis);
    localStringBuffer.append("|34=" + paramAPClickStreamParams.uinTypeFromSvr);
    localStringBuffer.append("|35=" + paramAPClickStreamParams.uinFromSvr);
    localStringBuffer.append("|37=" + paramAPClickStreamParams.SessionId);
    localStringBuffer.append("|43=" + paramAPClickStreamParams.SessionType);
    if (!TextUtils.isEmpty(paramAPClickStreamParams.PayLevel)) {
      localStringBuffer.append("|54=" + paramAPClickStreamParams.PayLevel);
    }
    if (!TextUtils.isEmpty(paramAPClickStreamParams.VipFlags)) {
      localStringBuffer.append("|53=" + paramAPClickStreamParams.VipFlags);
    }
    AppMethodBeat.o(217024);
    return localStringBuffer;
  }
  
  /* Error */
  public void dataReport(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 522
    //   5: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 356
    //   12: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +28 -> 43
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 161	com/tencent/midas/data/APPluginReportManager:initDataReport	Ljava/util/ArrayList;
    //   23: invokespecial 524	com/tencent/midas/data/APPluginReportManager:getAllReportRecord	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +24 -> 55
    //   34: ldc_w 522
    //   37: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 163	com/tencent/midas/data/APPluginReportManager:payDataReport	Ljava/util/ArrayList;
    //   48: invokespecial 524	com/tencent/midas/data/APPluginReportManager:getAllReportRecord	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   51: astore_1
    //   52: goto -25 -> 27
    //   55: invokestatic 529	com/pay/http/APNetworkManager:getInstance	()Lcom/pay/http/APNetworkManager;
    //   58: aload_1
    //   59: new 8	com/tencent/midas/data/APPluginReportManager$2
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 532	com/tencent/midas/data/APPluginReportManager$2:<init>	(Lcom/tencent/midas/data/APPluginReportManager;)V
    //   67: invokevirtual 535	com/pay/http/APNetworkManager:dataReport	(Ljava/lang/String;Lcom/pay/http/IAPHttpAnsObserver;)V
    //   70: ldc_w 522
    //   73: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -36 -> 40
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	APPluginReportManager
    //   0	84	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	27	79	finally
    //   27	40	79	finally
    //   43	52	79	finally
    //   55	76	79	finally
  }
  
  public void initInterfaceInit(String paramString, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(217095);
    APInitData.init();
    APInitData.singleton().setInitGUID(APMidasTools.getUUID());
    APInitData.singleton().setInitInterfaceTime(System.currentTimeMillis());
    APPluginDataInterface.init();
    APPluginDataInterface.singleton().setLaunchInterface(paramString);
    APMidasAnalyzeParams.getInstance().AnalyzeParams(paramAPMidasBaseRequest);
    AppMethodBeat.o(217095);
  }
  
  public void insertData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217128);
    APLog.i("insertTimeData interfaceName=", paramString1 + " format=" + paramString2 + " action=" + paramString3 + " extend=" + paramString4);
    insertOneRecord(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(217128);
  }
  
  public void insertTimeData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217112);
    APLog.i("insertTimeData interfaceName=", paramString1);
    APLog.i("insertTimeData timeName=", paramString2);
    if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId()))
    {
      AppMethodBeat.o(217112);
      return;
    }
    if (paramString1 == "init")
    {
      l = System.currentTimeMillis() - APInitData.singleton().getInitInterfaceTime();
      APLog.i("时耗", "insertTimeData timeName=" + paramString2 + ",initTime:" + l);
      insertOneRecord(paramString1, "sdk.plugin.time", "", constructTimeReport(paramString2, l));
      AppMethodBeat.o(217112);
      return;
    }
    APMultiProcessData localAPMultiProcessData = APPluginDataInterface.singleton().getProcessData();
    long l = 0L;
    if (localAPMultiProcessData != null)
    {
      localAPMultiProcessData = APPluginDataInterface.singleton().getProcessData();
      l = System.currentTimeMillis() - localAPMultiProcessData.getPayInterfaceTime();
    }
    APLog.i("时耗", "insertTimeData timeName=" + paramString2 + ",payTime:" + l);
    insertOneRecord(paramString1, "sdk.plugin.time", "", constructTimeReport(paramString2, l));
    AppMethodBeat.o(217112);
  }
  
  public void insertTimeData(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(217117);
    APLog.d("insertTimeData interfaceName=", paramString1 + " timeName=" + paramString2 + " time=" + String.valueOf(paramLong));
    if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId()))
    {
      AppMethodBeat.o(217117);
      return;
    }
    insertOneRecord(paramString1, "sdk.plugin.time", "", constructTimeReport(paramString2, paramLong));
    AppMethodBeat.o(217117);
  }
  
  public void insertTimeDataEx(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(217123);
    paramLong = APMidasTools.getTimeInterval(paramLong, System.currentTimeMillis());
    APLog.d("insertTimeDataEx", "timeName:" + paramString2 + ",time" + paramLong);
    insertTimeData(paramString1, paramString2, paramLong);
    AppMethodBeat.o(217123);
  }
  
  public void payInterfaceInit(APMidasBaseRequest paramAPMidasBaseRequest, String paramString)
  {
    AppMethodBeat.i(217104);
    APPluginDataInterface.init();
    APPluginDataInterface.singleton().setLaunchInterface(paramString);
    paramString = new APMultiProcessData();
    paramString.setGuid(APMidasTools.getUUID());
    long l = System.currentTimeMillis();
    APLog.i("showFirstPageInsertDB=====", "all:".concat(String.valueOf(l)));
    paramString.setPayInterfaceTime(l);
    if (APInitData.singleton().getInitInterfaceTime() < 1L) {
      paramString.setIntervalTime(0);
    }
    for (;;)
    {
      APPluginDataInterface.singleton().setProcessData(paramString);
      APMidasAnalyzeParams.getInstance().setSaveType(paramAPMidasBaseRequest);
      APMidasAnalyzeParams.getInstance().AnalyzeParams(paramAPMidasBaseRequest);
      AppMethodBeat.o(217104);
      return;
      paramString.setIntervalTime((int)(System.currentTimeMillis() - APInitData.singleton().getInitInterfaceTime()));
    }
  }
  
  public void reportImmediatelyOneRecord(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217138);
    APClickStreamParams localAPClickStreamParams = new APClickStreamParams();
    localAPClickStreamParams.device = ("android_v" + APMidasPayAPI.getMidasPluginVersion());
    localAPClickStreamParams.openid = APPluginDataInterface.singleton().getOpenId();
    localAPClickStreamParams.format = paramString2;
    localAPClickStreamParams.from = "";
    localAPClickStreamParams.offerid = APPluginDataInterface.singleton().getOfferId();
    localAPClickStreamParams.pf = APPluginDataInterface.singleton().getPf();
    localAPClickStreamParams.SessionId = APPluginDataInterface.singleton().getSessionId();
    localAPClickStreamParams.SessionType = APPluginDataInterface.singleton().getSessionType();
    if (!TextUtils.isEmpty(paramString3)) {
      localAPClickStreamParams.extend = APMidasTools.urlEncode(paramString3, 3);
    }
    switch (APPluginDataInterface.singleton().getSaveType())
    {
    default: 
      localAPClickStreamParams.savetype = "game";
      localAPClickStreamParams.currentTimeMillis = String.valueOf(System.currentTimeMillis());
      if (paramString1.equals("init"))
      {
        APInitData.singleton();
        localAPClickStreamParams.dataId = APInitData.getInitdataCount();
        localAPClickStreamParams.VipFlags = APInitData.singleton().getInitGUID();
      }
      break;
    }
    for (;;)
    {
      paramString1 = new ArrayList();
      paramString1.add(localAPClickStreamParams);
      paramString1 = getAllReportRecord(paramString1);
      if (!TextUtils.isEmpty(paramString1)) {
        break label341;
      }
      AppMethodBeat.o(217138);
      return;
      localAPClickStreamParams.savetype = "game";
      break;
      localAPClickStreamParams.savetype = "goods";
      break;
      localAPClickStreamParams.savetype = "acct";
      break;
      localAPClickStreamParams.savetype = "month";
      break;
      localAPClickStreamParams.savetype = "subscribe";
      break;
      localAPClickStreamParams.dataId = APDataId.getDataId();
      paramString1 = APPluginDataInterface.singleton().getProcessData();
      if (paramString1 != null) {
        localAPClickStreamParams.VipFlags = paramString1.getGuid();
      }
    }
    label341:
    APNetworkManager.getInstance().dataReport(paramString1, new IAPHttpAnsObserver()
    {
      public void onError(APBaseHttpAns paramAnonymousAPBaseHttpAns) {}
      
      public void onFinish(APBaseHttpAns paramAnonymousAPBaseHttpAns) {}
      
      public void onStop(APBaseHttpAns paramAnonymousAPBaseHttpAns) {}
    });
    AppMethodBeat.o(217138);
  }
  
  static class SingletonHolder
  {
    private static APPluginReportManager instance;
    
    static
    {
      AppMethodBeat.i(217013);
      instance = new APPluginReportManager(null);
      AppMethodBeat.o(217013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.data.APPluginReportManager
 * JD-Core Version:    0.7.0.1
 */