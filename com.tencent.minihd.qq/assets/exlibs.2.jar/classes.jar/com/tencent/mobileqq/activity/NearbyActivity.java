package com.tencent.mobileqq.activity;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyBannerManager;
import com.tencent.mobileqq.config.NearbyBannerManager.INearbyBannerListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.dating.AnchorageManager.Anchorage;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.dating.NearbyBannerMgr;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.NearbyPushBanner;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import ell;
import elm;
import eln;
import elo;
import elp;
import elr;
import els;
import elt;
import elu;
import elv;
import elw;
import elx;
import ely;
import elz;
import ema;
import emc;
import eme;
import emf;
import emg;
import emh;
import emi;
import emo;
import emp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class NearbyActivity
  extends DatingBaseActivity
  implements View.OnClickListener, PopupWindow.OnDismissListener, IFlingSwitch, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final int A = 4;
  private static final int B = 5;
  private static final int C = 0;
  private static final int D = 1;
  private static final int E = 3;
  private static final int F = 1;
  private static final int G = 1;
  public static final int a = 1000;
  public static final String a = "nearby_people_disclaimer_ok";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130840397, 2130840376, 2130840380, 2130840418, 2130840423 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final int b = 0;
  private static final long jdField_b_of_type_Long = 1000L;
  public static final String b = "together_guide";
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131365794, 2131369923, 2131369656, 2131369492, 2131370009 };
  public static int c = 0;
  private static final long jdField_c_of_type_Long = 180000L;
  public static final String c = "nearby_people_portrait_guide_ok";
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131369924, 2131369925, 2131369926, 2131369927, 2131369928 };
  public static final int d = 2;
  public static final String d = "nearby_people_profile_ok_new";
  public static final int e = 4;
  public static final String e = "is_skip_nearby_guide";
  public static final int f = 1;
  public static final int g = 0;
  public static final int h = -1;
  private static final String jdField_h_of_type_JavaLangString = "https://ti.qq.com/plaza/";
  public static final int i = -1;
  private static final String jdField_i_of_type_JavaLangString = "extra_has_more";
  public static final int j = 0;
  private static final String j = "extra_last_time";
  public static final int k = 1002;
  private static final String k = "extra_last_filter";
  public static final int l = 0;
  private static final String l = "extra_nearby_banner";
  private static final String m = "Q.nearby";
  private static final String n = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city&from=nearby_new";
  private static final int w = 0;
  private static final int x = 1;
  private static final int y = 2;
  private static final int z = 3;
  private int H = 0;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new elm(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NearPeopleFilterActivity.NearPeopleFilters jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private PeopleAroundAdapter jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter;
  private LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new emi(this);
  private NearbyBannerManager.INearbyBannerListener jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager$INearbyBannerListener = new elz(this);
  private NearbyBannerManager jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager;
  private CarrierHelper jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper;
  DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new emo(this);
  private NearbyBannerMgr jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr;
  public NearbyUserBehaviorReport a;
  GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new emh(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new elo(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new eln(this);
  public XListView a;
  private emp jdField_a_of_type_Emp = new emp(this, this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private RedTouch[] jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ema(this);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private NearPeopleFilterActivity.NearPeopleFilters jdField_b_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private long jdField_e_of_type_Long = -1L;
  private View jdField_e_of_type_AndroidViewView;
  private View f;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_i_of_type_Boolean;
  public int m = 0;
  protected int n = 0;
  protected int o = 0;
  public int p = 0;
  public int q = 0;
  protected int r = 0;
  public int s = 4;
  int t = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "100510.100513", "100510.100514", "100510.100511", "100510.100512", "100510.100515" };
    jdField_c_of_type_Int = 100;
  }
  
  public NearbyActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.h = false;
    this.jdField_a_of_type_Boolean = false;
    this.i = false;
  }
  
  public static int a(Activity paramActivity)
  {
    int i1 = -1;
    if (paramActivity != null) {}
    try
    {
      i1 = paramActivity.getIntent().getIntExtra("FROM_WHERE", -1);
      return i1;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
  }
  
  private int a(NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    if (paramNearPeopleFilters != null) {}
    switch (paramNearPeopleFilters.i)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  private View a()
  {
    View localView = getLayoutInflater().inflate(2130903422, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131297803).setVisibility(8);
    localView.findViewById(2131298165).setOnClickListener(new elw(this));
    return localView;
  }
  
  private void a()
  {
    int i1 = a(this);
    if (i1 == 0)
    {
      this.leftView.setText(2131366001);
      return;
    }
    if (i1 == 1002)
    {
      this.leftView.setText(2131369424);
      return;
    }
    this.leftView.setText(2131365114);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.H == 0) {
      this.H = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.H, this.H);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    if ((paramNearPeopleFilters != null) && (!paramNearPeopleFilters.a()))
    {
      this.centerView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.centerView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(boolean paramBoolean, NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    TextView localTextView;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.f == null) {
          this.f = getLayoutInflater().inflate(2130903954, null);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a()))
        {
          localTextView = (TextView)this.f.findViewById(2131297963);
          localTextView.setText(getString(2131369571));
          localTextView.setTextColor(getResources().getColor(2131427972));
          this.f.findViewById(2131297967).setVisibility(4);
          this.f.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.f);
          label137:
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          label146:
          if (!paramBoolean) {
            break label317;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(2, null);
          }
          a(paramNearPeopleFilters);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      }
      return;
      localTextView = (TextView)this.f.findViewById(2131297963);
      localTextView.setText(2131369930);
      localTextView.setTextColor(getResources().getColor(2131427934));
      this.f.findViewById(2131297967).setVisibility(0);
      this.f.setOnClickListener(new emg(this));
      break;
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(null);
      break label137;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.h)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break label146;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      break label146;
      label317:
      d(false);
    }
  }
  
  private boolean a()
  {
    if ((getIntent() == null) || (getIntent().getBooleanExtra("is_skip_nearby_guide", false))) {}
    while (c()) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    setTitle(2131367588);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131297354);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297355));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297356));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367588);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369929);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838415);
    this.rightViewImg.setOnClickListener(this);
    int i1 = a(this);
    if ((i1 == 0) || (this.jdField_e_of_type_Boolean)) {
      this.leftView.setText(2131366001);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297468));
      this.jdField_d_of_type_AndroidViewView = getLayoutInflater().inflate(2130903951, null);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131300191);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[5];
      this.mDensity = getResources().getDisplayMetrics().density;
      i1 = 0;
      while (i1 < 5)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = LayoutInflater.from(this).inflate(2130903955, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setContentDescription(getString(jdField_c_of_type_ArrayOfInt[i1]));
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setOnClickListener(this);
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131300203)).setImageResource(jdField_a_of_type_ArrayOfInt[i1]);
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131300204)).setText(getString(jdField_b_of_type_ArrayOfInt[i1]));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLinearLayout.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[i1], localLayoutParams);
        i1 += 1;
      }
      if (i1 == 1002) {
        this.leftView.setText(2131369424);
      } else {
        this.leftView.setText(2131365114);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[5];
    i1 = 0;
    while (i1 < 5)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i1] = new RedTouch(this, this.jdField_a_of_type_ArrayOfAndroidViewView[i1]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i1].a(53).e(5).d(5).a();
      i1 += 1;
    }
    this.jdField_g_of_type_AndroidViewView = a();
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_g_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903607, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492896));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903958, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300205);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300206);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.rightViewImg.setContentDescription("我的资料及清除位置等功能");
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_Emp;
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 1)
    {
      localObject = ((emp)localObject).obtainMessage(0, i1, 0);
      this.jdField_a_of_type_Emp.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  private boolean b()
  {
    Object localObject = ((DatingManager)this.app.getManager(67)).a().a(getClass().getName());
    if (localObject != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilMap.get("extra_last_filter"));
      this.jdField_a_of_type_JavaUtilList = ((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_a_of_type_JavaUtilList, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.onRestoreInstanceState(((AnchorageManager.Anchorage)localObject).jdField_a_of_type_AndroidOsParcelable);
      localObject = ((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilMap;
      this.jdField_d_of_type_Long = ((Long)((Map)localObject).get("extra_last_time")).longValue();
      this.h = ((Boolean)((Map)localObject).get("extra_has_more")).booleanValue();
      this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr = ((NearbyBannerMgr)((Map)localObject).get("extra_nearby_banner"));
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr.a(this.jdField_a_of_type_Emp);
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    int i1 = 0;
    while (i1 < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i1].a(localRedTouchManager.a(jdField_a_of_type_ArrayOfJavaLangString[i1]));
      i1 += 1;
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903908);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).gravity = 5;
    ((WindowManager.LayoutParams)localObject).width = SizeMeasure.e(this);
    ((WindowManager.LayoutParams)localObject).height = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    a(paramInt);
    localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300042);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, this.app.a(), 3000);
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.app.a(), 3000, true, false);
      ((ImageView)localObject).setImageDrawable((BitmapDrawable)ImageUtil.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new els(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300044).setOnClickListener(new elt(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300043).setOnClickListener(new elu(this));
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new elv(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      ((ImageView)localObject).setImageBitmap(localBitmap);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject1;
    if (getIntent() != null)
    {
      localObject1 = getIntent().getStringExtra("filter");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.m = Integer.valueOf((String)localObject1).intValue();
      if (this.m != 0)
      {
        localObject6 = getIntent().getStringExtra("filterGender");
        str = getIntent().getStringExtra("filter_time");
        localObject5 = getIntent().getStringExtra("filter_age");
        localObject4 = getIntent().getStringExtra("filter_xingzuo");
        localObject1 = getIntent().getStringExtra("filter_career");
        localObject3 = getIntent().getStringExtra("filter_location");
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
        NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
        if (TextUtils.isEmpty((CharSequence)localObject6))
        {
          i1 = 0;
          localNearPeopleFilters.i = i1;
          if (!TextUtils.isEmpty(str)) {
            break label374;
          }
          i1 = 3;
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
          if (i1 >= NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfInt.length) {
            break label386;
          }
          i1 = NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfInt[i1];
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject6).j = i1;
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            break label391;
          }
          i1 = 0;
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject6).k = i1;
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break label403;
          }
          i1 = 0;
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject5).l = i1;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label415;
          }
          i1 = 0;
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject4).m = i1;
          localObject1 = new String[5];
          localObject1[0] = "0";
          localObject1[1] = "0";
          localObject1[2] = "0";
          localObject1[3] = "0";
          localObject1[4] = "不限";
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label453;
          }
        }
      }
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        label318:
        Object localObject2;
        break label318;
      }
      if (localObject1.length >= 4)
      {
        i1 = i2;
        while (i1 < 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[i1] = localObject1[i1];
          i1 += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject6;
        String str;
        Object localObject5;
        Object localObject4;
        this.m = 0;
        continue;
        int i1 = Integer.valueOf((String)localObject6).intValue();
        continue;
        label374:
        i1 = Integer.valueOf(str).intValue();
        continue;
        label386:
        i1 = 0;
        continue;
        label391:
        i1 = Integer.valueOf((String)localObject5).intValue();
        continue;
        label403:
        i1 = Integer.valueOf((String)localObject4).intValue();
        continue;
        label415:
        i1 = Integer.valueOf(localException1).intValue();
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
      if (localException1.length >= 5)
      {
        localObject2 = localException1[4];
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
      }
      label453:
      do
      {
        return;
        localObject2 = "不限";
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a());
        if (!paramBoolean) {
          this.jdField_b_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null);
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j = 4;
      localObject2 = ((FriendsManager)this.app.getManager(49)).a(this.app.a());
      if (localObject2 != null) {
        this.t = ((Card)localObject2).shGender;
      }
      if (this.t == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 2;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 0;
      return;
    }
  }
  
  @TargetApi(9)
  private boolean c()
  {
    boolean bool = this.app.getPreferences().getBoolean("nearby_people_disclaimer_ok", false);
    if (!bool)
    {
      getWindow().setBackgroundDrawableResource(2130837687);
      this.rightViewImg.setVisibility(8);
      RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131300016);
      View localView = LayoutInflater.from(getApplicationContext()).inflate(2130903976, null);
      localRelativeLayout.addView(localView, new LinearLayout.LayoutParams(-1, -1));
      if (Build.VERSION.SDK_INT >= 9) {
        localView.setOverScrollMode(2);
      }
      ((Button)localView.findViewById(2131300324)).setOnClickListener(new elp(this, localRelativeLayout, localView));
    }
    return bool;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager.a(this);
    Leba.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    b("0X8004440");
    ThreadManager.c(new emc(this, b()));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport = new NearbyUserBehaviorReport();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    int i2 = 8;
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297997);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131296735);
    ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297996);
    if (paramBoolean)
    {
      i1 = 2131368842;
      localTextView.setText(i1);
      if (!paramBoolean) {
        break label94;
      }
      i1 = 0;
      label68:
      localProgressBar.setVisibility(i1);
      if (!paramBoolean) {
        break label100;
      }
    }
    label94:
    label100:
    for (int i1 = i2;; i1 = 0)
    {
      localImageView.setVisibility(i1);
      return;
      i1 = 2131366569;
      break;
      i1 = 8;
      break label68;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "doRefreshList last request is in process... return");
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
    if (localNearPeopleFilters == null)
    {
      localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
      localNearPeopleFilters.k = 0;
      localNearPeopleFilters.l = 0;
      localNearPeopleFilters.j = 4;
    }
    for (;;)
    {
      int i2 = a(localNearPeopleFilters);
      byte b3 = (byte)localNearPeopleFilters.l;
      int i1 = 480;
      byte b1;
      byte b2;
      if (localNearPeopleFilters.j == 0)
      {
        i1 = 480;
        b1 = 0;
        b2 = 0;
        if (localNearPeopleFilters.k != 0) {
          break label363;
        }
        b1 = 0;
        b2 = 0;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("NearbyFilter", 4, "NearbyActivity doRefreshList" + localNearPeopleFilters.i);
        }
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.n != 0)
        {
          localObject1 = localObject2;
          if (this.o != 0) {
            localObject1 = new GeoPoint(this.n, this.o);
          }
        }
        this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i2, paramBoolean, null, (GeoPoint)localObject1, this.r, b3, i1, b1, b2, localNearPeopleFilters.m, ConditionSearchManager.a(localNearPeopleFilters.c[0]), ConditionSearchManager.a(localNearPeopleFilters.c[1]), ConditionSearchManager.a(localNearPeopleFilters.c[2]), null, DatingFilters.a(this, this.app.a()));
        DatingUtil.b("doRefreshList", new Object[] { Long.valueOf(this.jdField_e_of_type_Long) });
        return;
        if (localNearPeopleFilters.j == 1)
        {
          i1 = 30;
          break;
        }
        if (localNearPeopleFilters.j == 2)
        {
          i1 = 60;
          break;
        }
        if (localNearPeopleFilters.j == 3)
        {
          i1 = 240;
          break;
        }
        DatingUtil.b("doRefreshList time is unknown", new Object[] { Integer.valueOf(localNearPeopleFilters.j) });
        break;
        label363:
        if (localNearPeopleFilters.k == 1)
        {
          b1 = 18;
          b2 = 22;
        }
        else if (localNearPeopleFilters.k == 2)
        {
          b1 = 23;
          b2 = 26;
        }
        else if (localNearPeopleFilters.k == 3)
        {
          b1 = 27;
          b2 = 35;
        }
        else if (localNearPeopleFilters.k == 4)
        {
          b1 = 36;
          b2 = 127;
        }
        else
        {
          DatingUtil.b("doRefreshList agetype is unknown", new Object[] { Integer.valueOf(localNearPeopleFilters.k) });
        }
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      DatingManager localDatingManager = (DatingManager)this.app.getManager(67);
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("extra_has_more", Boolean.valueOf(this.h));
      localHashMap.put("extra_last_time", Long.valueOf(this.jdField_d_of_type_Long));
      localHashMap.put("extra_last_filter", this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr != null) {
        localHashMap.put("extra_nearby_banner", this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr);
      }
      localDatingManager.a().a(getClass().getName(), this.jdField_a_of_type_ComTencentWidgetXListView.onSaveInstanceState(), this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList, localHashMap);
    }
  }
  
  private void h()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    DatingManager localDatingManager = (DatingManager)this.app.getManager(67);
    if (localDatingManager != null) {}
    for (int i1 = localDatingManager.a().a();; i1 = 0)
    {
      if (i1 > 0) {
        localRedTouchManager.a(100511, "100510.100511", i1);
      }
      return;
    }
  }
  
  @TargetApi(16)
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(new elr(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      ADView localADView = (ADView)this.jdField_g_of_type_AndroidViewView.findViewById(2131297804);
      if (localADView != null) {
        localADView.a();
      }
      this.jdField_g_of_type_AndroidViewView.findViewById(2131297803).setVisibility(8);
    }
    b("0X8004C1C");
  }
  
  private void k()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    int i2 = 0;
    int i4 = 0;
    int i3 = 0;
    int i5 = 0;
    int i1 = i2;
    Object localObject6;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.iterator();
        }
      }
    }
    for (;;)
    {
      i1 = i2;
      if (((Iterator)localObject6).hasNext())
      {
        localObject1 = ((Iterator)localObject6).next();
        if (!(localObject1 instanceof RespEncounterInfo)) {
          break label368;
        }
      }
      label368:
      Object localObject3;
      for (Object localObject1 = (RespEncounterInfo)localObject1; (localObject1 != null) && (((RespEncounterInfo)localObject1).lEctID > 0L) && (this.app.a().equals(String.valueOf(((RespEncounterInfo)localObject1).lEctID))); localObject3 = null) {
        for (i2 = i4;; i2 = i3)
        {
          try
          {
            localObject6 = this.app.a().createEntityManager();
            localObject4 = localObject6;
            i2 = i4;
            localObject5 = localObject6;
            Card localCard = (Card)((EntityManager)localObject6).a(Card.class, "uin=?", new String[] { this.app.a() });
            if (localCard == null) {
              continue;
            }
            i1 = i5;
            localObject4 = localObject6;
            i2 = i4;
            localObject5 = localObject6;
            if (((RespEncounterInfo)localObject1).iVoteIncrement != localCard.iVoteIncrement)
            {
              localObject4 = localObject6;
              i2 = i4;
              localObject5 = localObject6;
              ((RespEncounterInfo)localObject1).iVoteIncrement = localCard.iVoteIncrement;
              i1 = 1;
            }
            localObject4 = localObject6;
            i2 = i1;
            localObject5 = localObject6;
            i3 = i1;
            if (((RespEncounterInfo)localObject1).iVoteNum == localCard.lVoteCount) {
              continue;
            }
            localObject4 = localObject6;
            i2 = i1;
            localObject5 = localObject6;
            ((RespEncounterInfo)localObject1).iVoteNum = ((int)localCard.lVoteCount);
            i2 = 1;
            i1 = i2;
            if (localObject6 != null)
            {
              ((EntityManager)localObject6).a();
              i1 = i2;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i1 = i2;
              if (localObject4 != null)
              {
                localObject4.a();
                i1 = i2;
              }
            }
          }
          finally
          {
            if (localObject5 == null) {
              continue;
            }
            localObject5.a();
          }
          if (i1 != 0) {
            this.jdField_a_of_type_Emp.sendEmptyMessage(2);
          }
          return;
        }
      }
    }
  }
  
  public int a()
  {
    int i5 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i1 = 0;
    int i2 = -1;
    Object localObject;
    int i4;
    if (i1 < i5)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1);
      i4 = i2;
      if (localObject != null)
      {
        localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
        i4 = i2;
        if (localObject != null)
        {
          localObject = ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangObject;
          i4 = i2;
          if ((localObject instanceof RespEncounterInfo))
          {
            int i3 = i2;
            if (i2 < 0) {
              i3 = i1;
            }
            i4 = i3;
            if (String.valueOf(((RespEncounterInfo)localObject).lEctID).equals(this.app.a()))
            {
              i2 = i1;
              i1 = i3;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i2 < 0) {}
      for (;;)
      {
        if (i1 >= 0)
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1);
          Rect localRect = new Rect();
          ((View)localObject).getGlobalVisibleRect(localRect);
          return localRect.bottom - (localRect.bottom - localRect.top) / 2;
          i1 += 1;
          i2 = i4;
          break;
        }
        return -1;
        i1 = i2;
      }
      i1 = i2;
      i2 = -1;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {}
    while (paramInt < 0) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i1 = ((Rect)localObject).top;
    int i2 = (int)(localDisplayMetrics.scaledDensity * 76.0F);
    int i3 = (int)(localDisplayMetrics.scaledDensity * 151.0F);
    int i4 = localDisplayMetrics.heightPixels;
    localObject = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300016);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.gravity = 48;
    if (paramInt - i1 < i2) {}
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      if (i4 - paramInt < i3) {
        localLayoutParams.topMargin = ((int)((localDisplayMetrics.heightPixels - localDisplayMetrics.scaledDensity * 227.0F - i1) * 0.5D));
      } else {
        localLayoutParams.topMargin = (paramInt - i2 - i1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "uin=" + paramString + ", type=" + paramInt2);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < i1)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label208;
        }
        localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
        if ((localObject == null) || (paramInt2 != ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label208;
        }
        ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "face updated, uin=" + paramString);
        }
      }
      if ((this.jdField_a_of_type_AndroidAppDialog == null) || (!paramString.equals(this.app.a()))) {
        break;
      }
      ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300042)).setImageBitmap(paramBitmap);
      return;
      label208:
      paramInt1 += 1;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131369819, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368196, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131369821, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 1);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.a(paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if (paramInt == 0)
      {
        int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1);
          if (paramAbsListView != null)
          {
            paramAbsListView = (PeopleAroundAdapter.ViewHolder)paramAbsListView.getTag();
            if (paramAbsListView != null)
            {
              Object localObject = paramAbsListView.jdField_a_of_type_JavaLangObject;
              if ((localObject instanceof RespEncounterInfo))
              {
                localObject = (RespEncounterInfo)localObject;
                this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a((RespEncounterInfo)localObject, paramAbsListView.jdField_a_of_type_AndroidWidgetImageView);
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 2131366577, 2131366578, 2131365736, 2131366587, new eme(this), new emf(this, paramRunnable));
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  /* Error */
  public void a(String paramString1, List paramList, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 1297	java/io/ObjectOutputStream
    //   6: dup
    //   7: new 1299	java/io/BufferedOutputStream
    //   10: dup
    //   11: aload_0
    //   12: new 1017	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 1018	java/lang/StringBuilder:<init>	()V
    //   19: aload_1
    //   20: invokevirtual 1024	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 1301
    //   26: invokevirtual 1024	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 1030	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokevirtual 1305	com/tencent/mobileqq/activity/NearbyActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: invokespecial 1308	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: invokespecial 1309	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_1
    //   45: aload_3
    //   46: aload_2
    //   47: invokevirtual 1313	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   50: aload_3
    //   51: astore_1
    //   52: aload_3
    //   53: aload_0
    //   54: getfield 282	com/tencent/mobileqq/activity/NearbyActivity:jdField_d_of_type_Long	J
    //   57: invokevirtual 1317	java/io/ObjectOutputStream:writeLong	(J)V
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 1320	java/io/ObjectOutputStream:flush	()V
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 1323	java/io/ObjectOutputStream:close	()V
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 1324	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore 4
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   92: aload_2
    //   93: ifnull -19 -> 74
    //   96: aload_2
    //   97: invokevirtual 1323	java/io/ObjectOutputStream:close	()V
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 1324	java/io/IOException:printStackTrace	()V
    //   106: return
    //   107: astore_1
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 1323	java/io/ObjectOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 1324	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_3
    //   130: aload_1
    //   131: astore_2
    //   132: aload_3
    //   133: astore_1
    //   134: goto -23 -> 111
    //   137: astore 4
    //   139: aload_3
    //   140: astore_2
    //   141: goto -56 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	NearbyActivity
    //   0	144	1	paramString1	String
    //   0	144	2	paramList	List
    //   0	144	3	paramString2	String
    //   1	1	4	localObject	Object
    //   81	28	4	localException1	Exception
    //   137	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   70	74	75	java/io/IOException
    //   3	43	81	java/lang/Exception
    //   96	100	101	java/io/IOException
    //   3	43	107	finally
    //   115	119	121	java/io/IOException
    //   45	50	129	finally
    //   52	60	129	finally
    //   62	66	129	finally
    //   87	92	129	finally
    //   45	50	137	java/lang/Exception
    //   52	60	137	java/lang/Exception
    //   62	66	137	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
    if ((paramBoolean1) && (!paramBoolean2) && (l1 >= 0L) && (l1 < 180000L) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.equals(this.jdField_b_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters))) {
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Emp.removeMessages(0);
      if (paramBoolean2) {
        stopTitleProgress();
      }
    }
    while (NetworkUtil.e(this))
    {
      e(paramBoolean1);
      return;
      startTitleProgress();
      a(null);
      continue;
      d(true);
    }
    Message localMessage = this.jdField_a_of_type_Emp.obtainMessage(1, 1, 0);
    this.jdField_a_of_type_Emp.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    paramView = (ADView)paramView.findViewById(2131297804);
    paramView.a();
    int i2 = this.jdField_b_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      NearbyPushBanner localNearbyPushBanner = (NearbyPushBanner)this.jdField_b_of_type_JavaUtilList.get(i1);
      FrameLayout localFrameLayout = (FrameLayout)getLayoutInflater().inflate(2130903423, null);
      ImageView localImageView1 = (ImageView)localFrameLayout.findViewById(2131298166);
      ImageView localImageView2 = (ImageView)localFrameLayout.findViewById(2131298167);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView1.getLayoutParams();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      Bitmap localBitmap = localNearbyPushBanner.a;
      int i3 = localBitmap.getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / localBitmap.getWidth();
      localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i3));
      localImageView1.setLayoutParams(localLayoutParams);
      localImageView1.setImageBitmap(localBitmap);
      localImageView2.setTag(localNearbyPushBanner);
      localImageView2.setOnClickListener(new ely(this));
      localFrameLayout.setTag(localNearbyPushBanner);
      paramView.a(localFrameLayout, i1);
      i1 += 1;
    }
    return true;
  }
  
  public void b(View paramView)
  {
    if (a(paramView))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(0, Boolean.valueOf(false));
      }
      paramView.findViewById(2131297803).setVisibility(0);
      ((ADView)paramView.findViewById(2131297804)).b();
      b("0X8004C1A");
      return;
    }
    paramView.findViewById(2131297803).setVisibility(8);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903957);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager = ((NearbyBannerManager)this.app.getManager(70));
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager$INearbyBannerListener);
    this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper = new CarrierHelper(this, null, 0);
    b();
    if (a()) {
      return true;
    }
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingNearbyBannerMgr.a();
    }
    g();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager$INearbyBannerListener);
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      ADView localADView = (ADView)this.jdField_g_of_type_AndroidViewView.findViewById(2131297804);
      if (localADView != null) {
        localADView.a();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) || (this.jdField_c_of_type_Boolean)) {
      ThreadManager.c(new ell(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.a(this.app);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(false));
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
    }
    h();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(true));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == jdField_c_of_type_Int)
    {
      if (paramInt2 == -1)
      {
        localObject = new NearPeopleFilterActivity.NearPeopleFilters();
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).i = paramIntent.getIntExtra("gender", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).j = paramIntent.getIntExtra("time", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).k = paramIntent.getIntExtra("age", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l = paramIntent.getIntExtra("xingzuo", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).m = paramIntent.getIntExtra("key_career", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[0] = paramIntent.getStringExtra("key_hometown_country");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[1] = paramIntent.getStringExtra("key_hometown_province");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[2] = paramIntent.getStringExtra("key_hometown_city");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_hometown_string");
        this.jdField_b_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)localObject);
        a(true, false);
      }
      return;
    }
    if (paramInt1 == 1000)
    {
      if (paramInt2 == -1)
      {
        localObject = paramIntent.getByteArrayExtra("param_xuan_yan");
        String str = paramIntent.getStringExtra("param_nickname");
        int i1 = paramIntent.getByteExtra("param_gender", (byte)-1);
        paramInt1 = paramIntent.getIntExtra("param_age", 0);
        paramInt2 = paramIntent.getIntExtra("param_career", 0);
        byte b1 = paramIntent.getByteExtra("param_constellation", (byte)0);
        byte b2 = paramIntent.getByteExtra("param_marital_status", (byte)0);
        int i2 = paramIntent.getIntExtra("param_photo_count", 0);
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
          if ((paramIntent instanceof RespEncounterInfo))
          {
            paramIntent = (RespEncounterInfo)paramIntent;
            if ((paramIntent.lEctID > 0L) && (this.app.a().equals(String.valueOf(paramIntent.lEctID))))
            {
              if (paramIntent.richState == null) {
                paramIntent.richState = new RishState();
              }
              paramIntent.richState.vState = ((byte[])localObject);
              paramIntent.strNick = str;
              paramIntent.cSex = i1;
              paramIntent.cAge = ((byte)paramInt1);
              paramIntent.profession_id = paramInt2;
              paramIntent.constellation = b1;
              paramIntent.marriage = b2;
              paramIntent.nFaceNum = i2;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a());
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a())) && (i1 != this.t))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
          this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k = 0;
          this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l = 0;
          this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j = 4;
          this.t = i1;
          if (this.t != 0) {
            break label523;
          }
        }
      }
      label523:
      for (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 2;; this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 0)
      {
        a(true, false);
        ThreadManager.a().post(new elx(this));
        return;
      }
    }
    a(true, false);
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 5);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
        if (paramView != this.jdField_a_of_type_ArrayOfAndroidViewView[i1]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      Intent localIntent;
      switch (i1)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(6);
          }
          do
          {
            return;
            a(paramView);
            return;
            if (!NetworkUtil.e(this))
            {
              a(1, getString(2131367328));
              return;
            }
            a(false, true);
          } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport == null);
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(3);
          return;
          i1 += 1;
          break;
          paramView = new Intent(this, NearbyTroopsLocationActivity.class);
          paramView.putExtra("lat", this.p);
          paramView.putExtra("lon", this.q);
          paramView.putExtra("location_name", getResources().getString(2131365804));
          paramView.putExtra("from", 23);
          paramView.putExtra("mode", 1);
          NearbyTroopsLocationActivity.a(this, this.app, paramView);
          b("0X8004EC7");
          ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "grp", "nearclick", 0, 0, "", "", "", "");
          ((RedTouchManager)this.app.getManager(35)).b(jdField_a_of_type_ArrayOfJavaLangString[0]);
          continue;
          b("0X8004EC8");
          paramView = new StringBuilder("https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city&from=nearby_new");
          if ((this.p != 0) && (this.q != 0) && (this.jdField_a_of_type_Long != 0L)) {
            paramView.append("&maplng=" + this.q + "&maplat=" + this.p + "&coordinate=1&loctime" + this.jdField_a_of_type_Long);
          }
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("isShowAd", false);
          localIntent.putExtra("url", paramView.toString());
          localIntent.putExtra("hide_operation_bar", true);
          localIntent.putExtra("hide_more_button", true);
          startActivity(localIntent);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.nearby", 4, "ReportController:0X8004EC8");
          }
          ((RedTouchManager)this.app.getManager(35)).b(String.valueOf("100510.100514"));
          continue;
          paramView = new Intent(this, DatingFeedActivity.class);
          paramView.putExtra("FROM_WHERE", 0);
          startActivity(paramView);
          paramView = (RedTouchManager)this.app.getManager(35);
          paramView.a("100510.100511");
          paramView.b(String.valueOf("100510.100511"));
          continue;
          ReportController.b(this.app, "CliOper", "", "", "0X8004410", "0X8004410", 1, 0, "", "", "", "");
          HotChatListActivity.a();
          ((RedTouchManager)this.app.getManager(35)).b(String.valueOf("100510.100512"));
        }
      }
      a(this.app, "0X800513E");
      paramView = (DatingManager)this.app.getManager(67);
      if (paramView != null)
      {
        i1 = paramView.b();
        if (i1 == 1)
        {
          paramView = String.format("%s?sex=%d", new Object[] { "https://ti.qq.com/plaza/", Integer.valueOf(0) });
          label676:
          DatingUtil.a("NEARBY_SQUARE", new Object[] { paramView });
        }
      }
      for (;;)
      {
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("isShowAd", false);
        localIntent.putExtra("url", paramView);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ((RedTouchManager)this.app.getManager(35)).b(String.valueOf("100510.100515"));
        break;
        if (i1 == 2)
        {
          paramView = String.format("%s?sex=%d", new Object[] { "https://ti.qq.com/plaza/", Integer.valueOf(1) });
          break label676;
        }
        paramView = "https://ti.qq.com/plaza/";
        break label676;
        paramView = "https://ti.qq.com/plaza/";
      }
      i1 = -1;
    }
  }
  
  public void onDismiss()
  {
    if (this.jdField_g_of_type_Boolean) {
      b("0X8004445");
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */