package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.qphone.base.util.QLog;
import iet;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;

public class EPRecommendTask
{
  public static final String c = "1";
  public static final String d = "https://imgcache.qq.com/club/item/parcel/android_tab.json";
  public static final String e = "2";
  public static final String f = "https://imgcache.qq.com/club/item/parcel/android_magictab.json";
  public static final String g = "3";
  public static final String h = "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json";
  public static final String i = "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/";
  private static final String j = EPRecommendTask.class.getSimpleName();
  public QQAppInterface a;
  Runnable a;
  public String a;
  public String b;
  
  public EPRecommendTask(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new iet(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public EPRecommendTask a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaLangString == "1") {
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable);
    }
    do
    {
      return;
      if (this.jdField_b_of_type_JavaLangString == "3")
      {
        ThreadManager.c(this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
    } while (this.jdField_b_of_type_JavaLangString != "2");
    ThreadManager.c(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = EmoticonUtils.a(new String(paramArrayOfByte, "utf-8"));
        if (paramArrayOfByte != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(j, 2, "promotionInfo:[hide]:" + paramArrayOfByte.jdField_a_of_type_Int + ",[ver]:" + paramArrayOfByte.jdField_b_of_type_Int);
          }
          if ((1 != paramArrayOfByte.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramArrayOfByte.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArrayOfByte.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArrayOfByte.c)))
          {
            SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
            localSharedPreferences.edit().putString("magic_promotion_jump_url", paramArrayOfByte.c).commit();
            localSharedPreferences.edit().putString("magic_promotion_imgUrl", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/" + paramArrayOfByte.jdField_b_of_type_JavaLangString).commit();
            localSharedPreferences.edit().putString("magic_promotion_gifUrl", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/" + paramArrayOfByte.jdField_a_of_type_JavaLangString).commit();
            if (localSharedPreferences.getInt("magic_promotion_old_ver_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1) < paramArrayOfByte.jdField_b_of_type_Int)
            {
              localSharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
              localSharedPreferences.edit().putInt("magic_promotion_old_ver_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramArrayOfByte.jdField_b_of_type_Int).commit();
              return;
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask
 * JD-Core Version:    0.7.0.1
 */