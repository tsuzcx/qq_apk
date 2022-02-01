package com.tencent.mobileqq.app;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.empty.BrowserCallActivity;
import com.tencent.mobileqq.activity.empty.BrowserContactActivity;
import com.tencent.mobileqq.activity.empty.BrowserConversationActivity;
import com.tencent.mobileqq.activity.empty.BrowserLebaMeActivity;
import com.tencent.mobileqq.activity.empty.BrowserQzoneActivity;
import com.tencent.mobileqq.activity.empty.BrowserSettingMeActivity;
import com.tencent.mobileqq.activity.empty.MusicCallActivity;
import com.tencent.mobileqq.activity.empty.MusicContactsActivity;
import com.tencent.mobileqq.activity.empty.MusicConversationActivity;
import com.tencent.mobileqq.activity.empty.MusicSettingMeActivity;
import com.tencent.mobileqq.activity.empty.QWalletPluginProxyCallActivity;
import com.tencent.mobileqq.activity.empty.QWalletPluginProxyContactsActivity;
import com.tencent.mobileqq.activity.empty.QWalletPluginProxyConversationActivity;
import com.tencent.mobileqq.activity.empty.QWalletPluginProxySettingMeActivity;
import com.tencent.mobileqq.activity.empty.SendHbCallActivity;
import com.tencent.mobileqq.activity.empty.SendHbContactActivity;
import com.tencent.mobileqq.activity.empty.SendHbConversationActivity;
import com.tencent.mobileqq.activity.empty.TransactionCallActivity;
import com.tencent.mobileqq.activity.empty.TransactionContactActivity;
import com.tencent.mobileqq.activity.empty.TransactionConversationActivity;
import com.tencent.mobileqq.activity.empty.TroopLocationModifyContactsActivity;
import com.tencent.mobileqq.activity.empty.TroopLocationModifyConversationActivity;
import com.tencent.mobileqq.activity.empty.TroopTagContactsActivity;
import com.tencent.mobileqq.activity.empty.TroopTagConversationActivity;
import com.tencent.mobileqq.activity.flaotaio.FloatSetting;
import com.tencent.mobileqq.customviews.CircleMenu;
import com.tencent.mobileqq.customviews.CircleMenuManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.widget.ActionSheet;
import hoh;
import hoi;
import hoj;
import hok;
import hol;
import hon;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import mqq.app.BasePadActivity;

public class QQTabActivity
  extends BaseActivity
  implements TabHost.OnTabChangeListener, QQTabHost.OnTabSelectionListener
{
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private static final String jdField_a_of_type_JavaLangString = "android:states";
  private static SparseArray jdField_b_of_type_AndroidUtilSparseArray;
  private static SparseArray jdField_c_of_type_AndroidUtilSparseArray;
  private static SparseArray d;
  private static SparseArray e;
  private static SparseArray f;
  private static SparseArray g;
  static final String n = "android:parent_non_config_instance";
  public static final String o = "splash_task_show";
  public static final String p = "splash_task_hdie";
  public static final String q = "activty_clear_top";
  public static final String r = "fragment_on_recieve";
  public static final String s = "new_task_activity_result";
  public static final String t = "top_fragment_anim";
  public static final String u = "Common_BroadcastReceiver";
  protected LocalActivityManager a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected TabHost a;
  List jdField_a_of_type_JavaUtilList = new ArrayList(6);
  private boolean jdField_a_of_type_Boolean;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  
  public QQTabActivity()
  {
    this(true);
  }
  
  public QQTabActivity(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppLocalActivityManager = new LocalActivityManager(this, paramBoolean);
  }
  
  public static SparseArray a()
  {
    int i = 0;
    if (jdField_a_of_type_AndroidUtilSparseArray == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = BrowserSettingMeActivity.class;
      arrayOfClass[1] = BrowserConversationActivity.class;
      arrayOfClass[2] = BrowserCallActivity.class;
      arrayOfClass[3] = BrowserContactActivity.class;
      arrayOfClass[4] = BrowserQzoneActivity.class;
      arrayOfClass[5] = BrowserLebaMeActivity.class;
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  private View a(int paramInt)
  {
    try
    {
      View localView = (View)ReflectionUtil.a(ReflectionUtil.a((TabHost.TabSpec)this.jdField_a_of_type_JavaUtilList.get(paramInt), TabHost.TabSpec.class, "mContentStrategy"), null, "mLaunchedView");
      return localView;
    }
    catch (Exception localException)
    {
      Log.e("app2", "getTabView index = " + paramInt + " error", localException);
    }
    return null;
  }
  
  public static Object a(Class paramClass, Object paramObject, String paramString)
  {
    while ((paramClass == null) || (paramClass != null)) {
      try
      {
        Object localObject = paramClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        return localObject;
        paramClass = paramObject.getClass();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        paramClass = paramClass.getSuperclass();
      }
      catch (Exception paramClass)
      {
        Log.e("app", "field-->fieldName=" + paramString, paramClass);
      }
    }
    return null;
  }
  
  private void a()
  {
    try
    {
      FloatSetting localFloatSetting = FloatSetting.a(this);
      if (localFloatSetting.a(this.app.a())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006182", "0X8006182", 0, 0, "", "", "", "");
      }
      if (localFloatSetting.b(this.app.a())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006183", "0X8006183", 0, 0, "", "", "", "");
      }
      if (localFloatSetting.c(this.app.a())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006184", "0X8006184", 0, 0, "", "", "", "");
      }
      if (localFloatSetting.d(this.app.a())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006185", "0X8006185", 0, 0, "", "", "", "");
      }
      if (SettingCloneUtil.readValue(this, this.app.a(), getString(2131367906), "qqsetting_lock_screen_whenexit_key", true)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006186", "0X8006186", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("app2", "reportFloatMsgStatus error", localException);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost == null) {}
    for (;;)
    {
      return;
      QQTabHost localQQTabHost = (QQTabHost)this.jdField_a_of_type_AndroidWidgetTabHost;
      if (paramInt1 != paramInt2) {
        try
        {
          if (!localQQTabHost.jdField_a_of_type_Boolean)
          {
            Object localObject3 = a(paramInt1);
            Object localObject2 = a(paramInt2);
            Object localObject1 = new DecelerateInterpolator(1.5F);
            if (localObject3 != null)
            {
              localQQTabHost.jdField_a_of_type_Boolean = true;
              ((View)localObject3).setVisibility(0);
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 1.0F, 0.0F });
              localObjectAnimator.setDuration(200L);
              localObjectAnimator.setInterpolator((TimeInterpolator)localObject1);
              localObjectAnimator.addListener(new hol(this, localQQTabHost, (View)localObject3));
              localObject3 = CircleMenuManager.a(paramInt1);
              if (localObject3 != null) {
                ((CircleMenu)localObject3).g();
              }
              localObjectAnimator.start();
            }
            if (localObject2 != null)
            {
              localQQTabHost.jdField_a_of_type_Boolean = true;
              ((View)localObject2).setAlpha(0.0F);
              localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F });
              ((ObjectAnimator)localObject2).setDuration(200L);
              ((ObjectAnimator)localObject2).setStartDelay(50L);
              ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
              ((ObjectAnimator)localObject2).addListener(new hon(this, localQQTabHost));
              localObject1 = CircleMenuManager.a(paramInt2);
              if (localObject1 != null) {
                ((CircleMenu)localObject1).f();
              }
              ((ObjectAnimator)localObject2).start();
              return;
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("app2", "startTabSwitchAnim error = ", localException);
          localQQTabHost.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  private void a(TabHost paramTabHost)
  {
    try
    {
      Field localField = TabHost.class.getDeclaredField("mCurrentTab");
      localField.setAccessible(true);
      localField.setInt(paramTabHost, 0);
      return;
    }
    catch (Exception paramTabHost)
    {
      paramTabHost.printStackTrace();
    }
  }
  
  public static SparseArray b()
  {
    int i = 0;
    if (jdField_b_of_type_AndroidUtilSparseArray == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = null;
      arrayOfClass[1] = SendHbConversationActivity.class;
      arrayOfClass[2] = SendHbCallActivity.class;
      arrayOfClass[3] = SendHbContactActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        jdField_b_of_type_AndroidUtilSparseArray.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return jdField_b_of_type_AndroidUtilSparseArray;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hoj(this);
      IntentFilter localIntentFilter = new IntentFilter("splash_task_show");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent("broadcast_show_or_hide_task");
    localIntent.putExtra("cur_Tab_Id", paramInt);
    localIntent.putExtra("start_from_splash", true);
    sendBroadcast(localIntent);
  }
  
  private void b(TabHost paramTabHost)
  {
    FrameLayout localFrameLayout = paramTabHost.getTabContentView();
    paramTabHost = paramTabHost.getTabWidget();
    int i = SizeMeasure.a(this);
    paramTabHost.getLayoutParams().width = i;
    localFrameLayout.setPadding(i, 0, 0, 0);
  }
  
  public static SparseArray c()
  {
    int i = 0;
    if (d == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = null;
      arrayOfClass[1] = TransactionConversationActivity.class;
      arrayOfClass[2] = TransactionCallActivity.class;
      arrayOfClass[3] = TransactionContactActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      d = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        d.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return d;
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new hok(this);
      IntentFilter localIntentFilter = new IntentFilter("activty_clear_top");
      localIntentFilter.addAction("fragment_on_recieve");
      localIntentFilter.addAction("new_task_activity_result");
      localIntentFilter.addAction("top_fragment_anim");
      localIntentFilter.addAction("Common_BroadcastReceiver");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static SparseArray d()
  {
    int i = 0;
    if (jdField_c_of_type_AndroidUtilSparseArray == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = QWalletPluginProxySettingMeActivity.class;
      arrayOfClass[1] = QWalletPluginProxyConversationActivity.class;
      arrayOfClass[2] = QWalletPluginProxyCallActivity.class;
      arrayOfClass[3] = QWalletPluginProxyContactsActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        jdField_c_of_type_AndroidUtilSparseArray.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return jdField_c_of_type_AndroidUtilSparseArray;
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public static SparseArray e()
  {
    int i = 0;
    if (e == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = null;
      arrayOfClass[1] = TroopTagConversationActivity.class;
      arrayOfClass[2] = null;
      arrayOfClass[3] = TroopTagContactsActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      e = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        e.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return e;
  }
  
  public static SparseArray f()
  {
    int i = 0;
    if (f == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = null;
      arrayOfClass[1] = TroopLocationModifyConversationActivity.class;
      arrayOfClass[2] = null;
      arrayOfClass[3] = TroopLocationModifyContactsActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      f = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        f.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return f;
  }
  
  public static SparseArray g()
  {
    int i = 0;
    if (g == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = MusicSettingMeActivity.class;
      arrayOfClass[1] = MusicConversationActivity.class;
      arrayOfClass[2] = MusicCallActivity.class;
      arrayOfClass[3] = MusicContactsActivity.class;
      arrayOfClass[4] = null;
      arrayOfClass[5] = null;
      g = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        g.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return g;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost != null) {
      return this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTab();
    }
    return -1;
  }
  
  public final LocalActivityManager a()
  {
    return this.jdField_a_of_type_AndroidAppLocalActivityManager;
  }
  
  public TabHost a()
  {
    return this.jdField_a_of_type_AndroidWidgetTabHost;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost != null) {
      this.jdField_a_of_type_AndroidWidgetTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    Activity localActivity = b();
    if ((localActivity instanceof QQTabHost.OnTabSelectionListener)) {
      ((QQTabHost.OnTabSelectionListener)localActivity).a(paramInt1, paramInt2, paramQQTabHost);
    }
    b(paramInt2);
    a(paramInt1, paramInt2);
  }
  
  protected void a(View paramView1, Class paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost == null) {
      if (paramView1 == null) {
        break label129;
      }
    }
    label129:
    for (this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)paramView1.findViewById(16908306));; this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(16908306)))
    {
      this.jdField_a_of_type_AndroidWidgetTabHost.setup(a());
      this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
      a(this.jdField_a_of_type_AndroidWidgetTabHost);
      b(this.jdField_a_of_type_AndroidWidgetTabHost);
      if ((this.jdField_a_of_type_AndroidWidgetTabHost instanceof QQTabHost)) {
        ((QQTabHost)this.jdField_a_of_type_AndroidWidgetTabHost).setOnTabSelectionListener(this);
      }
      paramView1 = this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(paramClass.getName()).setIndicator(paramView2).setContent(new Intent(this, paramClass));
      this.jdField_a_of_type_JavaUtilList.add(paramView1);
      this.jdField_a_of_type_AndroidWidgetTabHost.addTab(paramView1);
      return;
    }
  }
  
  public Activity b()
  {
    return this.jdField_a_of_type_AndroidAppLocalActivityManager.getCurrentActivity();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Activity localActivity = b();
    if ((localActivity instanceof BasePadActivity)) {
      ((BasePadActivity)localActivity).hanldeActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    CircleMenuManager.b();
    ActionSheet.b();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = ((TabHost.TabSpec)this.jdField_a_of_type_JavaUtilList.get(i)).getTag();
      localObject = this.jdField_a_of_type_AndroidAppLocalActivityManager.getActivity((String)localObject);
      if (localObject != null) {
        ((Activity)localObject).onConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundle("android:states");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchCreate(paramBundle);
      b();
      c();
      getWindow().getDecorView().postDelayed(new hoh(this), 3500L);
      return false;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetTabHost != null)
    {
      sendBroadcast(new Intent("remove_owner_task"));
      Intent localIntent = new Intent("finish_all_activity_in_task");
      localIntent.putExtra("cur_Tab_Id", this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTab());
      sendBroadcast(localIntent);
    }
    super.doOnDestroy();
    CircleMenuManager.a();
    SizeMeasure.d(this);
    this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchDestroy(isFinishing());
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchPause(isFinishing());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchResume();
    if ((this.jdField_a_of_type_AndroidWidgetTabHost != null) && (this.jdField_a_of_type_Boolean) && (!this.notShowNewTask)) {
      b(this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTab());
    }
    if (this.app != null) {
      this.app.isBackground_Stop = false;
    }
    this.notShowNewTask = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    Bundle localBundle = this.jdField_a_of_type_AndroidAppLocalActivityManager.saveInstanceState();
    if (localBundle != null) {
      paramBundle.putBundle("android:states", localBundle);
    }
  }
  
  public void doOnStart()
  {
    this.jdField_b_of_type_Boolean = true;
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    CircleMenuManager.b();
    this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchStop();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((this.app != null) && (this.jdField_c_of_type_Boolean) && (!sNotShowLockScreen))
    {
      this.jdField_c_of_type_Boolean = false;
      getWindow().getDecorView().postDelayed(new hoi(this), 400L);
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.app != null) {
      this.app.isBackground_Stop = false;
    }
    if (paramString.contains("Conversation")) {
      setContaierViewId(2131297308);
    }
    do
    {
      return;
      if (paramString.contains("Call"))
      {
        setContaierViewId(2131297021);
        return;
      }
      if (paramString.contains("Contacts"))
      {
        setContaierViewId(2131297225);
        return;
      }
      if (paramString.contains("QzoneWrapperActivity"))
      {
        setContaierViewId(2131301978);
        return;
      }
      if (paramString.contains("Leba"))
      {
        setContaierViewId(2131297932);
        return;
      }
    } while (!paramString.contains("SettingMe"));
    setContaierViewId(2131302160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQTabActivity
 * JD-Core Version:    0.7.0.1
 */