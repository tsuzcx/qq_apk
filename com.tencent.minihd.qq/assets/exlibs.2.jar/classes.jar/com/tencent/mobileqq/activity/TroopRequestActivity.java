package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import fkc;
import fkd;
import fke;
import fkf;
import fkg;
import fkh;
import fki;
import fkj;
import fkk;
import fkl;
import fkm;
import fkn;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants, FaceDecoder.DecodeTaskCompletionListener
{
  private static final String B = ".";
  private static final String C = " ";
  public static final String a = "troopMsgId";
  public static final int b = 0;
  public static final String b = "troopMsgTpype";
  public static final boolean b = true;
  public static final int c = 1;
  protected static long c = 0L;
  public static final String c = "troopCode";
  private static final int jdField_d_of_type_Int = 2;
  public static long d = 0L;
  public static final String d = "troopmanagerUin";
  private static final int jdField_e_of_type_Int = 0;
  public static final String e = "troopsMsg";
  public static final String f = "troopRequestUin";
  public static final String g = "troopAuth";
  public static final String h = "troopOp";
  public static final String i = "troopsummary";
  public static final String j = "is_unread";
  public static final String k = "infotime";
  public static final String l = "troopMsgDealInfo";
  public static final String m = "troopMsgDealType";
  public static final String n = "troopinvatememUin";
  public static final String o = "troop_describe_uintype";
  private static final String r = "Q.systemmsg.TroopRequestActivity";
  private String A = "";
  public int a;
  public long a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fkj(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fkf(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new fke(this);
  public TroopHandler a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new fkd(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private short jdField_a_of_type_Short;
  public boolean a;
  public byte[] a;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new fkk(this);
  private Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TextView c;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 0;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  public String p;
  public String q;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y = null;
  private String z = "";
  
  static
  {
    jdField_c_of_type_Long = 0L;
    jdField_d_of_type_Long = 0L;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new fkn(this);
  }
  
  private void a(Card paramCard)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = "";
    if ((paramCard != null) && ((paramCard.shGender == 0) || (paramCard.shGender == 1))) {}
    for (int i1 = paramCard.shGender;; i1 = -1)
    {
      if (i1 == 0)
      {
        str = getString(2131366573);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (paramCard == null) {
          break label160;
        }
      }
      label160:
      for (i1 = paramCard.age;; i1 = -1)
      {
        if (i1 > 0)
        {
          paramCard = i1 + getString(2131366575);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCard);
          return;
          if (i1 == 1)
          {
            str = getString(2131366574);
            break;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText("");
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        return;
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get()).blacklist.set(true);
          this.app.a().a().b(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (paramInt < localList.size())
        {
          this.app.a().a().b(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f()
  {
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    Object localObject2 = (TextView)findViewById(2131299202);
    Object localObject1 = (LinearLayout)findViewById(2131300606);
    ((LinearLayout)localObject1).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.q = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.p = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.t = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.u = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.v = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    ImageView localImageView1;
    TextView localTextView;
    ImageView localImageView2;
    Object localObject3;
    int i1;
    if (this.v.startsWith(getString(2131365889)))
    {
      this.v = this.v.replace(getString(2131365889), "");
      this.jdField_b_of_type_Long = getIntent().getLongExtra("infotime", 0L);
      ((TextView)localObject2).setText(TimeFormatterUtils.a(this, 3, this.jdField_b_of_type_Long * 1000L));
      this.jdField_a_of_type_Long = getIntent().getLongExtra("troopMsgId", 0L);
      this.w = getIntent().getExtras().getString("troopMsgDealInfo");
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      localImageView1 = (ImageView)findViewById(2131296567);
      localTextView = (TextView)findViewById(2131296683);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300597));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300598));
      localObject2 = (TextView)findViewById(2131300608);
      localImageView2 = (ImageView)findViewById(2131297282);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300607));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300583));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject3 == null) || (((List)localObject3).size() < 2)) {
        break label670;
      }
      i1 = 0;
      label481:
      if (i1 >= ((List)localObject3).size()) {
        break label759;
      }
      localObject5 = ((structmsg.SystemMsgAction)((List)localObject3).get(i1)).detail_name.get();
      if (i1 != 0) {
        break label594;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject5);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject5);
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      i1 += 1;
      break label481;
      if (!this.v.startsWith(getString(2131365890))) {
        break;
      }
      this.v = this.v.replace(getString(2131365890), "");
      break;
      label594:
      if (i1 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject5);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject5);
      }
      else if (i1 == 2)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText((CharSequence)localObject5);
        this.rightViewText.setContentDescription((CharSequence)localObject5);
        this.rightViewText.setEnabled(true);
      }
    }
    label670:
    if ((localObject3 != null) && (((List)localObject3).size() == 1))
    {
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setTextAppearance(this, 2131558818);
      ((TextView)localObject2).setText(((structmsg.SystemMsgAction)((List)localObject3).get(0)).detail_name.get());
      ((TextView)localObject2).setContentDescription(((structmsg.SystemMsgAction)((List)localObject3).get(0)).detail_name.get());
      ((TextView)localObject2).setBackgroundResource(2130838073);
      ((TextView)localObject2).setVisibility(0);
      label759:
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300602));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300603));
      this.e = ((TextView)findViewById(2131298047));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300604));
      this.g = ((TextView)findViewById(2131300605));
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      localObject5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (localObject1 != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (a((String)localObject5))
        {
          localObject1 = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label2004;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        label929:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
          this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(false);
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())) {
        break label2016;
      }
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get();
      label997:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label2023;
      }
      this.e.setVisibility(8);
      label1014:
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
        break label2084;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558822);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838081);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 22))) {
        break label2072;
      }
      this.g.setVisibility(0);
      this.g.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
      this.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
      label1145:
      localObject1 = new fkc(this, (TextView)localObject2);
      if ((localObject3 != null) && (((List)localObject3).size() == 1)) {
        ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      this.rightViewText.setOnClickListener((View.OnClickListener)localObject1);
      localObject2 = new fkg(this);
      localObject3 = new fkh(this);
      localObject5 = new fki(this);
      localObject1 = null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label2117;
      }
      localObject1 = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get(), true, false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label2180;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131300595));
      switch (TroopNotificationUtils.a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()))
      {
      default: 
        getString(2131365892);
        localObject3 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + getString(2131363674);
        localObject5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if ((localObject5 == null) || (((String)localObject5).equals("")))
        {
          localTextView.setText(this.p);
          label1459:
          localObject5 = (FriendsManagerImp)this.app.getManager(8);
          if (localObject5 == null) {
            break label2898;
          }
        }
        break;
      }
    }
    label1280:
    label1305:
    label1562:
    label1630:
    label2016:
    label2023:
    Object localObject6;
    label2072:
    label2084:
    label2117:
    label2762:
    label2898:
    for (Object localObject5 = ((FriendsManagerImp)localObject5).a(String.valueOf(this.p));; localObject6 = null)
    {
      int i2;
      if ((localObject5 != null) && (((TroopInfo)localObject5).dwGroupClassExt != 0L))
      {
        localObject5 = GroupCatalogTool.a(BaseApplication.getContext()).a(this, Long.toString(((TroopInfo)localObject5).dwGroupClassExt));
        if (localObject5 != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((GroupCatalogBean)localObject5).a() + "");
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_ext_flag.get() & 0x800) == 0) {
          break label2837;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() != 2) {
          break label2762;
        }
        localImageView2.setVisibility(0);
        localImageView2.setBackgroundResource(2130838652);
        localObject5 = localObject2;
        i1 = 4;
        localObject2 = localObject1;
        localObject1 = localObject5;
        localImageView1.setBackgroundDrawable(TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, (String)localObject3, i1));
        localImageView1.setOnClickListener((View.OnClickListener)localObject1);
        localImageView1.setContentDescription((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject1);
        this.j = ((TextView)findViewById(2131300588));
        this.i = ((TextView)findViewById(2131300587));
        this.h = ((TextView)findViewById(2131300586));
        this.j.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = super.getString(2131367235);
        this.h.setText(Html.fromHtml("<u>" + (String)localObject1 + "</u>"));
        localObject1 = super.getString(2131367234);
        this.j.setText(Html.fromHtml("<u>" + (String)localObject1 + "</u>"));
        i2 = 0;
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.z = "";
        i1 = i2;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1)
        {
          if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 22)) {
            break label2861;
          }
          this.z = this.u;
          this.A = "1";
          this.jdField_f_of_type_Int = 2131367239;
          i1 = 1;
        }
      }
      while (i1 != 0)
      {
        for (;;)
        {
          for (;;)
          {
            this.j.setVisibility(0);
            this.i.setVisibility(0);
            this.h.setVisibility(0);
            return;
            if ((localObject2 == null) || (this.w.equals(""))) {
              break;
            }
            ((TextView)localObject2).setTextAppearance(getApplicationContext(), 2131558576);
            ((TextView)localObject2).setText(this.w);
            ((TextView)localObject2).setContentDescription(this.w);
            ((TextView)localObject2).setVisibility(0);
            break;
            label2004:
            this.jdField_c_of_type_AndroidWidgetTextView.setText("");
            break label929;
            localObject1 = "";
            break label997;
            localObject1 = "\"" + localObject1 + "\"";
            this.e.setText((CharSequence)localObject1);
            this.e.setVisibility(0);
            break label1014;
            this.g.setVisibility(8);
            break label1145;
            this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558818);
            this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838073);
            this.g.setVisibility(8);
            break label1145;
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
              break label1280;
            }
            localObject1 = getResources().getString(2131365888) + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
            break label1280;
            if (a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
              this.jdField_f_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.jdField_f_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131558576);
            this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            break label1305;
            getString(2131365889);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "";
            localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + getString(2131363675);
            localObject5 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
            if ((localObject5 == null) || (((String)localObject5).equals(""))) {
              localTextView.setText((CharSequence)localObject1);
            }
            try
            {
              if (this.app != null)
              {
                localObject5 = (FriendManager)this.app.getManager(8);
                if (localObject5 != null)
                {
                  localObject5 = ((FriendManager)localObject5).a((String)localObject1);
                  if ((localObject5 == null) || (((Card)localObject5).age <= 0) || ((((Card)localObject5).shGender != 0) && (((Card)localObject5).shGender != 1))) {
                    break label2452;
                  }
                  a((Card)localObject5);
                }
              }
              for (;;)
              {
                i1 = 1;
                localObject5 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject5;
                break;
                localTextView.setText((CharSequence)localObject5);
                break label2352;
                ((FriendListHandler)this.app.a(1)).b((String)localObject1);
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
              }
              i1 = 1;
              localObject6 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject6;
            }
          }
          getString(2131365890);
          localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
          localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + getString(2131363676);
          localObject3 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
          if ((localObject3 == null) || (((String)localObject3).equals(""))) {
            localTextView.setText((CharSequence)localObject1);
          }
          try
          {
            if (this.app != null)
            {
              localObject3 = (FriendManager)this.app.getManager(8);
              if (localObject3 != null)
              {
                localObject3 = ((FriendManager)localObject3).a((String)localObject1);
                if (localObject3 == null) {
                  break label2681;
                }
                a((Card)localObject3);
              }
            }
            for (;;)
            {
              i1 = 1;
              localObject3 = localObject1;
              localObject1 = localObject6;
              break;
              localTextView.setText((CharSequence)localObject3);
              break label2610;
              label2681:
              ((FriendListHandler)this.app.a(1)).b((String)localObject1);
            }
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
            }
            i1 = 1;
            Object localObject4 = localObject1;
            localObject1 = localObject6;
          }
        }
        localTextView.setText(localObject6);
        break label1459;
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null) {
          break label1562;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d(this.p);
        break label1562;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() == 1)
        {
          localImageView2.setVisibility(0);
          localImageView2.setBackgroundResource(2130839096);
          i1 = 4;
          localObject6 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject6;
          break label1630;
        }
        localImageView2.setVisibility(8);
        i1 = 4;
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject6;
        break label1630;
        localImageView2.setVisibility(8);
        i1 = 4;
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject6;
        break label1630;
        i1 = i2;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.z = this.t;
          this.A = "0";
          this.jdField_f_of_type_Int = 2131367240;
          i1 = 1;
        }
      }
    }
  }
  
  private void g()
  {
    startActivityForResult(AddFriendLogicActivity.a(this, this.p, this.s, this.jdField_a_of_type_Short, 0, this.x, null, null, null), 0);
  }
  
  public SpannableString a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString1;
    if (paramBoolean2)
    {
      i1 = paramString1.indexOf(paramString3);
      str = paramString1;
      if (i1 > 0)
      {
        localObject = paramString1.substring(paramString3.length() + i1, paramString1.length());
        str = paramString1.substring(0, i1 + paramString3.length());
        a((String)localObject);
      }
    }
    Object localObject = Pattern.compile(paramString3).matcher(str);
    if (!((Matcher)localObject).find()) {
      return null;
    }
    paramBoolean2 = paramString3.equals(getString(2131365892));
    int i2 = 0;
    int i3 = -1;
    if (paramBoolean2) {
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_ext_flag.get() & 0x800) != 0) {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() == 2)
        {
          i2 = 1;
          i3 = 2130838652;
          i1 = 4;
          paramString1 = new DisplayMetrics();
          getWindowManager().getDefaultDisplay().getMetrics(paramString1);
          int i4 = (int)(paramString1.density * 17.0F);
          paramString1 = new StringBuilder(str);
          if (i2 == 0) {
            break label566;
          }
          paramString1.insert(((Matcher)localObject).end(), " ." + paramString2);
          paramString1 = new SpannableString(paramString1.toString());
          paramString3 = getResources().getDrawable(i3);
          paramString3.setBounds(0, 0, i4, i4);
          paramString3 = new ImageSpan(paramString3, 0);
          if (((Matcher)localObject).end() + " ".length() + ".".length() <= paramString1.length()) {
            break label544;
          }
          i2 = paramString1.length();
          label305:
          paramString1.setSpan(paramString3, ((Matcher)localObject).end() + " ".length(), i2, 33);
          i2 = ((Matcher)localObject).end();
          i3 = ".".length();
          int i5 = " ".length();
          i2 = i2 + i3 + i5;
          label356:
          boolean bool = str.contains("处理人");
          paramString3 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, paramString4, i1);
          paramString3.setBounds(0, 0, i4, i4);
          if (paramBoolean1)
          {
            paramString4 = new TroopRequestActivity.NumberSpan(this, bool, paramString2, paramString4, paramBoolean2);
            if (paramString2.length() + i2 <= paramString1.length()) {
              break label631;
            }
            i1 = paramString1.length();
            label430:
            paramString1.setSpan(paramString4, i2, i1, 33);
          }
          paramString2 = new ImageSpan(paramString3, 0);
          if (((Matcher)localObject).end() <= paramString1.length()) {
            break label643;
          }
        }
      }
    }
    label643:
    for (int i1 = paramString1.length();; i1 = ((Matcher)localObject).end())
    {
      paramString1.setSpan(paramString2, ((Matcher)localObject).start(), i1, 33);
      return paramString1;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() == 1)
      {
        i2 = 1;
        i3 = 2130839096;
        i1 = 4;
        break;
      }
      i2 = 0;
      i1 = 4;
      break;
      i2 = 0;
      i1 = 4;
      break;
      i1 = 1;
      break;
      label544:
      i2 = ((Matcher)localObject).end() + " ".length() + ".".length();
      break label305;
      label566:
      paramString1.insert(((Matcher)localObject).end(), " " + paramString2);
      paramString1 = new SpannableString(paramString1.toString());
      i2 = ((Matcher)localObject).end();
      i3 = " ".length();
      i2 += i3;
      break label356;
      label631:
      i1 = paramString2.length() + i2;
      break label430;
    }
  }
  
  public SpannableString a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!paramString.contains(getString(2131365889))) {
              break;
            }
            str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
          } while (TextUtils.isEmpty(str));
          return a(paramString, str, getString(2131365889), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
          if (!paramString.contains(getString(2131365890))) {
            break;
          }
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        } while (TextUtils.isEmpty(str));
        return a(paramString, str, getString(2131365890), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
        if (!paramString.contains(getString(2131365891))) {
          break;
        }
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
      } while (TextUtils.isEmpty(str));
      return a(paramString, str, getString(2131365891), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      if (!paramString.contains(getString(2131365892))) {
        break;
      }
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
    } while (TextUtils.isEmpty(str));
    return a(paramString, str, getString(2131365892), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
    return new SpannableString(paramString);
  }
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    case 14: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    default: 
      return getString(2131363958);
    case 1: 
    case 22: 
      return getString(2131363949);
    case 2: 
      return getString(2131363950);
    case 11: 
      return getString(2131363953);
    case 12: 
      return getString(2131363952);
    case 10: 
      return getString(2131363951);
    case 3: 
      return getString(2131363954);
    case 15: 
    case 16: 
      return getString(2131363955);
    case 6: 
    case 7: 
      return getString(2131363956);
    }
    return getString(2131363957);
  }
  
  public void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String str = "";
    if (this.jdField_f_of_type_Int != 0) {
      str = getString(this.jdField_f_of_type_Int);
    }
    localActionSheet.a(str);
    localActionSheet.a(getString(2131367238), 3);
    localActionSheet.a(new fkl(this, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else
    {
      paramString = null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label165;
      }
      paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get(), true, false);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label227;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      break;
      label165:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        paramString = getResources().getString(2131365888) + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
      }
    }
    label227:
    if (a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
      this.jdField_f_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131558576);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131365889))) || (paramString.contains(getString(2131365891))) || (paramString.contains(getString(2131365892))) || (paramString.contains(getString(2131365890)));
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131366141), 3);
    localActionSheet.a(new fkm(this, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131366988));
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904037);
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
    f();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e()
  {
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */