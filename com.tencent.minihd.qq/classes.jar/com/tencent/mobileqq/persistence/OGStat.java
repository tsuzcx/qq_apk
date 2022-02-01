package com.tencent.mobileqq.persistence;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import jlf;
import jlg;
import mqq.app.MobileQQ;

public class OGStat
{
  public static OGStat a;
  public static final String a = "actQOrmOper";
  public static final boolean a = true;
  public static final String b = "OGStat";
  public static final boolean b = false;
  public Handler a;
  public StringBuilder a;
  public HashMap a;
  public HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqPersistenceOGStat = new OGStat();
  }
  
  public OGStat()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public static OGStat a()
  {
    jdField_a_of_type_ComTencentMobileqqPersistenceOGStat.b();
    return jdField_a_of_type_ComTencentMobileqqPersistenceOGStat;
  }
  
  public static void a(String paramString)
  {
    Log.d("OGStat", paramString);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler == null) && (TextUtils.equals(BaseApplicationImpl.a().getPackageName(), MobileQQ.processName))) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b());
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new jlf(this, paramString, paramLong));
  }
  
  public String a(Class paramClass)
  {
    try
    {
      paramClass = TableBuilder.a(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return "";
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new jlg(this));
  }
  
  public void a(String paramString, long paramLong)
  {
    b(paramString, paramLong);
  }
  
  public void a(String paramString, Entity paramEntity, long paramLong)
  {
    a().b(paramString, System.nanoTime() - paramLong);
  }
  
  public void a(String paramString, Class paramClass, long paramLong)
  {
    a().b(paramString, System.nanoTime() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGStat
 * JD-Core Version:    0.7.0.1
 */