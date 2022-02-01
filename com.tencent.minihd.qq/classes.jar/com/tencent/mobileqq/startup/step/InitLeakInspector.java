package com.tencent.mobileqq.startup.step;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.memoryleak.LeakInspector;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jvt;

public class InitLeakInspector
  extends Step
{
  public static final String a = "LeakInspector";
  
  private static void b(String paramString, WeakReference paramWeakReference)
  {
    if ((!AppSetting.j) && (BaseActivity.sTopActivity != null))
    {
      paramWeakReference = new Intent(BaseActivity.sTopActivity, ShareDumpMemoryActivity.class);
      paramWeakReference.putExtra("showWarningDialog", true);
      paramWeakReference.putExtra("suspiciousName", paramString);
      BaseActivity.sTopActivity.startActivity(paramWeakReference);
    }
  }
  
  protected boolean a()
  {
    if (1 != BaseApplicationImpl.g) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "InitLeakInspector");
    }
    LeakInspector.a(ThreadManager.b(), new jvt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitLeakInspector
 * JD-Core Version:    0.7.0.1
 */