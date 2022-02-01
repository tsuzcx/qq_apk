package com.tencent.biz.viewplugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cpg;
import cph;
import java.lang.reflect.Method;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ViewPluginManager
{
  public static final String a = "ViewPluginManager";
  public static final String b = "leba_search";
  public static final String c = "leba_search_load_builder";
  public static final String d = "leba_search_set_data";
  private static final String g = "SearchViewPluginVersion";
  public ViewPluginContext a;
  public BaseActivity a;
  public ClassLoader a;
  public HashMap a;
  public String e;
  public String f;
  
  public ViewPluginManager(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    this.f = paramString1;
    this.e = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a(View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      Method localMethod = paramView.getClass().getMethod("setData", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[] { paramString });
      return true;
    }
    catch (Exception paramView)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_set_data", 0, 0, HtmlOffline.c("1002"), paramView.getClass().getSimpleName(), null, null);
    }
    return false;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {}
    Object localObject;
    do
    {
      for (;;)
      {
        try
        {
          Class localClass = this.jdField_a_of_type_JavaLangClassLoader.loadClass("com.tencent.biz.lebsearch.widget.SearchViewBuilder");
          if (localClass != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.f + " not find view:" + paramInt);
          }
          return null;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_builder", 0, 0, HtmlOffline.c("1002"), localClassNotFoundException.getClass().getSimpleName(), null, null);
        }
        localObject = null;
      }
      if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginManager", 2, "plugin:" + this.f + " plugin context is null");
    return null;
    try
    {
      localObject = ((Class)localObject).getMethod("getView", new Class[] { Context.class, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      localObject = (View)((Method)localObject).invoke(null, new Object[] { this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext, Integer.valueOf(paramInt) });
      return localObject;
    }
    catch (Exception localException)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_builder", 0, 0, HtmlOffline.c("1002"), localException.getClass().getSimpleName(), null, null);
    }
    return null;
  }
  
  public void a()
  {
    String str = "http://" + this.f + "?_bid=" + this.e;
    b();
    long l = System.currentTimeMillis();
    if ((!HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, new cpg(this, l))) && (QLog.isColorLevel())) {
      QLog.i("ViewPluginManager", 2, "plugin:" + this.f + " transToLocalUrl: return false");
    }
  }
  
  public void b()
  {
    String str = "http://" + this.f + "?_bid=" + this.e;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), new cph(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager
 * JD-Core Version:    0.7.0.1
 */