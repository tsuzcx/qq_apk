package com.tencent.mobileqq.qcall;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jpb;
import jpe;
import jpg;
import jph;
import jpi;
import jpk;
import jpl;
import jpm;
import jpo;
import jpp;
import jpq;
import jps;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static final String jdField_a_of_type_JavaLangString = "0X8004069";
  private static final String jdField_b_of_type_JavaLangString = "0X8004068";
  private static final String jdField_c_of_type_JavaLangString = "QCallDetailActivity";
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new jph(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jpb(this);
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new jpm(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private jps jdField_a_of_type_Jps;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_c_of_type_Int;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = -1;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  private void a(long paramLong)
  {
    Object localObject = ColorRingManager.a(paramLong);
    if ("".equals(localObject))
    {
      localObject = new File(ColorRingManager.b(paramLong, 2));
      localObject = new DownloadTask(ColorRingManager.a(paramLong, 2), (File)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 2);
      localBundle.putLong("colorRingId", paramLong);
      ((DownloaderFactory)this.app.getManager(46)).a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      finish();
    }
    do
    {
      return;
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
      if (this.jdField_a_of_type_Int == 8) {
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
      }
      this.f = paramIntent.getStringExtra("uinname");
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("bind_type", 0);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
      this.g = paramIntent.getStringExtra("bind_id");
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("sig");
      this.h = paramIntent.getStringExtra("entrance");
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = 1003;
      }
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    } while (this.jdField_e_of_type_Int != -1);
    paramIntent = (PhoneContactManager)this.app.getManager(10);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramIntent = paramIntent.a(this.jdField_d_of_type_JavaLangString);
    }
    while (paramIntent != null)
    {
      this.jdField_e_of_type_Int = paramIntent.contactID;
      return;
      paramIntent = paramIntent.c(this.jdField_d_of_type_JavaLangString);
      continue;
      paramIntent = paramIntent.b(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    return ((FriendManager)this.app.getManager(8)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.b(new jpi(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130903842, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296751));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296582));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298883));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299800));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299801));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299806));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299797));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299802));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299809));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299804));
    label378:
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_d_of_type_JavaLangString));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.f);
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299808);
      ((TextView)localObject).setContentDescription(getString(2131369223));
      ((TextView)localObject).setOnClickListener(this);
      d();
      localObject = (ExtensionInfo)this.app.a().createEntityManager().a(ExtensionInfo.class, this.jdField_d_of_type_JavaLangString);
      if ((localObject == null) || (((ExtensionInfo)localObject).colorRingId == 0L))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131368554));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(new jpk(this));
        if (this.jdField_e_of_type_Int != -1)
        {
          localObject = this.app.a().createEntityManager().a(PhoneContact.class, false, "contactID = " + this.jdField_e_of_type_Int, null, null, null, null, null);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            NoScrollListView localNoScrollListView = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299805);
            localNoScrollListView.setVisibility(0);
            localNoScrollListView.setAdapter(new PhoneNumberAdapter(this, (List)localObject));
            localNoScrollListView.setOnItemClickListener(new jpl(this));
          }
        }
        return;
      }
      break;
    case 3000: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, this.jdField_d_of_type_JavaLangString));
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null)
      {
        i = ((FriendManager)localObject).c(this.jdField_d_of_type_JavaLangString);
        if (i <= 0) {
          break label766;
        }
      }
      break;
    }
    label766:
    for (Object localObject = "(" + i + ")";; localObject = "")
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 4, this.jdField_d_of_type_JavaLangString));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 3000, this.jdField_d_of_type_JavaLangString, true));
      break;
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296997);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838853);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(ContactUtils.a(this.f));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131368854);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      findViewById(2131299793).setVisibility(8);
      break;
      a(((ExtensionInfo)localObject).colorRingId);
      break label378;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((FriendManager)this.app.getManager(8)).c(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369225);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369225));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369226);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369226));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369227);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369227));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840110);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369228);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369228));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void e()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131299791);
    TextView localTextView1 = (TextView)localLinearLayout1.findViewById(2131297022);
    localLinearLayout1.setOnClickListener(this);
    localLinearLayout1 = (LinearLayout)findViewById(2131299790);
    TextView localTextView2 = (TextView)localLinearLayout1.findViewById(2131297022);
    localLinearLayout1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131299789);
    TextView localTextView3 = (TextView)localLinearLayout2.findViewById(2131297022);
    localLinearLayout2.setOnClickListener(this);
    localTextView1.setText(2131366330);
    if ((this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 1))
    {
      localTextView1.setContentDescription("发消息 按钮");
      localTextView3.setText(2131368269);
      localTextView3.setContentDescription("群组电话 按钮");
      localLinearLayout1.setVisibility(8);
      return;
    }
    localTextView1.setContentDescription("发消息 按钮");
    localTextView3.setText(2131368268);
    localTextView3.setContentDescription("QQ电话 按钮");
    if (!CrmUtils.b(this.app, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      localLinearLayout1.setVisibility(0);
      localTextView2.setText(2131369237);
      localTextView2.setContentDescription("视频电话 按钮");
      return;
    }
    localLinearLayout1.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299794));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.app.getManager(37));
    this.jdField_a_of_type_Jps = new jps(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Jps);
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Int == 1024)
    {
      localObject = new Intent(this, EnterpriseDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_d_of_type_JavaLangString);
      startActivityForResult((Intent)localObject, 2000);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne(this.jdField_d_of_type_JavaLangString, 46);
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 19;
    ((ProfileActivity.AllInOne)localObject).h = ContactUtils.a(this.app, this.jdField_d_of_type_JavaLangString);
    label248:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 1010)) {
        break label472;
      }
      if (this.jdField_b_of_type_Int == 1001)
      {
        ((ProfileActivity.AllInOne)localObject).g = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!Utils.a(this.jdField_d_of_type_JavaLangString, this.app.a())) {
          break label460;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 20;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 42;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 76;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 22;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 70;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 47;
      ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break;
      if (this.jdField_b_of_type_Int != 1010) {
        break label248;
      }
      ((ProfileActivity.AllInOne)localObject).g = 13;
      break label248;
      label460:
      localIntent.putExtra("param_mode", 3);
    }
    label472:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.f);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    startActivityForResult(localIntent, 2000);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    FriendsManagerImp localFriendsManagerImp;
    do
    {
      do
      {
        return;
        localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
      } while (localFriendsManagerImp == null);
      paramString = localFriendsManagerImp.a(paramString);
    } while ((paramString == null) || (paramString.discussionName == null));
    this.f = paramString.discussionName;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, this.jdField_d_of_type_JavaLangString));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.f);
    int i = localFriendsManagerImp.c(this.jdField_d_of_type_JavaLangString);
    if (i > 0) {}
    for (paramString = "(" + i + ")";; paramString = "")
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    Object localObject1 = getIntent();
    if (((paramIntent != null) && (localObject1 == null)) || ((paramIntent == null) && (localObject1 != null))) {}
    int i;
    String str;
    do
    {
      Bundle localBundle;
      do
      {
        return false;
        if ((paramIntent == null) || (localObject1 == null)) {
          break;
        }
        localBundle = paramIntent.getExtras();
        localObject1 = ((Intent)localObject1).getExtras();
      } while ((localBundle != null) && (localObject1 == null) && (localBundle == null) && (localObject1 != null));
      if ((localBundle == null) || (localObject1 == null)) {
        break label219;
      }
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "uin";
      arrayOfString[1] = "troop_uin";
      arrayOfString[2] = "uintype";
      int j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label219;
      }
      str = arrayOfString[i];
      if (!localBundle.containsKey(str)) {
        break label197;
      }
      localObject2 = localBundle.get(str);
      if (localObject2 == null) {
        break;
      }
    } while ((!((Bundle)localObject1).containsKey(str)) || (!localObject2.equals(((Bundle)localObject1).get(str))));
    label197:
    while ((!((Bundle)localObject1).containsKey(str)) || (((Bundle)localObject1).get(str) == null))
    {
      do
      {
        Object localObject2;
        i += 1;
        break;
      } while ((!((Bundle)localObject1).containsKey(str)) || (((Bundle)localObject1).get(str) == null));
      return false;
    }
    return false;
    label219:
    return super.dataEquals(paramIntent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    boolean bool1;
    do
    {
      return;
      boolean bool2 = false;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
    } while (!bool1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903840);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    this.rightViewImg.setImageResource(2130838415);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setContentDescription("更多按钮，点击进入");
    setTitle(2131369217);
    setLeftViewName(2131369218);
    a(getIntent());
    c();
    e();
    f();
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.addObserver(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_d_of_type_JavaLangString, false);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1006) {
      localObject = this.jdField_d_of_type_JavaLangString;
    }
    for (Object localObject = null;; localObject = this.jdField_d_of_type_JavaLangString) {
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    finish();
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X8004E6D", "0X8004E6D", 0, 0, "", "", "", "");
    paramView = (ActionSheet)ActionSheetHelper.a(this, null);
    int i;
    boolean bool2;
    label232:
    boolean bool1;
    if ((this.jdField_a_of_type_Int == 0) && (!((FriendManager)this.app.getManager(8)).b(this.jdField_d_of_type_JavaLangString)))
    {
      i = 1003;
      if ((i != 0) || (!((FriendManager)this.app.getManager(8)).b(this.jdField_d_of_type_JavaLangString))) {
        break label350;
      }
      bool2 = true;
      if (!bool2) {
        break label356;
      }
      localObject = (FriendManager)this.app.getManager(8);
      if ((localObject == null) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
        break label1321;
      }
      bool1 = ((FriendManager)localObject).g(this.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      label279:
      if (bool1) {}
      for (int j = 2131367808;; j = 2131367806)
      {
        paramView.c(j);
        paramView.c(2131367622);
        paramView.e(2131365736);
        paramView.a(new jpo(this));
        paramView.a(new jpp(this, bool2, bool1, i, paramView));
        paramView.show();
        return;
        i = this.jdField_a_of_type_Int;
        break;
        label350:
        bool2 = false;
        break label232;
        label356:
        localObject = (ShieldMsgManger)this.app.getManager(15);
        if ((localObject == null) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
          break label1315;
        }
        bool1 = ((ShieldMsgManger)localObject).a(this.jdField_d_of_type_JavaLangString);
        break label279;
      }
      ReportController.b(this.app, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Tc_msg_dinfo", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 3000) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004F93", "0X8004F93", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        a(true);
        this.jdField_a_of_type_Jps.a.clear();
        this.jdField_a_of_type_Jps.notifyDataSetChanged();
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8004F8D", "0X8004F8D", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Int == 3000)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        paramView = new Intent(this, ChatActivity.class);
        paramView.putExtra("uin", this.jdField_d_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_Int);
        paramView.putExtra("uinname", this.f);
        paramView.putExtra("entrance", 0);
        startActivity(paramView);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
      }
      ReportController.b(this.app, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
      paramView = (SplashActivity)SplashActivity.a();
      if ((!paramView.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!paramView.permissionManager.checkPermission("android.permission.CAMERA")))
      {
        paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new jpq(this, (String)localObject, paramView));
        return;
      }
      paramView = new Intent(this, QavChatActivity.class);
      paramView.addFlags(262144);
      paramView.putExtra("key_peer_uin", (String)localObject);
      paramView.putExtra("key_only_audio", false);
      startActivity(paramView);
      return;
      paramView = (SplashActivity)SplashActivity.a();
      if ((!paramView.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!paramView.permissionManager.checkPermission("android.permission.CAMERA")))
      {
        paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new jpe(this, (String)localObject, paramView));
        return;
      }
      paramView = new Intent(this, QavChatActivity.class);
      paramView.addFlags(262144);
      paramView.putExtra("key_peer_uin", (String)localObject);
      paramView.putExtra("key_only_audio", true);
      startActivity(paramView);
      return;
      i = ((SVIPHandler)this.app.a(12)).f();
      if (i == 2) {
        i = 0;
      }
      for (;;)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        VasWebviewUtil.a(this, VasWebviewConstants.PERSONALITY_QQ_COLOR_RING_URL, 4194304L, paramView, true, -1);
        ReportController.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i, "", "", "");
        return;
        if (i == 3)
        {
          i = 2;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "qq_call_lightalk_download onclick");
          }
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", "https://laidian.qq.com");
          ReportController.b(this.app, "CliOper", "", "", "0X8004E97", "0X8004E97", 0, 0, "", "", "", "");
          startActivity(paramView);
          return;
          switch (this.jdField_a_of_type_Int)
          {
          case 56938: 
          default: 
            ReportController.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_Int == 56938) {
              break;
            }
            g();
            return;
          case 3000: 
            ReportController.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
            a();
            return;
          }
        }
      }
      label1315:
      bool1 = false;
      continue;
      label1321:
      bool1 = false;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Jps.a = null;
    this.jdField_a_of_type_Jps = null;
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.deleteObserver(this);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int k = 0;
    if (this.jdField_a_of_type_Jps == null) {}
    label10:
    do
    {
      break label10;
      do
      {
        return;
      } while ((paramObservable == null) || (!(paramObservable instanceof QCallFacade)) || (paramObject == null) || (!(paramObject instanceof List)));
      paramObservable = (List)paramObject;
    } while ((paramObservable.isEmpty()) || (!(paramObservable.get(0) instanceof QCallRecord)));
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramObservable.size())
      {
        if (!(paramObservable.get(i) instanceof QCallRecord)) {
          break;
        }
        paramObject = (QCallRecord)paramObservable.get(i);
        if ((TextUtils.isEmpty(paramObject.friendUin)) || (!paramObject.friendUin.equals(this.jdField_d_of_type_JavaLangString)) || (paramObject.uinType != this.jdField_a_of_type_Int)) {
          break label157;
        }
        j = 1;
      }
      if (j == 0) {
        break;
      }
      runOnUiThread(new jpg(this, paramObservable));
      return;
      label157:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */