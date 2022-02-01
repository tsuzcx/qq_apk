package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.QLog;
import hjo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class FrameActivity
  extends BaseActivity
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, OnDrawCompleteListener
{
  long jdField_a_of_type_Long = -1L;
  protected TabHost a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  String jdField_a_of_type_JavaLangString = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap(3);
  protected boolean a;
  
  public FrameActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTab();
  }
  
  protected Frame a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrame;
  }
  
  protected Frame a(Class paramClass)
  {
    Frame localFrame = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localFrame = (Frame)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localFrame;
  }
  
  public void a()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.jdField_a_of_type_JavaLangString + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.jdField_a_of_type_JavaLangString + "TabSwitch, cost=" + l);
    }
  }
  
  protected void a(View paramView1, Class paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost == null) {
      if (paramView1 == null) {
        break label155;
      }
    }
    label155:
    for (this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)paramView1.findViewById(16908306));; this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(16908306)))
    {
      this.jdField_a_of_type_AndroidWidgetTabHost.setup();
      this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTabHost instanceof QQTabHost)) {
        ((QQTabHost)this.jdField_a_of_type_AndroidWidgetTabHost).setOnTabSelectionListener(new hjo(this));
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      String str = paramClass.getName();
      paramClass = (TabHost.TabSpec)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      paramView1 = paramClass;
      if (paramClass == null)
      {
        paramView1 = this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(str).setIndicator(paramView2).setContent(this);
        this.jdField_a_of_type_JavaUtilHashMap.put(str, paramView1);
      }
      this.jdField_a_of_type_AndroidWidgetTabHost.addTab(paramView1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTabHost.addTab(this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(paramClass.getName()).setIndicator(paramView2).setContent(this));
  }
  
  protected void a(Class paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Frame localFrame = a(paramClass);
      if (localFrame != null) {
        localFrame.d();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramClass.getName());
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass.getName());
    }
  }
  
  public Frame b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (Frame)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTabTag());
  }
  
  public View createTabContent(String paramString)
  {
    try
    {
      Frame localFrame = (Frame)Class.forName(paramString).newInstance();
      localFrame.a(this);
      View localView = localFrame.a(getLayoutInflater());
      localFrame.a(localView);
      localFrame.b();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localFrame);
      return localView;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.a(paramInt1, paramInt2, paramIntent);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("qqBaseActivity", 4, "FrameActivity:onActivityResult");
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramConfiguration);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).d();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.c();
    }
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    paramBundle = paramBundle.getString("currentTab");
    String str;
    if ((paramBundle != null) && (this.jdField_a_of_type_AndroidWidgetTabHost != null))
    {
      str = this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTabTag();
      if (str.endsWith(paramBundle)) {
        break label49;
      }
      this.jdField_a_of_type_AndroidWidgetTabHost.setCurrentTabByTag(paramBundle);
    }
    label49:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("qqBaseActivity", 2, "onRestoreInstanceState restoreTag:" + paramBundle + "|curTag：" + str);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Frame localFrame = b();
    if ((localFrame != null) && (localFrame.b())) {
      localFrame.a(false);
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_AndroidWidgetTabHost != null)
    {
      String str = this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTabTag();
      if (str != null) {
        paramBundle.putString("currentTab", str);
      }
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131492923);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).g();
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.jdField_a_of_type_JavaLangString = paramString.substring(i + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_AndroidWidgetTabHost instanceof QQTabHost)) {
        ((QQTabHost)this.jdField_a_of_type_AndroidWidgetTabHost).setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = b();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrame.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.a(true);
    }
  }
  
  protected String setLastActivityName()
  {
    Frame localFrame = b();
    if (localFrame != null) {
      return localFrame.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameActivity
 * JD-Core Version:    0.7.0.1
 */