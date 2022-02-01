package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.data.RecentUser;

public class SecMsgRecentItemData
  extends RecentUserBaseData
{
  public SecMsgRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramContext.getResources().getString(2131369374);
    }
    this.G &= 0xFFFFFF0F;
    paramQQAppInterface = (SecMsgManager)paramQQAppInterface.getManager(55);
    this.jdField_b_of_type_JavaLangCharSequence = "";
    this.c = "";
    if ((paramQQAppInterface != null) && (paramQQAppInterface.d()))
    {
      this.c = paramContext.getResources().getString(2131369375);
      this.E = paramContext.getResources().getColor(2131427997);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775803L)) {
        this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      return;
      this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131369376);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.SecMsgRecentItemData
 * JD-Core Version:    0.7.0.1
 */