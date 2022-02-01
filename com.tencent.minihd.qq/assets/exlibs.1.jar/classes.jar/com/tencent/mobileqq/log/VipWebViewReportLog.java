package com.tencent.mobileqq.log;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebJsInfo;
import com.tencent.protofile.coupon.CouponProto.ReportReq;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import jdk;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipWebViewReportLog
{
  public static int a = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public static final String a;
  static Thread jdField_a_of_type_JavaLangThread = new jdk();
  public static Queue a;
  static Set jdField_a_of_type_JavaUtilSet;
  public static NewIntent a;
  public static boolean a = false;
  public static final int b = 10;
  static String jdField_b_of_type_JavaLangString;
  static boolean jdField_b_of_type_Boolean = false;
  private static int c = 0;
  public static final String c;
  private static int d = 0;
  public static final String d = "config.json";
  private static int e;
  public static String e;
  private static int jdField_f_of_type_Int;
  private static String jdField_f_of_type_JavaLangString;
  private static String g;
  private static String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipWebViewReportLog.class.getSimpleName();
    jdField_f_of_type_JavaLangString = "Dequelock";
    jdField_a_of_type_JavaUtilQueue = new LinkedList();
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidContentContext = null;
    jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    jdField_b_of_type_JavaLangString = "0";
    g = "";
    h = "";
    d = 1;
    jdField_e_of_type_Int = 2;
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_JavaLangString = AppConstants.aG + "WebViewCheck" + File.separator;
    jdField_e_of_type_JavaLangString = null;
  }
  
  public static Set a()
  {
    return jdField_a_of_type_JavaUtilSet;
  }
  
  public static void a()
  {
    int i = 0;
    Object localObject1 = new File(jdField_c_of_type_JavaLangString + "config.json");
    if (((File)localObject1).exists())
    {
      jdField_a_of_type_Int = 0;
      jdField_f_of_type_Int = jdField_e_of_type_Int;
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (localObject1 != null)
        {
          localObject1 = new JSONObject((String)localObject1);
          jdField_a_of_type_Boolean = true;
          jdField_b_of_type_Boolean = true;
          if (((JSONObject)localObject1).has("url_list"))
          {
            localObject1 = ((JSONObject)localObject1).getJSONArray("url_list");
            while (i < ((JSONArray)localObject1).length())
            {
              jdField_a_of_type_JavaUtilSet.add(((JSONArray)localObject1).getString(i));
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        b();
      }
    }
    jdField_a_of_type_Int += 1;
    if (jdField_a_of_type_Int >= 10)
    {
      jdField_f_of_type_Int = jdField_e_of_type_Int;
      b();
      return;
    }
    jdField_f_of_type_Int = d;
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface)
  {
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    jdField_f_of_type_Int = d;
  }
  
  public static void a(PreloadInfoCheckUpdate.WebJsInfo paramWebJsInfo)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!jdField_a_of_type_Boolean) {
      return;
    }
    CouponProto.ReportReq localReportReq = new CouponProto.ReportReq();
    localReportReq.type.set(10006);
    String str = "" + "protocol_ver=" + paramWebJsInfo.head.protocol_ver.get();
    str = str + "&client_plat_id=" + paramWebJsInfo.head.client_plat_id.get();
    str = str + "&client_ver=" + paramWebJsInfo.head.client_ver.get();
    str = str + "&os_ver=" + paramWebJsInfo.head.os_ver.get();
    str = str + "&uin=" + paramWebJsInfo.head.uin.get();
    str = str + "&err_file=" + paramWebJsInfo.err_file.get();
    str = str + "&err_line=" + paramWebJsInfo.err_line.get();
    str = str + "&err_message=" + paramWebJsInfo.err_message.get();
    str = str + "&err_page_url=" + paramWebJsInfo.err_page_url.get();
    paramWebJsInfo = str + "&err_timestamp=" + paramWebJsInfo.err_timestamp.get();
    localReportReq.data.set(paramWebJsInfo);
    if (jdField_a_of_type_MqqAppNewIntent == null)
    {
      jdField_a_of_type_MqqAppNewIntent = new NewIntent(jdField_a_of_type_AndroidContentContext, ProtoServlet.class);
      jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "CouponSvr.report");
    }
    jdField_a_of_type_MqqAppNewIntent.putExtra("data", localReportReq.toByteArray());
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(jdField_a_of_type_MqqAppNewIntent);
  }
  
  public static void a(ConsoleMessage paramConsoleMessage)
  {
    for (;;)
    {
      PreloadInfoCheckUpdate.WebJsInfo localWebJsInfo;
      try
      {
        if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          return;
        }
        if ((jdField_f_of_type_Int == jdField_e_of_type_Int) && (!jdField_a_of_type_Boolean)) {
          break;
        }
        localWebJsInfo = new PreloadInfoCheckUpdate.WebJsInfo();
        localWebJsInfo.head.protocol_ver.set(1);
        localWebJsInfo.head.client_plat_id.set(109);
        localWebJsInfo.head.client_ver.set("5.9.3");
        localWebJsInfo.head.os_ver.set(Build.VERSION.SDK);
        String str = jdField_a_of_type_ComTencentCommonAppAppInterface.a();
        if ((str != null) && (str.length() != 0))
        {
          localWebJsInfo.head.uin.set(Long.parseLong(str));
          if (paramConsoleMessage.sourceId() != null) {
            localWebJsInfo.err_file.set(URLEncoder.encode(paramConsoleMessage.sourceId()));
          }
          localWebJsInfo.err_line.set(String.valueOf(paramConsoleMessage.lineNumber()));
          if (paramConsoleMessage.message() != null) {
            localWebJsInfo.err_message.set(URLEncoder.encode(paramConsoleMessage.message()));
          }
          localWebJsInfo.err_timestamp.set(System.currentTimeMillis());
          if (jdField_e_of_type_JavaLangString != null) {
            localWebJsInfo.err_page_url.set(URLEncoder.encode(jdField_e_of_type_JavaLangString));
          }
          a(localWebJsInfo);
          return;
        }
      }
      catch (Exception paramConsoleMessage)
      {
        paramConsoleMessage.printStackTrace();
        return;
      }
      localWebJsInfo.head.uin.set(0L);
    }
  }
  
  public static void a(String paramString)
  {
    a();
    jdField_e_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  /* Error */
  private static boolean a(PreloadInfoCheckUpdate.WebJsInfo paramWebJsInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 39	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: getstatic 46	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   11: aload_0
    //   12: invokeinterface 359 2 0
    //   17: pop
    //   18: iconst_1
    //   19: istore_1
    //   20: iconst_1
    //   21: istore_2
    //   22: getstatic 39	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   25: invokevirtual 362	java/lang/Object:notify	()V
    //   28: iload_2
    //   29: istore_1
    //   30: aload_3
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: astore_0
    //   35: aload_3
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: astore_0
    //   40: goto -10 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramWebJsInfo	PreloadInfoCheckUpdate.WebJsInfo
    //   1	32	1	bool1	boolean
    //   21	8	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	18	34	finally
    //   22	28	34	finally
    //   30	32	34	finally
    //   35	37	34	finally
    //   8	18	39	java/lang/Exception
    //   22	28	39	java/lang/Exception
  }
  
  public static void b()
  {
    if (jdField_f_of_type_Int == d) {}
    for (;;)
    {
      return;
      if (!jdField_a_of_type_Boolean) {
        synchronized (jdField_f_of_type_JavaLangString)
        {
          jdField_a_of_type_JavaUtilQueue.clear();
          return;
        }
      }
      g = MsfSdkUtils.getProcessName(jdField_a_of_type_AndroidContentContext);
      try
      {
        h = jdField_a_of_type_AndroidContentContext.getPackageName();
        jdField_c_of_type_Int = Process.myPid();
        jdField_a_of_type_JavaLangThread.setName("VipWebViewReportLogWriteThread");
        if (jdField_a_of_type_JavaLangThread.isAlive()) {
          continue;
        }
        jdField_a_of_type_JavaLangThread.start();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h = "unknow";
        }
      }
    }
  }
  
  public static void b(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.VipWebViewReportLog
 * JD-Core Version:    0.7.0.1
 */