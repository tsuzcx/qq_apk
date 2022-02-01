package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.widget.TraceUtils;

public class Step
  implements Runnable
{
  public static final int A = 25;
  public static final int B = 26;
  public static final int C = 27;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "STEP_GROUP", "STEP_TRY_LOAD_DEX", "STEP_NAME_PROCESS", "STEP_SET_SPLASH", "STEP_WEBP", "STEP_PERMISSION_STORAGEANDPHONE", "STEP_DO_LOAD_DEX", "STEP_NEW_RUNTIME", "STEP_LOAD_DATA", "STEP_MEMORY_CACHE", "STEP_OLD_ONCREATE", "STEP_START_SERVICE", "STEP_INIT_SKIN", "STEP_URL_DRAWABLE", "STEP_UPDATE", "STEP_RDM", "STEP_MANAGE_THREAD", "STEP_INIT_LEAKINSPECTOR", "STEP_LOAD_UI", "STEP_LOAD_OTHER", "STEP_MORE_DATA", "STEP_QZPRELOAD", "STEP_START_SERVICE_LITE", "STEP_START_SERVICE_LITE_CMP", "STEP_UPDATE_BUBBLE", "STEP_UPDATE_AVSO", "STEP_SET_PLUGIN", "STEP_UPDATE_PLUGIN_VERSION" };
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 15;
  public static final int r = 16;
  public static final int s = 17;
  public static final int t = 18;
  public static final int u = 19;
  public static final int v = 20;
  public static final int w = 21;
  public static final int x = 22;
  public static final int y = 23;
  public static final int z = 24;
  protected int D;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public StartupDirector a;
  private int[] jdField_a_of_type_ArrayOfInt;
  protected String b;
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean a()
  {
    if (this.D == 0)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i2 = arrayOfInt.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (!Step.AmStepFactory.b(arrayOfInt[i1], this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, null).c()) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public final boolean c()
  {
    long l1 = 0L;
    if (StartupDirector.e)
    {
      l1 = SystemClock.uptimeMillis();
      TraceUtils.a(this.b);
    }
    boolean bool = a();
    if (StartupDirector.e)
    {
      TraceUtils.a();
      Log.i("AutoMonitor", this.b + ", cost=" + (SystemClock.uptimeMillis() - l1) + " results: " + bool);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(this.jdField_a_of_type_Int, Boolean.valueOf(bool)).sendToTarget();
    }
    return bool;
  }
  
  public void run()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step
 * JD-Core Version:    0.7.0.1
 */