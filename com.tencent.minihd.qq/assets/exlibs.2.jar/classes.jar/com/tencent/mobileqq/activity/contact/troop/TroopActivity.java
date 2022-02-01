package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.BadTokenException;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import gjy;
import gjz;
import gka;
import gkb;
import gkc;
import gkd;
import gke;
import gkf;
import gkg;
import gkh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  public static final int a = 0;
  public static final String a = "onlyOneSegement";
  public static final int b = 0;
  public static final String b = "_key_mode";
  public static final int c = 1;
  public static final String c = "messageTab";
  public static final int d = 1;
  public static final String d = "key_tab_mode";
  public static final int e = 4;
  public static final int f = 0;
  protected static final String f = "noti_and_rec_last_tab_mode";
  public static final int g = 1;
  private static final String g = "last_tab_mode";
  public static final int h = 2;
  public static final int k = 1234;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gkb(this);
  public View a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new gke(this);
  protected Animation a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected LinearLayout a;
  protected RelativeLayout a;
  private BaseTroopView.ITroopContext jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext;
  private BaseTroopView jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new gkd(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new gkf(this);
  protected View b;
  protected Animation b;
  RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  protected LinearLayout b;
  protected boolean b;
  protected LinearLayout c;
  protected boolean c;
  protected LinearLayout d;
  protected boolean d;
  protected String e;
  boolean e;
  public int i = 0;
  public int j = 0;
  private int l = 0;
  private int m = 0;
  
  public TroopActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "DEFAULT";
    this.jdField_d_of_type_Boolean = false;
  }
  
  private int a()
  {
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0)) {
      return localSharedPreferences.getInt("last_tab_mode", 0);
    }
  }
  
  private BaseTroopView a(int paramInt)
  {
    Object localObject;
    if (paramInt >= 4) {
      localObject = null;
    }
    BaseTroopView localBaseTroopView;
    do
    {
      return localObject;
      localBaseTroopView = (BaseTroopView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localBaseTroopView;
    } while (localBaseTroopView != null);
    if (this.j != 2) {
      switch (paramInt)
      {
      default: 
        localObject = new TroopView(this, this.jdField_b_of_type_Boolean);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
      return localObject;
      localObject = new TroopView(this, this.jdField_b_of_type_Boolean);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 1: 
        localObject = new RecommendTroopView(this);
        break;
      case 0: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new gjy(this);
  }
  
  private void a(int paramInt, String paramString)
  {
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a(this, paramInt, paramString);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363947, new Integer(0), this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363948, new Integer(1), this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
  }
  
  private void b()
  {
    ((TextView)findViewById(2131297357)).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297361));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298590));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.jdField_a_of_type_Boolean = true;
    TextView localTextView;
    if (this.j != 2) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localTextView = (TextView)findViewById(2131297348);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131298589).setVisibility(8);
          if (this.i == 0) {
            localTextView.setText(2131366004);
          }
        }
        if (this.j == 2) {
          break label304;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131366004));
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localTextView.setText(2131363982);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298591));
      f();
      d();
      e();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838415);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838415);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new gka(this));
      break;
      label304:
      localTextView.setText(2131366005);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131365774));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131366006));
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131363947, 5);
    localActionSheet.a(2131363948, 5);
    localActionSheet.e(2131365736);
    localActionSheet.a(new gkc(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (this != null) && (!isFinishing())) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void d()
  {
    if (isFinishing()) {}
    BaseTroopView localBaseTroopView1;
    do
    {
      NewFriendManager localNewFriendManager;
      do
      {
        do
        {
          return;
        } while (this.j != 2);
        localBaseTroopView1 = a(1);
        localNewFriendManager = (NewFriendManager)this.app.getManager(33);
        BaseTroopView localBaseTroopView2 = a(0);
        if (this.i == 1)
        {
          int n = GroupSystemMsgController.a().a(this.app);
          if ((!localBaseTroopView2.a()) && (n > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(true);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
          return;
        }
      } while (this.i != 0);
      this.l = localNewFriendManager.a(3);
    } while (this.j != 0);
    if ((!localBaseTroopView1.a()) && (this.l > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(false);
  }
  
  private void e()
  {
    if (this.j != 2)
    {
      switch (this.i)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    switch (this.i)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298678);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298679);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298680));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968653);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968651);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298681));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298874));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298876));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299329));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("创建群");
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription("添加群");
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription("群消息设置");
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setContentDescription("创建讨论组");
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 49);
    localIntent.putExtra("display_like_dialog", true);
    startActivityForResult(localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    BaseTroopView localBaseTroopView = a(paramInt);
    if (localBaseTroopView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == localBaseTroopView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
  }
  
  public void a(View paramView)
  {
    IconPopupWindow localIconPopupWindow = new IconPopupWindow(this);
    gkg localgkg = new gkg(this, localIconPopupWindow);
    localIconPopupWindow.a(2131363247, localgkg);
    localIconPopupWindow.a(2131367980, localgkg);
    localIconPopupWindow.a(2131363249, localgkg);
    localIconPopupWindow.a(paramView, 1);
  }
  
  public void a(boolean paramBoolean) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903514);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = (NewFriendManager)this.app.getManager(33);
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("fromH5", false);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("troopType");
    this.j = getIntent().getIntExtra("key_tab_mode", 0);
    this.i = getIntent().getIntExtra("_key_mode", a());
    if (this.i == 4) {
      this.i = a();
    }
    if (this.j == 2)
    {
      if (GroupSystemMsgController.a().a(this.app) <= 0) {
        break label268;
      }
      this.i = 0;
      if (this.i != 1) {
        break label286;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.j = getIntent().getIntExtra("key_tab_mode", 0);
      a();
      b();
      return true;
      label268:
      if (RecommendTroopManagerImp.a(this.app) <= 0) {
        break;
      }
      this.i = 1;
      break;
      label286:
      if (this.i == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    ((NewFriendManager)this.app.getManager(33)).deleteObserver(this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.h();
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      b(this.i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
    }
    this.jdField_e_of_type_Boolean = false;
    if (!this.jdField_a_of_type_Boolean) {
      b(this.i);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.jdField_e_of_type_Boolean = true;
    d();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(4, this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_e_of_type_JavaLangString = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968591);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new gkh(this));
    }
    for (;;)
    {
      return true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
        if (localBaseTroopView != null) {
          localBaseTroopView.a(paramMessage);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.i = 1;
      e();
      if (paramIntent != null)
      {
        String str1 = paramIntent.getStringExtra("roomId");
        if (str1 != null)
        {
          String str2 = ContactUtils.a(this.app, getApplicationContext(), str1);
          Intent localIntent = new Intent(getActivity(), ChatActivity.class);
          localIntent.putExtra("uin", str1);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", str2);
          startActivity(localIntent);
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.isShown()))
    {
      a(true);
      return true;
    }
    return super.onBackEvent();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new gjz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */