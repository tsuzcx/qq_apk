package com.tencent.qav.monitor;

import android.content.Context;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import ljr;
import ljs;
import lju;

public class PhoneStatusMonitor
{
  private static final String jdField_a_of_type_JavaLangString = "PhoneStatusMonitor";
  private Context jdField_a_of_type_AndroidContentContext;
  private PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  private PhoneStatusMonitor.PhoneStatusListener jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor$PhoneStatusListener;
  private ljs jdField_a_of_type_Ljs;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor$PhoneStatusListener = paramPhoneStatusListener;
    b();
    d();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidTelephonyPhoneStateListener == null) {
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new lju(this, null);
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      ThreadManager.b(new ljr(this));
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidTelephonyPhoneStateListener != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ljs == null) {
      this.jdField_a_of_type_Ljs = new ljs(this, null);
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PHONE_STATE");
      localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
      localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
      localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
      localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ljs, localIntentFilter);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Ljs != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ljs);
      this.jdField_a_of_type_Ljs = null;
    }
  }
  
  public void a()
  {
    c();
    e();
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.monitor.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */