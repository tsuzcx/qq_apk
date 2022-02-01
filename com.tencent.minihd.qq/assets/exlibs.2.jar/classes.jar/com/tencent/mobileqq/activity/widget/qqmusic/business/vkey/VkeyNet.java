package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.expressinfo.ExpressInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference.VKeyPreference;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference.VKeyPreferenceManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.VkeyRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import hdf;
import hdg;

public class VkeyNet
  extends Vkey
{
  private static final int jdField_a_of_type_Int = 5;
  private static final String jdField_a_of_type_JavaLangString = "VkeyNet";
  private static final long jdField_b_of_type_Long = 300000L;
  private Handler jdField_a_of_type_AndroidOsHandler = new hdf(this, Looper.getMainLooper());
  private VkeyPair jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair = new VkeyPair();
  private ExpressInfo jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyExpressinfoExpressInfo;
  private OnResultListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hdg(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private volatile String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String d = "";
  
  public VkeyNet()
  {
    d();
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.b(SessionManager.a().a().d());
    VkeyRequest localVkeyRequest = new VkeyRequest();
    try
    {
      this.jdField_c_of_type_Int = Network.a(localVkeyRequest, this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      return true;
    }
    catch (Exception localException)
    {
      MLog.a("VkeyNet", localException);
    }
    return false;
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (d())
      {
        MLog.c("zhangsg", "Get HQ vkey----3-2:isDBCanUse");
        VKeyPreference localVKeyPreference = VKeyPreferenceManager.a().a();
        if (localVKeyPreference != null)
        {
          MLog.c("zhangsg", "Get HQ vkey----3-3:vKeyPreference != null");
          this.jdField_a_of_type_Long = localVKeyPreference.a();
          this.jdField_b_of_type_JavaLangString = localVKeyPreference.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.a();
          String str2 = localVKeyPreference.b();
          String str1 = VkeyPair.a(str2, "vkey");
          str2 = VkeyPair.a(str2, "guid");
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.b(str2);
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.a(str1);
          this.jdField_c_of_type_JavaLangString = localVKeyPreference.c();
          localVKeyPreference.a();
          localVKeyPreference.b();
          MLog.c("VKEY", "initNetVKey by DB:" + this.jdField_a_of_type_Long);
          return;
        }
      }
      e();
      return;
    }
  }
  
  private boolean d()
  {
    VKeyPreference localVKeyPreference = VKeyPreferenceManager.a().a();
    if (localVKeyPreference != null)
    {
      long l = localVKeyPreference.a();
      if (l > 0L)
      {
        l = System.currentTimeMillis() - l;
        if ((l > 0L) && (l < 6900000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    if ((ApnManager.a()) && (c())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
      }
      MLog.c("VKEY", "initNetVKey:" + this.jdField_a_of_type_Long);
      return;
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        if (this.jdField_c_of_type_Int >= 0) {
          Network.a(this.jdField_c_of_type_Int);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          MLog.a("VkeyNet", localException);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 300000L) {}
    }
    else {
      while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 7200000L) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.toString();
      return str;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      VKeyPreference localVKeyPreference = VKeyPreferenceManager.a().a();
      if (localVKeyPreference != null) {
        localVKeyPreference.a();
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.d = paramString;
      e();
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int != -1;
  }
  
  public String c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      return str;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      e();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyNet
 * JD-Core Version:    0.7.0.1
 */