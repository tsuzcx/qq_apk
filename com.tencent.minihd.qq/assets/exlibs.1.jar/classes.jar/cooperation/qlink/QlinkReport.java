package cooperation.qlink;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QlinkReport
{
  public static final String a = "actNbFileContactScan";
  public static final String b = "actNbFileContactArbitrate";
  public static final String c = "actNbFileFileSend";
  public static final String d = "actNbFileFileRecv";
  public static final String e = "actNbFileChannelDetect";
  private static final String f = "QlinkReport";
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 8: 
      return 8;
    }
    return 257;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QlAndQQInterface.ReportNbFileContactArbitrateInfo paramReportNbFileContactArbitrateInfo)
  {
    long l2 = 0L;
    if ((paramQQAppInterface == null) || (paramReportNbFileContactArbitrateInfo == null))
    {
      QLog.e("QlinkReport", 1, "[QLINK]-QQ reportNbFileContactArbitrate -> param=null");
      return;
    }
    if (0L == paramReportNbFileContactArbitrateInfo.startTime) {
      paramReportNbFileContactArbitrateInfo.startTime = System.currentTimeMillis();
    }
    long l1;
    if (paramReportNbFileContactArbitrateInfo.startTime < 1L)
    {
      l1 = 0L;
      if (l1 >= 0L) {
        break label217;
      }
      l1 = l2;
    }
    label217:
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramReportNbFileContactArbitrateInfo.param_failCode));
      if (100 != paramReportNbFileContactArbitrateInfo.param_result) {
        localHashMap.put("param_result", String.valueOf(paramReportNbFileContactArbitrateInfo.param_result));
      }
      localHashMap.put("param_errMsg", String.valueOf(paramReportNbFileContactArbitrateInfo.param_errMsg));
      localHashMap.put("param_source", String.valueOf(paramReportNbFileContactArbitrateInfo.param_source));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actNbFileContactArbitrate", paramReportNbFileContactArbitrateInfo.eResult, l1, paramReportNbFileContactArbitrateInfo.rpSize, localHashMap, paramReportNbFileContactArbitrateInfo.reserved);
      QLog.i("QlinkReport", 1, "[QLINK]-QQ [QL_REPORT][" + paramReportNbFileContactArbitrateInfo._id + "] reportNbFileContactArbitrate -> " + paramReportNbFileContactArbitrateInfo.toString());
      return;
      l1 = System.currentTimeMillis() - paramReportNbFileContactArbitrateInfo.startTime;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QlAndQQInterface.ReportNbFileContactScanInfo paramReportNbFileContactScanInfo)
  {
    long l2 = 0L;
    if ((paramQQAppInterface == null) || (paramReportNbFileContactScanInfo == null))
    {
      QLog.e("QlinkReport", 1, "[QLINK]-QQ reportNbFileContactScan -> param=null");
      return;
    }
    if (0L == paramReportNbFileContactScanInfo.startTime) {
      paramReportNbFileContactScanInfo.startTime = System.currentTimeMillis();
    }
    long l1;
    if (paramReportNbFileContactScanInfo.startTime < 1L)
    {
      l1 = 0L;
      if (l1 >= 0L) {
        break label313;
      }
      l1 = l2;
    }
    label313:
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_method", String.valueOf(paramReportNbFileContactScanInfo.param_method));
      localHashMap.put("param_FailCode", String.valueOf(paramReportNbFileContactScanInfo.param_failCode));
      localHashMap.put("param_sid", String.valueOf(paramReportNbFileContactScanInfo.param_sid));
      localHashMap.put("param_result", String.valueOf(paramReportNbFileContactScanInfo.param_result));
      localHashMap.put("param_errMsg", String.valueOf(paramReportNbFileContactScanInfo.param_errMsg));
      localHashMap.put("param_count", String.valueOf(paramReportNbFileContactScanInfo.param_count));
      localHashMap.put("param_count_onenet", String.valueOf(paramReportNbFileContactScanInfo.param_onenetCount));
      localHashMap.put("param_count_aphost", String.valueOf(paramReportNbFileContactScanInfo.param_crApCount));
      localHashMap.put("param_count_apclient", String.valueOf(paramReportNbFileContactScanInfo.param_connApCount));
      localHashMap.put("param_count_fromnb", String.valueOf(paramReportNbFileContactScanInfo.param_count_fromnb));
      localHashMap.put("param_count_fromsvr", String.valueOf(paramReportNbFileContactScanInfo.param_count_fromsvr));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actNbFileContactScan", paramReportNbFileContactScanInfo.eResult, l1, paramReportNbFileContactScanInfo.rpSize, localHashMap, paramReportNbFileContactScanInfo.reserved);
      QLog.i("QlinkReport", 1, "[QLINK]-QQ [QL_REPORT][" + paramReportNbFileContactScanInfo._id + "] reportNbFileContactScan -> " + paramReportNbFileContactScanInfo.toString());
      return;
      l1 = System.currentTimeMillis() - paramReportNbFileContactScanInfo.startTime;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QlAndQQInterface.ReportNbFileFileRecvInfo paramReportNbFileFileRecvInfo)
  {
    long l2 = 0L;
    if ((paramQQAppInterface == null) || (paramReportNbFileFileRecvInfo == null))
    {
      QLog.e("QlinkReport", 1, "[QLINK]-QQ reportNbFileFileRecv -> param=null");
      return;
    }
    if (0L == paramReportNbFileFileRecvInfo.startTime) {
      paramReportNbFileFileRecvInfo.startTime = System.currentTimeMillis();
    }
    long l1;
    if (paramReportNbFileFileRecvInfo.startTime < 1L)
    {
      l1 = 0L;
      if (l1 >= 0L) {
        break label401;
      }
      l1 = l2;
    }
    label401:
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramReportNbFileFileRecvInfo.param_failCode));
      localHashMap.put("param_source", String.valueOf(paramReportNbFileFileRecvInfo.param_source));
      localHashMap.put("param_fsizeo", String.valueOf(paramReportNbFileFileRecvInfo.param_fileSize));
      localHashMap.put("param_filename", String.valueOf(paramReportNbFileFileRecvInfo.param_fileName));
      localHashMap.put("param_errMsg", String.valueOf(paramReportNbFileFileRecvInfo.param_errMsg));
      localHashMap.put("param_error_ext", String.valueOf(paramReportNbFileFileRecvInfo.param_exErrCode));
      localHashMap.put("param_uuid", "qfile-" + paramReportNbFileFileRecvInfo.fromUin + "-" + paramReportNbFileFileRecvInfo.sessionid);
      localHashMap.put("param_speed", String.valueOf(paramReportNbFileFileRecvInfo.param_speed));
      localHashMap.put("param_speed_in", String.valueOf(paramReportNbFileFileRecvInfo.param_speed_in));
      localHashMap.put("param_speed_out", String.valueOf(paramReportNbFileFileRecvInfo.param_speed_out));
      if (paramReportNbFileFileRecvInfo.etinfo != null)
      {
        localHashMap.put("param_apowner", String.valueOf(paramReportNbFileFileRecvInfo.etinfo.apOwner));
        localHashMap.put("param_local_abs", paramReportNbFileFileRecvInfo.etinfo.localAbs);
        localHashMap.put("param_peer_abs", paramReportNbFileFileRecvInfo.etinfo.peerAbs);
        localHashMap.put("param_peer_os", String.valueOf(paramReportNbFileFileRecvInfo.etinfo.peerOs));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actNbFileFileRecv", paramReportNbFileFileRecvInfo.eResult, l1, paramReportNbFileFileRecvInfo.rpSize, localHashMap, paramReportNbFileFileRecvInfo.reserved);
      QLog.i("QlinkReport", 1, "[QLINK]-QQ [QL_REPORT][" + paramReportNbFileFileRecvInfo._id + "] reportNbFileFileRecv -> " + paramReportNbFileFileRecvInfo.toString());
      return;
      l1 = System.currentTimeMillis() - paramReportNbFileFileRecvInfo.startTime;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QlAndQQInterface.ReportNbFileFileSendInfo paramReportNbFileFileSendInfo)
  {
    long l2 = 0L;
    if ((paramQQAppInterface == null) || (paramReportNbFileFileSendInfo == null))
    {
      QLog.e("QlinkReport", 1, "[QLINK]-QQ reportNbFileFileSend -> param=null");
      return;
    }
    if (0L == paramReportNbFileFileSendInfo.startTime) {
      paramReportNbFileFileSendInfo.startTime = System.currentTimeMillis();
    }
    long l1;
    if (paramReportNbFileFileSendInfo.startTime < 1L)
    {
      l1 = 0L;
      if (l1 >= 0L) {
        break label368;
      }
      l1 = l2;
    }
    label368:
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramReportNbFileFileSendInfo.param_failCode));
      localHashMap.put("param_source", String.valueOf(paramReportNbFileFileSendInfo.param_source));
      localHashMap.put("param_fsizeo", String.valueOf(paramReportNbFileFileSendInfo.param_fileSize));
      localHashMap.put("param_filename", String.valueOf(paramReportNbFileFileSendInfo.param_fileName));
      localHashMap.put("param_errMsg", String.valueOf(paramReportNbFileFileSendInfo.param_errMsg));
      localHashMap.put("param_error_ext", String.valueOf(paramReportNbFileFileSendInfo.param_exErrCode));
      localHashMap.put("param_speed_in", String.valueOf(paramReportNbFileFileSendInfo.param_speed_in));
      localHashMap.put("param_speed_out", String.valueOf(paramReportNbFileFileSendInfo.param_speed_out));
      if (paramReportNbFileFileSendInfo.param_ssid != null) {
        localHashMap.put("param_ssid", String.valueOf(paramReportNbFileFileSendInfo.param_ssid));
      }
      if (paramReportNbFileFileSendInfo.etinfo != null)
      {
        localHashMap.put("param_apowner", String.valueOf(paramReportNbFileFileSendInfo.etinfo.apOwner));
        localHashMap.put("param_local_abs", paramReportNbFileFileSendInfo.etinfo.localAbs);
        localHashMap.put("param_peer_abs", paramReportNbFileFileSendInfo.etinfo.peerAbs);
        localHashMap.put("param_peer_os", String.valueOf(paramReportNbFileFileSendInfo.etinfo.peerOs));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actNbFileFileSend", paramReportNbFileFileSendInfo.eResult, l1, paramReportNbFileFileSendInfo.rpSize, localHashMap, paramReportNbFileFileSendInfo.reserved);
      QLog.i("QlinkReport", 1, "[QLINK]-QQ [QL_REPORT][" + paramReportNbFileFileSendInfo._id + "] reportNbFileFileSend -> " + paramReportNbFileFileSendInfo.toString());
      return;
      l1 = System.currentTimeMillis() - paramReportNbFileFileSendInfo.startTime;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkReport
 * JD-Core Version:    0.7.0.1
 */