package cooperation.qzone.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyService;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mdg;
import mdh;
import mdi;
import mdj;
import mdk;
import mdl;
import mdm;
import mdn;
import mdo;
import mdp;

public class QZoneDistributedAppCtrl
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 0;
  private static QZoneDistributedAppCtrl jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
  public static final String a = "key_desc";
  static final int jdField_b_of_type_Int = 1;
  public static final String b = "key_url";
  static final int jdField_c_of_type_Int = 2;
  public static final String c = "key_trace_baseTime";
  public static final int d = 1;
  private static final long jdField_d_of_type_Long = 1800000L;
  public static final String d = "key_trace_offset";
  public static final int e = 2;
  public static final String e = "qzone_execCmdAction";
  public static final int f = 3;
  private static final String jdField_f_of_type_JavaLangString = "QZoneDistributedAppCtrl";
  public static final int g = 4;
  private static String jdField_g_of_type_JavaLangString;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static int n = 0;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Runnable jdField_a_of_type_JavaLangRunnable = new mdj(this);
  ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  private long jdField_b_of_type_Long = 0L;
  Runnable jdField_b_of_type_JavaLangRunnable = new mdk(this);
  private long jdField_c_of_type_Long = 0L;
  Runnable jdField_c_of_type_JavaLangRunnable = new mdl(this);
  Runnable jdField_d_of_type_JavaLangRunnable;
  Runnable e = new mdn(this);
  Runnable jdField_f_of_type_JavaLangRunnable;
  Runnable jdField_g_of_type_JavaLangRunnable = new mdp(this);
  Runnable h = new mdh(this);
  private Runnable i = new mdi(this);
  
  QZoneDistributedAppCtrl(Context paramContext, String paramString)
  {
    this.d = new mdm(this);
    this.f = new mdo(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "QZoneDistributedAppCtrl constructor");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    jdField_g_of_type_JavaLangString = paramString;
  }
  
  public static QZoneDistributedAppCtrl a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl == null) {
      jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl = new QZoneDistributedAppCtrl(paramContext, paramString);
    }
    return jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
  }
  
  private void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:qzone");
  }
  
  public static void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new mdg(paramString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void b(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i1 = paramControl.jdField_a_of_type_Int;
    switch (i1)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i1);
      }
    case 4: 
      return;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrl", 4, "CMD_CLEAR_AD_FEEDS");
      }
      d();
      return;
    case 2: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrl", 4, "CMD_CLEAR_ALL_FEEDS");
      }
      c();
      return;
    case 3: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrl", 4, "CMD_CLEAR_CACHE");
      }
      e();
      return;
    case 5: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrl", 4, "CMD_CLEAR_CACHE");
      }
      b();
      return;
    case 6: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrl", 4, "CMD_NOTIFY_DIALOG");
      }
      a((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url"));
      return;
    case 7: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "CMD_UPLOAD_DB");
      }
      f();
      return;
    case 8: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "CMD_UPLOAD_ANR");
      }
      g();
      return;
    case 9: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "CMD_UPLOAD_TRACE");
      }
      String str = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_baseTime");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_offset");
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      if (TextUtils.isEmpty(str))
      {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramControl)) {
          break label470;
        }
        this.jdField_b_of_type_Long = 1800000L;
      }
      for (;;)
      {
        for (;;)
        {
          if (this.jdField_c_of_type_Long <= 0L) {
            this.jdField_c_of_type_Long = System.currentTimeMillis();
          }
          if (this.jdField_b_of_type_Long <= 0L) {
            this.jdField_b_of_type_Long = 1800000L;
          }
          this.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + this.jdField_a_of_type_Long + "ms\t offsettime: " + this.jdField_b_of_type_Long + "\t trace endTime: " + this.jdField_c_of_type_Long + "ms");
          }
          i();
          return;
          try
          {
            this.jdField_c_of_type_Long = (Long.valueOf(str).longValue() * 1000L);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
        break;
        try
        {
          label470:
          this.jdField_b_of_type_Long = (Long.valueOf(paramControl).longValue() * 1000L);
        }
        catch (NumberFormatException paramControl)
        {
          paramControl.printStackTrace();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "excel CMD_UPLOAD_LOGCAT");
    }
    h();
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  private void c(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i1 = paramControl.jdField_a_of_type_Int;
    switch (i1)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i1);
      }
    case 5: 
      return;
    }
    paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserDelegationActivity.class);
    localIntent.setFlags(localIntent.getFlags() | 0x10000000);
    localIntent.putExtra("post_data", "");
    localIntent.putExtra("url", paramControl);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramControl));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.d);
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.e);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.f);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_g_of_type_JavaLangRunnable);
  }
  
  private void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.h);
  }
  
  public void a(QZoneDistributedAppCtrl.Control paramControl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "submitCtrl  function");
    }
    if (paramControl != null) {
      b(paramControl);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      b((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl
 * JD-Core Version:    0.7.0.1
 */