package com.tencent.mobileqq.app.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;

public class UpgradeController$AutoDownloadInWifiController
  extends BroadcastReceiver
{
  private static final String jdField_a_of_type_JavaLangString = "android.net.conn.CONNECTIVITY_CHANGE";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
  
  public UpgradeController$AutoDownloadInWifiController(UpgradeController paramUpgradeController) {}
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 29	android/content/IntentFilter
    //   5: dup
    //   6: invokespecial 30	android/content/IntentFilter:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc 8
    //   13: invokevirtual 34	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 14	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController	Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   20: invokestatic 39	com/tencent/mobileqq/app/upgrade/UpgradeController:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeController;)Landroid/app/Application;
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 45	android/app/Application:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   28: pop
    //   29: aload_0
    //   30: getfield 24	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   33: invokestatic 51	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   36: iconst_1
    //   37: if_icmpne +11 -> 48
    //   40: aload_0
    //   41: getfield 14	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController	Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   44: iconst_1
    //   45: invokevirtual 55	com/tencent/mobileqq/app/upgrade/UpgradeController:c	(Z)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: goto -28 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	AutoDownloadInWifiController
    //   9	16	1	localIntentFilter	android.content.IntentFilter
    //   51	4	1	localObject	java.lang.Object
    //   56	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	29	51	finally
    //   29	48	51	finally
    //   2	29	56	java/lang/Exception
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController	Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   6: invokestatic 39	com/tencent/mobileqq/app/upgrade/UpgradeController:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeController;)Landroid/app/Application;
    //   9: aload_0
    //   10: invokevirtual 59	android/app/Application:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   13: aload_0
    //   14: getfield 14	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController	Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   17: invokevirtual 61	com/tencent/mobileqq/app/upgrade/UpgradeController:c	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: goto -16 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	AutoDownloadInWifiController
    //   23	4	1	localObject	java.lang.Object
    //   28	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	13	23	finally
    //   13	20	23	finally
    //   2	13	28	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      int i;
      try
      {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
        {
          i = NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext);
          if (i != 0) {
            continue;
          }
          if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController)) {
            this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.e();
          }
        }
        return;
        if (i != 1) {
          break label87;
        }
        if (!UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.c(true);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.d();
      }
      finally {}
      continue;
      label87:
      if ((i == 0) && (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController))) {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeController.AutoDownloadInWifiController
 * JD-Core Version:    0.7.0.1
 */