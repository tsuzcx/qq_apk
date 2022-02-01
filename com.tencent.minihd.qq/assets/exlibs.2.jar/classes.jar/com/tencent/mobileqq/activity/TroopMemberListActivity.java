package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import fit;
import fiu;
import fiv;
import fiw;
import fix;
import fiz;
import fja;
import fjc;
import fjd;
import fje;
import fjf;
import fjg;
import fjh;
import fji;
import fjl;
import fjm;
import fjo;
import fjp;
import fjq;
import fjr;
import fjs;
import fjt;
import fju;
import fjv;
import fjw;
import fjz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TroopMemberListActivity
  extends BaseActivity
  implements IndexView.OnIndexChangedListener, AdapterView.OnItemClickListener
{
  public static final int A = 1;
  public static final int B = 2;
  public static final int C = 3;
  public static final int D = 4;
  public static final int E = 5;
  public static final int F = 6;
  public static final int G = 7;
  public static final int H = 0;
  public static final int I = 1;
  public static final int J = 2;
  public static final int K = 3;
  public static final int L = 34;
  public static final int M = 250;
  public static final int a = 1;
  public static final String a = "TroopMemberListActivity";
  public static final int b = 2;
  public static final String b = "last_update_time";
  protected static final int c = 1;
  public static final String c = "key_last_update_time";
  protected static final int d = 2;
  public static final String d = "key_last_update_num";
  protected static final int e = 5;
  public static final String e = "key_troop_info_last_update";
  protected static final int f = 6;
  public static final String f = "member_uin";
  protected static final int g = 7;
  public static final String g = "member_display_name";
  protected static final int h = 8;
  protected static final int i = 9;
  protected static final int j = 10;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 0;
  public static final String n = "param_is_pop_up_style";
  public static final int o = 1;
  public static final String o = "param_from";
  public static final int p = 2;
  public static final String p = "param_chat_mode";
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final String t = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
  public static final int u = 500;
  public static final int v = 300000;
  public static final int w = 86400000;
  public static final int x = 60000;
  public static final int z = 0;
  public float a;
  public long a;
  public Dialog a;
  protected Drawable a;
  public Handler a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  public TroopMemberListActivity.ListAdapter a;
  public TroopMemberListActivity.SearchResultAdapter a;
  protected DiscussionHandler a;
  public DiscussionObserver a;
  public TroopObserver a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public IconPopupWindow a;
  protected IndexView a;
  public PinnedDividerListView a;
  public TabBarView a;
  protected XListView a;
  public List a;
  public boolean a;
  public long b;
  public Dialog b;
  protected Drawable b;
  public View.OnClickListener b;
  protected View b;
  public RelativeLayout b;
  protected TextView b;
  protected List b;
  public boolean b;
  public Drawable c;
  public View.OnClickListener c;
  protected View c;
  protected RelativeLayout c;
  protected TextView c;
  protected List c;
  public boolean c;
  protected View d;
  public boolean d;
  public View e;
  public boolean e = false;
  protected boolean f = false;
  public boolean g = true;
  public String h = "";
  public String i = "";
  public String j = "";
  protected int k;
  public String k;
  public String l = "";
  protected String m;
  public String q = "2";
  public String r = "";
  public String s = "";
  public int t = 0;
  private String u;
  public int y = 0;
  
  public TroopMemberListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fix(this);
    this.jdField_a_of_type_AndroidOsHandler = new fjf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fjh(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new fji(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new fjl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new fjm(this);
  }
  
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, TroopMemberListActivity.class);
    paramContext.putExtra("troop_uin", paramString);
    paramContext.putExtra("param_from", paramInt);
    return paramContext;
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    if (paramInt == 0) {
      paramTextView.setBackgroundResource(2130842107);
    }
    for (;;)
    {
      paramTextView.setPadding(10, 2, 10, 2);
      return;
      if (paramInt == 1) {
        paramTextView.setBackgroundResource(2130842106);
      } else if (paramInt == 2) {
        paramTextView.setBackgroundResource(2130839510);
      } else {
        paramTextView.setBackgroundResource(2130841670);
      }
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidAppDialog = new fjz(this);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setSoftInputMode(37);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130904393);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296742);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopMemberListActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302032));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter = new TroopMemberListActivity.SearchResultAdapter(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new fiv(this, localInputMethodManager));
  }
  
  private void n()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public TroopMemberListActivity.ATroopMember a(DiscussionMemberInfo paramDiscussionMemberInfo, FriendsManagerImp paramFriendsManagerImp)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramFriendsManagerImp != null) {
      localFriends = paramFriendsManagerImp.a(paramDiscussionMemberInfo.memberUin);
    }
    localATroopMember.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.jdField_a_of_type_Short = 0;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.c(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localATroopMember.g(localFriends.remark);
      localATroopMember.i(ChnToSpell.a(localATroopMember.j, 1));
      localATroopMember.h(ChnToSpell.a(localATroopMember.j, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localATroopMember.j(paramDiscussionMemberInfo.memberName);
        localATroopMember.l(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localATroopMember.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      return localATroopMember;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localATroopMember.g(paramDiscussionMemberInfo.inteRemark);
        localATroopMember.i(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localATroopMember.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public TroopMemberListActivity.ATroopMember a(TroopMemberInfo paramTroopMemberInfo, FriendsManagerImp paramFriendsManagerImp)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Object localObject2 = localATroopMember.jdField_a_of_type_JavaLangString;
    Object localObject1;
    if (paramFriendsManagerImp != null)
    {
      localObject1 = paramFriendsManagerImp.a(paramTroopMemberInfo.memberuin);
      if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark)))
      {
        paramFriendsManagerImp = ((Friends)localObject1).remark;
        if (!TextUtils.isEmpty(paramFriendsManagerImp)) {
          break label530;
        }
        localObject2 = paramTroopMemberInfo.memberuin;
        paramFriendsManagerImp = (FriendsManagerImp)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localATroopMember.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
      localATroopMember.c(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localATroopMember.d(paramTroopMemberInfo.friendnick);
        localATroopMember.f(paramTroopMemberInfo.pyAll_friendnick);
        localATroopMember.e(paramTroopMemberInfo.pyFirst_friendnick);
      }
      if ((paramFriendsManagerImp != null) && (paramFriendsManagerImp.isFriend()) && (paramFriendsManagerImp.remark != null) && (paramFriendsManagerImp.remark.length() > 0))
      {
        localATroopMember.g(paramFriendsManagerImp.remark);
        localATroopMember.i(ChnToSpell.a(localATroopMember.j, 1));
        localATroopMember.h(ChnToSpell.a(localATroopMember.j, 2));
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.troopnick != null) && (paramTroopMemberInfo.troopnick.length() > 0))
        {
          localATroopMember.j(paramTroopMemberInfo.troopnick);
          localATroopMember.l(paramTroopMemberInfo.pyAll_troopnick);
          localATroopMember.k(paramTroopMemberInfo.pyFirst_troopnick);
        }
        localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localATroopMember.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localATroopMember.d = paramTroopMemberInfo.credit_level;
        localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localATroopMember.t = paramTroopMemberInfo.mUniqueTitle;
          localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        return localATroopMember;
        if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick))
        {
          paramFriendsManagerImp = paramTroopMemberInfo.troopnick;
          break;
        }
        if ((localObject1 != null) && (((Friends)localObject1).isFriend()))
        {
          paramFriendsManagerImp = ((Friends)localObject1).name;
          break;
        }
        paramFriendsManagerImp = (FriendsManagerImp)localObject2;
        if (paramTroopMemberInfo == null) {
          break;
        }
        if (localATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a()))
        {
          paramFriendsManagerImp = paramTroopMemberInfo.friendnick;
          break;
        }
        if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark))
        {
          paramFriendsManagerImp = paramTroopMemberInfo.autoremark;
          break;
        }
        paramFriendsManagerImp = paramTroopMemberInfo.friendnick;
        break;
        if ((paramTroopMemberInfo.autoremark != null) && (paramTroopMemberInfo.autoremark.length() > 0))
        {
          localATroopMember.g(paramTroopMemberInfo.autoremark);
          localATroopMember.i(paramTroopMemberInfo.pyAll_autoremark);
          localATroopMember.h(paramTroopMemberInfo.pyFirst_autoremark);
        }
      }
      label530:
      localObject2 = paramFriendsManagerImp;
      paramFriendsManagerImp = (FriendsManagerImp)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = localObject2;
      paramFriendsManagerImp = null;
    }
  }
  
  public TroopMemberListActivity.TmViewHolder a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int i2;
    int i1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
      i2 = ((ViewGroup)localObject1).getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label133;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof TroopMemberListActivity.TmViewHolder)))
      {
        localObject2 = (TroopMemberListActivity.TmViewHolder)((View)localObject2).getTag();
        if ((((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString != null) && (((TroopMemberListActivity.TmViewHolder)localObject2).jdField_b_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivity", 2, "findListItemHolderByUin:" + i1);
          }
          return localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
          break;
        }
      }
      i1 += 1;
    }
    label133:
    return null;
  }
  
  protected void a()
  {
    Object localObject = (ViewGroup)findViewById(2131297347);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131296488);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131297357);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(View paramView)
  {
    boolean bool = TroopMemberLbsHelper.a(this.i, this.app).booleanValue();
    String[] arrayOfString = getResources().getStringArray(2131230775);
    int i1;
    int i2;
    if (this.t == 0) {
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = arrayOfString.length;
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
        i2 = 0;
        label60:
        if (i2 >= i1) {
          break label119;
        }
        if ((bool) || (i2 != 3)) {
          break label100;
        }
      }
    }
    for (;;)
    {
      i2 += 1;
      break label60;
      i1 = arrayOfString.length - 1;
      break;
      i1 = arrayOfString.length - 3;
      break;
      label100:
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(arrayOfString[i2], this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label119:
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow, arrayOfString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 1);
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new fjw(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    int i1 = 3;
    if ((paramATroopMember == null) || (paramATroopMember.jdField_a_of_type_JavaLangString == null)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (this.t == 1)
      {
        if (this.app.a().equals(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localObject1 = new ProfileActivity.AllInOne(paramATroopMember.jdField_a_of_type_JavaLangString, 0);
          ((ProfileActivity.AllInOne)localObject1).h = ContactUtils.g(this.app, paramATroopMember.jdField_a_of_type_JavaLangString);
          ((ProfileActivity.AllInOne)localObject1).f = 3;
          ((ProfileActivity.AllInOne)localObject1).g = 4;
          ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
          return;
        }
        a(paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_b_of_type_JavaLangString);
        return;
      }
      if (this.t == 2)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("troop_uin", this.i);
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        localObject2 = new SetTroopAdminsActivity.TroopAdmin();
        ((SetTroopAdminsActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
        ((SetTroopAdminsActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramATroopMember.jdField_a_of_type_Short;
        ((SetTroopAdminsActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramATroopMember.jdField_b_of_type_JavaLangString;
        ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
        setResult(-1, (Intent)localObject1);
        finish();
        return;
      }
      if (this.t == 3)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
        setResult(-1, (Intent)localObject1);
        finish();
        return;
      }
      if ((this.t == 0) || (this.t == 4))
      {
        f(paramATroopMember.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.t != 5);
    if ((this.j != null) && (this.j.equals(paramATroopMember.jdField_a_of_type_JavaLangString)))
    {
      startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.i, paramATroopMember.jdField_a_of_type_JavaLangString, i1, paramATroopMember.t, paramATroopMember.jdField_b_of_type_Int), 2);
      this.u = paramATroopMember.jdField_a_of_type_JavaLangString;
      localObject1 = this.app;
      localObject2 = this.i;
      i1 = this.y;
      if (!this.g) {
        break label410;
      }
    }
    label410:
    for (paramATroopMember = "1";; paramATroopMember = "0")
    {
      ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramATroopMember, "");
      return;
      if ((this.jdField_k_of_type_JavaLangString != null) && (this.jdField_k_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
      {
        i1 = 2;
        break;
      }
      i1 = 1;
      break;
    }
  }
  
  protected void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = this.s;
      paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean;
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramATroopMember.jdField_b_of_type_JavaLangString);
      paramTmViewHolder.jdField_b_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
      paramTmViewHolder.e.setText("");
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean));
      paramTmViewHolder.f.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (!this.jdField_b_of_type_Boolean) {
        break label342;
      }
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
      label153:
      if (this.t != 1) {
        break label392;
      }
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131366646) + paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      if ((this.j == null) || (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.j))) {
        break label361;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label232:
      if (!str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        break label381;
      }
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    for (;;)
    {
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131366643), new Object[] { paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString() }));
      paramTmViewHolder.f.setContentDescription(getString(2131366644));
      return;
      str = this.r;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label342:
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label153;
      label361:
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label232;
      label381:
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label392:
    if (this.y == 2) {
      if (this.t != 5) {
        if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.j)))
        {
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (TextUtils.isEmpty(paramATroopMember.t))
          {
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365820);
            a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 0);
            label465:
            paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131365860, new Object[] { Long.valueOf(paramATroopMember.jdField_c_of_type_Long) }));
          }
        }
      }
    }
    label1037:
    label1350:
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankSysFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag != 1)) {
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label1867;
      }
      if ((!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.j)) && ((this.app.a().equals(this.j)) || (this.jdField_k_of_type_JavaLangString == null) || (!this.jdField_k_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))) {
        break label1829;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      return;
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
      break;
      if ((this.jdField_k_of_type_JavaLangString != null) && (this.jdField_k_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
      {
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramATroopMember.t)) {
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365819);
        }
        for (;;)
        {
          a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 1);
          break;
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
        }
      }
      if (TextUtils.isEmpty(paramATroopMember.t))
      {
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label465;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
      a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 2);
      break label465;
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.h.setVisibility(0);
      if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.j)))
      {
        paramTmViewHolder.g.setVisibility(0);
        if (TextUtils.isEmpty(paramATroopMember.t)) {
          paramTmViewHolder.g.setText(2131365820);
        }
        for (;;)
        {
          a(paramTmViewHolder.g, 0);
          break;
          paramTmViewHolder.g.setText(paramATroopMember.t);
        }
      }
      if ((this.jdField_k_of_type_JavaLangString != null) && (this.jdField_k_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
      {
        paramTmViewHolder.g.setVisibility(0);
        if (TextUtils.isEmpty(paramATroopMember.t)) {
          paramTmViewHolder.g.setText(2131365819);
        }
        for (;;)
        {
          a(paramTmViewHolder.g, 1);
          break;
          paramTmViewHolder.g.setText(paramATroopMember.t);
        }
      }
      if (!TextUtils.isEmpty(paramATroopMember.t))
      {
        paramTmViewHolder.g.setVisibility(0);
        paramTmViewHolder.g.setText(paramATroopMember.t);
        a(paramTmViewHolder.g, 2);
        break label465;
      }
      paramTmViewHolder.g.setVisibility(8);
      break label465;
      paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
      int i1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap() != null) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_a_of_type_Int)))))
      {
        i1 = 1;
        if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.j))) {
          break label1350;
        }
        if (this.t != 5) {
          break label1142;
        }
        paramTmViewHolder.g.setVisibility(0);
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramTmViewHolder.h.setVisibility(0);
        if (!TextUtils.isEmpty(paramATroopMember.t)) {
          break label1128;
        }
        paramTmViewHolder.g.setText(2131365820);
      }
      for (;;)
      {
        a(paramTmViewHolder.g, 0);
        break;
        i1 = 0;
        break label1037;
        label1128:
        paramTmViewHolder.g.setText(paramATroopMember.t);
      }
      label1142:
      if (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a()))
      {
        if (i1 != 0)
        {
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (TextUtils.isEmpty(paramATroopMember.t)) {
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365820);
          }
          for (;;)
          {
            a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 0);
            paramTmViewHolder.e.setText(getString(2131365823));
            break;
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
          }
        }
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramTmViewHolder.e.setText(getString(2131365822));
      }
      else
      {
        if (i1 != 0)
        {
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (TextUtils.isEmpty(paramATroopMember.t)) {
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365820);
          }
          for (;;)
          {
            a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 0);
            paramTmViewHolder.e.setText("");
            break;
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
          }
        }
        paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramTmViewHolder.e.setText(getString(2131365820));
        continue;
        if ((this.jdField_k_of_type_JavaLangString != null) && (this.jdField_k_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
        {
          if (this.t == 5)
          {
            paramTmViewHolder.g.setVisibility(0);
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramTmViewHolder.h.setVisibility(0);
            if (TextUtils.isEmpty(paramATroopMember.t)) {
              paramTmViewHolder.g.setText(2131365819);
            }
            for (;;)
            {
              a(paramTmViewHolder.g, 1);
              break;
              paramTmViewHolder.g.setText(paramATroopMember.t);
            }
          }
          if (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.a()))
          {
            if (i1 != 0)
            {
              paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.t)) {
                paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365819);
              }
              for (;;)
              {
                a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 1);
                paramTmViewHolder.e.setText(getString(2131365823));
                break;
                paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
              }
            }
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramTmViewHolder.e.setText(getString(2131365821));
          }
          else
          {
            if (i1 != 0)
            {
              paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              if (TextUtils.isEmpty(paramATroopMember.t)) {
                paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131365819);
              }
              for (;;)
              {
                a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 1);
                paramTmViewHolder.e.setText("");
                break;
                paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
              }
            }
            paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramTmViewHolder.e.setText(getString(2131365819));
          }
        }
        else if (this.t == 5)
        {
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramTmViewHolder.h.setVisibility(0);
          if (!TextUtils.isEmpty(paramATroopMember.t))
          {
            paramTmViewHolder.g.setVisibility(0);
            paramTmViewHolder.g.setText(paramATroopMember.t);
            a(paramTmViewHolder.g, 2);
          }
          else
          {
            paramTmViewHolder.g.setVisibility(8);
          }
        }
        else
        {
          if (i1 != 0)
          {
            if (TextUtils.isEmpty(paramATroopMember.t))
            {
              paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_a_of_type_Int)));
              a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 3);
            }
            for (;;)
            {
              paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              break;
              paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramATroopMember.t);
              a(paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView, 2);
            }
          }
          paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    label1829:
    paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (str.equals(paramATroopMember.jdField_a_of_type_JavaLangString))
    {
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
      return;
    }
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    return;
    label1867:
    paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
  }
  
  public void a(IconPopupWindow paramIconPopupWindow, String[] paramArrayOfString)
  {
    if ((paramIconPopupWindow == null) || (paramArrayOfString == null)) {
      return;
    }
    for (;;)
    {
      int i2;
      try
      {
        i2 = paramIconPopupWindow.a();
        paramIconPopupWindow = paramArrayOfString[this.y];
        if (!QLog.isColorLevel()) {
          break label146;
        }
        QLog.d("TroopMemberListActivity", 2, "checkSortType:" + paramIconPopupWindow);
      }
      catch (Exception paramIconPopupWindow) {}
      if (i1 < i2)
      {
        paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(i1);
        if ((paramArrayOfString == null) || (!paramIconPopupWindow.equals(paramArrayOfString.getText().toString()))) {
          break label151;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(i1);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopMemberListActivity", 2, "checkSortType:" + paramIconPopupWindow.toString());
        return;
      }
      int i1 = -1;
      continue;
      label146:
      i1 = 0;
      continue;
      label151:
      i1 += 1;
    }
  }
  
  protected void a(AdapterView paramAdapterView, int paramInt)
  {
    paramAdapterView = (TroopMemberListActivity.ATroopMember)paramAdapterView.a().getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    a(paramAdapterView);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendManager)this.app.getManager(8);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.jdField_a_of_type_Int = 20;
        paramString1.d = this.h;
        paramString1.jdField_c_of_type_JavaLangString = this.i;
        paramString1.g = 4;
        ProfileActivity.b(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.jdField_a_of_type_Int = 21;
    paramString1.d = this.h;
    paramString1.jdField_c_of_type_JavaLangString = this.i;
    paramString1.g = 4;
    ProfileActivity.b(this, paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivity", 2, "doReport, actionName=" + paramString1 + " ext2=" + paramString2 + " ext3=" + paramString3 + " from=" + this.t);
      }
      if (this.t == 1) {
        return;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.i, paramString2, paramString3, "");
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivity", 2, "doReport:" + paramString1.toString());
      }
    }
  }
  
  public Object[] a(String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList;
    long l1;
    Object localObject;
    long l2;
    int i2;
    try
    {
      localArrayList = new ArrayList();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = (FriendsManagerImp)this.app.getManager(8);
        this.jdField_c_of_type_JavaUtilList = ((DiscussionManager)this.app.getManager(51)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
        }
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label536;
        }
        i2 = this.jdField_c_of_type_JavaUtilList.size();
        if (i1 < i2)
        {
          paramString = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
          if (paramString == null) {
            break label541;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if ((this.t == 2) && (paramString.memberUin.equals(this.j))) {
              break label541;
            }
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label541;
            }
            QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB:" + paramString.toString());
        }
        paramString = new Object[1];
        paramString[0] = localArrayList;
        return paramString;
        localArrayList.add(a(paramString, (FriendsManagerImp)localObject));
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label310:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.a() == null) {
        break label548;
      }
    }
    finally {}
    this.app.a().f();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + localArrayList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(localArrayList);
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[4];
        paramString[0] = localArrayList;
        paramString[1] = localObject[0];
        paramString[2] = localObject[1];
        paramString[3] = localObject[2];
        break label310;
      }
      paramString = new Object[1];
      paramString[0] = localArrayList;
      break label310;
      label536:
      i1 = 0;
      continue;
      label541:
      i1 += 1;
      break;
      label548:
      i1 = i2;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302355));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296488);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    if (this.t == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297358));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297361));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131302140));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302098));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131296735);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131365861));
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "removeSearchItem:" + paramString);
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_b_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public Object[] b(String paramString)
  {
    ArrayList localArrayList;
    long l1;
    Object localObject;
    long l2;
    int i1;
    int i2;
    try
    {
      localArrayList = new ArrayList();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = this.app.a().createEntityManager();
        paramString = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).a();
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB, queryTime:" + (l2 - l1));
        }
        i1 = 0;
        if (paramString == null) {
          break label409;
        }
        localObject = (FriendsManagerImp)this.app.getManager(8);
        i2 = paramString.size();
        i1 = 0;
        if (i1 < i2)
        {
          localTroopMemberInfo = (TroopMemberInfo)paramString.get(i1);
          if (localTroopMemberInfo == null) {
            break label546;
          }
          if (Utils.c(localTroopMemberInfo.memberuin))
          {
            if (this.t == 2)
            {
              if (localTroopMemberInfo.memberuin.equals(this.j)) {
                break label546;
              }
              if (this.jdField_k_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin)) {
                break label546;
              }
            }
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label546;
            }
            QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB, continued, tmi.memberuin:" + localTroopMemberInfo.memberuin);
          }
        }
      }
      catch (Exception paramString)
      {
        TroopMemberInfo localTroopMemberInfo;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB:" + paramString.toString());
        }
        paramString = new Object[1];
        paramString[0] = localArrayList;
        return paramString;
        localArrayList.add(a(localTroopMemberInfo, (FriendsManagerImp)localObject));
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label319:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.a() == null) {
        break label553;
      }
    }
    finally {}
    this.app.a().f();
    for (;;)
    {
      label409:
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "getTroopMemberFromDB, totalTime:" + (l2 - l1) + ", listSize:" + localArrayList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(localArrayList);
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[4];
        paramString[0] = localArrayList;
        paramString[1] = localObject[0];
        paramString[2] = localObject[1];
        paramString[3] = localObject[2];
        break label319;
      }
      paramString = new Object[1];
      paramString[0] = localArrayList;
      break label319;
      label546:
      i1 += 1;
      break;
      label553:
      i1 = i2;
    }
  }
  
  protected void c()
  {
    if (this.t == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367857));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367064));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131366645));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new fit(this));
      return;
    }
    if (this.t == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131365824));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131366374);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new fjg(this));
      return;
    }
    if (this.t == 3)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363739));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131365736);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new fjp(this));
      return;
    }
    if (this.t == 5)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364001));
      if (this.m == null) {
        this.m = getString(2131366374);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.m);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new fjq(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131365817));
    if (this.m == null) {
      this.m = getString(2131366374);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.m);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new fjr(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367064);
    if (this.t != 4)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "removeItem:" + paramString);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_a_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public void d()
  {
    if ((this.t == 2) || (this.t == 3) || (this.t == 0) || (this.t == 5)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new fjs(this));
    }
    if (this.t == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new fjt(this));
    }
  }
  
  protected void d(String paramString)
  {
    this.s = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    String str1 = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramString = this.jdField_a_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label855;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
        localATroopMember.e = "";
        localATroopMember.f = "";
        if ((str1.equals(localATroopMember.m)) || (str1.equals(localATroopMember.o)) || (str1.equals(localATroopMember.n)))
        {
          localATroopMember.e = localATroopMember.m;
          localArrayList1.add(localATroopMember);
        }
        else if ((str1.equals(localATroopMember.j)) || (str1.equals(localATroopMember.l)) || (str1.equals(localATroopMember.jdField_k_of_type_JavaLangString)))
        {
          localATroopMember.e = localATroopMember.j;
          localArrayList1.add(localATroopMember);
        }
      }
      finally {}
      if ((str2.equals(localATroopMember.g)) || (str2.equals(localATroopMember.i)) || (str2.equals(localATroopMember.h)))
      {
        localATroopMember.e = localATroopMember.g;
        localArrayList1.add(localATroopMember);
      }
      else if (str2.equals(localATroopMember.jdField_a_of_type_JavaLangString))
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList1.add(localATroopMember);
      }
      else if ((localATroopMember.m.indexOf(str2) == 0) || (localATroopMember.o.indexOf(str2) == 0) || (localATroopMember.n.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.m;
        localATroopMember.f = localATroopMember.n;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.j.indexOf(str2) == 0) || (localATroopMember.l.indexOf(str2) == 0) || (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.j;
        localATroopMember.f = localATroopMember.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.g.indexOf(str2) == 0) || (localATroopMember.i.indexOf(str2) == 0) || (localATroopMember.h.indexOf(str2) == 0))
      {
        localATroopMember.e = localATroopMember.g;
        localATroopMember.f = localATroopMember.h;
        localArrayList2.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) == 0)
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localATroopMember.f = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.m.indexOf(str2) > 0) || (localATroopMember.o.indexOf(str2) > 0) || (localATroopMember.n.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.m;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.j.indexOf(str2) > 0) || (localATroopMember.l.indexOf(str2) > 0) || (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.j;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.g.indexOf(str2) > 0) || (localATroopMember.i.indexOf(str2) > 0) || (localATroopMember.h.indexOf(str2) > 0))
      {
        localATroopMember.e = localATroopMember.g;
        localArrayList3.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(str2) > 0)
      {
        localATroopMember.e = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
        break label946;
        label855:
        Collections.sort(localArrayList2, new TroopMemberListActivity.SearchResultComparator(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          return;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      label946:
      i1 += 1;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent arg3)
  {
    int i1 = -1;
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    label163:
    label447:
    Object localObject3;
    do
    {
      do
      {
        return;
        if (???.getBooleanExtra("isNeedFinish", false))
        {
          ??? = new Intent();
          ???.putExtra("isNeedFinish", true);
          setResult(-1, ???);
          finish();
          return;
        }
        Object localObject1 = "";
        paramInt1 = i1;
        if (??? != null)
        {
          paramInt1 = ???.getIntExtra("memberOperationFlag", -1);
          localObject1 = ???.getStringExtra("memberOperateUin");
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + paramInt1 + ", optUin=" + (String)localObject1);
        }
        if (paramInt1 == 1) {
          c((String)localObject1);
        }
        while ((paramInt1 >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          return;
          if (paramInt1 == 0)
          {
            TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.app, this.i, (String)localObject1);
            if ((localTroopMemberInfo != null) && (localFriendsManagerImp != null))
            {
              c((String)localObject1);
              synchronized (this.jdField_a_of_type_JavaUtilList)
              {
                localObject1 = a(localTroopMemberInfo, localFriendsManagerImp);
                this.jdField_a_of_type_JavaUtilList.add(localObject1);
              }
            }
          }
          else if ((paramInt1 == 2) && (localFriendsManagerImp != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localFriendsManagerImp.a(this.i);
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
                this.j = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
                this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
              }
              if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.app.a()))) && ((this.jdField_k_of_type_JavaLangString == null) || (!this.jdField_k_of_type_JavaLangString.contains(this.app.a())))) {
                break label447;
              }
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_Boolean = bool;
          if (!QLog.isColorLevel()) {
            break label163;
          }
          QLog.d("TroopMemberListActivity", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.jdField_k_of_type_JavaLangString + " owner:" + this.j);
          break label163;
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (TextUtils.isEmpty(this.u));
      localObject3 = DBUtils.a().a(this.app, this.i, this.u);
    } while ((localObject3 == null) || (localFriendsManagerImp == null));
    c(this.u);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localObject3 = a((TroopMemberInfo)localObject3, localFriendsManagerImp);
      this.jdField_a_of_type_JavaUtilList.add(localObject3);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      return;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = getIntent().getExtras();
    this.i = ((Bundle)localObject).getString("troop_uin");
    this.m = ((Bundle)localObject).getString("leftViewText");
    this.f = ((Bundle)localObject).getBoolean("param_is_pop_up_style", false);
    this.t = ((Bundle)localObject).getInt("param_from", 0);
    this.jdField_k_of_type_Int = ((Bundle)localObject).getInt("param_chat_mode", 0);
    localObject = ((Bundle)localObject).getString("param_from");
    if (localObject != null) {}
    try
    {
      this.t = Integer.parseInt((String)localObject);
      label81:
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "doOnCreate, troopCode=" + this.i + " troopUin=" + this.h + " from=" + this.t);
      }
      super.doOnCreate(paramBundle);
      setContentView(2130904499);
      b();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
      this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      paramBundle = (FriendManager)this.app.getManager(8);
      if (paramBundle != null)
      {
        if (this.t != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.i);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
        }
        for (this.h = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode; (this.t == 5) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.a())); this.h = this.i)
        {
          finish();
          return false;
          finish();
          return false;
          this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramBundle.a(this.i);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
      }
      finish();
      return false;
      boolean bool;
      label482:
      label487:
      String str;
      if (this.t == 1)
      {
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        ChnToSpell.a(this);
        if (this.t == 1) {
          break label684;
        }
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label666;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.j = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.app.a()))) && ((this.jdField_k_of_type_JavaLangString == null) || (!this.jdField_k_of_type_JavaLangString.contains(this.app.a())))) {
          break label661;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_k_of_type_JavaLangString + "  owner:" + this.j);
        }
        c();
        e();
        f();
        a();
        localObject = "4";
        paramBundle = (Bundle)localObject;
        switch (this.t)
        {
        default: 
          paramBundle = (Bundle)localObject;
        case 1: 
          label598:
          str = "2";
          if ((this.j != null) && (this.j.equals(this.app.a()))) {
            localObject = "0";
          }
          break;
        }
      }
      for (;;)
      {
        this.q = ((String)localObject);
        a("exp", paramBundle, (String)localObject);
        return true;
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
        break;
        label661:
        bool = false;
        break label482;
        label666:
        if (!QLog.isColorLevel()) {
          break label487;
        }
        QLog.d("TroopMemberListActivity", 2, "doOnCreate, mTroopInfo==null");
        break label487;
        label684:
        this.jdField_b_of_type_Boolean = true;
        this.r = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
          this.j = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        }
        for (;;)
        {
          if ((this.j != null) && (this.j.equals(this.app.a()))) {
            this.jdField_a_of_type_Boolean = true;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopMemberListActivity", 2, "doOnCreate, mDiscussionInfo owner: " + this.j);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivity", 2, "doOnCreate, mDiscussionInfo==null");
          }
        }
        paramBundle = "0";
        break label598;
        paramBundle = "1";
        break label598;
        paramBundle = "2";
        break label598;
        paramBundle = "3";
        break label598;
        localObject = str;
        if (this.jdField_k_of_type_JavaLangString != null)
        {
          localObject = str;
          if (this.jdField_k_of_type_JavaLangString.contains(this.app.a())) {
            localObject = "1";
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label81;
    }
  }
  
  protected void doOnDestroy()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      try
      {
        label8:
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        label24:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.b();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
        }
        return;
      }
      catch (Exception localException1)
      {
        break label24;
      }
    }
    catch (Exception localException2)
    {
      break label8;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  protected void e()
  {
    View localView = getLayoutInflater().inflate(2130904502, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131298255));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)localView.findViewById(2131302367));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131302368));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    Object localObject2;
    Object localObject1;
    if ((this.t == 3) && (this.jdField_a_of_type_Boolean) && (this.jdField_k_of_type_Int != 1))
    {
      localObject2 = getString(2131365832);
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297297)).setText((CharSequence)localObject2);
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302369);
      ((TextView)localObject1).setText("");
      ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131297531)).setBackgroundDrawable(ImageUtil.c());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new fju(this, (String)localObject2));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
      localObject2 = (TroopHandler)this.app.a(19);
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break label560;
      }
      QQToast.a(this, 2131365941, 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, "tab0");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, "tab1");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new fjv(this));
      localObject1 = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299473);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299461)).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(localView);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
      m();
      ((EditText)localObject1).setOnTouchListener(new fiu(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      return;
      label560:
      if (localObject2 != null)
      {
        ((TroopHandler)localObject2).a(this.app.a(), this.h);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_c_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
  }
  
  public void e(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "kickOutDiscussionMember:" + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903050);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.t != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606)).setText(getString(2131366630));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.h), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivity", 2, "kickOutDiscussionMember:" + paramString.toString());
      }
      bool = false;
    }
  }
  
  protected void f()
  {
    n();
    fiw localfiw = new fiw(this);
    Object localObject;
    long l1;
    long l2;
    int i2;
    if (this.t != 1)
    {
      localObject = getSharedPreferences("last_update_time" + this.app.a(), 0);
      l1 = ((SharedPreferences)localObject).getLong("key_last_update_time" + this.i, 0L);
      l2 = Math.abs(System.currentTimeMillis() - l1);
      int i3 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        i3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum;
      }
      i2 = ((SharedPreferences)localObject).getInt("key_last_update_num" + this.i, 0);
      ((SharedPreferences)localObject).edit().putInt("key_last_update_num" + this.i, i3).commit();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i3 + " lastUpdateMemberNum:" + i2);
      }
      i1 = 0;
      if (i2 != i3) {
        i1 = 1;
      }
      i2 = i1;
      if (i3 <= 500) {
        if (l1 != 0L)
        {
          i2 = i1;
          if (l1 > 0L)
          {
            i2 = i1;
            if (l2 <= 300000L) {}
          }
        }
        else
        {
          i2 = 1;
        }
      }
      if ((i3 <= 500) || ((l1 != 0L) && ((l1 <= 0L) || (l2 <= 86400000L)))) {
        break label657;
      }
    }
    label657:
    for (int i1 = 1;; i1 = i2)
    {
      if (i1 != 0)
      {
        localObject = (TroopHandler)this.app.a(19);
        if (localObject != null)
        {
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          ((TroopHandler)localObject).a(true, this.i, this.h);
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivity", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.h + " troopCode: " + this.i);
          }
        }
      }
      if (this.t == 3)
      {
        l1 = getSharedPreferences("last_update_time" + this.app.a(), 0).getLong("key_troop_info_last_update" + this.i, 0L);
        l2 = Math.abs(l1 - System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
        }
        if (l2 > 60000L)
        {
          localObject = (TroopHandler)this.app.a(19);
          if (localObject != null)
          {
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            ((TroopHandler)localObject).a(this.i, (byte)0, 0L, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivity", 2, "fillData, getGroupInfoReq, mTroopUin:" + this.i);
            }
          }
        }
      }
      this.app.a(localfiw);
      return;
    }
  }
  
  protected void f(String paramString)
  {
    Intent localIntent = new Intent(this, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.i);
    localIntent.putExtra("memberUin", paramString);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", getString(2131365817));
    this.u = paramString;
    startActivityForResult(localIntent, 1);
    a("Clk_item", this.q, "");
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivity", 2, "checkShowCharIndexView, mItemCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int + " mCharSegmentCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int);
    }
    if (this.y == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int > 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int > 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void h()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903050);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.t == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606)).setText(getString(2131366988));
      return;
      label76:
      bool = false;
    }
  }
  
  public void i()
  {
    Object localObject = (InputMethodManager)getSystemService("input_method");
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    fiz localfiz = new fiz(this, localTranslateAnimation1);
    localTranslateAnimation1.setAnimationListener(localfiz);
    localTranslateAnimation2.setAnimationListener(localfiz);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new fja(this, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131299465));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new fjc(this));
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131299461);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new fjd(this));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297286);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297284));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new fje(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
    this.e = true;
  }
  
  public void j()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void k()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.i;
    localIntent.putExtra("url", str);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "showMemberDstribute:" + str);
    }
    a("Clk_mberdist", this.q, "");
  }
  
  public void l()
  {
    ThreadManager.a(new fjo(this));
    a("Clk_invite", this.q, "");
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */