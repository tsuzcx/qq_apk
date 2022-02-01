package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.qqmusicplayerprocess.netspeed.VkeyManager;

public class VkeyLocal
  extends Vkey
{
  private static final String jdField_a_of_type_JavaLangString = "VkeyLocal";
  private static final long jdField_b_of_type_Long = 300000L;
  private VkeyPair jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair = new VkeyPair();
  private final String jdField_b_of_type_JavaLangString;
  
  public VkeyLocal()
  {
    String str3 = SessionManager.a().a().d();
    if (str3 != null) {}
    String str2;
    for (;;)
    {
      try
      {
        String str1 = VkeyManager.getInstance().createWeakExpressKey(str3, 86400, 64);
        if ((str1 == null) || (!TextUtils.isEmpty(str1))) {
          break;
        }
        this.b = null;
        return;
      }
      catch (Exception localException)
      {
        MLog.a("VkeyLocal", localException);
        Object localObject = null;
        continue;
      }
      catch (Error localError)
      {
        MLog.a("VkeyLocal", localError);
      }
      str2 = null;
    }
    this.b = str2;
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.b(str3);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.a(str2);
  }
  
  public String a()
  {
    if (this.b == null) {
      return "";
    }
    return this.b;
  }
  
  public void a() {}
  
  public boolean a()
  {
    if (this.b == null) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long > 300000L) {
      return true;
    }
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyVkeyPair.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyLocal
 * JD-Core Version:    0.7.0.1
 */