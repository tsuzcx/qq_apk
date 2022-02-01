package com.tencent.mobileqq.memoryleak;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import jgf;
import jgg;

public class LeakInspector
{
  private static int jdField_a_of_type_Int = 100;
  private static Instrumentation jdField_a_of_type_AndroidAppInstrumentation;
  private static LeakInspector jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector;
  public static final String a = "LeakInspector";
  public static boolean a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LeakInspector.InspectorListener jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector$InspectorListener;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidAppInstrumentation = null;
  }
  
  private LeakInspector(Handler paramHandler, LeakInspector.InspectorListener paramInspectorListener)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector$InspectorListener = paramInspectorListener;
  }
  
  public static LeakInspector a()
  {
    return jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector;
  }
  
  private static String a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() != null)) {
      return String.format("%s@%x", new Object[] { paramObject.getClass().getSimpleName(), Integer.valueOf(paramObject.hashCode()) });
    }
    return "[noclass]";
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "afterOnDestroy " + paramActivity.getClass().getSimpleName());
    }
    ActivityLeakSolution.a(paramActivity);
    ActivityLeakSolution.b(paramActivity);
    ActivityLeakSolution.a(paramActivity);
  }
  
  public static void a(Handler paramHandler, LeakInspector.InspectorListener paramInspectorListener)
  {
    if (jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector != null) {
      throw new RuntimeException("Oh man, this only can be called once.");
    }
    jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector = new LeakInspector(paramHandler, paramInspectorListener);
  }
  
  public static void a(Object paramObject)
  {
    a(paramObject, a(paramObject));
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector == null) {
      throw new RuntimeException("Please call initInspector before this");
    }
    if (jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector.jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector$InspectorListener == null) {
      throw new RuntimeException("Please init a listener first!");
    }
    jdField_a_of_type_ComTencentMobileqqMemoryleakLeakInspector.b(paramObject, paramString);
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      throw new RuntimeException("Oh man, this only can be called once.");
    }
    try
    {
      localObject2 = BaseApplicationImpl.a;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        BaseApplicationImpl.b();
        localObject2 = BaseApplicationImpl.a;
        localObject1 = localObject2;
        if (localObject2 == null) {
          throw new IllegalStateException("Failed to get sCurrentActivityThread");
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, "startActivityInspect exception", localException);
      }
      return false;
    }
    Object localObject2 = localException.getClass().getDeclaredField("mInstrumentation");
    ((Field)localObject2).setAccessible(true);
    Object localObject3 = (Instrumentation)((Field)localObject2).get(localException);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localException.getClass().getDeclaredMethod("getInstrumentation", null);
      ((Method)localObject2).setAccessible(true);
      localObject3 = (Instrumentation)((Method)localObject2).invoke(localException, null);
      localObject2 = localObject3;
      if (localObject3 == null) {
        throw new IllegalStateException("Failed to get mInstrumentation.");
      }
    }
    if (!Instrumentation.class.equals(localObject2.getClass()))
    {
      localObject3 = localObject2.getClass().getName();
      if ((localObject3 != null) && (!((String)localObject3).contains("com.lbe.security"))) {
        throw new IllegalStateException("Not an Instrumentation instance. Maybe something is modified in this system.");
      }
    }
    if (localObject2.getClass().equals(jgg.class)) {
      throw new RuntimeException("Buddy you already hacked the system.");
    }
    jdField_a_of_type_AndroidAppInstrumentation = (Instrumentation)localObject2;
    localObject2 = localException.getClass().getDeclaredField("mInstrumentation");
    ((Field)localObject2).setAccessible(true);
    ((Field)localObject2).set(localException, new jgg(null));
    jdField_a_of_type_Boolean = true;
    return true;
  }
  
  private void b(Object paramObject, String paramString)
  {
    paramObject = new jgf(this, new WeakReference(paramObject), paramString, 0);
    this.jdField_a_of_type_AndroidOsHandler.post(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.memoryleak.LeakInspector
 * JD-Core Version:    0.7.0.1
 */