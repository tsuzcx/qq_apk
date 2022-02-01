package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.utils.NetworkUtil;

public class DetailHost
  extends DetailModel
{
  public long a;
  public DatingStranger a;
  public byte[] a;
  
  protected DetailHost(DatingDetailActivity paramDatingDetailActivity, DatingInfo paramDatingInfo, CustomTabBarView paramCustomTabBarView)
  {
    super(paramDatingDetailActivity, 1, paramDatingInfo, paramCustomTabBarView);
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    if (paramInt == 5) {
      if ((paramObject instanceof DatingInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = ((DatingInfo)paramObject);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(1, 2131369754, 1000);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a();
        c();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus = 1;
      break;
      if (paramInt != 6) {
        break label130;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
    } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger == null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_Long, 1);
    DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, 2);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = null;
    return;
    label130:
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
  }
  
  public void a(DatingStranger paramDatingStranger)
  {
    if (paramDatingStranger == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X800494A");
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getApplicationContext()))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369804);
      if (paramDatingStranger.b == 1) {}
      for (paramDatingStranger = "她";; paramDatingStranger = "他")
      {
        paramDatingStranger = String.format(str, new Object[] { paramDatingStranger });
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(paramDatingStranger);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = paramDatingStranger;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, paramDatingStranger.jdField_a_of_type_Long, 2);
      str = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369803);
      if (paramDatingStranger.b == 1) {}
      for (paramDatingStranger = "她";; paramDatingStranger = "他")
      {
        paramDatingStranger = String.format(str, new Object[] { paramDatingStranger });
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(0, paramDatingStranger, 1000);
        return;
      }
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369805);
    if (paramDatingStranger.b == 1) {}
    for (paramDatingStranger = "她";; paramDatingStranger = "他")
    {
      paramDatingStranger = String.format(str, new Object[] { paramDatingStranger });
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(paramDatingStranger);
      return;
    }
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      super.b(paramInt, paramObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DetailHost
 * JD-Core Version:    0.7.0.1
 */