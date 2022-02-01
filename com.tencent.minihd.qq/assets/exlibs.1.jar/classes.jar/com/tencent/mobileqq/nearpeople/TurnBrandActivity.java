package com.tencent.mobileqq.nearpeople;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import jkk;
import jkn;
import jko;
import jkp;
import jkq;
import jkr;
import jks;
import jkt;
import jku;

public class TurnBrandActivity
  extends DatingBaseActivity
  implements TurnBrandDownloader.ImageCallback, TurnBrandPopupView.PopupCallback
{
  static final int jdField_a_of_type_Int = 1184274;
  private static final long jdField_a_of_type_Long = 10000L;
  static final String jdField_a_of_type_JavaLangString = "nearpeople_turnbrand_swipe";
  static final int jdField_b_of_type_Int = 1184275;
  private static final long jdField_b_of_type_Long = 3000L;
  private static final String jdField_b_of_type_JavaLangString = "TurnBrandActivity";
  static final int jdField_c_of_type_Int = 1184276;
  private static final String jdField_c_of_type_JavaLangString = "nearpeople_turnbrand_guide";
  static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "nearpeople_turnbrand_first_waiton";
  static final int jdField_e_of_type_Int = 2;
  private static final int f = 5;
  private static final int g = 2000;
  private static final int h = 2001;
  private static final int i = 2002;
  private static final int j = 2003;
  private static final int k = 2004;
  private static final int l = 2005;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new jks(this);
  private TurnBrandDownloader jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader;
  private TurnBrandLoadingView jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView;
  private TurnBrandPopupView jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView;
  private TurnBrandView jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public Queue a;
  private jku jdField_a_of_type_Jku;
  private long jdField_c_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  
  public TurnBrandActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new jkk(this);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "doLike: reqLbsTurnBrandZan: tiny: " + this.jdField_a_of_type_Jku.a + ", mCurUserProfile: " + this.jdField_a_of_type_Jku);
    }
    if ((this.jdField_a_of_type_Jku == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Jku.a))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(this.jdField_a_of_type_Jku.a);
    if (this.jdField_a_of_type_Jku.jdField_c_of_type_Int == 1)
    {
      a(2004, true);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a(TurnBrandDownloader.a(this.jdField_a_of_type_Jku.b));
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a(this.jdField_a_of_type_Jku.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Jku.d, this.jdField_a_of_type_Jku.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Jku.b);
    }
    for (;;)
    {
      ReportController.a(this.app, "CliOper", "", "", "0X80049F4", "0X80049F4", 0, 0, "", "", "", "");
      ReportController.a(this.app, "CliOper", "", "", "0X80049F5", "0X80049F5", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Jku.a, this.jdField_a_of_type_Jku);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "doDislike: mCurUserProfile: " + this.jdField_a_of_type_Jku + ", tinyList: " + this.jdField_a_of_type_JavaUtilArrayList);
    }
    Object localObject;
    if ((this.jdField_a_of_type_Jku != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Jku.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "doDislike: add to list: " + this.jdField_a_of_type_Jku.a);
      }
      localObject = Long.valueOf(0L);
    }
    try
    {
      Long localLong = Long.valueOf(this.jdField_a_of_type_Jku.a);
      localObject = localLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1;
        localNumberFormatException.printStackTrace();
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    l1 = System.currentTimeMillis();
    if ((l1 - this.c >= 10000L) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.c = l1;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    ReportController.a(this.app, "CliOper", "", "", "0X80049F4", "0X80049F4", 0, 0, "", "", "", "");
    ReportController.a(this.app, "CliOper", "", "", "0X80049F6", "0X80049F6", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    c(2003);
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "updateAndlloadNextBrand: count: " + this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.a()) {
      return;
    }
    this.jdField_a_of_type_Jku = this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.b();
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "updateAndlloadNextBrand: downloadImage: tiny: " + this.jdField_a_of_type_Jku.a + ", url: " + this.jdField_a_of_type_Jku.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader.a(this.jdField_a_of_type_Jku.a, this.jdField_a_of_type_Jku.b);
    g();
  }
  
  private void g()
  {
    Object localObject = BaseApplication.getContext();
    if (NetworkUtil.g((Context)localObject)) {}
    for (int m = 5;; m = 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "preloadImage: num: " + m);
      }
      c(2003);
      localObject = new LinkedList();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.a();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
      int n = 0;
      while ((n < m) && (localIterator.hasNext()))
      {
        jku localjku = (jku)localIterator.next();
        if (TurnBrandDownloader.a(localjku.b) == null) {
          ((Queue)localObject).offer(localjku);
        }
        n += 1;
      }
      if (!NetworkUtil.d((Context)localObject)) {
        return;
      }
    }
    if (!((Queue)localObject).isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader.a((Queue)localObject);
    }
  }
  
  private void h()
  {
    a(2004, false);
    Queue localQueue = this.jdField_a_of_type_JavaUtilQueue;
    if (localQueue != null) {
      while (localQueue.size() > 0)
      {
        jku localjku = (jku)localQueue.poll();
        if (localjku != null)
        {
          a(2004, true);
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a(TurnBrandDownloader.a(localjku.b));
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a(localjku.jdField_c_of_type_JavaLangString, localjku.d, localjku.jdField_e_of_type_JavaLangString, localjku.b);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.app.getPreferences().getBoolean("nearpeople_turnbrand_first_waiton" + this.app.a(), true))
    {
      DialogUtil.a(this, 230, null, "会话已保存至消息列表的“附近人的消息”中，你可以稍后去查看。", "我知道了", "", null, new jkt(this)).show();
      this.app.getPreferences().edit().putBoolean("nearpeople_turnbrand_first_waiton" + this.app.a(), false).commit();
    }
    for (;;)
    {
      ReportController.a(this.app, "CliOper", "", "", "0X80049F7", "0X80049F7", 0, 0, "", "", "", "");
      return;
      h();
    }
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    FrameLayout localFrameLayout = (FrameLayout)getWindow().getDecorView();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramBoolean) {
              break;
            }
            c(2004);
          } while (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.getParent() != null);
          localFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView);
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.setVisibility(0);
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView == null) || (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.getParent() == null));
        localFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView);
        return;
        if (!paramBoolean) {
          break;
        }
        c(2005);
      } while (this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() != null);
      localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() == null));
    localFrameLayout.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onImageLoaded: the URL of face image is: " + paramString + ", bitmap: " + paramBitmap);
    }
    if (paramBitmap == null) {
      a(2131369585);
    }
    do
    {
      return;
      c(2003);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.a(paramBitmap, paramString);
    } while ((this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView == null) || (!this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.isShown()) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a())));
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.a(paramBitmap);
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "switchToAIO: uin: " + paramString1 + ", nick: " + paramString2 + ", sig: " + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("rich_date_sig", paramString3);
    startActivity(localIntent);
  }
  
  public void b(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView == null) {
            this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView = ((TurnBrandLoadingView)findViewById(2131300295));
          }
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.a();
          if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView != null) {
            a(2004, false);
          }
        } while (this.jdField_a_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        c(2003);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setVisibility(0);
        this.app.a(new jkr(this));
        if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView != null) {
          a(2004, false);
        }
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        ViewStub localViewStub = (ViewStub)findViewById(2131300296);
        FrameLayout localFrameLayout = (FrameLayout)localViewStub.inflate();
        localViewStub.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView = localFrameLayout.findViewById(2131300297);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localFrameLayout.findViewById(2131300298));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandLoadingView.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView == null);
    a(2004, false);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3);
    a(2004, false);
    ReportController.a(this.app, "CliOper", "", "", "0X80049F8", "0X80049F8", 0, 0, "", "", "", "");
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView != null);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView = new TurnBrandView(this);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setLayoutParams(localLayoutParams);
        ((FrameLayout)findViewById(2131300294)).addView(this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView.setOnFlingListener(new jko(this));
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView != null);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView = new TurnBrandPopupView(this, this);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView.setOnClickListener(new jkp(this));
      return;
    } while (this.jdField_a_of_type_AndroidWidgetFrameLayout != null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
    LayoutInflater.from(this).inflate(2130903971, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new jkq(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903969);
    super.setTitle(2131369578);
    if (this.jdField_e_of_type_Boolean) {
      setLeftViewName(2131367588);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader = new TurnBrandDownloader(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
    this.app.e(true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.c = System.currentTimeMillis();
    b(2002, null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1184275, 3000L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader.a();
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandDownloader.b();
    this.app.a(new jkn(this));
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "doOnDestroy!");
    }
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.jdField_e_of_type_Boolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandActivity
 * JD-Core Version:    0.7.0.1
 */