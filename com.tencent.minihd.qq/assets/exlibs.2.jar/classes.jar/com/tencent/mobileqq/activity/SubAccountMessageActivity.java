package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.OverScrollViewListener;
import fdh;
import fdi;
import fdj;
import fdk;
import fdl;
import fdm;
import fdn;
import fdo;
import fdp;
import fdq;
import fdr;
import fds;
import fdt;
import fdu;
import fdv;
import fdw;
import fdx;
import fdy;
import fdz;
import fea;
import feb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;

public class SubAccountMessageActivity
  extends SubAccountBaseActivity
  implements DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1011;
  private static final String jdField_d_of_type_JavaLangString = "0X8004458";
  private static final String jdField_e_of_type_JavaLangString = "0X8004459";
  private static final String f = "0X800445A";
  private static final String g = "0X8004784";
  private Handler jdField_a_of_type_AndroidOsHandler = new fdh(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fdw(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private SubAccountMessageAdapter jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fdx(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new fdy(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new fea(this);
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new feb(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountMessageActivity";
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private String h;
  
  public SubAccountMessageActivity()
  {
    this.d = false;
    this.e = false;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    int i = 2131365737;
    String str = getString(2131366765);
    switch (paramInt)
    {
    }
    for (paramInt = i;; paramInt = 2131365738)
    {
      a(str, paramString1, 2131365736, paramInt, new fdj(this, paramString2), new fdk(this));
      return;
      str = getString(2131366511);
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fdl(this), paramLong);
  }
  
  private void a(SubAccountControll paramSubAccountControll, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramSubAccountControll == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (SubAccountControll.a(this.app, paramString)))
      {
        a();
        paramString = paramSubAccountControll.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramSubAccountControll.a(this.app, this, localPair, new fdz(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 2131365736, 2131365737, new fdi(this), null);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
      if (localSubAccountManager != null)
      {
        if (paramBoolean) {
          localSubAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        }
        localSubAccountManager.f(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    SubAccountControll.a(this.app, paramString, false);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = ((SubAccountManager)this.app.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    if (bool) {}
    for (String str = getResources().getString(2131368689);; str = getResources().getString(2131368687))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      if (paramBoolean) {
        localActionSheet.a(getResources().getString(2131368688), 1);
      }
      localActionSheet.a(str, 1);
      localActionSheet.a(getResources().getString(2131368671), 1);
      localActionSheet.a(getResources().getString(2131368678), 3);
      localActionSheet.e(2131365736);
      localActionSheet.a(new fdq(this, paramBoolean, localActionSheet, bool));
      localActionSheet.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean, View paramView, int paramInt)
  {
    boolean bool = ((SubAccountManager)this.app.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    if (bool) {}
    for (String str = getResources().getString(2131368689);; str = getResources().getString(2131368687))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368688, new fdm(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(str, new fdn(this, bool));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368671, new fdo(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368678, new fdp(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131365736, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    if (paramBoolean1)
    {
      localActionSheet.a(2131368674);
      localActionSheet.a(2131365737, 3);
    }
    for (;;)
    {
      localActionSheet.e(2131365736);
      localActionSheet.a(new fdr(this, localActionSheet, paramBoolean1, paramBoolean2));
      localActionSheet.show();
      return;
      if (paramBoolean2)
      {
        localActionSheet.a(2131368675);
        localActionSheet.a(2131368673, 3);
      }
    }
  }
  
  private boolean c()
  {
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      String str = ContactUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, true);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 4, "initData:set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
      }
    }
    h();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter = new SubAccountMessageAdapter(this.app, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter);
    i();
    this.h = this.app.a();
    return true;
  }
  
  private boolean d()
  {
    String str = getIntent().getStringExtra("subAccount");
    this.jdField_c_of_type_JavaLangString = str;
    Object localObject = (SubAccountManager)this.app.getManager(59);
    if (localObject != null) {}
    for (localObject = ((SubAccountManager)localObject).a(str);; localObject = null)
    {
      if ((localObject != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = new SubAccountInfo();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cloneTo((SubAccountInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshAccountInfo: set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          localObject = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return true;
          localObject = ContactUtils.b(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          } else {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "subaccount refreshAccountInfo but mSubAccountInfo is null??");
      }
      a(this.app.a().getString(2131368693));
      if (str != null) {
        SubAccountControll.c(this.app, str);
      }
      finish();
      return false;
    }
  }
  
  private void e()
  {
    setTitle(2131368649);
    d();
    ImageView localImageView = this.rightViewImg;
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838415);
    localImageView.setOnClickListener(new fds(this));
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2130904464, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302268));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302270));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302271));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131302267));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302266));
    localImageView.setContentDescription(getText(2131368731));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131302264));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void f()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
    int i = localSubAccountManager.a();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) && (i == 1) && (!DBUtils.a().a(this.app.a())))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("还可再关联1个QQ号，立即体验吧，触摸两次进入");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new fdv(this, localSubAccountManager));
      ReportController.a(this.app, "CliOper", "", "", "0X8004458", "0X8004458", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
      return;
    }
    Iterator localIterator = getAppRuntime().getApplication().getAllAccounts().iterator();
    SimpleAccount localSimpleAccount;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localSimpleAccount = (SimpleAccount)localIterator.next();
    } while (!localSimpleAccount.getUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin));
    for (;;)
    {
      if (localSimpleAccount != null)
      {
        this.d = true;
        if (this.e)
        {
          this.app.switchAccount(localSimpleAccount, "com.tencent.minihd.qq:qzone");
          return;
        }
        this.app.switchAccount(localSimpleAccount, null);
        return;
      }
      a();
      return;
      localSimpleAccount = null;
    }
  }
  
  private void h()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
    if (localSubAccountManager != null) {}
    for (int i = localSubAccountManager.d(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);; i = 0)
    {
      if (i > 0)
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)))
    {
      localObject = (SubAccountManager)this.app.getManager(59);
      if (localObject == null) {
        break label177;
      }
    }
    label177:
    for (Object localObject = ((SubAccountManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);; localObject = null)
    {
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.notifyDataSetChanged();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList.finish");
        return;
        localObject = new SubAccountMessage();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("fromsubaccount", true);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    localIntent.putExtra("befault_uin", this.app.a());
    startActivityForResult(localIntent, 1011);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "dologoutWhenSwitch:onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("fromsubaccount", true);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin;
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  public void d()
  {
    if (this.leftView != null)
    {
      Object localObject = this.app.a();
      if (localObject == null) {
        break label155;
      }
      int k = ((QQMessageFacade)localObject).e();
      int j = 0;
      localObject = this.app.a();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
          i = ((ConversationFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, 7000);
        }
      }
      i = k - i;
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.leftView.setText(getString(2131366025) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131366025));
    return;
    label155:
    this.leftView.setText(getString(2131366025));
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString.equals(paramIntent.getStringExtra("subAccount"))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    finish();
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
    setContentView(2130904462);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    if (!c()) {
      return true;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.app.a().addObserver(this);
    SubAccountAssistantForward.b(this.app);
    SubAccountAssistantForward.a(this.app);
    SubAccountAssistantForward.e(this.app);
    SubAccountAssistantForward.c(this.app);
    a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
    f();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (DBUtils.a().a(this.app.a()))) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "onAccountChanged() click2switch=" + this.d);
    }
    super.onAccountChanged();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    Object localObject;
    if (this.d)
    {
      localObject = this.h;
      SubAccountControll.a(this.app, (String)localObject, 7);
    }
    if (this.app != null)
    {
      this.app.saveLastAccountState();
      this.app.getApplication().refreAccountList();
    }
    a();
    if (this.e)
    {
      SubAccountControll.a(this.app);
      this.e = false;
      ReportController.a(this.app, "CliOper", "", "", "0X8004784", "0X8004784", 0, 0, this.app.a(), "", "", "");
    }
    for (;;)
    {
      finish();
      return;
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", 1);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    a();
    j();
    this.e = false;
  }
  
  protected boolean onBackEvent()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null))
    {
      this.app.a().c(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, 7000);
      localObject = (SubAccountManager)this.app.getManager(59);
      if (localObject != null) {
        ((SubAccountManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      }
      if (this.jdField_c_of_type_Boolean) {
        ((MessageHandler)this.app.a(0)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, null);
      }
    }
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 1);
    ((Intent)localObject).setFlags(67108864);
    startActivity((Intent)localObject);
    return super.onBackEvent();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    a();
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onLogout:zsw onLogout");
      }
      k();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (!((MessageRecord)paramObject).isSendFromLocal()) {
        runOnUiThread(new fdt(this));
      }
    }
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!AppConstants.W.equals(paramObservable[0])));
    runOnUiThread(new fdu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountMessageActivity
 * JD-Core Version:    0.7.0.1
 */