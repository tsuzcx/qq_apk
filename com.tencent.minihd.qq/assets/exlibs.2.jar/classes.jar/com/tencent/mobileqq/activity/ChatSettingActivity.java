package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import dos;
import dot;
import dou;
import dov;
import dow;
import dox;
import doy;
import doz;
import dpa;
import dpb;
import dpc;
import dpd;
import dpe;
import dpf;
import dpg;
import dph;
import dpi;
import java.util.ArrayList;
import java.util.List;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1000;
  public static final String a = "isShieldMsgSwitchUnClickable";
  private static final boolean jdField_a_of_type_Boolean = true;
  static final String jdField_b_of_type_JavaLangString = "memberUin";
  static final String jdField_c_of_type_JavaLangString = "memberName";
  static final String jdField_d_of_type_JavaLangString = "faceId";
  static final String jdField_e_of_type_JavaLangString = "pinyin";
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private static final int jdField_n_of_type_Int = 33;
  private static final int jdField_o_of_type_Int = 18;
  private static final int jdField_p_of_type_Int = 32;
  private float jdField_a_of_type_Float;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public QvipSpecialSoundManager a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dou(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dot(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dow(this);
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new dpd(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new dov(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new doy(this);
  public RichStatus a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private XSimpleListAdapter jdField_a_of_type_ComTencentWidgetXSimpleListAdapter;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 1;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 2;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_d_of_type_Boolean = false;
  private final int jdField_e_of_type_Int = 3;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_f_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private boolean jdField_f_of_type_Boolean = true;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int = 0;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 4;
  private String jdField_m_of_type_JavaLangString;
  private String jdField_n_of_type_JavaLangString;
  private String jdField_o_of_type_JavaLangString;
  private String jdField_p_of_type_JavaLangString;
  private int jdField_q_of_type_Int;
  private String jdField_q_of_type_JavaLangString = "";
  
  public ChatSettingActivity()
  {
    this.k = 0;
    this.l = 0;
    this.o = "";
    this.p = "";
    this.jdField_a_of_type_AndroidOsHandler = new dpi(this);
  }
  
  private void A()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void B()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void C()
  {
    ThreadManager.c(new dox(this));
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.a(paramString.toString(), null);
    } while (paramString == null);
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label152;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label152:
      if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendsManager)this.app.getManager(49)).a(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = (FriendManager)this.app.getManager(8);
    } while (localObject == null);
    Friends localFriends = ((FriendManager)localObject).c(paramString);
    if (localFriends != null) {
      if (localFriends.remark != null)
      {
        paramString = localFriends.remark;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (TextUtils.isEmpty(localFriends.name)) {}
        }
      }
    }
    for (Object localObject = localFriends.name;; localObject = null)
    {
      return localObject;
      paramString = null;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_j_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_g_of_type_JavaLangString, paramIntent, false);
          this.jdField_h_of_type_Int |= 0x1;
          a(paramIntent);
          g(getString(2131367846));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(2131368252, 1);
        return;
      }
      a(2131368251, 0);
      return;
    }
    a(2131367135, 1);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.a(null);
    if (!TextUtils.isEmpty(paramRichStatus.c))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
      if (localStatusManager != null) {}
      for (paramRichStatus = localStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);; paramRichStatus = BitmapManager.a(getResources(), 2130841575))
      {
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, i1, i1);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i3 = (int)(20.0F * f1);
    int i1 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    int i5 = (int)(50.0F * f1);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(f1 * 20.0F);
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = i2;
    this.k = i3;
    this.l = i3;
    this.jdField_m_of_type_Int = i1;
    paramMyGridView.setPadding(this.jdField_i_of_type_Int, this.k, this.jdField_j_of_type_Int, this.l);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, getTitleBarHeight(), 0, paramInt);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 1007: 
    case 1008: 
    case 1010: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1020: 
    case 1021: 
    case 1022: 
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((FriendManager)this.app.getManager(8)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    paramString = localFriendManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int i1 = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendsManager)this.app.getManager(49)).a(String.valueOf(i1));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void c()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.a(ChatSettingActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    Intent localIntent = new Intent(getActivity(), EditActivity.class);
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    localIntent.putExtra("title", 2131366181).putExtra("limit", 96).putExtra("current", paramString).putExtra("canPostNull", bool).putExtra("multiLine", false);
    startActivityForResult(localIntent, 1003);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_f_of_type_JavaLangString, 2, "AIO_edit_name");
    }
    ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_name", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.a(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = null;
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Friends localFriends = ((FriendManager)this.app.getManager(8)).c(paramString);
    if (localFriends != null) {
      startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", paramString).putExtra("mgid", (byte)localFriends.groupid), 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_f_of_type_JavaLangString, 2, "AIO_edit_category");
    }
    ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_h_of_type_JavaLangString == null) {
      this.jdField_h_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_g_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = 1003;
    }
    if ((1 == this.jdField_b_of_type_Int) || (1000 == this.jdField_b_of_type_Int) || (1004 == this.jdField_b_of_type_Int)) {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.jdField_q_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("add_friend_source_id", 10004);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
  }
  
  private void e(String paramString)
  {
    Object localObject = this.app.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.app.a().e(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        this.app.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Int, l1);
          }
          paramString = this.app.a(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.jdField_g_of_type_JavaLangString;
          ((Message)localObject).arg1 = this.jdField_b_of_type_Int;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      h();
    }
    for (;;)
    {
      setTitle(2131367787);
      return;
      g();
    }
  }
  
  private void f(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131367048)).setMessage(getString(2131367057)).setPositiveButton(2131365959, new dph(this, paramString)).setNegativeButton(2131366375, new dpg(this)).show();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130903353, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    try
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903158, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
      super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297138));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297139));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297141));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297142));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297143));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297121));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297122));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297124));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297148));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297149));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297145));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297146));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297123).setOnClickListener(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setFocusable(false);
      Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131297147);
      if (Build.VERSION.SDK_INT <= 25)
      {
        ((View)localObject).setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131368193));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131366949));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366331));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366332));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367772));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369132));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367807));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367776));
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131367048));
        this.jdField_j_of_type_JavaLangString = a(this.jdField_g_of_type_JavaLangString);
        if (this.jdField_j_of_type_JavaLangString == null) {
          this.jdField_j_of_type_JavaLangString = "";
        }
        a(this.jdField_j_of_type_JavaLangString);
        if (this.jdField_j_of_type_JavaLangString != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
        }
        if (this.jdField_g_of_type_JavaLangString != null)
        {
          localObject = this.app.b(this.jdField_g_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        a(a(this.jdField_g_of_type_JavaLangString), this.jdField_c_of_type_AndroidWidgetTextView);
        this.jdField_m_of_type_JavaLangString = b(this.jdField_g_of_type_JavaLangString);
        if (this.jdField_m_of_type_JavaLangString == null) {
          this.jdField_m_of_type_JavaLangString = "";
        }
        b(this.jdField_m_of_type_JavaLangString);
        n();
        if (this.app != null) {
          u();
        }
        return;
        ((View)localObject).setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904387);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131366988));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  private void h()
  {
    Object localObject = View.inflate(this, 2130903160, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131297158));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903159, null);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    super.setContentView((View)localObject);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297150));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297155));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297151));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297153));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297154));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131297156));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297157));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297159));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131368193));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367804));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367807));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131367805));
    this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(getString(2131367234));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((this.jdField_b_of_type_Int == 1006) && (this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false)))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject != null) {
        ((Switch)localObject).setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_b_of_type_Int != 1010) && (this.jdField_b_of_type_Int != 1001) && ((this.jdField_b_of_type_Int != 1022) || ((this.jdField_q_of_type_Int != 3007) && (this.jdField_q_of_type_Int != 2007) && (this.jdField_q_of_type_Int != 3019) && (this.jdField_q_of_type_Int != 2019)))) {
        break label809;
      }
      localObject = FaceDrawable.a(this.app, 3000, this.jdField_g_of_type_JavaLangString, true);
      label485:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.o = this.jdField_g_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1004)) {
        this.p = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if (this.jdField_b_of_type_Int == 1001) {
        break label891;
      }
      if (this.jdField_b_of_type_Int == 1006)
      {
        this.jdField_q_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
          break label851;
        }
        this.jdField_f_of_type_Boolean = false;
      }
      label578:
      localObject = (ShieldMsgManger)this.app.getManager(15);
      if ((localObject != null) && (!TextUtils.isEmpty(this.o))) {
        this.jdField_e_of_type_Boolean = ((ShieldMsgManger)localObject).a(this.o);
      }
      label617:
      if (!a(this.jdField_b_of_type_Int)) {
        break label943;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
      this.jdField_h_of_type_Boolean = true;
      t();
      a(a(this.jdField_g_of_type_JavaLangString), this.jdField_f_of_type_AndroidWidgetTextView);
      localObject = new String[1];
      localObject[0] = this.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        b();
      }
      if ((this.jdField_b_of_type_Int != 1010) && (this.jdField_b_of_type_Int != 1001) && ((this.jdField_b_of_type_Int != 1022) || ((this.jdField_q_of_type_Int != 3007) && (this.jdField_q_of_type_Int != 2007) && (this.jdField_q_of_type_Int != 3019) && (this.jdField_q_of_type_Int != 2019)))) {
        break label955;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject, true);
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dos(this));
      break;
      label809:
      if (this.jdField_b_of_type_Int == 1006)
      {
        localObject = this.app.a(this.jdField_g_of_type_JavaLangString, (byte)3);
        break label485;
      }
      localObject = FaceDrawable.a(this.app, 1, this.jdField_g_of_type_JavaLangString);
      break label485;
      label851:
      localObject = ContactUtils.d(this.app, this.jdField_q_of_type_JavaLangString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_f_of_type_Boolean = false;
        break label578;
      }
      this.jdField_f_of_type_Boolean = true;
      this.o = ((String)localObject);
      break label578;
      label891:
      localObject = ((FriendManager)this.app.getManager(8)).c(this.o);
      if ((localObject != null) && (((Friends)localObject).groupid == -1002))
      {
        this.jdField_e_of_type_Boolean = true;
        break label617;
      }
      this.jdField_e_of_type_Boolean = false;
      break label617;
      label943:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label955:
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject, false);
  }
  
  private void i()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_g_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 50 - localArrayList.size() - 1);
    localIntent.putExtra("display_like_dialog", true);
    startActivityForResult(localIntent, 2);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this, FMActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    startActivity(localIntent);
  }
  
  private void l()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("friendUin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    PhotoUtils.a(this, localIntent);
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void n()
  {
    Object localObject = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!QvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130841955);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130841952);
    getResources().getDrawable(2130838068);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
    {
      if (QvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString, this.app))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
          p();
        }
        String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(QvipSpecialCareManager.a(this.jdField_g_of_type_JavaLangString, this.app));
        FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = getResources().getString(2131369144);
        }
        localFormSimpleItem.setRightText(str1);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131369144));
    boolean bool1 = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("special_care_chat_setting", true);
    boolean bool2 = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("special_care_red_point_one", false);
    if ((bool1) || (bool2))
    {
      int i1 = (int)getResources().getDimension(2131493182);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void p()
  {
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new dpe(this));
  }
  
  private void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.app.a(new dpf(this, localStringBuilder));
    a(2, getString(2131367019));
  }
  
  private void r()
  {
    boolean bool = true;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131365730, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      b();
      return;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_g_of_type_JavaLangString);
      if (l1 > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_d_of_type_Boolean)
        {
          localFriendListHandler.a(l1, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        bool = false;
      }
      a(1, "无效的号码");
    }
  }
  
  private void s()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131365730, 1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    for (;;)
    {
      return;
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      try
      {
        l1 = Long.parseLong(this.o);
        if (l1 > 0L)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(l1));
          if (this.jdField_e_of_type_Boolean)
          {
            localShieldMsgManger.b(this.jdField_b_of_type_Int, localArrayList);
            this.jdField_g_of_type_Boolean = true;
            if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 1003))
            {
              if (!this.jdField_e_of_type_Boolean) {
                break label252;
              }
              if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
              {
                this.app.a().b(this.jdField_g_of_type_JavaLangString);
                this.jdField_g_of_type_Boolean = true;
              }
            }
            if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_Int != 1010)) {
              continue;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break label291;
            }
            ReportController.b(this.app, "CliOper", "", this.o, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = 0L;
          continue;
          localShieldMsgManger.a(this.jdField_b_of_type_Int, localException);
          continue;
          a(1, "无效的号码");
          continue;
          label252:
          if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
          {
            this.app.a().a(this.jdField_g_of_type_JavaLangString);
            this.jdField_g_of_type_Boolean = true;
          }
        }
        label291:
        ReportController.b(this.app, "CliOper", "", this.o, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367806));
    }
    if ((this.jdField_b_of_type_Int == 1003) || (!this.jdField_f_of_type_Boolean)) {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void u()
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    if ((localFriendManager != null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
      this.jdField_d_of_type_Boolean = localFriendManager.g(this.jdField_g_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367806));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
  }
  
  private void v()
  {
    if (this.app != null)
    {
      Handler localHandler = this.app.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.app.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void w()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_g_of_type_JavaLangString, 46);
    localAllInOne.a = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_g_of_type_JavaLangString);
    localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localAllInOne.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localAllInOne.jdField_f_of_type_Int = 5;
    localAllInOne.g = 61;
    label266:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 1010) && ((this.jdField_b_of_type_Int != 1022) || ((this.jdField_q_of_type_Int != 3007) && (this.jdField_q_of_type_Int != 2007) && (this.jdField_q_of_type_Int != 3019) && (this.jdField_q_of_type_Int != 2019)))) {
        break label483;
      }
      if (this.jdField_b_of_type_Int == 1001)
      {
        localAllInOne.g = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", localAllInOne);
        if (!Utils.a(this.jdField_g_of_type_JavaLangString, this.app.a())) {
          break label471;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      return;
      localAllInOne.a = 42;
      break;
      localAllInOne.a = 76;
      break;
      localAllInOne.a = 22;
      localAllInOne.d = this.p;
      break;
      localAllInOne.a = 70;
      break;
      localAllInOne.a = 47;
      localAllInOne.jdField_e_of_type_JavaLangString = this.p;
      break;
      localAllInOne.a = 2;
      break;
      localAllInOne.a = 34;
      break;
      localAllInOne.a = 57;
      break;
      localAllInOne.a = 72;
      break;
      localAllInOne.a = 74;
      break;
      localAllInOne.a = 27;
      break;
      localAllInOne.a = 58;
      break;
      if (this.jdField_b_of_type_Int == 1010)
      {
        localAllInOne.g = 13;
        break label266;
      }
      localAllInOne.g = 30;
      break label266;
      label471:
      localIntent.putExtra("param_mode", 3);
    }
    label483:
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void x()
  {
    int i4 = 10004;
    int i3 = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i1 = i4;
    int i2 = i3;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      i2 = i3;
      i1 = i4;
      localObject1 = localObject2;
    }
    while (i1 == 3007)
    {
      if (LBSHandler.a(this.app, this.jdField_g_of_type_JavaLangString)) {
        break label331;
      }
      a();
      return;
      i1 = 3004;
      localObject1 = getIntent().getStringExtra("troop_uin");
      i2 = i3;
      continue;
      i1 = 3007;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3003;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3005;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3008;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3006;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3013;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3008;
      localObject1 = localObject2;
      i2 = i3;
      continue;
      i1 = 3003;
      i2 = 2;
      localObject1 = localObject2;
      continue;
      i1 = 3019;
      localObject1 = localObject2;
      i2 = i3;
    }
    if ((i1 == 3019) && (!DatingUtil.a(this.app, this.jdField_g_of_type_JavaLangString)))
    {
      a();
      return;
    }
    label331:
    if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 4000) || (this.jdField_b_of_type_Int == 1006)) {}
    for (localObject1 = AddFriendLogicActivity.a(this, 2, this.jdField_q_of_type_JavaLangString, null, i1, i2, this.jdField_h_of_type_JavaLangString, null, null, setLastActivityName());; localObject1 = AddFriendLogicActivity.a(this, 1, this.jdField_g_of_type_JavaLangString, (String)localObject1, i1, i2, this.jdField_h_of_type_JavaLangString, null, null, setLastActivityName()))
    {
      startActivity((Intent)localObject1);
      return;
    }
  }
  
  private void y()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_g_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_g_of_type_JavaLangString);
    if (3000 != this.jdField_b_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    }
    localAllInOne.jdField_f_of_type_Int = 5;
    localAllInOne.g = 61;
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void z()
  {
    ReportController.b(this.app, "CliOper", "", "", "Special_remind", "Clk_special_remind", 62, 0, "", "", "", "");
    Object localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://imgcache.qq.com/club/client/specialRing/rel/index.html?_wv=1027&suin=" + this.jdField_g_of_type_JavaLangString + "&uin=" + this.app.a() + "&_bid=279");
    ((Intent)localObject).putExtra("uin", this.jdField_g_of_type_JavaLangString);
    startActivity((Intent)localObject);
    localObject = this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    ((SharedPreferences)localObject).edit().putBoolean("special_care_chat_setting", false).commit();
    if (((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false)) {
      ((SharedPreferences)localObject).edit().putBoolean("special_care_red_point_one", false).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131369575), new doz(this), new dpa(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_c_of_type_Boolean = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      return;
      m();
      finish();
      return;
      setResult(-1);
      this.jdField_b_of_type_Boolean = true;
      return;
      a(paramIntent);
      return;
      b(paramIntent);
      return;
      switch (paramIntent.getIntExtra("param_subtype", -1))
      {
      default: 
        return;
      case 0: 
        ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
      }
      Intent localIntent = new Intent(this, ChatActivity.class);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
      localIntent.putExtra("isBack2Root", true);
      localIntent.setFlags(67108864);
      getActivity().startActivity(localIntent);
      noFinishAnim();
      finish();
      return;
    }
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
    c();
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    d();
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected void doOnPause()
  {
    this.jdField_c_of_type_Boolean = true;
    v();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(32);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(33);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      localObject = ((FriendsManager)this.app.getManager(49)).a(this.jdField_g_of_type_JavaLangString);
      if ((localObject == null) || (((SpecialCareInfo)localObject).globalSwitch == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131368425));
      }
    }
    else
    {
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297125);
      if (localObject != null) {
        if (!ChatBackground.a(this, this.app.getAccount(), this.jdField_g_of_type_JavaLangString)) {
          break label218;
        }
      }
    }
    label218:
    for (int i1 = 2131370020;; i1 = 2131370018)
    {
      ((TextView)localObject).setText(i1);
      if ((this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (!ChatBackground.a(this, this.app.getAccount(), false))) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.b();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131368426));
      break;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean) {
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
    }
    for (;;)
    {
      r();
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131297143: 
    case 2131297121: 
    case 2131297122: 
    case 2131297123: 
    case 2131297148: 
    case 2131297155: 
    case 2131297159: 
      do
      {
        return;
        i();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
        return;
        j();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
        return;
        k();
        FileManagerReporter.a("0X8004E01");
        return;
        ReportController.b(null, "CliOper", "", "", "0X8006279", "0X8006279", 0, 0, "1", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.c();
        ChatBackground.a(this, this.app.getAccount(), false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370018, new dpb(this));
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370019, new dpc(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(), 0, 12, 12);
        ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        return;
        C();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
        return;
        q();
        ReportController.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      } while (!a(this.jdField_b_of_type_Int));
      ProfileCardUtil.a(this, "", this.jdField_g_of_type_JavaLangString, this.app.getAccount(), false);
      return;
    case 2131297150: 
      w();
      return;
    case 2131297157: 
      x();
      ReportController.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
      return;
    case 2131297138: 
      y();
      return;
    case 2131297149: 
      f(this.jdField_g_of_type_JavaLangString);
      ReportController.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent(this, QQSpecialCareSettingActivity.class);
    paramView.putExtra("key_friend_uin", this.jdField_g_of_type_JavaLangString);
    startActivity(paramView);
    ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */