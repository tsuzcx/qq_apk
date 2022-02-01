import android.content.Context;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ibo
  implements Runnable
{
  int jdField_a_of_type_Int;
  appoint_define.LocaleInfo jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  int d;
  int e;
  int f;
  
  private ibo(DatingFeedActivity paramDatingFeedActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    if (DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity) == null) {
      DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, new DatingFilters(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity));
    }
    DatingFilters localDatingFilters = DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity);
    this.jdField_a_of_type_Int = localDatingFilters.e;
    this.jdField_b_of_type_Int = localDatingFilters.g;
    this.c = localDatingFilters.d;
    this.e = DatingFilters.jdField_a_of_type_ArrayOfInt[localDatingFilters.h];
    this.d = DatingFilters.b[localDatingFilters.h];
    this.f = localDatingFilters.i;
    if (this.f < 0) {
      this.f = 0;
    }
    this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ArrayOfByte = DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity);
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public void run()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity.app.a(40);
    boolean bool = localDatingHandler.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, DatingFeedActivity.d(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity));
    if (!bool) {
      if (!DatingUtil.a()) {
        break label166;
      }
    }
    label166:
    for (String str = BaseApplication.getContext().getString(2131366592);; str = BaseApplication.getContext().getString(2131366584))
    {
      localDatingHandler.a(9, false, new Object[] { null, Boolean.valueOf(false), Boolean.valueOf(false), this.jdField_a_of_type_ArrayOfByte, str, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      DatingUtil.b("getDatingFeeds fail", new Object[] { Boolean.valueOf(bool) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibo
 * JD-Core Version:    0.7.0.1
 */