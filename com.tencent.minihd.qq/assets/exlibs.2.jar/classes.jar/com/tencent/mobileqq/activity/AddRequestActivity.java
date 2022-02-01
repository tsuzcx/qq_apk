package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dfm;
import dfp;
import dfq;
import dfr;
import dfs;
import dft;
import dfu;
import dfv;
import dfw;
import dfx;
import dfy;
import dfz;
import dga;
import dgb;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AddRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants
{
  public static final int a = 1;
  public static final String a = "infoid";
  public static final int b = 2;
  public static final String b = "infouin";
  static final int jdField_c_of_type_Int = 2;
  public static final String c = "infonick";
  public static final String d = "infotime";
  public static final String e = "verify_msg";
  public static final String f = "verify_type";
  private static final int jdField_g_of_type_Int = 0;
  public static final String g = "msg_source";
  private static final int jdField_h_of_type_Int = 1;
  public static final String h = "msg_source_id";
  private static final int jdField_i_of_type_Int = 1;
  public static final String i = "msg_type";
  public static final String j = "sig";
  public static final String k = "lToMobile";
  public static final String l = "strNickName";
  public static final String m = "info_dealwith_msg";
  public static final String n = "msg_troopuin";
  public static final String o = "info_troopnickname";
  public static final String p = "msg_title";
  private static final String r = "Q.systemmsg.AddRequestActivity";
  protected float a;
  public long a;
  public Dialog a;
  final Handler jdField_a_of_type_AndroidOsHandler = new dfm(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dfz(this);
  public Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dft(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dfp(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dfs(this);
  public QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private boolean jdField_a_of_type_Boolean = false;
  public byte[] a;
  protected float b;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new dga(this);
  public Button b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new dgb(this);
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 10004;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private final int jdField_j_of_type_Int = 0;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private final int k = 1;
  public String q;
  private String s;
  private String t = "";
  private String u = "";
  private String v;
  private String w = "";
  private String x;
  
  private boolean a()
  {
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
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
      if ((localList != null) && (1 < localList.size()))
      {
        ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(1)).action_info.get()).blacklist.set(true);
        this.jdField_a_of_type_Boolean = true;
        this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(1)).action_info.get(), 1);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
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
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i1 = 0;
      while (i1 < paramString.length())
      {
        if (!Character.isSpaceChar(paramString.charAt(i1))) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 0;
    b();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300571));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300572));
    this.g = ((TextView)findViewById(2131300573));
    TextView localTextView = (TextView)findViewById(2131300582);
    Object localObject2 = (LinearLayout)findViewById(2131300575);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131300581);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296567));
    this.h = ((TextView)findViewById(2131296683));
    Object localObject1 = (TextView)findViewById(2131296583);
    Object localObject3 = (TextView)findViewById(2131300576);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300584));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300583));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131300577));
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.t = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    TextPaint localTextPaint = ((TextView)localObject3).getPaint();
    localObject1 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.t);
    label403:
    int i1;
    if (this.jdField_b_of_type_Float - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.t);
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.t == null) || (this.t.equals(""))) {
        break label613;
      }
      if ((this.u == null) || (this.u.equals(""))) {
        break label589;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130838155);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      localTextView.setText(this.u);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1458;
      }
      new ArrayList();
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label767;
      }
      i1 = 0;
      label476:
      if (i1 >= ((List)localObject2).size()) {
        break label785;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
      if (i1 != 0) {
        break label727;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
    }
    for (;;)
    {
      i1 += 1;
      break label476;
      localObject2 = (LinearLayout)findViewById(2131300578);
      localObject1 = (TextView)findViewById(2131300579);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131300580));
      break;
      label589:
      ((LinearLayout)localObject2).setBackgroundResource(2130838153);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label403;
      label613:
      if ((this.t != null) && (!this.t.equals(""))) {
        break label403;
      }
      if ((this.u != null) && (!this.u.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        localTextView.setText(this.u);
        if (localLinearLayout.getVisibility() == 0) {
          break label403;
        }
        localLinearLayout.setVisibility(0);
        break label403;
      }
      localObject3 = (ViewGroup)findViewById(2131300569);
      ((View)localObject3).setBackgroundResource(2130838151);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label403;
      label727:
      if (i1 == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
      }
    }
    label767:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    label785:
    localObject2 = (TextView)findViewById(2131300125);
    if ((this.jdField_f_of_type_Int == 3014) || (this.jdField_f_of_type_Int == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label823:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300588));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300587));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300586));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null))
      {
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) && (!"".equals(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get()))) {
          break label1489;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label981:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        label1077:
        this.i = ((TextView)findViewById(2131300570));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.i.setVisibility(0);
          label1175:
          localObject2 = ((FriendManager)this.app.getManager(8)).c(this.s);
          if ((localObject2 != null) && (((Friends)localObject2).alias != null) && (((Friends)localObject2).alias.length() != 0)) {
            break label1587;
          }
          this.v = this.s;
          localObject2 = this.app;
          localObject3 = this.app;
          ((FriendListHandler)((QQAppInterface)localObject2).a(1)).b(this.s);
          label1258:
          if (TextUtils.isEmpty(this.q)) {
            break label1599;
          }
          this.h.setText(this.q);
          label1279:
          if ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2007))
          {
            i1 = i2;
            if (this.jdField_f_of_type_Int != 2019) {}
          }
          else
          {
            localObject2 = (FriendManager)this.app.getManager(8);
            if ((localObject2 == null) || (!((FriendManager)localObject2).b(this.s))) {
              break label1613;
            }
            i1 = i2;
          }
          label1358:
          if (i1 == 0) {
            break label1618;
          }
        }
        break;
      }
    }
    label1458:
    label1489:
    label1618:
    for (localObject2 = FaceDrawable.a(this.app, 3000, this.s, true);; localObject2 = FaceDrawable.a(this.app, 1, this.s))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
      ((ViewGroup)findViewById(2131300569)).setOnClickListener(new dfu(this));
      if (this.jdField_e_of_type_Int != 2) {
        break label1635;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      ((TextView)localObject1).setText(StringUtil.b(this.t));
      localObject1 = new dfv(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      ((TextView)localObject2).setVisibility(8);
      break label823;
      if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() != 1)) {
        break label981;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label981;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      break label1077;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      break label1077;
      this.i.setVisibility(8);
      a();
      break label1175;
      this.v = ((Friends)localObject2).alias;
      break label1258;
      this.h.setText(this.s);
      break label1279;
      i1 = 1;
      break label1358;
    }
    label1587:
    label1599:
    label1613:
    label1635:
    ((TextView)localObject1).setText(StringUtil.b(this.t));
    if ((this.t == null) || ("".equals(this.t))) {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = new dfw(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    int i2 = -1;
    Card localCard = ((FriendManager)this.app.getManager(8)).a(this.s);
    Object localObject1;
    if (localCard != null)
    {
      localObject1 = "";
      if ((localCard == null) || ((localCard.shGender != 0) && (localCard.shGender != 1))) {
        break label392;
      }
    }
    label392:
    for (int i1 = localCard.shGender;; i1 = -1)
    {
      if (i1 == 0)
      {
        localObject1 = getString(2131366573);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = "";
        i1 = i2;
        if (localCard != null) {
          i1 = localCard.age;
        }
        if (i1 <= 0) {
          break label353;
        }
        localObject1 = i1 + getString(2131366575);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject2 = "";
        localObject1 = localObject2;
        if (localCard.strProvince != null)
        {
          localObject1 = localObject2;
          if (localCard.strProvince.length() > 0) {
            localObject1 = "" + localCard.strProvince;
          }
        }
        localObject2 = localObject1;
        if (localCard.strCity != null)
        {
          localObject2 = localObject1;
          if (localCard.strCity.length() > 0) {
            localObject2 = (String)localObject1 + "" + localCard.strCity;
          }
        }
        this.g.setText((CharSequence)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.AddRequestActivity", 2, "age:" + localCard.age + "gender:" + localCard.shGender);
        }
        return;
        if (i1 == 1)
        {
          localObject1 = getString(2131366574);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label353:
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject1 = this.app;
      Object localObject2 = this.app;
      ((FriendListHandler)((QQAppInterface)localObject1).a(1)).b(this.s);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("infotime", paramLong1);
    localIntent.putExtra("refuse_reason", paramString2);
    localIntent.putExtra("db_id", paramLong2);
    localIntent.putExtra("src_name", paramString3);
    startActivityForResult(localIntent, 0);
  }
  
  public void a(String paramString1, long paramLong1, byte[] paramArrayOfByte, String paramString2, long paramLong2, long paramLong3, String paramString3)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 2);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("lToMobile", paramLong1);
    localIntent.putExtra("sig", paramArrayOfByte);
    localIntent.putExtra("nick_name", paramString2);
    localIntent.putExtra("infotime", paramLong2);
    localIntent.putExtra("db_id", paramLong3);
    localIntent.putExtra("src_name", paramString3);
    startActivityForResult(localIntent, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = getResources().getDimensionPixelSize(2131493031);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i1 * 1 - 175.0F * this.mDensity);
  }
  
  public void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131366141), 3);
    localActionSheet.a(new dfx(this, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  public void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131367239));
    localActionSheet.a(getString(2131367238), 3);
    localActionSheet.a(new dfy(this, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    this.jdField_b_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.s = getIntent().getStringExtra("infouin");
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.t = getIntent().getStringExtra("verify_msg");
    this.jdField_e_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.u = getIntent().getStringExtra("msg_source");
    this.jdField_f_of_type_Int = getIntent().getIntExtra("msg_source_id", 10004);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("msg_type", -1006);
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("sig");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("lToMobile", 0L);
    this.q = getIntent().getStringExtra("strNickName");
    this.x = getIntent().getStringExtra("info_dealwith_msg");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("msg_troopuin", 0L);
    this.w = getIntent().getStringExtra("msg_title");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    setContentView(2130904034);
    setContentBackgroundResource(2130837687);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300585));
    if ((this.x != null) && (!this.x.equals("")))
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.x);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setTitle(this.w);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131366143)).setMessage(2131366144).setPositiveButton(2131366145, new dfr(this)).setNegativeButton(2131366375, new dfq(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903050);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606)).setText(2131366160);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */