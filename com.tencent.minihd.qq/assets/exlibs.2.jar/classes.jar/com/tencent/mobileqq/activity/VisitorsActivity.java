package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import fns;
import fnt;
import fnu;
import fnv;
import fny;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements FaceDecoder.DecodeTaskCompletionListener, AdapterView.OnItemClickListener, OverScrollViewListener
{
  protected static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "VisitorsActivity";
  protected static final int b = 1;
  protected static final int c = 3;
  private static final String jdField_c_of_type_JavaLangString = "visitors_last_refresh_time";
  protected static final int d = 4;
  private static final String d = "favoritors_last_refresh_time";
  protected static final int e = 5;
  static final long e = 800L;
  static final int f = 0;
  static final int g = 1;
  static final int j = 1;
  static final int k = 2;
  static final int l = 3;
  static final int m = 4;
  static final int n = 800;
  static final int o = 1000;
  static final int p = 0;
  static final int q = 1;
  static final int r = 2;
  static final int s = 3;
  static final int t = 3;
  static final int u = 4;
  static final int v = 4;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new fns(this);
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new fnv(this);
  protected FriendManager a;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new fnu(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public GridListView a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new fnt(this);
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public fny a;
  public ArrayList a;
  public HashMap a;
  public boolean a;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  public GridListView b;
  private PullRefreshHeader jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public fny b;
  protected String b;
  public ArrayList b;
  public boolean b;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = true;
  public long d = 0L;
  public int h = 0;
  protected int i = 0;
  private int w = 0;
  
  public VisitorsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = null;
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void a(long paramLong)
  {
    getActivity().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", paramLong).commit();
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.w == 0) {
      this.w = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.w, this.w);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.getLEctID()), 41);
    localAllInOne.h = paramCardProfile.getStrNick();
    localAllInOne.b = paramCardProfile.getBAge();
    localAllInOne.jdField_a_of_type_Byte = paramCardProfile.getBSex();
    localAllInOne.jdField_a_of_type_Short = paramCardProfile.getWFace();
    if (paramCardProfile.getVIntroContent() != null) {}
    try
    {
      new String(paramCardProfile.getVIntroContent(), "utf-8");
      paramCardProfile = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(localAllInOne.jdField_a_of_type_JavaLangString);
      if ((paramCardProfile != null) && (paramCardProfile.isFriend()))
      {
        localAllInOne.jdField_a_of_type_Int = 1;
        ProfileActivity.b(this, localAllInOne);
        return;
      }
    }
    catch (UnsupportedEncodingException paramCardProfile)
    {
      for (;;)
      {
        paramCardProfile.printStackTrace();
      }
    }
    catch (NullPointerException paramCardProfile)
    {
      for (;;)
      {
        paramCardProfile.printStackTrace();
      }
      localAllInOne.g = 16;
      paramCardProfile = new Bundle();
      paramCardProfile.putInt("param_mode", 3);
      NearbyPeopleProfileActivity.a(this, localAllInOne, paramCardProfile);
    }
  }
  
  private long b()
  {
    return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
  }
  
  private void b(long paramLong)
  {
    getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).edit().putLong("favoritors_last_refresh_time", paramLong).commit();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298591));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298590));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131367532));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131367533));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131302402));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setContentBackground(2130837687);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Fny);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131302403));
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setContentBackground(2130837687);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_b_of_type_Fny);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setMode(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903418, this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView, false));
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollHeader(this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a();
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b();
    this.jdField_a_of_type_Fny = new fny(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_Fny = new fny(this, this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Fny.jdField_a_of_type_JavaLangString = getString(2131369572);
    this.jdField_b_of_type_Fny.jdField_a_of_type_JavaLangString = getString(2131369573);
    startTitleProgress();
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    a(true);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130904514, null);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130903966, null);
  }
  
  void a()
  {
    if (!NetworkUtil.e(this))
    {
      a(1, getString(2131367328));
      return;
    }
    a(false);
    this.jdField_a_of_type_Fny.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Fny.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      ReportController.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView);
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    startTitleProgress();
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis() - this.d;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if ((paramInt1 == 0) || (l1 >= 800L))
    {
      this.d = SystemClock.uptimeMillis();
      if (this.h == 0)
      {
        this.jdField_a_of_type_Fny.notifyDataSetChanged();
        return;
      }
      this.jdField_b_of_type_Fny.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l1);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(b());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView == this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView)
    {
      switch (this.jdField_a_of_type_Fny.getItemViewType(paramInt))
      {
      default: 
        return;
      case 0: 
        ReportController.a(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
        a((CardProfile)this.jdField_a_of_type_Fny.getItem(paramInt));
        return;
      }
      a();
      return;
    }
    switch (this.jdField_b_of_type_Fny.getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
      ReportController.a(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
      a((CardProfile)this.jdField_b_of_type_Fny.getItem(paramInt));
      return;
    }
    b();
  }
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramString);
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false);
        localObject = a();
      }
      paramImageView.setImageBitmap((Bitmap)localObject);
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramString, 3000);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 3000, true, false);
      localObject = a();
    }
    paramImageView.setImageBitmap((Bitmap)localObject);
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    TextView localTextView = this.rightViewText;
    if (paramArrayList.size() > 0) {
      localTextView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_a_of_type_Fny.a(paramArrayList);
      this.jdField_a_of_type_Fny.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      if (paramLong == 0L) {
        a(true);
      }
      this.jdField_a_of_type_Fny.notifyDataSetChanged();
      return;
      localTextView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  void a(boolean paramBoolean)
  {
    a(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131366939));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
      if (!stopTitleProgress())
      {
        if (NetworkUtil.e(this)) {
          break label63;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      }
    }
    label63:
    do
    {
      return true;
      a(true);
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(b());
    } while (stopTitleProgress());
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return true;
    }
    b(true);
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    String str = this.app.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_b_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_a_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, 30);
    return true;
  }
  
  void b()
  {
    if (!NetworkUtil.e(this))
    {
      a(1, getString(2131367328));
      return;
    }
    b(false);
    this.jdField_b_of_type_Fny.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Fny.notifyDataSetChanged();
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(b());
  }
  
  public void b(ArrayList paramArrayList, long paramLong)
  {
    if (paramArrayList.size() == 0) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Fny.a(paramArrayList);
    this.jdField_b_of_type_Fny.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramLong == 0L) {
      b(true);
    }
    this.jdField_b_of_type_Fny.notifyDataSetChanged();
  }
  
  void b(boolean paramBoolean)
  {
    b(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 800L);
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131366939));
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.B();
  }
  
  boolean b(boolean paramBoolean)
  {
    String str = this.app.a();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_b_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_b_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, 30);
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    QQToast.a(this, 1, 2131366939, 0).b(getTitleBarHeight());
    a(false);
    if (this.jdField_a_of_type_Fny.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Fny.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Fny.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    QQToast.a(this, 1, 2131366939, 0).b(getTitleBarHeight());
    b(false);
    if (this.jdField_b_of_type_Fny.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Fny.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Fny.notifyDataSetChanged();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.app.getManager(8));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    paramBundle = this.app.a();
    this.jdField_b_of_type_JavaLangString = String.valueOf(getIntent().getLongExtra("toUin", 0L));
    if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.equals(this.jdField_b_of_type_JavaLangString))) {}
    this.jdField_a_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2130904515);
    g();
    f();
    e();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Fny != null) && (this.jdField_a_of_type_Fny.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_Fny.jdField_a_of_type_Int), "", "", "");
    }
    if ((this.jdField_b_of_type_Fny != null) && (this.jdField_b_of_type_Fny.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_Fny.jdField_a_of_type_Int), "", "", "");
    }
    return super.onBackEvent();
  }
  
  protected View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131367529);
    return this.centerView;
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(8);
    return this.rightViewText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */