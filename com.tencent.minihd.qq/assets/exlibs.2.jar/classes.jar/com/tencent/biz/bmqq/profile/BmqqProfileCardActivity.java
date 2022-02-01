package com.tencent.biz.bmqq.profile;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cct;
import ccu;
import ccv;
import ccw;
import ccx;
import ccy;
import cda;
import cdb;
import cdd;
import cdf;
import cdg;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BmqqProfileCardActivity
  extends ProfileActivity
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "message/rfc822";
  private static final int jdField_b_of_type_Int = 1;
  private static final int bP = 9;
  private static final int bQ = 10;
  private static final int bR = 11;
  private static final int bS = 12;
  private static final int bT = 13;
  private static final int bU = 14;
  private static final int bV = 15;
  private static final int bW = 16;
  private static final int bX = 17;
  private static final int bY = 18;
  private static final int bZ = 19;
  private static final int jdField_c_of_type_Int = 2;
  private static final int cA = 3;
  private static final int cB = 4;
  private static final int cC = 0;
  private static final int cD = 1;
  private static final int cE = 2;
  private static final int cF = 3;
  private static final int cG = 4;
  private static final int cH = 5;
  private static final int cI = 6;
  private static final int cJ = 7;
  private static final int cK = 8;
  private static final int cL = 0;
  private static final int cM = 1;
  private static final int cN = 2;
  private static final int cO = 3;
  private static final int cP = 4;
  private static final int ca = 20;
  private static final int cb = 21;
  private static final int cc = 22;
  private static final int cd = 23;
  private static final int ce = 24;
  private static final int cf = 25;
  private static final int cg = 26;
  private static final int ch = 27;
  private static final int ci = 28;
  private static final int cj = 29;
  private static final int ck = 30;
  private static final int cl = 31;
  private static final int cm = 32;
  private static final int cn = 33;
  private static final int co = 0;
  private static final int cp = 1;
  private static final int cq = 2;
  private static final int cr = 3;
  private static final int cs = 4;
  private static final int ct = 5;
  private static final int cu = 6;
  private static final int cv = 0;
  private static final int cw = 1;
  private static final int cx = 2;
  private static final int cy = 1;
  private static final int cz = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final int jdField_e_of_type_Int = 4;
  private static final int jdField_f_of_type_Int = 5;
  private static final int jdField_g_of_type_Int = 6;
  private static final int jdField_h_of_type_Int = 7;
  private static final int jdField_i_of_type_Int = 8;
  private long jdField_a_of_type_Long = 0L;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cdf(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  public TextView a;
  private BmqqBusinessObserver jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver = new cct(this);
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ccw(this);
  public BmqqUserSimpleInfo a;
  private MQQProfileName jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new cdg(this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean = true;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[7];
  public RelativeLayout b;
  public TextView b;
  private ActionSheet.OnButtonClickListener jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new ccu(this);
  private boolean jdField_b_of_type_Boolean = false;
  public RelativeLayout c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_i_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private RelativeLayout jdField_j_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  
  public BmqqProfileCardActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ccv(this);
  }
  
  private ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, b());
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Friends localFriends = ((FriendManager)this.app.getManager(8)).c(paramString);
    if ((localFriends != null) && (localFriends.remark != null)) {}
    for (paramString = localFriends.remark;; paramString = null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (localFriends != null) {
          str = localFriends.name;
        }
      }
      return str;
    }
  }
  
  private void a(int paramInt)
  {
    int k = 0;
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramInt == 0) {
        k = 8;
      }
      ((LinearLayout)localObject).setVisibility(k);
      while (paramInt < m)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 29, 2131368233, 2130840480, 2131362003);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 33, 2131369023, 2130840884, 2131362045);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 31, 2131368267, 2130840477, 2131362002);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 32, 2131366330, 2130840484, 2131362001);
      paramInt = 5;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 32, 2131366330, 2130840484, 2131362001);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 31, 2131368267, 2130840477, 2131362002);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 32, 2131366330, 2130840484, 2131362001);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 31, 2131368267, 2130840477, 2131362002);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 30, 2131368232, 2130840474, 2131362000);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 32, 2131366330, 2130840484, 2131362001);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 31, 2131368267, 2130840477, 2131362002);
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TextView localTextView;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      localTextView = (TextView)paramView.findViewById(2131297022);
      localTextView.setText(paramInt2);
      localTextView.setContentDescription(getString(paramInt4));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      if ((!a(paramInt1)) || (this.jdField_a_of_type_Boolean)) {
        break label136;
      }
      localTextView.setTextColor(getResources().getColor(2131427972));
    }
    for (;;)
    {
      localTextView.setEnabled(this.jdField_a_of_type_Boolean);
      try
      {
        paramView.setBackgroundResource(2130840468);
        localTextView.setTextColor(getResources().getColorStateList(2131427970));
        return;
      }
      catch (Exception paramView)
      {
        label136:
        paramView.printStackTrace();
      }
      localTextView.setTextColor(getResources().getColor(2131427970));
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    int k = getResources().getColor(2131427889);
    View localView = View.inflate(this, 2130903986, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this);
    localView.setBackgroundColor(k);
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
    localView = View.inflate(this, 2130903986, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
    localView = new View(this);
    localView.setBackgroundColor(k);
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
    localView = View.inflate(this, 2130903986, null);
    localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView(localView, localLayoutParams);
  }
  
  private void a(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    j();
    l();
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new cdb(this));
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", BmqqProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
    }
    String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      localIntent.putExtra("uinname", paramString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        break label596;
      }
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
      paramString = (FriendManager)this.app.getManager(8);
      if (paramString != null)
      {
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (paramString.cSpecialFlag == 1))
        {
          localIntent.setClass(getActivity(), ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101)) {
        break label628;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      startActivityForResult(localIntent, 1010);
      return;
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      if ((paramInt == 1021) && (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[2])))
      {
        localIntent.putExtra("uinname", this.jdField_a_of_type_ArrayOfJavaLangString[2]);
        break;
      }
      paramString = this.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = this.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break;
      label596:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
      }
    }
    label628:
    startActivity(localIntent);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int + ", entry = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g);
        }
      }
      for (;;)
      {
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private String b()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(this.app.getAccount())) {
      finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if (!a()) {
      finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.endsWith("0"))) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      if (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, "qq_error|" + localException.toString());
      }
      finish();
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230780)[0], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230780)[1], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getResources().getStringArray(2131230780)[2]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getStringArray(2131230781)[0], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getResources().getStringArray(2131230781)[1]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    }
  }
  
  private void c()
  {
    n();
    d();
    e();
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296803));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void d(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    if ((paramString != null) && (paramString.length() > 0))
    {
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
      localIntent.setType("message/rfc822");
      Intent.createChooser(localIntent, getResources().getString(2131361792));
    }
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(getActivity().getApplicationContext(), 2131361793, 0).show();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131296800));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296804));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296805));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296806));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131296808));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131296820));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(8));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296809));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131296811));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131296820));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(7));
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296812));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296814));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_i_of_type_AndroidWidgetRelativeLayout.findViewById(2131296820));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(13));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296815));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131296817));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131296820));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(16));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296818));
    this.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidWidgetRelativeLayout.findViewById(2131296819));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidWidgetRelativeLayout.findViewById(2131296823));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296801));
  }
  
  private void e(String paramString)
  {
    int k = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(4, paramString);
    p();
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      if (k == 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName);
      }
      else
      {
        k = 0;
      }
    }
  }
  
  private void f()
  {
    i();
    l();
  }
  
  private void g()
  {
    addObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void h()
  {
    removeObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void i()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    if (localEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  private void j()
  {
    ((BmqqBusinessHandler)this.app.a(39)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  private void k()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void l()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    m();
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean == true) || (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundColor(5731309);
      this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    int k;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString);
      k = 1;
    }
    for (;;)
    {
      if (k == 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle))
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundResource(2130837695);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle);
      }
      int[] arrayOfInt;
      for (;;)
      {
        arrayOfInt = new int[4];
        k = 0;
        while (k < 4)
        {
          arrayOfInt[k] = 0;
          k += 1;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName)) {
          break label817;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName);
        k = 1;
        break;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundColor(5731309);
        this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum))
      {
        arrayOfInt[0] = 1;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum);
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone))
        {
          arrayOfInt[1] = 1;
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone);
        }
        for (int i2 = 1;; i2 = 0)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail))
          {
            arrayOfInt[2] = 1;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnPreDrawListener(new ccx(this));
          }
          for (int i3 = 1;; i3 = 0)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany))
            {
              arrayOfInt[3] = 1;
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany);
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnPreDrawListener(new ccy(this));
            }
            for (int i4 = 1;; i4 = 0)
            {
              int m = -1;
              int i5 = -1;
              k = 0;
              while (k < 4)
              {
                int i7 = i5;
                int i6 = m;
                if (arrayOfInt[k] == 1)
                {
                  int n = m;
                  if (m < 0) {
                    n = k;
                  }
                  i7 = i5;
                  i6 = n;
                  if (i5 < k)
                  {
                    i7 = k;
                    i6 = n;
                  }
                }
                k += 1;
                i5 = i7;
                m = i6;
              }
              if (i5 == 0)
              {
                this.jdField_g_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837702);
                if (i5 != 1) {
                  break label754;
                }
                this.jdField_h_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837702);
                label666:
                if (i5 != 2) {
                  break label767;
                }
                this.jdField_i_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837702);
                label682:
                if (i5 != 3) {
                  break label780;
                }
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837702);
              }
              for (;;)
              {
                if ((i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0)) {
                  break label791;
                }
                this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                return;
                this.jdField_g_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837703);
                break;
                label754:
                this.jdField_h_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837703);
                break label666;
                label767:
                this.jdField_i_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837703);
                break label682;
                label780:
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837703);
              }
              label791:
              break;
            }
          }
        }
      }
      label817:
      k = 0;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      a(1);
      return;
    }
    boolean bool1 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool2 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((bool1) && (bool2) && (bool3))
    {
      a(2);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(3);
      return;
    }
    if ((bool2) && (bool3))
    {
      a(4);
      return;
    }
    if ((bool1) && (bool3))
    {
      a(5);
      return;
    }
    if (bool1)
    {
      a(6);
      return;
    }
    if (bool2)
    {
      a(7);
      return;
    }
    if (bool3)
    {
      a(5);
      return;
    }
    a(0);
  }
  
  private void n()
  {
    int m = 1;
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296797));
    label75:
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131368195);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296798));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 6) {
        break label175;
      }
      a();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new cda(this));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296799));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label192;
      }
      k = 0;
    }
    for (;;)
    {
      if (k == 0) {
        break label541;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(this.jdField_a_of_type_Boolean);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131368194);
      break;
      label175:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131366374));
      break label75;
      label192:
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)
      {
        k = m;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71)
        {
          k = m;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70)
          {
            k = m;
            if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              k = m;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 21)
              {
                k = m;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)
                {
                  k = m;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22)
                  {
                    k = m;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 46)
                    {
                      k = m;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 47)
                      {
                        k = m;
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41)
                        {
                          k = m;
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 42)
                          {
                            k = m;
                            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
                            {
                              k = m;
                              if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)
                              {
                                if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
                                {
                                  if (TextUtils.isEmpty(a())) {}
                                  for (k = 0;; k = 1) {
                                    break;
                                  }
                                }
                                if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
                                {
                                  k = 0;
                                }
                                else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
                                {
                                  k = m;
                                  if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int == 0) {
                                    k = 0;
                                  }
                                }
                                else
                                {
                                  k = m;
                                  if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 2)
                                  {
                                    k = m;
                                    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 74)
                                    {
                                      k = m;
                                      if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                                        k = 0;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label541:
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 221
    //   11: iconst_2
    //   12: ldc_w 945
    //   15: invokestatic 539	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   22: getfield 568	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   31: getfield 500	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   39: getfield 503	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   42: astore 7
    //   44: aload_0
    //   45: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   48: getfield 947	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   51: astore 13
    //   53: aload_0
    //   54: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   57: getfield 949	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   66: getfield 951	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:k	Ljava/lang/String;
    //   69: astore 6
    //   71: aload_0
    //   72: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   75: getfield 953	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 14
    //   80: aload 4
    //   82: astore 8
    //   84: aload 4
    //   86: astore 9
    //   88: aload_0
    //   89: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   92: invokestatic 935	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   95: ifeq +633 -> 728
    //   98: aload 4
    //   100: astore 8
    //   102: aload 4
    //   104: astore 9
    //   106: aload_0
    //   107: getfield 206	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   110: bipush 8
    //   112: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   115: checkcast 243	com/tencent/mobileqq/model/FriendManager
    //   118: astore_3
    //   119: aload_3
    //   120: ifnonnull +582 -> 702
    //   123: aload 4
    //   125: astore 10
    //   127: aload 11
    //   129: ifnull +1114 -> 1243
    //   132: aload 4
    //   134: astore_3
    //   135: aload 4
    //   137: astore 8
    //   139: aload 4
    //   141: astore 9
    //   143: aload 11
    //   145: getfield 254	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   148: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne +17 -> 168
    //   154: aload 4
    //   156: astore 8
    //   158: aload 4
    //   160: astore 9
    //   162: aload 11
    //   164: getfield 254	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   167: astore_3
    //   168: aload_3
    //   169: astore 8
    //   171: aload_3
    //   172: astore 9
    //   174: aload_3
    //   175: astore 10
    //   177: aload 11
    //   179: getfield 251	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   182: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +1058 -> 1243
    //   188: aload_3
    //   189: astore 8
    //   191: aload_3
    //   192: astore 9
    //   194: aload 11
    //   196: getfield 251	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   199: astore 4
    //   201: aload_3
    //   202: astore_2
    //   203: aload 4
    //   205: astore_3
    //   206: aload 7
    //   208: astore 8
    //   210: aload 7
    //   212: astore 9
    //   214: aload_0
    //   215: getfield 206	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   218: bipush 8
    //   220: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 955	com/tencent/mobileqq/app/FriendsManagerImp
    //   226: astore 11
    //   228: aload 7
    //   230: astore 8
    //   232: aload 7
    //   234: astore 9
    //   236: aload_0
    //   237: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   240: getfield 516	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   243: astore 4
    //   245: aload 4
    //   247: astore 10
    //   249: aload 7
    //   251: astore 8
    //   253: aload 7
    //   255: astore 9
    //   257: aload 4
    //   259: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifeq +59 -> 321
    //   265: aload 4
    //   267: astore 10
    //   269: aload 7
    //   271: astore 8
    //   273: aload 7
    //   275: astore 9
    //   277: aload_0
    //   278: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   281: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   284: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   287: ifne +34 -> 321
    //   290: aload 4
    //   292: astore 10
    //   294: aload 11
    //   296: ifnull +25 -> 321
    //   299: aload 7
    //   301: astore 8
    //   303: aload 7
    //   305: astore 9
    //   307: aload 11
    //   309: aload_0
    //   310: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   313: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   316: invokevirtual 957	com/tencent/mobileqq/app/FriendsManagerImp:f	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore 10
    //   321: aload 7
    //   323: astore 4
    //   325: aload 7
    //   327: astore 8
    //   329: aload 7
    //   331: astore 9
    //   333: aload 10
    //   335: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   338: ifne +36 -> 374
    //   341: aload 7
    //   343: astore 4
    //   345: aload 11
    //   347: ifnull +27 -> 374
    //   350: aload 7
    //   352: astore 8
    //   354: aload 7
    //   356: astore 9
    //   358: aload 11
    //   360: aload 10
    //   362: aload_0
    //   363: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   366: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   369: invokevirtual 960	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 4
    //   374: aload 4
    //   376: astore 8
    //   378: aload 4
    //   380: astore 9
    //   382: aload 6
    //   384: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +842 -> 1229
    //   390: aload 4
    //   392: astore 8
    //   394: aload 4
    //   396: astore 9
    //   398: aload_0
    //   399: invokespecial 603	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:a	()Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   402: astore 7
    //   404: aload 7
    //   406: ifnull +823 -> 1229
    //   409: aload 4
    //   411: astore 8
    //   413: aload 4
    //   415: astore 9
    //   417: aload 7
    //   419: getfield 961	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   422: astore 7
    //   424: aload 7
    //   426: astore 6
    //   428: aload_0
    //   429: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   432: invokestatic 963	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:j	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   435: ifeq +788 -> 1223
    //   438: aload 5
    //   440: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifeq +780 -> 1223
    //   446: aload_0
    //   447: getfield 206	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   450: bipush 34
    //   452: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   455: checkcast 965	com/tencent/mobileqq/app/CircleManager
    //   458: astore 7
    //   460: aload 7
    //   462: ifnull +761 -> 1223
    //   465: aload 7
    //   467: aload_0
    //   468: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   471: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokevirtual 968	com/tencent/mobileqq/app/CircleManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/CircleBuddy;
    //   477: astore 9
    //   479: aload 9
    //   481: ifnull +742 -> 1223
    //   484: aload 9
    //   486: getfield 971	com/tencent/mobileqq/data/CircleBuddy:remark	Ljava/lang/String;
    //   489: astore 7
    //   491: aload 7
    //   493: astore 5
    //   495: aload_2
    //   496: astore 8
    //   498: aload 9
    //   500: getfield 974	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   503: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   506: ifne +14 -> 520
    //   509: aload 9
    //   511: getfield 974	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   514: astore 8
    //   516: aload 7
    //   518: astore 5
    //   520: aload_3
    //   521: astore 9
    //   523: aload 4
    //   525: astore 10
    //   527: aload 5
    //   529: astore 11
    //   531: aload 6
    //   533: astore 12
    //   535: aload_0
    //   536: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   539: iconst_0
    //   540: aload 8
    //   542: aastore
    //   543: aload_0
    //   544: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   547: iconst_4
    //   548: aload 9
    //   550: aastore
    //   551: aload_0
    //   552: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   555: iconst_3
    //   556: aload 12
    //   558: aastore
    //   559: aload_0
    //   560: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   563: iconst_2
    //   564: aload 11
    //   566: aastore
    //   567: aload_0
    //   568: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   571: iconst_5
    //   572: aload 13
    //   574: aastore
    //   575: aload_0
    //   576: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   579: iconst_1
    //   580: aload 10
    //   582: aastore
    //   583: aload_0
    //   584: getfield 133	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   587: bipush 6
    //   589: aload 14
    //   591: aastore
    //   592: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +106 -> 701
    //   598: new 407	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 408	java/lang/StringBuilder:<init>	()V
    //   605: astore_2
    //   606: aload_2
    //   607: ldc_w 976
    //   610: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 978
    //   616: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 8
    //   621: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w 980
    //   627: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 9
    //   632: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc_w 982
    //   638: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload 12
    //   643: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc_w 984
    //   649: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 11
    //   654: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: ldc_w 986
    //   660: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload 13
    //   665: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: ldc_w 988
    //   671: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 10
    //   676: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 990
    //   682: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload 13
    //   687: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: ldc 221
    //   693: iconst_2
    //   694: aload_2
    //   695: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: return
    //   702: aload 4
    //   704: astore 8
    //   706: aload 4
    //   708: astore 9
    //   710: aload_3
    //   711: aload_0
    //   712: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   715: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   718: invokeinterface 246 2 0
    //   723: astore 11
    //   725: goto -602 -> 123
    //   728: aload 4
    //   730: astore 8
    //   732: aload 4
    //   734: astore 9
    //   736: aload_0
    //   737: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   740: getfield 424	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   743: ifne +35 -> 778
    //   746: aload 4
    //   748: astore 8
    //   750: aload 4
    //   752: astore 9
    //   754: aload_0
    //   755: getfield 206	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   758: aload_0
    //   759: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   762: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   765: invokestatic 992	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   768: astore 4
    //   770: aload_2
    //   771: astore_3
    //   772: aload 4
    //   774: astore_2
    //   775: goto -569 -> 206
    //   778: aload 4
    //   780: astore 8
    //   782: aload 4
    //   784: astore 9
    //   786: aload 4
    //   788: astore_3
    //   789: aload 4
    //   791: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   794: ifeq +438 -> 1232
    //   797: aload 4
    //   799: astore 8
    //   801: aload 4
    //   803: astore 9
    //   805: aload 4
    //   807: astore_3
    //   808: aload_0
    //   809: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   812: invokestatic 580	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   815: ifeq +417 -> 1232
    //   818: aload 4
    //   820: astore 8
    //   822: aload 4
    //   824: astore 9
    //   826: aload_0
    //   827: getfield 206	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   830: aload_0
    //   831: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   834: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   837: iconst_0
    //   838: invokestatic 995	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   841: astore_3
    //   842: aload_3
    //   843: astore 8
    //   845: aload_3
    //   846: astore 9
    //   848: aload_3
    //   849: aload_0
    //   850: getfield 178	com/tencent/biz/bmqq/profile/BmqqProfileCardActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   853: getfield 426	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   856: invokestatic 1000	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   859: istore_1
    //   860: iload_1
    //   861: ifeq +371 -> 1232
    //   864: aconst_null
    //   865: astore 4
    //   867: aload_2
    //   868: astore_3
    //   869: aload 4
    //   871: astore_2
    //   872: goto -666 -> 206
    //   875: astore 4
    //   877: aload 6
    //   879: astore 9
    //   881: aload 5
    //   883: astore_3
    //   884: aload 8
    //   886: astore 6
    //   888: aload 7
    //   890: astore 8
    //   892: aload 4
    //   894: astore 7
    //   896: aload_2
    //   897: astore 5
    //   899: aload 8
    //   901: astore 4
    //   903: aload 9
    //   905: astore_2
    //   906: aload_2
    //   907: astore 12
    //   909: aload_3
    //   910: astore 11
    //   912: aload 4
    //   914: astore 10
    //   916: aload 5
    //   918: astore 9
    //   920: aload 6
    //   922: astore 8
    //   924: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq -392 -> 535
    //   930: ldc 221
    //   932: iconst_2
    //   933: aload 7
    //   935: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   938: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: aload_2
    //   942: astore 12
    //   944: aload_3
    //   945: astore 11
    //   947: aload 4
    //   949: astore 10
    //   951: aload 5
    //   953: astore 9
    //   955: aload 6
    //   957: astore 8
    //   959: goto -424 -> 535
    //   962: astore 4
    //   964: aload 6
    //   966: astore 8
    //   968: aload 5
    //   970: astore_3
    //   971: aload 9
    //   973: astore 6
    //   975: aload 7
    //   977: astore 9
    //   979: aload 4
    //   981: astore 7
    //   983: aload_2
    //   984: astore 5
    //   986: aload 9
    //   988: astore 4
    //   990: aload 8
    //   992: astore_2
    //   993: aload_2
    //   994: astore 12
    //   996: aload_3
    //   997: astore 11
    //   999: aload 4
    //   1001: astore 10
    //   1003: aload 5
    //   1005: astore 9
    //   1007: aload 6
    //   1009: astore 8
    //   1011: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq -479 -> 535
    //   1017: ldc 221
    //   1019: iconst_2
    //   1020: aload 7
    //   1022: invokevirtual 1001	java/lang/Error:toString	()Ljava/lang/String;
    //   1025: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: aload_2
    //   1029: astore 12
    //   1031: aload_3
    //   1032: astore 11
    //   1034: aload 4
    //   1036: astore 10
    //   1038: aload 5
    //   1040: astore 9
    //   1042: aload 6
    //   1044: astore 8
    //   1046: goto -511 -> 535
    //   1049: astore 10
    //   1051: aload 8
    //   1053: astore 4
    //   1055: aload_2
    //   1056: astore 7
    //   1058: aload 5
    //   1060: astore 9
    //   1062: aload_3
    //   1063: astore 5
    //   1065: aload 10
    //   1067: astore 8
    //   1069: aload 6
    //   1071: astore_2
    //   1072: aload 9
    //   1074: astore_3
    //   1075: aload 7
    //   1077: astore 6
    //   1079: aload 8
    //   1081: astore 7
    //   1083: goto -90 -> 993
    //   1086: astore 8
    //   1088: aload 6
    //   1090: astore 7
    //   1092: aload_2
    //   1093: astore 6
    //   1095: aload 5
    //   1097: astore 9
    //   1099: aload_3
    //   1100: astore 5
    //   1102: aload 7
    //   1104: astore_2
    //   1105: aload 9
    //   1107: astore_3
    //   1108: aload 8
    //   1110: astore 7
    //   1112: goto -119 -> 993
    //   1115: astore 8
    //   1117: aload_3
    //   1118: astore 5
    //   1120: aload 6
    //   1122: astore_3
    //   1123: aload_2
    //   1124: astore 6
    //   1126: aload_3
    //   1127: astore_2
    //   1128: aload 7
    //   1130: astore_3
    //   1131: aload 8
    //   1133: astore 7
    //   1135: goto -142 -> 993
    //   1138: astore 8
    //   1140: aload 9
    //   1142: astore 4
    //   1144: aload_2
    //   1145: astore 7
    //   1147: aload 5
    //   1149: astore 9
    //   1151: aload_3
    //   1152: astore 5
    //   1154: aload 6
    //   1156: astore_2
    //   1157: aload 9
    //   1159: astore_3
    //   1160: aload 7
    //   1162: astore 6
    //   1164: aload 8
    //   1166: astore 7
    //   1168: goto -262 -> 906
    //   1171: astore 8
    //   1173: aload 6
    //   1175: astore 7
    //   1177: aload_2
    //   1178: astore 6
    //   1180: aload 5
    //   1182: astore 9
    //   1184: aload_3
    //   1185: astore 5
    //   1187: aload 7
    //   1189: astore_2
    //   1190: aload 9
    //   1192: astore_3
    //   1193: aload 8
    //   1195: astore 7
    //   1197: goto -291 -> 906
    //   1200: astore 8
    //   1202: aload_3
    //   1203: astore 5
    //   1205: aload 6
    //   1207: astore_3
    //   1208: aload_2
    //   1209: astore 6
    //   1211: aload_3
    //   1212: astore_2
    //   1213: aload 7
    //   1215: astore_3
    //   1216: aload 8
    //   1218: astore 7
    //   1220: goto -314 -> 906
    //   1223: aload_2
    //   1224: astore 8
    //   1226: goto -706 -> 520
    //   1229: goto -801 -> 428
    //   1232: aload_2
    //   1233: astore 4
    //   1235: aload_3
    //   1236: astore_2
    //   1237: aload 4
    //   1239: astore_3
    //   1240: goto -1034 -> 206
    //   1243: aload_2
    //   1244: astore_3
    //   1245: aload 10
    //   1247: astore_2
    //   1248: goto -1042 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1251	0	this	BmqqProfileCardActivity
    //   859	2	1	bool	boolean
    //   34	1214	2	localObject1	Object
    //   118	1127	3	localObject2	Object
    //   25	845	4	localObject3	Object
    //   875	18	4	localException1	Exception
    //   901	47	4	localObject4	Object
    //   962	18	4	localError1	java.lang.Error
    //   988	250	4	localObject5	Object
    //   60	1144	5	localObject6	Object
    //   69	1141	6	localObject7	Object
    //   42	1177	7	localObject8	Object
    //   82	998	8	localObject9	Object
    //   1086	23	8	localError2	java.lang.Error
    //   1115	17	8	localError3	java.lang.Error
    //   1138	27	8	localException2	Exception
    //   1171	23	8	localException3	Exception
    //   1200	17	8	localException4	Exception
    //   1224	1	8	localObject10	Object
    //   86	1105	9	localObject11	Object
    //   125	912	10	localObject12	Object
    //   1049	197	10	localError4	java.lang.Error
    //   1	1032	11	localObject13	Object
    //   533	497	12	localObject14	Object
    //   51	635	13	str1	String
    //   78	512	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   88	98	875	java/lang/Exception
    //   106	119	875	java/lang/Exception
    //   143	154	875	java/lang/Exception
    //   162	168	875	java/lang/Exception
    //   177	188	875	java/lang/Exception
    //   194	201	875	java/lang/Exception
    //   710	725	875	java/lang/Exception
    //   736	746	875	java/lang/Exception
    //   754	770	875	java/lang/Exception
    //   789	797	875	java/lang/Exception
    //   808	818	875	java/lang/Exception
    //   826	842	875	java/lang/Exception
    //   848	860	875	java/lang/Exception
    //   88	98	962	java/lang/Error
    //   106	119	962	java/lang/Error
    //   143	154	962	java/lang/Error
    //   162	168	962	java/lang/Error
    //   177	188	962	java/lang/Error
    //   194	201	962	java/lang/Error
    //   710	725	962	java/lang/Error
    //   736	746	962	java/lang/Error
    //   754	770	962	java/lang/Error
    //   789	797	962	java/lang/Error
    //   808	818	962	java/lang/Error
    //   826	842	962	java/lang/Error
    //   848	860	962	java/lang/Error
    //   214	228	1049	java/lang/Error
    //   236	245	1049	java/lang/Error
    //   257	265	1049	java/lang/Error
    //   277	290	1049	java/lang/Error
    //   307	321	1049	java/lang/Error
    //   333	341	1049	java/lang/Error
    //   358	374	1049	java/lang/Error
    //   382	390	1049	java/lang/Error
    //   398	404	1049	java/lang/Error
    //   417	424	1049	java/lang/Error
    //   428	460	1086	java/lang/Error
    //   465	479	1086	java/lang/Error
    //   484	491	1086	java/lang/Error
    //   498	516	1115	java/lang/Error
    //   214	228	1138	java/lang/Exception
    //   236	245	1138	java/lang/Exception
    //   257	265	1138	java/lang/Exception
    //   277	290	1138	java/lang/Exception
    //   307	321	1138	java/lang/Exception
    //   333	341	1138	java/lang/Exception
    //   358	374	1138	java/lang/Exception
    //   382	390	1138	java/lang/Exception
    //   398	404	1138	java/lang/Exception
    //   417	424	1138	java/lang/Exception
    //   428	460	1171	java/lang/Exception
    //   465	479	1171	java/lang/Exception
    //   484	491	1171	java/lang/Exception
    //   498	516	1200	java/lang/Exception
  }
  
  private void p()
  {
    int i1 = 3;
    int n = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int m = n;
    int k = i1;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      k = 0;
      m = n;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(k, m, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateProfileName profileName=" + this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString());
      }
      return;
      k = 1;
      m = 2;
      continue;
      m = 2;
      k = 2;
      continue;
      m = 2;
      k = i1;
      continue;
      k = 4;
      m = n;
      continue;
      m = 2;
      k = 6;
      continue;
      k = 6;
      m = n;
      continue;
      m = 2;
      k = 7;
      continue;
      k = 7;
      m = n;
      continue;
      k = 8;
      m = n;
      continue;
      k = 9;
      m = n;
      continue;
      k = 11;
      m = n;
      continue;
      k = 10;
      m = n;
      continue;
      k = 5;
      m = n;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      if (ProfileCardUtil.a()) {
        a(2131367097, 1);
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33);
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        str = b();
      } while ((str == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, str);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    if (ProfileCardUtil.a())
    {
      a(2131367097, 1);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p);
      return;
    }
    ProfileCardUtil.a(this, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  private void r()
  {
    int k = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      setResult(0, (Intent)localObject);
      finish();
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      localObject = b();
    }
    for (;;)
    {
      a((String)localObject, k);
      return;
      localObject = str;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 3)
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 102)
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 103) {
            localObject = str;
          }
        }
      }
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
    }
    int k = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str1;
    String str2;
    Object localObject1;
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString[4];
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
      String str3 = this.jdField_a_of_type_ArrayOfJavaLangString[1];
      localObject2 = str3;
      if (TextUtils.isEmpty(str3)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
      }
      if ((k != 0) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label156;
      }
    }
    for (;;)
    {
      if (k == 1000)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        label122:
        ChatActivityUtils.a(this.app, this, k, str1, (String)localObject1, str2, true, (String)localObject2, true, true, null, null);
        return;
        str2 = b();
        str1 = null;
        break;
        label156:
        if ((k == 1000) || (k == 1020))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        }
        else if (k == 1021)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) || (this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a == null)) {
            break label321;
          }
        }
      }
    }
    label321:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
          break;
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[3];
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
          }
          localObject1 = localObject2;
          break;
          if (k == 1004)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
            break label122;
          }
          localObject2 = null;
          break label122;
        }
      }
      break;
    }
  }
  
  private void t()
  {
    int i1 = 10004;
    int n = 0;
    int k = i1;
    int m = n;
    String str;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      m = n;
      k = i1;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 33: 
    case 38: 
    case 39: 
    case 40: 
    case 43: 
    case 44: 
    case 45: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 55: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 73: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
        break label762;
      }
      ProfileActivity.CardContactInfo localCardContactInfo = a();
      if ((localCardContactInfo != null) && (localCardContactInfo.c != null) && (localCardContactInfo.c.length() > 0))
      {
        str = localCardContactInfo.b + localCardContactInfo.c;
        localObject2 = localCardContactInfo.jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label704;
          }
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
      break;
    }
    for (;;)
    {
      startActivity(AddFriendLogicActivity.a(this, 2, str, null, k, m, (String)localObject1, null, FriendProfileCardActivity.class.getName(), setLastActivityName()));
      return;
      k = 3004;
      m = n;
      break;
      k = 3007;
      m = n;
      break;
      k = 3001;
      m = n;
      break;
      k = 3020;
      m = n;
      break;
      k = 3017;
      m = n;
      break;
      k = 3002;
      m = n;
      break;
      k = 3005;
      m = n;
      break;
      k = 3007;
      m = n;
      break;
      k = 3003;
      m = n;
      break;
      k = 3008;
      m = n;
      break;
      k = 3008;
      m = n;
      break;
      k = 3009;
      m = n;
      break;
      k = 3006;
      m = n;
      break;
      k = 3009;
      m = 1;
      break;
      k = 3006;
      m = 1;
      break;
      k = 3013;
      m = n;
      break;
      k = 3003;
      m = 1;
      break;
      k = 3014;
      m = n;
      break;
      k = 3003;
      m = 2;
      break;
      label704:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        }
      }
    }
    label762:
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (3004 == k)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString.length() != 0) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        }
      }
    }
    localObject1 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72)) {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[2];
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    for (;;)
    {
      if (getIntent().getStringExtra("param_return_addr") != null)
      {
        startActivity(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, k, m, (String)localObject1, null, AddContactsActivity.class.getName(), setLastActivityName()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, k, m, (String)localObject1, null, BmqqProfileCardActivity.class.getName(), setLastActivityName()), 1000);
      return;
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  void a()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int k;
    if (localQQMessageFacade != null)
    {
      k = localQQMessageFacade.e();
      if (k <= 0) {
        break label105;
      }
      if (k > 99) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131366025) + "(99+)");
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131366025) + "(" + k + ")");
    return;
    label105:
    getIntent().putExtra("leftViewText", getString(2131366025));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131366025));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString);
    }
    ThreadManager.b(new cdd(this, paramInt, paramAllInOne, paramString));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 101) && (paramInt2 == -1)) {
      finish();
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1012: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
      } while (Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent));
      e(paramIntent);
      return;
    }
    setResult(-1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    super.doOnCreate(paramBundle);
    b();
    if (CrmUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      paramBundle = new Intent(this, EnterpriseDetailActivity.class);
      paramBundle.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("need_finish", true);
      paramBundle.addFlags(536870912);
      startActivity(paramBundle);
      finish();
    }
    setContentView(2130903092);
    o();
    p();
    c();
    g();
    k();
    j();
    f();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if ((QLog.isColorLevel()) && (l > 100L)) {
      QLog.i("Q.PerfTrace", 2, "BmqqProfileCardActivity onCreate used:" + l);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      this.app.a(getClass());
    }
    h();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.profile.BmqqProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */