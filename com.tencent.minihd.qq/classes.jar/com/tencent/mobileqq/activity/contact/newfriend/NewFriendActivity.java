package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.service.circle.ISwitchObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ghn;
import gho;
import ghp;
import ghs;
import ghv;
import ghw;
import ghx;
import ghy;
import ghz;
import java.util.Observable;
import java.util.Observer;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 0;
  public static final String a = "_key_mode";
  public static final int b = 1;
  public static final String b = "enter_cricle_view";
  static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "NewFriendManager";
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "newfriend_";
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = -1000;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ghp(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseNewFriendView.INewFriendContext jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext;
  private BaseNewFriendView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView;
  private CircleGroupListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView;
  private RecommendListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  public CircleManager a;
  private ISwitchObserver jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver = new ghv(this);
  IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new gho(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  boolean jdField_d_of_type_Boolean;
  private boolean e;
  private int h = 0;
  private int i = 0;
  private int j = 3;
  private int k;
  
  private int a()
  {
    return getSharedPreferences("newfriend_" + this.app.a(), 0).getInt("_key_mode", -1000);
  }
  
  private void a(int paramInt)
  {
    getSharedPreferences("newfriend_" + this.app.a(), 0).edit().putInt("_key_mode", paramInt).commit();
  }
  
  private void a(boolean paramBoolean)
  {
    NewFriendManager localNewFriendManager = (NewFriendManager)this.app.getManager(33);
    if (paramBoolean)
    {
      this.app.a().addObserver(this);
      localNewFriendManager.addObserver(this);
    }
    do
    {
      return;
      localNewFriendManager.deleteObserver(this);
    } while (this.app.a() == null);
    this.app.a().deleteObserver(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getWindow().getDecorView().findViewById(2131296742);
        } while (localObject == null);
        localObject = ((View)localObject).getParent();
      } while ((localObject == null) || (!(localObject instanceof FrameLayout)));
      localObject = (FrameLayout)localObject;
      if (paramBoolean1) {
        ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      }
    } while (!paramBoolean2);
    ((FrameLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.k);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) || (!paramBoolean)) {
      a(false, true);
    }
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = getSharedPreferences(this.app.a(), 0);
      l = localSharedPreferences.getLong("newfriend_enter_time", -100L);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "enterTime: " + l);
      }
    } while ((l != -100L) || ((this.jdField_a_of_type_AndroidViewView != null) && (paramBoolean)));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getApplicationContext()).inflate(2130903978, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ghy(this, localSharedPreferences));
    a(true, false);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.k = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = new ghn(this);
  }
  
  private void f()
  {
    setContentView(2130903977);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296742));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298589));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298590));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298591));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297738));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297361));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131366042), 16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131366041), 16);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.app.getManager(34));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("人脉圈");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131365736);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      h();
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("取消本次转发");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131367261));
      return;
    }
    this.e = getIntent().getBooleanExtra("enter_cricle_view", false);
    label433:
    RelativeLayout localRelativeLayout;
    if (this.e)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("人脉圈");
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
      ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Circle_grplist_exp", 0, 0, "", "", "", "");
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!this.e) {
        break label528;
      }
    }
    label528:
    for (int m = 8;; m = 0)
    {
      localRelativeLayout.setVisibility(m);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838415);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ghz(this));
      j();
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("新朋友");
      g();
      a(true);
      i();
      break label433;
    }
  }
  
  private void g()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    NewFriendManager localNewFriendManager = (NewFriendManager)this.app.getManager(33);
    if (localNewFriendManager != null) {}
    for (int m = localNewFriendManager.a();; m = 0)
    {
      if (localQQMessageFacade != null)
      {
        m = localQQMessageFacade.e() - m;
        if ((m > 0) && (m <= 99)) {}
      }
      else
      {
        return;
      }
      new StringBuilder().append("").append(m).toString();
      return;
    }
  }
  
  private void h()
  {
    b(true);
    a();
  }
  
  private void i()
  {
    boolean bool2 = true;
    Object localObject = (NewFriendManager)this.app.getManager(33);
    this.h = ((NewFriendManager)localObject).a(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView))
    {
      RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1);
      if (this.h > 0)
      {
        bool1 = true;
        localRedDotTextView.a(bool1);
      }
    }
    else
    {
      this.i = ((NewFriendManager)localObject).a(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
        if (this.i <= 0) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((RedDotTextView)localObject).a(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void j()
  {
    if (this.e)
    {
      h();
      return;
    }
    switch (getIntent().getIntExtra("_key_mode", -1000))
    {
    }
    do
    {
      k();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
      if (this.i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        this.i = 0;
        return;
      }
    } while (this.h <= 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
    this.h = 0;
  }
  
  private void k()
  {
    switch (a())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
  }
  
  public View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView = new CircleGroupListView(this, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView);
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    if (!this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131366678, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131366679, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131366680, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  void a(BaseNewFriendView paramBaseNewFriendView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != paramBaseNewFriendView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView = paramBaseNewFriendView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = new RecommendListView(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = new SystemMsgListView(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView);
  }
  
  void d()
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (!this.e)
    {
      localActionSheet.a(getString(2131366678), 0, false, false);
      localActionSheet.a(getString(2131366679), 0, false, false);
    }
    for (;;)
    {
      localActionSheet.a(new ghs(this, localActionSheet));
      localActionSheet.e(2131365736);
      localActionSheet.show();
      return;
      String str = getString(2131366680);
      if (!this.jdField_c_of_type_Boolean) {
        bool = true;
      }
      localActionSheet.a(str, bool);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      getSharedPreferences(this.app.a(), 0).edit().putLong("newfriend_enter_time", System.currentTimeMillis()).commit();
    }
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903977);
    setContentBackgroundResource(2130837687);
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    a(false);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    j();
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
    }
    this.d = false;
    if (!this.e) {
      a(this.j);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
    }
    this.d = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
    }
    super.doOnStop();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
    } while (!this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 11))
    {
      ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_c_of_type_Boolean = false;
    }
    setResult(1);
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof NewFriendMessage)) {
      runOnUiThread(new ghw(this, paramObject));
    }
    int m;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      int n = 1;
      m = n;
      if ((paramObject instanceof ChatMessage))
      {
        m = n;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          m = 0;
        }
      }
    } while (m == 0);
    runOnUiThread(new ghx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */