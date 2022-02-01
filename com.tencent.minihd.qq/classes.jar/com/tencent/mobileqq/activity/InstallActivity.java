package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Handler;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.util.SizeMeasure;
import mqq.app.AppActivity;

public class InstallActivity
  extends AppActivity
  implements Runnable
{
  public static final String a = "NT_AY";
  boolean a = false;
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    SizeMeasure.b(this);
  }
  
  /* Error */
  protected boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 36	mqq/app/AppActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: invokestatic 28	com/tencent/mobileqq/util/SizeMeasure:b	(Landroid/content/Context;)V
    //   10: aload_0
    //   11: invokevirtual 40	com/tencent/mobileqq/activity/InstallActivity:getIntent	()Landroid/content/Intent;
    //   14: ldc 10
    //   16: invokevirtual 46	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   19: checkcast 42	android/content/Intent
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +59 -> 83
    //   27: new 42	android/content/Intent
    //   30: dup
    //   31: aload_0
    //   32: ldc 48
    //   34: invokestatic 54	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   37: invokespecial 57	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc 58
    //   44: invokevirtual 62	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   47: pop
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 66	com/tencent/mobileqq/activity/InstallActivity:startActivity	(Landroid/content/Intent;)V
    //   53: aload_0
    //   54: invokevirtual 69	com/tencent/mobileqq/activity/InstallActivity:finish	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 72	java/lang/ClassNotFoundException:printStackTrace	()V
    //   68: goto -20 -> 48
    //   71: astore_1
    //   72: iconst_m1
    //   73: invokestatic 78	java/lang/System:exit	(I)V
    //   76: goto -19 -> 57
    //   79: astore_2
    //   80: goto -16 -> 64
    //   83: aload_2
    //   84: astore_1
    //   85: goto -37 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	InstallActivity
    //   0	88	1	paramBundle	android.os.Bundle
    //   22	43	2	localObject	java.lang.Object
    //   79	5	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   59	4	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   27	41	59	java/lang/ClassNotFoundException
    //   48	57	71	java/lang/Exception
    //   41	48	79	java/lang/ClassNotFoundException
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      setContentView(new LinearLayout(this));
      label16:
      this.mRuntime = null;
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.a) {
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(this);
    }
    SizeMeasure.b(this);
  }
  
  public void run()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources();
    SetSplash.a(this);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InstallActivity
 * JD-Core Version:    0.7.0.1
 */