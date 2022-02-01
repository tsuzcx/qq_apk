package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import gvb;
import gvc;
import gve;
import gvg;
import gvh;
import gvi;
import gvj;
import gvk;
import gvl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public class RecentCallHelper
{
  public static final String a = "RecentCallHelper";
  public static final boolean a = true;
  public static final String b = "-";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecommendAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter;
  public QQAppInterface a;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  private RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private int jdField_b_of_type_Int = 300;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  public boolean d = false;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  
  public RecentCallHelper(QQAppInterface paramQQAppInterface, View paramView1, View paramView2, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, ViewStub.OnInflateListener paramOnInflateListener)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView1.findViewById(2131299512));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    paramView1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131299513);
    paramView1.setContentDescription("消息记录");
    paramView1.setFocusable(true);
    paramView1 = BaseApplication.getContext();
    this.jdField_a_of_type_Int = SharedPreUtils.c(paramView1);
    this.j = SharedPreUtils.a(paramView1, paramQQAppInterface.a(), this.jdField_a_of_type_Int, "acount_uin_first_use_app");
    a(paramQQAppInterface, true, this.j);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView2.findViewById(2131297009));
    this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(paramOnInflateListener);
  }
  
  public RecentCallHelper(QQAppInterface paramQQAppInterface, View paramView, ViewStub.OnInflateListener paramOnInflateListener)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    Context localContext = BaseApplication.getContext();
    this.jdField_a_of_type_Int = SharedPreUtils.c(localContext);
    this.j = SharedPreUtils.a(localContext, paramQQAppInterface.a(), this.jdField_a_of_type_Int, "acount_uin_first_use_app");
    this.h = this.j;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131297009));
    this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(paramOnInflateListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private RecentCallItem a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return (RecentCallItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Handler paramHandler, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    if (paramBoolean)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)paramQQAppInterface.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d(paramQQAppInterface.a(), (byte)0);
      }
      a(paramHandler, 60000L);
      return;
    }
    a(paramHandler, 800L);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(40);
    }
    for (;;)
    {
      int n = paramList.size();
      int m = 0;
      while (m < n)
      {
        RecentCallItem localRecentCallItem = (RecentCallItem)paramList.get(m);
        if (localRecentCallItem != null)
        {
          String str = localRecentCallItem.a() + "-" + localRecentCallItem.a();
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localRecentCallItem);
        }
        m += 1;
      }
      break;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("lightalktips", 2, "is need onInlfate  show lightalk ");
    }
    int m;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = null;
        if (paramQQAppInterface == null) {
          break label94;
        }
        m = paramQQAppInterface.size();
        label45:
        if (m < 1) {
          break label99;
        }
      }
    }
    label94:
    label99:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("lightalktips", 2, "is need onInlfate  show lightalk  result = " + bool);
      }
      return bool;
      paramQQAppInterface = paramQQAppInterface.a();
      break;
      m = 0;
      break label45;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int m = 8;
    int i1 = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (this.g)
    {
      localMarginLayoutParams.leftMargin = SizeMeasure.b(BaseApplication.getContext());
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (paramBoolean) {}
      for (;;)
      {
        ((View)localObject).setVisibility(m);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
        return;
        m = 0;
      }
    }
    localMarginLayoutParams.leftMargin = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if ((this.f) || (paramBoolean))
    {
      n = 0;
      label100:
      ((FPSSwipListView)localObject).setVisibility(n);
      localObject = this.jdField_a_of_type_AndroidViewView;
      n = m;
      if (!this.f) {
        if (!paramBoolean) {
          break label170;
        }
      }
    }
    label170:
    for (int n = m;; n = 0)
    {
      ((View)localObject).setVisibility(n);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.f)
      {
        m = i1;
        if (!paramBoolean) {}
      }
      else
      {
        m = 4;
      }
      ((ImageView)localObject).setVisibility(m);
      break;
      n = 8;
      break label100;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) {
        break label108;
      }
    }
    label108:
    for (int m = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.getCount();; m = 0)
    {
      int n = 0;
      while (n < m)
      {
        ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
        localImageView.setImageResource(2130838260);
        localImageView.setPadding(10, 10, 10, 10);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
        n += 1;
      }
      if (m > 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131299513);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramInt, paramString);
  }
  
  public void a(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    if ((!this.k) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      g();
      localObject1 = LightTalkTipsData.a();
      localObject2 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297024);
      ((TextView)localObject2).setText(((LightTalkTipsData)localObject1).e);
      ((TextView)localObject2).setContentDescription(((LightTalkTipsData)localObject1).e + "点击进入");
      localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297023);
    }
    try
    {
      localObject1 = new BitmapDrawable(paramContext.getResources(), BitmapManager.a(LightTalkTipsData.d));
      paramContext = (Context)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = (BitmapDrawable)paramContext.getResources().getDrawable(2130840075);
      }
    }
    ((ImageView)localObject2).setImageDrawable(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.k = true;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (SharedPreUtils.a(paramContext, paramString, this.jdField_a_of_type_Int, "acount_uin_first_use_app")) {
      SharedPreUtils.a(paramContext, paramString, this.jdField_a_of_type_Int, "acount_uin_first_use_app");
    }
  }
  
  public void a(Configuration paramConfiguration, boolean paramBoolean)
  {
    boolean bool;
    if (paramConfiguration.orientation == 2)
    {
      bool = true;
      this.g = bool;
      if (!this.g) {
        break label88;
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
    }
    for (;;)
    {
      b(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramConfiguration);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0) == RecentItemBuilderFactory.c)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
      return;
      bool = false;
      break;
      label88:
      if ((!this.g) && (!this.f)) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
      }
    }
  }
  
  protected void a(Handler paramHandler, long paramLong)
  {
    if ((this.jdField_c_of_type_Boolean) && (paramHandler != null))
    {
      paramHandler.removeMessages(1022);
      paramHandler.sendEmptyMessageDelayed(1022, paramLong);
    }
  }
  
  public void a(Handler paramHandler, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    a(paramHandler, 800L);
    paramHandler = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (paramBoolean) {}
    for (int m = 0;; m = 2)
    {
      paramHandler.a(m);
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|msg: " + paramMessage);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramMessage = (List)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(paramMessage);
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.h))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() - 1);
        this.h = false;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|" + this.jdField_a_of_type_Long);
      }
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|call adapter is null");
  }
  
  public void a(BaseActivity paramBaseActivity, ViewStub paramViewStub, View paramView1, QQAppInterface paramQQAppInterface, View paramView2, View paramView3, OverScrollViewListener paramOverScrollViewListener, OnRecentUserOpsListener paramOnRecentUserOpsListener, AbsListView.OnScrollListener paramOnScrollListener)
  {
    label602:
    boolean bool2;
    if (paramView1 != null)
    {
      if (paramView1.getResources().getConfiguration().orientation != 2) {
        break label652;
      }
      bool1 = true;
      this.g = bool1;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramView1.findViewById(2131299879));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setChoiceMode(1);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(new ColorDrawable(-1));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      l();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramView2, paramView3, paramBaseActivity, paramOnRecentUserOpsListener, null, 16, 10);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramBaseActivity).inflate(2130903135, null));
      paramViewStub = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297025);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new gvc(this, paramBaseActivity));
      paramViewStub.setOnClickListener(new gve(this));
      paramViewStub.setContentDescription("关闭");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = new TipsBar(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(paramBaseActivity.getResources().getString(2131366289));
      paramViewStub = paramView2.getResources().getDrawable(2130840074);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(paramViewStub);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setContentDescription(paramBaseActivity.getResources().getString(2131366289));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new gvg(this, paramBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(paramBaseActivity).inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(paramOverScrollViewListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(paramBaseActivity, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramOnRecentUserOpsListener, 4);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(paramOnScrollListener);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnInterceptTouchListener(new gvh(this, paramBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter = new RecommendAdapter(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(paramOnRecentUserOpsListener);
      this.jdField_a_of_type_AndroidViewView = paramBaseActivity.findViewById(2131297010);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBaseActivity.findViewById(2131297020));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131297018));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new gvi(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297012));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297013));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297019));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297017));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("返回通话记录界面");
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new gvj(this));
      if (QLog.isColorLevel()) {
        QLog.d("lightalktips", 2, "inflase adapter size is " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount());
      }
      if ((!a()) || (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label658;
      }
      a(BaseApplication.getContext());
      ThreadManager.b(new gvk(this));
      if (!this.k) {
        f();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      bool2 = this.g;
      if (this.g) {
        break label672;
      }
    }
    label652:
    label658:
    label672:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramQQAppInterface, bool2, bool1, false);
      return;
      bool1 = false;
      break;
      if (!this.k) {
        break label602;
      }
      h();
      break label602;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "send_oidb_0x7d7_0");
    }
    paramQQAppInterface = (RecentCallHandler)paramQQAppInterface.a(47);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "setVisibility|visibility: " + paramInt + ", forceRecommend: " + paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(paramInt);
      if (!this.f) {
        break label391;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(paramInt);
        if (paramInt == 8) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
        }
      }
    }
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C0B", "0X8004C0B", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
        a(paramQQAppInterface.getApplication(), paramQQAppInterface.a());
      }
      Object localObject = null;
      if (paramQQAppInterface != null) {
        localObject = (QCallFacade)paramQQAppInterface.getManager(37);
      }
      if (localObject != null)
      {
        ((QCallFacade)localObject).a(false);
        label207:
        ArrayList localArrayList;
        label257:
        int m;
        label260:
        QCallRecent localQCallRecent;
        RecentCallItem localRecentCallItem;
        if (localObject == null)
        {
          localObject = null;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label476;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() != 1) {
            break label475;
          }
          localArrayList = new ArrayList(30);
          if (localObject == null) {
            break label441;
          }
          paramInt = ((List)localObject).size();
          m = 0;
          if (m >= paramInt) {
            break label456;
          }
          localQCallRecent = (QCallRecent)((List)localObject).get(m);
          if ((localQCallRecent != null) && (!TextUtils.isEmpty(localQCallRecent.uin)))
          {
            localRecentCallItem = a(localQCallRecent.uin + "-" + localQCallRecent.type);
            if (localRecentCallItem != null) {
              break label446;
            }
            localRecentCallItem = new RecentCallItem(localQCallRecent);
          }
        }
        for (;;)
        {
          localRecentCallItem.B = localQCallRecent.missedCallCount;
          localRecentCallItem.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext());
          localArrayList.add(localRecentCallItem);
          m += 1;
          break label260;
          label391:
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.g)) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
          localObject = ((QCallFacade)localObject).a();
          break label207;
          label441:
          paramInt = 0;
          break label257;
          label446:
          localRecentCallItem.a(localQCallRecent);
        }
        label456:
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(localArrayList);
        }
      }
    }
    label475:
    return;
    label476:
    a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshData|REFRESH_FLAG_CALL_LIST");
    }
    if ((paramQQAppInterface != null) && (paramContext != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      Object localObject = (QCallFacade)paramQQAppInterface.getManager(37);
      ArrayList localArrayList;
      int m;
      label74:
      int n;
      label77:
      QCallRecent localQCallRecent;
      RecentCallItem localRecentCallItem;
      if (localObject == null)
      {
        localObject = null;
        localArrayList = new ArrayList(30);
        if (localObject == null) {
          break label213;
        }
        m = ((List)localObject).size();
        n = 0;
        if (n >= m) {
          break label229;
        }
        localQCallRecent = (QCallRecent)((List)localObject).get(n);
        if ((localQCallRecent != null) && (!TextUtils.isEmpty(localQCallRecent.uin)))
        {
          localRecentCallItem = a(localQCallRecent.uin + "-" + localQCallRecent.type);
          if (localRecentCallItem != null) {
            break label219;
          }
          localRecentCallItem = new RecentCallItem(localQCallRecent);
        }
      }
      for (;;)
      {
        localRecentCallItem.B = localQCallRecent.missedCallCount;
        localRecentCallItem.a(paramQQAppInterface, paramContext);
        localArrayList.add(localRecentCallItem);
        n += 1;
        break label77;
        localObject = ((QCallFacade)localObject).a();
        break;
        label213:
        m = 0;
        break label74;
        label219:
        localRecentCallItem.a(localQCallRecent);
      }
      label229:
      a(localArrayList);
      if ((paramHandler != null) && (localArrayList.size() > 0)) {
        Message.obtain(paramHandler, 1021, 0, 0, localArrayList).sendToTarget();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onAccountChanged");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.C();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
    {
      this.j = SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.a(), this.jdField_a_of_type_Int, "acount_uin_first_use_app");
      a(paramQQAppInterface, true, this.j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(paramQQAppInterface);
    }
    this.jdField_b_of_type_Int = 300;
    this.jdField_c_of_type_JavaLangString = "";
    this.h = false;
    this.i = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((paramQQAppInterface != null) && (!paramBoolean))
    {
      this.f = true;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
        l();
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.g)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      a(false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(paramBoolean2);
    }
    if (paramBoolean2) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C0A", "0X8004C0A", 0, 0, "", "", "", "");
    }
    this.h = paramBoolean2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "showRecommendView|visibility: " + paramBoolean1 + ", back: " + paramBoolean2);
    }
    label196:
    QCallFacade localQCallFacade;
    if (paramBoolean1)
    {
      b(false);
      if (paramBoolean3) {
        this.f = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (!this.g))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((paramBoolean2) && (!this.g))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() <= 0)) {
          break label323;
        }
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (paramBoolean1)
        {
          localQCallFacade = null;
          if (paramQQAppInterface != null) {
            localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(37);
          }
          if (localQCallFacade != null)
          {
            localQCallFacade.a(false);
            if (localQCallFacade != null) {
              break label441;
            }
            label234:
            if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
              this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, false);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() <= 0) {
              break label450;
            }
            a(true);
            if (!this.i) {
              ReportController.b(null, "CliOper", "", "", "0X8004C11", "0X8004C11", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!this.g) {
        a(paramQQAppInterface);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break;
      label323:
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367212);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      a(false);
      break label196;
      this.f = true;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      a(false);
      break label196;
      label441:
      localQCallFacade.a();
      break label234;
      label450:
      if (!this.i) {
        ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    while ((paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
  }
  
  public void a(String paramString)
  {
    int m = 0;
    if (this.f) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, false);
      }
    }
    label77:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null)) {
        for (;;)
        {
          if (m >= this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount()) {
            break label77;
          }
          View localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(m);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(localView, paramString)) {
            break;
          }
          m += 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, paramInt);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshRecommendFriendList isSuccess: " + paramBoolean);
    }
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() == 0))
      {
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367211);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        a(false);
        if (this.i)
        {
          this.i = false;
          ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a());
        }
      }
    }
    label576:
    label607:
    label609:
    do
    {
      for (;;)
      {
        return;
        this.jdField_b_of_type_Int = paramInt;
        this.jdField_c_of_type_JavaLangString = paramString;
        if ((paramList != null) && (paramList.size() > 0))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(paramList);
            o();
            if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
              this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
            }
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
          }
          if (this.i)
          {
            this.i = false;
            ReportController.b(null, "CliOper", "", "", "0X8004C11", "0X8004C11", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (!this.f) {
            break label576;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        for (;;)
        {
          if (!this.g) {
            break label607;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          if ((paramList == null) || (paramList.size() <= 0)) {
            break label609;
          }
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
          {
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, false);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          a(true);
          return;
          if (((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() == 0)) && (this.i))
          {
            this.i = false;
            ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
          }
          o();
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (!this.g))
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
          }
        }
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() != 0));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367211);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    a(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Handler paramHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|mInRecentCallList: " + this.f + ", isListViewIdle: " + paramBoolean1 + ", bImmediate: " + paramBoolean2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (paramHandler == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "refreshCallList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
        long l;
        if (paramBoolean2) {
          l = 0L;
        }
        while (!paramHandler.hasMessages(16)) {
          if (l == 0L)
          {
            paramHandler.sendEmptyMessage(16);
            return;
            l = Math.max(2000L - Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()), 500L);
          }
          else
          {
            paramHandler.sendEmptyMessageDelayed(16, l);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("RecentCallHelper", 4, "refreshCallList|already has not complete refresh");
      return;
      this.jdField_b_of_type_Boolean = true;
    } while (!QLog.isDevelopLevel());
    QLog.i("RecentCallHelper", 4, "refreshCallList|list scrolling");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    int m;
    do
    {
      return false;
      m = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getInt("show_tab_lightalk_tips", 0);
    } while ((m < 0) || (m >= 3) || (LightTalkTipsData.a() == null));
    return true;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView, QQAppInterface paramQQAppInterface, Handler paramHandler, boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    a(paramQQAppInterface, paramHandler, paramBoolean);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {}
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {}
    while (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.isShown());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onResume|mInRecentCallList: " + this.f);
    }
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
      QLog.d("lightalktips", 2, "onresume adapter size is " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount());
    }
    if (!this.f) {
      a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() > 2) && (a()))
    {
      a(BaseApplication.getContext());
      ThreadManager.b(new gvb(this));
    }
    for (;;)
    {
      if (!this.k) {
        f();
      }
      return;
      if (this.k) {
        h();
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount() == 1);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onPause|mInRecentCallList: " + this.f);
    }
    if (!this.f) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = null;
    this.jdField_a_of_type_AndroidWidgetRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void f()
  {
    int n = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int m = ((SharedPreferences)localObject).getInt("funcall_RecentCall_Tipsnum", 0);
    if (m < 3)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_RecentCall_Tipsnum", m + 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (m = 1;; m = 0)
    {
      if (m != 0)
      {
        if (this.e) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.m() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
        }
        for (m = 1;; m = n)
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar);
          this.e = true;
          if (m == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
          return;
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar);
        }
      }
      if (this.e != true) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar);
      this.e = false;
      return;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar);
      this.e = false;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RecentCallHelper", 2, "dismiss funcall bar exception");
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.k = false;
    }
  }
  
  public void i()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
  }
  
  public void j()
  {
    if ((!this.f) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null))
    {
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount())
      {
        View localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(m);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(localView);
        m += 1;
      }
    }
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getVisibility() != 0)) {
      return;
    }
    if (!this.d)
    {
      this.d = true;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.postDelayed(new gvl(this), 100L);
      return;
    }
    this.d = false;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837687);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path == "null")
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837687);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (Object localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);; localObject = null)
    {
      if (localObject != null) {
        if (localObject == null)
        {
          localObject = null;
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label52;
          }
        }
      }
      label52:
      while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)
      {
        return;
        localObject = ((QCallFacade)localObject).a();
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallHelper
 * JD-Core Version:    0.7.0.1
 */