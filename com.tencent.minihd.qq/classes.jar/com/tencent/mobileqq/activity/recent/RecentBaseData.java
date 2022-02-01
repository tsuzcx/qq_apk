package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class RecentBaseData
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  public static final int l = 15;
  public static final int m = 240;
  public static final int n = 3840;
  public static final int o = 61440;
  public static final int p = 0;
  public static final int q = 1;
  public static final int r = 16;
  public static final int s = 32;
  public static final int t = 48;
  public static final int u = 256;
  public static final int v = 4096;
  public static final int w = 8192;
  public static final int x = 12288;
  public static final int y = 16384;
  protected int A = 1;
  public int B;
  public int C;
  public int D;
  public int E;
  protected int F;
  protected int G = 0;
  public int H;
  public int I;
  public volatile long a;
  protected MsgSummary a;
  public CharSequence a;
  public String a;
  public boolean a;
  public CharSequence b;
  public String b;
  public CharSequence c;
  public String c;
  public String d;
  protected String e;
  public String f;
  public int z;
  
  public RecentBaseData()
  {
    this.jdField_a_of_type_Boolean = false;
    this.G |= 0x1;
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public final MsgSummary a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a();
    }
  }
  
  public abstract String a();
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = "null";
      String str1 = "null";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        str1 = "lenth=" + this.jdField_a_of_type_JavaLangString.length();
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        str2 = "lenth=" + this.jdField_b_of_type_JavaLangCharSequence.length();
      }
      localStringBuilder.append("[").append("type:").append(a()).append(", uin:").append(a()).append(", unreadNum:").append(this.B).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.G).append(", status:").append(this.z).append(", authenIcon:").append(this.C).append(", showTime:").append(this.jdField_b_of_type_JavaLangString).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.jdField_a_of_type_JavaLangCharSequence).append(", lastmsgtime:").append(a()).append(", lastdrafttime:").append(b()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = a();
    }
    if (paramMsgSummary != null)
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramMsgSummary.a(paramContext);
      if (((this.jdField_b_of_type_JavaLangCharSequence instanceof SpannableStringBuilder)) && (DeviceInfoUtil.b())) {
        this.jdField_b_of_type_JavaLangCharSequence = ((SpannableStringBuilder)this.jdField_b_of_type_JavaLangCharSequence).append(" ");
      }
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
      this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.d = null;
    }
    if (this.jdField_a_of_type_Long > b()) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null) {}
    for (String str = paramMessage.nickName;; str = null)
    {
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, str, false, false);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    return this.B;
  }
  
  public abstract long b();
  
  public final String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void b()
  {
    this.B = 0;
  }
  
  public final void c()
  {
    this.B = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.a() != a()) || (!Utils.a(paramObject.a(), a()))) {
        break;
      }
      return true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */