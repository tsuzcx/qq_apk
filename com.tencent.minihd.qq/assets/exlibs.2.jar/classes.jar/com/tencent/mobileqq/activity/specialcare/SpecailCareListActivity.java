package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import han;
import hao;
import hap;
import haq;
import har;
import has;
import hat;
import hau;
import hav;
import haw;
import hax;
import hay;
import haz;
import hba;
import hbb;
import hbc;
import hbe;
import hbf;
import hbh;
import hbi;
import hbj;
import hbk;
import hbl;
import hbm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ActivateFriendGrid.GridCallBack, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final int jdField_a_of_type_Int = 300;
  static final long jdField_a_of_type_Long = 500L;
  static final String jdField_a_of_type_JavaLangString = "SpecailCareListActivity";
  static final int jdField_b_of_type_Int = 2000;
  static final long jdField_b_of_type_Long = 1000L;
  static final String jdField_b_of_type_JavaLangString = "管理";
  static final int jdField_c_of_type_Int = 2001;
  static final String jdField_c_of_type_JavaLangString = "完成";
  static final int d = 2002;
  static final int e = 1;
  static final int f = 2;
  private static final int k = 16;
  private static final int l = 46;
  private static final int m = 8;
  private static final int n = 34;
  private static final int o = 46;
  private static final int p = 46;
  private static final int q = 8;
  private static final int r = 46;
  private static final int s = 8;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public ActivateFriendGrid a;
  public SpecailCareListActivity.ViewHolderLayoutParams a;
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new hbb(this);
  public FriendsManager a;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FaceDecoder a;
  public PullRefreshHeader a;
  public QQProgressDialog a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new hay(this);
  public XListView a;
  public hbl a;
  hbm jdField_a_of_type_Hbm = new hbm(this, null);
  public ArrayList a;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  View jdField_b_of_type_AndroidViewView;
  public SpecailCareListActivity.ViewHolderLayoutParams b;
  public ArrayList b;
  public boolean b;
  public View c;
  public boolean c;
  public int g;
  int h;
  int i;
  public int j = 0;
  
  public SpecailCareListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new han(this);
  }
  
  public SpannableString a(Friends paramFriends, SpecailCareListActivity.ViewHolder paramViewHolder)
  {
    Object localObject = (StatusManager)this.app.getManager(14);
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    if ((localObject == null) || (localFriendsManager == null)) {
      return null;
    }
    paramFriends = localFriendsManager.a(paramFriends.uin);
    boolean bool;
    if (paramFriends != null) {
      if (this.j != 0)
      {
        bool = true;
        paramFriends = paramFriends.getRichStatus(bool);
        label71:
        if (TextUtils.isEmpty(paramFriends.c)) {
          break label185;
        }
        localObject = ((StatusManager)localObject).a(paramFriends.b, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        int i1 = this.h;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i1), i1);
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
    }
    for (;;)
    {
      paramFriends = paramFriends.a(null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramFriends);
      return paramFriends;
      bool = false;
      break;
      paramFriends = RichStatus.a();
      break label71;
      label185:
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b();
    if ((localList == null) || (localList.size() <= 0))
    {
      b();
      this.leftView.setVisibility(0);
      this.jdField_c_of_type_Boolean = false;
      this.rightViewText.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "refreshSpecialCareData cost time = " + (l2 - l1));
      }
      return;
      this.rightViewText.setVisibility(0);
      if (this.jdField_c_of_type_Boolean) {
        this.rightViewText.setText("完成");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos return size:" + localList.size());
        }
        int i1 = 0;
        while (i1 < localList.size())
        {
          Object localObject = (SpecialCareInfo)localList.get(i1);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((SpecialCareInfo)localObject).uin);
          if (localObject != null) {
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          i1 += 1;
        }
        this.rightViewText.setText("管理");
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      ThreadManager.b(new hbf(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    for (;;)
    {
      return;
      if (this.j != 0)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (SpecailCareListActivity.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((SpecailCareListActivity.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
          {
            ((SpecailCareListActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    getPreferences(0).edit().putBoolean("enterSpecailCare" + this.app.a() + "_" + paramInt, paramBoolean).commit();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.j = paramInt;
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Hbl.notifyDataSetChanged();
      this.jdField_b_of_type_Boolean = false;
    }
    while (paramInt != 0) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i2 = this.h;
    paramInt = 0;
    label49:
    SpecailCareListActivity.ViewHolder localViewHolder;
    if (paramInt < i1)
    {
      localViewHolder = (SpecailCareListActivity.ViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_JavaLangString != null) && (localViewHolder.jdField_a_of_type_JavaLangString.length() > 0))
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localViewHolder.jdField_a_of_type_JavaLangString);
        if (paramAbsListView == null) {
          break label224;
        }
        paramAbsListView = paramAbsListView.getRichStatus(false);
        label117:
        if (TextUtils.isEmpty(paramAbsListView.c)) {
          break label231;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramAbsListView.b, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i2), i2);
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
    }
    for (;;)
    {
      paramAbsListView = paramAbsListView.a(null);
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramAbsListView);
      paramInt += 1;
      break label49;
      break;
      label224:
      paramAbsListView = RichStatus.a();
      break label117;
      label231:
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) || (paramAbsListView == null)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int i2 = paramAbsListView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onScroll.firstVisibleItem=" + paramInt1 + ", visibleItemCount=" + paramInt2 + ",totalItemCount=" + paramInt3 + ",addBtnBottom=" + i1 + ",listviewBottom=" + i2 + ",mBottomBtnBottomMargin=" + this.i);
    }
    if (paramInt1 + paramInt2 == paramInt3)
    {
      if ((i1 > this.i) && (i2 >= i1 - this.i))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (!getPreferences(0).getBoolean("enterSpecailCare" + this.app.a() + "_" + paramInt, false)) {
      bool = true;
    }
    return bool;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Hbl != null) && (this.jdField_a_of_type_Hbl.a() != null)) {
      return;
    }
    if (((FriendsManager)this.app.getManager(49)).c() > 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2130904026, null);
      if (this.jdField_a_of_type_Hbl == null) {
        break;
      }
      this.jdField_a_of_type_Hbl.a(localView);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904029, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.a(75.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new hbh(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131300556));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131296449));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (hbk)localIterator.next();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((hbk)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((hbk)localObject2).jdField_a_of_type_JavaLangString + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((hbk)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((hbk)localObject2).b);
        if (i1 >= 6) {
          break label423;
        }
        ((ArrayList)localObject1).add(localObject2);
        i1 += 1;
      }
    }
    label403:
    label423:
    for (;;)
    {
      break;
      ReportController.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i1), "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, (ArrayList)localObject1);
      if (this.jdField_c_of_type_AndroidViewView.getParent() == null)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label403;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).addView(this.jdField_c_of_type_AndroidViewView);
      }
      for (;;)
      {
        setRightButton(2131369844, this);
        return;
        ((FrameLayout)getWindow().getDecorView()).addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getParent() != null))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        break label56;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.rightViewText.setVisibility(4);
      return;
      label56:
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new hbi(this));
      this.jdField_c_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Hbl != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new hbe(this), 100L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2130904028);
    super.setTitle(2131369132);
    super.setRightButton(2131365818, this);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.g = ((int)DisplayUtils.a(this, 9.0F));
    this.h = ((int)DisplayUtils.a(this, 12.0F));
    this.i = ((int)DisplayUtils.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131300016));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297468));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131300554);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2130904025, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Hbl = new hbl(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Hbl);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903607, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492896));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840085);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_Hbm);
    a();
    ThreadManager.b(new hbc(this));
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "doOnCreate cost time = " + (l2 - l1));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_Hbm);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidViewView != null);
      ReportController.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904027, null);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131300553);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131300299).setOnClickListener(this);
      localButton.setOnClickListener(this);
    } while (this.jdField_b_of_type_AndroidViewView.getParent() != null);
    localFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  void f()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() != null))
    {
      ((FrameLayout)getWindow().getDecorView()).removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131365839);
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  void i()
  {
    this.rightViewText.setClickable(false);
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    Object localObject1 = this.rightViewText.getText().toString();
    if ("管理".equals(localObject1))
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new hbj(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i1 = 0;
      if (i1 < i2)
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(-(34.0F * this.mDensity), 0.0F, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          Object localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setStartOffset(120L);
          ((AlphaAnimation)localObject2).setDuration(180L);
          Object localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localTranslateAnimation.setAnimationListener(new hao(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject3);
          localTranslateAnimation = new TranslateAnimation(0.0F, this.mDensity * 46.0F, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localTranslateAnimation.setAnimationListener(new hap(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
          int i3 = (int)(this.mDensity * 46.0F);
          int i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject3).setFillAfter(true);
          ((AnimationSet)localObject3).setAnimationListener(new haq(this, (SpecailCareListActivity.ViewHolder)localObject1, i4));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject3);
          i3 = (int)(this.mDensity * 46.0F);
          i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localTranslateAnimation);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new har(this, (SpecailCareListActivity.ViewHolder)localObject1, i4));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          i3 = (int)(this.mDensity * 46.0F);
          i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localTranslateAnimation);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new has(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localTranslateAnimation = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(240L);
          localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject3).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
          if (!((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_Boolean) {
            break label907;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject3);
        }
        for (;;)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setFillAfter(true);
          if (i1 == i2 - 2)
          {
            localObject1 = new AlphaAnimation(1.0F, 0.0F);
            ((AlphaAnimation)localObject1).setDuration(300L);
            ((AlphaAnimation)localObject1).setAnimationListener(new hat(this));
            this.leftView.startAnimation((Animation)localObject1);
          }
          i1 += 1;
          break;
          label907:
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    else if ("完成".equals(localObject1))
    {
      j();
    }
  }
  
  void j()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.t();
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int i3 = this.jdField_a_of_type_ComTencentWidgetXListView.getBottom();
    label74:
    Object localObject1;
    if (i1 == this.jdField_a_of_type_ComTencentWidgetXListView.b() - 1) {
      if ((i2 > this.i) && (i3 >= i2 - this.i))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        i1 = 0;
        if (i1 >= i2) {
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i1).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          Object localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(180L);
          Object localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          localTranslateAnimation.setAnimationListener(new hau(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject3);
          localTranslateAnimation = new TranslateAnimation(0.0F, -(this.mDensity * 46.0F), 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localTranslateAnimation.setAnimationListener(new hav(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
          i3 = (int)(this.mDensity * 46.0F);
          int i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, -i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject3).setFillAfter(true);
          ((AnimationSet)localObject3).setAnimationListener(new haw(this, (SpecailCareListActivity.ViewHolder)localObject1, i4));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject3);
          i3 = (int)(this.mDensity * 46.0F);
          i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, -i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localTranslateAnimation);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new hax(this, (SpecailCareListActivity.ViewHolder)localObject1, i4));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          i3 = (int)(this.mDensity * 46.0F);
          i4 = (int)(8.0F * this.mDensity);
          localTranslateAnimation = new TranslateAnimation(0.0F, -i3, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, i4);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localTranslateAnimation);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new haz(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localTranslateAnimation = new TranslateAnimation(24.0F * this.mDensity, 0.0F, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localTranslateAnimation.setFillAfter(true);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setStartOffset(60L);
          ((AlphaAnimation)localObject2).setDuration(240L);
          localObject3 = new AnimationSet(true);
          ((AnimationSet)localObject3).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject3).setFillAfter(true);
          if (!((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_Boolean) {
            break label889;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject3);
        }
      }
    }
    for (;;)
    {
      if (i1 == i2 - 2)
      {
        localObject1 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new hba(this));
        this.leftView.startAnimation((Animation)localObject1);
      }
      i1 += 1;
      break label74;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      label889:
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      j();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (((paramView instanceof ImageView)) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!StringUtil.b(paramView))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!NetworkUtil.e(this)) {
          break label134;
        }
        localObject = (FriendListHandler)this.app.a(1);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramView };
        ((FriendListHandler)localObject).a(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
      }
    }
    label134:
    do
    {
      return;
      QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
      return;
      switch (paramView.getId())
      {
      case 2131300299: 
      default: 
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof SpecailCareListActivity.ViewHolder))) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        paramView = new Intent(this, ForwardFriendListActivity.class);
        paramView.putExtra("extra_choose_friend", 1);
        paramView.putExtra("extra_add_special_friend", 2);
        paramView.putExtra("display_like_dialog", true);
        startActivity(paramView);
        overridePendingTransition(2130968586, 2130968583);
        return;
      case 2131297360: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          ReportController.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
          return;
        }
        i();
        return;
      case 2131300556: 
        if (NetworkUtil.e(this)) {
          break label411;
        }
        QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
      }
    } while (!QLog.isColorLevel());
    QLog.i("SpecailCareListActivity", 2, "No Network!");
    return;
    label411:
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    Object localObject = new boolean[paramView.length];
    String[] arrayOfString = new String[paramView.length];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length];
    int i1 = 0;
    while (i1 < paramView.length)
    {
      localObject[i1] = 1;
      arrayOfString[i1] = String.valueOf(paramView[i1]);
      this.jdField_a_of_type_ArrayOfJavaLangString[i1] = arrayOfString[i1];
      i1 += 1;
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, arrayOfString, (boolean[])localObject);
    ReportController.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(paramView.length), "", "", "");
    return;
    f();
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
    paramView = new Intent(this, ForwardFriendListActivity.class);
    paramView.putExtra("extra_choose_friend", 1);
    paramView.putExtra("extra_add_special_friend", 2);
    paramView.putExtra("display_like_dialog", true);
    startActivity(paramView);
    return;
    paramView = (SpecailCareListActivity.ViewHolder)paramView;
    localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataFriends;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
      ((Intent)localObject).putExtra("key_friend_uin", paramView.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_is_from_management_activity", true);
      startActivity((Intent)localObject);
      return;
    }
    paramView = new ProfileActivity.AllInOne(((Friends)localObject).uin, 1);
    paramView.g = 59;
    paramView.i = 3;
    ProfileActivity.b(this, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */