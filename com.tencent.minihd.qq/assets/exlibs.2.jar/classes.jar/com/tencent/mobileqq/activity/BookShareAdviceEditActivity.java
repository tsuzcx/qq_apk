package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.book.BookEditText;
import com.tencent.mobileqq.activity.book.ResizeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import dkg;
import dkh;
import dki;

public class BookShareAdviceEditActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 1;
  public static final String a = "qrmsg";
  public static final int b = 0;
  public static final String b = "qrsendname";
  public static final String c = "qrreceivername";
  private static final int d = 120;
  private static final String e = "BookShareAdviceEditActivity";
  public Intent a;
  View.OnClickListener a;
  public TextView a;
  public BookEditText a;
  public ResizeLayout a;
  TextView b;
  public int c;
  TextView c;
  public String d = "";
  
  public BookShareAdviceEditActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dkg(this);
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private String a()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_content_action_DATA");
    if (str == null) {
      return "";
    }
    int i = str.indexOf("&name=", 0);
    int j = str.indexOf("&", "&name=".length() + i);
    if (j != -1) {}
    for (str = str.substring(i + "&name=".length(), j);; str = str.substring(i + "&name=".length(), str.length())) {
      return b(str);
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("&", "/46");
    }
    return str;
  }
  
  @SuppressLint({"NewApi"})
  private void a()
  {
    Object localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidContentIntent.getExtras());
    if ((localObject1 instanceof StructMsgForGeneralShare))
    {
      Object localObject2 = (StructMsgForGeneralShare)localObject1;
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qrreceivername");
      StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_content_action_DATA"));
      localStringBuilder.append("&msg=").append(a(this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.getText().toString())).append("&toUin=").append(str);
      ((StructMsgForGeneralShare)localObject2).mMsgActionData = localStringBuilder.toString();
      localObject2 = this.app.a();
      int i = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = i + 1;
      long l = i;
      localObject1 = MessageRecordFactory.a(this.app, (String)localObject2, str, (String)localObject2, 0, l, (AbsStructMsg)localObject1);
      this.app.a().a((MessageRecord)localObject1, null);
      QQToast.a(this, 2, getString(2131368770), 0).b(getTitleBarHeight());
      setResult(-1);
      finish();
    }
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("/46", "&");
    }
    return str;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBookResizeLayout = ((ResizeLayout)findViewById(2131296824));
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText = ((BookEditText)findViewById(2131296827));
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setCanInputWhenLenghtLimit(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setTextLengthLimit(120);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296828));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296829));
    this.b = ((TextView)findViewById(2131296825));
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qrreceivername");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.app, this.app.a()));
    this.d = ContactUtils.b(this.app, (String)localObject, 0);
    this.b.setText(c(this.d));
    localObject = getResources().getStringArray(2131230748);
    String str1 = localObject[new java.util.Random().nextInt(localObject.length)];
    this.jdField_a_of_type_AndroidContentIntent.getStringExtra("title");
    String str2 = a();
    localObject = str1;
    if (str1 != null)
    {
      localObject = str1.replace("%s", str2);
      this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setSelection(((String)localObject).length());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.getText() != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.getText().toString();
      if ((str1 == null) || (!"".equals(str1))) {
        break label345;
      }
      this.rightHighLView.setEnabled(false);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = ((120 - this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.a((String)localObject) + 2) / 3);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.addTextChangedListener(new dkh(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityBookResizeLayout.setOnResizeListener(new dki(this));
      return;
      label345:
      this.rightHighLView.setEnabled(true);
    }
  }
  
  private String c(String paramString)
  {
    int i = getResources().getDisplayMetrics().widthPixels;
    if (!TextUtils.isEmpty(paramString))
    {
      i = i * 1 / 2;
      int j = (int)Layout.getDesiredWidth(paramString, this.b.getPaint());
      String str = paramString;
      if (j > i)
      {
        paramString = paramString.substring(0, i * paramString.length() / j);
        str = paramString + "...";
      }
      return str;
    }
    return "";
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setBackgroundResource(2130841550);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903096);
    setTitle(getString(2131368767));
    setRightHighlightButton(2131368765, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    enableRightHighlight(true);
    setLeftViewName(2131365114);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BookShareAdviceEditActivity
 * JD-Core Version:    0.7.0.1
 */