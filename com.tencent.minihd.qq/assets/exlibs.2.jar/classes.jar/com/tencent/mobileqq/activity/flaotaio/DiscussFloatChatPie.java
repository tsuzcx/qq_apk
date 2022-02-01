package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import glc;
import gld;

public class DiscussFloatChatPie
  extends BaseFloatChatPie
{
  private DiscussionObserver a;
  protected MessageObserver a;
  
  public DiscussFloatChatPie(QQAppInterface paramQQAppInterface, FloatAioPage paramFloatAioPage)
  {
    super(paramQQAppInterface, paramFloatAioPage);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new glc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new gld(this);
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      return;
    }
    int i = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (i <= 0)
    {
      paramTextView.setText(paramString1);
      return;
    }
    int j = FloatBaseChatItemLayout.f;
    int k = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    TextPaint localTextPaint = paramTextView.getPaint();
    float f2 = j - k - localTextPaint.measureText(String.format("(%d人)", new Object[] { Integer.valueOf(i) })) - 4.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    String str = paramString1;
    if (f2 > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString1);
      str = paramString1;
      if (f1 > f2)
      {
        float f3 = f2 - localTextPaint.measureText("…");
        paramString2 = paramString1;
        while ((f3 > 0.0F) && (f1 > f3) && (paramString2.length() > 0))
        {
          str = paramString2.substring(0, paramString2.length() - 1);
          f2 = localTextPaint.measureText(str);
          paramString2 = str;
          f1 = f2;
          if (f2 == 0.0F)
          {
            paramString2 = str;
            f1 = f2;
            if (str.length() > 0)
            {
              f1 = 1.0F + f3;
              paramString2 = str;
            }
          }
        }
        str = paramString1;
        if (f3 > 0.0F)
        {
          str = paramString1;
          if (paramString2.length() > 0) {
            str = paramString2 + "…";
          }
        }
      }
    }
    paramTextView.setText(String.format("%s(%d人)", new Object[] { str, Integer.valueOf(i) }));
  }
  
  protected void d(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.b);
  }
  
  protected void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  protected void n()
  {
    super.n();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.DiscussFloatChatPie
 * JD-Core Version:    0.7.0.1
 */