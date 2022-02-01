package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import gpw;
import gpx;
import gpy;
import gqa;
import gqb;
import gqc;
import gqd;
import gqe;
import gqf;
import gqg;
import gqh;
import gqi;
import gqk;
import gql;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  protected static final String a = "QQwangting";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  protected static final String b = "txl_show_bluebar";
  protected static final String c = "txl_clk_bluebar";
  protected static final String d = "txl_close_bluebar";
  protected static final String e = "show_bluebar";
  protected static final String f = "clk_bluebar";
  static final int g = 1;
  protected static final String g = "close_bluebar";
  public static final int h = 2;
  private static final String h = ContactListView.class.getSimpleName();
  static final int jdField_i_of_type_Int = 3;
  private static final String jdField_i_of_type_JavaLangString = "未启用通讯录的联系人";
  static final int jdField_j_of_type_Int = 4;
  private static final String jdField_j_of_type_JavaLangString = "contact_bind_info_global";
  public static final int k = 5;
  private static final String k = "business_show_count";
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 3;
  private static final int p = 1;
  private static final int r = 3;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gpw(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ForwardOperations a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gpx(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public gqg a;
  gqh jdField_a_of_type_Gqh;
  private gqi jdField_a_of_type_Gqi;
  public gql a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  public List b;
  private View jdField_c_of_type_AndroidViewView;
  private List jdField_c_of_type_JavaUtilList;
  private View d;
  public int l;
  private int q = 0;
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2130903397);
    this.jdField_a_of_type_Gql = new gql(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298098));
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131299461).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_c_of_type_AndroidViewView);
    this.d = b();
    if (this.d != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.d);
      a("P_CliOper", "QQwangting", "txl_show_bluebar", "show_bluebar");
      a(false);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298099));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 4))
    {
      this.jdField_a_of_type_Gqh = new gqh(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gqh);
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
      return;
    }
    this.jdField_a_of_type_Gqg = new gqg(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gqg);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    paramView = (gqk)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i1 = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i1 == 2)
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (i1 != 2) {
        break label219;
      }
      paramView = new Intent(getContext(), ChatActivity.class);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject2 != null)
      {
        localObject1 = ((FriendManager)localObject2).c(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ContactUtils.a((Friends)localObject1));
          if (((Friends)localObject1).cSpecialFlag == 1)
          {
            paramView.setClass(getContext(), ChatActivity.class);
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
    }
    label219:
    while (i1 != 3)
    {
      return;
      paramView = "1";
      break;
    }
    paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    localObject2 = paramView.nationCode + paramView.mobileNo;
    paramView = new Intent(getContext(), ChatActivity.class);
    paramView.putExtra("entrance", 3);
    paramView.putExtra("uin", ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode);
    paramView.putExtra("phonenum", (String)localObject2);
    paramView.putExtra("uintype", 1006);
    paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
    localObject2 = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 31);
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    ((ProfileActivity.AllInOne)localObject2).h = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).k = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).d = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).f = 3;
    ((ProfileActivity.AllInOne)localObject2).g = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    paramView.addFlags(67108864);
    a(paramView);
  }
  
  private void a(View paramView, PhoneContact paramPhoneContact)
  {
    gqk localgqk = (gqk)paramView.getTag();
    localgqk.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    localgqk.jdField_a_of_type_JavaLangString = null;
    localgqk.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    localgqk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramPhoneContact.uin.equals("0")) {
      if (paramPhoneContact.hasSendAddReq)
      {
        localgqk.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        localgqk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localgqk.jdField_c_of_type_AndroidWidgetTextView.setText("等待验证");
      }
    }
    for (;;)
    {
      paramView.setContentDescription(paramPhoneContact.name);
      if (paramPhoneContact.uin.equals("0")) {
        break;
      }
      localgqk.jdField_a_of_type_Int = 2;
      a(localgqk, paramPhoneContact.uin, Integer.parseInt(paramPhoneContact.faceUrl), 1);
      return;
      localgqk.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      localgqk.jdField_c_of_type_AndroidWidgetButton.setContentDescription("添加按钮");
      localgqk.jdField_c_of_type_AndroidWidgetButton.setTag(localgqk);
      localgqk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      localgqk.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localgqk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localgqk.jdField_c_of_type_AndroidWidgetTextView.setText("已添加");
    }
    localgqk.jdField_a_of_type_Int = 3;
    a(localgqk, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int i2;
    int i1;
    if (this.q == 0)
    {
      i2 = paramListView.getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        gqk localgqk = (gqk)paramListView.getChildAt(i1).getTag();
        if ((localgqk != null) && (paramString.equals(localgqk.jdField_a_of_type_JavaLangString))) {
          localgqk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(gqk paramgqk, String paramString, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt2, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt2, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramgqk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramgqk.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, "", paramString3, paramString4, 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    SharedPreferences.Editor localEditor;
    if (localSharedPreferences != null)
    {
      localEditor = localSharedPreferences.edit();
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (int i1 = 3;; i1 = localSharedPreferences.getInt("business_show_count", 0) + 1)
    {
      localEditor.putInt("business_show_count", i1);
      localEditor.commit();
      return;
    }
  }
  
  private View b()
  {
    View localView = null;
    if (b())
    {
      localView = LayoutInflater.from(getContext()).inflate(2130903851, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localView.findViewById(2131299827).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return localView;
  }
  
  private void b(View paramView)
  {
    Object localObject = (gqk)paramView.getTag();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i2;
    int i1;
    if (((gqk)localObject).jdField_a_of_type_Int == 2)
    {
      paramView = "0";
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((gqk)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      i2 = ((gqk)localObject).jdField_a_of_type_Int;
      i1 = 0;
      if (i2 != 2) {
        break label180;
      }
      i1 = 0;
    }
    for (;;)
    {
      localObject = paramView.nationCode + paramView.mobileCode;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), i1, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
      return;
      paramView = "1";
      break;
      label180:
      if (i2 == 3) {
        i1 = 1006;
      }
    }
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    return (localSharedPreferences == null) || (localSharedPreferences.getInt("business_show_count", 0) < 3);
  }
  
  private void c(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    paramView = ((gqk)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    a(AddFriendLogicActivity.a(getContext(), 2, paramView.nationCode + paramView.mobileCode, null, 3006, 3, paramView.name, null, null, "手机联系人"));
  }
  
  private void d(View paramView)
  {
    paramView = (gqk)paramView.getTag();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {}
    PhoneContact localPhoneContact;
    int i1;
    do
    {
      return;
      localPhoneContact = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      i1 = paramView.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      if (i1 == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.uin, 0, localPhoneContact.uin, localPhoneContact.name);
        return;
      }
    } while (i1 != 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.nationCode + localPhoneContact.mobileCode, 1006, "", localPhoneContact.name);
    return;
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i1 == 2)
      {
        paramView = "0";
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
        label165:
        paramView = getContext();
        localObject = new Intent(paramView, QCallDetailActivity.class);
        ((Intent)localObject).putExtra("contactID", localPhoneContact.contactID);
        switch (i1)
        {
        default: 
          ((Intent)localObject).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject).putExtra("uintype", 56938);
          ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("entrance", "Call");
      paramView.startActivity((Intent)localObject);
      return;
      paramView = "1";
      break;
      if (this.jdField_a_of_type_Int != 3) {
        break label165;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
      break label165;
      ((Intent)localObject).putExtra("uin", localPhoneContact.uin);
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.nickName);
      continue;
      ((Intent)localObject).putExtra("uin", localPhoneContact.nationCode + localPhoneContact.mobileCode);
      ((Intent)localObject).putExtra("uintype", 1006);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i1;
    if (this.jdField_a_of_type_Int == 2) {
      i1 = 11;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = new gqc(this, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, 3);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
      localTranslateAnimation1.setDuration(200L);
      localTranslateAnimation1.setFillAfter(true);
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
      localTranslateAnimation2.setDuration(200L);
      localTranslateAnimation1.setAnimationListener(new gqd(this));
      localTranslateAnimation2.setAnimationListener(new gqe(this, i1));
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new gqf(this, i1, localTranslateAnimation2));
      this.jdField_b_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
      return;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4)) {
        i1 = 5;
      } else {
        i1 = 15;
      }
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903398, null);
    gqk localgqk = new gqk(null);
    localgqk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298100));
    localgqk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298101));
    localgqk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298102));
    localgqk.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298103));
    localgqk.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localgqk.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298104));
    localgqk.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localgqk.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298106));
    localgqk.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    localgqk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298105));
    localgqk.jdField_a_of_type_AndroidViewView = localView.findViewById(2131298107);
    if (this.jdField_a_of_type_Int == 3)
    {
      localgqk.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localgqk.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localgqk.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localView.setTag(localgqk);
      return localView;
      localgqk.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localgqk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class, this.jdField_a_of_type_Gql);
    boolean bool;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("选择通讯录联系人");
      if (this.jdField_a_of_type_Gqi == null)
      {
        this.jdField_a_of_type_Gqi = new gqi(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Gqi);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      j();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i1 == 0) {
        break label229;
      }
      bool = true;
      label108:
      localTextView.setEnabled(bool);
      if ((i1 != 7) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()))
      {
        if (!NetworkUtil.e(getContext())) {
          break label234;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d == 0L)) {
          this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
        }
        h();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
        break;
      }
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText("手机联系人");
      break;
      label229:
      bool = false;
      break label108;
      label234:
      a(2131367136, 3000L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        paramIntent.putExtra("key_is_first_activity", false);
        a(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        a(new Intent(getContext(), PhoneLaunchActivity.class));
        return;
      } while (paramInt2 != 0);
      paramInt1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    a(new Intent(getContext(), PhoneLaunchActivity.class));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity.getIntent(), this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras());
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      paramIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringArrayExtra("key_reserved_mobile");
      if ((paramIntent != null) && (paramIntent.length > 0)) {
        this.jdField_c_of_type_JavaUtilList = Arrays.asList(paramIntent);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    if ((NetworkUtil.e(getContext())) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h())) {
      a(2131366988, 0L, false);
    }
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    paramView = (gqk)paramView.getTag();
    if (paramBoolean) {
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = null;
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
      if (!TextUtils.isEmpty(paramPhoneContact.uin)) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.jdField_a_of_type_Int = 1;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838853);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(paramPhoneContact.name));
      return;
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4))
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
    paramView.jdField_b_of_type_AndroidWidgetButton.setTag(paramView);
    paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发消息");
    paramView.jdField_b_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发起语音通话");
    if (!paramPhoneContact.uin.equals("0"))
    {
      paramView.jdField_a_of_type_Int = 2;
      a(paramView, paramPhoneContact.uin, 0, 1);
      return;
    }
    paramView.jdField_a_of_type_Int = 3;
    a(paramView, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.q = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < i2)
    {
      paramAbsListView = (gqk)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int i1 = 1;
        if (paramAbsListView.jdField_a_of_type_Int == 3) {
          i1 = 11;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i1, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap != null) {
          break label140;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_JavaLangString, i1, false);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label52;
      break;
      label140:
      paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.m();
    localXListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + i1);
  }
  
  protected void b()
  {
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    i();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    m();
    if (this.jdField_a_of_type_Gqi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Gqi);
      this.jdField_a_of_type_Gqi = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.d();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    super.e();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4))
    {
      k();
      this.jdField_a_of_type_Gqh.notifyDataSetChanged();
    }
    int i1;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 3);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_c_of_type_JavaUtilList);
    } while (!QLog.isColorLevel());
    QLog.d("ContactListView", 2, "load contact friend result: " + i1);
  }
  
  void k()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_Gql.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = localObject1[i1];
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
      i1 += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = "*";
    Iterator localIterator = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      Object localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) == null)
      {
        localObject1 = "#";
        localPhoneContact.pinyinFirst = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue() + 1));
      localObject2 = localObject3;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    i1 = 0;
    label251:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      i2 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (i2 == 0) {
        break label453;
      }
    }
    label453:
    for (i2 = i2 + i1 + 1;; i2 = i1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i1));
      i1 = i2;
      break label251;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4))
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(1);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("未启用通讯录的联系人", Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((Iterator)localObject1).next();
            ((PhoneContact)localObject2).pinyinFirst = "未启用通讯录的联系人";
            localArrayList.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.l = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.l <= 0) {
        break;
      }
      m();
      return;
    }
  }
  
  public void l()
  {
    if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) || (this.l > 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getContext(), 231, getContext().getString(2131362562), getContext().getString(2131362561), 2131362563, 2131362564, new gpy(this), new gqa(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new gqb(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Gql.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      return;
    case 2131299473: 
      n();
      return;
    case 2131297360: 
      if (this.jdField_a_of_type_Int == 2)
      {
        f();
        return;
      }
      b(new Intent(getContext(), SettingActivity2.class), 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131298103: 
      a(paramView);
      return;
    case 2131298104: 
      b(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */