package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kcz;
import kda;
import kdb;
import kdc;
import kdd;
import kde;
import kdf;

public class NearbyTroopsActivity
  extends QQBrowserActivity
  implements Handler.Callback, View.OnTouchListener
{
  public static final int N = 2;
  public static final int O = -1;
  public static final int P = 0;
  public static final int Q = 1;
  public static final int R = 2;
  public static final int S = 3;
  public static final int T = 4;
  public static final int U = 5;
  public static final int a = 886;
  public static final String a = "TAB_INDEX";
  public static final boolean a = true;
  public static final String b = "NearbyTroopsActivity";
  public static final int d = 1229;
  public static final int e = 1339;
  public static final int f = -1;
  public static final String f = "886.100170";
  public static final int g = 0;
  public static final String g = "886.100171";
  public static final int h = 1;
  public static final String h = "886.100172";
  public static final String i = "tab_index";
  public int V = 0;
  public int W = -1;
  private int X = -1;
  public Context a;
  public Drawable a;
  protected View.OnClickListener a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new kde(this);
  protected Animation a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public TroopMemberApiClient a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private NearbyTroopsBaseView.INearbyTroopContext jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext;
  private NearbyTroopsBaseView jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new kdd(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public String[] a;
  public int b;
  protected Animation b;
  RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  protected LinearLayout b;
  protected TextView b;
  public BrowserAppInterface b;
  private NearbyTroopsBaseView jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
  boolean jdField_b_of_type_Boolean = false;
  protected String[] b;
  public int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new kdf(this);
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public String c;
  protected boolean c;
  public String d;
  boolean d;
  public View e;
  protected ImageView e;
  public String e;
  boolean e;
  protected View f;
  
  public NearbyTroopsActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "886.100170", "886.100171", "886.100172" };
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kcz(this);
  }
  
  private NearbyTroopsBaseView a(int paramInt)
  {
    Object localObject;
    if (paramInt == -1) {
      localObject = null;
    }
    NearbyTroopsBaseView localNearbyTroopsBaseView;
    do
    {
      return localObject;
      localNearbyTroopsBaseView = (NearbyTroopsBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localNearbyTroopsBaseView;
    } while (localNearbyTroopsBaseView != null);
    switch (paramInt)
    {
    default: 
      localObject = new NearbyTroopsView(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((NearbyTroopsBaseView)localObject).a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
      return localObject;
      localObject = new NearbyTroopsView(this);
      continue;
      localObject = new NearbyActivityView(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = ((NearbyTroopsBaseView)localObject);
      continue;
      localObject = new NearbyRecommendView(this);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    if ((paramContext == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyTroopsActivity", 2, "openNearbyTroopsActivity failed! from：" + paramInt1);
      }
      return;
    }
    Intent localIntent = new Intent(paramContext, NearbyTroopsActivity.class);
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("mode", paramInt2);
    paramQQAppInterface = paramQQAppInterface.a().a();
    ResourcePluginInfo localResourcePluginInfo;
    if (paramQQAppInterface != null)
    {
      paramInt1 = 0;
      if (paramInt1 < paramQQAppInterface.size())
      {
        localResourcePluginInfo = (ResourcePluginInfo)paramQQAppInterface.get(paramInt1);
        if (localResourcePluginInfo.uiResId != 886L) {}
      }
    }
    for (paramQQAppInterface = localResourcePluginInfo.strResName;; paramQQAppInterface = null) {
      for (;;)
      {
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          localIntent.putExtra("config_res_plugin_item_name", paramQQAppInterface);
        }
        if (!TextUtils.isEmpty(paramString)) {}
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          localIntent.putExtra("TAB_INDEX", paramInt1);
          paramContext.startActivity(localIntent);
          return;
          paramInt1 += 1;
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          for (;;)
          {
            paramInt1 = j;
            if (QLog.isColorLevel())
            {
              QLog.e("NearbyTroopsActivity", 2, "NumberFormatException");
              paramInt1 = j;
            }
          }
        }
      }
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = new kdc(this);
  }
  
  private void y()
  {
    this.jdField_e_of_type_AndroidViewView = findViewById(2131298678);
    this.f = findViewById(2131298679);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298680));
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968653);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968651);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298681));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298683));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.rightViewImg.setContentDescription(getString(2131365810));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("创建群");
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription("创建活动");
  }
  
  public void a()
  {
    this.rightViewImg.setSelected(true);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130968652));
    this.f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130968650));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int[] arrayOfInt = paramBundle.getIntArray("iNewFlags");
    paramBundle = paramBundle.getIntArray("types");
    int j = this.X;
    int k = j;
    if (arrayOfInt != null)
    {
      k = j;
      if (paramBundle != null)
      {
        k = j;
        if (arrayOfInt.length == paramBundle.length)
        {
          k = j;
          if (arrayOfInt.length == this.jdField_b_of_type_ArrayOfJavaLangString.length)
          {
            int m = 0;
            k = j;
            j = m;
            while (j < paramBundle.length)
            {
              m = k;
              if (arrayOfInt[j] != 0)
              {
                m = k;
                if (paramBundle[j] != -1)
                {
                  RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(j);
                  if (localRedDotTextView != null) {
                    localRedDotTextView.a(true);
                  }
                  m = k;
                  if (k == -1) {
                    m = j;
                  }
                }
              }
              j += 1;
              k = m;
            }
          }
        }
      }
    }
    if (k == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(k, false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    super.setTitle(paramCharSequence);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3) {}
  
  public void a(boolean paramBoolean)
  {
    this.u = false;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    FrameLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetAbsoluteLayout != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.getLayoutParams();
      if (localLayoutParams != null) {}
    }
    else
    {
      return;
    }
    localLayoutParams.bottomMargin = 0;
    this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      setContentView(2130903541);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      ViewGroup.LayoutParams localLayoutParams = this.rightViewImg.getLayoutParams();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      localLayoutParams.width = (localDisplayMetrics.densityDpi * 36 / 160);
      localLayoutParams.height = -2;
      this.rightViewImg.setLayoutParams(localLayoutParams);
      int j = localDisplayMetrics.densityDpi * 100 / 160;
      this.rightViewImg.setMaxWidth(j);
      this.rightViewImg.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      this.rightViewText.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298591));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298590));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131364124));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131364125));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(2, getString(2131364126));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      y();
      this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("leftViewText");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("mode", 0);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
      if ((this.jdField_c_of_type_Int != 10) && (this.jdField_c_of_type_Int != 23) && (this.jdField_c_of_type_Int != 11)) {
        break label425;
      }
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131364143);
      label338:
      if (this.jdField_c_of_type_Int != 23) {
        break label475;
      }
      this.V = 5;
    }
    for (;;)
    {
      if ((!paramBoolean) || (this.jdField_b_of_type_Int != 0)) {
        break label509;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_b_of_type_ArrayOfJavaLangString, new kda(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
      paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
      if (!TextUtils.isEmpty(paramIntent))
      {
        b(paramIntent);
        break;
      }
      b(2131365804, -1);
      break;
      label425:
      this.rightViewImg.setVisibility(0);
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setBackgroundResource(2130842093);
      this.rightViewImg.setImageResource(2130838208);
      this.rightViewImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      break label338;
      label475:
      if (this.jdField_c_of_type_Int == 10) {
        this.V = 3;
      } else if (this.jdField_c_of_type_Int == 11) {
        this.V = 4;
      }
    }
    label509:
    if (this.X == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.X, true);
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("is_show_mapentry", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("from", 0);
    a(paramBoolean, paramIntent);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == null) {
      return;
    }
    super.b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      setTitle(paramInt1);
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramInt2 == -1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams.topMargin = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = Utils.a(BaseApplication.getContext(), 6.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(Intent paramIntent, String paramString) {}
  
  public void b(CharSequence paramCharSequence)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    a(paramCharSequence);
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {}
  
  public void c(int paramInt)
  {
    NearbyTroopsBaseView localNearbyTroopsBaseView = a(paramInt);
    if (localNearbyTroopsBaseView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == localNearbyTroopsBaseView);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = localNearbyTroopsBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.h();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.c();
        }
        this.jdField_c_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_c_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView);
        this.jdField_c_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(null);
      }
    } while ((paramInt != 1) || (this.jdField_d_of_type_Boolean));
    this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = localNearbyTroopsBaseView;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1339);
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof BrowserAppInterface)) {
      this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.app != null) {}
    for (paramBundle = this.app;; paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramBundle;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break;
      }
      finish();
      return true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = getIntent();
    paramBundle.putExtra("url", "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city");
    paramBundle.putExtra("uin", this.N);
    paramBundle.putExtra("portraitOnly", true);
    paramBundle.putExtra("hide_more_button", true);
    paramBundle.putExtra("hide_operation_bar", true);
    paramBundle.putExtra("isShowAd", false);
    this.X = paramBundle.getIntExtra("TAB_INDEX", -1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    x();
    a(true, paramBundle);
    getWindow().setBackgroundDrawable(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)localIterator.next();
      if (localNearbyTroopsBaseView != null) {
        localNearbyTroopsBaseView.a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.X = paramIntent.getIntExtra("TAB_INDEX", -1);
    a(false, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramIntent);
    }
    getWindow().setBackgroundDrawable(null);
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.c();
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
    }
    super.doOnStop();
  }
  
  protected void e()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      super.e();
      CustomWebView localCustomWebView = (CustomWebView)findViewById(2131296450);
      if (localCustomWebView != null) {
        localCustomWebView.setVisibility(0);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (paramMessage.what == 1229)
    {
      if (paramMessage.arg1 == 0) {
        bool = true;
      }
      runOnUiThread(new kdb(this, bool));
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 1339)
      {
        if ((!this.jdField_d_of_type_Boolean) && (this.X == 1))
        {
          startTitleProgress();
          this.jdField_d_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = true;
          e();
          this.jdField_e_of_type_Boolean = false;
          stopTitleProgress();
          return true;
        }
      }
      else
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)localIterator.next();
          if (localNearbyTroopsBaseView != null) {
            localNearbyTroopsBaseView.a(paramMessage);
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onRestart()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.i();
    }
    super.onRestart();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      this.mDensity = getResources().getDisplayMetrics().density;
      super.setContentViewC(paramInt);
      getWindow().setFeatureInt(7, 2130903542);
      ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130841809));
    } while (this.leftView != null);
    this.vg = ((ViewGroup)findViewById(2131297347));
    setLayerType(this.vg);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298709));
    this.rightViewText = ((TextView)findViewById(2131297360));
    this.rightViewImg = ((ImageView)findViewById(2131297361));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298707));
    this.leftView = ((TextView)findViewById(2131297357));
    this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setLayerType(this.leftView);
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_b_of_type_Boolean) {
      return getString(2131366001);
    }
    return super.setLastActivityName();
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public boolean showPreview()
  {
    getWindow().setBackgroundDrawableResource(2131427365);
    return true;
  }
  
  public boolean startTitleProgress()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    while (!QLog.isColorLevel()) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startTitleProgress, ad !instanceof Animatable, isNull=");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      bool = true;
    }
    QLog.d("NearbyTroopsActivity", 2, bool);
    return true;
  }
  
  public boolean stopTitleProgress()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    while (!QLog.isColorLevel())
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("stopTitleProgress, ad !instanceof Animatable, isNull=");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NearbyTroopsActivity", 2, bool);
      break;
    }
  }
  
  public void w()
  {
    this.rightViewImg.setSelected(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.f.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_order", 0, 0, "3", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsActivity
 * JD-Core Version:    0.7.0.1
 */