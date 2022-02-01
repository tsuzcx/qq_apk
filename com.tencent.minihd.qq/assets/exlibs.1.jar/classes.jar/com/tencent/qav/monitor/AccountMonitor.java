package com.tencent.qav.monitor;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qav.log.AVLog;
import ljq;

public class AccountMonitor
{
  private static final String jdField_a_of_type_JavaLangString = "AccountMonitor";
  private Context jdField_a_of_type_AndroidContentContext;
  private ljq jdField_a_of_type_Ljq;
  private boolean jdField_a_of_type_Boolean;
  
  public AccountMonitor(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    AVLog.e("AccountMonitor", String.format("register mHasRegisterQQAccount=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (!this.jdField_a_of_type_Boolean)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_Ljq = new ljq(null);
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ljq, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ljq);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.monitor.AccountMonitor
 * JD-Core Version:    0.7.0.1
 */