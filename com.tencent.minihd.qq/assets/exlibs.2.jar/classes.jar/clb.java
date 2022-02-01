import android.content.Context;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.AccountObserver;

public final class clb
  extends AccountObserver
{
  public clb(QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void onUpdateSid(String paramString)
  {
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     clb
 * JD-Core Version:    0.7.0.1
 */